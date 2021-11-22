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
/* loaded from: classes10.dex */
public class WhiteScreenMonitor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WhiteScreenConfig f60004a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f60005b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f60006c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f60007d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60008e;

    /* renamed from: f  reason: collision with root package name */
    public String f60009f;

    /* renamed from: g  reason: collision with root package name */
    public Context f60010g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, c> f60011h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, b> f60012i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f60025a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f60026b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f60027c;

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
            this.f60025a = null;
            this.f60026b = false;
            this.f60027c = null;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f60028a;

        /* renamed from: b  reason: collision with root package name */
        public String f60029b;

        /* renamed from: c  reason: collision with root package name */
        public String f60030c;

        /* renamed from: d  reason: collision with root package name */
        public String f60031d;

        /* renamed from: e  reason: collision with root package name */
        public String f60032e;

        /* renamed from: f  reason: collision with root package name */
        public String f60033f;

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
                this.f60028a = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f60030c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f60031d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f60032e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f60029b = str;
                this.f60033f = Uri.parse(str).getHost();
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Object f60034a;

        /* renamed from: b  reason: collision with root package name */
        public int f60035b;

        /* renamed from: c  reason: collision with root package name */
        public int f60036c;

        /* renamed from: d  reason: collision with root package name */
        public final int f60037d;

        /* renamed from: e  reason: collision with root package name */
        public final double f60038e;

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
            this.f60035b = i2;
            this.f60037d = i3;
            this.f60038e = Math.max(d2, 0.0d);
            this.f60034a = this;
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.f60034a) {
                    z = this.f60036c <= this.f60037d;
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
                synchronized (this.f60034a) {
                    i2 = this.f60035b;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.f60034a) {
                    this.f60036c++;
                    this.f60035b = (int) (this.f60035b * this.f60038e);
                }
                LogUtil.d("WhiteScreenMonitor", "Retry, count: " + this.f60036c + ", delay: " + this.f60035b + ", hasAttemptRemaining: " + a());
                return a();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static WhiteScreenMonitor f60039a;
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
            f60039a = new WhiteScreenMonitor();
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
        this.f60005b = new CopyOnWriteArrayList();
        this.f60007d = new Handler(Looper.getMainLooper());
        this.f60011h = new ConcurrentHashMap();
        this.f60012i = new ConcurrentHashMap();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Map<String, b> map = this.f60012i;
            if (map != null) {
                for (Map.Entry<String, b> entry : map.entrySet()) {
                    if (entry.getValue().f60028a && !TextUtils.isEmpty(entry.getValue().f60031d)) {
                        a(entry.getKey());
                    }
                }
            }
            Map<String, c> map2 = this.f60011h;
            if (map2 != null) {
                this.f60007d.removeCallbacksAndMessages(map2);
                this.f60011h.clear();
            }
            List<a> list = this.f60005b;
            if (list != null) {
                for (a aVar : list) {
                    a(aVar.f60025a);
                }
                this.f60005b.clear();
            }
        }
    }

    public static WhiteScreenMonitor a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f60039a : (WhiteScreenMonitor) invokeV.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, context) == null) || this.f60008e) {
            return;
        }
        File externalFilesDir = context.getExternalFilesDir("");
        this.f60010g = DxmApplicationContextImpl.getApplicationContext(context);
        if (externalFilesDir != null) {
            this.f60009f = externalFilesDir.getAbsolutePath();
        } else {
            this.f60009f = context.getFilesDir().getAbsolutePath();
        }
        String whiteScreenConfig = SdkInitResponse.getInstance().getWhiteScreenConfig(context);
        if (!TextUtils.isEmpty(whiteScreenConfig)) {
            try {
                this.f60004a = (WhiteScreenConfig) JsonUtils.fromJson(whiteScreenConfig, WhiteScreenConfig.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        WhiteScreenConfig whiteScreenConfig2 = this.f60004a;
        if (whiteScreenConfig2 == null || !whiteScreenConfig2.isValid()) {
            this.f60004a = new WhiteScreenConfig();
        }
        WhiteScreenConfig whiteScreenConfig3 = this.f60004a;
        if (!whiteScreenConfig3.wsc_enable && !whiteScreenConfig3.wsc_view_enable) {
            this.f60008e = true;
            return;
        }
        ThreadFactory threadFactory = new ThreadFactory(this) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public AtomicInteger f60013a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ WhiteScreenMonitor f60014b;

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
                this.f60014b = this;
                this.f60013a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WhiteScreenMoniter #" + this.f60013a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        WhiteScreenConfig whiteScreenConfig4 = this.f60004a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(whiteScreenConfig4.wsc_core_task, whiteScreenConfig4.wsc_max_task, whiteScreenConfig4.wsc_alive_time, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        this.f60006c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f60008e = true;
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
            this.f60006c.execute(new Runnable(this, a2.f60027c, currentTimeMillis, webView, pageStates, clearQuery, a2) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Bitmap f60018a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f60019b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WebView f60020c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PageStates f60021d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f60022e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f60023f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ WhiteScreenMonitor f60024g;

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
                    this.f60024g = this;
                    this.f60018a = r7;
                    this.f60019b = currentTimeMillis;
                    this.f60020c = webView;
                    this.f60021d = pageStates;
                    this.f60022e = clearQuery;
                    this.f60023f = a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WhiteScreenMonitor whiteScreenMonitor = this.f60024g;
                        ArrayList a3 = whiteScreenMonitor.a(whiteScreenMonitor.f60004a.wsc_area_detect, 4, 0);
                        boolean a4 = this.f60024g.a(this.f60018a, a3);
                        String str = "" + (System.currentTimeMillis() - this.f60019b);
                        b bVar = new b();
                        bVar.a(this.f60022e).a(a4).b(this.f60021d.name()).c(this.f60024g.a(a3)).d(str);
                        this.f60024g.f60012i.put(this.f60022e, bVar);
                        if (!a4) {
                            this.f60024g.b(this.f60022e);
                        } else {
                            this.f60024g.a(true, this.f60022e, this.f60020c, this.f60021d);
                        }
                        this.f60024g.a(this.f60023f);
                        this.f60024g.a(this.f60018a);
                        LogUtil.d("WhiteScreenMonitor", "WhiteScreen:" + this.f60022e + " " + a4 + " " + this.f60021d + " " + this.f60024g.a(a3));
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
            this.f60011h.remove(str);
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
            Iterator<Integer> it = a(this.f60004a.wsc_simple_count, new int[0]).iterator();
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
        if (this.f60004a.wsc_enable) {
            String clearQuery = URLUtil.clearQuery(url);
            a(pageStates, clearQuery);
            this.f60007d.removeCallbacksAndMessages(this.f60011h);
            a(false, clearQuery, webView, pageStates);
        }
    }

    private void a(PageStates pageStates, String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, pageStates, str) == null) {
            if (PageStates.START == pageStates) {
                WhiteScreenConfig.Policy policy = this.f60004a.startPolicy;
                cVar = new c(policy.initialDelayMs, policy.maxNumRetries, policy.backoffMultiplier);
            } else if (PageStates.FINISH == pageStates) {
                WhiteScreenConfig.Policy policy2 = this.f60004a.finishPolicy;
                cVar = new c(policy2.initialDelayMs, policy2.maxNumRetries, policy2.backoffMultiplier);
            } else {
                WhiteScreenConfig.Policy policy3 = this.f60004a.resumePolicy;
                cVar = new c(policy3.initialDelayMs, policy3.maxNumRetries, policy3.backoffMultiplier);
            }
            this.f60011h.put(str, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, WebView webView, PageStates pageStates) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Boolean.valueOf(z), str, webView, pageStates}) == null) {
            LogUtil.d("WhiteScreenMonitor", "queuedDetectTask, " + str + ", retrying: " + z + ", states: " + pageStates);
            c cVar = this.f60011h.get(str);
            if (cVar == null) {
                return;
            }
            if (z && !cVar.c()) {
                a(str);
                this.f60011h.remove(str);
                return;
            }
            this.f60007d.postAtTime(new Runnable(this, webView, pageStates) { // from class: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WebView f60015a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PageStates f60016b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WhiteScreenMonitor f60017c;

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
                    this.f60017c = this;
                    this.f60015a = webView;
                    this.f60016b = pageStates;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f60017c.b(this.f60015a, this.f60016b);
                    }
                }
            }, this.f60011h, SystemClock.uptimeMillis() + cVar.b());
        }
    }

    private void a(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            b bVar = this.f60012i.get(str);
            c cVar = this.f60011h.get(str);
            if (bVar != null && (z = bVar.f60028a) && cVar != null) {
                List asList = Arrays.asList(bVar.f60029b, String.valueOf(z), bVar.f60030c, bVar.f60031d, bVar.f60032e, bVar.f60033f, String.valueOf(cVar.a()));
                LogUtil.d("WhiteScreenMonitor", "reportResult, " + str + ", hasAttemptRemaining: " + cVar.a());
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, asList);
                HashMap hashMap = new HashMap(asList.size());
                hashMap.put("pageUrl", bVar.f60029b);
                hashMap.put("tag", bVar.f60030c);
                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, bVar.f60031d);
                hashMap.put("timeCost", bVar.f60032e);
                hashMap.put("host", bVar.f60033f);
                hashMap.put("hasAttemptRemaining", String.valueOf(cVar.a()));
                Tracker.send(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, hashMap, this.f60010g);
                this.f60012i.remove(str);
                return;
            }
            this.f60012i.remove(str);
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
            webView.draw(new Canvas(a2.f60025a));
            int a3 = a(width, height, 96, 96);
            a2.f60027c = ThumbnailUtils.extractThumbnail(a2.f60025a, width / a3, height / a3);
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
                if (i2 < this.f60004a.wsc_general_detect) {
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
                if (this.f60005b != null && this.f60005b.size() > 0) {
                    for (a aVar : this.f60005b) {
                        if (aVar.f60025a != null && !aVar.f60025a.isRecycled() && !aVar.f60026b && aVar.f60025a.getWidth() == i2 && aVar.f60025a.getHeight() == i3) {
                            aVar.f60026b = true;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Recycled");
                            return aVar;
                        }
                    }
                }
                if (this.f60005b.size() < this.f60004a.wsc_core_cache) {
                    a aVar2 = new a();
                    aVar2.f60025a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                    aVar2.f60026b = true;
                    this.f60005b.add(aVar2);
                    LogUtil.d("WhiteScreenMonitor", "Bitmap created");
                    return aVar2;
                }
                LogUtil.d("WhiteScreenMonitor", "Bitmap new");
                a aVar3 = new a();
                aVar3.f60025a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                aVar3.f60026b = true;
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
                if (this.f60005b != null && this.f60005b.size() > 0) {
                    for (a aVar2 : this.f60005b) {
                        if (aVar2.f60025a == aVar.f60025a && !aVar2.f60025a.isRecycled() && aVar2.f60026b) {
                            aVar2.f60026b = false;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Released");
                            return;
                        }
                    }
                }
                if (aVar.f60025a != null && !aVar.f60025a.isRecycled()) {
                    LogUtil.d("WhiteScreenMonitor", "Bitmap Full Released");
                    aVar.f60025a.recycle();
                }
            }
        }
    }
}
