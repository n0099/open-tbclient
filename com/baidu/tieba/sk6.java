package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.InputDeviceCompat;
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
public final class sk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uk6<MonitorWebView> a;
    public boolean b;
    public int c;
    public final Handler d;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sk6 sk6Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk6Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sk6Var;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (message.what == 1) {
                    HybridLog.getInstance().b("CachedManager", "WebView空白页监听未触发，进行兜底回收");
                    MonitorWebView monitorWebView = (MonitorWebView) message.obj;
                    if (monitorWebView != null) {
                        this.a.a.a(monitorWebView);
                        return;
                    }
                    return;
                }
                super.handleMessage(message);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pn6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MonitorWebView a;
        public final /* synthetic */ sk6 b;

        public b(sk6 sk6Var, MonitorWebView monitorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk6Var, monitorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sk6Var;
            this.a = monitorWebView;
        }

        @Override // com.baidu.tieba.pn6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                HybridLog.getInstance().c("CachedManager", "WebView空白页监听，开始回收");
                ((BaseWebView) this.a).B();
                this.b.d.removeMessages(1);
                this.b.a.a(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final sk6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-429432564, "Lcom/baidu/tieba/sk6$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-429432564, "Lcom/baidu/tieba/sk6$c;");
                    return;
                }
            }
            a = new sk6(null);
        }
    }

    public sk6() {
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
        this.d = new a(this, Looper.getMainLooper());
        this.a = new wk6(8);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c < 0) {
                this.c = da5.p().q("webview_blank_page_switch_android", 2);
                h29 hybridLog = HybridLog.getInstance();
                hybridLog.c("CachedManager", "初始化空白页设置开关：" + this.c);
            }
            return this.c;
        }
        return invokeV.intValue;
    }

    public /* synthetic */ sk6(a aVar) {
        this();
    }

    @NonNull
    public MonitorWebView d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new BaseWebView(new MutableContextWrapper(f(context)));
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public final ContextThemeWrapper f(Context context) {
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

    public void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            try {
                if (ni.a()) {
                    k(d(context));
                    this.b = true;
                    k(d(context));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static sk6 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c.a;
        }
        return (sk6) invokeV.objValue;
    }

    public void c() {
        uk6<MonitorWebView> uk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (uk6Var = this.a) != null) {
            uk6Var.d();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FetchStaticResourceManager.e();
        }
    }

    @NonNull
    public MonitorWebView j(Context context) {
        InterceptResult invokeL;
        MonitorWebView d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (context == null) {
                context = xm6.getContext();
            }
            if (ni.a()) {
                d = this.a.b();
                h29 hybridLog = HybridLog.getInstance();
                hybridLog.c("CachedManager", "尝试获取可复用WebView：" + d);
                if (d == null) {
                    if (!this.b) {
                        h29 hybridLog2 = HybridLog.getInstance();
                        hybridLog2.b("CachedManager", "冷启立刻就加载WebView？：" + context);
                    }
                    d = d(context);
                }
            } else {
                d = d(context);
            }
            Context context2 = d.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context);
            } else {
                d.destroy();
                d = d(context);
            }
            kl6.d(d);
            return d;
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public void k(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, webView) == null) {
            if (webView instanceof MonitorWebView) {
                MonitorWebView monitorWebView = (MonitorWebView) webView;
                boolean z = false;
                Context context = monitorWebView.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(xm6.getContext());
                    z = true;
                }
                if (ni.a() && z && monitorWebView.v()) {
                    if (e() == 2 && (monitorWebView instanceof BaseWebView)) {
                        ((BaseWebView) monitorWebView).C(new b(this, monitorWebView));
                        Message obtainMessage = this.d.obtainMessage(1);
                        obtainMessage.obj = monitorWebView;
                        this.d.sendMessageDelayed(obtainMessage, 200L);
                    } else {
                        this.a.a(monitorWebView);
                    }
                    h29 hybridLog = HybridLog.getInstance();
                    hybridLog.c("CachedManager", "WebView放回缓存池：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                    return;
                }
                h29 hybridLog2 = HybridLog.getInstance();
                hybridLog2.c("CachedManager", "销毁WebView：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                monitorWebView.destroy();
            } else if (webView != null) {
                webView.destroy();
            }
        }
    }
}
