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
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ad extends BaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BindFastRequest a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f52125b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52126c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> ad(Context context) {
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
        this.f52126c = false;
        this.f52125b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f52126c = z;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.execBean(null);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.a.getmPhone())));
                arrayList.add(new RestNameValuePair("vcode", this.a.mSmsVCode));
                if (!this.f52126c) {
                    arrayList.add(new RestNameValuePair("source_flag", "3"));
                    BindFastRequest bindFastRequest = this.a;
                    if (bindFastRequest != null) {
                        arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
                    }
                    arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.a.getServiceType()));
                }
                arrayList.add(new RestNameValuePair("bind_without_pay", this.a.getWithoutPay()));
                if (!TextUtils.isEmpty(this.a.getSubBankCode())) {
                    arrayList.add(new RestNameValuePair("sub_bank_code", this.a.getSubBankCode()));
                }
                PayRequest payRequest = this.f52125b;
                if (payRequest != null) {
                    arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                    arrayList.add(new RestNameValuePair("sp_no", this.f52125b.mSpNO));
                    arrayList.add(new RestNameValuePair("total_amount", this.f52125b.getOrderPrice()));
                }
                PayRequest payRequest2 = this.f52125b;
                if (payRequest2 != null && (bondCard = payRequest2.mBondCard) != null && !TextUtils.isEmpty(bondCard.account_no)) {
                    arrayList.add(new RestNameValuePair("card_no", SecurePay.getInstance().encryptProxy(this.f52125b.mBondCard.account_no)));
                }
                arrayList.add(new RestNameValuePair("session_id", this.a.getSessionId()));
                return arrayList;
            }
            throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 11;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(DomainConfig.getInstance().getAppPayHost());
            sb.append(this.f52126c ? BeanConstants.API_SIGN_CONTRACT_VERIFY_SMS : BeanConstants.API_VERIFY_SMS);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bindFastRequest) == null) {
            this.a = bindFastRequest;
        }
    }
}
