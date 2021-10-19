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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes8.dex */
public class WhiteScreenMonitor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WhiteScreenConfig f62205a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f62206b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f62207c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f62208d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62209e;

    /* renamed from: f  reason: collision with root package name */
    public String f62210f;

    /* renamed from: g  reason: collision with root package name */
    public Context f62211g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, c> f62212h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, b> f62213i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f62226a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f62227b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f62228c;

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
            this.f62226a = null;
            this.f62227b = false;
            this.f62228c = null;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f62229a;

        /* renamed from: b  reason: collision with root package name */
        public String f62230b;

        /* renamed from: c  reason: collision with root package name */
        public String f62231c;

        /* renamed from: d  reason: collision with root package name */
        public String f62232d;

        /* renamed from: e  reason: collision with root package name */
        public String f62233e;

        /* renamed from: f  reason: collision with root package name */
        public String f62234f;

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
                this.f62229a = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f62231c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f62232d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f62233e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f62230b = str;
                this.f62234f = Uri.parse(str).getHost();
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Object f62235a;

        /* renamed from: b  reason: collision with root package name */
        public int f62236b;

        /* renamed from: c  reason: collision with root package name */
        public int f62237c;

        /* renamed from: d  reason: collision with root package name */
        public final int f62238d;

        /* renamed from: e  reason: collision with root package name */
        public final double f62239e;

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
            this.f62236b = i2;
            this.f62238d = i3;
            this.f62239e = Math.max(d2, 0.0d);
            this.f62235a = this;
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.f62235a) {
                    z = this.f62237c <= this.f62238d;
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
                synchronized (this.f62235a) {
                    i2 = this.f62236b;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.f62235a) {
                    this.f62237c++;
                    this.f62236b = (int) (this.f62236b * this.f62239e);
                }
                LogUtil.d("WhiteScreenMonitor", "Retry, count: " + this.f62237c + ", delay: " + this.f62236b + ", hasAttemptRemaining: " + a());
                return a();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static WhiteScreenMonitor f62240a;
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
            f62240a = new WhiteScreenMonitor();
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
        this.f62206b = new CopyOnWriteArrayList();
        this.f62208d = new Handler(Looper.getMainLooper());
        this.f62212h = new ConcurrentHashMap();
        this.f62213i = new ConcurrentHashMap();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Map<String, b> map = this.f62213i;
            if (map != null) {
                for (Map.Entry<String, b> entry : map.entrySet()) {
                    if (entry.getValue().f62229a && !TextUtils.isEmpty(entry.getValue().f62232d)) {
                        a(entry.getKey());
                    }
                }
            }
            Map<String, c> map2 = this.f62212h;
            if (map2 != null) {
                this.f62208d.removeCallbacksAndMessages(map2);
                this.f62212h.clear();
            }
            List<a> list = this.f62206b;
            if (list != null) {
                for (a aVar : list) {
                    a(aVar.f62226a);
                }
                this.f62206b.clear();
            }
        }
    }

    public static WhiteScreenMonitor a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f62240a : (WhiteScreenMonitor) invokeV.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, context) == null) || this.f62209e) {
            return;
        }
        File externalFilesDir = context.getExternalFilesDir("");
        this.f62211g = DxmApplicationContextImpl.getApplicationContext(context);
        if (externalFilesDir != null) {
            this.f62210f = externalFilesDir.getAbsolutePath();
        } else {
            this.f62210f = context.getFilesDir().getAbsolutePath();
        }
        String whiteScreenConfig = SdkInitResponse.getInstance().getWhiteScreenConfig(context);
        if (!TextUtils.isEmpty(whiteScreenConfig)) {
            try {
                this.f62205a = (WhiteScreenConfig) JsonUtils.fromJson(whiteScreenConfig, WhiteScreenConfig.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        WhiteScreenConfig whiteScreenConfig2 = this.f62205a;
        if (whiteScreenConfig2 == null || !whiteScreenConfig2.isValid()) {
            this.f62205a = new WhiteScreenConfig();
        }
        WhiteScreenConfig whiteScreenConfig3 = this.f62205a;
        if (!whiteScreenConfig3.wsc_enable && !whiteScreenConfig3.wsc_view_enable) {
            this.f62209e = true;
            return;
        }
        ThreadFactory threadFactory = new ThreadFactory(this) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public AtomicInteger f62214a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ WhiteScreenMonitor f62215b;

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
                this.f62215b = this;
                this.f62214a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WhiteScreenMoniter #" + this.f62214a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        WhiteScreenConfig whiteScreenConfig4 = this.f62205a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(whiteScreenConfig4.wsc_core_task, whiteScreenConfig4.wsc_max_task, whiteScreenConfig4.wsc_alive_time, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        this.f62207c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f62209e = true;
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
            this.f62207c.execute(new Runnable(this, a2.f62228c, currentTimeMillis, webView, pageStates, clearQuery, a2) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Bitmap f62219a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f62220b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WebView f62221c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PageStates f62222d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f62223e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f62224f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ WhiteScreenMonitor f62225g;

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
                    this.f62225g = this;
                    this.f62219a = r7;
                    this.f62220b = currentTimeMillis;
                    this.f62221c = webView;
                    this.f62222d = pageStates;
                    this.f62223e = clearQuery;
                    this.f62224f = a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WhiteScreenMonitor whiteScreenMonitor = this.f62225g;
                        ArrayList a3 = whiteScreenMonitor.a(whiteScreenMonitor.f62205a.wsc_area_detect, 4, 0);
                        boolean a4 = this.f62225g.a(this.f62219a, a3);
                        String str = "" + (System.currentTimeMillis() - this.f62220b);
                        b bVar = new b();
                        bVar.a(this.f62223e).a(a4).b(this.f62222d.name()).c(this.f62225g.a(a3)).d(str);
                        this.f62225g.f62213i.put(this.f62223e, bVar);
                        if (!a4) {
                            this.f62225g.b(this.f62223e);
                        } else {
                            this.f62225g.a(true, this.f62223e, this.f62221c, this.f62222d);
                        }
                        this.f62225g.a(this.f62224f);
                        this.f62225g.a(this.f62219a);
                        LogUtil.d("WhiteScreenMonitor", "WhiteScreen:" + this.f62223e + " " + a4 + " " + this.f62222d + " " + this.f62225g.a(a3));
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
            this.f62212h.remove(str);
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
            Iterator<Integer> it = a(this.f62205a.wsc_simple_count, new int[0]).iterator();
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
        if (this.f62205a.wsc_enable) {
            String clearQuery = URLUtil.clearQuery(url);
            a(pageStates, clearQuery);
            this.f62208d.removeCallbacksAndMessages(this.f62212h);
            a(false, clearQuery, webView, pageStates);
        }
    }

    private void a(PageStates pageStates, String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, pageStates, str) == null) {
            if (PageStates.START == pageStates) {
                WhiteScreenConfig.Policy policy = this.f62205a.startPolicy;
                cVar = new c(policy.initialDelayMs, policy.maxNumRetries, policy.backoffMultiplier);
            } else if (PageStates.FINISH == pageStates) {
                WhiteScreenConfig.Policy policy2 = this.f62205a.finishPolicy;
                cVar = new c(policy2.initialDelayMs, policy2.maxNumRetries, policy2.backoffMultiplier);
            } else {
                WhiteScreenConfig.Policy policy3 = this.f62205a.resumePolicy;
                cVar = new c(policy3.initialDelayMs, policy3.maxNumRetries, policy3.backoffMultiplier);
            }
            this.f62212h.put(str, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, WebView webView, PageStates pageStates) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Boolean.valueOf(z), str, webView, pageStates}) == null) {
            LogUtil.d("WhiteScreenMonitor", "queuedDetectTask, " + str + ", retrying: " + z + ", states: " + pageStates);
            c cVar = this.f62212h.get(str);
            if (cVar == null) {
                return;
            }
            if (z && !cVar.c()) {
                a(str);
                this.f62212h.remove(str);
                return;
            }
            this.f62208d.postAtTime(new Runnable(this, webView, pageStates) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WebView f62216a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PageStates f62217b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WhiteScreenMonitor f62218c;

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
                    this.f62218c = this;
                    this.f62216a = webView;
                    this.f62217b = pageStates;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62218c.b(this.f62216a, this.f62217b);
                    }
                }
            }, this.f62212h, SystemClock.uptimeMillis() + cVar.b());
        }
    }

    private void a(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            b bVar = this.f62213i.get(str);
            c cVar = this.f62212h.get(str);
            if (bVar != null && (z = bVar.f62229a) && cVar != null) {
                List asList = Arrays.asList(bVar.f62230b, String.valueOf(z), bVar.f62231c, bVar.f62232d, bVar.f62233e, bVar.f62234f, String.valueOf(cVar.a()));
                LogUtil.d("WhiteScreenMonitor", "reportResult, " + str + ", hasAttemptRemaining: " + cVar.a());
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, asList);
                HashMap hashMap = new HashMap(asList.size());
                hashMap.put("pageUrl", bVar.f62230b);
                hashMap.put("tag", bVar.f62231c);
                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, bVar.f62232d);
                hashMap.put("timeCost", bVar.f62233e);
                hashMap.put("host", bVar.f62234f);
                hashMap.put("hasAttemptRemaining", String.valueOf(cVar.a()));
                Tracker.send(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, hashMap, this.f62211g);
                this.f62213i.remove(str);
                return;
            }
            this.f62213i.remove(str);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, webView)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            int width = webView.getWidth();
            int height = webView.getHeight();
            a a2 = a(width, height);
            webView.draw(new Canvas(a2.f62226a));
            int a3 = a(width, height, 96, 96);
            a2.f62228c = ThumbnailUtils.extractThumbnail(a2.f62226a, width / a3, height / a3);
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
                if (i2 < this.f62205a.wsc_general_detect) {
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
                if (this.f62206b != null && this.f62206b.size() > 0) {
                    for (a aVar : this.f62206b) {
                        if (aVar.f62226a != null && !aVar.f62226a.isRecycled() && !aVar.f62227b && aVar.f62226a.getWidth() == i2 && aVar.f62226a.getHeight() == i3) {
                            aVar.f62227b = true;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Recycled");
                            return aVar;
                        }
                    }
                }
                if (this.f62206b.size() < this.f62205a.wsc_core_cache) {
                    a aVar2 = new a();
                    aVar2.f62226a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                    aVar2.f62227b = true;
                    this.f62206b.add(aVar2);
                    LogUtil.d("WhiteScreenMonitor", "Bitmap created");
                    return aVar2;
                }
                LogUtil.d("WhiteScreenMonitor", "Bitmap new");
                a aVar3 = new a();
                aVar3.f62226a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                aVar3.f62227b = true;
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
                if (this.f62206b != null && this.f62206b.size() > 0) {
                    for (a aVar2 : this.f62206b) {
                        if (aVar2.f62226a == aVar.f62226a && !aVar2.f62226a.isRecycled() && aVar2.f62227b) {
                            aVar2.f62227b = false;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Released");
                            return;
                        }
                    }
                }
                if (aVar.f62226a != null && !aVar.f62226a.isRecycled()) {
                    LogUtil.d("WhiteScreenMonitor", "Bitmap Full Released");
                    aVar.f62226a.recycle();
                }
            }
        }
    }
}
