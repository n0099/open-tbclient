package com.baidu.ufosdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public final class er extends Dialog {

    /* renamed from: a */
    private final int f5574a;

    /* renamed from: b */
    private final int f5575b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private Context h;
    private eu i;
    private EditText j;
    private String k;

    public er(Context context, String str) {
        super(context);
        this.f5574a = R.dimen.L_X02;
        this.f5575b = R.dimen.L_X03;
        this.c = R.dimen.L_X04;
        this.d = R.dimen.L_X05;
        this.e = R.dimen.L_X06;
        this.f = R.dimen.M_H_X001;
        this.g = R.dimen.M_H_X002;
        this.k = "";
        this.h = context;
        this.k = str;
    }

    public final void a(eu euVar) {
        this.i = euVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.baidu.ufosdk.b.A);
        gradientDrawable.setCornerRadius(com.baidu.ufosdk.f.i.a(this.h, 4.0f));
        RelativeLayout relativeLayout = new RelativeLayout(this.h);
        relativeLayout.setId(R.dimen.L_X02);
        relativeLayout.setBackgroundDrawable(gradientDrawable);
        TextView textView = new TextView(this.h);
        textView.setId(R.dimen.M_H_X002);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(18.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setText(com.baidu.ufosdk.f.s.a("38"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.h, 10.0f), com.baidu.ufosdk.f.i.a(this.h, 20.0f), com.baidu.ufosdk.f.i.a(this.h, 10.0f), 0);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this.h);
        textView2.setId(R.dimen.L_X03);
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView2.setTextSize(15.0f);
        textView2.setText(com.baidu.ufosdk.f.s.a("39"));
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.h, 20.0f), com.baidu.ufosdk.f.i.a(this.h, 20.0f), com.baidu.ufosdk.f.i.a(this.h, 20.0f), 0);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        relativeLayout.addView(textView2, layoutParams2);
        int a2 = com.baidu.ufosdk.f.i.a(this.h, 4.0f);
        int parseColor = Color.parseColor("#2E3135");
        int parseColor2 = Color.parseColor("#FFFFFF");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(parseColor2);
        gradientDrawable2.setCornerRadius(a2);
        gradientDrawable2.setStroke(1, parseColor);
        this.j = new EditText(this.h);
        this.j.setId(R.dimen.L_X04);
        this.j.setTextSize(15.0f);
        this.j.setTextColor(-13421773);
        if (this.k.length() > 0) {
            this.j.setText(this.k);
            this.j.setSelection(this.k.length());
        }
        this.j.setHint(com.baidu.ufosdk.f.s.a("41"));
        this.j.setBackgroundDrawable(gradientDrawable2);
        this.j.setPadding(com.baidu.ufosdk.f.i.a(this.h, 3.0f), com.baidu.ufosdk.f.i.a(this.h, 3.0f), com.baidu.ufosdk.f.i.a(this.h, 3.0f), com.baidu.ufosdk.f.i.a(this.h, 3.0f));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.h, 35.0f));
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.h, 25.0f), com.baidu.ufosdk.f.i.a(this.h, 10.0f), com.baidu.ufosdk.f.i.a(this.h, 25.0f), com.baidu.ufosdk.f.i.a(this.h, 5.0f));
        relativeLayout.addView(this.j, layoutParams3);
        LinearLayout linearLayout = new LinearLayout(this.h);
        linearLayout.setId(R.dimen.L_X05);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(0);
        linearLayout.setGravity(17);
        TextView textView3 = new TextView(this.h);
        textView3.setId(R.dimen.L_X06);
        textView3.setText(com.baidu.ufosdk.f.s.a("36"));
        textView3.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.t, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
        textView3.setBackgroundColor(0);
        textView3.setTextSize(17.0f);
        textView3.setGravity(17);
        textView3.setOnClickListener(new et(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(textView3, layoutParams4);
        View view = new View(this.h);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.h, 0.8f), -1);
        layoutParams5.setMargins(0, com.baidu.ufosdk.f.i.a(this.h, 10.0f), 0, 0);
        view.setBackgroundColor(-6710887);
        linearLayout.addView(view, layoutParams5);
        TextView textView4 = new TextView(this.h);
        textView4.setId(R.dimen.M_H_X001);
        textView4.setText(com.baidu.ufosdk.f.s.a(PayConfig.PAYMENT_POS_KEY_MANGA));
        textView4.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.t, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
        textView4.setBackgroundColor(0);
        textView4.setTextSize(17.0f);
        textView4.setGravity(17);
        textView4.setOnClickListener(new et(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.weight = 1.0f;
        linearLayout.addView(textView4, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.h, 50.0f));
        layoutParams7.addRule(3, this.j.getId());
        relativeLayout.addView(linearLayout, layoutParams7);
        setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -2));
        this.j.addTextChangedListener(new es(this));
    }
}
