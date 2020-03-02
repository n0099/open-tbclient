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
    private static long kVJ = f.cXz();
    private static n kWs;
    private static long kWt;
    private Runnable kWw;
    private boolean kWu = false;
    private boolean kWv = true;
    private Handler handler = new Handler();
    private a kWx = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cXL() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Ls("app   went foreground ");
            if (currentTimeMillis - m.kWt > m.kVJ) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cXo().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Ls("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cXo().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cXM() {
            d dVar;
            dVar = d.a.kWb;
            if (dVar.cXv().size() == 0) {
                com.baidu.ubs.analytics.d.b.Ls("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cXo().a(true);
                long unused = m.kWt = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Ls("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void cXL();

        void cXM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        kWt = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cXG() {
        return kWs;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void T() {
        this.kWv = false;
        boolean z = this.kWu ? false : true;
        this.kWu = true;
        if (this.kWw != null) {
            this.handler.removeCallbacks(this.kWw);
        }
        if (z) {
            try {
                this.kWx.cXL();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Ls("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void U() {
        this.kWv = true;
        if (this.kWw != null) {
            this.handler.removeCallbacks(this.kWw);
            this.kWw = null;
        }
        kWt = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kWs.z(String.valueOf(currentTimeMillis));
                try {
                    m.kWs.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kWs.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Ls(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Ln(m.kWs.I())) {
                    pVar.b(m.kWs);
                } else {
                    pVar.c(m.kWs);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kWu && m.this.kWv) {
                    m.this.kWu = false;
                    try {
                        m.this.kWx.cXM();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Ls("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kWw = runnable;
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
        kWs = nVar;
        nVar.setStartTime(String.valueOf(j));
        kWs.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Ls("超时了……………… 一个新的session");
                new p().c(m.kWs);
            }
        });
    }
}
