package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class aj extends PayBaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f26130a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f26131b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26132c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> aj(Context context) {
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
        this.f26132c = false;
        this.f26131b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f26132c = z;
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.execBean(null);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f26130a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f26130a.getmPhone())));
                arrayList.add(new RestNameValuePair("vcode", this.f26130a.mSmsVCode));
                if (!this.f26132c) {
                    arrayList.add(new RestNameValuePair("source_flag", "3"));
                    BindFastRequest bindFastRequest = this.f26130a;
                    if (bindFastRequest != null) {
                        arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
                    }
                    arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f26130a.getServiceType()));
                }
                arrayList.add(new RestNameValuePair("bind_without_pay", this.f26130a.getWithoutPay()));
                if (!TextUtils.isEmpty(this.f26130a.getSubBankCode())) {
                    arrayList.add(new RestNameValuePair("sub_bank_code", this.f26130a.getSubBankCode()));
                }
                PayRequest payRequest = this.f26131b;
                if (payRequest != null) {
                    arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                    arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f26131b.mSpNO));
                    arrayList.add(new RestNameValuePair("total_amount", this.f26131b.getOrderPrice()));
                }
                PayRequest payRequest2 = this.f26131b;
                if (payRequest2 != null && (bondCard = payRequest2.mBondCard) != null && !TextUtils.isEmpty(bondCard.account_no)) {
                    arrayList.add(new RestNameValuePair("card_no", SafePay.getInstance().encryptProxy(this.f26131b.mBondCard.account_no)));
                }
                arrayList.add(new RestNameValuePair("session_id", this.f26130a.getSessionId()));
                return arrayList;
            }
            throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 11;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(DomainConfig.getInstance().getAppPayHost());
            sb.append(this.f26132c ? BeanConstants.API_SIGN_CONTRACT_VERIFY_SMS : BeanConstants.API_VERIFY_SMS);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bindFastRequest) == null) {
            this.f26130a = bindFastRequest;
        }
    }
}
