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
    private static long hky = f.bEW();
    private static n hli;
    private static long hlj;
    private Runnable hlk;
    private boolean foreground = false;
    private boolean aK = true;
    private Handler handler = new Handler();
    private a hll = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.vk("app   went foreground ");
            if (currentTimeMillis - m.hlj > m.hky) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bEN().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.vk("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bEN().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.hkR;
            if (dVar.bES().size() == 0) {
                com.baidu.ubs.analytics.d.b.vk("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bEN().a(true);
                long unused = m.hlj = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.vk("进入后台但没退出                  ");
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
        hlj = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bFd() {
        return hli;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void T() {
        this.aK = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hlk != null) {
            this.handler.removeCallbacks(this.hlk);
        }
        if (z) {
            try {
                this.hll.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.vk("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void U() {
        this.aK = true;
        if (this.hlk != null) {
            this.handler.removeCallbacks(this.hlk);
            this.hlk = null;
        }
        hlj = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hli.z(String.valueOf(currentTimeMillis));
                try {
                    m.hli.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hli.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.vk(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.vf(m.hli.I())) {
                    pVar.b(m.hli);
                } else {
                    pVar.c(m.hli);
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
                        m.this.hll.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.vk("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hlk = runnable;
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
        hli = nVar;
        nVar.setStartTime(String.valueOf(j));
        hli.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.vk("超时了……………… 一个新的session");
                new p().c(m.hli);
            }
        });
    }
}
