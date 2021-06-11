package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class x extends PayBaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f25279a;

    /* renamed from: b  reason: collision with root package name */
    public String f25280b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25281c;

    public <T> x(Context context) {
        super(context);
        this.f25279a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    private void a(List<RestNameValuePair> list) {
        if (!this.f25281c || TextUtils.isEmpty(this.f25280b)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f25280b);
            jSONObject.remove(Constants.HALF_SCREEN_PWD_VERIFY);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    list.add(new RestNameValuePair(next, opt != null ? String.valueOf(opt) : ""));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class, ErrorContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        String seed = PasswordController.getSeed();
        String encryptProxy = SafePay.getInstance().encryptProxy(seed);
        int i2 = this.f25279a.mRequestType;
        if (i2 != 2 && i2 != 1) {
            String encryptProxy2 = SafePay.getInstance().encryptProxy(PasswordController.handlePwdSimple(this.f25279a.mConfirmPayPass));
            String handlePwd = PasswordController.handlePwd(this.f25279a.mConfirmPayPass, seed);
            String str = SafePay.getInstance().getpwProxy();
            arrayList.add(new RestNameValuePair("new_mobile_pwd", encryptProxy2));
            arrayList.add(new RestNameValuePair("confirm_new_mobile_pwd", handlePwd));
            arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f25279a.mConfirmPayPass)));
            arrayList.add(new RestNameValuePair("key_no", str));
            arrayList.add(new RestNameValuePair("sess_key", this.f25279a.mSessionKey));
        } else {
            if (!TextUtils.isEmpty(this.f25279a.mPayPass)) {
                String handlePwd2 = PasswordController.handlePwd(this.f25279a.mPayPass, seed);
                String str2 = SafePay.getInstance().getpwProxy();
                arrayList.add(new RestNameValuePair("mobile_pwd", handlePwd2));
                arrayList.add(new RestNameValuePair("key", str2));
            }
            a(arrayList);
        }
        arrayList.add(new RestNameValuePair("seed", encryptProxy));
        PwdRequest pwdRequest = this.f25279a;
        if (pwdRequest.mRequestType == 2 && TextUtils.equals(pwdRequest.fromType, BeanConstants.FROM_BIND)) {
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            arrayList.add(new RestNameValuePair("scenario", "bindcard"));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            if (bindFastRequest != null) {
                arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
            } else {
                arrayList.add(new RestNameValuePair("request_type", BindFastRequest.getCardRequestType(1)));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f25279a.serviceType));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        int i2 = this.f25279a.mRequestType;
        if (i2 == 2) {
            return 257;
        }
        return i2 == 3 ? 259 : 258;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        int i2 = this.f25279a.mRequestType;
        if (i2 == 2) {
            String str = PayRequestCache.getInstance().isPaying() ? BeanConstants.API_VERIFY_PAY_PWD : BeanConstants.API_VERIFY_MOBILE_PWD_NEW;
            return DomainConfig.getInstance().getAppPayHost() + str;
        } else if (i2 == 1) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CHECK_MOBILE_PWD;
        } else if (i2 == 3) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_MODIFY_MOBILE_PWD;
        } else {
            return "";
        }
    }

    public void a(String str) {
        this.f25280b = str;
    }

    public void a(boolean z) {
        this.f25281c = z;
    }
}
