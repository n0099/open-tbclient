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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class j extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a */
    public final int f57950a;

    /* renamed from: b */
    public final int f57951b;

    /* renamed from: c */
    public final int f57952c;

    /* renamed from: d */
    public final int f57953d;

    /* renamed from: e */
    public final int f57954e;

    /* renamed from: f */
    public final int f57955f;

    /* renamed from: g */
    public Context f57956g;

    /* renamed from: h */
    public l f57957h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57950a = R.dimen.L_X02;
        this.f57951b = R.dimen.L_X03;
        this.f57952c = R.dimen.L_X05;
        this.f57953d = R.dimen.L_X06;
        this.f57954e = R.dimen.M_H_X001;
        this.f57955f = R.dimen.M_H_X002;
        this.f57956g = context;
    }

    public final void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            this.f57957h = lVar;
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setCanceledOnTouchOutside(false);
            getWindow().setBackgroundDrawable(new BitmapDrawable());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(com.baidu.ufosdk.b.C);
            gradientDrawable.setCornerRadius(com.baidu.ufosdk.f.i.a(this.f57956g, 4.0f));
            RelativeLayout relativeLayout = new RelativeLayout(this.f57956g);
            relativeLayout.setId(R.dimen.L_X02);
            relativeLayout.setBackgroundDrawable(gradientDrawable);
            TextView textView = new TextView(this.f57956g);
            textView.setId(R.dimen.M_H_X002);
            textView.setTextColor(-16777216);
            textView.setTextSize(18.0f);
            textView.setText(com.baidu.ufosdk.f.s.a("57"));
            textView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, com.baidu.ufosdk.f.i.a(this.f57956g, 10.0f), 0, 0);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            relativeLayout.addView(textView, layoutParams);
            TextView textView2 = new TextView(this.f57956g);
            textView2.setId(R.dimen.L_X03);
            textView2.setTextColor(com.baidu.ufosdk.b.J);
            textView2.setTextSize(16.0f);
            textView2.setText(com.baidu.ufosdk.f.s.a("58"));
            textView2.setGravity(17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.f57956g, 20.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 15.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 20.0f), 0);
            layoutParams2.addRule(14);
            layoutParams2.addRule(3, textView.getId());
            relativeLayout.addView(textView2, layoutParams2);
            LinearLayout linearLayout = new LinearLayout(this.f57956g);
            linearLayout.setId(R.dimen.L_X05);
            linearLayout.setOrientation(0);
            linearLayout.setBackgroundColor(0);
            linearLayout.setGravity(17);
            TextView textView3 = new TextView(this.f57956g);
            textView3.setId(R.dimen.L_X06);
            textView3.setText(com.baidu.ufosdk.f.s.a(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR));
            textView3.setTextColor(-13421773);
            textView3.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f57956g, "ufo_confirm_cancel.9.png", "ufo_confirm_cancel_pressed.9.png"));
            textView3.setTextSize(18.0f);
            textView3.setGravity(17);
            textView3.setOnClickListener(new k(this, (byte) 0));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f57956g, 35.0f));
            layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.f57956g, 20.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 20.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 5.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 15.0f));
            layoutParams3.weight = 1.0f;
            linearLayout.addView(textView3, layoutParams3);
            TextView textView4 = new TextView(this.f57956g);
            textView4.setId(R.dimen.M_H_X001);
            textView4.setText(com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT));
            textView4.setTextColor(-1);
            textView4.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.f57956g, "ufo_confirm_ok.9.png", "ufo_confirm_ok_pressed.9.png"));
            textView4.setTextSize(18.0f);
            textView4.setGravity(17);
            textView4.setOnClickListener(new k(this, (byte) 0));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f57956g, 35.0f));
            layoutParams4.setMargins(com.baidu.ufosdk.f.i.a(this.f57956g, 5.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 20.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 20.0f), com.baidu.ufosdk.f.i.a(this.f57956g, 15.0f));
            layoutParams4.weight = 1.0f;
            linearLayout.addView(textView4, layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(3, textView2.getId());
            relativeLayout.addView(linearLayout, layoutParams5);
            setContentView(relativeLayout, new ViewGroup.LayoutParams(com.baidu.ufosdk.f.i.a(this.f57956g, 280.0f), -2));
        }
    }
}
