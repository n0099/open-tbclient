package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class p extends BaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f25889a;

    /* renamed from: b  reason: collision with root package name */
    public PwdRequest f25890b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> p(Context context) {
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
        this.f25889a = null;
        this.f25890b = null;
        this.f25890b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bindFastRequest) == null) {
            this.f25889a = bindFastRequest;
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.execBean(null);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f25889a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("request_type", this.f25889a.getCardRequestType()));
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f25889a.getServiceType()));
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f25889a.getmBankCard())));
                if (!TextUtils.isEmpty(this.f25889a.getmName())) {
                    arrayList.add(new RestNameValuePair("true_name", this.f25889a.getmName()));
                }
                if (!TextUtils.isEmpty(this.f25889a.getCertificateType())) {
                    arrayList.add(new RestNameValuePair("identity_type", this.f25889a.getCertificateType()));
                }
                if (!TextUtils.isEmpty(this.f25889a.getmIdCard())) {
                    arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f25889a.getmIdCard())));
                }
                if (!TextUtils.isEmpty(this.f25889a.getmPhone())) {
                    arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.f25889a.getmPhone())));
                }
                arrayList.add(new RestNameValuePair("vcode", this.f25889a.mSmsVCode));
                String handlePwdSimple = PasswordController.handlePwdSimple(this.f25890b.mPayPass);
                String seed = PasswordController.getSeed();
                String handlePwd = PasswordController.handlePwd(this.f25890b.mConfirmPayPass, seed);
                arrayList.add(new RestNameValuePair("mobile_pass", SafePay.getInstance().encryptProxy(handlePwdSimple)));
                arrayList.add(new RestNameValuePair("mobile_pass_confirm", handlePwd));
                arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f25890b.mConfirmPayPass)));
                arrayList.add(new RestNameValuePair("seed", SafePay.getInstance().encryptProxy(seed)));
                arrayList.add(new RestNameValuePair("key", SafePay.getInstance().getpwProxy()));
                if (!TextUtils.isEmpty(this.f25889a.getmValidDate())) {
                    arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.f25889a.getmValidDate())));
                }
                if (!TextUtils.isEmpty(this.f25889a.getmCvv())) {
                    arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.f25889a.getmCvv())));
                }
                if (!TextUtils.isEmpty(this.f25889a.getChannelNo())) {
                    arrayList.add(new RestNameValuePair("channel_no", this.f25889a.getChannelNo()));
                }
                if (!TextUtils.isEmpty(this.f25889a.getSubBankCode())) {
                    arrayList.add(new RestNameValuePair("sub_bank_code", this.f25889a.getSubBankCode()));
                }
                CardData.BondCard bondCard = this.f25889a.mBondCard;
                if (bondCard != null) {
                    arrayList.add(new RestNameValuePair("card_no_bind", bondCard.account_no));
                }
                arrayList.add(new RestNameValuePair("session_id", this.f25889a.getSessionId()));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 260;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_FIND_PASSWD;
        }
        return (String) invokeV.objValue;
    }
}
