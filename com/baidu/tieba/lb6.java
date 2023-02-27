package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.browser.core.cache.prefetch.PreFetchManager;
import com.baidu.tieba.browser.core.webview.flyweight.FlyweightWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class lb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ob6<FlyweightWebView> a;
    public final mb6<FlyweightWebView> b;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final lb6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-638148372, "Lcom/baidu/tieba/lb6$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-638148372, "Lcom/baidu/tieba/lb6$a;");
                    return;
                }
            }
            a = new lb6(null);
        }
    }

    public lb6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new nb6(8);
        this.a = new ob6<>();
    }

    public static lb6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a.a;
        }
        return (lb6) invokeV.objValue;
    }

    public /* synthetic */ lb6(kb6 kb6Var) {
        this();
    }

    public final ContextThemeWrapper b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            if (theme != null) {
                theme.resolveAttribute(16973840, typedValue, true);
            }
            return new ContextThemeWrapper(context, typedValue.resourceId);
        }
        return (ContextThemeWrapper) invokeL.objValue;
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            g(a(context));
            PreFetchManager.e();
        }
    }

    @NonNull
    public FlyweightWebView e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return f(context, "");
        }
        return (FlyweightWebView) invokeL.objValue;
    }

    @NonNull
    public FlyweightWebView a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            FlyweightWebView flyweightWebView = new FlyweightWebView(new MutableContextWrapper(b(context)));
            ke6.b("lt-log", "创建webView 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
            return flyweightWebView;
        }
        return (FlyweightWebView) invokeL.objValue;
    }

    public void g(@NonNull WebView webView) {
        FlyweightWebView flyweightWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, webView) == null) {
            if (webView instanceof FlyweightWebView) {
                flyweightWebView = (FlyweightWebView) webView;
            } else {
                flyweightWebView = null;
            }
            if (flyweightWebView == null) {
                return;
            }
            boolean z = false;
            if (flyweightWebView.h()) {
                z = this.a.b(flyweightWebView);
            }
            if (!z) {
                this.b.c(flyweightWebView);
            }
            me6.a().c();
        }
    }

    @NonNull
    public FlyweightWebView f(Context context, String str) {
        InterceptResult invokeLL;
        FlyweightWebView flyweightWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                flyweightWebView = this.a.a(str);
                if (flyweightWebView != null) {
                    ke6.b("lt-log", "我在预热池里找到了webview");
                }
            } else {
                flyweightWebView = null;
            }
            if (flyweightWebView == null && (flyweightWebView = this.b.a()) != null) {
                ke6.b("lt-log", "我在复用池里找到了webview");
            }
            if (flyweightWebView == null) {
                flyweightWebView = a(TbadkCoreApplication.getInst());
            }
            ((MutableContextWrapper) flyweightWebView.getContext()).setBaseContext(b(context));
            me6.a().b();
            return flyweightWebView;
        }
        return (FlyweightWebView) invokeLL.objValue;
    }
}
