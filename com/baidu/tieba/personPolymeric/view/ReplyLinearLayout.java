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
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ReplyLinearLayout extends LinearLayout {
    private static ViewGroup.LayoutParams gEl;
    private List<TextView> gEk;
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
                String[] strArr = (String[]) view.getTag();
                TiebaStatic.log(new am("c12043").x("obj_type", ReplyLinearLayout.this.mIsHost ? 1 : 2));
                if (strArr != null) {
                    Context context2 = ReplyLinearLayout.this.getContext();
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
        };
        this.gEk = new ArrayList();
    }

    public void setContent(ArrayList<String[]> arrayList) {
        int i;
        if (gEl == null) {
            gEl = new LinearLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = ((arrayList.size() - 1) * 3) + 1;
        int size2 = size - this.gEk.size();
        for (int i2 = 0; i2 < size2; i2++) {
            TextView textView = new TextView(getContext());
            this.gEk.add(textView);
            addView(textView);
        }
        for (int i3 = 0; i3 < this.gEk.size(); i3++) {
            TextView textView2 = this.gEk.get(i3);
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
                n(textView2, i3);
                if (i3 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    textView2.setLayoutParams(gEl);
                    al.c(textView2, e.d.cp_cont_b, 1);
                } else if (i3 == 1 || i3 % 3 == 1) {
                    textView2.setLayoutParams(layoutParams);
                    al.i(textView2, e.d.cp_bg_line_b);
                } else if (i3 % 3 == 2) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    textView2.setLayoutParams(gEl);
                    al.c(textView2, e.d.cp_cont_f, 1);
                } else if (i3 % 3 == 0) {
                    textView2.setTextSize(10.0f);
                    textView2.setLayoutParams(gEl);
                    al.c(textView2, e.d.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    private void n(TextView textView, int i) {
        if (i == 0) {
            al.c(textView, e.d.common_color_10039, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f));
        } else if (i % 3 == 2) {
            al.c(textView, e.d.common_color_10081, 1);
            textView.setBackgroundResource(e.d.common_color_10022);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 2.0f));
        } else if (i % 3 == 0) {
            al.c(textView, e.d.common_color_10005, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 2.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f));
        }
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }
}
