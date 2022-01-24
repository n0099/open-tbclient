package com.baidu.wallet.home.beans;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.home.WalletHomeBeanConstants;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class HomeCfgBean extends BaseBean<HomeCfgResponse> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String PAGE_CREDIT = "3";
    public static String PAGE_FINANCE = "1";
    public static String PAGE_HOME = "2";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f51141b;

    /* renamed from: c  reason: collision with root package name */
    public String f51142c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51143d;

    /* renamed from: e  reason: collision with root package name */
    public String f51144e;

    /* renamed from: f  reason: collision with root package name */
    public String f51145f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1561659366, "Lcom/baidu/wallet/home/beans/HomeCfgBean;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1561659366, "Lcom/baidu/wallet/home/beans/HomeCfgBean;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> HomeCfgBean(Context context) {
        super(DxmApplicationContextImpl.getApplicationContext(context));
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
        this.a = "";
        this.f51141b = "";
        this.f51142c = "";
        this.f51143d = false;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(HomeCfgResponse.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("cate[layout_content]", this.a));
            arrayList.add(new RestNameValuePair("cate[layout_title]", this.f51141b));
            arrayList.add(new RestNameValuePair("cate[layout_footer]", this.f51142c));
            arrayList.add(new RestNameValuePair("page", this.f51145f));
            arrayList.add(new RestNameValuePair("changedSign", this.f51144e));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? WalletHomeBeanFactory.BEAN_ID_HOME_CFG : invokeV.intValue;
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
            StringBuilder sb = new StringBuilder();
            sb.append(DomainConfig.getInstance().getAppHost(this.tag));
            sb.append(this.f51143d ? WalletHomeBeanConstants.API_HOME_CFG_ABTYPE : WalletHomeBeanConstants.API_HOME_CFG_NEW);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void setAbtypeHomePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f51143d = z;
        }
    }

    public void setAllFingerPrint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a = str;
        }
    }

    public void setChangeSign(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f51144e = str;
        }
    }

    public void setFooterFingerPrint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f51142c = str;
        }
    }

    public void setPageId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f51145f = str;
        }
    }

    public void setTitleFingerPrint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f51141b = str;
        }
    }
}
