package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class FastPayResultAdapter extends PayResultAdapter {
    public FastPayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getExpectedTime() {
        PayResultContent payResultContent = this.f25413c;
        return (payResultContent == null || TextUtils.isEmpty(payResultContent.expected_time)) ? "" : this.f25413c.expected_time;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        super.getPayingContents();
        this.contents.put("mainTip", "ebpay_pay_error_huafei");
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.PayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        super.onCreateCheckInvalide(bundle);
        return this.f25413c != null;
    }
}
