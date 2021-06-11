package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class d extends PayBaseBean<QueryResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f25200a;

    public d(Context context) {
        super(context);
        this.f25200a = null;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(QueryResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null) {
            UserData.SP sp = payResponse.sp;
            str2 = (sp == null || TextUtils.isEmpty(sp.serial_num)) ? null : payResponse.sp.serial_num;
            Map<String, String> map = payResponse.cashdesk;
            str = (map == null || map.isEmpty() || TextUtils.isEmpty(payResponse.cashdesk.get("session_no"))) ? null : payResponse.cashdesk.get("session_no");
        } else {
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new RestNameValuePair("serial_num", str2));
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new RestNameValuePair("precashier_session_no", str));
        }
        String b2 = com.baidu.wallet.paysdk.banksign.a.a.a().b();
        if (!TextUtils.isEmpty(b2)) {
            this.f25200a = b2;
        } else if (PayDataCache.getInstance().isFromPreCashier()) {
            this.f25200a = PayDataCache.getInstance().getSelectedCardNo();
        } else {
            CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
            if (selectCard != null) {
                this.f25200a = selectCard.account_no;
            }
        }
        if (!TextUtils.isEmpty(this.f25200a)) {
            arrayList.add(new RestNameValuePair("selected_card_no", this.f25200a));
        }
        String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(null);
        if (!TextUtils.isEmpty(sessionId)) {
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, sessionId));
        }
        arrayList.add(new RestNameValuePair("sign_request_type", "1"));
        String encryptProxy = SafePay.getInstance().encryptProxy(com.baidu.wallet.paysdk.banksign.a.a.a().l());
        String str3 = SafePay.getInstance().getpwProxy();
        arrayList.add(new RestNameValuePair("agreement_trans_id", encryptProxy));
        arrayList.add(new RestNameValuePair("key", str3));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return BankSignFactory.BEAN_ID_QUERY;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/banksign/query";
    }
}
