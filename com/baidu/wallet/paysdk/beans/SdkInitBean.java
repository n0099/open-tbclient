package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SdkInitBean extends BaseBean<SdkInitResponse> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BACHUP_INIT_YTPE = 3;
    public static final int NEW_INIT_TYPE = 2;
    public static final int OLD_INIT_TYPE = 1;

    /* renamed from: b  reason: collision with root package name */
    public static String f59556b = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f59557a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1589433534, "Lcom/baidu/wallet/paysdk/beans/SdkInitBean;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1589433534, "Lcom/baidu/wallet/paysdk/beans/SdkInitBean;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> SdkInitBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59557a = -1;
    }

    public static void setContentSignForReq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f59556b = str;
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean checkSignSame(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? !TextUtils.isEmpty(f59556b) && f59556b.equals(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.execBean(SdkInitResponse.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("contentSign", f59556b));
            LogUtil.i("SdkInitBean", "contentSign" + f59556b);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.f59557a;
            if (i2 != 2) {
                return i2 != 3 ? 530 : 1042;
            }
            return 786;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        String initHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LogUtil.i("SdkInitBean", "tag is: " + this.tag[0]);
            int i2 = this.f59557a;
            if (i2 == 1) {
                initHost = DomainConfig.getInstance().getInitHost(1, this.tag);
            } else if (i2 == 2) {
                initHost = DomainConfig.getInstance().getInitHost(2, this.tag);
            } else if (i2 != 3) {
                initHost = DomainConfig.getInstance().getInitHost(1, this.tag);
            } else {
                initHost = DomainConfig.getInstance().getInitHost(3, this.tag);
            }
            LogUtil.i("SdkInitBean", "tag1 is: " + this.tag[0]);
            return initHost + "/odp/wireless/sdk/init";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean needVerifySignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f59557a = i2;
        }
    }
}
