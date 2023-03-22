package com.baidu.tieba;

import android.app.Application;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.browser.exception.TbWebViewException;
import com.baidu.tieba.fc6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class va6 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static fsa<String> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ec6 {
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

        @Override // com.baidu.tieba.ec6
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (!TextUtils.isEmpty(str) && !str.contains("duxiaoman")) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948234110, "Lcom/baidu/tieba/va6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948234110, "Lcom/baidu/tieba/va6;");
                return;
            }
        }
        c = new ArrayList();
    }

    public va6() {
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
            return c;
        }
        return (List) invokeV.objValue;
    }

    public static String b() throws TbWebViewException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            fsa<String> fsaVar = b;
            if (fsaVar == null) {
                if (!f()) {
                    return "";
                }
                throw new TbWebViewException("TBWebKit need call initUserAgent first !");
            }
            return fsaVar.call();
        }
        return (String) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            fc6.a aVar = new fc6.a();
            aVar.c(new a());
            ic6.b().c(aVar);
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void c(final Application application, va6 va6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, application, va6Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (zc6.getContext() == null) {
                zc6.b(application);
            }
            if (f()) {
                cd6.a().f(new Runnable() { // from class: com.baidu.tieba.ta6
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
                pd6.f(true);
                pd6.d(3);
            }
            cd6.a().f(new Runnable() { // from class: com.baidu.tieba.sa6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        va6.h(application);
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                mc6.h().k();
            }
            pd6.b("lt-log", "init WebView Env 耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static void e(fsa<String> fsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, fsaVar) == null) {
            b = fsaVar;
        }
    }

    public static /* synthetic */ void h(Application application) {
        d();
        bd6.a().execute(new Runnable() { // from class: com.baidu.tieba.ua6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    fd6.a();
                }
            }
        });
        wa6.c().d(application);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            a = z;
        }
    }
}
