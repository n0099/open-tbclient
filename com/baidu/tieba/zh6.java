package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.browser.core.cache.prefetch.FetchStaticResourceManager;
import com.baidu.tieba.browser.core.webview.base.BaseWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class zh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bi6<MonitorWebView> a;
    public boolean b;
    public int c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MonitorWebView a;
        public final /* synthetic */ zh6 b;

        public a(zh6 zh6Var, MonitorWebView monitorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh6Var, monitorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zh6Var;
            this.a = monitorWebView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridLog.getInstance().e("CachedManager", "WebView空白页监听未触发，进行兜底回收");
                if (this.a != null) {
                    this.b.a.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements xk6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MonitorWebView a;
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ zh6 c;

        public b(zh6 zh6Var, MonitorWebView monitorWebView, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh6Var, monitorWebView, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zh6Var;
            this.a = monitorWebView;
            this.b = runnable;
        }

        @Override // com.baidu.tieba.xk6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                HybridLog.getInstance().i("CachedManager", "WebView空白页监听，开始回收");
                ((BaseWebView) this.a).B();
                SafeHandler.getInst().removeCallbacks(this.b);
                this.c.a.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final zh6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231799070, "Lcom/baidu/tieba/zh6$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-231799070, "Lcom/baidu/tieba/zh6$c;");
                    return;
                }
            }
            a = new zh6(null);
        }
    }

    public zh6() {
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
        this.a = new di6(8);
    }

    public static zh6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c.a;
        }
        return (zh6) invokeV.objValue;
    }

    public void b() {
        bi6<MonitorWebView> bi6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bi6Var = this.a) != null) {
            bi6Var.d();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FetchStaticResourceManager.e();
        }
    }

    public /* synthetic */ zh6(a aVar) {
        this();
    }

    @NonNull
    public MonitorWebView c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new BaseWebView(new MutableContextWrapper(e(context)));
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public final ContextThemeWrapper e(Context context) {
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

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            try {
                if (sh.a()) {
                    j(c(context));
                    this.b = true;
                    j(c(context));
                }
            } catch (Exception unused) {
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c < 0) {
                this.c = SharedPrefHelper.getInstance().getInt("webview_blank_page_switch_android", 2);
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("CachedManager", "初始化空白页设置开关：" + this.c);
            }
            return this.c;
        }
        return invokeV.intValue;
    }

    @NonNull
    public MonitorWebView i(Context context) {
        InterceptResult invokeL;
        MonitorWebView c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (context == null) {
                context = fk6.getContext();
            }
            if (sh.a()) {
                c2 = this.a.b();
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("CachedManager", "尝试获取可复用WebView：" + c2);
                if (c2 == null) {
                    if (!this.b) {
                        TbLog hybridLog2 = HybridLog.getInstance();
                        hybridLog2.e("CachedManager", "冷启立刻就加载WebView？：" + context);
                    }
                    c2 = c(context);
                }
            } else {
                c2 = c(context);
            }
            Context context2 = c2.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context);
            } else {
                c2.destroy();
                c2 = c(context);
            }
            si6.d(c2);
            return c2;
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public void j(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, webView) == null) {
            if (webView instanceof MonitorWebView) {
                MonitorWebView monitorWebView = (MonitorWebView) webView;
                boolean z = false;
                Context context = monitorWebView.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(fk6.getContext());
                    z = true;
                }
                if (sh.a() && z && monitorWebView.v()) {
                    if (d() == 2 && (monitorWebView instanceof BaseWebView)) {
                        a aVar = new a(this, monitorWebView);
                        ((BaseWebView) monitorWebView).C(new b(this, monitorWebView, aVar));
                        long j = 200;
                        SafeHandler.getInst().postDelayed(aVar, (TbadkCoreApplication.getInst().isDebugMode() || GlobalBuildConfig.isTiebaDebugTool()) ? 10L : 10L);
                    } else {
                        this.a.a(monitorWebView);
                    }
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.i("CachedManager", "WebView放回缓存池：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                    return;
                }
                TbLog hybridLog2 = HybridLog.getInstance();
                hybridLog2.i("CachedManager", "销毁WebView：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                monitorWebView.destroy();
            } else if (webView != null) {
                webView.destroy();
            }
        }
    }
}
