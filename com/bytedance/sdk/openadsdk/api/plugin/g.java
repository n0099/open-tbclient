package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import dalvik.system.DexClassLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements TTInitializer {

    /* renamed from: b  reason: collision with root package name */
    public volatile TTInitializer f38287b;

    /* renamed from: c  reason: collision with root package name */
    public static final Bundle f38286c = new Bundle();
    public static ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new a());

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        return com.bytedance.sdk.openadsdk.api.plugin.a.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            initCallback.fail(4201, "Only support >= 5.0");
            return;
        }
        f.a(context);
        if (this.f38287b != null) {
            this.f38287b.init(context, adConfig, initCallback);
        } else {
            a(context, adConfig, initCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        if (this.f38287b != null) {
            return this.f38287b.isInitSuccess();
        }
        return false;
    }

    public static void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return;
        }
        f38286c.putBundle(str, bundle);
    }

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {
        public final ThreadGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f38291b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38292c;

        public a() {
            this.f38291b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.f38292c = "tt_pangle_thread_pl_init";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.f38292c + this.f38291b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        public a(String str) {
            this.f38291b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.f38292c = str;
        }
    }

    public void a(final Context context, final AdConfig adConfig, final TTAdSdk.InitCallback initCallback) {
        a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.1
            @Override // java.lang.Runnable
            public void run() {
                TTInitializer a2 = g.this.a(context, adConfig);
                if (a2 != null) {
                    a2.init(context, adConfig, initCallback);
                    com.bytedance.sdk.openadsdk.api.plugin.a.a.a(g.this.f38287b.getAdManager());
                    e.a();
                    return;
                }
                initCallback.fail(4201, "No initializer");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTInitializer a(Context context, AdConfig adConfig) {
        if (this.f38287b == null) {
            synchronized (this) {
                if (this.f38287b == null) {
                    e.a(adConfig);
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Create initializer");
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f38287b = a(context);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("duration", Long.valueOf(currentTimeMillis2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    adConfig.setExtra("plugin", jSONObject);
                }
            }
        }
        return this.f38287b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager init(Context context, AdConfig adConfig) {
        throw new RuntimeException("Please use init(Context context, AdConfig config, TTAdSdk.InitCallback callback)!");
    }

    public static TTInitializer a(Context context) {
        DexClassLoader a2;
        try {
            a2 = f.a(context).a();
        } catch (Throwable th) {
            e.a(6, th.getMessage(), 0L);
            com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Create initializer failed: " + th);
        }
        if (a2 == null) {
            e.a(6, "Load plugin failed", 0L);
            com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Load plugin failed");
            return null;
        }
        Class<?> loadClass = a2.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new f.b());
        bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, f38286c);
        TTInitializer tTInitializer = (TTInitializer) loadClass.getDeclaredMethod("getInstance", Bundle.class).invoke(null, bundle);
        com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Create initializer success");
        return tTInitializer;
    }
}
