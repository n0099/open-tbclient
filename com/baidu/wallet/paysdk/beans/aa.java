package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.SignChannelResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class aa extends BaseBean<SignChannelResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> aa(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(SignChannelResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("query_name", "query_bank_list"));
            if (com.baidu.wallet.paysdk.a.b.a()) {
                arrayList.add(new RestNameValuePair("source_flag", "8"));
            } else {
                arrayList.add(new RestNameValuePair("source_flag", "3"));
            }
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache((PayRequestCache.getInstance().isPaying() ? PayRequestCache.BindCategory.Other : PayRequestCache.BindCategory.Initiative).name());
            if (bindFastRequest != null) {
                arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, bindFastRequest.getServiceType()));
            }
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                String str = payRequest.mSpNO;
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new RestNameValuePair("sp_no", str));
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
                arrayList.add(new RestNameValuePair("sp_no", bindFastRequest.getSp_no()));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 517;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SIGN_CHANNEL_QUERY;
        }
        return (String) invokeV.objValue;
    }
}
