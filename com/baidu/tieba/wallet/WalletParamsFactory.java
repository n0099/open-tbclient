package com.baidu.tieba.wallet;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.GetOrder.DataRes;
/* loaded from: classes13.dex */
public class WalletParamsFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WalletParamsFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HashMap<String, String> buildWalletParams(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (dataRes == null) {
                return hashMap;
            }
            hashMap.put("customerId", "" + dataRes.customerId);
            hashMap.put("service", dataRes.service);
            hashMap.put("orderId", dataRes.orderId);
            hashMap.put("orderCreateTime", "" + dataRes.orderCreateTime);
            hashMap.put("deviceType", "" + dataRes.deviceType);
            hashMap.put("payAmount", "" + dataRes.payAmount);
            hashMap.put("originalAmount", "" + dataRes.originalAmount);
            hashMap.put("notifyUrl", dataRes.notifyUrl);
            hashMap.put("passuid", dataRes.passuid);
            hashMap.put("title", dataRes.title);
            hashMap.put("mobile", dataRes.mobile);
            hashMap.put("itemInfo", dataRes.itemInfo);
            hashMap.put("sdk", "" + dataRes.sdk);
            hashMap.put("sdkStyle", "" + dataRes.sdkStyle);
            hashMap.put("sign", dataRes.sign);
            hashMap.put("signType", "" + dataRes.signType);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
