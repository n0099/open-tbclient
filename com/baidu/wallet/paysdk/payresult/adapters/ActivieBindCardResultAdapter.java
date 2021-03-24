package com.baidu.wallet.paysdk.payresult.adapters;

import com.baidu.wallet.core.BaseActivity;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ActivieBindCardResultAdapter extends PayResultAdapter {
    public ActivieBindCardResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getActionBarTextId() {
        return "ebpay_bind_card_result";
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        super.getPaySuccessContents();
        this.contents.put("mainTip", "ebpay_bind_card_success");
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        super.getPayingContents();
        this.contents.put("mainTip", "ebpay_bind_card_success");
        return this.contents;
    }
}
