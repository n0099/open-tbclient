package com.baidu.tieba;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.al6;
import com.baidu.tieba.browser.exception.TbWebViewException;
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
public class nj6 {
    public static /* synthetic */ Interceptable $ic;
    public static ptb<String, Pair<Boolean, String>> a;
    public static final List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements zk6 {
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

        @Override // com.baidu.tieba.zk6
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948004431, "Lcom/baidu/tieba/nj6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948004431, "Lcom/baidu/tieba/nj6;");
                return;
            }
        }
        b = new ArrayList();
    }

    public nj6() {
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
            al6.a aVar = new al6.a();
            aVar.c(new a());
            dl6.b().c(aVar);
        }
    }

    public static /* synthetic */ void f() {
        c();
        vl6.a().execute(new Runnable() { // from class: com.baidu.tieba.mj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    am6.a();
                }
            }
        });
        oj6.e().g();
    }

    public static void b(final Application application, nj6 nj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, application, nj6Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (tl6.getContext() == null) {
                tl6.b(application);
            }
            if (ul6.a()) {
                wl6.a().f(new Runnable() { // from class: com.baidu.tieba.jj6
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
            wl6.a().c(new Runnable() { // from class: com.baidu.tieba.kj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        nj6.f();
                    }
                }
            });
            wl6.a().f(new Runnable() { // from class: com.baidu.tieba.lj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        oj6.e().f(application);
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                fl6.n().r();
            }
            rm6.b("newHybrid", "init WebView Env 耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static void d(ptb<String, Pair<Boolean, String>> ptbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ptbVar) == null) {
            a = ptbVar;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ul6.b(z);
        }
    }

    public static Pair<Boolean, String> i(String str) throws TbWebViewException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            ptb<String, Pair<Boolean, String>> ptbVar = a;
            if (ptbVar == null) {
                if (!ul6.a()) {
                    return new Pair<>(Boolean.FALSE, null);
                }
                throw new TbWebViewException("TBWebKit need call initUserAgent first !");
            }
            return ptbVar.call(str);
        }
        return (Pair) invokeL.objValue;
    }
}
