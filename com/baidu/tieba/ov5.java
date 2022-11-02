package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ov5 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public static final BdUniqueId d;
    public transient /* synthetic */ FieldHolder $fh;
    public bv5 a;
    public bv5 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948045723, "Lcom/baidu/tieba/ov5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948045723, "Lcom/baidu/tieba/ov5;");
                return;
            }
        }
        c = BdUniqueId.gen();
        d = BdUniqueId.gen();
    }

    public ov5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bv5 bv5Var = this.a;
            if (bv5Var != null && (sdkLiveInfoData = bv5Var.a) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null && (yYExt = alaLiveInfo.yyExt) != null && yYExt.isYYGame == 1) {
                return d;
            }
            return c;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
