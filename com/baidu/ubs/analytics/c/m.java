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
public final class m implements a.InterfaceC0643a {
    private static long kXy = f.cXY();
    private static n kYh;
    private static long kYi;
    private Runnable kYl;
    private boolean kYj = false;
    private boolean kYk = true;
    private Handler handler = new Handler();
    private a kYm = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cYj() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Ls("app   went foreground ");
            if (currentTimeMillis - m.kYi > m.kXy) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cXN().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Ls("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cXN().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cYk() {
            d dVar;
            dVar = d.a.kXQ;
            if (dVar.cXU().size() == 0) {
                com.baidu.ubs.analytics.d.b.Ls("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cXN().a(true);
                long unused = m.kYi = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Ls("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void cYj();

        void cYk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        kYi = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cYe() {
        return kYh;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void T() {
        this.kYk = false;
        boolean z = this.kYj ? false : true;
        this.kYj = true;
        if (this.kYl != null) {
            this.handler.removeCallbacks(this.kYl);
        }
        if (z) {
            try {
                this.kYm.cYj();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Ls("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void U() {
        this.kYk = true;
        if (this.kYl != null) {
            this.handler.removeCallbacks(this.kYl);
            this.kYl = null;
        }
        kYi = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kYh.z(String.valueOf(currentTimeMillis));
                try {
                    m.kYh.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kYh.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Ls(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Ln(m.kYh.I())) {
                    pVar.b(m.kYh);
                } else {
                    pVar.c(m.kYh);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kYj && m.this.kYk) {
                    m.this.kYj = false;
                    try {
                        m.this.kYm.cYk();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Ls("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kYl = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        kYh = nVar;
        nVar.setStartTime(String.valueOf(j));
        kYh.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Ls("超时了……………… 一个新的session");
                new p().c(m.kYh);
            }
        });
    }
}
