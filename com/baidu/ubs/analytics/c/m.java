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
public final class m implements a.InterfaceC0551a {
    private static long jWY = f.cBm();
    private static n jXH;
    private static long jXI;
    private Runnable jXL;
    private boolean jXJ = false;
    private boolean jXK = true;
    private Handler handler = new Handler();
    private a jXM = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cBy() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Gf("app   went foreground ");
            if (currentTimeMillis - m.jXI > m.jWY) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cBb().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Gf("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cBb().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cBz() {
            d dVar;
            dVar = d.a.jXq;
            if (dVar.cBi().size() == 0) {
                com.baidu.ubs.analytics.d.b.Gf("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cBb().a(true);
                long unused = m.jXI = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Gf("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void cBy();

        void cBz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        jXI = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cBt() {
        return jXH;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0551a
    public final void T() {
        this.jXK = false;
        boolean z = this.jXJ ? false : true;
        this.jXJ = true;
        if (this.jXL != null) {
            this.handler.removeCallbacks(this.jXL);
        }
        if (z) {
            try {
                this.jXM.cBy();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Gf("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0551a
    public final void U() {
        this.jXK = true;
        if (this.jXL != null) {
            this.handler.removeCallbacks(this.jXL);
            this.jXL = null;
        }
        jXI = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jXH.z(String.valueOf(currentTimeMillis));
                try {
                    m.jXH.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jXH.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Gf(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Ga(m.jXH.I())) {
                    pVar.b(m.jXH);
                } else {
                    pVar.c(m.jXH);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.jXJ && m.this.jXK) {
                    m.this.jXJ = false;
                    try {
                        m.this.jXM.cBz();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Gf("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jXL = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0551a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0551a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jXH = nVar;
        nVar.setStartTime(String.valueOf(j));
        jXH.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Gf("超时了……………… 一个新的session");
                new p().c(m.jXH);
            }
        });
    }
}
