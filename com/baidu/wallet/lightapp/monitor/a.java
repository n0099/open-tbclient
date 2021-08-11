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
import com.baidu.apollon.utils.CheckUtils;
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
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WhiteScreenConfig f61664a;

    /* renamed from: b  reason: collision with root package name */
    public List<C1838a> f61665b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f61666c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f61667d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61668e;

    /* renamed from: f  reason: collision with root package name */
    public String f61669f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61670g;

    /* renamed from: com.baidu.wallet.lightapp.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1838a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f61689a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61690b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f61691c;

        public C1838a(a aVar) {
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
            this.f61691c = aVar;
            this.f61689a = null;
            this.f61690b = false;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f61692a;
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
            f61692a = new a();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61667d.removeCallbacksAndMessages(null);
            List<C1838a> list = this.f61665b;
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
        this.f61665b = new CopyOnWriteArrayList();
        this.f61667d = new Handler(Looper.getMainLooper());
    }

    private boolean b(Bitmap bitmap, Rect rect, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, this, new Object[]{bitmap, rect, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Rect[] a2 = a(rect.width(), rect.height(), 3, 3);
            Iterator<Integer> it = a(this.f61664a.wsc_simple_count, new int[0]).iterator();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.f61692a : (a) invokeV.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, context) == null) || this.f61668e) {
            return;
        }
        File externalFilesDir = context.getExternalFilesDir("");
        this.f61670g = DxmApplicationContextImpl.getApplicationContext(context);
        if (externalFilesDir != null) {
            this.f61669f = externalFilesDir.getAbsolutePath();
        } else {
            this.f61669f = context.getFilesDir().getAbsolutePath();
        }
        String whiteScreenConfig = SdkInitResponse.getInstance().getWhiteScreenConfig(context);
        if (!TextUtils.isEmpty(whiteScreenConfig)) {
            try {
                this.f61664a = (WhiteScreenConfig) JsonUtils.fromJson(whiteScreenConfig, WhiteScreenConfig.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        WhiteScreenConfig whiteScreenConfig2 = this.f61664a;
        if (whiteScreenConfig2 == null || !whiteScreenConfig2.isValid()) {
            this.f61664a = new WhiteScreenConfig();
        }
        WhiteScreenConfig whiteScreenConfig3 = this.f61664a;
        if (!whiteScreenConfig3.wsc_enable && !whiteScreenConfig3.wsc_view_enable) {
            this.f61668e = true;
            return;
        }
        ThreadFactory threadFactory = new ThreadFactory(this) { // from class: com.baidu.wallet.lightapp.monitor.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public AtomicInteger f61671a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f61672b;

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
                this.f61672b = this;
                this.f61671a = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WhiteScreenMoniter #" + this.f61671a.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        WhiteScreenConfig whiteScreenConfig4 = this.f61664a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(whiteScreenConfig4.wsc_core_task, whiteScreenConfig4.wsc_max_task, whiteScreenConfig4.wsc_alive_time, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        this.f61666c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f61668e = true;
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
            WhiteScreenConfig whiteScreenConfig = this.f61664a;
            if (z2) {
                if (!whiteScreenConfig.wsc_enable) {
                    return;
                }
            } else if (!whiteScreenConfig.wsc_view_enable) {
                return;
            }
            if (z2) {
                this.f61667d.removeCallbacksAndMessages(null);
                Runnable runnable = new Runnable(this, view, str) { // from class: com.baidu.wallet.lightapp.monitor.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ View f61673a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f61674b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f61675c;

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
                        this.f61675c = this;
                        this.f61673a = view;
                        this.f61674b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f61675c.a((WebView) this.f61673a, this.f61674b);
                        }
                    }
                };
                Handler handler = this.f61667d;
                WhiteScreenConfig whiteScreenConfig2 = this.f61664a;
                handler.postDelayed(runnable, z ? whiteScreenConfig2.wsc_delay_time : whiteScreenConfig2.wsc_wait_time);
                return;
            }
            a(view, str2, str);
        }
    }

    private void a(View view, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, view, str, str2) == null) {
            LogUtil.d("WhiteScreenMonitor", "START DETECT");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(createBitmap));
                this.f61666c.execute(new Runnable(this, createBitmap, currentTimeMillis, view, str2, str) { // from class: com.baidu.wallet.lightapp.monitor.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Bitmap f61676a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f61677b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ View f61678c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f61679d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f61680e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ a f61681f;

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
                        this.f61681f = this;
                        this.f61676a = createBitmap;
                        this.f61677b = currentTimeMillis;
                        this.f61678c = view;
                        this.f61679d = str2;
                        this.f61680e = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            a aVar = this.f61681f;
                            ArrayList a2 = aVar.a(aVar.f61664a.wsc_area_detect, 4, 0);
                            boolean a3 = this.f61681f.a(this.f61676a, a2);
                            String str3 = "" + (System.currentTimeMillis() - this.f61677b);
                            DXMSdkSAUtils.onEventWithValues("White_View_Detected", Arrays.asList(this.f61680e, "" + a3, this.f61679d, this.f61681f.a(a2), str3));
                            this.f61681f.a(this.f61676a);
                            LogUtil.d("WhiteScreenMonitor", "WhiteView:" + this.f61680e + " " + a3 + " " + this.f61679d + " " + this.f61681f.a(a2));
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
        if (interceptable == null || interceptable.invokeLL(65550, this, webView, str) == null) {
            LogUtil.d("WhiteScreenMonitor", "START DETECT");
            long currentTimeMillis = System.currentTimeMillis();
            String url = webView.getUrl();
            try {
                this.f61666c.execute(new Runnable(this, a(webView), currentTimeMillis, webView, str, url, a(url)) { // from class: com.baidu.wallet.lightapp.monitor.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Bitmap f61682a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f61683b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ WebView f61684c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f61685d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f61686e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ String f61687f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ a f61688g;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, Long.valueOf(currentTimeMillis), webView, str, url, r13};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61688g = this;
                        this.f61682a = r7;
                        this.f61683b = currentTimeMillis;
                        this.f61684c = webView;
                        this.f61685d = str;
                        this.f61686e = url;
                        this.f61687f = r13;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            a aVar = this.f61688g;
                            ArrayList a2 = aVar.a(aVar.f61664a.wsc_area_detect, 4, 0);
                            boolean a3 = this.f61688g.a(this.f61682a, a2);
                            String str2 = "" + (System.currentTimeMillis() - this.f61683b);
                            List asList = Arrays.asList(CheckUtils.stripUrlParams(this.f61686e), "" + a3, this.f61685d, this.f61688g.a(a2), str2, this.f61687f);
                            if (a3) {
                                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, asList);
                                HashMap hashMap = new HashMap(asList.size());
                                hashMap.put("pageUrl", CheckUtils.stripUrlParams(this.f61686e));
                                hashMap.put("tag", this.f61685d);
                                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.f61688g.a(a2));
                                hashMap.put("timeCost", str2);
                                hashMap.put("host", this.f61687f);
                                Tracker.send(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, hashMap, this.f61684c.getContext());
                            }
                            this.f61688g.a(this.f61682a);
                            LogUtil.d("WhiteScreenMonitor", "WhiteScreen:" + CheckUtils.stripUrlParams(this.f61686e) + " " + a3 + " " + this.f61685d + " " + this.f61688g.a(a2));
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

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                return new URL(str).getHost();
            } catch (MalformedURLException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, bitmap, arrayList)) == null) {
            if (!a(bitmap, new Rect((bitmap.getWidth() / 2) - 1, 0, (bitmap.getWidth() / 2) + 1, bitmap.getHeight()), false, 0)) {
                LogUtil.d("WhiteScreenMonitor", "Fast detect: false");
                return false;
            }
            int pixel = bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            Rect[] a2 = a(bitmap.getWidth(), bitmap.getHeight(), 3, 3);
            boolean z = false;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 < this.f61664a.wsc_general_detect) {
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
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65556, this, i2, i3, i4, i5)) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, this, new Object[]{bitmap, rect, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
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
                if (this.f61665b != null && this.f61665b.size() > 0) {
                    for (C1838a c1838a : this.f61665b) {
                        if (c1838a.f61689a != null && !c1838a.f61689a.isRecycled() && !c1838a.f61690b && c1838a.f61689a.getWidth() == i2 && c1838a.f61689a.getHeight() == i3) {
                            c1838a.f61690b = true;
                            LogUtil.d("WhiteScreenMonitor", "Bitmap Recycled");
                            return c1838a.f61689a;
                        }
                    }
                }
                if (this.f61665b.size() < this.f61664a.wsc_core_cache) {
                    C1838a c1838a2 = new C1838a();
                    c1838a2.f61689a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                    c1838a2.f61690b = true;
                    this.f61665b.add(c1838a2);
                    LogUtil.d("WhiteScreenMonitor", "Bitmap created");
                    return c1838a2.f61689a;
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
        if (interceptable == null || interceptable.invokeL(65548, this, bitmap) == null) {
            synchronized (this) {
                if (this.f61665b != null && this.f61665b.size() > 0) {
                    for (C1838a c1838a : this.f61665b) {
                        if (c1838a.f61689a == bitmap && !c1838a.f61689a.isRecycled() && c1838a.f61690b) {
                            c1838a.f61690b = false;
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
