package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ae extends PayBaseBean<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25855a;

    /* renamed from: b  reason: collision with root package name */
    public String f25856b;

    /* renamed from: c  reason: collision with root package name */
    public String f25857c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> ae(Context context) {
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

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(String.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("new_passfree_status", this.f25856b));
            arrayList.add(new RestNameValuePair("new_passfree_credit", this.f25857c));
            if (!TextUtils.isEmpty(this.f25855a)) {
                String seed = PasswordController.getSeed();
                arrayList.add(new RestNameValuePair("mobile_pwd", PasswordController.handlePwd(this.f25855a, seed)));
                arrayList.add(new RestNameValuePair("pwd_seed", SafePay.getInstance().encryptProxy(seed)));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PayBeanFactory.BEAN_ID_SET_PASSFREE : invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SET_PASS_FREE;
        }
        return (String) invokeV.objValue;
    }
}
