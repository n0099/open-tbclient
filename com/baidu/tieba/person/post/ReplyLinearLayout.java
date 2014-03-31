package com.baidu.tieba.person.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
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
        this.c = new y(this);
        this.a = new ArrayList();
    }

    public void setContent(ArrayList<String[]> arrayList) {
        if (b == null) {
            b = new LinearLayout.LayoutParams(-1, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int size = (arrayList.size() * 2) - 1;
        int size2 = size - this.a.size();
        for (int i = 0; i < size2; i++) {
            TextView textView = new TextView(getContext());
            this.a.add(textView);
            addView(textView);
            if (i != 0 && i % 2 == 0 && i < size2 - 1) {
                View view = new View(getContext());
                view.setLayoutParams(layoutParams);
                ba.f(view, com.baidu.tieba.a.e.cp_bg_line_b);
                addView(view);
            }
        }
        int i2 = 0;
        while (i2 < this.a.size()) {
            TextView textView2 = this.a.get(i2);
            if (i2 < size) {
                String[] strArr = arrayList.get(i2 == 0 ? i2 : (i2 / 2) + (i2 % 2));
                textView2.setText((i2 == 0 || i2 % 2 == 1) ? strArr[0] : strArr[4]);
                textView2.setTag(strArr);
                textView2.setOnClickListener(this.c);
                if (TbadkApplication.j().l() == 1) {
                    if (i2 == 0) {
                        textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_main_1));
                        textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                    } else if (i2 % 2 == 1) {
                        textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_sub_1));
                        textView2.setBackgroundResource(com.baidu.tieba.a.e.transparent);
                        textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f));
                    } else {
                        textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_time_1));
                        textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                    }
                } else if (i2 == 0) {
                    textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_main));
                    textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                } else if (i2 % 2 == 1) {
                    textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_sub));
                    textView2.setBackgroundResource(com.baidu.tieba.a.e.transparent);
                    textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f));
                } else {
                    textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_time));
                    textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                }
                textView2.setLayoutParams(b);
                if (i2 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    ba.a(textView2, com.baidu.tieba.a.e.cp_cont_b, 1);
                } else if (i2 % 2 == 1) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    ba.a(textView2, com.baidu.tieba.a.e.cp_cont_f, 1);
                } else {
                    textView2.setTextSize(10.0f);
                    ba.a(textView2, com.baidu.tieba.a.e.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            i2++;
        }
    }
}
