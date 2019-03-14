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
    private static long jwD = f.csz();
    private static n jxk;
    private static long jxl;
    private Runnable jxn;
    private boolean foreground = false;
    private boolean jxm = true;
    private Handler handler = new Handler();
    private a jxo = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.EX("app   went foreground ");
            if (currentTimeMillis - m.jxl > m.jwD) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.csq().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.EX("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.csq().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jwV;
            if (dVar.csv().size() == 0) {
                com.baidu.ubs.analytics.d.b.EX("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.csq().a(true);
                long unused = m.jxl = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.EX("进入后台但没退出                  ");
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
        jxl = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n csE() {
        return jxk;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void T() {
        this.jxm = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.jxn != null) {
            this.handler.removeCallbacks(this.jxn);
        }
        if (z) {
            try {
                this.jxo.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.EX("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0421a
    public final void U() {
        this.jxm = true;
        if (this.jxn != null) {
            this.handler.removeCallbacks(this.jxn);
            this.jxn = null;
        }
        jxl = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jxk.z(String.valueOf(currentTimeMillis));
                try {
                    m.jxk.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jxk.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.EX(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.ES(m.jxk.I())) {
                    pVar.b(m.jxk);
                } else {
                    pVar.c(m.jxk);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.jxm) {
                    m.this.foreground = false;
                    try {
                        m.this.jxo.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.EX("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jxn = runnable;
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
        jxk = nVar;
        nVar.setStartTime(String.valueOf(j));
        jxk.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.EX("超时了……………… 一个新的session");
                new p().c(m.jxk);
            }
        });
    }
}
