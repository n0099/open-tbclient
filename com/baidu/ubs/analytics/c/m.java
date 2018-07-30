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
    private static n hCP;
    private static long hCQ;
    private static long hCg = f.bJd();
    private Runnable hCS;
    private boolean foreground = false;
    private boolean hCR = true;
    private Handler handler = new Handler();
    private a hCT = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.we("app   went foreground ");
            if (currentTimeMillis - m.hCQ > m.hCg) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bIU().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.we("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bIU().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hCz;
            if (dVar.bIZ().size() == 0) {
                com.baidu.ubs.analytics.d.b.we("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bIU().a(true);
                long unused = m.hCQ = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.we("进入后台但没退出                  ");
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
        hCQ = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bJj() {
        return hCP;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void T() {
        this.hCR = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hCS != null) {
            this.handler.removeCallbacks(this.hCS);
        }
        if (z) {
            try {
                this.hCT.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.we("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void U() {
        this.hCR = true;
        if (this.hCS != null) {
            this.handler.removeCallbacks(this.hCS);
            this.hCS = null;
        }
        hCQ = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hCP.z(String.valueOf(currentTimeMillis));
                try {
                    m.hCP.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hCP.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.we(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.vZ(m.hCP.I())) {
                    pVar.b(m.hCP);
                } else {
                    pVar.c(m.hCP);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.hCR) {
                    m.this.foreground = false;
                    try {
                        m.this.hCT.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.we("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hCS = runnable;
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
        hCP = nVar;
        nVar.setStartTime(String.valueOf(j));
        hCP.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.we("超时了……………… 一个新的session");
                new p().c(m.hCP);
            }
        });
    }
}
