package com.baidu.ufosdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes8.dex */
public final class j extends Dialog {

    /* renamed from: a */
    private final int f5602a;

    /* renamed from: b */
    private final int f5603b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private Context g;
    private l h;

    public j(Context context) {
        super(context);
        this.f5602a = R.dimen.L_X02;
        this.f5603b = R.dimen.L_X03;
        this.c = R.dimen.L_X05;
        this.d = R.dimen.L_X06;
        this.e = R.dimen.M_H_X001;
        this.f = R.dimen.M_H_X002;
        this.g = context;
    }

    public final void a(l lVar) {
        this.h = lVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.baidu.ufosdk.b.C);
        gradientDrawable.setCornerRadius(com.baidu.ufosdk.f.i.a(this.g, 4.0f));
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        relativeLayout.setId(R.dimen.L_X02);
        relativeLayout.setBackgroundDrawable(gradientDrawable);
        TextView textView = new TextView(this.g);
        textView.setId(R.dimen.M_H_X002);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(18.0f);
        textView.setText(com.baidu.ufosdk.f.s.a("57"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.baidu.ufosdk.f.i.a(this.g, 10.0f), 0, 0);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        relativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this.g);
        textView2.setId(R.dimen.L_X03);
        textView2.setTextColor(com.baidu.ufosdk.b.J);
        textView2.setTextSize(16.0f);
        textView2.setText(com.baidu.ufosdk.f.s.a("58"));
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.g, 20.0f), com.baidu.ufosdk.f.i.a(this.g, 15.0f), com.baidu.ufosdk.f.i.a(this.g, 20.0f), 0);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        relativeLayout.addView(textView2, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.g);
        linearLayout.setId(R.dimen.L_X05);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(0);
        linearLayout.setGravity(17);
        TextView textView3 = new TextView(this.g);
        textView3.setId(R.dimen.L_X06);
        textView3.setText(com.baidu.ufosdk.f.s.a("36"));
        textView3.setTextColor(-13421773);
        textView3.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.g, "ufo_confirm_cancel.9.png", "ufo_confirm_cancel_pressed.9.png"));
        textView3.setTextSize(18.0f);
        textView3.setGravity(17);
        textView3.setOnClickListener(new k(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.g, 35.0f));
        layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.g, 20.0f), com.baidu.ufosdk.f.i.a(this.g, 20.0f), com.baidu.ufosdk.f.i.a(this.g, 5.0f), com.baidu.ufosdk.f.i.a(this.g, 15.0f));
        layoutParams3.weight = 1.0f;
        linearLayout.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(this.g);
        textView4.setId(R.dimen.M_H_X001);
        textView4.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_ACT_TYPE_TWENTY_EIGHT));
        textView4.setTextColor(-1);
        textView4.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.g, "ufo_confirm_ok.9.png", "ufo_confirm_ok_pressed.9.png"));
        textView4.setTextSize(18.0f);
        textView4.setGravity(17);
        textView4.setOnClickListener(new k(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.g, 35.0f));
        layoutParams4.setMargins(com.baidu.ufosdk.f.i.a(this.g, 5.0f), com.baidu.ufosdk.f.i.a(this.g, 20.0f), com.baidu.ufosdk.f.i.a(this.g, 20.0f), com.baidu.ufosdk.f.i.a(this.g, 15.0f));
        layoutParams4.weight = 1.0f;
        linearLayout.addView(textView4, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, textView2.getId());
        relativeLayout.addView(linearLayout, layoutParams5);
        setContentView(relativeLayout, new ViewGroup.LayoutParams(com.baidu.ufosdk.f.i.a(this.g, 280.0f), -2));
    }
}
