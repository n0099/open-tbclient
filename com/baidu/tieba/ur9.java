package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
/* loaded from: classes6.dex */
public class ur9 extends tr9.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ds9 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur9(tr9 tr9Var, xs9 xs9Var, String str, ds9 ds9Var) {
        super(tr9Var, xs9Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tr9Var, xs9Var, str, ds9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((tr9) objArr2[0], (xs9) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = ds9Var;
    }

    @Override // com.baidu.tieba.tr9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            super.onAdClicked(view2, i);
            ds9 ds9Var = this.f;
            String str = this.b;
            FunSplashAdInteractionListener funSplashAdInteractionListener = ds9Var.j;
            if (funSplashAdInteractionListener != null) {
                funSplashAdInteractionListener.onAdClicked(str);
            }
        }
    }

    @Override // com.baidu.tieba.tr9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            super.onAdShow(view2, i);
            ds9 ds9Var = this.f;
            ds9Var.g = ds9Var.b.getWidth();
            ds9Var.h = ds9Var.b.getHeight();
        }
    }
}
