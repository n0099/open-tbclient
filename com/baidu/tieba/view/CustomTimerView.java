package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CustomTimerView extends LinearLayout {
    private static long a = 359999;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;

    public CustomTimerView(Context context) {
        super(context);
    }

    public CustomTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.custom_timer_view, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.hour_num);
        this.d = (TextView) findViewById(R.id.hour_text);
        this.e = (TextView) findViewById(R.id.min_num);
        this.f = (TextView) findViewById(R.id.min_text);
        this.g = (TextView) findViewById(R.id.sec_num);
        this.h = (TextView) findViewById(R.id.sec_text);
    }

    public void setNumColor(int i) {
        this.c.setTextColor(i);
        this.e.setTextColor(i);
        this.g.setTextColor(i);
    }

    public void setNumMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.rightMargin = i;
        this.c.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams2.rightMargin = i;
        this.e.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams3.rightMargin = i;
        this.g.setLayoutParams(layoutParams3);
    }

    public void setNumSize(int i) {
        this.c.setTextSize(2, i);
        this.e.setTextSize(2, i);
        this.g.setTextSize(2, i);
    }

    public void setTextColor(int i) {
        this.d.setTextColor(i);
        this.f.setTextColor(i);
        this.h.setTextColor(i);
    }

    public void setTextMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.rightMargin = i;
        this.d.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.rightMargin = i;
        this.f.setLayoutParams(layoutParams2);
    }

    public void setTextSize(int i) {
        this.d.setTextSize(2, i);
        this.f.setTextSize(2, i);
        this.h.setTextSize(2, i);
    }

    public void setTime(long j) {
        if (j < 0 || j > a) {
            j = a;
        }
        this.c.setText(String.format("%1$02d", Long.valueOf(j / 3600)));
        this.e.setText(String.format("%1$02d", Long.valueOf((j % 3600) / 60)));
        this.g.setText(String.format("%1$02d", Long.valueOf((j % 3600) % 60)));
    }

    public void setTitle(int i) {
        this.b.setText(i);
    }

    public void setTitleColor(int i) {
        this.b.setTextColor(i);
    }

    public void setTitleSize(int i) {
        this.b.setTextSize(2, i);
    }
}
