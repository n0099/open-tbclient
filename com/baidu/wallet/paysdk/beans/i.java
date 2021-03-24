package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.CheckPwdErrorContent;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i extends BaseBean<Void> {

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f25515a;

    public i(Context context) {
        super(context);
        this.f25515a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(null, CheckPwdErrorContent.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.f25515a == null) {
            return arrayList;
        }
        String seed = PasswordController.getSeed();
        arrayList.add(new RestNameValuePair("mobile_pwd", PasswordController.handlePwd(this.f25515a.mPayPass, seed)));
        arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
        arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
        Map<String, String> map = this.f25515a.mExtData;
        if (map == null) {
            return arrayList;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                key = "";
            }
            if (value == null) {
                value = "";
            }
            arrayList.add(new RestNameValuePair(key, value));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_CHECK_PWD;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CHECK_PWD;
    }
}
