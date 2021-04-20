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
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes5.dex */
public final class j extends Dialog {

    /* renamed from: a */
    public final int f22964a;

    /* renamed from: b */
    public final int f22965b;

    /* renamed from: c */
    public final int f22966c;

    /* renamed from: d */
    public final int f22967d;

    /* renamed from: e */
    public final int f22968e;

    /* renamed from: f */
    public final int f22969f;

    /* renamed from: g */
    public Context f22970g;

    /* renamed from: h */
    public l f22971h;

    public j(Context context) {
        super(context);
        this.f22964a = R.dimen.L_X02;
        this.f22965b = R.dimen.L_X03;
        this.f22966c = R.dimen.L_X05;
        this.f22967d = R.dimen.L_X06;
        this.f22968e = R.dimen.M_H_X001;
        this.f22969f = R.dimen.M_H_X002;
        this.f22970g = context;
    }

    public final void a(l lVar) {
        this.f22971h = lVar;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.baidu.ufosdk.b.C);
        gradientDrawable.setCornerRadius(com.baidu.ufosdk.f.i.a(this.f22970g, 4.0f));
        RelativeLayout relativeLayout = new RelativeLayout(this.f22970g);
        relativeLayout.setId(R.dimen.L_X02);
        relativeLayout.setBackgroundDrawable(gradientDrawable);
        TextView textView = new TextView(this.f22970g);
        textView.setId(R.dimen.M_H_X002);
        textView.setTextColor(-16777216);
        textView.setTextSize(18.0f);
        textView.setText(com.baidu.ufosdk.f.s.a("57"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.baidu.ufosdk.f.i.a(this.f22970g, 10.0f), 0, 0);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        relativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this.f22970g);
        textView2.setId(R.dimen.L_X03);
        textView2.setTextColor(com.baidu.ufosdk.b.J);
        textView2.setTextSize(16.0f);
        textView2.setText(com.baidu.ufosdk.f.s.a("58"));
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.f22970g, 20.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 15.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 20.0f), 0);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        relativeLayout.addView(textView2, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.f22970g);
        linearLayout.setId(R.dimen.L_X05);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(0);
        linearLayout.setGravity(17);
        TextView textView3 = new TextView(this.f22970g);
        textView3.setId(R.dimen.L_X06);
        textView3.setText(com.baidu.ufosdk.f.s.a(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR));
        textView3.setTextColor(-13421773);
        textView3.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f22970g, "ufo_confirm_cancel.9.png", "ufo_confirm_cancel_pressed.9.png"));
        textView3.setTextSize(18.0f);
        textView3.setGravity(17);
        textView3.setOnClickListener(new k(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f22970g, 35.0f));
        layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.f22970g, 20.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 20.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 5.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 15.0f));
        layoutParams3.weight = 1.0f;
        linearLayout.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(this.f22970g);
        textView4.setId(R.dimen.M_H_X001);
        textView4.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_ACT_TYPE_TWENTY_EIGHT));
        textView4.setTextColor(-1);
        textView4.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f22970g, "ufo_confirm_ok.9.png", "ufo_confirm_ok_pressed.9.png"));
        textView4.setTextSize(18.0f);
        textView4.setGravity(17);
        textView4.setOnClickListener(new k(this, (byte) 0));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f22970g, 35.0f));
        layoutParams4.setMargins(com.baidu.ufosdk.f.i.a(this.f22970g, 5.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 20.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 20.0f), com.baidu.ufosdk.f.i.a(this.f22970g, 15.0f));
        layoutParams4.weight = 1.0f;
        linearLayout.addView(textView4, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, textView2.getId());
        relativeLayout.addView(linearLayout, layoutParams5);
        setContentView(relativeLayout, new ViewGroup.LayoutParams(com.baidu.ufosdk.f.i.a(this.f22970g, 280.0f), -2));
    }
}
