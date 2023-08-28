package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
/* loaded from: classes7.dex */
public class mpb extends sqb<KsFullScreenVideoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mpb(KsFullScreenVideoAd ksFullScreenVideoAd) {
        super(ksFullScreenVideoAd);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFullScreenVideoAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sqb
    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            A a = this.a;
            if (a == 0) {
                return 0.0d;
            }
            return ((KsFullScreenVideoAd) a).getECPM();
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.tieba.sqb
    public void b(int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || this.a == 0) {
            return;
        }
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = i;
        ((KsFullScreenVideoAd) this.a).reportAdExposureFailed(i2, adExposureFailedReason);
    }

    @Override // com.baidu.tieba.sqb
    public void c(long j, long j2) {
        A a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (a = this.a) == 0) {
            return;
        }
        ((KsFullScreenVideoAd) a).setBidEcpm((int) j);
    }
}
