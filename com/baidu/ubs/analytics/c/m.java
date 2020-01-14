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
    private static n kVK;
    private static long kVL;
    private static long kVb = f.cWj();
    private Runnable kVO;
    private boolean kVM = false;
    private boolean kVN = true;
    private Handler handler = new Handler();
    private a kVP = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cWv() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.Lf("app   went foreground ");
            if (currentTimeMillis - m.kVL > m.kVb) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.cVY().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.Lf("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.cVY().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void cWw() {
            d dVar;
            dVar = d.a.kVt;
            if (dVar.cWf().size() == 0) {
                com.baidu.ubs.analytics.d.b.Lf("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.cVY().a(true);
                long unused = m.kVL = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.Lf("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cWv();

        void cWw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        kVL = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n cWq() {
        return kVK;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0634a
    public final void T() {
        this.kVN = false;
        boolean z = this.kVM ? false : true;
        this.kVM = true;
        if (this.kVO != null) {
            this.handler.removeCallbacks(this.kVO);
        }
        if (z) {
            try {
                this.kVP.cWv();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.Lf("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0634a
    public final void U() {
        this.kVN = true;
        if (this.kVO != null) {
            this.handler.removeCallbacks(this.kVO);
            this.kVO = null;
        }
        kVL = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.kVK.z(String.valueOf(currentTimeMillis));
                try {
                    m.kVK.A(String.valueOf(currentTimeMillis - Long.parseLong(m.kVK.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.Lf(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.La(m.kVK.I())) {
                    pVar.b(m.kVK);
                } else {
                    pVar.c(m.kVK);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.kVM && m.this.kVN) {
                    m.this.kVM = false;
                    try {
                        m.this.kVP.cWw();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Lf("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.kVO = runnable;
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
        kVK = nVar;
        nVar.setStartTime(String.valueOf(j));
        kVK.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.Lf("超时了……………… 一个新的session");
                new p().c(m.kVK);
            }
        });
    }
}
