package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import com.baidu.ubs.analytics.a.p;
import com.baidu.ubs.analytics.c.a;
import com.baidu.ubs.analytics.c.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC0629a {
    private static long kRv = f.cVe();
    private static n kSe;
    private static long kSf;
    private Runnable kSi;
    private boolean kSg = false;
    private boolean kSh = true;
    private Handler handler = new Handler();
    private a kSj = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cVq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.KV("app   went foreground ");
            if (currentTimeMillis - m.kSf > m.kRv) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cUT().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.KV("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cUT().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cVr() {
            d dVar;
            dVar = d.a.kRN;
            if (dVar.cVa().size() == 0) {
                com.baidu.ubs.analytics.d.b.KV("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cUT().a(true);
                long unused = m.kSf = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.KV("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void cVq();

        void cVr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        kSf = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cVl() {
        return kSe;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0629a
    public final void T() {
        this.kSh = false;
        boolean z = this.kSg ? false : true;
        this.kSg = true;
        if (this.kSi != null) {
            this.handler.removeCallbacks(this.kSi);
        }
        if (z) {
            try {
                this.kSj.cVq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.KV("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0629a
    public final void U() {
        this.kSh = true;
        if (this.kSi != null) {
            this.handler.removeCallbacks(this.kSi);
            this.kSi = null;
        }
        kSf = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kSe.z(String.valueOf(currentTimeMillis));
                try {
                    m.kSe.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kSe.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.KV(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.KQ(m.kSe.I())) {
                    pVar.b(m.kSe);
                } else {
                    pVar.c(m.kSe);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kSg && m.this.kSh) {
                    m.this.kSg = false;
                    try {
                        m.this.kSj.cVr();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.KV("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kSi = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0629a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0629a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        kSe = nVar;
        nVar.setStartTime(String.valueOf(j));
        kSe.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.KV("超时了……………… 一个新的session");
                new p().c(m.kSe);
            }
        });
    }
}
