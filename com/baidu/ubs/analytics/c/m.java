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
public final class m implements a.InterfaceC0328a {
    private static long jwL = f.csw();
    private static n jxs;
    private static long jxt;
    private Runnable jxv;
    private boolean foreground = false;
    private boolean jxu = true;
    private Handler handler = new Handler();
    private a jxw = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.EZ("app   went foreground ");
            if (currentTimeMillis - m.jxt > m.jwL) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.csn().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.EZ("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.csn().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jxd;
            if (dVar.css().size() == 0) {
                com.baidu.ubs.analytics.d.b.EZ("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.csn().a(true);
                long unused = m.jxt = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.EZ("进入后台但没退出                  ");
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
        jxt = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n csB() {
        return jxs;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0328a
    public final void T() {
        this.jxu = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.jxv != null) {
            this.handler.removeCallbacks(this.jxv);
        }
        if (z) {
            try {
                this.jxw.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.EZ("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0328a
    public final void U() {
        this.jxu = true;
        if (this.jxv != null) {
            this.handler.removeCallbacks(this.jxv);
            this.jxv = null;
        }
        jxt = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jxs.z(String.valueOf(currentTimeMillis));
                try {
                    m.jxs.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jxs.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.EZ(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.EU(m.jxs.I())) {
                    pVar.b(m.jxs);
                } else {
                    pVar.c(m.jxs);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.jxu) {
                    m.this.foreground = false;
                    try {
                        m.this.jxw.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.EZ("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jxv = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0328a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0328a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jxs = nVar;
        nVar.setStartTime(String.valueOf(j));
        jxs.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.EZ("超时了……………… 一个新的session");
                new p().c(m.jxs);
            }
        });
    }
}
