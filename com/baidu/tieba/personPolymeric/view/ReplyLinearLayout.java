package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ReplyLinearLayout extends LinearLayout {
    private static ViewGroup.LayoutParams gsI;
    private List<TextView> gsH;
    private boolean mIsHost;
    private View.OnClickListener mOnItemClickListener;

    public ReplyLinearLayout(Context context) {
        this(context, null);
    }

    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.ReplyLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z;
                String[] strArr = (String[]) view.getTag();
                TiebaStatic.log(new ak("c12043").s("obj_type", ReplyLinearLayout.this.mIsHost ? 1 : 2));
                if (strArr != null) {
                    Context context2 = ReplyLinearLayout.this.getContext();
                    if (strArr.length < 6 || strArr[5] == null || com.baidu.adp.lib.g.b.h(strArr[5], 0) != 33) {
                        z = false;
                    } else if ("0".equals(strArr[3])) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(context2, strArr[1]).xD()));
                        z = true;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveCommentActivityConfig(context2).createPhotoLiveCommentActivityConfig(strArr[1], strArr[2], false)));
                        z = true;
                    }
                    if (!z) {
                        if ("0".equals(strArr[3])) {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(context2).createNormalCfg(strArr[1], strArr[2], "person_page");
                            createNormalCfg.setStartFrom(4);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                            return;
                        }
                        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context2).createSubPbActivityConfig(strArr[1], strArr[2], "person_post_reply", false, null, false);
                        createSubPbActivityConfig.setKeyPageStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                    }
                }
            }
        };
        this.gsH = new ArrayList();
    }

    public void setContent(ArrayList<String[]> arrayList) {
        int i;
        if (gsI == null) {
            gsI = new LinearLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = ((arrayList.size() - 1) * 3) + 1;
        int size2 = size - this.gsH.size();
        for (int i2 = 0; i2 < size2; i2++) {
            TextView textView = new TextView(getContext());
            this.gsH.add(textView);
            addView(textView);
        }
        for (int i3 = 0; i3 < this.gsH.size(); i3++) {
            TextView textView2 = this.gsH.get(i3);
            if (i3 < size) {
                if (i3 == 0 || i3 == 1) {
                    i = 0;
                } else if (i3 % 3 == 0 || i3 % 3 == 1) {
                    i = i3 / 3;
                } else {
                    i = i3 % 3 == 2 ? (i3 / 3) + 1 : 0;
                }
                CharSequence[] charSequenceArr = (String[]) arrayList.get(i);
                if (i3 == 0 || i3 % 3 == 2) {
                    textView2.setText(charSequenceArr[0]);
                } else if (i3 % 3 == 0) {
                    textView2.setText(charSequenceArr[4]);
                }
                textView2.setTag(charSequenceArr);
                textView2.setOnClickListener(this.mOnItemClickListener);
                o(textView2, i3);
                if (i3 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    textView2.setLayoutParams(gsI);
                    aj.e(textView2, d.C0141d.cp_cont_b, 1);
                } else if (i3 == 1 || i3 % 3 == 1) {
                    textView2.setLayoutParams(layoutParams);
                    aj.s(textView2, d.C0141d.cp_bg_line_b);
                } else if (i3 % 3 == 2) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    textView2.setLayoutParams(gsI);
                    aj.e(textView2, d.C0141d.cp_cont_f, 1);
                } else if (i3 % 3 == 0) {
                    textView2.setTextSize(10.0f);
                    textView2.setLayoutParams(gsI);
                    aj.e(textView2, d.C0141d.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    private void o(TextView textView, int i) {
        if (i == 0) {
            aj.e(textView, d.C0141d.common_color_10039, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f));
        } else if (i % 3 == 2) {
            aj.e(textView, d.C0141d.common_color_10081, 1);
            textView.setBackgroundResource(d.C0141d.common_color_10022);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 2.0f));
        } else if (i % 3 == 0) {
            aj.e(textView, d.C0141d.common_color_10005, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 2.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f));
        }
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }
}
