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
/* loaded from: classes7.dex */
public final class m implements a.InterfaceC0846a {
    private static long npZ = f.dQx();
    private static n nqH;
    private static long nqI;
    private Runnable nqL;
    private boolean nqJ = false;
    private boolean nqK = true;
    private Handler handler = new Handler();
    private a nqM = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.I("app   went foreground ");
            if (currentTimeMillis - m.nqI > m.npZ) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.dQp().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.I("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.dQp().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void dQK() {
            d dVar;
            dVar = d.a.nqr;
            if (dVar.dQu().size() == 0) {
                com.baidu.ubs.analytics.d.b.I("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.dQp().a(true);
                long unused = m.nqI = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.I("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void aq();

        void dQK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        nqI = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n dQF() {
        return nqH;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0846a
    public final void T() {
        this.nqK = false;
        boolean z = this.nqJ ? false : true;
        this.nqJ = true;
        if (this.nqL != null) {
            this.handler.removeCallbacks(this.nqL);
        }
        if (z) {
            try {
                this.nqM.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0846a
    public final void U() {
        this.nqK = true;
        if (this.nqL != null) {
            this.handler.removeCallbacks(this.nqL);
            this.nqL = null;
        }
        nqI = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.nqH.z(String.valueOf(currentTimeMillis));
                try {
                    m.nqH.A(String.valueOf(currentTimeMillis - Long.parseLong(m.nqH.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.I(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Us(m.nqH.I())) {
                    pVar.b(m.nqH);
                } else {
                    pVar.c(m.nqH);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.nqJ && m.this.nqK) {
                    m.this.nqJ = false;
                    try {
                        m.this.nqM.dQK();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.nqL = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0846a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0846a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        nqH = nVar;
        nVar.setStartTime(String.valueOf(j));
        nqH.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.I("超时了……………… 一个新的session");
                new p().c(m.nqH);
            }
        });
    }
}
