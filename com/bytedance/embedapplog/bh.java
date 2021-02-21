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
    private static i pno;
    private boolean f;
    private final Context h;
    private Map<String, String> k;
    private Long l;
    private bi pnp;
    private bl pnq;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5802b = bh.class.getSimpleName() + "#";

    /* renamed from: a  reason: collision with root package name */
    public static final String f5801a = f5802b;
    private final ReentrantLock c = new ReentrantLock();
    private AtomicBoolean i = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(Context context) {
        this.h = context;
        this.pnp = bj.hW(context);
        if (this.pnp != null) {
            this.f = this.pnp.a(context);
        } else {
            this.f = false;
        }
        this.pnq = new bl(context);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE] complete} */
    @Nullable
    @WorkerThread
    public Map<String, String> ig(long j2) {
        if (!this.f) {
            return null;
        }
        a();
        bb.a(f5801a, "Oaid#getOaid timeoutMills=" + j2);
        if (this.k == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = false;
            try {
                try {
                    z = this.c.tryLock(j2, TimeUnit.MILLISECONDS);
                    bb.b(f5801a, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
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
        bb.a(f5801a, "Oaid#getOaid return apiMap=" + this.k);
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @AnyThread
    public static void b(@Nullable i iVar) {
        pno = iVar;
        if (j != null) {
            a(new i.a(j));
        }
    }

    private static void a(@Nullable i.a aVar) {
        i iVar;
        if (aVar != null && (iVar = pno) != null) {
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
        bb.b(f5801a, "Oaid#initOaid");
        try {
            this.c.lock();
            bb.b(f5801a, "Oaid#initOaid exec");
            bk eob = this.pnq.eob();
            bb.b(f5801a, "Oaid#initOaid fetch=" + eob);
            if (eob != null) {
                j = eob.f5804a;
                this.k = eob.a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> hV = hV(this.h);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (hV.first != null) {
                int i = -1;
                if (eob != null) {
                    str = eob.f5805b;
                    i = eob.pns.intValue() + 1;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                bkVar = new bk((String) hV.first, str, (Boolean) hV.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i <= 0 ? 1 : i), this.l);
                this.pnq.a(bkVar);
            }
            if (bkVar != null) {
                j = bkVar.f5804a;
                this.k = bkVar.a();
            }
            bb.b(f5801a, "Oaid#initOaid oaidModel=" + bkVar);
        } finally {
            this.c.unlock();
            a(new i.a(j));
        }
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> hV(Context context) {
        Boolean bool;
        String str;
        bi.a hS;
        if (this.pnp == null || (hS = this.pnp.hS(context)) == null) {
            bool = null;
            str = null;
        } else {
            str = hS.f5803b;
            Boolean valueOf = Boolean.valueOf(hS.c);
            if (hS instanceof bd.a) {
                this.l = Long.valueOf(((bd.a) hS).f5800a);
            }
            bool = valueOf;
        }
        return new Pair<>(str, bool);
    }

    private static void a(Runnable runnable) {
        bc.a(f5801a + "-query", runnable);
    }
}
