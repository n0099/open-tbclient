package com.baidu.wallet.home;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.baidu.wallet.home.beans.HomeCfgBean;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24865a;

    /* renamed from: com.baidu.wallet.home.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0265a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f24868a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-531392827, "Lcom/baidu/wallet/home/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-531392827, "Lcom/baidu/wallet/home/a$a;");
                    return;
                }
            }
            f24868a = new a();
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24865a = "";
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0265a.f24868a : (a) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.f24865a = str;
        }
    }

    public void a(Context context, String str, String str2, String str3, boolean z, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z), str4}) == null) {
            if (HomeCfgBean.PAGE_FINANCE.equals(str4)) {
                str5 = "clickTabHomePageItem";
            } else {
                str5 = HomeCfgBean.PAGE_CREDIT.equals(str4) ? "clickCreditHomePageItem" : "clickHomePageItem";
            }
            SDKJumpManager.getInstance().doSDKJump(context, str, str2, str3, z, new SDKJumpManager.OnJumpListener(this, str5) { // from class: com.baidu.wallet.home.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f24866a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f24867b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str5};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24867b = this;
                    this.f24866a = str5;
                }

                @Override // com.baidu.wallet.base.widget.SDKJumpManager.OnJumpListener
                public void beforeJump(Context context2, String str6, String str7, String str8, boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{context2, str6, str7, str8, Boolean.valueOf(z2)}) == null) {
                        DXMSdkSAUtils.onEventWithValues(this.f24866a, Arrays.asList(str6, str7, str8, this.f24867b.f24865a));
                        PayStatisticsUtil.onEventWithValues(this.f24866a, Arrays.asList(str6, str7, str8, this.f24867b.f24865a));
                    }
                }
            });
        }
    }
}
