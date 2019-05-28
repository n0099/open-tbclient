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
    private static n jPS;
    private static long jPT;
    private static long jPl = f.cAw();
    private Runnable jPV;
    private boolean foreground = false;
    private boolean jPU = true;
    private Handler handler = new Handler();
    private a jPW = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Gr("app   went foreground ");
            if (currentTimeMillis - m.jPT > m.jPl) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cAn().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Gr("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cAn().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jPD;
            if (dVar.cAs().size() == 0) {
                com.baidu.ubs.analytics.d.b.Gr("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cAn().a(true);
                long unused = m.jPT = 0L;
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
        jPT = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cAD() {
        return jPS;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void T() {
        this.jPU = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.jPV != null) {
            this.handler.removeCallbacks(this.jPV);
        }
        if (z) {
            try {
                this.jPW.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Gr("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void U() {
        this.jPU = true;
        if (this.jPV != null) {
            this.handler.removeCallbacks(this.jPV);
            this.jPV = null;
        }
        jPT = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jPS.z(String.valueOf(currentTimeMillis));
                try {
                    m.jPS.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jPS.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Gr(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Gm(m.jPS.I())) {
                    pVar.b(m.jPS);
                } else {
                    pVar.c(m.jPS);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.jPU) {
                    m.this.foreground = false;
                    try {
                        m.this.jPW.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Gr("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jPV = runnable;
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
        jPS = nVar;
        nVar.setStartTime(String.valueOf(j));
        jPS.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Gr("超时了……………… 一个新的session");
                new p().c(m.jPS);
            }
        });
    }
}
