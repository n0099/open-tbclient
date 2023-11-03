package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e51> a;
    public final List<j51> b;
    public final i51 c;

    public o51(i51 contextHelper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contextHelper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        this.c = contextHelper;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final boolean g(String url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, url)) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            while (true) {
                boolean z = false;
                for (j51 j51Var : this.b) {
                    if (z || j51Var.a(this.c, url)) {
                        z = true;
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (e51 e51Var : this.a) {
                if (e51Var instanceof f51) {
                    return e51Var.b();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.m();
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.c();
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.d();
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.i();
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.l();
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.clear();
        }
    }

    public final boolean b(AbsNadBrowserView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            for (e51 e51Var : this.a) {
                if (e51Var instanceof h51) {
                    return e51Var.f(webView, str);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void c(AbsNadBrowserView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.g(webView, str);
                }
            }
            if (str != null) {
                for (j51 j51Var : this.b) {
                    j51Var.b(this.c, str);
                }
            }
        }
    }

    public final void d(AbsNadBrowserView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.h(webView, str, bitmap);
                }
            }
        }
    }

    public final void e(AbsNadBrowserView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, webView, i, str, str2) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.j(webView, i, str, str2);
                }
            }
        }
    }

    public final void f(AbsNadBrowserView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webView, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.k(webView, str);
                }
            }
        }
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            for (e51 e51Var : this.a) {
                if (e51Var != null) {
                    e51Var.e(intent);
                }
            }
        }
    }

    public final void n(j51 action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, action) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.b.add(action);
        }
    }

    public final void o(e51 e51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, e51Var) == null) {
            this.a.add(e51Var);
        }
    }
}
