package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import java.util.Map;
/* loaded from: classes6.dex */
public class inb extends gnb<UnifiedInterstitialAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public inb(UnifiedInterstitialAD unifiedInterstitialAD) {
        super(unifiedInterstitialAD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {unifiedInterstitialAD};
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

    @Override // com.baidu.tieba.gnb
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (String) ((UnifiedInterstitialAD) this.a).getExtraInfo().get(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gnb
    public void b(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            ((UnifiedInterstitialAD) this.a).sendLossNotification(map);
        }
    }

    @Override // com.baidu.tieba.gnb
    public void d(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            ((UnifiedInterstitialAD) this.a).sendWinNotification(map);
        }
    }

    @Override // com.baidu.tieba.gnb
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((UnifiedInterstitialAD) this.a).getECPM();
        }
        return invokeV.intValue;
    }
}
