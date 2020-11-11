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
/* loaded from: classes10.dex */
public final class m implements a.InterfaceC0930a {
    private static n orJ;
    private static long orK;
    private static long ora = f.edI();
    private Runnable orN;
    private boolean orL = false;
    private boolean orM = true;
    private Handler handler = new Handler();
    private a orO = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.I("app   went foreground ");
            if (currentTimeMillis - m.orK > m.ora) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.edA().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.I("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.edA().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void edV() {
            d dVar;
            dVar = d.a.ort;
            if (dVar.edF().size() == 0) {
                com.baidu.ubs.analytics.d.b.I("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.edA().a(true);
                long unused = m.orK = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.I("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void aq();

        void edV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        orK = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n edQ() {
        return orJ;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0930a
    public final void T() {
        this.orM = false;
        boolean z = this.orL ? false : true;
        this.orL = true;
        if (this.orN != null) {
            this.handler.removeCallbacks(this.orN);
        }
        if (z) {
            try {
                this.orO.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0930a
    public final void U() {
        this.orM = true;
        if (this.orN != null) {
            this.handler.removeCallbacks(this.orN);
            this.orN = null;
        }
        orK = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.orJ.z(String.valueOf(currentTimeMillis));
                try {
                    m.orJ.A(String.valueOf(currentTimeMillis - Long.parseLong(m.orJ.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.I(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.WX(m.orJ.I())) {
                    pVar.b(m.orJ);
                } else {
                    pVar.c(m.orJ);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.orL && m.this.orM) {
                    m.this.orL = false;
                    try {
                        m.this.orO.edV();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.orN = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0930a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0930a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        orJ = nVar;
        nVar.setStartTime(String.valueOf(j));
        orJ.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.I("超时了……………… 一个新的session");
                new p().c(m.orJ);
            }
        });
    }
}
