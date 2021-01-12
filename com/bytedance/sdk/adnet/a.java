package com.bytedance.sdk.adnet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.core.q;
import com.bytedance.sdk.adnet.core.r;
import com.bytedance.sdk.adnet.d.d;
import com.bytedance.sdk.adnet.d.g;
import java.io.File;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static String f5987b;
    private static boolean d = true;
    public static q pjX;
    private static b pjY;
    private static com.bytedance.sdk.adnet.c.a pjZ;

    public static o hU(Context context) {
        return n.hU(context);
    }

    public static o a(Context context, com.bytedance.sdk.adnet.e.a aVar) {
        return n.a(context, aVar);
    }

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(f5987b)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                f5987b = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            r.a(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return f5987b;
    }

    public static void a(q qVar) {
        pjX = qVar;
    }

    public static void a(b bVar) {
        pjY = bVar;
    }

    public static b eok() {
        if (pjY == null) {
            throw new IllegalArgumentException("sITTNetDepend is null");
        }
        return pjY;
    }

    public static void a(boolean z) {
        d = z;
    }

    public static boolean b() {
        return d;
    }

    public static void c() {
        d.a(d.a.DEBUG);
    }

    public static void a(com.bytedance.sdk.adnet.c.a aVar) {
        pjZ = aVar;
    }

    public static com.bytedance.sdk.adnet.c.a eol() {
        return pjZ;
    }

    public static void a(Context context, Application application, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        f.eor().a(context, g.b(context));
        if (g.a(context) || (!g.b(context) && z)) {
            com.bytedance.sdk.adnet.a.a.hV(context).c();
            com.bytedance.sdk.adnet.a.a.hV(context).a();
        }
        if (g.b(context)) {
            com.bytedance.sdk.adnet.a.a.hV(context);
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.adnet.a.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        a.a(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }
                });
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.sdk.adnet.a$2] */
    public static void a(Activity activity) {
        if (activity != null) {
            final Context applicationContext = activity.getApplicationContext();
            new Thread("load_config") { // from class: com.bytedance.sdk.adnet.a.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.adnet.a.a.hV(applicationContext).c();
                    com.bytedance.sdk.adnet.a.a.hV(applicationContext);
                    com.bytedance.sdk.adnet.a.a.b(applicationContext);
                }
            }.start();
        }
    }
}
