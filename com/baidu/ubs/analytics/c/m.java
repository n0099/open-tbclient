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
    private static long hBB = f.bKz();
    private static n hCk;
    private static long hCl;
    private Runnable hCn;
    private boolean foreground = false;
    private boolean hCm = true;
    private Handler handler = new Handler();
    private a hCo = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.wd("app   went foreground ");
            if (currentTimeMillis - m.hCl > m.hBB) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bKq().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.wd("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bKq().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hBU;
            if (dVar.bKv().size() == 0) {
                com.baidu.ubs.analytics.d.b.wd("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bKq().a(true);
                long unused = m.hCl = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.wd("进入后台但没退出                  ");
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
        hCl = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bKF() {
        return hCk;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void T() {
        this.hCm = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hCn != null) {
            this.handler.removeCallbacks(this.hCn);
        }
        if (z) {
            try {
                this.hCo.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.wd("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0263a
    public final void U() {
        this.hCm = true;
        if (this.hCn != null) {
            this.handler.removeCallbacks(this.hCn);
            this.hCn = null;
        }
        hCl = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hCk.z(String.valueOf(currentTimeMillis));
                try {
                    m.hCk.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hCk.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.wd(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.vY(m.hCk.I())) {
                    pVar.b(m.hCk);
                } else {
                    pVar.c(m.hCk);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.hCm) {
                    m.this.foreground = false;
                    try {
                        m.this.hCo.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.wd("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hCn = runnable;
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
        hCk = nVar;
        nVar.setStartTime(String.valueOf(j));
        hCk.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.wd("超时了……………… 一个新的session");
                new p().c(m.hCk);
            }
        });
    }
}
