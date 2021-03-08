package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.bd;
import com.bytedance.embedapplog.bi;
import com.bytedance.embedapplog.i;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class bh {
    private static String j;
    @Nullable
    private static i ppy;
    private boolean f;
    private final Context h;
    private Map<String, String> k;
    private Long l;
    private bl ppA;
    private bi ppz;
    private static final String b = bh.class.getSimpleName() + "#";

    /* renamed from: a  reason: collision with root package name */
    public static final String f3915a = b;
    private final ReentrantLock c = new ReentrantLock();
    private AtomicBoolean i = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(Context context) {
        this.h = context;
        this.ppz = bj.hV(context);
        if (this.ppz != null) {
            this.f = this.ppz.a(context);
        } else {
            this.f = false;
        }
        this.ppA = new bl(context);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE] complete} */
    @Nullable
    @WorkerThread
    public Map<String, String> ig(long j2) {
        if (!this.f) {
            return null;
        }
        a();
        bb.a(f3915a, "Oaid#getOaid timeoutMills=" + j2);
        if (this.k == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = false;
            try {
                try {
                    z = this.c.tryLock(j2, TimeUnit.MILLISECONDS);
                    bb.b(f3915a, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                    if (z) {
                        this.c.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (z) {
                        this.c.unlock();
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    this.c.unlock();
                }
                throw th;
            }
        }
        bb.a(f3915a, "Oaid#getOaid return apiMap=" + this.k);
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @AnyThread
    public static void b(@Nullable i iVar) {
        ppy = iVar;
        if (j != null) {
            a(new i.a(j));
        }
    }

    private static void a(@Nullable i.a aVar) {
        i iVar;
        if (aVar != null && (iVar = ppy) != null) {
            iVar.onOaidLoaded(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(Map<K, V> map, K k, V v) {
        if (k != null && v != null) {
            map.put(k, v);
        }
    }

    public void a() {
        if (this.i.compareAndSet(false, true)) {
            a(new Runnable() { // from class: com.bytedance.embedapplog.bh.1
                @Override // java.lang.Runnable
                public void run() {
                    bh.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String str;
        bk bkVar = null;
        bb.b(f3915a, "Oaid#initOaid");
        try {
            this.c.lock();
            bb.b(f3915a, "Oaid#initOaid exec");
            bk eom = this.ppA.eom();
            bb.b(f3915a, "Oaid#initOaid fetch=" + eom);
            if (eom != null) {
                j = eom.f3916a;
                this.k = eom.a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> hU = hU(this.h);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (hU.first != null) {
                int i = -1;
                if (eom != null) {
                    str = eom.b;
                    i = eom.ppC.intValue() + 1;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                bkVar = new bk((String) hU.first, str, (Boolean) hU.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i <= 0 ? 1 : i), this.l);
                this.ppA.a(bkVar);
            }
            if (bkVar != null) {
                j = bkVar.f3916a;
                this.k = bkVar.a();
            }
            bb.b(f3915a, "Oaid#initOaid oaidModel=" + bkVar);
        } finally {
            this.c.unlock();
            a(new i.a(j));
        }
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> hU(Context context) {
        Boolean bool;
        String str;
        bi.a hR;
        if (this.ppz == null || (hR = this.ppz.hR(context)) == null) {
            bool = null;
            str = null;
        } else {
            str = hR.b;
            Boolean valueOf = Boolean.valueOf(hR.c);
            if (hR instanceof bd.a) {
                this.l = Long.valueOf(((bd.a) hR).f3914a);
            }
            bool = valueOf;
        }
        return new Pair<>(str, bool);
    }

    private static void a(Runnable runnable) {
        bc.a(f3915a + "-query", runnable);
    }
}
