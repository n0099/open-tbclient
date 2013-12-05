package com.baidu.tieba.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SettingTextTipView extends FrameLayout {
    protected Context b;
    protected LinearLayout c;
    protected TextView d;
    protected TextView e;
    protected ImageView f;

    public SettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        e();
        a(attributeSet);
        a(TiebaApplication.h().an());
    }

    public SettingTextTipView(Context context) {
        super(context);
        this.b = context;
        e();
        a(TiebaApplication.h().an());
    }

    public void b() {
        if (this.e != null) {
            this.e.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.e != null) {
            this.e.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.e != null) {
        }
    }

    public void c() {
    }

    public void d() {
        this.f.setVisibility(8);
    }

    public void setText(String str) {
        this.d.setText(str);
    }

    public void setText(int i) {
        this.d.setText(i);
    }

    public void setTip(String str) {
        this.e.setText(str);
    }

    public void setTipBackground(Drawable drawable) {
        this.e.setBackgroundDrawable(drawable);
    }

    public void a(int i) {
        if (i == 1) {
            this.d.setTextColor(this.b.getResources().getColor(R.color.skin_1_common_color));
            this.e.setTextColor(this.b.getResources().getColor(R.color.c_FF515865));
            this.f.setImageResource(R.drawable.icon_arrow_right_1);
            return;
        }
        this.d.setTextColor(this.b.getResources().getColor(R.color.more_color));
        this.f.setImageResource(R.drawable.icon_arrow_right);
        this.e.setTextColor(this.b.getResources().getColor(R.color.c_FFB2B6BA));
    }

    protected void e() {
        LayoutInflater.from(this.b).inflate(R.layout.setting_text_tip_view, (ViewGroup) this, true);
        this.c = (LinearLayout) findViewById(R.id.container);
        this.d = (TextView) findViewById(R.id.text);
        this.e = (TextView) findViewById(R.id.tip);
        this.f = (ImageView) findViewById(R.id.arrow2);
    }

    protected void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(attributeSet, com.baidu.tieba.au.SettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.d.setText(string);
        }
        if (color > -1) {
            this.d.setTextColor(color);
        }
        if (string2 != null) {
            this.e.setText(string2);
        }
        if (color2 > -1) {
            this.e.setTextColor(color2);
        }
        this.c.setClickable(false);
        this.c.setFocusable(false);
    }
}
