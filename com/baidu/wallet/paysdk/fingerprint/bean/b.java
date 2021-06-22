package com.baidu.wallet.paysdk.fingerprint.bean;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.datamodel.OpenFingerprintResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends PayBaseBean<OpenFingerprintResponse> {

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f25463a;

    public b(Context context) {
        super(context);
        this.f25463a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        execBean(OpenFingerprintResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        PwdRequest pwdRequest = this.f25463a;
        if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
            String seed = PasswordController.getSeed();
            String encryptProxy = SafePay.getInstance().encryptProxy(seed);
            arrayList.add(new RestNameValuePair("mobile_pwd", PasswordController.handlePwd(this.f25463a.mPayPass, seed)));
            arrayList.add(new RestNameValuePair("seed", encryptProxy));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/_u/otp/createtoken/";
    }
}
