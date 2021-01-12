package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.mobstat.Config;
/* loaded from: classes10.dex */
public class TurnTableLuckyBubbleView extends LinearLayout {
    private TextView aBG;
    private String hKr;
    private String mName;

    public TurnTableLuckyBubbleView(Context context) {
        super(context);
        init();
    }

    public void setContent(String str) {
        this.aBG.setText(str);
    }

    public void setContent(String str, String str2) {
        if (TextUtils.isEmpty(this.mName) || TextUtils.isEmpty(this.hKr) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.mName.equals(str) || !this.hKr.equals(str2)) {
            this.mName = str;
            this.hKr = str2;
            this.aBG.setText(!TextUtils.isEmpty(this.hKr) ? this.mName + Config.EVENT_HEAT_X + this.hKr : this.mName);
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.turn_table_widget_lucky_bubble, (ViewGroup) this, true);
        this.aBG = (TextView) findViewById(a.f.tv_content);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(new int[]{-22755, -2199, -22755});
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        } else {
            gradientDrawable.setColor(-2199);
        }
        this.aBG.setBackgroundDrawable(gradientDrawable);
    }
}
