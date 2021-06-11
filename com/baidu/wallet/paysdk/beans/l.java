package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardCheckSmsResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class l extends BaseBean<FindPWDFromOldCardCheckSmsResponse> {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25260a;

    public <T> l(Context context) {
        super(context);
        this.f25260a = null;
        this.f25260a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Pwd.name());
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(FindPWDFromOldCardCheckSmsResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25260a.getmBankCard())));
        arrayList.add(new RestNameValuePair("sms_vcode", this.f25260a.mSmsVCode));
        arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_CHECKSMS;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "gbk";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_FIND_PASS_FROM_OLD_CARD_CHECKSMS;
    }
}
