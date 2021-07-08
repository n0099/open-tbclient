package com.baidu.wallet.personal.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseBean<CouponListResponse> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f27069a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f27070b;

    /* renamed from: c  reason: collision with root package name */
    public String f27071c;

    /* renamed from: d  reason: collision with root package name */
    public String f27072d;

    /* renamed from: e  reason: collision with root package name */
    public String f27073e;

    /* renamed from: f  reason: collision with root package name */
    public String f27074f;

    /* renamed from: g  reason: collision with root package name */
    public String f27075g;

    /* renamed from: h  reason: collision with root package name */
    public String f27076h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(974612106, "Lcom/baidu/wallet/personal/beans/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(974612106, "Lcom/baidu/wallet/personal/beans/d;");
                return;
            }
        }
        f27069a = !d.class.desiredAssertionStatus();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
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
        this.f27070b = "";
        this.f27071c = "0";
        this.f27076h = "1";
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f27070b = str;
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            this.f27072d = str;
            this.f27073e = str2;
            this.f27074f = str3;
            this.f27075g = str4;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f27071c = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f27076h = str;
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.execBean(CouponListResponse.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f27070b)) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                arrayList.add(new RestNameValuePair("page_index", this.f27070b));
                arrayList.add(new RestNameValuePair("filter_status", this.f27076h));
                if (TextUtils.isEmpty(this.f27071c)) {
                    this.f27071c = "0";
                }
                arrayList.add(new RestNameValuePair("is_from_new_promot", this.f27071c));
            }
            if (!TextUtils.isEmpty(this.f27072d) && !TextUtils.isEmpty(this.f27073e) && !TextUtils.isEmpty(this.f27074f) && !TextUtils.isEmpty(this.f27075g)) {
                if (!f27069a && arrayList == null) {
                    throw new AssertionError();
                }
                arrayList.add(new RestNameValuePair("activity_id", this.f27072d));
                arrayList.add(new RestNameValuePair(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE, this.f27073e));
                arrayList.add(new RestNameValuePair("coupon_num", this.f27074f));
                arrayList.add(new RestNameValuePair("coupon_expire_time", this.f27075g));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 515;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return DomainConfig.getInstance().getMyHost() + "/yqcard/card/getcouponlistv2";
        }
        return (String) invokeV.objValue;
    }
}
