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
/* loaded from: classes4.dex */
public final class bh {
    private static String j;
    @Nullable
    private static i phc;
    private boolean f;
    private final Context h;
    private Map<String, String> k;
    private Long l;
    private bi phd;
    private bl phe;

    /* renamed from: b  reason: collision with root package name */
    private static final String f6099b = bh.class.getSimpleName() + "#";

    /* renamed from: a  reason: collision with root package name */
    public static final String f6098a = f6099b;
    private final ReentrantLock phb = new ReentrantLock();
    private AtomicBoolean i = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(Context context) {
        this.h = context;
        this.phd = bj.hV(context);
        if (this.phd != null) {
            this.f = this.phd.a(context);
        } else {
            this.f = false;
        }
        this.phe = new bl(context);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE] complete} */
    @Nullable
    @WorkerThread
    public Map<String, String> id(long j2) {
        if (!this.f) {
            return null;
        }
        a();
        bb.a(f6098a, "Oaid#getOaid timeoutMills=" + j2);
        if (this.k == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = false;
            try {
                try {
                    z = this.phb.tryLock(j2, TimeUnit.MILLISECONDS);
                    bb.b(f6098a, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                    if (z) {
                        this.phb.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (z) {
                        this.phb.unlock();
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    this.phb.unlock();
                }
                throw th;
            }
        }
        bb.a(f6098a, "Oaid#getOaid return apiMap=" + this.k);
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @AnyThread
    public static void b(@Nullable i iVar) {
        phc = iVar;
        if (j != null) {
            a(new i.a(j));
        }
    }

    private static void a(@Nullable i.a aVar) {
        i iVar;
        if (aVar != null && (iVar = phc) != null) {
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
        bb.b(f6098a, "Oaid#initOaid");
        try {
            this.phb.lock();
            bb.b(f6098a, "Oaid#initOaid exec");
            bk epv = this.phe.epv();
            bb.b(f6098a, "Oaid#initOaid fetch=" + epv);
            if (epv != null) {
                j = epv.f6101a;
                this.k = epv.a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> hU = hU(this.h);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (hU.first != null) {
                int i = -1;
                if (epv != null) {
                    str = epv.f6102b;
                    i = epv.phg.intValue() + 1;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                bkVar = new bk((String) hU.first, str, (Boolean) hU.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i <= 0 ? 1 : i), this.l);
                this.phe.a(bkVar);
            }
            if (bkVar != null) {
                j = bkVar.f6101a;
                this.k = bkVar.a();
            }
            bb.b(f6098a, "Oaid#initOaid oaidModel=" + bkVar);
        } finally {
            this.phb.unlock();
            a(new i.a(j));
        }
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> hU(Context context) {
        Boolean bool;
        String str;
        bi.a hR;
        if (this.phd == null || (hR = this.phd.hR(context)) == null) {
            bool = null;
            str = null;
        } else {
            str = hR.f6100b;
            Boolean valueOf = Boolean.valueOf(hR.c);
            if (hR instanceof bd.a) {
                this.l = Long.valueOf(((bd.a) hR).f6097a);
            }
            bool = valueOf;
        }
        return new Pair<>(str, bool);
    }

    private static void a(Runnable runnable) {
        bc.a(f6098a + "-query", runnable);
    }
}
