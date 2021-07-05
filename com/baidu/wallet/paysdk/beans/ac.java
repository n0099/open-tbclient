package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ac extends PayBaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25846a;

    /* renamed from: b  reason: collision with root package name */
    public String f25847b;

    /* renamed from: c  reason: collision with root package name */
    public String f25848c;

    /* renamed from: d  reason: collision with root package name */
    public String f25849d;

    /* renamed from: e  reason: collision with root package name */
    public String f25850e;

    /* renamed from: f  reason: collision with root package name */
    public String f25851f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(Context context) {
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

    public void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            this.f25846a = str;
            this.f25847b = str2;
            this.f25848c = str3;
            this.f25849d = str4;
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.execBean(String.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("mobile_pwd", this.f25846a));
            arrayList.add(new RestNameValuePair("seed", this.f25847b));
            arrayList.add(new RestNameValuePair("new_passfree_status", this.f25848c));
            arrayList.add(new RestNameValuePair("new_passfree_credit", this.f25849d));
            if (!TextUtils.isEmpty(this.f25850e)) {
                arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f25850e)));
            }
            if (!TextUtils.isEmpty(this.f25851f)) {
                arrayList.add(new RestNameValuePair("sms_vcode", this.f25851f));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE : invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SAVE_PAYFREE;
        }
        return (String) invokeV.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.f25850e = str;
            this.f25851f = str2;
        }
    }
}
