package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class UnbindCardBean extends BaseBean<Object> implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public String f25177a;

    /* renamed from: b  reason: collision with root package name */
    public String f25178b;

    /* renamed from: c  reason: collision with root package name */
    public String f25179c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25180d;

    public <T> UnbindCardBean(Context context) {
        super(context);
        this.f25180d = true;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        if (!TextUtils.isEmpty(this.f25179c)) {
            super.execBean(null);
        } else {
            this.mRspCallback.onBeanExecFailure(getBeanId(), -10, "");
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f25179c)) {
            return arrayList;
        }
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25177a)));
        if (this.f25180d) {
            String seed = PasswordController.getSeed();
            String handlePwd = PasswordController.handlePwd(this.f25179c, seed);
            String encryptProxy = SafePay.getInstance().encryptProxy(seed);
            arrayList.add(new RestNameValuePair("mobile_pass", handlePwd));
            arrayList.add(new RestNameValuePair("seed", encryptProxy));
        } else {
            arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f25178b)));
            arrayList.add(new RestNameValuePair("vcode", this.f25179c));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 516;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_UNBIND_CARD;
    }

    public void setCardNo(String str) {
        this.f25177a = str;
    }

    public void setPhoneNo(String str) {
        this.f25178b = str;
    }

    public void setUsePass(boolean z) {
        this.f25180d = z;
    }

    public void setValue(String str) {
        this.f25179c = str;
    }
}
