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
/* loaded from: classes6.dex */
public class g<T extends i> extends HandlerThread implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public static String f27307a = "AdEventThread";

    /* renamed from: b  reason: collision with root package name */
    public static String f27308b = "ttad_bk";

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f27309c;

    /* renamed from: d  reason: collision with root package name */
    public q<T> f27310d;

    /* renamed from: e  reason: collision with root package name */
    public final List<T> f27311e;

    /* renamed from: f  reason: collision with root package name */
    public long f27312f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27313g;

    /* renamed from: h  reason: collision with root package name */
    public int f27314h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f27315i;
    public final a j;
    public final b k;
    public boolean l;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f27316a;

        /* renamed from: b  reason: collision with root package name */
        public final long f27317b;

        /* renamed from: c  reason: collision with root package name */
        public final long f27318c;

        /* renamed from: d  reason: collision with root package name */
        public final int f27319d;

        /* renamed from: e  reason: collision with root package name */
        public final long f27320e;

        /* renamed from: f  reason: collision with root package name */
        public final long f27321f;

        public b(int i2, long j, long j2, int i3, long j3, long j4) {
            this.f27316a = i2;
            this.f27317b = j;
            this.f27318c = j2;
            this.f27319d = i3;
            this.f27320e = j3;
            this.f27321f = j4;
        }

        public static b a() {
            return new b(1, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 15000L, 5, 172800000L, 300000L);
        }

        public static b b() {
            return new b(3, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 15000L, 5, 172800000L, 300000L);
        }
    }

    public g(e<T> eVar, q<T> qVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + f27308b);
        this.k = bVar;
        this.j = aVar;
        this.f27309c = eVar;
        this.f27310d = qVar;
        this.f27311e = Collections.synchronizedList(new LinkedList());
        this.l = false;
    }

    private void a() {
        e<T> eVar = this.f27309c;
        b bVar = this.k;
        eVar.a(bVar.f27319d, bVar.f27320e);
        this.f27313g = this.f27309c.a();
        this.f27314h = this.f27309c.b();
        if (this.f27313g) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f27314h);
            h();
            return;
        }
        b(this.f27309c.a(100, "_id"));
        a("onHandleInitEvent,mCloseSaveAndRetry is false, read db event data");
        a("onHandleInitEvent cacheData count = " + this.f27311e.size());
        e();
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T t : this.f27311e) {
                        hashSet.add(t.b());
                    }
                    for (T t2 : list) {
                        if (!hashSet.contains(t2.b())) {
                            this.f27311e.add(t2);
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
        if (this.f27313g) {
            return;
        }
        a("onHandleRoutineRetryEvent");
        e();
    }

    private void d() {
        if (this.f27313g) {
            return;
        }
        a("onHandleRoutineUploadEvent");
        e();
    }

    private void e() {
        this.f27315i.removeMessages(3);
        this.f27315i.removeMessages(2);
        if (s.a(this.f27311e)) {
            this.f27312f = System.currentTimeMillis();
            j();
        } else if (!this.j.a()) {
            a("doRoutineUpload no net, wait retry");
            i();
        } else {
            h a2 = a(this.f27311e);
            if (a2 != null) {
                if (a2.f27322a) {
                    a("doRoutineUpload success");
                    g();
                    f();
                } else if (a(a2)) {
                    a("doRoutineUpload serverbusy");
                    k();
                } else if (b(a2)) {
                    g();
                    f();
                } else if (this.f27313g) {
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
        this.f27312f = System.currentTimeMillis();
        o();
        j();
    }

    private void g() {
        a("clearCacheList, delete event from cache and db");
        this.f27309c.a(this.f27311e);
        this.f27311e.clear();
    }

    private void h() {
        a(4, m());
    }

    private void i() {
        a(3, this.k.f27318c);
    }

    private void j() {
        a(2, this.k.f27317b);
    }

    private void k() {
        this.f27313g = true;
        this.f27309c.a(true);
        this.f27311e.clear();
        this.f27315i.removeMessages(3);
        this.f27315i.removeMessages(2);
        h();
    }

    private void l() {
        this.f27313g = true;
        this.f27309c.a(true);
        this.f27311e.clear();
        this.f27315i.removeMessages(3);
        this.f27315i.removeMessages(2);
        h();
    }

    private long m() {
        return ((this.f27314h % 3) + 1) * this.k.f27321f;
    }

    private boolean n() {
        return !this.f27313g && (this.f27311e.size() >= this.k.f27316a || System.currentTimeMillis() - this.f27312f >= this.k.f27317b);
    }

    private void o() {
        this.f27313g = false;
        this.f27309c.a(false);
        this.f27314h = 0;
        this.f27309c.a(0);
        this.f27315i.removeMessages(4);
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
        this.f27312f = System.currentTimeMillis();
        this.f27315i = new Handler(getLooper(), this);
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
        this.f27309c.a(arrayList);
        a("end checkAndDeleteEvent local size:" + list.size());
    }

    public g(String str, String str2, e<T> eVar, q<T> qVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + str);
        f27307a = str2;
        this.k = bVar;
        this.j = aVar;
        this.f27309c = eVar;
        this.f27310d = qVar;
        this.f27311e = Collections.synchronizedList(new LinkedList());
        this.l = false;
    }

    private void b() {
        if (!this.j.a()) {
            a(4, this.k.f27318c);
            a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> a2 = this.f27309c.a(100, "_id");
        c(a2);
        if (s.a(a2)) {
            a("onHandleServerBusyRetryEvent, empty list start routine");
            o();
            j();
            return;
        }
        h a3 = a(a2);
        if (a3 != null) {
            if (a3.f27322a) {
                a("onHandleServerBusyRetryEvent, success");
                g();
                f();
            } else if (a(a3)) {
                int i2 = this.f27314h + 1;
                this.f27314h = i2;
                this.f27309c.a(i2);
                e<T> eVar = this.f27309c;
                b bVar = this.k;
                eVar.a(a2, bVar.f27319d, bVar.f27320e);
                h();
                a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f27314h);
            } else if (b(a3)) {
                g();
                f();
            } else if (!this.l) {
                i();
                a("onHandleServerBusyRetryEvent, net fail");
            } else {
                int i3 = this.f27314h + 1;
                this.f27314h = i3;
                this.f27309c.a(i3);
                e<T> eVar2 = this.f27309c;
                b bVar2 = this.k;
                eVar2.a(a2, bVar2.f27319d, bVar2.f27320e);
                l();
            }
        }
    }

    public h a(List<T> list) {
        if (this.f27310d == null) {
            com.bytedance.sdk.openadsdk.core.p.f();
        }
        q<T> qVar = this.f27310d;
        if (qVar == null) {
            return null;
        }
        return qVar.a(list);
    }

    private void a(T t) {
        c(this.f27311e);
        this.f27309c.a((e<T>) t);
        a("onHandleReceivedAdEvent mCloseSaveAndRetry is false, save event into db");
        if (this.f27313g) {
            return;
        }
        a("onHandleReceivedAdEvent");
        this.f27311e.add(t);
        if (n()) {
            a("onHandleReceivedAdEvent upload");
            e();
        }
    }

    private void a(int i2, long j) {
        Message obtainMessage = this.f27315i.obtainMessage();
        obtainMessage.what = i2;
        this.f27315i.sendMessageDelayed(obtainMessage, j);
    }

    public static boolean a(h hVar) {
        return hVar.f27323b == 509;
    }

    private void a(String str) {
        u.b(f27307a, str);
    }

    public static boolean b(h hVar) {
        return hVar.f27325d;
    }
}
