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
public final class m implements a.InterfaceC0440a {
    private static n jPR;
    private static long jPS;
    private static long jPk = f.cAu();
    private Runnable jPU;
    private boolean foreground = false;
    private boolean jPT = true;
    private Handler handler = new Handler();
    private a jPV = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Gr("app   went foreground ");
            if (currentTimeMillis - m.jPS > m.jPk) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cAl().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Gr("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cAl().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jPC;
            if (dVar.cAq().size() == 0) {
                com.baidu.ubs.analytics.d.b.Gr("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cAl().a(true);
                long unused = m.jPS = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Gr("进入后台但没退出                  ");
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
        jPS = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cAB() {
        return jPR;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void T() {
        this.jPT = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.jPU != null) {
            this.handler.removeCallbacks(this.jPU);
        }
        if (z) {
            try {
                this.jPV.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Gr("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void U() {
        this.jPT = true;
        if (this.jPU != null) {
            this.handler.removeCallbacks(this.jPU);
            this.jPU = null;
        }
        jPS = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jPR.z(String.valueOf(currentTimeMillis));
                try {
                    m.jPR.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jPR.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Gr(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Gm(m.jPR.I())) {
                    pVar.b(m.jPR);
                } else {
                    pVar.c(m.jPR);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.jPT) {
                    m.this.foreground = false;
                    try {
                        m.this.jPV.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Gr("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jPU = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jPR = nVar;
        nVar.setStartTime(String.valueOf(j));
        jPR.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Gr("超时了……………… 一个新的session");
                new p().c(m.jPR);
            }
        });
    }
}
