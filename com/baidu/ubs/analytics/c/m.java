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
/* loaded from: classes3.dex */
public final class m implements a.InterfaceC0421a {
    private static long jwt = f.csx();
    private static n jxa;
    private static long jxb;
    private Runnable jxd;
    private boolean foreground = false;
    private boolean jxc = true;
    private Handler handler = new Handler();
    private a jxe = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.EW("app   went foreground ");
            if (currentTimeMillis - m.jxb > m.jwt) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cso().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.EW("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cso().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jwL;
            if (dVar.cst().size() == 0) {
                com.baidu.ubs.analytics.d.b.EW("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cso().a(true);
                long unused = m.jxb = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.EW("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void aq();

        void ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        jxb = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n csE() {
        return jxa;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void T() {
        this.jxc = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.jxd != null) {
            this.handler.removeCallbacks(this.jxd);
        }
        if (z) {
            try {
                this.jxe.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.EW("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void U() {
        this.jxc = true;
        if (this.jxd != null) {
            this.handler.removeCallbacks(this.jxd);
            this.jxd = null;
        }
        jxb = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jxa.z(String.valueOf(currentTimeMillis));
                try {
                    m.jxa.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jxa.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.EW(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.ER(m.jxa.I())) {
                    pVar.b(m.jxa);
                } else {
                    pVar.c(m.jxa);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.jxc) {
                    m.this.foreground = false;
                    try {
                        m.this.jxe.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.EW("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jxd = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jxa = nVar;
        nVar.setStartTime(String.valueOf(j));
        jxa.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.EW("超时了……………… 一个新的session");
                new p().c(m.jxa);
            }
        });
    }
}
