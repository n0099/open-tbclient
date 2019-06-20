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
public final class m implements a.InterfaceC0440a {
    private static n jPV;
    private static long jPW;
    private static long jPo = f.cAv();
    private Runnable jPY;
    private boolean foreground = false;
    private boolean jPX = true;
    private Handler handler = new Handler();
    private a jPZ = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Gt("app   went foreground ");
            if (currentTimeMillis - m.jPW > m.jPo) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cAm().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Gt("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cAm().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jPG;
            if (dVar.cAr().size() == 0) {
                com.baidu.ubs.analytics.d.b.Gt("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cAm().a(true);
                long unused = m.jPW = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Gt("进入后台但没退出                  ");
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
        jPW = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cAC() {
        return jPV;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void T() {
        this.jPX = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.jPY != null) {
            this.handler.removeCallbacks(this.jPY);
        }
        if (z) {
            try {
                this.jPZ.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Gt("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void U() {
        this.jPX = true;
        if (this.jPY != null) {
            this.handler.removeCallbacks(this.jPY);
            this.jPY = null;
        }
        jPW = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jPV.z(String.valueOf(currentTimeMillis));
                try {
                    m.jPV.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jPV.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Gt(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Go(m.jPV.I())) {
                    pVar.b(m.jPV);
                } else {
                    pVar.c(m.jPV);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.jPX) {
                    m.this.foreground = false;
                    try {
                        m.this.jPZ.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Gt("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jPY = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0440a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jPV = nVar;
        nVar.setStartTime(String.valueOf(j));
        jPV.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Gt("超时了……………… 一个新的session");
                new p().c(m.jPV);
            }
        });
    }
}
