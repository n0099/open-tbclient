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
/* loaded from: classes8.dex */
public final class m implements a.InterfaceC0642a {
    private static long kVV = f.cXA();
    private static n kWE;
    private static long kWF;
    private Runnable kWI;
    private boolean kWG = false;
    private boolean kWH = true;
    private Handler handler = new Handler();
    private a kWJ = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cXM() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Lt("app   went foreground ");
            if (currentTimeMillis - m.kWF > m.kVV) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cXp().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Lt("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cXp().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cXN() {
            d dVar;
            dVar = d.a.kWn;
            if (dVar.cXw().size() == 0) {
                com.baidu.ubs.analytics.d.b.Lt("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cXp().a(true);
                long unused = m.kWF = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Lt("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void cXM();

        void cXN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        kWF = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cXH() {
        return kWE;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void T() {
        this.kWH = false;
        boolean z = this.kWG ? false : true;
        this.kWG = true;
        if (this.kWI != null) {
            this.handler.removeCallbacks(this.kWI);
        }
        if (z) {
            try {
                this.kWJ.cXM();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Lt("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void U() {
        this.kWH = true;
        if (this.kWI != null) {
            this.handler.removeCallbacks(this.kWI);
            this.kWI = null;
        }
        kWF = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kWE.z(String.valueOf(currentTimeMillis));
                try {
                    m.kWE.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kWE.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Lt(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Lo(m.kWE.I())) {
                    pVar.b(m.kWE);
                } else {
                    pVar.c(m.kWE);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kWG && m.this.kWH) {
                    m.this.kWG = false;
                    try {
                        m.this.kWJ.cXN();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Lt("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kWI = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        kWE = nVar;
        nVar.setStartTime(String.valueOf(j));
        kWE.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Lt("超时了……………… 一个新的session");
                new p().c(m.kWE);
            }
        });
    }
}
