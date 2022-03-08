package com.baidu.tieba.wallet.pay;

import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.wallet.Login;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.api.BaiduWalletDelegate;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class PayActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PayActivityStatic() {
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

    public static void initBaiduWallet() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && BaiduWalletDelegate.getInstance().getAppContext() == null) {
            BaiduWallet.getInstance().initWallet(new Login(TbadkApplication.getInst().getContext()), TbadkApplication.getInst().getContext(), "tieba");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(BaiduRimConstants.RIM_ID_KEY, "2100020001");
            hashMap.put("tpl", "1200020868");
            hashMap.put("appkey", "ef4b7e008deab5c6fd206d180c5967039bfa8120");
            BaiduRIM.getInstance().initRIM(TbadkApplication.getInst().getContext(), hashMap);
        }
    }
}
