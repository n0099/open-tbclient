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
/* loaded from: classes17.dex */
public final class m implements a.InterfaceC0950a {
    private static long oHP = f.ejw();
    private static n oIx;
    private static long oIy;
    private Runnable oIA;
    private boolean oIz = false;
    private boolean aK = true;
    private Handler handler = new Handler();
    private a oIB = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.I("app   went foreground ");
            if (currentTimeMillis - m.oIy > m.oHP) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.ejo().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.I("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.ejo().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.oIh;
            if (dVar.ejt().size() == 0) {
                com.baidu.ubs.analytics.d.b.I("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.ejo().a(true);
                long unused = m.oIy = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.I("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes17.dex */
    public interface a {
        void aq();

        void ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        oIy = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n ejD() {
        return oIx;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0950a
    public final void T() {
        this.aK = false;
        boolean z = this.oIz ? false : true;
        this.oIz = true;
        if (this.oIA != null) {
            this.handler.removeCallbacks(this.oIA);
        }
        if (z) {
            try {
                this.oIB.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0950a
    public final void U() {
        this.aK = true;
        if (this.oIA != null) {
            this.handler.removeCallbacks(this.oIA);
            this.oIA = null;
        }
        oIy = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.oIx.z(String.valueOf(currentTimeMillis));
                try {
                    m.oIx.A(String.valueOf(currentTimeMillis - Long.parseLong(m.oIx.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.I(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Yb(m.oIx.I())) {
                    pVar.b(m.oIx);
                } else {
                    pVar.c(m.oIx);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.oIz && m.this.aK) {
                    m.this.oIz = false;
                    try {
                        m.this.oIB.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.oIA = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0950a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0950a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        oIx = nVar;
        nVar.setStartTime(String.valueOf(j));
        oIx.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.I("超时了……………… 一个新的session");
                new p().c(m.oIx);
            }
        });
    }
}
