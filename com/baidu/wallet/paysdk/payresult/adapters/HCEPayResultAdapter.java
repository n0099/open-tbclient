package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class HCEPayResultAdapter extends BasePayResultAdapter {
    public HCEPayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        this.contents.clear();
        PayResultContent payResultContent = this.f26136c;
        if (payResultContent == null || this.f26135b == null) {
            return null;
        }
        if (!payResultContent.isPaySuccess) {
            this.contents.put("statusDrawableName", "wallet_hce_icon_nfc_fail");
            this.contents.put("mainTip", "wallet_hce_pay_failed");
            this.contents.put("errorMsg", this.f26136c.mErrorMsg);
        }
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_QUICK_PASS_PAY_RET_SHOW, this.f26136c.isPaySuccess ? "1" : "0");
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_QUICK_PASS_PAY_DONE_CLICK, this.f26136c.isPaySuccess ? "1" : "0");
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        boolean onCreateCheckInvalide = super.onCreateCheckInvalide(bundle);
        PayResultContent payResultContent = this.f26136c;
        if (payResultContent != null) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_QUICK_PASS_CLICK_OPEN, payResultContent.isPaySuccess ? "1" : "0");
        }
        return onCreateCheckInvalide;
    }
}
