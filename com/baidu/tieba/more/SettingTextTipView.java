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

    /* renamed from: a  reason: collision with root package name */
    protected Context f1471a;
    protected LinearLayout b;
    protected TextView c;
    protected TextView d;
    protected ImageView e;

    public SettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1471a = context;
        c();
        a(attributeSet);
        a(TiebaApplication.g().ap());
    }

    public SettingTextTipView(Context context) {
        super(context);
        this.f1471a = context;
        c();
        a(TiebaApplication.g().ap());
    }

    public void setTipColor(int i) {
        if (this.d != null) {
            this.d.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void a() {
    }

    public void b() {
        this.e.setVisibility(8);
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void setText(int i) {
        this.c.setText(i);
    }

    public void setTip(String str) {
        this.d.setText(str);
    }

    public void setTipBackground(Drawable drawable) {
        this.d.setBackgroundDrawable(drawable);
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setTextColor(this.f1471a.getResources().getColor(R.color.skin_1_common_color));
            this.d.setTextColor(this.f1471a.getResources().getColor(R.color.c_FF515865));
            this.e.setImageResource(R.drawable.icon_arrow_right_1);
            return;
        }
        this.c.setTextColor(this.f1471a.getResources().getColor(R.color.more_color));
        this.e.setImageResource(R.drawable.icon_arrow_right);
        this.d.setTextColor(this.f1471a.getResources().getColor(R.color.c_FFB2B6BA));
    }

    protected void c() {
        LayoutInflater.from(this.f1471a).inflate(R.layout.setting_text_tip_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(R.id.container);
        this.c = (TextView) findViewById(R.id.text);
        this.d = (TextView) findViewById(R.id.tip);
        this.e = (ImageView) findViewById(R.id.arrow2);
    }

    protected void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f1471a.obtainStyledAttributes(attributeSet, com.baidu.tieba.ag.SettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        int color2 = obtainStyledAttributes.getColor(3, -1);
        if (string != null) {
            this.c.setText(string);
        }
        if (color > -1) {
            this.c.setTextColor(color);
        }
        if (string2 != null) {
            this.d.setText(string2);
        }
        if (color2 > -1) {
            this.d.setTextColor(color2);
        }
        this.b.setClickable(false);
        this.b.setFocusable(false);
    }
}
