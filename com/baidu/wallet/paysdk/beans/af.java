package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.SignChannelResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class af extends PayBaseBean<SignChannelResponse> {
    public <T> af(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(SignChannelResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("query_name", "query_bank_list"));
        if (com.baidu.wallet.paysdk.a.b.a()) {
            arrayList.add(new RestNameValuePair("source_flag", "8"));
        } else {
            arrayList.add(new RestNameValuePair("source_flag", "3"));
        }
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        if (bindFastRequest != null) {
            arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, bindFastRequest.getServiceType()));
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            String str = payRequest.mSpNO;
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, str));
            }
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        String sellerUserId = PayDataCache.getInstance().getSellerUserId();
        if (!TextUtils.isEmpty(sellerUserId)) {
            arrayList.add(new RestNameValuePair("seller_user_id", sellerUserId));
        }
        if (payResponse != null && (directPayPay = payResponse.pay) != null && (easyPay = directPayPay.easypay) != null) {
            String buyerUserId = easyPay.getBuyerUserId();
            if (!TextUtils.isEmpty(buyerUserId)) {
                arrayList.add(new RestNameValuePair("buyer_user_id", buyerUserId));
            }
            String amount = payResponse.pay.easypay.getAmount();
            if (!TextUtils.isEmpty(amount)) {
                arrayList.add(new RestNameValuePair("total_amount", amount));
            }
            if (com.baidu.wallet.paysdk.a.b.a()) {
                arrayList.add(new RestNameValuePair("trans_need_to_pay", String.valueOf(!com.baidu.wallet.paysdk.a.b.b())));
            } else {
                String insideTransOrder = PayDataCache.getInstance().getInsideTransOrder();
                if (!TextUtils.isEmpty(insideTransOrder)) {
                    arrayList.add(new RestNameValuePair("trans_need_to_pay", insideTransOrder));
                }
            }
            String service = payResponse.pay.easypay.getService();
            if (!TextUtils.isEmpty(service)) {
                arrayList.add(new RestNameValuePair("service", service));
            }
        }
        if (bindFastRequest != null && bindFastRequest.getmBindFrom() == 1 && !TextUtils.isEmpty(bindFastRequest.getSp_no())) {
            arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, bindFastRequest.getSp_no()));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 517;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CHANNEL_QUERY;
    }
}
