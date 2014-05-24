package com.baidu.tieba.person.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ReplyLinearLayout extends LinearLayout {
    private static ViewGroup.LayoutParams b;
    private List<TextView> a;
    private View.OnClickListener c;

    public ReplyLinearLayout(Context context) {
        this(context, null);
    }

    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new z(this);
        this.a = new ArrayList();
    }

    public void setContent(ArrayList<String[]> arrayList) {
        int i;
        if (b == null) {
            b = new LinearLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = ((arrayList.size() - 1) * 3) + 1;
        int size2 = size - this.a.size();
        for (int i2 = 0; i2 < size2; i2++) {
            TextView textView = new TextView(getContext());
            this.a.add(textView);
            addView(textView);
        }
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            TextView textView2 = this.a.get(i3);
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
                textView2.setOnClickListener(this.c);
                a(textView2, i3);
                if (i3 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    textView2.setLayoutParams(b);
                    bc.a(textView2, com.baidu.tieba.s.cp_cont_b, 1);
                } else if (i3 == 1 || i3 % 3 == 1) {
                    textView2.setLayoutParams(layoutParams);
                    bc.f((View) textView2, com.baidu.tieba.s.cp_bg_line_b);
                } else if (i3 % 3 == 2) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    textView2.setLayoutParams(b);
                    bc.a(textView2, com.baidu.tieba.s.cp_cont_f, 1);
                } else if (i3 % 3 == 0) {
                    textView2.setTextSize(10.0f);
                    textView2.setLayoutParams(b);
                    bc.a(textView2, com.baidu.tieba.s.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    private void a(TextView textView, int i) {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (i == 0) {
                textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_content_main_1));
                textView.setPadding(0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f));
            } else if (i % 3 == 2) {
                textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_content_sub_1));
                textView.setBackgroundResource(com.baidu.tieba.s.transparent);
                textView.setPadding(0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.k.a(getContext(), 2.0f));
            } else if (i % 3 == 0) {
                textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_header_time_1));
                textView.setPadding(0, com.baidu.adp.lib.util.k.a(getContext(), 2.0f), 0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f));
            }
        } else if (i == 0) {
            textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_content_main));
            textView.setPadding(0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f));
        } else if (i % 3 == 2) {
            textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_content_sub));
            textView.setBackgroundResource(com.baidu.tieba.s.transparent);
            textView.setPadding(0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.k.a(getContext(), 2.0f));
        } else if (i % 3 == 0) {
            textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_header_time));
            textView.setPadding(0, com.baidu.adp.lib.util.k.a(getContext(), 2.0f), 0, com.baidu.adp.lib.util.k.a(getContext(), 10.0f));
        }
    }
}
