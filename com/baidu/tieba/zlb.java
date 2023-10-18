package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes9.dex */
public final class zlb implements ExpressResponse.ExpressInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ okb a;

    public zlb(okb okbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = okbVar;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdRenderSuccess(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdUnionClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d("express feed ad click", new Object[0]);
            okb okbVar = this.a;
            if (okbVar != null) {
                jlb jlbVar = (jlb) okbVar;
                jlbVar.b.e.onAdClick(jlbVar.a);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdExposed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d("express feed ad onAdExposed", new Object[0]);
            okb okbVar = this.a;
            if (okbVar != null) {
                jlb jlbVar = (jlb) okbVar;
                jlbVar.b.e.onAdShow(jlbVar.a);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdRenderFail(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, str, i) == null) {
            LogPrinter.d("express feed ad onAdRenderFail", new Object[0]);
            okb okbVar = this.a;
            if (okbVar != null) {
                jlb jlbVar = (jlb) okbVar;
                jlbVar.b.onAdError(jlbVar.a, str);
            }
        }
    }
}
