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
public final class m implements a.InterfaceC0796a {
    private static long mMH = f.dAD();
    private static n mNp;
    private static long mNq;
    private Runnable mNt;
    private boolean mNr = false;
    private boolean mNs = true;
    private Handler handler = new Handler();
    private a mNu = new a() { // from class: com.baidu.ubs.analytics.c.m.1
        @Override // com.baidu.ubs.analytics.c.m.a
        public final void dAO() {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.ubs.analytics.d.b.I("app   went foreground ");
            if (currentTimeMillis - m.mNq > m.mMH) {
                m.this.d(currentTimeMillis);
            }
            if (com.baidu.ubs.analytics.d.dAu().i()) {
                com.baidu.ubs.analytics.d.c.a(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.1.1
                    @Override // com.baidu.ubs.analytics.d.d
                    protected final void a() {
                        com.baidu.ubs.analytics.d.b.I("记录一次app启动事件");
                        com.baidu.ubs.analytics.a.a("power_on", "", "", null);
                        com.baidu.ubs.analytics.d.dAu().a(false);
                    }
                });
            }
        }

        @Override // com.baidu.ubs.analytics.c.m.a
        public final void ar() {
            d dVar;
            dVar = d.a.mMZ;
            if (dVar.dAz().size() == 0) {
                com.baidu.ubs.analytics.d.b.I("后台应用退出了 了               ");
                com.baidu.ubs.analytics.d.dAu().a(true);
                long unused = m.mNq = 0L;
                return;
            }
            com.baidu.ubs.analytics.d.b.I("进入后台但没退出                  ");
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void ar();

        void dAO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        mNq = currentTimeMillis;
        d(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n dAJ() {
        return mNp;
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0796a
    public final void T() {
        this.mNs = false;
        boolean z = this.mNr ? false : true;
        this.mNr = true;
        if (this.mNt != null) {
            this.handler.removeCallbacks(this.mNt);
        }
        if (z) {
            try {
                this.mNu.dAO();
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
            }
        }
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0796a
    public final void U() {
        this.mNs = true;
        if (this.mNt != null) {
            this.handler.removeCallbacks(this.mNt);
            this.mNt = null;
        }
        mNq = System.currentTimeMillis();
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.3
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                long currentTimeMillis = System.currentTimeMillis();
                m.mNp.z(String.valueOf(currentTimeMillis));
                try {
                    m.mNp.A(String.valueOf(currentTimeMillis - Long.parseLong(m.mNp.N())));
                } catch (NumberFormatException e) {
                    com.baidu.ubs.analytics.d.b.I(e.getLocalizedMessage());
                }
                p pVar = new p();
                if (pVar.QQ(m.mNp.I())) {
                    pVar.b(m.mNp);
                } else {
                    pVar.c(m.mNp);
                }
            }
        });
        Handler handler = this.handler;
        Runnable runnable = new Runnable() { // from class: com.baidu.ubs.analytics.c.m.2
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.mNr && m.this.mNs) {
                    m.this.mNr = false;
                    try {
                        m.this.mNu.ar();
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.I("Listener threw exception!:" + e.toString());
                    }
                }
            }
        };
        this.mNt = runnable;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0796a
    public final void a(Activity activity) {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0796a
    public final void onActivityDestroyed(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        n nVar = new n();
        mNp = nVar;
        nVar.setStartTime(String.valueOf(j));
        mNp.x(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.m.4
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                com.baidu.ubs.analytics.d.b.I("超时了……………… 一个新的session");
                new p().c(m.mNp);
            }
        });
    }
}
