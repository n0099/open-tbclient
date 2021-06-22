package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
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
public class p extends BaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25346a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f25347b;

    public <T> p(Context context) {
        super(context);
        this.f25346a = null;
        this.f25347b = null;
        this.f25347b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25346a = bindFastRequest;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(null);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        if (this.f25346a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("request_type", this.f25346a.getCardRequestType()));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f25346a.getServiceType()));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25346a.getmBankCard())));
            if (!TextUtils.isEmpty(this.f25346a.getmName())) {
                arrayList.add(new RestNameValuePair("true_name", this.f25346a.getmName()));
            }
            if (!TextUtils.isEmpty(this.f25346a.getCertificateType())) {
                arrayList.add(new RestNameValuePair("identity_type", this.f25346a.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.f25346a.getmIdCard())) {
                arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f25346a.getmIdCard())));
            }
            if (!TextUtils.isEmpty(this.f25346a.getmPhone())) {
                arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f25346a.getmPhone())));
            }
            arrayList.add(new RestNameValuePair("vcode", this.f25346a.mSmsVCode));
            String handlePwdSimple = PasswordController.handlePwdSimple(this.f25347b.mPayPass);
            String seed = PasswordController.getSeed();
            String handlePwd = PasswordController.handlePwd(this.f25347b.mConfirmPayPass, seed);
            arrayList.add(new RestNameValuePair("mobile_pass", SafePay.getInstance().encryptProxy(handlePwdSimple)));
            arrayList.add(new RestNameValuePair("mobile_pass_confirm", handlePwd));
            arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f25347b.mConfirmPayPass)));
            arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
            arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
            if (!TextUtils.isEmpty(this.f25346a.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f25346a.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.f25346a.getmCvv())) {
                arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f25346a.getmCvv())));
            }
            if (!TextUtils.isEmpty(this.f25346a.getChannelNo())) {
                arrayList.add(new RestNameValuePair("channel_no", this.f25346a.getChannelNo()));
            }
            if (!TextUtils.isEmpty(this.f25346a.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("sub_bank_code", this.f25346a.getSubBankCode()));
            }
            CardData.BondCard bondCard = this.f25346a.mBondCard;
            if (bondCard != null) {
                arrayList.add(new RestNameValuePair("card_no_bind", bondCard.account_no));
            }
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, this.f25346a.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 260;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "UTF-8";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_FIND_PASSWD;
    }
}
