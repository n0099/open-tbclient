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
/* loaded from: classes3.dex */
public final class m implements a.InterfaceC0421a {
    private static long jwu = f.csx();
    private static n jxb;
    private static long jxc;
    private Runnable jxe;
    private boolean foreground = false;
    private boolean jxd = true;
    private Handler handler = new Handler();
    private a jxf = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.EW("app   went foreground ");
            if (currentTimeMillis - m.jxc > m.jwu) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cso().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.EW("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cso().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jwM;
            if (dVar.cst().size() == 0) {
                com.baidu.ubs.analytics.d.b.EW("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cso().a(true);
                long unused = m.jxc = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.EW("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void aq();

        void ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        jxc = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n csE() {
        return jxb;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void T() {
        this.jxd = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.jxe != null) {
            this.handler.removeCallbacks(this.jxe);
        }
        if (z) {
            try {
                this.jxf.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.EW("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void U() {
        this.jxd = true;
        if (this.jxe != null) {
            this.handler.removeCallbacks(this.jxe);
            this.jxe = null;
        }
        jxc = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jxb.z(String.valueOf(currentTimeMillis));
                try {
                    m.jxb.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jxb.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.EW(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.ER(m.jxb.I())) {
                    pVar.b(m.jxb);
                } else {
                    pVar.c(m.jxb);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.jxd) {
                    m.this.foreground = false;
                    try {
                        m.this.jxf.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.EW("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jxe = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jxb = nVar;
        nVar.setStartTime(String.valueOf(j));
        jxb.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.EW("超时了……………… 一个新的session");
                new p().c(m.jxb);
            }
        });
    }
}
