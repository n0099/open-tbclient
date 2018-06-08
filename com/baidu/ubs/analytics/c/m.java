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
/* loaded from: classes.dex */
public final class m implements a.InterfaceC0261a {
    private static long hxu = f.bJY();
    private static n hyd;
    private static long hye;
    private Runnable hyg;
    private boolean foreground = false;
    private boolean hyf = true;
    private Handler handler = new Handler();
    private a hyh = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.wh("app   went foreground ");
            if (currentTimeMillis - m.hye > m.hxu) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bJP().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.wh("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bJP().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hxN;
            if (dVar.bJU().size() == 0) {
                com.baidu.ubs.analytics.d.b.wh("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bJP().a(true);
                long unused = m.hye = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.wh("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aq();

        void ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        hye = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bKe() {
        return hyd;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0261a
    public final void T() {
        this.hyf = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hyg != null) {
            this.handler.removeCallbacks(this.hyg);
        }
        if (z) {
            try {
                this.hyh.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.wh("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0261a
    public final void U() {
        this.hyf = true;
        if (this.hyg != null) {
            this.handler.removeCallbacks(this.hyg);
            this.hyg = null;
        }
        hye = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hyd.z(String.valueOf(currentTimeMillis));
                try {
                    m.hyd.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hyd.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.wh(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.wc(m.hyd.I())) {
                    pVar.b(m.hyd);
                } else {
                    pVar.c(m.hyd);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.hyf) {
                    m.this.foreground = false;
                    try {
                        m.this.hyh.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.wh("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hyg = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0261a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0261a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        hyd = nVar;
        nVar.setStartTime(String.valueOf(j));
        hyd.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.wh("超时了……………… 一个新的session");
                new p().c(m.hyd);
            }
        });
    }
}
