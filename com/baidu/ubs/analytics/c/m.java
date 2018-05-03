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
    private static long hkv = f.bEW();
    private static n hlf;
    private static long hlg;
    private Runnable hlh;
    private boolean foreground = false;
    private boolean aK = true;
    private Handler handler = new Handler();
    private a hli = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.vk("app   went foreground ");
            if (currentTimeMillis - m.hlg > m.hkv) {
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
            dVar = d.a.hkO;
            if (dVar.bES().size() == 0) {
                com.baidu.ubs.analytics.d.b.vk("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bEN().a(true);
                long unused = m.hlg = 0L;
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
        hlg = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bFd() {
        return hlf;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void T() {
        this.aK = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.hlh != null) {
            this.handler.removeCallbacks(this.hlh);
        }
        if (z) {
            try {
                this.hli.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.vk("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0244a
    public final void U() {
        this.aK = true;
        if (this.hlh != null) {
            this.handler.removeCallbacks(this.hlh);
            this.hlh = null;
        }
        hlg = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.hlf.z(String.valueOf(currentTimeMillis));
                try {
                    m.hlf.A(String.valueOf(currentTimeMillis - Long.parseLong(m.hlf.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.vk(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.vf(m.hlf.I())) {
                    pVar.b(m.hlf);
                } else {
                    pVar.c(m.hlf);
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
                        m.this.hli.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.vk("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.hlh = runnable;
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
        hlf = nVar;
        nVar.setStartTime(String.valueOf(j));
        hlf.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.vk("超时了……………… 一个新的session");
                new p().c(m.hlf);
            }
        });
    }
}
