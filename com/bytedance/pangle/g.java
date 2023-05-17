package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public static volatile g d;
    public boolean a;
    public final List<ZeusPluginStateListener> b = new CopyOnWriteArrayList();
    public final List<ZeusPluginEventCallback> c = new ArrayList();
    public final Handler e = new Handler(Looper.getMainLooper());

    public static g a() {
        if (d == null) {
            synchronized (g.class) {
                if (d == null) {
                    d = new g();
                }
            }
        }
        return d;
    }

    private Object[] c() {
        Object[] objArr;
        synchronized (this.c) {
            if (!this.c.isEmpty()) {
                objArr = this.c.toArray();
            } else {
                objArr = null;
            }
        }
        if (objArr == null) {
            return new Object[0];
        }
        return objArr;
    }

    public static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        try {
            for (ProviderInfo providerInfo : Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers) {
                if (!TextUtils.isEmpty(providerInfo.authority)) {
                    if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ZeusConstants.e)) {
                        if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                            str = providerInfo.processName.split(":")[1];
                            if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                Zeus.getServerManagerHashMap().put(str, providerInfo);
                            }
                        }
                        str = "main";
                        if (Zeus.getServerManagerHashMap().get(str) != null) {
                        }
                        Zeus.getServerManagerHashMap().put(str, providerInfo);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final void a(final int i, final int i2, @Nullable final String str, final int i3, @Nullable final Throwable th) {
        Object[] c;
        for (final Object obj : c()) {
            this.e.post(new Runnable() { // from class: com.bytedance.pangle.g.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public final synchronized void a(Application application) {
        boolean z;
        if (this.a) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        a(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.bytedance.pangle.b.b a = com.bytedance.pangle.b.b.a();
            com.bytedance.pangle.b.a aVar = new com.bytedance.pangle.b.a() { // from class: com.bytedance.pangle.g.1
                @Override // com.bytedance.pangle.b.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    com.bytedance.pangle.log.c.a(str, jSONObject, jSONObject2, jSONObject3);
                }
            };
            synchronized (a.a) {
                a.a.add(aVar);
            }
            b.a();
            if (Build.VERSION.SDK_INT == 29) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                com.bytedance.pangle.c.e.a.execute(new Runnable() { // from class: com.bytedance.pangle.g.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            if (h.d()) {
                try {
                    FieldUtils.writeField(com.bytedance.pangle.c.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e) {
                    ZeusLogger.e(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            com.bytedance.pangle.receiver.b.a(application);
            this.a = true;
            a(3100, 0, null, -1, null);
            return;
        }
        throw new IllegalArgumentException("context must be not null !!!");
    }
}
