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
import com.baidu.mobads.container.widget.ConfirmDialog;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public final class er extends Dialog {

    /* renamed from: a */
    public final int f22925a;

    /* renamed from: b */
    public final int f22926b;

    /* renamed from: c */
    public final int f22927c;

    /* renamed from: d */
    public final int f22928d;

    /* renamed from: e */
    public final int f22929e;

    /* renamed from: f */
    public final int f22930f;

    /* renamed from: g */
    public final int f22931g;

    /* renamed from: h */
    public Context f22932h;
    public eu i;
    public EditText j;
    public String k;

    public er(Context context, String str) {
        super(context);
        this.f22925a = R.dimen.L_X02;
        this.f22926b = R.dimen.L_X03;
        this.f22927c = R.dimen.L_X04;
        this.f22928d = R.dimen.L_X05;
        this.f22929e = R.dimen.L_X06;
        this.f22930f = R.dimen.M_H_X001;
        this.f22931g = R.dimen.M_H_X002;
        this.k = "";
        this.f22932h = context;
        this.k = str;
    }

    public final void a(eu euVar) {
        this.i = euVar;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.baidu.ufosdk.b.A);
        gradientDrawable.setCornerRadius(com.baidu.ufosdk.f.i.a(this.f22932h, 4.0f));
        RelativeLayout relativeLayout = new RelativeLayout(this.f22932h);
        relativeLayout.setId(R.dimen.L_X02);
        relativeLayout.setBackgroundDrawable(gradientDrawable);
        TextView textView = new TextView(this.f22932h);
        textView.setId(R.dimen.M_H_X002);
        textView.setTextColor(-16777216);
        textView.setTextSize(18.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setText(com.baidu.ufosdk.f.s.a("38"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22932h, 10.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 20.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 10.0f), 0);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this.f22932h);
        textView2.setId(R.dimen.L_X03);
        textView2.setTextColor(-16777216);
        textView2.setTextSize(15.0f);
        textView2.setText(com.baidu.ufosdk.f.s.a("39"));
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.f22932h, 20.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 20.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 20.0f), 0);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        relativeLayout.addView(textView2, layoutParams2);
        int a2 = com.baidu.ufosdk.f.i.a(this.f22932h, 4.0f);
        int parseColor = Color.parseColor("#2E3135");
        int parseColor2 = Color.parseColor("#FFFFFF");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(parseColor2);
        gradientDrawable2.setCornerRadius(a2);
        gradientDrawable2.setStroke(1, parseColor);
        EditText editText = new EditText(this.f22932h);
        this.j = editText;
        editText.setId(R.dimen.L_X04);
        this.j.setTextSize(15.0f);
        this.j.setTextColor(-13421773);
        if (this.k.length() > 0) {
            this.j.setText(this.k);
            this.j.setSelection(this.k.length());
        }
        this.j.setHint(com.baidu.ufosdk.f.s.a("41"));
        this.j.setBackgroundDrawable(gradientDrawable2);
        this.j.setPadding(com.baidu.ufosdk.f.i.a(this.f22932h, 3.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 3.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 3.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 3.0f));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f22932h, 35.0f));
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.f22932h, 25.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 10.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 25.0f), com.baidu.ufosdk.f.i.a(this.f22932h, 5.0f));
        relativeLayout.addView(this.j, layoutParams3);
        LinearLayout linearLayout = new LinearLayout(this.f22932h);
        linearLayout.setId(R.dimen.L_X05);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(0);
        linearLayout.setGravity(17);
        TextView textView3 = new TextView(this.f22932h);
        textView3.setId(R.dimen.L_X06);
        textView3.setText(com.baidu.ufosdk.f.s.a(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR));
        int i = com.baidu.ufosdk.b.v;
        int i2 = com.baidu.ufosdk.b.t;
        int i3 = com.baidu.ufosdk.b.v;
        textView3.setTextColor(com.baidu.ufosdk.f.i.a(i, i2, i3, i3));
        textView3.setBackgroundColor(0);
        textView3.setTextSize(17.0f);
        textView3.setGravity(17);
        textView3.setOnClickListener(new et(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(textView3, layoutParams4);
        View view = new View(this.f22932h);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f22932h, 0.8f), -1);
        layoutParams5.setMargins(0, com.baidu.ufosdk.f.i.a(this.f22932h, 10.0f), 0, 0);
        view.setBackgroundColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
        linearLayout.addView(view, layoutParams5);
        TextView textView4 = new TextView(this.f22932h);
        textView4.setId(R.dimen.M_H_X001);
        textView4.setText(com.baidu.ufosdk.f.s.a(PayConfig.PAYMENT_POS_KEY_MANGA));
        int i4 = com.baidu.ufosdk.b.v;
        int i5 = com.baidu.ufosdk.b.t;
        int i6 = com.baidu.ufosdk.b.v;
        textView4.setTextColor(com.baidu.ufosdk.f.i.a(i4, i5, i6, i6));
        textView4.setBackgroundColor(0);
        textView4.setTextSize(17.0f);
        textView4.setGravity(17);
        textView4.setOnClickListener(new et(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.weight = 1.0f;
        linearLayout.addView(textView4, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f22932h, 50.0f));
        layoutParams7.addRule(3, this.j.getId());
        relativeLayout.addView(linearLayout, layoutParams7);
        setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -2));
        this.j.addTextChangedListener(new es(this));
    }
}
