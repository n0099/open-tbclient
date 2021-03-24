package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.PollingResponse;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class c extends PayBaseBean<PollingResponse> {
    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(PollingResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        String str;
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(null);
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null) {
            UserData.SP sp = payResponse.sp;
            String str3 = (sp == null || TextUtils.isEmpty(sp.serial_num)) ? null : payResponse.sp.serial_num;
            Map<String, String> map = payResponse.cashdesk;
            if (map != null && !map.isEmpty() && !TextUtils.isEmpty(payResponse.cashdesk.get("session_no"))) {
                str2 = payResponse.cashdesk.get("session_no");
            }
            str = str2;
            str2 = str3;
        } else {
            str = null;
        }
        String encryptProxy = SafePay.getInstance().encryptProxy(com.baidu.wallet.paysdk.banksign.a.a.a().l());
        String str4 = SafePay.getInstance().getpwProxy();
        arrayList.add(new RestNameValuePair("agreement_trans_id", encryptProxy));
        arrayList.add(new RestNameValuePair("key", str4));
        if (!TextUtils.isEmpty(sessionId)) {
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, sessionId));
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new RestNameValuePair("serial_num", str2));
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new RestNameValuePair("precashier_session_no", str));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return BankSignFactory.BEAN_ID_POLLING;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/banksign/polling";
    }
}
