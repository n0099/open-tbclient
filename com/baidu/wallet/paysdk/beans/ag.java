package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyByBankResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ag extends PayBaseBean<VerifyByBankResponse> {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f25201a = {"coupon_id", "activity_id", "stage_number", "need_bind_card", "sms_vcode", "seed", "mobile_pwd", "confirm_mobile_pwd", "mobile_pwd_psp", "open_passfree", "fp_code", "fp_num", "need_open_passfree", "need_open_authorize", "message_vcode", "is_pay_sms"};

    /* renamed from: b  reason: collision with root package name */
    public final List f25202b;

    public ag(Context context) {
        super(context);
        this.f25202b = Arrays.asList(f25201a);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(VerifyByBankResponse.class, ErrorContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList(PayDataCache.getInstance().getPrePayRequestParams());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (this.f25202b.indexOf(((RestNameValuePair) it.next()).getName()) != -1) {
                it.remove();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_APPLY_VERIFY_SMS_BY_BANK;
    }
}
