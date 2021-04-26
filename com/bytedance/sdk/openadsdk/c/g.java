package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.searchbox.config.AppConfig;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g<T extends i> extends HandlerThread implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public static String f28062a = "AdEventThread";

    /* renamed from: b  reason: collision with root package name */
    public static String f28063b = "ttad_bk";

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f28064c;

    /* renamed from: d  reason: collision with root package name */
    public q<T> f28065d;

    /* renamed from: e  reason: collision with root package name */
    public final List<T> f28066e;

    /* renamed from: f  reason: collision with root package name */
    public long f28067f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28068g;

    /* renamed from: h  reason: collision with root package name */
    public int f28069h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f28070i;
    public final a j;
    public final b k;
    public boolean l;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f28071a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28072b;

        /* renamed from: c  reason: collision with root package name */
        public final long f28073c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28074d;

        /* renamed from: e  reason: collision with root package name */
        public final long f28075e;

        /* renamed from: f  reason: collision with root package name */
        public final long f28076f;

        public b(int i2, long j, long j2, int i3, long j3, long j4) {
            this.f28071a = i2;
            this.f28072b = j;
            this.f28073c = j2;
            this.f28074d = i3;
            this.f28075e = j3;
            this.f28076f = j4;
        }

        public static b a() {
            return new b(1, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 15000L, 5, 172800000L, 300000L);
        }

        public static b b() {
            return new b(3, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 15000L, 5, 172800000L, 300000L);
        }
    }

    public g(e<T> eVar, q<T> qVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + f28063b);
        this.k = bVar;
        this.j = aVar;
        this.f28064c = eVar;
        this.f28065d = qVar;
        this.f28066e = Collections.synchronizedList(new LinkedList());
        this.l = false;
    }

    private void a() {
        e<T> eVar = this.f28064c;
        b bVar = this.k;
        eVar.a(bVar.f28074d, bVar.f28075e);
        this.f28068g = this.f28064c.a();
        this.f28069h = this.f28064c.b();
        if (this.f28068g) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f28069h);
            h();
            return;
        }
        b(this.f28064c.a(100, "_id"));
        a("onHandleInitEvent,mCloseSaveAndRetry is false, read db event data");
        a("onHandleInitEvent cacheData count = " + this.f28066e.size());
        e();
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T t : this.f28066e) {
                        hashSet.add(t.b());
                    }
                    for (T t2 : list) {
                        if (!hashSet.contains(t2.b())) {
                            this.f28066e.add(t2);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        a("reloadCacheList adEventList is empty======");
    }

    private void c() {
        if (this.f28068g) {
            return;
        }
        a("onHandleRoutineRetryEvent");
        e();
    }

    private void d() {
        if (this.f28068g) {
            return;
        }
        a("onHandleRoutineUploadEvent");
        e();
    }

    private void e() {
        this.f28070i.removeMessages(3);
        this.f28070i.removeMessages(2);
        if (s.a(this.f28066e)) {
            this.f28067f = System.currentTimeMillis();
            j();
        } else if (!this.j.a()) {
            a("doRoutineUpload no net, wait retry");
            i();
        } else {
            h a2 = a(this.f28066e);
            if (a2 != null) {
                if (a2.f28077a) {
                    a("doRoutineUpload success");
                    g();
                    f();
                } else if (a(a2)) {
                    a("doRoutineUpload serverbusy");
                    k();
                } else if (b(a2)) {
                    g();
                    f();
                } else if (this.f28068g) {
                } else {
                    if (!this.l) {
                        i();
                        a("doRoutineUpload net fail retry");
                        return;
                    }
                    l();
                }
            }
        }
    }

    private void f() {
        this.f28067f = System.currentTimeMillis();
        o();
        j();
    }

    private void g() {
        a("clearCacheList, delete event from cache and db");
        this.f28064c.a(this.f28066e);
        this.f28066e.clear();
    }

    private void h() {
        a(4, m());
    }

    private void i() {
        a(3, this.k.f28073c);
    }

    private void j() {
        a(2, this.k.f28072b);
    }

    private void k() {
        this.f28068g = true;
        this.f28064c.a(true);
        this.f28066e.clear();
        this.f28070i.removeMessages(3);
        this.f28070i.removeMessages(2);
        h();
    }

    private void l() {
        this.f28068g = true;
        this.f28064c.a(true);
        this.f28066e.clear();
        this.f28070i.removeMessages(3);
        this.f28070i.removeMessages(2);
        h();
    }

    private long m() {
        return ((this.f28069h % 3) + 1) * this.k.f28076f;
    }

    private boolean n() {
        return !this.f28068g && (this.f28066e.size() >= this.k.f28071a || System.currentTimeMillis() - this.f28067f >= this.k.f28072b);
    }

    private void o() {
        this.f28068g = false;
        this.f28064c.a(false);
        this.f28069h = 0;
        this.f28064c.a(0);
        this.f28070i.removeMessages(4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.bytedance.sdk.openadsdk.c.g<T extends com.bytedance.sdk.openadsdk.c.i> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a((g<T>) ((i) message.obj));
        } else if (i2 == 2) {
            d();
        } else if (i2 == 3) {
            c();
        } else if (i2 == 4) {
            b();
        } else if (i2 == 5) {
            a();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.f28067f = System.currentTimeMillis();
        this.f28070i = new Handler(getLooper(), this);
    }

    private void c(List<T> list) {
        if (!this.l || list == null) {
            return;
        }
        if (list.size() <= 100) {
            a("start and return, checkAndDeleteEvent local size:" + list.size() + "小于:100");
            return;
        }
        int size = (int) (list.size() - 75.0f);
        a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list.get(i2));
        }
        list.removeAll(arrayList);
        this.f28064c.a(arrayList);
        a("end checkAndDeleteEvent local size:" + list.size());
    }

    public g(String str, String str2, e<T> eVar, q<T> qVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + str);
        f28062a = str2;
        this.k = bVar;
        this.j = aVar;
        this.f28064c = eVar;
        this.f28065d = qVar;
        this.f28066e = Collections.synchronizedList(new LinkedList());
        this.l = false;
    }

    private void b() {
        if (!this.j.a()) {
            a(4, this.k.f28073c);
            a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> a2 = this.f28064c.a(100, "_id");
        c(a2);
        if (s.a(a2)) {
            a("onHandleServerBusyRetryEvent, empty list start routine");
            o();
            j();
            return;
        }
        h a3 = a(a2);
        if (a3 != null) {
            if (a3.f28077a) {
                a("onHandleServerBusyRetryEvent, success");
                g();
                f();
            } else if (a(a3)) {
                int i2 = this.f28069h + 1;
                this.f28069h = i2;
                this.f28064c.a(i2);
                e<T> eVar = this.f28064c;
                b bVar = this.k;
                eVar.a(a2, bVar.f28074d, bVar.f28075e);
                h();
                a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f28069h);
            } else if (b(a3)) {
                g();
                f();
            } else if (!this.l) {
                i();
                a("onHandleServerBusyRetryEvent, net fail");
            } else {
                int i3 = this.f28069h + 1;
                this.f28069h = i3;
                this.f28064c.a(i3);
                e<T> eVar2 = this.f28064c;
                b bVar2 = this.k;
                eVar2.a(a2, bVar2.f28074d, bVar2.f28075e);
                l();
            }
        }
    }

    public h a(List<T> list) {
        if (this.f28065d == null) {
            com.bytedance.sdk.openadsdk.core.p.f();
        }
        q<T> qVar = this.f28065d;
        if (qVar == null) {
            return null;
        }
        return qVar.a(list);
    }

    private void a(T t) {
        c(this.f28066e);
        this.f28064c.a((e<T>) t);
        a("onHandleReceivedAdEvent mCloseSaveAndRetry is false, save event into db");
        if (this.f28068g) {
            return;
        }
        a("onHandleReceivedAdEvent");
        this.f28066e.add(t);
        if (n()) {
            a("onHandleReceivedAdEvent upload");
            e();
        }
    }

    private void a(int i2, long j) {
        Message obtainMessage = this.f28070i.obtainMessage();
        obtainMessage.what = i2;
        this.f28070i.sendMessageDelayed(obtainMessage, j);
    }

    public static boolean a(h hVar) {
        return hVar.f28078b == 509;
    }

    private void a(String str) {
        u.b(f28062a, str);
    }

    public static boolean b(h hVar) {
        return hVar.f28080d;
    }
}
