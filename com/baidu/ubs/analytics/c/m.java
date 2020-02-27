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
    private static long kVH = f.cXx();
    private static n kWq;
    private static long kWr;
    private Runnable kWu;
    private boolean kWs = false;
    private boolean kWt = true;
    private Handler handler = new Handler();
    private a kWv = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cXJ() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Ls("app   went foreground ");
            if (currentTimeMillis - m.kWr > m.kVH) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cXm().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Ls("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cXm().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cXK() {
            d dVar;
            dVar = d.a.kVZ;
            if (dVar.cXt().size() == 0) {
                com.baidu.ubs.analytics.d.b.Ls("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cXm().a(true);
                long unused = m.kWr = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Ls("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void cXJ();

        void cXK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        kWr = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cXE() {
        return kWq;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void T() {
        this.kWt = false;
        boolean z = this.kWs ? false : true;
        this.kWs = true;
        if (this.kWu != null) {
            this.handler.removeCallbacks(this.kWu);
        }
        if (z) {
            try {
                this.kWv.cXJ();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Ls("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0642a
    public final void U() {
        this.kWt = true;
        if (this.kWu != null) {
            this.handler.removeCallbacks(this.kWu);
            this.kWu = null;
        }
        kWr = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kWq.z(String.valueOf(currentTimeMillis));
                try {
                    m.kWq.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kWq.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Ls(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Ln(m.kWq.I())) {
                    pVar.b(m.kWq);
                } else {
                    pVar.c(m.kWq);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kWs && m.this.kWt) {
                    m.this.kWs = false;
                    try {
                        m.this.kWv.cXK();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Ls("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kWu = runnable;
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
        kWq = nVar;
        nVar.setStartTime(String.valueOf(j));
        kWq.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Ls("超时了……………… 一个新的session");
                new p().c(m.kWq);
            }
        });
    }
}
