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
public final class m implements a.InterfaceC0445a {
    private static n jWV;
    private static long jWW;
    private static long jWn = f.cDu();
    private Runnable jWZ;
    private boolean jWX = false;
    private boolean jWY = true;
    private Handler handler = new Handler();
    private a jXa = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Hn("app   went foreground ");
            if (currentTimeMillis - m.jWW > m.jWn) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cDk().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Hn("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cDk().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.jWF;
            if (dVar.cDq().size() == 0) {
                com.baidu.ubs.analytics.d.b.Hn("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cDk().a(true);
                long unused = m.jWW = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Hn("进入后台但没退出                  ");
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
        jWW = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cDB() {
        return jWV;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void T() {
        this.jWY = false;
        boolean z = this.jWX ? false : true;
        this.jWX = true;
        if (this.jWZ != null) {
            this.handler.removeCallbacks(this.jWZ);
        }
        if (z) {
            try {
                this.jXa.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Hn("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void U() {
        this.jWY = true;
        if (this.jWZ != null) {
            this.handler.removeCallbacks(this.jWZ);
            this.jWZ = null;
        }
        jWW = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.jWV.z(String.valueOf(currentTimeMillis));
                try {
                    m.jWV.A(String.valueOf(currentTimeMillis - Long.parseLong(m.jWV.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Hn(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.Hi(m.jWV.I())) {
                    pVar.b(m.jWV);
                } else {
                    pVar.c(m.jWV);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.jWX && m.this.jWY) {
                    m.this.jWX = false;
                    try {
                        m.this.jXa.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Hn("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.jWZ = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        jWV = nVar;
        nVar.setStartTime(String.valueOf(j));
        jWV.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Hn("超时了……………… 一个新的session");
                new p().c(m.jWV);
            }
        });
    }
}
