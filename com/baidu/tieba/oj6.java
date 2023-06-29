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
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class oj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qj6<MonitorWebView> a;
    public boolean b;
    public int c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final oj6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-544872720, "Lcom/baidu/tieba/oj6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-544872720, "Lcom/baidu/tieba/oj6$b;");
                    return;
                }
            }
            a = new oj6(null);
        }
    }

    public oj6() {
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
        this.c = -1;
        this.a = new sj6(8);
    }

    public static oj6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (oj6) invokeV.objValue;
    }

    public void a() {
        qj6<MonitorWebView> qj6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (qj6Var = this.a) != null) {
            qj6Var.d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FetchStaticResourceManager.e();
        }
    }

    public /* synthetic */ oj6(a aVar) {
        this();
    }

    @NonNull
    public MonitorWebView b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new BaseWebView(new MutableContextWrapper(d(context)));
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public final ContextThemeWrapper d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            if (theme != null) {
                theme.resolveAttribute(16973840, typedValue, true);
            }
            return new ContextThemeWrapper(context, typedValue.resourceId);
        }
        return (ContextThemeWrapper) invokeL.objValue;
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            try {
                if (mi.a()) {
                    i(b(context));
                    this.b = true;
                    i(b(context));
                }
            } catch (Exception unused) {
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c < 0) {
                this.c = r95.p().q("webview_blank_page_switch_android", 1);
                ew8 hybridLog = HybridLog.getInstance();
                hybridLog.c("CachedManager", "初始化空白页设置开关：" + this.c);
            }
            return this.c;
        }
        return invokeV.intValue;
    }

    @NonNull
    public MonitorWebView h(Context context) {
        InterceptResult invokeL;
        MonitorWebView b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (context == null) {
                context = tl6.getContext();
            }
            if (mi.a()) {
                b2 = this.a.b();
                ew8 hybridLog = HybridLog.getInstance();
                hybridLog.c("CachedManager", "尝试获取可复用WebView：" + b2);
                if (b2 == null) {
                    if (!this.b) {
                        ew8 hybridLog2 = HybridLog.getInstance();
                        hybridLog2.b("CachedManager", "冷启立刻就加载WebView？：" + context);
                    }
                    b2 = b(context);
                }
            } else {
                b2 = b(context);
            }
            Context context2 = b2.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context);
            } else {
                b2.destroy();
                b2 = b(context);
            }
            gk6.d(b2);
            return b2;
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public void i(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, webView) == null) {
            if (webView instanceof MonitorWebView) {
                MonitorWebView monitorWebView = (MonitorWebView) webView;
                boolean z = false;
                Context context = monitorWebView.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(tl6.getContext());
                    z = true;
                }
                if (mi.a() && z && monitorWebView.v()) {
                    this.a.a(monitorWebView);
                    ew8 hybridLog = HybridLog.getInstance();
                    hybridLog.c("CachedManager", "WebView放回缓存池：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                    return;
                }
                ew8 hybridLog2 = HybridLog.getInstance();
                hybridLog2.c("CachedManager", "销毁WebView：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                monitorWebView.destroy();
            } else if (webView != null) {
                webView.destroy();
            }
        }
    }
}
