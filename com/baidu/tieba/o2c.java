package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.channel.model.baidu.CustomProgressButton;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes7.dex */
public final class o2c implements NativeResponse.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q2c a;
    public final /* synthetic */ CustomProgressButton b;
    public final /* synthetic */ NativeResponse c;

    public o2c(q2c q2cVar, CustomProgressButton customProgressButton, NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q2cVar, customProgressButton, nativeResponse};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q2cVar;
        this.b = customProgressButton;
        this.c = nativeResponse;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADExposed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADExposureFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a.onADExposureFailed(i);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADStatusChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            CustomProgressButton customProgressButton = this.b;
            if (customProgressButton != null) {
                customProgressButton.a(this.c);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onAdUnionClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
        }
    }
}
