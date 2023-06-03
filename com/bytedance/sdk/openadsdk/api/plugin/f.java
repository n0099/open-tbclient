package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.e;
import dalvik.system.DexClassLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f implements TTInitializer {
    public volatile TTInitializer b;
    public static final Bundle c = new Bundle();
    public static ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new a());

    /* loaded from: classes9.dex */
    public static class a implements ThreadFactory {
        public final ThreadGroup a;
        public final AtomicInteger b;
        public final String c;

        public a() {
            this.b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.c = "tt_pangle_thread_pl_init";
        }

        public a(String str) {
            this.b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.c = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        return com.bytedance.sdk.openadsdk.api.plugin.a.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        if (this.b != null) {
            return this.b.isInitSuccess();
        }
        return false;
    }

    public static TTInitializer a(Context context) {
        DexClassLoader b;
        try {
            b = e.a(context).b();
        } catch (Throwable th) {
            if (th instanceof c) {
                c cVar = th;
                d.a(cVar.a(), cVar.getMessage(), 0L);
            } else {
                d.a(6, th.getMessage(), 0L);
            }
            com.bytedance.sdk.openadsdk.api.a.e("TTPluginManager", "Create initializer failed: " + th);
        }
        if (b == null) {
            d.a(6, "Load plugin failed", 0L);
            com.bytedance.sdk.openadsdk.api.a.e("TTPluginManager", "Load plugin failed");
            return null;
        }
        Class<?> loadClass = b.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new e.b());
        bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, c);
        TTInitializer tTInitializer = (TTInitializer) loadClass.getDeclaredMethod("getInstance", Bundle.class).invoke(null, bundle);
        com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", "Create initializer success");
        return tTInitializer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTInitializer a(Context context, AdConfig adConfig) {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    d.a(adConfig);
                    com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", "Create initializer");
                    long currentTimeMillis = System.currentTimeMillis();
                    this.b = a(context);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("duration", Long.valueOf(currentTimeMillis2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adConfig.setExtra("plugin", jSONObject);
                }
            }
        }
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            initCallback.fail(4201, "Only support >= 5.0");
            return;
        }
        e.a(context).a();
        if (this.b != null) {
            this.b.init(context, adConfig, initCallback);
        } else {
            a(context, adConfig, initCallback);
        }
    }

    private void a(final Context context, final AdConfig adConfig, final TTAdSdk.InitCallback initCallback) {
        a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
            @Override // java.lang.Runnable
            public void run() {
                TTInitializer a2 = f.this.a(context, adConfig);
                if (a2 != null) {
                    com.bytedance.sdk.openadsdk.api.plugin.a.a.a(a2.getAdManager());
                    a2.init(context, adConfig, initCallback);
                    d.a();
                    a2.getAdManager().register(com.bytedance.sdk.openadsdk.a.b.a());
                    return;
                }
                initCallback.fail(4201, "No initializer");
            }
        });
    }

    public static void a(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null) {
            c.putBundle(str, bundle);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager init(Context context, AdConfig adConfig) {
        throw new RuntimeException("Please use init(Context context, AdConfig config, TTAdSdk.InitCallback callback)!");
    }
}
