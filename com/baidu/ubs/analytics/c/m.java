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
public final class m implements a.InterfaceC0634a {
    private static long kUW = f.cWh();
    private static n kVF;
    private static long kVG;
    private Runnable kVJ;
    private boolean kVH = false;
    private boolean kVI = true;
    private Handler handler = new Handler();
    private a kVK = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cWt() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Lf("app   went foreground ");
            if (currentTimeMillis - m.kVG > m.kUW) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cVW().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Lf("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cVW().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cWu() {
            d dVar;
            dVar = d.a.kVo;
            if (dVar.cWd().size() == 0) {
                com.baidu.ubs.analytics.d.b.Lf("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cVW().a(true);
                long unused = m.kVG = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Lf("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cWt();

        void cWu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        kVG = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cWo() {
        return kVF;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0634a
    public final void T() {
        this.kVI = false;
        boolean z = this.kVH ? false : true;
        this.kVH = true;
        if (this.kVJ != null) {
            this.handler.removeCallbacks(this.kVJ);
        }
        if (z) {
            try {
                this.kVK.cWt();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Lf("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0634a
    public final void U() {
        this.kVI = true;
        if (this.kVJ != null) {
            this.handler.removeCallbacks(this.kVJ);
            this.kVJ = null;
        }
        kVG = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kVF.z(String.valueOf(currentTimeMillis));
                try {
                    m.kVF.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kVF.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Lf(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.La(m.kVF.I())) {
                    pVar.b(m.kVF);
                } else {
                    pVar.c(m.kVF);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kVH && m.this.kVI) {
                    m.this.kVH = false;
                    try {
                        m.this.kVK.cWu();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Lf("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kVJ = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0634a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0634a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        kVF = nVar;
        nVar.setStartTime(String.valueOf(j));
        kVF.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Lf("超时了……………… 一个新的session");
                new p().c(m.kVF);
            }
        });
    }
}
