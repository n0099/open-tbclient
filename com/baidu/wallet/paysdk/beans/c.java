package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.BindCardProtocolPreviewResponse;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends BaseBean<BindCardProtocolPreviewResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f59571a;

    /* renamed from: b  reason: collision with root package name */
    public String f59572b;

    /* renamed from: c  reason: collision with root package name */
    public String f59573c;

    /* renamed from: d  reason: collision with root package name */
    public String f59574d;

    /* renamed from: e  reason: collision with root package name */
    public String f59575e;

    /* renamed from: f  reason: collision with root package name */
    public String f59576f;

    /* renamed from: g  reason: collision with root package name */
    public String f59577g;

    /* renamed from: h  reason: collision with root package name */
    public String f59578h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f59571a = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f59572b = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f59573c = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f59574d = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f59575e = str;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.execBean(BindCardProtocolPreviewResponse.class);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f59576f = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f59577g = str;
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair(BindCardProtocolActivity.PROTOCOL_SNAPSHOT_ID, this.f59571a));
            arrayList.add(new RestNameValuePair("protocolType", this.f59572b));
            arrayList.add(new RestNameValuePair("templateCode", this.f59573c));
            if (!TextUtils.isEmpty(this.f59574d)) {
                arrayList.add(new RestNameValuePair(BindCardProtocolActivity.TRUE_NAME, this.f59574d));
            }
            if (!TextUtils.isEmpty(this.f59576f)) {
                arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f59576f)));
            }
            if (!TextUtils.isEmpty(this.f59575e)) {
                arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.f59575e));
            }
            if (!TextUtils.isEmpty(this.f59577g)) {
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.f59577g)));
            }
            if (!TextUtils.isEmpty(this.f59578h)) {
                arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.f59578h)));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 605;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_BIND_CARD_PROTOCOL;
        }
        return (String) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f59578h = str;
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BaseBean, com.dxmpay.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
