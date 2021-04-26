package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import com.baidu.wallet.core.BaseActivity;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class BusCardPayResultAdapter extends PayResultAdapter {
    public BusCardPayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        super.getPaySuccessContents();
        this.contents.put("okBtnText", "wallet_base_payresult_goto_next");
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.PayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        super.onCreateCheckInvalide(bundle);
        return this.f26136c != null;
    }
}
