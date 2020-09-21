package com.baidu.tieba.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class ReplyLinearLayout extends LinearLayout {
    private static ViewGroup.LayoutParams hfD;
    private List<TextView> lAl;
    private View.OnClickListener mOnItemClickListener;

    public ReplyLinearLayout(Context context) {
        this(context, null);
    }

    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.post.ReplyLinearLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String[] strArr = (String[]) view.getTag();
                if (strArr != null) {
                    Context context2 = ReplyLinearLayout.this.getContext();
                    if ("0".equals(strArr[3])) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(context2).createNormalCfg(strArr[1], strArr[2], "person_page");
                        createNormalCfg.setStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        return;
                    }
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context2).createSubPbActivityConfig(strArr[1], strArr[2], "person_post_reply", false, null, false);
                    createSubPbActivityConfig.setKeyPageStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                }
            }
        };
        this.lAl = new ArrayList();
    }

    public void setContent(ArrayList<String[]> arrayList) {
        int i;
        if (hfD == null) {
            hfD = new LinearLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = ((arrayList.size() - 1) * 3) + 1;
        int size2 = size - this.lAl.size();
        for (int i2 = 0; i2 < size2; i2++) {
            TextView textView = new TextView(getContext());
            this.lAl.add(textView);
            addView(textView);
        }
        for (int i3 = 0; i3 < this.lAl.size(); i3++) {
            TextView textView2 = this.lAl.get(i3);
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
                i(textView2, i3);
                if (i3 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    textView2.setLayoutParams(hfD);
                    ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
                } else if (i3 == 1 || i3 % 3 == 1) {
                    textView2.setLayoutParams(layoutParams);
                    ap.setBackgroundResource(textView2, R.color.cp_bg_line_c);
                } else if (i3 % 3 == 2) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    textView2.setLayoutParams(hfD);
                    ap.setViewTextColor(textView2, R.color.cp_cont_f, 1);
                } else if (i3 % 3 == 0) {
                    textView2.setTextSize(10.0f);
                    textView2.setLayoutParams(hfD);
                    ap.setViewTextColor(textView2, R.color.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    private void i(TextView textView, int i) {
        if (i == 0) {
            ap.setViewTextColor(textView, R.color.common_color_10039, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f));
        } else if (i % 3 == 2) {
            ap.setViewTextColor(textView, R.color.common_color_10081, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 2.0f));
        } else if (i % 3 == 0) {
            ap.setViewTextColor(textView, R.color.common_color_10005, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 2.0f), 0, com.baidu.adp.lib.util.l.dip2px(getContext(), 10.0f));
        }
    }
}
