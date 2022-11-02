package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
/* loaded from: classes6.dex */
public class zn9 extends yn9.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ io9 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zn9(yn9 yn9Var, cp9 cp9Var, String str, io9 io9Var) {
        super(yn9Var, cp9Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yn9Var, cp9Var, str, io9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((yn9) objArr2[0], (cp9) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = io9Var;
    }

    @Override // com.baidu.tieba.yn9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            super.onAdClicked(view2, i);
            io9 io9Var = this.f;
            String str = this.b;
            FunSplashAdInteractionListener funSplashAdInteractionListener = io9Var.j;
            if (funSplashAdInteractionListener != null) {
                funSplashAdInteractionListener.onAdClicked(str);
            }
        }
    }

    @Override // com.baidu.tieba.yn9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            super.onAdShow(view2, i);
            io9 io9Var = this.f;
            io9Var.g = io9Var.b.getWidth();
            io9Var.h = io9Var.b.getHeight();
        }
    }
}
