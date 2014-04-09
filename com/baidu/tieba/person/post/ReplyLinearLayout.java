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
        int i;
        if (b == null) {
            b = new LinearLayout.LayoutParams(-1, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
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
                String[] strArr = arrayList.get(i);
                if (i3 == 0 || i3 % 3 == 2) {
                    textView2.setText(strArr[0]);
                } else if (i3 % 3 == 0) {
                    textView2.setText(strArr[4]);
                }
                textView2.setTag(strArr);
                textView2.setOnClickListener(this.c);
                if (TbadkApplication.j().l() == 1) {
                    if (i3 == 0) {
                        textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_main_1));
                        textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                    } else if (i3 % 3 == 2) {
                        textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_sub_1));
                        textView2.setBackgroundResource(com.baidu.tieba.a.e.transparent);
                        textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f));
                    } else if (i3 % 3 == 0) {
                        textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_time_1));
                        textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                    }
                } else if (i3 == 0) {
                    textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_main));
                    textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                } else if (i3 % 3 == 2) {
                    textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_content_sub));
                    textView2.setBackgroundResource(com.baidu.tieba.a.e.transparent);
                    textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f));
                } else if (i3 % 3 == 0) {
                    textView2.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_time));
                    textView2.setPadding(0, com.baidu.adp.lib.util.i.a(getContext(), 2.0f), 0, com.baidu.adp.lib.util.i.a(getContext(), 10.0f));
                }
                if (i3 == 0) {
                    textView2.setTextSize(17.0f);
                    textView2.setMaxLines(3);
                    textView2.setLayoutParams(b);
                    ba.a(textView2, com.baidu.tieba.a.e.cp_cont_b, 1);
                } else if (i3 == 1 || i3 % 3 == 1) {
                    textView2.setLayoutParams(layoutParams);
                    ba.f((View) textView2, com.baidu.tieba.a.e.cp_bg_line_b);
                } else if (i3 % 3 == 2) {
                    textView2.setTextSize(15.0f);
                    textView2.setMaxLines(2);
                    textView2.setLayoutParams(b);
                    ba.a(textView2, com.baidu.tieba.a.e.cp_cont_f, 1);
                } else if (i3 % 3 == 0) {
                    textView2.setTextSize(10.0f);
                    textView2.setLayoutParams(b);
                    ba.a(textView2, com.baidu.tieba.a.e.cp_cont_d, 1);
                }
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }
}
