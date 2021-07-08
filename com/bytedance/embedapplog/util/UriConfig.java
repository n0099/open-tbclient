package com.bytedance.embedapplog.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class UriConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PATH_AB = "/service/2/abtest_config/";
    public static final String PATH_ACTIVE = "/service/2/app_alert_check/";
    public static final String PATH_CONFIG = "/service/2/log_settings/";
    public static final String PATH_REGISTER = "/service/2/device_register_only/";
    public static final String PATH_SEND = "/service/2/app_log/";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f27693a;

    /* renamed from: b  reason: collision with root package name */
    public final String f27694b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f27695c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f27696d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27697e;

    /* renamed from: f  reason: collision with root package name */
    public final String f27698f;

    /* renamed from: g  reason: collision with root package name */
    public final String f27699g;

    /* renamed from: h  reason: collision with root package name */
    public final String f27700h;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27701a;

        /* renamed from: b  reason: collision with root package name */
        public String f27702b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f27703c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f27704d;

        /* renamed from: e  reason: collision with root package name */
        public String f27705e;

        /* renamed from: f  reason: collision with root package name */
        public String f27706f;

        /* renamed from: g  reason: collision with root package name */
        public String f27707g;

        /* renamed from: h  reason: collision with root package name */
        public String f27708h;

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
                this.f27701a = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b b(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                this.f27703c = strArr;
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
                this.f27702b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
                this.f27704d = strArr;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f27705e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f27706f = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f27708h = str;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? d.b.a.u1.a.a(i2) : (UriConfig) invokeI.objValue;
    }

    public String getAbUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27698f : (String) invokeV.objValue;
    }

    public String getActiveUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27694b : (String) invokeV.objValue;
    }

    public String getMonitorUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27700h : (String) invokeV.objValue;
    }

    public String getProfileUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27699g : (String) invokeV.objValue;
    }

    public String[] getRealUris() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27696d : (String[]) invokeV.objValue;
    }

    public String getRegisterUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27693a : (String) invokeV.objValue;
    }

    public String[] getSendUris() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27695c : (String[]) invokeV.objValue;
    }

    public String getSettingUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f27697e : (String) invokeV.objValue;
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
        this.f27693a = bVar.f27701a;
        this.f27694b = bVar.f27702b;
        this.f27695c = bVar.f27703c;
        this.f27696d = bVar.f27704d;
        this.f27697e = bVar.f27705e;
        this.f27698f = bVar.f27706f;
        this.f27699g = bVar.f27707g;
        this.f27700h = bVar.f27708h;
    }
}
