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
    private static long ics = f.Z();
    private static n ida;
    private static long idb;
    private Runnable idd;
    private boolean foreground = false;
    private boolean idc = true;
    private Handler handler = new Handler();
    private a ide = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void aq() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.yB("app   went foreground ");
            if (currentTimeMillis - m.idb > m.ics) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.bRJ().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.yB("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.bRJ().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.icK;
            if (dVar.bRO().size() == 0) {
                com.baidu.ubs.analytics.d.b.yB("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.bRJ().a(true);
                long unused = m.idb = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.yB("进入后台但没退出                  ");
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
        idb = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n bRV() {
        return ida;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0348a
    public final void T() {
        this.idc = false;
        boolean z = this.foreground ? false : true;
        this.foreground = true;
        if (this.idd != null) {
            this.handler.removeCallbacks(this.idd);
        }
        if (z) {
            try {
                this.ide.aq();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.yB("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0348a
    public final void U() {
        this.idc = true;
        if (this.idd != null) {
            this.handler.removeCallbacks(this.idd);
            this.idd = null;
        }
        idb = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.ida.z(String.valueOf(currentTimeMillis));
                try {
                    m.ida.A(String.valueOf(currentTimeMillis - Long.parseLong(m.ida.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.yB(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.yw(m.ida.I())) {
                    pVar.b(m.ida);
                } else {
                    pVar.c(m.ida);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.foreground && m.this.idc) {
                    m.this.foreground = false;
                    try {
                        m.this.ide.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.yB("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.idd = runnable;
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
        ida = nVar;
        nVar.setStartTime(String.valueOf(j));
        ida.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.yB("超时了……………… 一个新的session");
                new p().c(m.ida);
            }
        });
    }
}
