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
    public static m pgA;
    private static volatile h pgC;
    public static f pgE;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile cn pgz;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6093b = true;
    private static boolean c = false;
    private static ao pgB = new ao();
    public static ConcurrentHashMap<String, String> pgD = new ConcurrentHashMap<>(4);

    public static void a(@NonNull Context context, @NonNull l lVar) {
        if (!au.f6086b && Looper.myLooper() != Looper.getMainLooper()) {
            au.a(new RuntimeException("Wrong thread!"));
        } else if (pgz != null) {
            au.a(new RuntimeException("Init Twice!"));
            return;
        } else if (lVar.epr() == null) {
            au.a(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        bx epy = bx.epy();
        cn cnVar = new cn(application, lVar);
        m mVar = new m(application, cnVar);
        epy.a(application, cnVar, mVar, new bs(lVar.epf()));
        pgz = cnVar;
        pgA = mVar;
        au.d("Inited", null);
    }

    public static void flush() {
        bx.a();
    }

    public static h eoO() {
        return pgC;
    }

    public static f eoP() {
        return pgE;
    }

    public static void H(HashMap<String, Object> hashMap) {
        if (pgA != null) {
            pgA.a(hashMap);
        }
    }

    public static String eoQ() {
        if (pgA != null) {
            return pgA.q();
        }
        return null;
    }

    @Nullable
    public static JSONObject eoR() {
        if (pgz != null) {
            return pgz.epK();
        }
        return null;
    }

    @Nullable
    public static String eoS() {
        if (pgz != null) {
            return pgz.t();
        }
        return null;
    }

    public static <T> T C(String str, T t) {
        if (pgA != null) {
            return (T) pgA.D(str, t);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [311=4] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] YA(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            if (eoT()) {
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
                        if (!eoT()) {
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
        return !eoT() ? TTEncryptUtils.a(byteArray2, byteArray2.length) : byteArray2;
    }

    public static void c(@NonNull String str, @NonNull String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            if (au.f6086b) {
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

    public static void j(@NonNull String str, @Nullable Bundle bundle) {
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

    public static boolean eoT() {
        return true;
    }

    public static boolean eoU() {
        return f6093b;
    }

    public static String getDid() {
        return pgA != null ? pgA.g() : "";
    }

    public static String getSsid() {
        return pgA != null ? pgA.k() : "";
    }

    public static String eoV() {
        return pgA != null ? pgA.l() : "";
    }

    public static void a(g gVar) {
        pgB.b(gVar);
    }

    @NonNull
    public static g eoW() {
        return pgB;
    }

    public static int eoX() {
        if (pgz != null) {
            return pgz.i();
        }
        return 0;
    }

    @AnyThread
    public static void a(@Nullable i iVar) {
        ba.b(iVar);
    }

    public static l eoY() {
        if (pgz != null) {
            return pgz.epO();
        }
        return null;
    }
}
