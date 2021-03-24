package com.baidu.wallet.paysdk.payresult.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
/* loaded from: classes5.dex */
public class H5ResultParams implements NoProguard {
    public String pay_result_params;
    public String pay_result_url;
    public CashierDeskPayResult.PayScenario pay_scenario;
    public String redirect_sp_succpage_remain_time;
    public String show_h5_result;

    public H5ResultParams(String str, String str2, String str3, String str4, CashierDeskPayResult.PayScenario payScenario) {
        this.redirect_sp_succpage_remain_time = str;
        this.pay_result_url = str2;
        this.pay_result_params = str3;
        this.show_h5_result = str4;
        this.pay_scenario = CashierDeskPayResult.PayScenario.BalancedPay != payScenario ? CashierDeskPayResult.PayScenario.BankcardPay : payScenario;
    }

    public boolean toShowH5ResultPage() {
        return toShowH5ResultPage(this.redirect_sp_succpage_remain_time, this.pay_result_url, this.show_h5_result);
    }

    public static boolean toShowH5ResultPage(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || "0".equals(str)) {
            return false;
        }
        if (str3 == null || "1".equals(str3)) {
            return !TextUtils.isEmpty(str2);
        }
        return false;
    }
}
