package com.baidu.wallet.lightapp.monitor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WhiteScreenConfig f25780a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0275a> f25781b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f25782c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f25783d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25784e;

    /* renamed from: f  reason: collision with root package name */
    public String f25785f;

    /* renamed from: com.baidu.wallet.lightapp.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0275a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f25803a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f25804b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f25805c;

        public C0275a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25805c = aVar;
            this.f25803a = null;
            this.f25804b = false;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f25806a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1780624781, "Lcom/baidu/wallet/lightapp/monitor/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1780624781, "Lcom/baidu/wallet/lightapp/monitor/a$b;");
                    return;
                }
            }
            f25806a = new a();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25783d.removeCallbacksAndMessages(null);
            List<C0275a> list = this.f25781b;
            if (list != null) {
                list.clear();
            }
        }
    }

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
        this.f25781b = new CopyOnWriteArrayList();
        this.f25783d = new Handler(Looper.getMainLooper());
    }

    private boolean b(Bitmap bitmap, Rect rect, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, this, new Object[]{bitmap, rect, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Rect[] a2 = a(rect.width(), rect.height(), 3, 3);
            Iterator<Integer> it = a(this.f25780a.wsc_simple_count, new int[0]).iterator();
            while (it.hasNext()) {
                Rect rect2 = a2[it.next().intValue()];
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.f25806a : (a) invokeV.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, context) == null) || this.f25784e) {
            return;
        }
        File externalFilesDir = context.getExternalFilesDir("");
        if (externalFilesDir != null) {
            this.f25785f = externalFilesDir.getAbsolutePath();
        } else {
            this.f25785f = context.getFilesDir().getAbsolutePath();
        }
        String whiteScreenConfig = SdkInitResponse.getInstance().getWhiteScreenConfig(context);
        if (!TextUtils.isEmpty(whiteScreenConfig)) {
            try {
                this.f25780a = (WhiteScreenConfig) JsonUtils.fromJson(whiteScreenConfig, WhiteScreenConfig.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        WhiteScreenConfig whiteScreenConfig2 = this.f25780a;
        if (whiteScreenConfig2 == null || !whiteScreenConfig2.isValid()) {
            this.f25780a = new WhiteScreenConfig();
        }
        WhiteScreenConfig whiteScreenConfig3 = this.f25780a;
        if (!whiteScreenConfig3.wsc_enable && !whiteScreenConfig3.wsc_view_enable) {
            this.f25784e = true;
            return;
        }
        ThreadFactory threadFactory = new ThreadFactory(this) { // from class: com.baidu.wallet.lightapp.monitor.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public AtomicInteger f25786a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f25787b;

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
                this.f25787b = this;
                this.f25786a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WhiteScreenMoniter #" + this.f25786a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        WhiteScreenConfig whiteScreenConfig4 = this.f25780a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(whiteScreenConfig4.wsc_core_task, whiteScreenConfig4.wsc_max_task, whiteScreenConfig4.wsc_alive_time, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        this.f25782c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f25784e = true;
    }

    public void a(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, str, z) == null) {
            a(view, str, (String) null, z);
        }
    }

    public void a(View view, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, str2, Boolean.valueOf(z)}) == null) {
            a(view.getContext());
            boolean z2 = view instanceof WebView;
            WhiteScreenConfig whiteScreenConfig = this.f25780a;
            if (z2) {
                if (!whiteScreenConfig.wsc_enable) {
                    return;
                }
            } else if (!whiteScreenConfig.wsc_view_enable) {
                return;
            }
            if (z2) {
                this.f25783d.removeCallbacksAndMessages(null);
                Runnable runnable = new Runnable(this, view, str) { // from class: com.baidu.wallet.lightapp.monitor.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ View f25788a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f25789b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f25790c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, view, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25790c = this;
                        this.f25788a = view;
                        this.f25789b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f25790c.a((WebView) this.f25788a, this.f25789b);
                        }
                    }
                };
                Handler handler = this.f25783d;
                WhiteScreenConfig whiteScreenConfig2 = this.f25780a;
                handler.postDelayed(runnable, z ? whiteScreenConfig2.wsc_delay_time : whiteScreenConfig2.wsc_wait_time);
                return;
            }
            a(view, str2, str);
        }
    }

    private void a(View view, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, this, view, str, str2) == null) {
            LogUtil.d("WhiteScreenMonitor", "START DETECT");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(createBitmap));
                this.f25782c.execute(new Runnable(this, createBitmap, currentTimeMillis, view, str2, str) { // from class: com.baidu.wallet.lightapp.monitor.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Bitmap f25791a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f25792b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ View f25793c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f25794d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f25795e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ a f25796f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, createBitmap, Long.valueOf(currentTimeMillis), view, str2, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25796f = this;
                        this.f25791a = createBitmap;
                        this.f25792b = currentTimeMillis;
                        this.f25793c = view;
                        this.f25794d = str2;
                        this.f25795e = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            a aVar = this.f25796f;
                            ArrayList a2 = aVar.a(aVar.f25780a.wsc_area_detect, 4, 0);
                            boolean a3 = this.f25796f.a(this.f25791a, a2);
                            String str3 = "" + (System.currentTimeMillis() - this.f25792b);
                            DXMSdkSAUtils.onEventWithValues("White_View_Detected", Arrays.asList(this.f25795e, "" + a3, this.f25794d, this.f25796f.a(a2), str3));
                            PayStatisticsUtil.onEventWithValues("White_View_Detected", Arrays.asList(this.f25795e, "" + a3, this.f25794d, this.f25796f.a(a2), str3));
                            this.f25796f.a(this.f25791a);
                            LogUtil.d("WhiteScreenMonitor", "WhiteView:" + this.f25795e + " " + a3 + " " + this.f25794d + " " + this.f25796f.a(a2));
                            StringBuilder sb = new StringBuilder();
                            sb.append("TIME COST:");
                            sb.append(str3);
                            LogUtil.d("WhiteScreenMonitor", sb.toString());
                        }
                    }
                });
            } catch (Exception e2) {
                LogUtil.d("WhiteScreenMonitor", e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, webView, str) == null) {
            LogUtil.d("WhiteScreenMonitor", "START DETECT");
            try {
                this.f25782c.execute(new Runnable(this, a(webView), System.currentTimeMillis(), webView, str, webView.getUrl()) { // from class: com.baidu.wallet.lightapp.monitor.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Bitmap f25797a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f25798b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ WebView f25799c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f25800d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f25801e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ a f25802f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, Long.valueOf(r8), webView, str, r12};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25802f = this;
                        this.f25797a = r7;
                        this.f25798b = r8;
                        this.f25799c = webView;
                        this.f25800d = str;
                        this.f25801e = r12;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            a aVar = this.f25802f;
                            ArrayList a2 = aVar.a(aVar.f25780a.wsc_area_detect, 4, 0);
                            boolean a3 = this.f25802f.a(this.f25797a, a2);
                            String str2 = "" + (System.currentTimeMillis() - this.f25798b);
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, Arrays.asList(CheckUtils.stripUrlParams(this.f25801e), "" + a3, this.f25800d, this.f25802f.a(a2), str2));
                            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, Arrays.asList(CheckUtils.stripUrlParams(this.f25801e), "" + a3, this.f25800d, this.f25802f.a(a2), str2));
                            this.f25802f.a(this.f25797a);
                            LogUtil.d("WhiteScreenMonitor", "WhiteScreen:" + CheckUtils.stripUrlParams(this.f25801e) + " " + a3 + " " + this.f25800d + " " + this.f25802f.a(a2));
                            StringBuilder sb = new StringBuilder();
                            sb.append("TIME COST:");
                            sb.append(str2);
                            LogUtil.d("WhiteScreenMonitor", sb.toString());
                        }
                    }
                });
            } catch (Exception e2) {
                LogUtil.d("WhiteScreenMonitor", e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Integer> a(int i2, int... iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, this, i2, iArr)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, arrayList)) == null) {
            String str = "";
            while (arrayList.iterator().hasNext()) {
                str = str + it.next();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private Bitmap a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, webView)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap a2 = a(webView.getWidth(), webView.getHeight());
            webView.draw(new Canvas(a2));
            LogUtil.d("WhiteScreenMonitor", "captureWebView:" + (System.currentTimeMillis() - currentTimeMillis));
            return a2;
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Bitmap bitmap, ArrayList<Integer> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, bitmap, arrayList)) == null) {
            if (!a(bitmap, new Rect((bitmap.getWidth() / 2) - 1, 0, (bitmap.getWidth() / 2) + 1, bitmap.getHeight()), false, 0)) {
                LogUtil.d("WhiteScreenMonitor", "Fast detect: false");
                return false;
            }
            int pixel = bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            Rect[] a2 = a(bitmap.getWidth(), bitmap.getHeight(), 3, 3);
            boolean z = false;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 < this.f25780a.wsc_general_detect) {
                    z = a(bitmap, a2[arrayList.get(i2).intValue()], false, pixel);
                } else {
                    z = b(bitmap, a2[arrayList.get(i2).intValue()], false, pixel);
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

    private Rect[] a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65555, this, i2, i3, i4, i5)) == null) {
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

    private boolean a(Bitmap bitmap, Rect rect, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{bitmap, rect, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
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

    private synchronized Bitmap a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i2, i3)) == null) {
            synchronized (this) {
                if (this.f25781b != null && this.f25781b.size() > 0) {
                    for (C0275a c0275a : this.f25781b) {
                        if (c0275a.f25803a != null && !c0275a.f25803a.isRecycled() && !c0275a.f25804b && c0275a.f25803a.getWidth() == i2 && c0275a.f25803a.getHeight() == i3) {
                            c0275a.f25804b = true;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Recycled");
                            return c0275a.f25803a;
                        }
                    }
                }
                if (this.f25781b.size() < this.f25780a.wsc_core_cache) {
                    C0275a c0275a2 = new C0275a();
                    c0275a2.f25803a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                    c0275a2.f25804b = true;
                    this.f25781b.add(c0275a2);
                    LogUtil.d("WhiteScreenMonitor", "Bitmap created");
                    return c0275a2.f25803a;
                }
                LogUtil.d("WhiteScreenMonitor", "Bitmap new");
                return Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bitmap) == null) {
            synchronized (this) {
                if (this.f25781b != null && this.f25781b.size() > 0) {
                    for (C0275a c0275a : this.f25781b) {
                        if (c0275a.f25803a == bitmap && !c0275a.f25803a.isRecycled() && c0275a.f25804b) {
                            c0275a.f25804b = false;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Released");
                            return;
                        }
                    }
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    LogUtil.d("WhiteScreenMonitor", "Bitmap Full Released");
                    bitmap.recycle();
                }
            }
        }
    }
}
