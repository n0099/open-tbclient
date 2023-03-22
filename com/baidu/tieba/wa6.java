package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.cache.prefetch.FetchStaticResourceManager;
import com.baidu.tieba.browser.core.webview.base.BaseWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class wa6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ya6<BaseWebView> a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final wa6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-324151201, "Lcom/baidu/tieba/wa6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-324151201, "Lcom/baidu/tieba/wa6$b;");
                    return;
                }
            }
            a = new wa6(null);
        }
    }

    public wa6() {
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
        this.a = new za6(8);
    }

    public static wa6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (wa6) invokeV.objValue;
    }

    public /* synthetic */ wa6(a aVar) {
        this();
    }

    @NonNull
    public BaseWebView a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return new BaseWebView(new MutableContextWrapper(b(context)));
        }
        return (BaseWebView) invokeL.objValue;
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
            f(a(context));
            FetchStaticResourceManager.e();
        }
    }

    @NonNull
    public BaseWebView e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BaseWebView a2 = this.a.a();
            if (a2 == null) {
                a2 = a(zc6.getContext());
            }
            Context context2 = a2.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context);
            } else {
                a2.destroy();
                a2 = a(context);
            }
            jb6.d(a2);
            pd6.c("lt-log", "获取WebView实例耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return a2;
        }
        return (BaseWebView) invokeL.objValue;
    }

    public void f(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, webView) == null) {
            if (webView instanceof BaseWebView) {
                BaseWebView baseWebView = (BaseWebView) webView;
                boolean z = false;
                Context context = baseWebView.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(zc6.getContext());
                    z = true;
                }
                if (z && baseWebView.o()) {
                    this.a.c(baseWebView);
                } else {
                    baseWebView.destroy();
                }
            } else if (webView != null) {
                webView.destroy();
            }
        }
    }
}
