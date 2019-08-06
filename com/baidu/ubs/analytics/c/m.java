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
public final class m implements a.InterfaceC0445a {
    private static long jXt = f.cDP();
    private static n jYb;
    private static long jYc;
    private Runnable jYf;
    private boolean jYd = false;
    private boolean jYe = true;
    private Handler handler = new Handler();
    private a jYg = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Ho("app   went foreground ");
            if (currentTimeMillis - m.jYc > m.jXt) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cDF().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Ho("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cDF().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jXL;
            if (dVar.cDL().size() == 0) {
                com.baidu.ubs.analytics.d.b.Ho("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cDF().a(true);
                long unused = m.jYc = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Ho("进入后台但没退出                  ");
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
        jYc = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cDW() {
        return jYb;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void T() {
        this.jYe = false;
        boolean z = this.jYd ? false : true;
        this.jYd = true;
        if (this.jYf != null) {
            this.handler.removeCallbacks(this.jYf);
        }
        if (z) {
            try {
                this.jYg.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Ho("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void U() {
        this.jYe = true;
        if (this.jYf != null) {
            this.handler.removeCallbacks(this.jYf);
            this.jYf = null;
        }
        jYc = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jYb.z(String.valueOf(currentTimeMillis));
                try {
                    m.jYb.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jYb.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Ho(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Hj(m.jYb.I())) {
                    pVar.b(m.jYb);
                } else {
                    pVar.c(m.jYb);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.jYd && m.this.jYe) {
                    m.this.jYd = false;
                    try {
                        m.this.jYg.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Ho("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jYf = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jYb = nVar;
        nVar.setStartTime(String.valueOf(j));
        jYb.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Ho("超时了……………… 一个新的session");
                new p().c(m.jYb);
            }
        });
    }
}
