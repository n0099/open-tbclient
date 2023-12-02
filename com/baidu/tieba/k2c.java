package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public final class k2c implements ExpressResponse.ExpressDislikeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ l2c a;

    public k2c(l2c l2cVar) {
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

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
    public void onDislikeItemClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
    public void onDislikeWindowShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
    public void onDislikeWindowClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d("express feed onDislikeWindowClose", new Object[0]);
            l2c l2cVar = this.a;
            if (l2cVar != null) {
                g3c g3cVar = (g3c) l2cVar;
                g3cVar.b.e.onAdClose(g3cVar.a);
            }
        }
    }
}
