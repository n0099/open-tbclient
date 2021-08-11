package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class HCEPayResultAdapter extends BasePayResultAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HCEPayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BaseActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.contents.clear();
            PayResultContent payResultContent = this.f62206c;
            if (payResultContent == null || this.f62205b == null) {
                return null;
            }
            if (!payResultContent.isPaySuccess) {
                this.contents.put("statusDrawableName", "wallet_hce_icon_nfc_fail");
                this.contents.put("mainTip", "wallet_hce_pay_failed");
                this.contents.put("errorMsg", this.f62206c.mErrorMsg);
            }
            StatisticManager.onEventWithValue(StatServiceEvent.EVENT_QUICK_PASS_PAY_RET_SHOW, this.f62206c.isPaySuccess ? "1" : "0");
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticManager.onEventWithValue(StatServiceEvent.EVENT_QUICK_PASS_PAY_DONE_CLICK, this.f62206c.isPaySuccess ? "1" : "0");
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            boolean onCreateCheckInvalide = super.onCreateCheckInvalide(bundle);
            PayResultContent payResultContent = this.f62206c;
            if (payResultContent != null) {
                StatisticManager.onEventWithValue(StatServiceEvent.EVENT_QUICK_PASS_CLICK_OPEN, payResultContent.isPaySuccess ? "1" : "0");
            }
            return onCreateCheckInvalide;
        }
        return invokeL.booleanValue;
    }
}
