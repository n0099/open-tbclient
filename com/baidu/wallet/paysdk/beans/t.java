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
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t extends BaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PwdRequest f62433a;

    /* renamed from: b  reason: collision with root package name */
    public String f62434b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62435c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> t(Context context) {
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
        this.f62433a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
    }

    private void a(List<RestNameValuePair> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, list) == null) && this.f62435c && !TextUtils.isEmpty(this.f62434b)) {
            try {
                JSONObject jSONObject = new JSONObject(this.f62434b);
                jSONObject.remove("half_screen_pwd_verify");
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        list.add(new RestNameValuePair(next, opt != null ? String.valueOf(opt) : ""));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.execBean(String.class, ErrorContentResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String seed = PasswordController.getSeed();
            String encryptProxy = SecurePay.getInstance().encryptProxy(seed);
            int i2 = this.f62433a.mRequestType;
            if (i2 != 2 && i2 != 1) {
                String encryptProxy2 = SecurePay.getInstance().encryptProxy(PasswordController.handlePwdSimple(this.f62433a.mConfirmPayPass));
                String handlePwd = PasswordController.handlePwd(this.f62433a.mConfirmPayPass, seed);
                String str = SecurePay.getInstance().getpwProxy();
                arrayList.add(new RestNameValuePair("new_mobile_pwd", encryptProxy2));
                arrayList.add(new RestNameValuePair("confirm_new_mobile_pwd", handlePwd));
                arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.f62433a.mConfirmPayPass)));
                arrayList.add(new RestNameValuePair("key_no", str));
                arrayList.add(new RestNameValuePair("sess_key", this.f62433a.mSessionKey));
            } else {
                if (!TextUtils.isEmpty(this.f62433a.mPayPass)) {
                    String handlePwd2 = PasswordController.handlePwd(this.f62433a.mPayPass, seed);
                    String str2 = SecurePay.getInstance().getpwProxy();
                    arrayList.add(new RestNameValuePair("mobile_pwd", handlePwd2));
                    arrayList.add(new RestNameValuePair("key", str2));
                }
                a(arrayList);
            }
            arrayList.add(new RestNameValuePair("seed", encryptProxy));
            PwdRequest pwdRequest = this.f62433a;
            if (pwdRequest.mRequestType == 2 && TextUtils.equals(pwdRequest.fromType, BeanConstants.FROM_BIND)) {
                BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
                arrayList.add(new RestNameValuePair("scenario", "bindcard"));
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                if (bindFastRequest != null) {
                    arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
                } else {
                    arrayList.add(new RestNameValuePair("request_type", BindFastRequest.getCardRequestType(1)));
                }
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f62433a.serviceType));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f62433a.mRequestType;
            if (i2 == 2) {
                return 257;
            }
            return i2 == 3 ? 259 : 258;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f62433a.mRequestType;
            if (i2 == 2) {
                String str = PayRequestCache.getInstance().isPaying() ? BeanConstants.API_VERIFY_PAY_PWD : BeanConstants.API_VERIFY_MOBILE_PWD_NEW;
                return DomainConfig.getInstance().getAppPayHost() + str;
            } else if (i2 == 1) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CHECK_MOBILE_PWD;
            } else if (i2 == 3) {
                return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_MODIFY_MOBILE_PWD;
            } else {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f62434b = str;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f62435c = z;
        }
    }
}
