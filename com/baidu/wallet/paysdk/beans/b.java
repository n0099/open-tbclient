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
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class b extends BaseBean<BindCardResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BindFastRequest a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f51915b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> b(Context context) {
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
        this.a = null;
        this.f51915b = null;
        this.a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.f51915b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bindFastRequest) == null) {
            this.a = bindFastRequest;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.execBean(BindCardResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.a.getmBankCard())));
                arrayList.add(new RestNameValuePair("request_type", this.a.getCardRequestType()));
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.a.getServiceType()));
                if (!TextUtils.isEmpty(this.a.getmName())) {
                    arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, this.a.getmName()));
                }
                if (!TextUtils.isEmpty(this.a.getCertificateType())) {
                    arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.a.getCertificateType()));
                }
                if (!TextUtils.isEmpty(this.a.getmIdCard())) {
                    arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.a.getmIdCard())));
                }
                if (!TextUtils.isEmpty(this.a.getmPhone())) {
                    arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.a.getmPhone())));
                }
                arrayList.add(new RestNameValuePair("vcode", this.a.getmSmsVCode()));
                PwdRequest pwdRequest = this.f51915b;
                if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass) && !TextUtils.isEmpty(this.f51915b.mConfirmPayPass)) {
                    String handlePwdSimple = PasswordController.handlePwdSimple(this.f51915b.mPayPass);
                    String seed = PasswordController.getSeed();
                    String handlePwd = PasswordController.handlePwd(this.f51915b.mConfirmPayPass, seed);
                    arrayList.add(new RestNameValuePair("mobile_pass", SecurePay.getInstance().encryptProxy(handlePwdSimple)));
                    arrayList.add(new RestNameValuePair("mobile_pass_confirm", handlePwd));
                    arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f51915b.mConfirmPayPass)));
                    arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
                }
                if (!TextUtils.isEmpty(this.a.getmValidDate())) {
                    arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.a.getmValidDate())));
                }
                if (!TextUtils.isEmpty(this.a.getmCvv())) {
                    arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.a.getmCvv())));
                }
                if (!TextUtils.isEmpty(this.a.getChannelNo())) {
                    arrayList.add(new RestNameValuePair("channel_no", this.a.getChannelNo()));
                }
                if (!TextUtils.isEmpty(this.a.getSubBankCode())) {
                    arrayList.add(new RestNameValuePair("sub_bank_code", this.a.getSubBankCode()));
                }
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                    arrayList.add(new RestNameValuePair("sp_no", payRequest.mSpNO));
                    if (!TextUtils.isEmpty(payRequest.mOrderNo)) {
                        arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                    }
                }
                if ((this.a.getmBindFrom() == 0 || this.a.getmBindFrom() == 2) && payRequest != null) {
                    if (!TextUtils.isEmpty(payRequest.mSpNO)) {
                        arrayList.add(new RestNameValuePair("sp_no", payRequest.mSpNO));
                    }
                    if (!TextUtils.isEmpty(payRequest.mOrderNo)) {
                        arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                    }
                }
                BindFastRequest bindFastRequest = this.a;
                if (bindFastRequest != null && bindFastRequest.getmBindFrom() == 1 && !TextUtils.isEmpty(this.a.getSp_no())) {
                    arrayList.add(new RestNameValuePair("sp_no", this.a.getSp_no()));
                }
                BindFastRequest bindFastRequest2 = this.a;
                if (bindFastRequest2 != null && !TextUtils.isEmpty(bindFastRequest2.mSecurityParams)) {
                    arrayList.add(new RestNameValuePair("security_sdk_param", this.a.mSecurityParams));
                }
                BindFastRequest bindFastRequest3 = this.a;
                if (bindFastRequest3 != null) {
                    arrayList.add(new RestNameValuePair("session_id", bindFastRequest3.getSessionId()));
                }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 513;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_BIND_CARD;
        }
        return (String) invokeV.objValue;
    }
}
