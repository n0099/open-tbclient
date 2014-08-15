package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class CustomTimerView extends LinearLayout {
    private static long a = 359999;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;

    public CustomTimerView(Context context) {
        super(context);
    }

    public CustomTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(com.baidu.tieba.v.custom_timer_view, (ViewGroup) this, true);
        this.b = (TextView) findViewById(com.baidu.tieba.u.hour_num);
        this.c = (TextView) findViewById(com.baidu.tieba.u.hour_text);
        this.d = (TextView) findViewById(com.baidu.tieba.u.min_num);
        this.e = (TextView) findViewById(com.baidu.tieba.u.min_text);
        this.f = (TextView) findViewById(com.baidu.tieba.u.sec_num);
        this.g = (TextView) findViewById(com.baidu.tieba.u.sec_text);
    }

    public void setTextSize(int i) {
        this.c.setTextSize(2, i);
        this.e.setTextSize(2, i);
        this.g.setTextSize(2, i);
    }

    public void setTextColor(int i) {
        this.c.setTextColor(i);
        this.e.setTextColor(i);
        this.g.setTextColor(i);
    }

    public void setNumSize(int i) {
        this.b.setTextSize(2, i);
        this.d.setTextSize(2, i);
        this.f.setTextSize(2, i);
    }

    public void setNumColor(int i) {
        this.b.setTextColor(i);
        this.d.setTextColor(i);
        this.f.setTextColor(i);
    }

    public void setTextMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.rightMargin = i;
        this.c.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams2.rightMargin = i;
        this.e.setLayoutParams(layoutParams2);
    }

    public void setNumMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.rightMargin = i;
        this.b.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.rightMargin = i;
        this.d.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams3.rightMargin = i;
        this.f.setLayoutParams(layoutParams3);
    }

    public void setTime(long j) {
        if (j < 0 || j > a) {
            j = a;
        }
        this.b.setText(String.format("%1$02d", Long.valueOf(j / 3600)));
        this.d.setText(String.format("%1$02d", Long.valueOf((j % 3600) / 60)));
        this.f.setText(String.format("%1$02d", Long.valueOf((j % 3600) % 60)));
    }
}
