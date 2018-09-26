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
public final class m implements a.InterfaceC0269a {
    private static long hKF = f.bLY();
    private static n hLn;
    private static long hLo;
    private Runnable hLq;
    private boolean foreground = false;
    private boolean hLp = true;
    private Handler handler = new Handler();
    private a hLr = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.wT("app   went foreground ");
            if (currentTimeMillis - m.hLo > m.hKF) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bLP().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.wT("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bLP().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hKX;
            if (dVar.bLU().size() == 0) {
                com.baidu.ubs.analytics.d.b.wT("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bLP().a(true);
                long unused = m.hLo = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.wT("进入后台但没退出                  ");
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
        hLo = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bMe() {
        return hLn;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0269a
    public final void T() {
        this.hLp = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hLq != null) {
            this.handler.removeCallbacks(this.hLq);
        }
        if (z) {
            try {
                this.hLr.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.wT("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0269a
    public final void U() {
        this.hLp = true;
        if (this.hLq != null) {
            this.handler.removeCallbacks(this.hLq);
            this.hLq = null;
        }
        hLo = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hLn.z(String.valueOf(currentTimeMillis));
                try {
                    m.hLn.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hLn.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.wT(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.wO(m.hLn.I())) {
                    pVar.b(m.hLn);
                } else {
                    pVar.c(m.hLn);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.hLp) {
                    m.this.foreground = false;
                    try {
                        m.this.hLr.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.wT("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hLq = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0269a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0269a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        hLn = nVar;
        nVar.setStartTime(String.valueOf(j));
        hLn.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.wT("超时了……………… 一个新的session");
                new p().c(m.hLn);
            }
        });
    }
}
