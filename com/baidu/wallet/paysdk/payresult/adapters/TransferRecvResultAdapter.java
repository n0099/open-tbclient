package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.personal.datamodel.TransfRecvRequest;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class TransferRecvResultAdapter extends BasePayResultAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public TransfRecvRequest f62409d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferRecvResultAdapter(BaseActivity baseActivity) {
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
    public HashMap<String, String> getPaySuccessContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.contents.clear();
            TransfRecvRequest transfRecvRequest = this.f62409d;
            if (transfRecvRequest == null) {
                return null;
            }
            if (transfRecvRequest.isGatheringSuccess) {
                this.contents.put("mainTip", "ebpay_pay_success");
                this.contents.put("mainTipExt", this.f62409d.recvAmount);
                this.contents.put("statusDrawableName", "wallet_base_result_main_success");
                this.contents.put("okBtnText", "dxm_ebpay_confirm");
                this.contents.put("payDetailInfo", this.f62406c.pay_detail_info);
            }
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.contents.clear();
            if (this.f62409d == null || this.f62405b == null) {
                return null;
            }
            if (!this.f62406c.isPaySuccess) {
                this.contents.put("statusDrawableName", "dxm_wallet_base_result_paying");
                this.contents.put("mainTip", "dxm_wallet_gathering_failed");
                this.contents.put("errorMsg", this.f62406c.mErrorMsg);
                TransfRecvRequest transfRecvRequest = this.f62409d;
                if (transfRecvRequest != null && !TextUtils.isEmpty(transfRecvRequest.errMsg)) {
                    this.contents.put("payDetailInfo", this.f62406c.mErrorMsg);
                }
                this.contents.put("okBtnText", "dxm_ebpay_know");
            }
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PayCallBackManager.callBackClientSuccess(this.f62404a.get().getActivity(), "");
            a(BeanConstants.EV_RECEIVE_MONEY_EXIT);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isPaySuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TransfRecvRequest transfRecvRequest = this.f62409d;
            return transfRecvRequest != null && transfRecvRequest.isGatheringSuccess;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        BeanRequestBase beanRequestFromCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            super.onCreateCheckInvalide(bundle);
            if (bundle != null) {
                beanRequestFromCache = (BeanRequestBase) bundle.getSerializable("mTransferRecvRequest");
            } else {
                beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_TRANSFER_RECV);
            }
            if (beanRequestFromCache == null || !(beanRequestFromCache instanceof TransfRecvRequest)) {
                return false;
            }
            this.f62409d = (TransfRecvRequest) beanRequestFromCache;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            TransfRecvRequest transfRecvRequest = this.f62409d;
            if (transfRecvRequest != null) {
                bundle.putSerializable("mTransferRecvRequest", transfRecvRequest);
            }
        }
    }
}
