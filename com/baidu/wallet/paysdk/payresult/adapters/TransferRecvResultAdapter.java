package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.personal.datamodel.TransfRecvRequest;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class TransferRecvResultAdapter extends BasePayResultAdapter {

    /* renamed from: d  reason: collision with root package name */
    public TransfRecvRequest f26139d;

    public TransferRecvResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        this.contents.clear();
        TransfRecvRequest transfRecvRequest = this.f26139d;
        if (transfRecvRequest == null) {
            return null;
        }
        if (transfRecvRequest.isGatheringSuccess) {
            this.contents.put("mainTip", "ebpay_pay_success");
            this.contents.put("mainTipExt", this.f26139d.recvAmount);
            this.contents.put("statusDrawableName", "wallet_base_result_main_success");
            this.contents.put("okBtnText", "ebpay_confirm");
            this.contents.put("payDetailInfo", this.f26136c.pay_detail_info);
        }
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        this.contents.clear();
        if (this.f26139d == null || this.f26135b == null) {
            return null;
        }
        if (!this.f26136c.isPaySuccess) {
            this.contents.put("statusDrawableName", "wallet_base_result_paying");
            this.contents.put("mainTip", "bd_wallet_gathering_failed");
            this.contents.put("errorMsg", this.f26136c.mErrorMsg);
            TransfRecvRequest transfRecvRequest = this.f26139d;
            if (transfRecvRequest != null && !TextUtils.isEmpty(transfRecvRequest.errMsg)) {
                this.contents.put("payDetailInfo", this.f26136c.mErrorMsg);
            }
            this.contents.put("okBtnText", "ebpay_know");
        }
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        PayCallBackManager.callBackClientSuccess(this.f26134a.get().getActivity(), "");
        a(BeanConstants.EV_RECEIVE_MONEY_EXIT);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isPaySuccess() {
        TransfRecvRequest transfRecvRequest = this.f26139d;
        return transfRecvRequest != null && transfRecvRequest.isGatheringSuccess;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        BeanRequestBase beanRequestFromCache;
        super.onCreateCheckInvalide(bundle);
        if (bundle != null) {
            beanRequestFromCache = (BeanRequestBase) bundle.getSerializable("mTransferRecvRequest");
        } else {
            beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_TRANSFER_RECV);
        }
        if (beanRequestFromCache == null || !(beanRequestFromCache instanceof TransfRecvRequest)) {
            return false;
        }
        this.f26139d = (TransfRecvRequest) beanRequestFromCache;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TransfRecvRequest transfRecvRequest = this.f26139d;
        if (transfRecvRequest != null) {
            bundle.putSerializable("mTransferRecvRequest", transfRecvRequest);
        }
    }
}
