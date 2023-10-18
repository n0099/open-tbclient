package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public final class uq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static final Map<String, uq2> e;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;
    public final vq2 b;
    public final String c;

    /* loaded from: classes8.dex */
    public class a implements ik3<vq2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uq2 a;

        public a(uq2 uq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uq2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: c */
        public void a(vq2 vq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vq2Var) == null) && uq2.d) {
                d();
            }
        }

        public final void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && uq2.d) {
                Log.i(str, str2);
            }
        }

        public final synchronized void d() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    b("SwanLaunch", "\n\n\n");
                    b("SwanLaunch", ">>>>>> SWAN Launch Log For " + this.a.c);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : this.a.a.entrySet()) {
                        sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                    }
                    for (vq2.b bVar : this.a.b.i()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (String str2 : bVar.b) {
                            sb2.append(str2);
                            sb2.append(" ");
                        }
                        for (String str3 : bVar.a) {
                            String h = this.a.b.h();
                            if (TextUtils.isEmpty(bVar.c)) {
                                str = h;
                            } else {
                                str = bVar.c;
                            }
                            b(str, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h, sb, sb2, str3));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948219571, "Lcom/baidu/tieba/uq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948219571, "Lcom/baidu/tieba/uq2;");
                return;
            }
        }
        d = am1.a;
        e = new HashMap();
    }

    public final ik3<vq2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (ik3) invokeV.objValue;
    }

    public vq2.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.d();
        }
        return (vq2.b) invokeV.objValue;
    }

    public synchronized uq2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                this.b.j();
            }
            return this;
        }
        return (uq2) invokeV.objValue;
    }

    public uq2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        vq2 vq2Var = new vq2();
        vq2Var.g("SwanLaunch");
        vq2Var.l(c());
        this.b = vq2Var;
        this.c = str;
    }

    public static uq2 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            uq2 uq2Var = e.get(str);
            if (uq2Var == null) {
                uq2 uq2Var2 = new uq2(str);
                e.put(str, uq2Var2);
                return uq2Var2;
            }
            return uq2Var;
        }
        return (uq2) invokeL.objValue;
    }

    public vq2.b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.b.e(str);
        }
        return (vq2.b) invokeL.objValue;
    }

    public vq2.b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            return this.b.f(str, str2);
        }
        return (vq2.b) invokeLL.objValue;
    }
}
