package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public class vq5 extends ff1<ej0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ej0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq5 c;

        /* renamed from: com.baidu.tieba.vq5$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0449a implements gj0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a f;

            public C0449a(a aVar) {
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

            @Override // com.baidu.tieba.gj0
            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? wq5.h().a() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? wq5.h().l() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.c.c() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? wq5.h().j() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? wq5.h().g() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? wq5.h().i() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String g() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? wq5.h().d() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String h() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? wq5.h().o() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String k() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? wq5.h().f() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String m() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? wq5.h().b() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String n() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String o() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? wq5.h().n() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String p() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "tieba" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String packageName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? wq5.h().m() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String q() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "2" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String r() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? wq5.h().p() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            @NonNull
            public String t() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? wq5.h().e() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String u() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? wq5.h().c() : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public String x() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "Tieba" : (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.gj0
            public boolean y() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        public a(vq5 vq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vq5Var;
        }

        @Override // com.baidu.tieba.ej0
        @NonNull
        public gj0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0449a(this) : (gj0) invokeV.objValue;
        }
    }

    public vq5() {
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
    @Override // com.baidu.tieba.ff1
    /* renamed from: b */
    public ej0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (ej0) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        byte[] b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = "";
            String q = ox4.k().q("key_last_cached_real_oid", "");
            if (StringUtils.isNull(q)) {
                String k = wq5.h().k();
                if (StringUtils.isNull(k)) {
                    return "";
                }
                String[] split = k.split("-");
                if (split != null && split.length > 1) {
                    String str2 = split[1];
                    if (StringUtils.isNull(str2) || (b = new e50("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(str2)) == null) {
                        return "";
                    }
                    try {
                        str = new String(b, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (!StringUtils.isNull(str)) {
                        ox4.k().y("key_last_cached_real_oid", str);
                    }
                }
                return str;
            }
            return q;
        }
        return (String) invokeV.objValue;
    }
}
