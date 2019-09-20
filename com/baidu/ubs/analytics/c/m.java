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
public final class m implements a.InterfaceC0456a {
    private static long jZQ = f.cED();
    private static n kay;
    private static long kaz;
    private Runnable kaC;
    private boolean kaA = false;
    private boolean kaB = true;
    private Handler handler = new Handler();
    private a kaD = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.HO("app   went foreground ");
            if (currentTimeMillis - m.kaz > m.jZQ) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cEt().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.HO("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cEt().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.kai;
            if (dVar.cEz().size() == 0) {
                com.baidu.ubs.analytics.d.b.HO("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cEt().a(true);
                long unused = m.kaz = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.HO("进入后台但没退出                  ");
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
        kaz = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cEK() {
        return kay;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0456a
    public final void T() {
        this.kaB = false;
        boolean z = this.kaA ? false : true;
        this.kaA = true;
        if (this.kaC != null) {
            this.handler.removeCallbacks(this.kaC);
        }
        if (z) {
            try {
                this.kaD.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.HO("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0456a
    public final void U() {
        this.kaB = true;
        if (this.kaC != null) {
            this.handler.removeCallbacks(this.kaC);
            this.kaC = null;
        }
        kaz = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kay.z(String.valueOf(currentTimeMillis));
                try {
                    m.kay.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kay.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.HO(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.HJ(m.kay.I())) {
                    pVar.b(m.kay);
                } else {
                    pVar.c(m.kay);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kaA && m.this.kaB) {
                    m.this.kaA = false;
                    try {
                        m.this.kaD.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.HO("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kaC = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0456a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0456a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        kay = nVar;
        nVar.setStartTime(String.valueOf(j));
        kay.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.HO("超时了……………… 一个新的session");
                new p().c(m.kay);
            }
        });
    }
}
