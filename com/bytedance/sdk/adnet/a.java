package com.bytedance.sdk.adnet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.core.q;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.openadsdk.j.e;
import java.io.File;
/* loaded from: classes6.dex */
public class a {
    private static String b;
    private static boolean d = true;
    public static p pwT;
    private static b pwU;
    private static com.bytedance.sdk.adnet.c.a pwV;

    public static n hW(Context context) {
        return m.hW(context);
    }

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(b)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                b = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            q.a(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return b;
    }

    public static void a(b bVar) {
        pwU = bVar;
    }

    public static b eqR() {
        if (pwU == null) {
            throw new IllegalArgumentException("sITTNetDepend is null");
        }
        return pwU;
    }

    public static void a(boolean z) {
        d = z;
    }

    public static boolean b() {
        return d;
    }

    public static void c() {
        c.a(c.a.DEBUG);
    }

    public static void a(com.bytedance.sdk.adnet.c.a aVar) {
        pwV = aVar;
    }

    public static com.bytedance.sdk.adnet.c.a eqS() {
        return pwV;
    }

    public static void a(Context context, Application application, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        f.eqZ().a(context, com.bytedance.sdk.adnet.d.f.b(context));
        if (com.bytedance.sdk.adnet.d.f.a(context) || (!com.bytedance.sdk.adnet.d.f.b(context) && z)) {
            com.bytedance.sdk.adnet.a.a.hX(context).c();
            com.bytedance.sdk.adnet.a.a.hX(context).a();
        }
        if (com.bytedance.sdk.adnet.d.f.b(context)) {
            com.bytedance.sdk.adnet.a.a.hX(context);
        }
    }

    public static void a(Activity activity) {
        if (activity != null) {
            final Context applicationContext = activity.getApplicationContext();
            e.a().execute(new Runnable() { // from class: com.bytedance.sdk.adnet.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.adnet.a.a.hX(applicationContext).c();
                    com.bytedance.sdk.adnet.a.a.hX(applicationContext);
                    com.bytedance.sdk.adnet.a.a.b(applicationContext);
                }
            });
        }
    }
}
