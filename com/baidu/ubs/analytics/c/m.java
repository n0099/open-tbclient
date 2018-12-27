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
public final class m implements a.InterfaceC0348a {
    private static long ifF = f.Z();
    private static n ign;
    private static long igo;
    private Runnable igq;
    private boolean foreground = false;
    private boolean igp = true;
    private Handler handler = new Handler();
    private a igr = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.yE("app   went foreground ");
            if (currentTimeMillis - m.igo > m.ifF) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bSz().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.yE("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bSz().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.ifX;
            if (dVar.bSE().size() == 0) {
                com.baidu.ubs.analytics.d.b.yE("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bSz().a(true);
                long unused = m.igo = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.yE("进入后台但没退出                  ");
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
        igo = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bSL() {
        return ign;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0348a
    public final void T() {
        this.igp = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.igq != null) {
            this.handler.removeCallbacks(this.igq);
        }
        if (z) {
            try {
                this.igr.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.yE("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0348a
    public final void U() {
        this.igp = true;
        if (this.igq != null) {
            this.handler.removeCallbacks(this.igq);
            this.igq = null;
        }
        igo = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.ign.z(String.valueOf(currentTimeMillis));
                try {
                    m.ign.A(String.valueOf(currentTimeMillis - Long.parseLong(m.ign.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.yE(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.yz(m.ign.I())) {
                    pVar.b(m.ign);
                } else {
                    pVar.c(m.ign);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.igp) {
                    m.this.foreground = false;
                    try {
                        m.this.igr.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.yE("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.igq = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0348a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0348a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        ign = nVar;
        nVar.setStartTime(String.valueOf(j));
        ign.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.yE("超时了……………… 一个新的session");
                new p().c(m.ign);
            }
        });
    }
}
