package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ae extends PayBaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public String f25127a;

    /* renamed from: b  reason: collision with root package name */
    public String f25128b;

    /* renamed from: c  reason: collision with root package name */
    public String f25129c;

    public <T> ae(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("new_passfree_status", this.f25128b));
        arrayList.add(new RestNameValuePair("new_passfree_credit", this.f25129c));
        if (!TextUtils.isEmpty(this.f25127a)) {
            String seed = PasswordController.getSeed();
            arrayList.add(new RestNameValuePair("mobile_pwd", PasswordController.handlePwd(this.f25127a, seed)));
            arrayList.add(new RestNameValuePair("pwd_seed", SafePay.getInstance().encryptProxy(seed)));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SET_PASSFREE;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SET_PASS_FREE;
    }
}
