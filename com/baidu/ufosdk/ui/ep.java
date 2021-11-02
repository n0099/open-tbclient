package com.baidu.ufosdk.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class ep extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f56977a;

    /* renamed from: b  reason: collision with root package name */
    public String f56978b;

    /* renamed from: c  reason: collision with root package name */
    public eq f56979c;

    public ep(String str, eq eqVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eqVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56977a = -11821318;
        this.f56978b = str;
        this.f56979c = eqVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            com.baidu.ufosdk.f.c.a("text clicked!!!" + this.f56978b);
            eq eqVar = this.f56979c;
            if (eqVar != null) {
                eqVar.a(this.f56978b);
            }
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f56977a);
        }
    }
}
