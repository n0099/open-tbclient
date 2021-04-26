package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class SignContractPayResultAdapter extends BasePayResultAdapter {
    public SignContractPayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getActionBarTextId() {
        return "ebpay_sign_contract_result";
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        this.contents.clear();
        PayResultContent payResultContent = this.f26136c;
        if (payResultContent == null || this.f26135b == null) {
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
            this.contents.put("payDetailInfo", this.f26136c.pay_detail_info);
        }
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        this.contents.clear();
        PayResultContent payResultContent = this.f26136c;
        if (payResultContent == null || this.f26135b == null) {
            return null;
        }
        if (!payResultContent.isPaySuccess) {
            this.contents.put("statusDrawableName", "wallet_base_result_paying");
            this.contents.put("mainTip", b.a() ? "ebpay_sign_paying" : "ebpay_pay_paying");
            this.contents.put("errorMsg", this.f26136c.mErrorMsg);
        }
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        PayCallBackManager.callBackClientSuccess(this.f26134a.get().getActivity(), "");
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        super.onCreateCheckInvalide(bundle);
        return this.f26136c != null;
    }
}
