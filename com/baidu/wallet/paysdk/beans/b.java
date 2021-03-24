package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends PayBaseBean<BindCardResponse> {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25499a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f25500b;

    public <T> b(Context context) {
        super(context);
        this.f25499a = null;
        this.f25500b = null;
        this.f25499a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.f25500b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25499a = bindFastRequest;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(BindCardResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        if (this.f25499a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25499a.getmBankCard())));
            arrayList.add(new RestNameValuePair("request_type", this.f25499a.getCardRequestType()));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f25499a.getServiceType()));
            if (!TextUtils.isEmpty(this.f25499a.getmName())) {
                arrayList.add(new RestNameValuePair("true_name", this.f25499a.getmName()));
            }
            if (!TextUtils.isEmpty(this.f25499a.getCertificateType())) {
                arrayList.add(new RestNameValuePair("identity_type", this.f25499a.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.f25499a.getmIdCard())) {
                arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f25499a.getmIdCard())));
            }
            if (!TextUtils.isEmpty(this.f25499a.getmPhone())) {
                arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f25499a.getmPhone())));
            }
            arrayList.add(new RestNameValuePair("vcode", this.f25499a.getmSmsVCode()));
            PwdRequest pwdRequest = this.f25500b;
            if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass) && !TextUtils.isEmpty(this.f25500b.mConfirmPayPass)) {
                String handlePwdSimple = PasswordController.handlePwdSimple(this.f25500b.mPayPass);
                String seed = PasswordController.getSeed();
                String handlePwd = PasswordController.handlePwd(this.f25500b.mConfirmPayPass, seed);
                arrayList.add(new RestNameValuePair("mobile_pass", SafePay.getInstance().encryptProxy(handlePwdSimple)));
                arrayList.add(new RestNameValuePair("mobile_pass_confirm", handlePwd));
                arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f25500b.mConfirmPayPass)));
                arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
            }
            if (!TextUtils.isEmpty(this.f25499a.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f25499a.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.f25499a.getmCvv())) {
                arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f25499a.getmCvv())));
            }
            if (!TextUtils.isEmpty(this.f25499a.getChannelNo())) {
                arrayList.add(new RestNameValuePair("channel_no", this.f25499a.getChannelNo()));
            }
            if (!TextUtils.isEmpty(this.f25499a.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("sub_bank_code", this.f25499a.getSubBankCode()));
            }
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, payRequest.mSpNO));
                if (!TextUtils.isEmpty(payRequest.mOrderNo)) {
                    arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                }
            }
            if ((this.f25499a.getmBindFrom() == 0 || this.f25499a.getmBindFrom() == 2) && payRequest != null) {
                if (!TextUtils.isEmpty(payRequest.mSpNO)) {
                    arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, payRequest.mSpNO));
                }
                if (!TextUtils.isEmpty(payRequest.mOrderNo)) {
                    arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                }
            }
            BindFastRequest bindFastRequest = this.f25499a;
            if (bindFastRequest != null && bindFastRequest.getmBindFrom() == 1 && !TextUtils.isEmpty(this.f25499a.getSp_no())) {
                arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25499a.getSp_no()));
            }
            BindFastRequest bindFastRequest2 = this.f25499a;
            if (bindFastRequest2 != null && !TextUtils.isEmpty(bindFastRequest2.mSecurityParams)) {
                arrayList.add(new RestNameValuePair("security_sdk_param", this.f25499a.mSecurityParams));
            }
            BindFastRequest bindFastRequest3 = this.f25499a;
            if (bindFastRequest3 != null) {
                arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, bindFastRequest3.getSessionId()));
            }
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 513;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "UTF-8";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_BIND_CARD;
    }
}
