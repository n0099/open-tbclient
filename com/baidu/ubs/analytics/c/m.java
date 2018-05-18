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
public final class m implements a.InterfaceC0244a {
    private static long hlz = f.bEU();
    private static n hmj;
    private static long hmk;
    private Runnable hml;
    private boolean foreground = false;
    private boolean aK = true;
    private Handler handler = new Handler();
    private a hmm = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.vn("app   went foreground ");
            if (currentTimeMillis - m.hmk > m.hlz) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bEL().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.vn("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bEL().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hlS;
            if (dVar.bEQ().size() == 0) {
                com.baidu.ubs.analytics.d.b.vn("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bEL().a(true);
                long unused = m.hmk = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.vn("进入后台但没退出                  ");
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
        hmk = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bFb() {
        return hmj;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void T() {
        this.aK = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hml != null) {
            this.handler.removeCallbacks(this.hml);
        }
        if (z) {
            try {
                this.hmm.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.vn("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void U() {
        this.aK = true;
        if (this.hml != null) {
            this.handler.removeCallbacks(this.hml);
            this.hml = null;
        }
        hmk = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hmj.z(String.valueOf(currentTimeMillis));
                try {
                    m.hmj.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hmj.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.vn(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.vi(m.hmj.I())) {
                    pVar.b(m.hmj);
                } else {
                    pVar.c(m.hmj);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.aK) {
                    m.this.foreground = false;
                    try {
                        m.this.hmm.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.vn("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hml = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        hmj = nVar;
        nVar.setStartTime(String.valueOf(j));
        hmj.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.vn("超时了……………… 一个新的session");
                new p().c(m.hmj);
            }
        });
    }
}
