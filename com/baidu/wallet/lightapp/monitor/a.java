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
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.JsonUtils;
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

    /* renamed from: a  reason: collision with root package name */
    public WhiteScreenConfig f24838a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0258a> f24839b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f24840c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f24841d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24842e;

    /* renamed from: f  reason: collision with root package name */
    public String f24843f;

    /* renamed from: com.baidu.wallet.lightapp.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0258a {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f24861a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f24862b;

        public C0258a() {
            this.f24861a = null;
            this.f24862b = false;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f24864a = new a();
    }

    public void b() {
        this.f24841d.removeCallbacksAndMessages(null);
        List<C0258a> list = this.f24839b;
        if (list != null) {
            list.clear();
        }
    }

    public a() {
        this.f24839b = new CopyOnWriteArrayList();
        this.f24841d = new Handler(Looper.getMainLooper());
    }

    private boolean b(Bitmap bitmap, Rect rect, boolean z, int i) {
        Rect[] a2 = a(rect.width(), rect.height(), 3, 3);
        Iterator<Integer> it = a(this.f24838a.wsc_simple_count, new int[0]).iterator();
        while (it.hasNext()) {
            Rect rect2 = a2[it.next().intValue()];
            for (int i2 = rect2.left + rect.left; i2 < rect2.right + rect.left; i2++) {
                for (int i3 = rect2.top + rect.top; i3 < rect2.bottom + rect.top; i3++) {
                    int pixel = bitmap.getPixel(i2, i3);
                    if (z) {
                        bitmap.setPixel(i2, i3, -16711936);
                    }
                    if (i == 0) {
                        i = pixel;
                    } else if (pixel != i) {
                        LogUtil.d("WhiteScreenMonitor", "diff(" + i2 + "," + i3 + "):" + pixel + " != " + i);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static a a() {
        return b.f24864a;
    }

    private void a(Context context) {
        if (this.f24842e) {
            return;
        }
        File externalFilesDir = context.getExternalFilesDir("");
        if (externalFilesDir != null) {
            this.f24843f = externalFilesDir.getAbsolutePath();
        } else {
            this.f24843f = context.getFilesDir().getAbsolutePath();
        }
        String whiteScreenConfig = SdkInitResponse.getInstance().getWhiteScreenConfig(context);
        if (!TextUtils.isEmpty(whiteScreenConfig)) {
            try {
                this.f24838a = (WhiteScreenConfig) JsonUtils.fromJson(whiteScreenConfig, WhiteScreenConfig.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        WhiteScreenConfig whiteScreenConfig2 = this.f24838a;
        if (whiteScreenConfig2 == null || !whiteScreenConfig2.isValid()) {
            this.f24838a = new WhiteScreenConfig();
        }
        WhiteScreenConfig whiteScreenConfig3 = this.f24838a;
        if (!whiteScreenConfig3.wsc_enable && !whiteScreenConfig3.wsc_view_enable) {
            this.f24842e = true;
            return;
        }
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.baidu.wallet.lightapp.monitor.a.1

            /* renamed from: a  reason: collision with root package name */
            public AtomicInteger f24844a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "WhiteScreenMoniter #" + this.f24844a.getAndIncrement());
            }
        };
        WhiteScreenConfig whiteScreenConfig4 = this.f24838a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(whiteScreenConfig4.wsc_core_task, whiteScreenConfig4.wsc_max_task, whiteScreenConfig4.wsc_alive_time, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        this.f24840c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f24842e = true;
    }

    public void a(View view, String str, boolean z) {
        a(view, str, (String) null, z);
    }

    public void a(final View view, final String str, String str2, boolean z) {
        a(view.getContext());
        boolean z2 = view instanceof WebView;
        WhiteScreenConfig whiteScreenConfig = this.f24838a;
        if (z2) {
            if (!whiteScreenConfig.wsc_enable) {
                return;
            }
        } else if (!whiteScreenConfig.wsc_view_enable) {
            return;
        }
        if (z2) {
            this.f24841d.removeCallbacksAndMessages(null);
            Runnable runnable = new Runnable() { // from class: com.baidu.wallet.lightapp.monitor.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a((WebView) view, str);
                }
            };
            Handler handler = this.f24841d;
            WhiteScreenConfig whiteScreenConfig2 = this.f24838a;
            handler.postDelayed(runnable, z ? whiteScreenConfig2.wsc_delay_time : whiteScreenConfig2.wsc_wait_time);
            return;
        }
        a(view, str2, str);
    }

    private void a(final View view, final String str, final String str2) {
        LogUtil.d("WhiteScreenMonitor", "START DETECT");
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            this.f24840c.execute(new Runnable() { // from class: com.baidu.wallet.lightapp.monitor.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    ArrayList a2 = aVar.a(aVar.f24838a.wsc_area_detect, 4, 0);
                    boolean a3 = a.this.a(createBitmap, a2);
                    String str3 = "" + (System.currentTimeMillis() - currentTimeMillis);
                    DXMSdkSAUtils.onEventWithValues("White_View_Detected", Arrays.asList(str, "" + a3, str2, a.this.a(a2), str3));
                    PayStatisticsUtil.onEventWithValues("White_View_Detected", Arrays.asList(str, "" + a3, str2, a.this.a(a2), str3));
                    a.this.a(createBitmap);
                    LogUtil.d("WhiteScreenMonitor", "WhiteView:" + str + " " + a3 + " " + str2 + " " + a.this.a(a2));
                    StringBuilder sb = new StringBuilder();
                    sb.append("TIME COST:");
                    sb.append(str3);
                    LogUtil.d("WhiteScreenMonitor", sb.toString());
                }
            });
        } catch (Exception e2) {
            LogUtil.d("WhiteScreenMonitor", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final WebView webView, final String str) {
        LogUtil.d("WhiteScreenMonitor", "START DETECT");
        final long currentTimeMillis = System.currentTimeMillis();
        final String url = webView.getUrl();
        try {
            final Bitmap a2 = a(webView);
            this.f24840c.execute(new Runnable() { // from class: com.baidu.wallet.lightapp.monitor.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    ArrayList a3 = aVar.a(aVar.f24838a.wsc_area_detect, 4, 0);
                    boolean a4 = a.this.a(a2, a3);
                    String str2 = "" + (System.currentTimeMillis() - currentTimeMillis);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, Arrays.asList(CheckUtils.stripUrlParams(url), "" + a4, str, a.this.a(a3), str2));
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, Arrays.asList(CheckUtils.stripUrlParams(url), "" + a4, str, a.this.a(a3), str2));
                    a.this.a(a2);
                    LogUtil.d("WhiteScreenMonitor", "WhiteScreen:" + CheckUtils.stripUrlParams(url) + " " + a4 + " " + str + " " + a.this.a(a3));
                    StringBuilder sb = new StringBuilder();
                    sb.append("TIME COST:");
                    sb.append(str2);
                    LogUtil.d("WhiteScreenMonitor", sb.toString());
                }
            });
        } catch (Exception e2) {
            LogUtil.d("WhiteScreenMonitor", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Integer> a(int i, int... iArr) {
        i = (i < 1 || i > 9) ? 9 : 9;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i2 : iArr) {
            if (i2 < 9) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        while (arrayList.size() < i) {
            int nextInt = new Random().nextInt(9);
            if (!arrayList.contains(Integer.valueOf(nextInt))) {
                arrayList.add(Integer.valueOf(nextInt));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<Integer> arrayList) {
        Iterator<Integer> it;
        String str = "";
        while (arrayList.iterator().hasNext()) {
            str = str + it.next();
        }
        return str;
    }

    private Bitmap a(WebView webView) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap a2 = a(webView.getWidth(), webView.getHeight());
        webView.draw(new Canvas(a2));
        LogUtil.d("WhiteScreenMonitor", "captureWebView:" + (System.currentTimeMillis() - currentTimeMillis));
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Bitmap bitmap, ArrayList<Integer> arrayList) {
        if (!a(bitmap, new Rect((bitmap.getWidth() / 2) - 1, 0, (bitmap.getWidth() / 2) + 1, bitmap.getHeight()), false, 0)) {
            LogUtil.d("WhiteScreenMonitor", "Fast detect: false");
            return false;
        }
        int pixel = bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Rect[] a2 = a(bitmap.getWidth(), bitmap.getHeight(), 3, 3);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i < this.f24838a.wsc_general_detect) {
                z = a(bitmap, a2[arrayList.get(i).intValue()], false, pixel);
            } else {
                z = b(bitmap, a2[arrayList.get(i).intValue()], false, pixel);
            }
            LogUtil.d("WhiteScreenMonitor", "Area(" + arrayList.get(i) + "):" + z);
            if (!z) {
                break;
            }
        }
        return z;
    }

    private Rect[] a(int i, int i2, int i3, int i4) {
        Rect[] rectArr = new Rect[i3 * i4];
        float f2 = i / i4;
        float f3 = i2 / i3;
        for (int i5 = 0; i5 < i3; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                float f4 = i6 * f2;
                float f5 = i5 * f3;
                rectArr[(i5 * i4) + i6] = new Rect((int) f4, (int) f5, (int) (f4 + f2), (int) (f5 + f3));
            }
        }
        return rectArr;
    }

    private boolean a(Bitmap bitmap, Rect rect, boolean z, int i) {
        for (int i2 = rect.left; i2 < rect.right; i2++) {
            for (int i3 = rect.top; i3 < rect.bottom; i3++) {
                int pixel = bitmap.getPixel(i2, i3);
                if (z) {
                    bitmap.setPixel(i2, i3, -16711936);
                }
                if (i == 0) {
                    i = pixel;
                } else if (pixel != i) {
                    LogUtil.d("WhiteScreenMonitor", "diff(" + i2 + "," + i3 + "):" + pixel + " != " + i);
                    return false;
                }
            }
        }
        return true;
    }

    private synchronized Bitmap a(int i, int i2) {
        if (this.f24839b != null && this.f24839b.size() > 0) {
            for (C0258a c0258a : this.f24839b) {
                if (c0258a.f24861a != null && !c0258a.f24861a.isRecycled() && !c0258a.f24862b && c0258a.f24861a.getWidth() == i && c0258a.f24861a.getHeight() == i2) {
                    c0258a.f24862b = true;
                    LogUtil.d("WhiteScreenMonitor", "Bitmap Recycled");
                    return c0258a.f24861a;
                }
            }
        }
        if (this.f24839b.size() < this.f24838a.wsc_core_cache) {
            C0258a c0258a2 = new C0258a();
            c0258a2.f24861a = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
            c0258a2.f24862b = true;
            this.f24839b.add(c0258a2);
            LogUtil.d("WhiteScreenMonitor", "Bitmap created");
            return c0258a2.f24861a;
        }
        LogUtil.d("WhiteScreenMonitor", "Bitmap new");
        return Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Bitmap bitmap) {
        if (this.f24839b != null && this.f24839b.size() > 0) {
            for (C0258a c0258a : this.f24839b) {
                if (c0258a.f24861a == bitmap && !c0258a.f24861a.isRecycled() && c0258a.f24862b) {
                    c0258a.f24862b = false;
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
