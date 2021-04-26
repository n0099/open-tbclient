package com.baidu.wallet.paysdk.b;

import android.content.Context;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
/* loaded from: classes5.dex */
public class f extends g {
    public com.baidu.wallet.paysdk.beans.g r;

    @Override // com.baidu.wallet.paysdk.b.g, com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean E() {
        BindFastRequest bindFastRequest = this.f25898e;
        if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || this.f25898e.getmBankInfo().channel_info == null) {
            return true;
        }
        return this.f25898e.getmBankInfo().channel_info.isNeedSendSms();
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void c(String... strArr) {
        if (this.r == null) {
            this.r = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f25897d, 17, BindCardBaseActivity.BEAN_TAG);
        }
        this.r.a(this.f25898e);
        this.r.setResponseCallback(this.f25897d);
        StatisticManager.onEventStart(StatServiceEvent.TIME_SMS);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
        PayStatisticsUtil.onEvent(StatServiceEvent.GET_SMS_CODE);
        b(strArr);
        this.r.execBean();
    }
}
