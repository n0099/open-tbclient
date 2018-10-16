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
public final class m implements a.InterfaceC0306a {
    private static long hTx = f.bQo();
    private static n hUf;
    private static long hUg;
    private Runnable hUi;
    private boolean foreground = false;
    private boolean hUh = true;
    private Handler handler = new Handler();
    private a hUj = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.xT("app   went foreground ");
            if (currentTimeMillis - m.hUg > m.hTx) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bQf().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.xT("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bQf().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hTP;
            if (dVar.bQk().size() == 0) {
                com.baidu.ubs.analytics.d.b.xT("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bQf().a(true);
                long unused = m.hUg = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.xT("进入后台但没退出                  ");
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
        hUg = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bQu() {
        return hUf;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0306a
    public final void T() {
        this.hUh = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hUi != null) {
            this.handler.removeCallbacks(this.hUi);
        }
        if (z) {
            try {
                this.hUj.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.xT("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0306a
    public final void U() {
        this.hUh = true;
        if (this.hUi != null) {
            this.handler.removeCallbacks(this.hUi);
            this.hUi = null;
        }
        hUg = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hUf.z(String.valueOf(currentTimeMillis));
                try {
                    m.hUf.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hUf.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.xT(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.xO(m.hUf.I())) {
                    pVar.b(m.hUf);
                } else {
                    pVar.c(m.hUf);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.hUh) {
                    m.this.foreground = false;
                    try {
                        m.this.hUj.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.xT("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hUi = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0306a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0306a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        hUf = nVar;
        nVar.setStartTime(String.valueOf(j));
        hUf.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.xT("超时了……………… 一个新的session");
                new p().c(m.hUf);
            }
        });
    }
}
