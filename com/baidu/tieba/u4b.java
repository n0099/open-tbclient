package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsInterstitialAd;
/* loaded from: classes8.dex */
public class u4b implements KsInterstitialAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ l4b a;
    public final /* synthetic */ r4b b;

    public u4b(r4b r4bVar, l4b l4bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r4bVar, l4bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = r4bVar;
        this.a = l4bVar;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.b.onAdClicked((r4b) this.a, false, new String[0]);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            this.b.onAdShow((r4b) this.a, false, new String[0]);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onPageDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            this.b.onAdClose(this.a);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onSkippedAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LogPrinter.d();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            LogPrinter.e("onVideoPlayError code:%d extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            this.b.onAdError(this.a, i, String.valueOf(i2));
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LogPrinter.d();
        }
    }
}
