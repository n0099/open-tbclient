package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class SignContractPayResultAdapter extends BasePayResultAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignContractPayResultAdapter(BaseActivity baseActivity) {
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
    public String getActionBarTextId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ebpay_sign_contract_result" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.contents.clear();
            PayResultContent payResultContent = this.f26148c;
            if (payResultContent == null || this.f26147b == null) {
                return null;
            }
            if (payResultContent.isPaySuccess) {
                if (b.a()) {
                    this.contents.put("mainTip", b.b() ? "ebpay_auth_payresult_sign_success" : "ebpay_auth_payresult_pay_success");
                } else {
                    this.contents.put("mainTip", "ebpay_pay_success");
                }
                this.contents.put("statusDrawableName", "wallet_base_result_main_success");
                this.contents.put("okBtnText", "ebpay_result_btn_success");
                this.contents.put("payDetailInfo", this.f26148c.pay_detail_info);
            }
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.contents.clear();
            PayResultContent payResultContent = this.f26148c;
            if (payResultContent == null || this.f26147b == null) {
                return null;
            }
            if (!payResultContent.isPaySuccess) {
                this.contents.put("statusDrawableName", "wallet_base_result_paying");
                this.contents.put("mainTip", b.a() ? "ebpay_sign_paying" : "ebpay_pay_paying");
                this.contents.put("errorMsg", this.f26148c.mErrorMsg);
            }
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PayCallBackManager.callBackClientSuccess(this.f26146a.get().getActivity(), "");
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            super.onCreateCheckInvalide(bundle);
            return this.f26148c != null;
        }
        return invokeL.booleanValue;
    }
}
