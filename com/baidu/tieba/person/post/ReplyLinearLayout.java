package com.baidu.tieba.person.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ReplyLinearLayout extends LinearLayout {
    private static ViewGroup.LayoutParams cRt;
    private View.OnClickListener aWx;
    private List<TextView> cRs;

    public ReplyLinearLayout(Context context) {
        this(context, null);
    }

    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWx = new ae(this);
        this.cRs = new ArrayList();
    }

    public void setContent(ArrayList<String[]> arrayList) {
        int i;
        if (cRt == null) {
            cRt = new LinearLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = ((arrayList.size() - 1) * 3) + 1;
        int size2 = size - this.cRs.size();
        for (int i2 = 0; i2 < size2; i2++) {
            TextView textView = new TextView(getContext());
            this.cRs.add(textView);
            addView(textView);
        }
        for (int i3 = 0; i3 < this.cRs.size(); i3++) {
            TextView textView2 = this.cRs.get(i3);
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
                textView2.setOnClickListener(this.aWx);
                r(textView2, i3);
                if (i3 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    textView2.setLayoutParams(cRt);
                    as.b(textView2, n.c.cp_cont_b, 1);
                } else if (i3 == 1 || i3 % 3 == 1) {
                    textView2.setLayoutParams(layoutParams);
                    as.i((View) textView2, n.c.cp_bg_line_b);
                } else if (i3 % 3 == 2) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    textView2.setLayoutParams(cRt);
                    as.b(textView2, n.c.cp_cont_f, 1);
                } else if (i3 % 3 == 0) {
                    textView2.setTextSize(10.0f);
                    textView2.setLayoutParams(cRt);
                    as.b(textView2, n.c.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    private void r(TextView textView, int i) {
        if (i == 0) {
            as.b(textView, n.c.person_post_content_main, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f));
        } else if (i % 3 == 2) {
            as.b(textView, n.c.person_post_content_sub, 1);
            textView.setBackgroundResource(n.c.transparent);
            textView.setPadding(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f), 0, com.baidu.adp.lib.util.k.dip2px(getContext(), 2.0f));
        } else if (i % 3 == 0) {
            as.b(textView, n.c.person_post_header_time, 1);
            textView.setPadding(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 2.0f), 0, com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f));
        }
    }
}
