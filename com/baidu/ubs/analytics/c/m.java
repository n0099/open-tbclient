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
    private static long jXP = f.cBo();
    private static n jYy;
    private static long jYz;
    private Runnable jYC;
    private boolean jYA = false;
    private boolean jYB = true;
    private Handler handler = new Handler();
    private a jYD = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cBA() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Gf("app   went foreground ");
            if (currentTimeMillis - m.jYz > m.jXP) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cBd().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Gf("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cBd().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cBB() {
            d dVar;
            dVar = d.a.jYh;
            if (dVar.cBk().size() == 0) {
                com.baidu.ubs.analytics.d.b.Gf("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cBd().a(true);
                long unused = m.jYz = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Gf("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void cBA();

        void cBB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        jYz = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cBv() {
        return jYy;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0551a
    public final void T() {
        this.jYB = false;
        boolean z = this.jYA ? false : true;
        this.jYA = true;
        if (this.jYC != null) {
            this.handler.removeCallbacks(this.jYC);
        }
        if (z) {
            try {
                this.jYD.cBA();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Gf("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0551a
    public final void U() {
        this.jYB = true;
        if (this.jYC != null) {
            this.handler.removeCallbacks(this.jYC);
            this.jYC = null;
        }
        jYz = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jYy.z(String.valueOf(currentTimeMillis));
                try {
                    m.jYy.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jYy.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Gf(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Ga(m.jYy.I())) {
                    pVar.b(m.jYy);
                } else {
                    pVar.c(m.jYy);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.jYA && m.this.jYB) {
                    m.this.jYA = false;
                    try {
                        m.this.jYD.cBB();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Gf("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jYC = runnable;
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
        jYy = nVar;
        nVar.setStartTime(String.valueOf(j));
        jYy.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Gf("超时了……………… 一个新的session");
                new p().c(m.jYy);
            }
        });
    }
}
