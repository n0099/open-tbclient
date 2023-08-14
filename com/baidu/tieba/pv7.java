package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.funad.view.FunAdButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.ChannelNativeAds;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes7.dex */
public class pv7 implements TTAppDownloadListener, ChannelNativeAds.GdtADStatusChangeListener, KsAppDownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunAdButton a;
    public final pba b;
    public ChannelNativeAds c;

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public pv7(FunAdButton funAdButton, pba pbaVar, ChannelNativeAds channelNativeAds) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdButton, pbaVar, channelNativeAds};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = funAdButton;
        this.b = pbaVar;
        this.c = channelNativeAds;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            FunAdButton funAdButton = this.a;
            if (funAdButton != null && funAdButton.getTag() == this.b) {
                this.a.setText(i);
            }
            pba pbaVar = this.b;
            if (pbaVar != null) {
                pbaVar.l(TbadkApplication.getInst().getString(i));
            }
        }
    }

    public void b(int i) {
        FunAdButton funAdButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (funAdButton = this.a) != null && funAdButton.getTag() == this.b) {
            this.a.setProgress(i);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            b(i);
        }
    }

    @Override // com.fun.ad.sdk.ChannelNativeAds.GdtADStatusChangeListener
    public void onADStatusChanged() {
        NativeUnifiedADData nativeUnifiedADData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ChannelNativeAds channelNativeAds = this.c;
            if (channelNativeAds != null) {
                nativeUnifiedADData = (NativeUnifiedADData) channelNativeAds.gdtNative;
            } else {
                nativeUnifiedADData = null;
            }
            if (nativeUnifiedADData == null) {
                return;
            }
            if (!nativeUnifiedADData.isAppAd()) {
                a(R.string.obfuscated_res_0x7f0f00e0);
                return;
            }
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus != 0) {
                if (appStatus != 1) {
                    if (appStatus != 2) {
                        if (appStatus != 4) {
                            if (appStatus != 8) {
                                if (appStatus != 16) {
                                    a(R.string.obfuscated_res_0x7f0f00e0);
                                    return;
                                } else {
                                    a(R.string.obfuscated_res_0x7f0f00dd);
                                    return;
                                }
                            }
                            a(R.string.obfuscated_res_0x7f0f00db);
                            return;
                        }
                        b(nativeUnifiedADData.getProgress());
                        return;
                    }
                    a(R.string.obfuscated_res_0x7f0f00df);
                    return;
                }
                a(R.string.obfuscated_res_0x7f0f00de);
                return;
            }
            a(R.string.obfuscated_res_0x7f0f00da);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) && j > 0) {
            b((int) ((j2 * 100) / j));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) && j > 0) {
            b((int) ((j2 * 100) / j));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00da);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00db);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00da);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00dc);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            a(R.string.obfuscated_res_0x7f0f00da);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            a(R.string.obfuscated_res_0x7f0f00db);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            a(R.string.obfuscated_res_0x7f0f00dc);
        }
    }
}
