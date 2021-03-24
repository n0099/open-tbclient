package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class s extends t {
    public <T> s(Context context) {
        super(context);
    }

    private boolean a(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (easyPay = directPayPay.easypay) == null || TextUtils.isEmpty(easyPay.getService())) ? false : true;
    }

    @Override // com.baidu.wallet.paysdk.beans.t, com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("request_type", Constants.VIA_REPORT_TYPE_WPA_STATE));
        if (com.baidu.wallet.paysdk.a.b.a()) {
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (a(payResponse)) {
                arrayList.add(new RestNameValuePair("service", payResponse.pay.easypay.getService()));
            } else {
                if (com.baidu.wallet.paysdk.a.b.c()) {
                    arrayList.add(new RestNameValuePair("service", LBSPayAli.ALI_AUTH_PAY));
                }
                if (com.baidu.wallet.paysdk.a.b.b()) {
                    arrayList.add(new RestNameValuePair("service", "authorize_pure"));
                }
            }
        }
        CardData.BondCard bondCard = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).mBondCard;
        if (bondCard != null) {
            arrayList.add(new RestNameValuePair("card_no_bind", bondCard.account_no));
            arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        }
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.beans.t, com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 15;
    }
}
