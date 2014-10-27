package com.baidu.tieba.person.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ReplyLinearLayout extends LinearLayout {
    private static ViewGroup.LayoutParams bEh;
    private List<TextView> bEg;
    private View.OnClickListener bEi;

    public ReplyLinearLayout(Context context) {
        this(context, null);
    }

    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bEi = new ab(this);
        this.bEg = new ArrayList();
    }

    public void setContent(ArrayList<String[]> arrayList) {
        int i;
        if (bEh == null) {
            bEh = new LinearLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = ((arrayList.size() - 1) * 3) + 1;
        int size2 = size - this.bEg.size();
        for (int i2 = 0; i2 < size2; i2++) {
            TextView textView = new TextView(getContext());
            this.bEg.add(textView);
            addView(textView);
        }
        for (int i3 = 0; i3 < this.bEg.size(); i3++) {
            TextView textView2 = this.bEg.get(i3);
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
                textView2.setOnClickListener(this.bEi);
                r(textView2, i3);
                if (i3 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    textView2.setLayoutParams(bEh);
                    aw.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
                } else if (i3 == 1 || i3 % 3 == 1) {
                    textView2.setLayoutParams(layoutParams);
                    aw.h((View) textView2, com.baidu.tieba.s.cp_bg_line_b);
                } else if (i3 % 3 == 2) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    textView2.setLayoutParams(bEh);
                    aw.b(textView2, com.baidu.tieba.s.cp_cont_f, 1);
                } else if (i3 % 3 == 0) {
                    textView2.setTextSize(10.0f);
                    textView2.setLayoutParams(bEh);
                    aw.b(textView2, com.baidu.tieba.s.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    private void r(TextView textView, int i) {
        if (i == 0) {
            aw.b(textView, com.baidu.tieba.s.person_post_content_main, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.m.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.m.dip2px(getContext(), 10.0f));
        } else if (i % 3 == 2) {
            aw.b(textView, com.baidu.tieba.s.person_post_content_sub, 1);
            textView.setBackgroundResource(com.baidu.tieba.s.transparent);
            textView.setPadding(0, com.baidu.adp.lib.util.m.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.m.dip2px(getContext(), 2.0f));
        } else if (i % 3 == 0) {
            aw.b(textView, com.baidu.tieba.s.person_post_header_time, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.m.dip2px(getContext(), 2.0f), 0, com.baidu.adp.lib.util.m.dip2px(getContext(), 10.0f));
        }
    }
}
