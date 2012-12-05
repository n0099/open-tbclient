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
    private static long MAX_TIME = 359999;
    private TextView mHourNum;
    private TextView mHourText;
    private TextView mMinNum;
    private TextView mMinText;
    private TextView mSecNum;
    private TextView mSecText;
    private TextView mTitle;

    public CustomTimerView(Context context) {
        super(context);
    }

    public CustomTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_timer_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mHourNum = (TextView) findViewById(R.id.hour_num);
        this.mHourText = (TextView) findViewById(R.id.hour_text);
        this.mMinNum = (TextView) findViewById(R.id.min_num);
        this.mMinText = (TextView) findViewById(R.id.min_text);
        this.mSecNum = (TextView) findViewById(R.id.sec_num);
        this.mSecText = (TextView) findViewById(R.id.sec_text);
    }

    public void setTitle(int textId) {
        this.mTitle.setText(textId);
    }

    public void setTitleSize(int size) {
        this.mTitle.setTextSize(2, size);
    }

    public void setTitleColor(int color) {
        this.mTitle.setTextColor(color);
    }

    public void setTextSize(int size) {
        this.mHourText.setTextSize(2, size);
        this.mMinText.setTextSize(2, size);
        this.mSecText.setTextSize(2, size);
    }

    public void setTextColor(int color) {
        this.mHourText.setTextColor(color);
        this.mMinText.setTextColor(color);
        this.mSecText.setTextColor(color);
    }

    public void setNumSize(int size) {
        this.mHourNum.setTextSize(2, size);
        this.mMinNum.setTextSize(2, size);
        this.mSecNum.setTextSize(2, size);
    }

    public void setNumColor(int color) {
        this.mHourNum.setTextColor(color);
        this.mMinNum.setTextColor(color);
        this.mSecNum.setTextColor(color);
    }

    public void setTextMargin(int n) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.mHourText.getLayoutParams();
        params.rightMargin = n;
        this.mHourText.setLayoutParams(params);
        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) this.mMinText.getLayoutParams();
        params2.rightMargin = n;
        this.mMinText.setLayoutParams(params2);
    }

    public void setNumMargin(int n) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.mHourNum.getLayoutParams();
        params.rightMargin = n;
        this.mHourNum.setLayoutParams(params);
        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) this.mMinNum.getLayoutParams();
        params2.rightMargin = n;
        this.mMinNum.setLayoutParams(params2);
        LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) this.mSecNum.getLayoutParams();
        params3.rightMargin = n;
        this.mSecNum.setLayoutParams(params3);
    }

    public void setTime(long time) {
        if (time < 0 || time > MAX_TIME) {
            time = MAX_TIME;
        }
        this.mHourNum.setText(String.format("%1$02d", Long.valueOf(time / 3600)));
        this.mMinNum.setText(String.format("%1$02d", Long.valueOf((time % 3600) / 60)));
        this.mSecNum.setText(String.format("%1$02d", Long.valueOf((time % 3600) % 60)));
    }
}
