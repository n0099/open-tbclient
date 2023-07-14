package com.baidu.tieba;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.browser.exception.TbWebViewException;
import com.baidu.tieba.em6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rk6 {
    public static /* synthetic */ Interceptable $ic;
    public static m2c<String, Pair<Boolean, String>> a;
    public static final List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements dm6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.dm6
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return !TextUtils.isEmpty(str);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948124556, "Lcom/baidu/tieba/rk6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948124556, "Lcom/baidu/tieba/rk6;");
                return;
            }
        }
        b = new ArrayList();
    }

    public rk6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            em6.a aVar = new em6.a();
            aVar.c(new a());
            hm6.b().c(aVar);
        }
    }

    public static /* synthetic */ void f() {
        c();
        zm6.a().execute(new Runnable() { // from class: com.baidu.tieba.qk6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    en6.a();
                }
            }
        });
        sk6.g().i();
    }

    public static void b(final Application application, rk6 rk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, application, rk6Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (xm6.getContext() == null) {
                xm6.b(application);
            }
            if (ym6.a()) {
                an6.a().f(new Runnable() { // from class: com.baidu.tieba.nk6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    }
                });
            }
            an6.a().c(new Runnable() { // from class: com.baidu.tieba.ok6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        rk6.f();
                    }
                }
            });
            an6.a().f(new Runnable() { // from class: com.baidu.tieba.pk6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        sk6.g().h(application);
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                jm6.n().r();
            }
            vn6.b("newHybrid", "init WebView Env 耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static void d(m2c<String, Pair<Boolean, String>> m2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, m2cVar) == null) {
            a = m2cVar;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ym6.b(z);
        }
    }

    public static Pair<Boolean, String> i(String str) throws TbWebViewException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            m2c<String, Pair<Boolean, String>> m2cVar = a;
            if (m2cVar == null) {
                if (!ym6.a()) {
                    return new Pair<>(Boolean.FALSE, null);
                }
                throw new TbWebViewException("TBWebKit need call initUserAgent first !");
            }
            return m2cVar.call(str);
        }
        return (Pair) invokeL.objValue;
    }
}
