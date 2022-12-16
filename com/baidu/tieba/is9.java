package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes4.dex */
public class is9 implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ ls9 c;
    public final /* synthetic */ fs9 d;

    public is9(fs9 fs9Var, ls9 ls9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs9Var, ls9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = fs9Var;
        this.c = ls9Var;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view2, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, tTNativeAd) == null) {
            LogPrinter.d();
            this.d.onAdClicked(this.c, this.b, new String[0]);
            this.b = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view2, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tTNativeAd) == null) {
            LogPrinter.d();
            this.d.onAdClicked(this.c, this.b, new String[0]);
            this.b = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            LogPrinter.d();
            this.d.onAdShow(this.c, this.a, new String[0]);
            this.a = true;
        }
    }
}
