package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayErrorContent;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class v extends PayBaseBean<DirectPayContentResponse> {

    /* renamed from: a  reason: collision with root package name */
    public PayRequest f25999a;

    /* renamed from: b  reason: collision with root package name */
    public String f26000b;

    /* renamed from: c  reason: collision with root package name */
    public String f26001c;

    public <T> v(Context context) {
        super(context);
        this.f25999a = null;
        this.f26000b = null;
        this.f26001c = null;
        this.f25999a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    public void a(String str) {
        this.f26000b = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        if (BeanConstants.API_GET_PAY_ORDER.equals(this.f26001c)) {
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo());
            HashMap hashMap = new HashMap();
            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
            StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_ORDER_COLLATION, collectData, hashMap);
        }
        super.execBean(DirectPayContentResponse.class, DirectPayErrorContent.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "gbk";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        String str;
        this.f26001c = BeanConstants.API_GET_PAY_ORDER;
        if (this.f25999a.hasCashDeskCode()) {
            this.f26001c = BeanConstants.API_GET_PAY_ORDER_PREPAY;
        } else if (BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(this.f25999a.getPayFrom())) {
            this.f26001c = BeanConstants.API_GET_PAY_ORDER_TRANSFER;
        } else if (BaiduPay.PAY_FROM_HUA_FEI.equals(this.f25999a.getPayFrom())) {
            this.f26001c = BeanConstants.API_GET_PAY_ORDER_CHARGE;
        } else if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.f25999a.getPayFrom())) {
            this.f26001c = BeanConstants.API_CARD_ADD;
        } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f25999a.getPayFrom())) {
            this.f26001c = BeanConstants.API_AUTHORIZE_ORDER;
        } else if (PayDataCache.getInstance().isFromPreCashier()) {
            this.f26001c = BeanConstants.API_GET_PRE_PAY_ORDER;
        }
        if (PayDataCache.getInstance().isFromPreCashier()) {
            str = DomainConfig.getInstance().getAppPayHost() + this.f26001c + "?" + this.f25999a.mParams + "&" + this.f26000b;
        } else {
            str = DomainConfig.getInstance().getAppPayHost() + this.f26001c + "?" + this.f25999a.mParams;
        }
        if (WalletFingerprint.getInstance(this.mContext).hasEnrollFingerprint()) {
            str = str + "&enroll_fingerprint=1";
        }
        if (TextUtils.isEmpty(this.f25999a.mSecurityParams)) {
            return str;
        }
        return str + "&security_sdk_param=" + this.f25999a.mSecurityParams;
    }
}
