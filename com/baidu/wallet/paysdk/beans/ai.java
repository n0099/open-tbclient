package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponseForNoPwd;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ai extends PayBaseBean<VerifyCodeResponseForNoPwd> {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.wallet.paysdk.datamodel.e f25495a;

    public ai(Context context) {
        super(context);
        this.f25495a = (com.baidu.wallet.paysdk.datamodel.e) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_VERIFY_CODE_FOR_NO_PWD);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(VerifyCodeResponseForNoPwd.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        return new ArrayList();
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 10;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_REQUEST_SMS_CODE_FOR_NO_PWD;
    }
}
