package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b extends PayBaseBean<GetJumpUrlResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f25922a;

    public b(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f25922a = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(GetJumpUrlResponse.class);
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
        if (!TextUtils.isEmpty(sessionId)) {
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, sessionId));
        }
        if (!TextUtils.isEmpty(this.f25922a)) {
            arrayList.add(new RestNameValuePair("selected_card_no", this.f25922a));
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
        return 768;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/banksign/getjumpurl";
    }
}
