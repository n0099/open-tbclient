package com.baidu.wallet.lightapp.monitor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.monitor.WhiteScreenConfig;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.utils.URLUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
/* loaded from: classes13.dex */
public class WhiteScreenMonitor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WhiteScreenConfig a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f53674b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f53675c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f53676d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53677e;

    /* renamed from: f  reason: collision with root package name */
    public String f53678f;

    /* renamed from: g  reason: collision with root package name */
    public Context f53679g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, c> f53680h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, b> f53681i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class PageStates {
        public static final /* synthetic */ PageStates[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PageStates ACTIVE;
        public static final PageStates FINISH;
        public static final PageStates START;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-868147332, "Lcom/baidu/wallet/lightapp/monitor/WhiteScreenMonitor$PageStates;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-868147332, "Lcom/baidu/wallet/lightapp/monitor/WhiteScreenMonitor$PageStates;");
                    return;
                }
            }
            START = new PageStates("START", 0);
            FINISH = new PageStates("FINISH", 1);
            PageStates pageStates = new PageStates("ACTIVE", 2);
            ACTIVE = pageStates;
            $VALUES = new PageStates[]{START, FINISH, pageStates};
        }

        public PageStates(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PageStates valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PageStates) Enum.valueOf(PageStates.class, str) : (PageStates) invokeL.objValue;
        }

        public static PageStates[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PageStates[]) $VALUES.clone() : (PageStates[]) invokeV.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f53691b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f53692c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f53691b = false;
            this.f53692c = null;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f53693b;

        /* renamed from: c  reason: collision with root package name */
        public String f53694c;

        /* renamed from: d  reason: collision with root package name */
        public String f53695d;

        /* renamed from: e  reason: collision with root package name */
        public String f53696e;

        /* renamed from: f  reason: collision with root package name */
        public String f53697f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.a = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f53694c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f53695d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f53696e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f53693b = str;
                this.f53697f = Uri.parse(str).getHost();
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object a;

        /* renamed from: b  reason: collision with root package name */
        public int f53698b;

        /* renamed from: c  reason: collision with root package name */
        public int f53699c;

        /* renamed from: d  reason: collision with root package name */
        public final int f53700d;

        /* renamed from: e  reason: collision with root package name */
        public final double f53701e;

        public c(int i2, int i3, double d2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53698b = i2;
            this.f53700d = i3;
            this.f53701e = Math.max(d2, 0.0d);
            this.a = this;
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.a) {
                    z = this.f53699c <= this.f53700d;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.a) {
                    i2 = this.f53698b;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.a) {
                    this.f53699c++;
                    this.f53698b = (int) (this.f53698b * this.f53701e);
                }
                LogUtil.d("WhiteScreenMonitor", "Retry, count: " + this.f53699c + ", delay: " + this.f53698b + ", hasAttemptRemaining: " + a());
                return a();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static WhiteScreenMonitor a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2138186395, "Lcom/baidu/wallet/lightapp/monitor/WhiteScreenMonitor$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2138186395, "Lcom/baidu/wallet/lightapp/monitor/WhiteScreenMonitor$d;");
                    return;
                }
            }
            a = new WhiteScreenMonitor();
        }
    }

    public WhiteScreenMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53674b = new CopyOnWriteArrayList();
        this.f53676d = new Handler(Looper.getMainLooper());
        this.f53680h = new ConcurrentHashMap();
        this.f53681i = new ConcurrentHashMap();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Map<String, b> map = this.f53681i;
            if (map != null) {
                for (Map.Entry<String, b> entry : map.entrySet()) {
                    if (entry.getValue().a && !TextUtils.isEmpty(entry.getValue().f53695d)) {
                        a(entry.getKey());
                    }
                }
            }
            Map<String, c> map2 = this.f53680h;
            if (map2 != null) {
                this.f53676d.removeCallbacksAndMessages(map2);
                this.f53680h.clear();
            }
            List<a> list = this.f53674b;
            if (list != null) {
                for (a aVar : list) {
                    a(aVar.a);
                }
                this.f53674b.clear();
            }
        }
    }

    public static WhiteScreenMonitor a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? d.a : (WhiteScreenMonitor) invokeV.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, context) == null) || this.f53677e) {
            return;
        }
        File externalFilesDir = context.getExternalFilesDir("");
        this.f53679g = DxmApplicationContextImpl.getApplicationContext(context);
        if (externalFilesDir != null) {
            this.f53678f = externalFilesDir.getAbsolutePath();
        } else {
            this.f53678f = context.getFilesDir().getAbsolutePath();
        }
        String whiteScreenConfig = SdkInitResponse.getInstance().getWhiteScreenConfig(context);
        if (!TextUtils.isEmpty(whiteScreenConfig)) {
            try {
                this.a = (WhiteScreenConfig) JsonUtils.fromJson(whiteScreenConfig, WhiteScreenConfig.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        WhiteScreenConfig whiteScreenConfig2 = this.a;
        if (whiteScreenConfig2 == null || !whiteScreenConfig2.isValid()) {
            this.a = new WhiteScreenConfig();
        }
        WhiteScreenConfig whiteScreenConfig3 = this.a;
        if (!whiteScreenConfig3.wsc_enable && !whiteScreenConfig3.wsc_view_enable) {
            this.f53677e = true;
            return;
        }
        ThreadFactory threadFactory = new ThreadFactory(this) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public AtomicInteger a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ WhiteScreenMonitor f53682b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53682b = this;
                this.a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WhiteScreenMoniter #" + this.a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        WhiteScreenConfig whiteScreenConfig4 = this.a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(whiteScreenConfig4.wsc_core_task, whiteScreenConfig4.wsc_max_task, whiteScreenConfig4.wsc_alive_time, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        this.f53675c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f53677e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(WebView webView, PageStates pageStates) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, this, webView, pageStates) == null) || webView == null) {
            return;
        }
        String url = webView.getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String clearQuery = URLUtil.clearQuery(url);
        LogUtil.d("WhiteScreenMonitor", "START DETECT, " + pageStates + StringUtil.ARRAY_ELEMENT_SEPARATOR + clearQuery);
        try {
            a a2 = a(webView);
            this.f53675c.execute(new Runnable(this, a2.f53692c, currentTimeMillis, webView, pageStates, clearQuery, a2) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f53685b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WebView f53686c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PageStates f53687d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f53688e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f53689f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ WhiteScreenMonitor f53690g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Long.valueOf(currentTimeMillis), webView, pageStates, clearQuery, a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53690g = this;
                    this.a = r7;
                    this.f53685b = currentTimeMillis;
                    this.f53686c = webView;
                    this.f53687d = pageStates;
                    this.f53688e = clearQuery;
                    this.f53689f = a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WhiteScreenMonitor whiteScreenMonitor = this.f53690g;
                        ArrayList a3 = whiteScreenMonitor.a(whiteScreenMonitor.a.wsc_area_detect, 4, 0);
                        boolean a4 = this.f53690g.a(this.a, a3);
                        String str = "" + (System.currentTimeMillis() - this.f53685b);
                        b bVar = new b();
                        bVar.a(this.f53688e).a(a4).b(this.f53687d.name()).c(this.f53690g.a(a3)).d(str);
                        this.f53690g.f53681i.put(this.f53688e, bVar);
                        if (!a4) {
                            this.f53690g.b(this.f53688e);
                        } else {
                            this.f53690g.a(true, this.f53688e, this.f53686c, this.f53687d);
                        }
                        this.f53690g.a(this.f53689f);
                        this.f53690g.a(this.a);
                        LogUtil.d("WhiteScreenMonitor", "WhiteScreen:" + this.f53688e + " " + a4 + " " + this.f53687d + " " + this.f53690g.a(a3));
                        StringBuilder sb = new StringBuilder();
                        sb.append("TIME COST:");
                        sb.append(str);
                        LogUtil.d("WhiteScreenMonitor", sb.toString());
                    }
                }
            });
        } catch (Exception e2) {
            LogUtil.d("WhiteScreenMonitor", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, str) == null) {
            this.f53680h.remove(str);
        }
    }

    private Rect[] b(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65565, this, i2, i3, i4, i5)) == null) {
            Rect[] rectArr = new Rect[i4 * i5];
            float f2 = i2 / i5;
            float f3 = i3 / i4;
            for (int i6 = 0; i6 < i4; i6++) {
                for (int i7 = 0; i7 < i5; i7++) {
                    float f4 = i7 * f2;
                    float f5 = i6 * f3;
                    rectArr[(i6 * i5) + i7] = new Rect((int) f4, (int) f5, (int) (f4 + f2), (int) (f5 + f3));
                }
            }
            return rectArr;
        }
        return (Rect[]) invokeIIII.objValue;
    }

    private boolean b(Bitmap bitmap, Rect rect, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, this, new Object[]{bitmap, rect, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Rect[] b2 = b(rect.width(), rect.height(), 3, 3);
            Iterator<Integer> it = a(this.a.wsc_simple_count, new int[0]).iterator();
            while (it.hasNext()) {
                Rect rect2 = b2[it.next().intValue()];
                for (int i3 = rect2.left + rect.left; i3 < rect2.right + rect.left; i3++) {
                    for (int i4 = rect2.top + rect.top; i4 < rect2.bottom + rect.top; i4++) {
                        int pixel = bitmap.getPixel(i3, i4);
                        if (z) {
                            bitmap.setPixel(i3, i4, -16711936);
                        }
                        if (i2 == 0) {
                            i2 = pixel;
                        } else if (pixel != i2) {
                            LogUtil.d("WhiteScreenMonitor", "diff(" + i3 + "," + i4 + "):" + pixel + " != " + i2);
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void a(WebView webView, PageStates pageStates) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, webView, pageStates) == null) || webView == null) {
            return;
        }
        String url = webView.getUrl();
        if (TextUtils.isEmpty(url) || "about:blank".equals(url)) {
            return;
        }
        LogUtil.d("WhiteScreenMonitor", "startDetectWebView, " + url + ", states: " + pageStates);
        a(webView.getContext());
        if (this.a.wsc_enable) {
            String clearQuery = URLUtil.clearQuery(url);
            a(pageStates, clearQuery);
            this.f53676d.removeCallbacksAndMessages(this.f53680h);
            a(false, clearQuery, webView, pageStates);
        }
    }

    private void a(PageStates pageStates, String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, pageStates, str) == null) {
            if (PageStates.START == pageStates) {
                WhiteScreenConfig.Policy policy = this.a.startPolicy;
                cVar = new c(policy.initialDelayMs, policy.maxNumRetries, policy.backoffMultiplier);
            } else if (PageStates.FINISH == pageStates) {
                WhiteScreenConfig.Policy policy2 = this.a.finishPolicy;
                cVar = new c(policy2.initialDelayMs, policy2.maxNumRetries, policy2.backoffMultiplier);
            } else {
                WhiteScreenConfig.Policy policy3 = this.a.resumePolicy;
                cVar = new c(policy3.initialDelayMs, policy3.maxNumRetries, policy3.backoffMultiplier);
            }
            this.f53680h.put(str, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, WebView webView, PageStates pageStates) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Boolean.valueOf(z), str, webView, pageStates}) == null) {
            LogUtil.d("WhiteScreenMonitor", "queuedDetectTask, " + str + ", retrying: " + z + ", states: " + pageStates);
            c cVar = this.f53680h.get(str);
            if (cVar == null) {
                return;
            }
            if (z && !cVar.c()) {
                a(str);
                this.f53680h.remove(str);
                return;
            }
            this.f53676d.postAtTime(new Runnable(this, webView, pageStates) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebView a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PageStates f53683b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WhiteScreenMonitor f53684c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, webView, pageStates};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53684c = this;
                    this.a = webView;
                    this.f53683b = pageStates;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f53684c.b(this.a, this.f53683b);
                    }
                }
            }, this.f53680h, SystemClock.uptimeMillis() + cVar.b());
        }
    }

    private void a(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            b bVar = this.f53681i.get(str);
            c cVar = this.f53680h.get(str);
            if (bVar != null && (z = bVar.a) && cVar != null) {
                List asList = Arrays.asList(bVar.f53693b, String.valueOf(z), bVar.f53694c, bVar.f53695d, bVar.f53696e, bVar.f53697f, String.valueOf(cVar.a()));
                LogUtil.d("WhiteScreenMonitor", "reportResult, " + str + ", hasAttemptRemaining: " + cVar.a());
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, asList);
                HashMap hashMap = new HashMap(asList.size());
                hashMap.put("pageUrl", bVar.f53693b);
                hashMap.put("tag", bVar.f53694c);
                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, bVar.f53695d);
                hashMap.put("timeCost", bVar.f53696e);
                hashMap.put("host", bVar.f53697f);
                hashMap.put("hasAttemptRemaining", String.valueOf(cVar.a()));
                Tracker.send(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, hashMap, this.f53679g);
                this.f53681i.remove(str);
                return;
            }
            this.f53681i.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Integer> a(int i2, int... iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, this, i2, iArr)) == null) {
            i2 = (i2 < 1 || i2 > 9) ? 9 : 9;
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i3 : iArr) {
                if (i3 < 9) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            while (arrayList.size() < i2) {
                int nextInt = new Random().nextInt(9);
                if (!arrayList.contains(Integer.valueOf(nextInt))) {
                    arrayList.add(Integer.valueOf(nextInt));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeIL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Iterator<Integer> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, arrayList)) == null) {
            String str = "";
            while (arrayList.iterator().hasNext()) {
                str = str + it.next();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private a a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, webView)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            int width = webView.getWidth();
            int height = webView.getHeight();
            a a2 = a(width, height);
            webView.draw(new Canvas(a2.a));
            int a3 = a(width, height, 96, 96);
            a2.f53692c = ThumbnailUtils.extractThumbnail(a2.a, width / a3, height / a3);
            LogUtil.d("WhiteScreenMonitor", "captureWebView:" + (System.currentTimeMillis() - currentTimeMillis));
            return a2;
        }
        return (a) invokeL.objValue;
    }

    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, null, i2, i3, i4, i5)) == null) {
            int i6 = 1;
            if (i3 > i5 || i2 > i4) {
                int i7 = i3 / 2;
                int i8 = i2 / 2;
                while (i7 / i6 >= i5 && i8 / i6 >= i4) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeIIII.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Bitmap bitmap, ArrayList<Integer> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, this, bitmap, arrayList)) == null) {
            LogUtil.d("WhiteScreenMonitor", "isWhiteBitmap width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
            if (!a(bitmap, new Rect((bitmap.getWidth() / 2) - 1, 0, (bitmap.getWidth() / 2) + 1, bitmap.getHeight()), false, 0)) {
                LogUtil.d("WhiteScreenMonitor", "Fast detect: false");
                return false;
            }
            int pixel = bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            Rect[] b2 = b(bitmap.getWidth(), bitmap.getHeight(), 3, 3);
            boolean z = false;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 < this.a.wsc_general_detect) {
                    z = a(bitmap, b2[arrayList.get(i2).intValue()], false, pixel);
                } else {
                    z = b(bitmap, b2[arrayList.get(i2).intValue()], false, pixel);
                }
                LogUtil.d("WhiteScreenMonitor", "Area(" + arrayList.get(i2) + "):" + z);
                if (!z) {
                    break;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(Bitmap bitmap, Rect rect, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, this, new Object[]{bitmap, rect, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            for (int i3 = rect.left; i3 < rect.right; i3++) {
                for (int i4 = rect.top; i4 < rect.bottom; i4++) {
                    int pixel = bitmap.getPixel(i3, i4);
                    if (z) {
                        bitmap.setPixel(i3, i4, -16711936);
                    }
                    if (i2 == 0) {
                        i2 = pixel;
                    } else if (pixel != i2) {
                        LogUtil.d("WhiteScreenMonitor", "diff(" + i3 + "," + i4 + "):" + pixel + " != " + i2);
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, bitmap) == null) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    private synchronized a a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3)) == null) {
            synchronized (this) {
                if (this.f53674b != null && this.f53674b.size() > 0) {
                    for (a aVar : this.f53674b) {
                        if (aVar.a != null && !aVar.a.isRecycled() && !aVar.f53691b && aVar.a.getWidth() == i2 && aVar.a.getHeight() == i3) {
                            aVar.f53691b = true;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Recycled");
                            return aVar;
                        }
                    }
                }
                if (this.f53674b.size() < this.a.wsc_core_cache) {
                    a aVar2 = new a();
                    aVar2.a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                    aVar2.f53691b = true;
                    this.f53674b.add(aVar2);
                    LogUtil.d("WhiteScreenMonitor", "Bitmap created");
                    return aVar2;
                }
                LogUtil.d("WhiteScreenMonitor", "Bitmap new");
                a aVar3 = new a();
                aVar3.a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                aVar3.f53691b = true;
                return aVar3;
            }
        }
        return (a) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, aVar) == null) {
            synchronized (this) {
                if (this.f53674b != null && this.f53674b.size() > 0) {
                    for (a aVar2 : this.f53674b) {
                        if (aVar2.a == aVar.a && !aVar2.a.isRecycled() && aVar2.f53691b) {
                            aVar2.f53691b = false;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Released");
                            return;
                        }
                    }
                }
                if (aVar.a != null && !aVar.a.isRecycled()) {
                    LogUtil.d("WhiteScreenMonitor", "Bitmap Full Released");
                    aVar.a.recycle();
                }
            }
        }
    }
}
