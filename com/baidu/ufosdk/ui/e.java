package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes21.dex */
public final class e extends LinearLayout {
    public boolean a;
    private ImageView b;
    private TextView c;
    private Context d;

    public e(Context context) {
        super(context);
        this.a = false;
        this.d = context;
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.b = new ImageView(context);
        this.c = new TextView(context);
        this.b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(context, "ufo_checkbox_default.png")));
        addView(this.b, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(context, 14.0f), com.baidu.ufosdk.f.i.a(context, 14.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(context, 10.0f), 0, 0, 0);
        addView(this.c, layoutParams);
    }

    public final void a() {
        this.c.setTextColor(-13421773);
    }

    public final void a(float f) {
        this.c.setTextSize(f);
    }

    public final void a(String str) {
        this.c.setText(str);
    }

    public final void a(boolean z) {
        if (z) {
            this.b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.d, "ufo_checkbox_checked.png")));
            return;
        }
        this.b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.d, "ufo_checkbox_default.png")));
    }

    public final String b() {
        return this.c.getText().toString();
    }
}
