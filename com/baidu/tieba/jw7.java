package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipUpgrade;
/* loaded from: classes5.dex */
public class jw7 implements yn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897791, "Lcom/baidu/tieba/jw7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897791, "Lcom/baidu/tieba/jw7;");
                return;
            }
        }
        a = BdUniqueId.gen();
    }

    public jw7() {
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

    @Override // com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void a(DataRes dataRes) {
        VipUpgrade vipUpgrade;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) && dataRes != null && (vipUpgrade = dataRes.upgrade) != null) {
            String str = vipUpgrade.svip;
            String str2 = vipUpgrade.link;
            String str3 = vipUpgrade.button;
            String str4 = vipUpgrade.text;
            vipUpgrade.pay.intValue();
            dataRes.upgrade.normal.intValue();
            VipUpgrade vipUpgrade2 = dataRes.upgrade;
            String str5 = vipUpgrade2.card_id;
            String str6 = vipUpgrade2.expire;
        }
    }
}
