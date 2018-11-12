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
/* loaded from: classes6.dex */
public final class m implements a.InterfaceC0334a {
    private static n hVQ;
    private static long hVR;
    private static long hVi = f.Z();
    private Runnable hVT;
    private boolean foreground = false;
    private boolean hVS = true;
    private Handler handler = new Handler();
    private a hVU = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.xY("app   went foreground ");
            if (currentTimeMillis - m.hVR > m.hVi) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bPD().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.xY("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bPD().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hVA;
            if (dVar.bPI().size() == 0) {
                com.baidu.ubs.analytics.d.b.xY("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bPD().a(true);
                long unused = m.hVR = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.xY("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void aq();

        void ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        hVR = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bPP() {
        return hVQ;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0334a
    public final void T() {
        this.hVS = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hVT != null) {
            this.handler.removeCallbacks(this.hVT);
        }
        if (z) {
            try {
                this.hVU.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.xY("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0334a
    public final void U() {
        this.hVS = true;
        if (this.hVT != null) {
            this.handler.removeCallbacks(this.hVT);
            this.hVT = null;
        }
        hVR = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hVQ.z(String.valueOf(currentTimeMillis));
                try {
                    m.hVQ.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hVQ.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.xY(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.xT(m.hVQ.I())) {
                    pVar.b(m.hVQ);
                } else {
                    pVar.c(m.hVQ);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.hVS) {
                    m.this.foreground = false;
                    try {
                        m.this.hVU.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.xY("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hVT = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0334a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0334a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        hVQ = nVar;
        nVar.setStartTime(String.valueOf(j));
        hVQ.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.xY("超时了……………… 一个新的session");
                new p().c(m.hVQ);
            }
        });
    }
}
