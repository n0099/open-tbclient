package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class e extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f22963a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f22964b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22965c;

    /* renamed from: d  reason: collision with root package name */
    public Context f22966d;

    public e(Context context) {
        super(context);
        this.f22963a = false;
        this.f22966d = context;
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f22964b = new ImageView(context);
        this.f22965c = new TextView(context);
        this.f22964b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(context, "ufo_checkbox_default.png")));
        addView(this.f22964b, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(context, 14.0f), com.baidu.ufosdk.f.i.a(context, 14.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(context, 10.0f), 0, 0, 0);
        addView(this.f22965c, layoutParams);
    }

    public final void a() {
        this.f22965c.setTextColor(-13421773);
    }

    public final void a(float f2) {
        this.f22965c.setTextSize(f2);
    }

    public final void a(String str) {
        this.f22965c.setText(str);
    }

    public final void a(boolean z) {
        this.f22964b.setBackgroundDrawable(z ? new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f22966d, "ufo_checkbox_checked.png")) : new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f22966d, "ufo_checkbox_default.png")));
    }

    public final String b() {
        return this.f22965c.getText().toString();
    }
}
