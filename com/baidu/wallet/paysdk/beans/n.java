package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class n extends BaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25214a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f25215b;

    public <T> n(Context context) {
        super(context);
        this.f25214a = null;
        this.f25215b = null;
        this.f25215b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(null);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        if (this.f25214a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25214a.getmBankCard())));
            String handlePwdSimple = PasswordController.handlePwdSimple(this.f25215b.mPayPass);
            String seed = PasswordController.getSeed();
            String handlePwd = PasswordController.handlePwd(this.f25215b.mConfirmPayPass, seed);
            arrayList.add(new RestNameValuePair("mobile_pwd", SafePay.getInstance().encryptProxy(handlePwdSimple)));
            arrayList.add(new RestNameValuePair("confirm_mobile_pwd", handlePwd));
            arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f25215b.mConfirmPayPass)));
            arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
            arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
            arrayList.add(new RestNameValuePair("sms_token", this.f25214a.getSmsToken()));
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, this.f25214a.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "gbk";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_FIND_PASS_FROM_OLD_CARD_RESETPASS;
    }
}
