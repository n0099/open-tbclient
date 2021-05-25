package com.baidu.wallet.paysdk.payresult.adapters;

import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.TransferRequest;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class TransferResultAdapter extends PayResultAdapter {
    public TransferResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getExpectedTime() {
        TransferRequest transferRequest = (TransferRequest) PayRequestCache.getInstance().getBeanRequestFromCache("request_id_transfer");
        if (transferRequest != null && transferRequest.mTransferType == 1) {
            PayResultContent payResultContent = this.f25310c;
            if (payResultContent != null && !TextUtils.isEmpty(payResultContent.expected_time)) {
                return this.f25310c.expected_time;
            }
        } else if (transferRequest != null && transferRequest.mTransferType == 2) {
            if (!"3".equals(transferRequest.mPayee_type) && !"2".equals(transferRequest.mPayee_type)) {
                PayResultContent payResultContent2 = this.f25310c;
                if (payResultContent2 != null && !TextUtils.isEmpty(payResultContent2.expected_time)) {
                    return this.f25310c.expected_time;
                }
            } else {
                return ResUtils.getString(this.f25308a.get(), "ebpay_none_passid_tips");
            }
        }
        return "";
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        super.getPaySuccessContents();
        this.contents.put("mainTip", "ebpay_payresult_transfer_success");
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        super.getPayingContents();
        this.contents.put("mainTip", "ebpay_pay_error_zhuanzhuang");
        return this.contents;
    }
}
