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
public final class m implements a.InterfaceC0766a {
    private static long miH = f.dsI();
    private static n mjn;
    private static long mjo;
    private Runnable mjr;
    private boolean mjp = false;
    private boolean mjq = true;
    private Handler handler = new Handler();
    private a mjs = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void dsT() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.I("app   went foreground ");
            if (currentTimeMillis - m.mjo > m.miH) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.dsy().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.I("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.dsy().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void dsU() {
            d dVar;
            dVar = d.a.miZ;
            if (dVar.dsE().size() == 0) {
                com.baidu.ubs.analytics.d.b.I("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.dsy().a(true);
                long unused = m.mjo = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.I("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void dsT();

        void dsU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        mjo = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n dsO() {
        return mjn;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0766a
    public final void Nl() {
        this.mjq = false;
        boolean z = this.mjp ? false : true;
        this.mjp = true;
        if (this.mjr != null) {
            this.handler.removeCallbacks(this.mjr);
        }
        if (z) {
            try {
                this.mjs.dsT();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0766a
    public final void U() {
        this.mjq = true;
        if (this.mjr != null) {
            this.handler.removeCallbacks(this.mjr);
            this.mjr = null;
        }
        mjo = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.mjn.z(String.valueOf(currentTimeMillis));
                try {
                    m.mjn.A(String.valueOf(currentTimeMillis - Long.parseLong(m.mjn.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.I(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Ps(m.mjn.I())) {
                    pVar.b(m.mjn);
                } else {
                    pVar.c(m.mjn);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.mjp && m.this.mjq) {
                    m.this.mjp = false;
                    try {
                        m.this.mjs.dsU();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.mjr = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0766a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0766a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        mjn = nVar;
        nVar.setStartTime(String.valueOf(j));
        mjn.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.I("超时了……………… 一个新的session");
                new p().c(m.mjn);
            }
        });
    }
}
