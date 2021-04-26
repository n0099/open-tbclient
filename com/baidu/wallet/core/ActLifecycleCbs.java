package com.baidu.wallet.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.lifecycle.SavedStateHandle;
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
    public static final String f24611b = "#invoke_config_impact_js_result";

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f24613d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public HandlerThread f24614e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f24615f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f24616g;

    /* renamed from: a  reason: collision with root package name */
    public static final String f24610a = ActLifecycleCbs.class.getName();

    /* renamed from: c  reason: collision with root package name */
    public static int f24612c = 30000;

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
        public a f24620a;

        /* renamed from: b  reason: collision with root package name */
        public long f24621b;

        /* renamed from: c  reason: collision with root package name */
        public long f24622c = System.currentTimeMillis();

        public b(a aVar, long j) {
            this.f24620a = aVar;
            this.f24621b = j;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final ActLifecycleCbs f24623a = new ActLifecycleCbs();
    }

    private void b() {
        this.f24615f.removeCallbacksAndMessages(null);
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
        return c.f24623a;
    }

    public void a(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this);
            HandlerThread handlerThread = new HandlerThread("poll");
            this.f24614e = handlerThread;
            handlerThread.start();
            this.f24615f = new Handler(this.f24614e.getLooper());
            com.baidu.wallet.core.a.a(application);
            LocalRouter.getInstance(application).route(application, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data(SavedStateHandle.KEYS, new String[]{"common", "multi-webview"}), new RouterCallback() { // from class: com.baidu.wallet.core.ActLifecycleCbs.1
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    LogUtil.d("jsHook", "routercb resultCode = " + i2);
                    PayStatisticsUtil.onEventWithValue(ActLifecycleCbs.f24611b, String.valueOf(i2));
                }
            });
        }
    }

    public void a(a aVar, long j) {
        if (aVar != null) {
            for (int i2 = 0; i2 < this.f24613d.size(); i2++) {
                b bVar = this.f24613d.get(i2);
                if (bVar != null && aVar == bVar.f24620a) {
                    bVar.f24621b = j;
                    return;
                }
            }
            this.f24613d.add(new b(aVar, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, FROM from) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f24613d != null) {
            for (int i2 = 0; i2 < this.f24613d.size(); i2++) {
                b bVar = this.f24613d.get(i2);
                if (bVar != null && currentTimeMillis - bVar.f24622c >= bVar.f24621b && bVar.f24620a.onInvoke(context, from)) {
                    bVar.f24622c = currentTimeMillis;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity) {
        if (this.f24616g == null) {
            this.f24616g = new Runnable() { // from class: com.baidu.wallet.core.ActLifecycleCbs.2
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.d("poll", "任务轮询30s一次");
                    ActLifecycleCbs.this.a(activity, FROM.POLL);
                    ActLifecycleCbs.this.a(activity);
                }
            };
        }
        this.f24615f.postDelayed(this.f24616g, f24612c);
    }
}
