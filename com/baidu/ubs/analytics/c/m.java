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
/* loaded from: classes2.dex */
public final class m implements a.InterfaceC0263a {
    private static n hCR;
    private static long hCS;
    private static long hCi = f.bJh();
    private Runnable hCU;
    private boolean foreground = false;
    private boolean hCT = true;
    private Handler handler = new Handler();
    private a hCV = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.wi("app   went foreground ");
            if (currentTimeMillis - m.hCS > m.hCi) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bIY().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.wi("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bIY().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hCB;
            if (dVar.bJd().size() == 0) {
                com.baidu.ubs.analytics.d.b.wi("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bIY().a(true);
                long unused = m.hCS = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.wi("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void aq();

        void ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        hCS = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bJn() {
        return hCR;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void T() {
        this.hCT = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hCU != null) {
            this.handler.removeCallbacks(this.hCU);
        }
        if (z) {
            try {
                this.hCV.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.wi("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void U() {
        this.hCT = true;
        if (this.hCU != null) {
            this.handler.removeCallbacks(this.hCU);
            this.hCU = null;
        }
        hCS = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hCR.z(String.valueOf(currentTimeMillis));
                try {
                    m.hCR.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hCR.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.wi(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.wd(m.hCR.I())) {
                    pVar.b(m.hCR);
                } else {
                    pVar.c(m.hCR);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.hCT) {
                    m.this.foreground = false;
                    try {
                        m.this.hCV.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.wi("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hCU = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        hCR = nVar;
        nVar.setStartTime(String.valueOf(j));
        hCR.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.wi("超时了……………… 一个新的session");
                new p().c(m.hCR);
            }
        });
    }
}
