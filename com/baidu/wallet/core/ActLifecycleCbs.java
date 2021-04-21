package com.baidu.wallet.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ActLifecycleCbs implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public static final String f23867b = "#invoke_config_impact_js_result";

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f23869d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public HandlerThread f23870e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f23871f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f23872g;

    /* renamed from: a  reason: collision with root package name */
    public static final String f23866a = ActLifecycleCbs.class.getName();

    /* renamed from: c  reason: collision with root package name */
    public static int f23868c = 30000;

    /* loaded from: classes5.dex */
    public enum FROM {
        RESUME,
        POLL
    }

    /* loaded from: classes5.dex */
    public interface a {
        boolean onInvoke(Context context, FROM from);
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f23876a;

        /* renamed from: b  reason: collision with root package name */
        public long f23877b;

        /* renamed from: c  reason: collision with root package name */
        public long f23878c = System.currentTimeMillis();

        public b(a aVar, long j) {
            this.f23876a = aVar;
            this.f23877b = j;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final ActLifecycleCbs f23879a = new ActLifecycleCbs();
    }

    private void b() {
        this.f23871f.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        LogUtil.d("poll", "onActivityPaused activity = " + activity.getLocalClassName());
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        LogUtil.d("poll", "onActivityResumed activity = " + activity.getLocalClassName());
        a(activity, FROM.RESUME);
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        com.baidu.wallet.core.a.a();
    }

    public static ActLifecycleCbs a() {
        return c.f23879a;
    }

    public void a(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this);
            HandlerThread handlerThread = new HandlerThread("poll");
            this.f23870e = handlerThread;
            handlerThread.start();
            this.f23871f = new Handler(this.f23870e.getLooper());
            com.baidu.wallet.core.a.a(application);
            LocalRouter.getInstance(application).route(application, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data("keys", new String[]{"common", "multi-webview"}), new RouterCallback() { // from class: com.baidu.wallet.core.ActLifecycleCbs.1
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap) {
                    LogUtil.d("jsHook", "routercb resultCode = " + i);
                    PayStatisticsUtil.onEventWithValue(ActLifecycleCbs.f23867b, String.valueOf(i));
                }
            });
        }
    }

    public void a(a aVar, long j) {
        if (aVar != null) {
            for (int i = 0; i < this.f23869d.size(); i++) {
                b bVar = this.f23869d.get(i);
                if (bVar != null && aVar == bVar.f23876a) {
                    bVar.f23877b = j;
                    return;
                }
            }
            this.f23869d.add(new b(aVar, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, FROM from) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f23869d != null) {
            for (int i = 0; i < this.f23869d.size(); i++) {
                b bVar = this.f23869d.get(i);
                if (bVar != null && currentTimeMillis - bVar.f23878c >= bVar.f23877b && bVar.f23876a.onInvoke(context, from)) {
                    bVar.f23878c = currentTimeMillis;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity) {
        if (this.f23872g == null) {
            this.f23872g = new Runnable() { // from class: com.baidu.wallet.core.ActLifecycleCbs.2
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.d("poll", "任务轮询30s一次");
                    ActLifecycleCbs.this.a(activity, FROM.POLL);
                    ActLifecycleCbs.this.a(activity);
                }
            };
        }
        this.f23871f.postDelayed(this.f23872g, f23868c);
    }
}
