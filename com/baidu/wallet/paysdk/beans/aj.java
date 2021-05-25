package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class aj extends PayBaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25134a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25135b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25136c;

    public <T> aj(Context context) {
        super(context);
        this.f25136c = false;
        this.f25135b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    public void a(boolean z) {
        this.f25136c = z;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(null);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        CardData.BondCard bondCard;
        if (this.f25134a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f25134a.getmPhone())));
            arrayList.add(new RestNameValuePair("vcode", this.f25134a.mSmsVCode));
            if (!this.f25136c) {
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                BindFastRequest bindFastRequest = this.f25134a;
                if (bindFastRequest != null) {
                    arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
                }
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f25134a.getServiceType()));
            }
            arrayList.add(new RestNameValuePair("bind_without_pay", this.f25134a.getWithoutPay()));
            if (!TextUtils.isEmpty(this.f25134a.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("sub_bank_code", this.f25134a.getSubBankCode()));
            }
            PayRequest payRequest = this.f25135b;
            if (payRequest != null) {
                arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25135b.mSpNO));
                arrayList.add(new RestNameValuePair("total_amount", this.f25135b.getOrderPrice()));
            }
            PayRequest payRequest2 = this.f25135b;
            if (payRequest2 != null && (bondCard = payRequest2.mBondCard) != null && !TextUtils.isEmpty(bondCard.account_no)) {
                arrayList.add(new RestNameValuePair("card_no", SafePay.getInstance().encryptProxy(this.f25135b.mBondCard.account_no)));
            }
            arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, this.f25134a.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 11;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(DomainConfig.getInstance().getAppPayHost());
        sb.append(this.f25136c ? BeanConstants.API_SIGN_CONTRACT_VERIFY_SMS : BeanConstants.API_VERIFY_SMS);
        return sb.toString();
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25134a = bindFastRequest;
    }
}
