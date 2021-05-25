package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardSendSmsResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o extends BaseBean<FindPWDFromOldCardSendSmsResponse> {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25160a;

    public <T> o(Context context) {
        super(context);
        this.f25160a = null;
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25160a = bindFastRequest;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(FindPWDFromOldCardSendSmsResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        if (this.f25160a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25160a.getmBankCard())));
            arrayList.add(new RestNameValuePair("account_bank_code", this.f25160a.getSubBankCode()));
            arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "gbk";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_FIND_PASS_FROM_OLD_CARD_SENDSMS;
    }
}
