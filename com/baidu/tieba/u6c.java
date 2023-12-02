package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public class u6c extends y6c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ f6c c;
    public final /* synthetic */ t6c d;

    public u6c(t6c t6cVar, f6c f6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t6cVar, f6cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = t6cVar;
        this.c = f6cVar;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.d.onAdClicked((t6c) this.c, this.b, new String[0]);
            this.b = true;
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            this.d.onAdClose(this.c);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            LogPrinter.e("onAdShowError code: " + i + ", message: " + str, new Object[0]);
            this.d.onAdError(this.c, i, str);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            this.d.onAdShow((t6c) this.c, this.a, new String[0]);
            this.a = true;
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
            this.d.onAdClose(this.c);
        }
    }
}
