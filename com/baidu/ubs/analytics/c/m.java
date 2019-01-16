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
/* loaded from: classes6.dex */
public final class m implements a.InterfaceC0347a {
    private static long igM = f.Z();
    private static n ihu;
    private static long ihv;
    private Runnable ihx;
    private boolean foreground = false;
    private boolean ihw = true;
    private Handler handler = new Handler();
    private a ihy = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.yU("app   went foreground ");
            if (currentTimeMillis - m.ihv > m.igM) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bTh().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.yU("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bTh().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.ihe;
            if (dVar.bTm().size() == 0) {
                com.baidu.ubs.analytics.d.b.yU("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bTh().a(true);
                long unused = m.ihv = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.yU("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void aq();

        void ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        ihv = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bTt() {
        return ihu;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0347a
    public final void T() {
        this.ihw = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.ihx != null) {
            this.handler.removeCallbacks(this.ihx);
        }
        if (z) {
            try {
                this.ihy.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.yU("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0347a
    public final void U() {
        this.ihw = true;
        if (this.ihx != null) {
            this.handler.removeCallbacks(this.ihx);
            this.ihx = null;
        }
        ihv = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.ihu.z(String.valueOf(currentTimeMillis));
                try {
                    m.ihu.A(String.valueOf(currentTimeMillis - Long.parseLong(m.ihu.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.yU(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.yP(m.ihu.I())) {
                    pVar.b(m.ihu);
                } else {
                    pVar.c(m.ihu);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.ihw) {
                    m.this.foreground = false;
                    try {
                        m.this.ihy.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.yU("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.ihx = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0347a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0347a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        ihu = nVar;
        nVar.setStartTime(String.valueOf(j));
        ihu.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.yU("超时了……………… 一个新的session");
                new p().c(m.ihu);
            }
        });
    }
}
