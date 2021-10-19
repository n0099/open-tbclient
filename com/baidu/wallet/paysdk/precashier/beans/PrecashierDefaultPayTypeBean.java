package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.OtherBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PrecashierDefaultPayTypeBean extends OtherBean<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62972a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrecashierDefaultPayTypeBean(Context context) {
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

    private List<RestNameValuePair> a(List<RestNameValuePair> list, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONArray names;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, list, jSONObject)) == null) {
            if (jSONObject != null && (names = jSONObject.names()) != null && names.length() > 0) {
                for (int i2 = 0; i2 < names.length(); i2++) {
                    try {
                        Object obj2 = names.get(i2);
                        if (obj2 != null && (obj2 instanceof String)) {
                            String str = (String) obj2;
                            if (!TextUtils.isEmpty(str) && (obj = jSONObject.get(str)) != null) {
                                if (obj instanceof JSONObject) {
                                    a(list, (JSONObject) obj);
                                } else {
                                    list.add(new RestNameValuePair(str, obj.toString()));
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(String.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f62972a == null) {
                return arrayList;
            }
            try {
                a(arrayList, new JSONObject(this.f62972a));
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_PRECASHIER_DEFAULT_PAY_TYPE;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setParams(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f62972a = str;
    }
}
