package com.baidu.tieba;

import com.baidu.tieba.lib;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
/* loaded from: classes7.dex */
public class oib implements lib.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ChannelNativeAds.GdtADStatusChangeListener a;

    public oib(pib pibVar, ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pibVar, gdtADStatusChangeListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gdtADStatusChangeListener;
    }

    @Override // com.baidu.tieba.lib.e
    public void onADStatusChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.onADStatusChanged();
        }
    }
}
