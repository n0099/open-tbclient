package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public final class w3c implements ExpressResponse.ExpressInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ l2c a;

    public w3c(l2c l2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l2cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = l2cVar;
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
            l2c l2cVar = this.a;
            if (l2cVar != null) {
                g3c g3cVar = (g3c) l2cVar;
                g3cVar.b.e.onAdClick(g3cVar.a);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdExposed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d("express feed ad onAdExposed", new Object[0]);
            l2c l2cVar = this.a;
            if (l2cVar != null) {
                g3c g3cVar = (g3c) l2cVar;
                g3cVar.b.e.onAdShow(g3cVar.a);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdRenderFail(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view2, str, i) == null) {
            LogPrinter.d("express feed ad onAdRenderFail", new Object[0]);
            l2c l2cVar = this.a;
            if (l2cVar != null) {
                g3c g3cVar = (g3c) l2cVar;
                g3cVar.b.onAdError(g3cVar.a, str);
            }
        }
    }
}
