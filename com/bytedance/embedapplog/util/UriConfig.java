package com.bytedance.embedapplog.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class UriConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PATH_AB = "/service/2/abtest_config/";
    public static final String PATH_ACTIVE = "/service/2/app_alert_check/";
    public static final String PATH_CONFIG = "/service/2/log_settings/";
    public static final String PATH_REGISTER = "/service/2/device_register_only/";
    public static final String PATH_SEND = "/service/2/app_log/";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f64411a;

    /* renamed from: b  reason: collision with root package name */
    public final String f64412b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f64413c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f64414d;

    /* renamed from: e  reason: collision with root package name */
    public final String f64415e;

    /* renamed from: f  reason: collision with root package name */
    public final String f64416f;

    /* renamed from: g  reason: collision with root package name */
    public final String f64417g;

    /* renamed from: h  reason: collision with root package name */
    public final String f64418h;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f64419a;

        /* renamed from: b  reason: collision with root package name */
        public String f64420b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f64421c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f64422d;

        /* renamed from: e  reason: collision with root package name */
        public String f64423e;

        /* renamed from: f  reason: collision with root package name */
        public String f64424f;

        /* renamed from: g  reason: collision with root package name */
        public String f64425g;

        /* renamed from: h  reason: collision with root package name */
        public String f64426h;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f64419a = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b b(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                this.f64421c = strArr;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public UriConfig c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new UriConfig(this, null) : (UriConfig) invokeV.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f64420b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
                this.f64422d = strArr;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f64423e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f64424f = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f64426h = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public /* synthetic */ UriConfig(b bVar, a aVar) {
        this(bVar);
    }

    public static UriConfig createByDomain(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, strArr)) == null) {
            b bVar = new b();
            bVar.a(str + PATH_REGISTER);
            bVar.e(str + PATH_ACTIVE);
            if (strArr == null || strArr.length == 0) {
                bVar.b(new String[]{str + PATH_SEND});
            } else {
                int length = strArr.length + 1;
                String[] strArr2 = new String[length];
                strArr2[0] = str + PATH_SEND;
                for (int i2 = 1; i2 < length; i2++) {
                    strArr2[i2] = strArr[i2 - 1] + PATH_SEND;
                }
                bVar.b(strArr2);
            }
            bVar.h(str + PATH_CONFIG);
            bVar.j(str + PATH_AB);
            return bVar.c();
        }
        return (UriConfig) invokeLL.objValue;
    }

    public static UriConfig createUriConfig(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? c.b.a.u1.a.a(i2) : (UriConfig) invokeI.objValue;
    }

    public String getAbUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64416f : (String) invokeV.objValue;
    }

    public String getActiveUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64412b : (String) invokeV.objValue;
    }

    public String getMonitorUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64418h : (String) invokeV.objValue;
    }

    public String getProfileUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64417g : (String) invokeV.objValue;
    }

    public String[] getRealUris() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64414d : (String[]) invokeV.objValue;
    }

    public String getRegisterUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64411a : (String) invokeV.objValue;
    }

    public String[] getSendUris() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64413c : (String[]) invokeV.objValue;
    }

    public String getSettingUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64415e : (String) invokeV.objValue;
    }

    public UriConfig(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64411a = bVar.f64419a;
        this.f64412b = bVar.f64420b;
        this.f64413c = bVar.f64421c;
        this.f64414d = bVar.f64422d;
        this.f64415e = bVar.f64423e;
        this.f64416f = bVar.f64424f;
        this.f64417g = bVar.f64425g;
        this.f64418h = bVar.f64426h;
    }
}
