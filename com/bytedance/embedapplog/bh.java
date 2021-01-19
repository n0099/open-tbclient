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
    private static i pcB;
    private boolean f;
    private final Context h;
    private Map<String, String> k;
    private Long l;
    private bi pcC;
    private bl pcD;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5800b = bh.class.getSimpleName() + "#";

    /* renamed from: a  reason: collision with root package name */
    public static final String f5799a = f5800b;
    private final ReentrantLock pcA = new ReentrantLock();
    private AtomicBoolean i = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(Context context) {
        this.h = context;
        this.pcC = bj.hT(context);
        if (this.pcC != null) {
            this.f = this.pcC.a(context);
        } else {
            this.f = false;
        }
        this.pcD = new bl(context);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE] complete} */
    @Nullable
    @WorkerThread
    public Map<String, String> id(long j2) {
        if (!this.f) {
            return null;
        }
        a();
        bb.a(f5799a, "Oaid#getOaid timeoutMills=" + j2);
        if (this.k == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = false;
            try {
                try {
                    z = this.pcA.tryLock(j2, TimeUnit.MILLISECONDS);
                    bb.b(f5799a, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                    if (z) {
                        this.pcA.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (z) {
                        this.pcA.unlock();
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    this.pcA.unlock();
                }
                throw th;
            }
        }
        bb.a(f5799a, "Oaid#getOaid return apiMap=" + this.k);
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @AnyThread
    public static void b(@Nullable i iVar) {
        pcB = iVar;
        if (j != null) {
            a(new i.a(j));
        }
    }

    private static void a(@Nullable i.a aVar) {
        i iVar;
        if (aVar != null && (iVar = pcB) != null) {
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
        bb.b(f5799a, "Oaid#initOaid");
        try {
            this.pcA.lock();
            bb.b(f5799a, "Oaid#initOaid exec");
            bk elA = this.pcD.elA();
            bb.b(f5799a, "Oaid#initOaid fetch=" + elA);
            if (elA != null) {
                j = elA.f5802a;
                this.k = elA.a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> hS = hS(this.h);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (hS.first != null) {
                int i = -1;
                if (elA != null) {
                    str = elA.f5803b;
                    i = elA.pcF.intValue() + 1;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                bkVar = new bk((String) hS.first, str, (Boolean) hS.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i <= 0 ? 1 : i), this.l);
                this.pcD.a(bkVar);
            }
            if (bkVar != null) {
                j = bkVar.f5802a;
                this.k = bkVar.a();
            }
            bb.b(f5799a, "Oaid#initOaid oaidModel=" + bkVar);
        } finally {
            this.pcA.unlock();
            a(new i.a(j));
        }
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> hS(Context context) {
        Boolean bool;
        String str;
        bi.a hP;
        if (this.pcC == null || (hP = this.pcC.hP(context)) == null) {
            bool = null;
            str = null;
        } else {
            str = hP.f5801b;
            Boolean valueOf = Boolean.valueOf(hP.c);
            if (hP instanceof bd.a) {
                this.l = Long.valueOf(((bd.a) hP).f5798a);
            }
            bool = valueOf;
        }
        return new Pair<>(str, bool);
    }

    private static void a(Runnable runnable) {
        bc.a(f5799a + "-query", runnable);
    }
}
