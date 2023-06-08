package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes8.dex */
public class v76 extends sl1<pk0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements pk0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v76 c;

        /* renamed from: com.baidu.tieba.v76$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0487a implements rk0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a f;

            @Override // com.baidu.tieba.rk0
            public boolean A() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.rk0
            public String p() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String r() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "tieba" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String s() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "2" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String z() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "Tieba" : (String) invokeV.objValue;
            }

            public C0487a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
            }

            @Override // com.baidu.tieba.rk0
            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return w76.h().a();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return w76.h().l();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return this.f.c.c();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return w76.h().j();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return w76.h().g();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return w76.h().i();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return w76.h().d();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return w76.h().q();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String i() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return w76.h().o();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String l() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return w76.h().f();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public boolean n() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    return PermissionUtil.isAgreePrivacyPolicy();
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.rk0
            public String o() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    return w76.h().b();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String packageName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    return w76.h().m();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String q() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    return w76.h().n();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String t() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    return w76.h().p();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            @NonNull
            public String v() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    return w76.h().e();
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.rk0
            public String w() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    return w76.h().c();
                }
                return (String) invokeV.objValue;
            }
        }

        public a(v76 v76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v76Var;
        }

        @Override // com.baidu.tieba.pk0
        @NonNull
        public rk0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new C0487a(this);
            }
            return (rk0) invokeV.objValue;
        }
    }

    public v76() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sl1
    /* renamed from: b */
    public pk0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (pk0) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        byte[] b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = "";
            String s = n95.m().s("key_last_cached_real_oid", "");
            if (!StringUtils.isNull(s)) {
                return s;
            }
            String k = w76.h().k();
            if (StringUtils.isNull(k)) {
                return "";
            }
            String[] split = k.split("-");
            if (split != null && split.length > 1) {
                String str2 = split[1];
                if (StringUtils.isNull(str2) || (b = new u50("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(str2)) == null) {
                    return "";
                }
                try {
                    str = new String(b, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isNull(str)) {
                    n95.m().B("key_last_cached_real_oid", str);
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
