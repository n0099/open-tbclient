package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile cn pbW;
    @SuppressLint({"StaticFieldLeak"})
    public static m pbX;
    private static volatile h pbZ;
    public static f pcb;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5793b = true;
    private static boolean c = false;
    private static ao pbY = new ao();
    public static ConcurrentHashMap<String, String> pca = new ConcurrentHashMap<>(4);

    public static void a(@NonNull Context context, @NonNull l lVar) {
        if (!au.f5786b && Looper.myLooper() != Looper.getMainLooper()) {
            au.a(new RuntimeException("Wrong thread!"));
        } else if (pbW != null) {
            au.a(new RuntimeException("Init Twice!"));
            return;
        } else if (lVar.elv() == null) {
            au.a(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        bx elC = bx.elC();
        cn cnVar = new cn(application, lVar);
        m mVar = new m(application, cnVar);
        elC.a(application, cnVar, mVar, new bs(lVar.elj()));
        pbW = cnVar;
        pbX = mVar;
        au.d("Inited", null);
    }

    public static void flush() {
        bx.a();
    }

    public static h ekS() {
        return pbZ;
    }

    public static f ekT() {
        return pcb;
    }

    public static void H(HashMap<String, Object> hashMap) {
        if (pbX != null) {
            pbX.a(hashMap);
        }
    }

    public static String ekU() {
        if (pbX != null) {
            return pbX.q();
        }
        return null;
    }

    @Nullable
    public static JSONObject ekV() {
        if (pbW != null) {
            return pbW.elO();
        }
        return null;
    }

    @Nullable
    public static String ekW() {
        if (pbW != null) {
            return pbW.t();
        }
        return null;
    }

    public static <T> T C(String str, T t) {
        if (pbX != null) {
            return (T) pbX.D(str, t);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [311=4] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] Xs(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            if (ekX()) {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(str.getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    try {
                        au.a(th);
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e) {
                                au.a(e);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!ekX()) {
                        }
                    } catch (Throwable th2) {
                        GZIPOutputStream gZIPOutputStream2 = gZIPOutputStream;
                        if (gZIPOutputStream2 != null) {
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e2) {
                                au.a(e2);
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                byteArrayOutputStream.write(str.getBytes("UTF-8"));
                gZIPOutputStream = null;
            }
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (IOException e3) {
                    au.a(e3);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        return !ekX() ? TTEncryptUtils.a(byteArray2, byteArray2.length) : byteArray2;
    }

    public static void c(@NonNull String str, @NonNull String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            if (au.f5786b) {
                au.a("category or label is empty", null);
            }
            bx.a(new ak("" + str2 + str3, "2", 1));
            return;
        }
        bx.a(new ae(str, str2, str3, j, j2, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void onEvent(String str) {
        c("umeng", str, null, 0L, 0L, null);
    }

    public static void v(@NonNull String str, @Nullable JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            au.a("eventName is empty", null);
            bx.a(new ak("", "2", 1));
        }
        bx.a(new ag(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void k(@NonNull String str, @Nullable Bundle bundle) {
        Throwable th;
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th2) {
                        th = th2;
                        jSONObject = jSONObject2;
                        au.a(th);
                        v(str, jSONObject);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        v(str, jSONObject);
    }

    public static boolean ekX() {
        return true;
    }

    public static boolean ekY() {
        return f5793b;
    }

    public static String getDid() {
        return pbX != null ? pbX.g() : "";
    }

    public static String getSsid() {
        return pbX != null ? pbX.k() : "";
    }

    public static String ekZ() {
        return pbX != null ? pbX.l() : "";
    }

    public static void a(g gVar) {
        pbY.b(gVar);
    }

    @NonNull
    public static g ela() {
        return pbY;
    }

    public static int elb() {
        if (pbW != null) {
            return pbW.i();
        }
        return 0;
    }

    @AnyThread
    public static void a(@Nullable i iVar) {
        ba.b(iVar);
    }

    public static l elc() {
        if (pbW != null) {
            return pbW.elS();
        }
        return null;
    }
}
