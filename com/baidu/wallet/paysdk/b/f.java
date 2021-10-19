package com.baidu.wallet.paysdk.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
/* loaded from: classes8.dex */
public class f extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.wallet.paysdk.beans.f r;

    public f() {
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

    @Override // com.baidu.wallet.paysdk.b.g, com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BindFastRequest bindFastRequest = this.f62654e;
            if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || this.f62654e.getmBankInfo().channel_info == null) {
                return true;
            }
            return this.f62654e.getmBankInfo().channel_info.isNeedSendSms();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void c(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr) == null) {
            if (this.r == null) {
                this.r = (com.baidu.wallet.paysdk.beans.f) PayBeanFactory.getInstance().getBean((Context) this.f62653d, 17, BindCardBaseActivity.BEAN_TAG);
            }
            this.r.a(this.f62654e);
            this.r.setResponseCallback(this.f62653d);
            StatisticManager.onEvent("callCardCheck");
            b(strArr);
            this.r.execBean();
        }
    }
}
