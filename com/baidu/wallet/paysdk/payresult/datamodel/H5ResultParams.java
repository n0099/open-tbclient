package com.baidu.wallet.paysdk.payresult.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
/* loaded from: classes6.dex */
public class H5ResultParams implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String pay_result_params;
    public String pay_result_url;
    public CashierDeskPayResult.PayScenario pay_scenario;
    public String redirect_sp_succpage_remain_time;
    public String show_h5_result;

    public H5ResultParams(String str, String str2, String str3, String str4, CashierDeskPayResult.PayScenario payScenario) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, payScenario};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.redirect_sp_succpage_remain_time = str;
        this.pay_result_url = str2;
        this.pay_result_params = str3;
        this.show_h5_result = str4;
        this.pay_scenario = CashierDeskPayResult.PayScenario.BalancedPay != payScenario ? CashierDeskPayResult.PayScenario.BankcardPay : payScenario;
    }

    public boolean toShowH5ResultPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? toShowH5ResultPage(this.redirect_sp_succpage_remain_time, this.pay_result_url, this.show_h5_result) : invokeV.booleanValue;
    }

    public static boolean toShowH5ResultPage(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || "0".equals(str)) {
                return false;
            }
            if (str3 == null || "1".equals(str3)) {
                return !TextUtils.isEmpty(str2);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
