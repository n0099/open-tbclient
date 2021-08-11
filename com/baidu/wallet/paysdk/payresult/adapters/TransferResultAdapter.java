package com.baidu.wallet.paysdk.payresult.adapters;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.TransferRequest;
import com.dxmpay.wallet.core.BaseActivity;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class TransferResultAdapter extends PayResultAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferResultAdapter(BaseActivity baseActivity) {
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
    public String getExpectedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TransferRequest transferRequest = (TransferRequest) PayRequestCache.getInstance().getBeanRequestFromCache("request_id_transfer");
            if (transferRequest != null && transferRequest.mTransferType == 1) {
                PayResultContent payResultContent = this.f62206c;
                if (payResultContent != null && !TextUtils.isEmpty(payResultContent.expected_time)) {
                    return this.f62206c.expected_time;
                }
            } else if (transferRequest != null && transferRequest.mTransferType == 2) {
                if (!"3".equals(transferRequest.mPayee_type) && !"2".equals(transferRequest.mPayee_type)) {
                    PayResultContent payResultContent2 = this.f62206c;
                    if (payResultContent2 != null && !TextUtils.isEmpty(payResultContent2.expected_time)) {
                        return this.f62206c.expected_time;
                    }
                } else {
                    return ResUtils.getString(this.f62204a.get(), "ebpay_none_passid_tips");
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            super.getPaySuccessContents();
            this.contents.put("mainTip", "ebpay_payresult_transfer_success");
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            super.getPayingContents();
            this.contents.put("mainTip", "ebpay_pay_error_zhuanzhuang");
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }
}
