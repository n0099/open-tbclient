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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.widget.ConfirmDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class er extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a */
    public final int f59716a;

    /* renamed from: b */
    public final int f59717b;

    /* renamed from: c */
    public final int f59718c;

    /* renamed from: d */
    public final int f59719d;

    /* renamed from: e */
    public final int f59720e;

    /* renamed from: f */
    public final int f59721f;

    /* renamed from: g */
    public final int f59722g;

    /* renamed from: h */
    public Context f59723h;

    /* renamed from: i */
    public eu f59724i;

    /* renamed from: j */
    public EditText f59725j;
    public String k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
        this.f59716a = R.dimen.L_X02;
        this.f59717b = R.dimen.L_X03;
        this.f59718c = R.dimen.L_X04;
        this.f59719d = R.dimen.L_X05;
        this.f59720e = R.dimen.L_X06;
        this.f59721f = R.dimen.M_H_X001;
        this.f59722g = R.dimen.M_H_X002;
        this.k = "";
        this.f59723h = context;
        this.k = str;
    }

    public final void a(eu euVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, euVar) == null) {
            this.f59724i = euVar;
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
            gradientDrawable.setColor(com.baidu.ufosdk.b.A);
            gradientDrawable.setCornerRadius(com.baidu.ufosdk.f.i.a(this.f59723h, 4.0f));
            RelativeLayout relativeLayout = new RelativeLayout(this.f59723h);
            relativeLayout.setId(R.dimen.L_X02);
            relativeLayout.setBackgroundDrawable(gradientDrawable);
            TextView textView = new TextView(this.f59723h);
            textView.setId(R.dimen.M_H_X002);
            textView.setTextColor(-16777216);
            textView.setTextSize(18.0f);
            textView.getPaint().setFakeBoldText(true);
            textView.setText(com.baidu.ufosdk.f.s.a("38"));
            textView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f59723h, 10.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 20.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 10.0f), 0);
            layoutParams.addRule(14);
            relativeLayout.addView(textView, layoutParams);
            TextView textView2 = new TextView(this.f59723h);
            textView2.setId(R.dimen.L_X03);
            textView2.setTextColor(-16777216);
            textView2.setTextSize(15.0f);
            textView2.setText(com.baidu.ufosdk.f.s.a("39"));
            textView2.setGravity(17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.f59723h, 20.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 20.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 20.0f), 0);
            layoutParams2.addRule(14);
            layoutParams2.addRule(3, textView.getId());
            relativeLayout.addView(textView2, layoutParams2);
            int a2 = com.baidu.ufosdk.f.i.a(this.f59723h, 4.0f);
            int parseColor = Color.parseColor("#2E3135");
            int parseColor2 = Color.parseColor("#FFFFFF");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(parseColor2);
            gradientDrawable2.setCornerRadius(a2);
            gradientDrawable2.setStroke(1, parseColor);
            EditText editText = new EditText(this.f59723h);
            this.f59725j = editText;
            editText.setId(R.dimen.L_X04);
            this.f59725j.setTextSize(15.0f);
            this.f59725j.setTextColor(-13421773);
            if (this.k.length() > 0) {
                this.f59725j.setText(this.k);
                this.f59725j.setSelection(this.k.length());
            }
            this.f59725j.setHint(com.baidu.ufosdk.f.s.a("41"));
            this.f59725j.setBackgroundDrawable(gradientDrawable2);
            this.f59725j.setPadding(com.baidu.ufosdk.f.i.a(this.f59723h, 3.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 3.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 3.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 3.0f));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f59723h, 35.0f));
            layoutParams3.addRule(3, textView2.getId());
            layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.f59723h, 25.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 10.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 25.0f), com.baidu.ufosdk.f.i.a(this.f59723h, 5.0f));
            relativeLayout.addView(this.f59725j, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(this.f59723h);
            linearLayout.setId(R.dimen.L_X05);
            linearLayout.setOrientation(0);
            linearLayout.setBackgroundColor(0);
            linearLayout.setGravity(17);
            TextView textView3 = new TextView(this.f59723h);
            textView3.setId(R.dimen.L_X06);
            textView3.setText(com.baidu.ufosdk.f.s.a("36"));
            int i2 = com.baidu.ufosdk.b.v;
            int i3 = com.baidu.ufosdk.b.t;
            int i4 = com.baidu.ufosdk.b.v;
            textView3.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
            textView3.setBackgroundColor(0);
            textView3.setTextSize(17.0f);
            textView3.setGravity(17);
            textView3.setOnClickListener(new et(this, (byte) 0));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.weight = 1.0f;
            linearLayout.addView(textView3, layoutParams4);
            View view = new View(this.f59723h);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f59723h, 0.8f), -1);
            layoutParams5.setMargins(0, com.baidu.ufosdk.f.i.a(this.f59723h, 10.0f), 0, 0);
            view.setBackgroundColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
            linearLayout.addView(view, layoutParams5);
            TextView textView4 = new TextView(this.f59723h);
            textView4.setId(R.dimen.M_H_X001);
            textView4.setText(com.baidu.ufosdk.f.s.a("37"));
            int i5 = com.baidu.ufosdk.b.v;
            int i6 = com.baidu.ufosdk.b.t;
            int i7 = com.baidu.ufosdk.b.v;
            textView4.setTextColor(com.baidu.ufosdk.f.i.a(i5, i6, i7, i7));
            textView4.setBackgroundColor(0);
            textView4.setTextSize(17.0f);
            textView4.setGravity(17);
            textView4.setOnClickListener(new et(this, (byte) 0));
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams6.weight = 1.0f;
            linearLayout.addView(textView4, layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f59723h, 50.0f));
            layoutParams7.addRule(3, this.f59725j.getId());
            relativeLayout.addView(linearLayout, layoutParams7);
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -2));
            this.f59725j.addTextChangedListener(new es(this));
        }
    }
}
