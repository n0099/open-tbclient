package com.baidu.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static volatile d jXd;
    private ExecutorService bav;
    private ExecutorService bwA;
    private int bwC;
    private boolean bwD = false;
    private com.baidu.ubc.e jXc;
    private com.baidu.ubc.c jXe;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bwC;
        dVar.bwC = i + 1;
        return i;
    }

    static {
        String ad = com.baidu.f.e.ad(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(ad)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.Hd(ad));
            nVar.Yi();
            cDw().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d cDw() {
        if (jXd == null) {
            synchronized (d.class) {
                if (jXd == null) {
                    jXd = new d();
                }
            }
        }
        return jXd;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bwC = com.baidu.f.b.cDB().getInt("ubc_key_flow_handle", 0);
            this.bav = Executors.newSingleThreadExecutor();
            this.bav.execute(new g(this, null));
            this.bwA = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jXc != null && this.jXc.kS(str)) {
                bVar.dr(true);
            }
            this.bav.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jXc != null && this.jXc.kS(str)) {
                bVar.dr(true);
            }
            this.bav.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, String str3, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Hb(str3);
            }
            if (this.jXc != null && this.jXc.kS(str)) {
                bVar.dr(true);
            }
            this.bav.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        if (this.jXc == null || this.jXc.J(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fO(str)) {
                if (this.jXc != null && this.jXc.kQ(str) > 0) {
                    if (new Random().nextInt(100) >= this.jXc.kQ(str)) {
                        return true;
                    }
                }
                return this.jXc != null && this.jXc.kR(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.bav.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bav.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bv;
        bv = bv(str, i);
        if (bv != null && bv.getValid()) {
            RunnableC0444d runnableC0444d = new RunnableC0444d(bv, str2);
            if (this.jXc != null && this.jXc.kS(str)) {
                runnableC0444d.dr(true);
            }
            this.bav.execute(runnableC0444d);
        }
        return bv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bv;
        bv = bv(str, i);
        if (bv != null && bv.getValid()) {
            RunnableC0444d runnableC0444d = new RunnableC0444d(bv, jSONObject);
            if (this.jXc != null && this.jXc.kS(str)) {
                runnableC0444d.dr(true);
            }
            this.bav.execute(runnableC0444d);
        }
        return bv;
    }

    Flow bv(String str, int i) {
        Flow flow = new Flow(str, this.bwC, i);
        if (this.jXc != null && !this.jXc.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fO(str)) {
            flow.setValid(false);
        } else {
            if (this.jXc != null && this.jXc.kQ(str) > 0) {
                if (new Random().nextInt(100) >= this.jXc.kQ(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jXc != null && this.jXc.kR(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void c(String str, int i, String str2) {
        this.bav.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.bav.execute(new e(str, i, jSONArray));
    }

    public void t(String str, int i) {
        this.bav.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jXf;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jXf.jXe != null) {
                this.jXf.jXe.Xx();
            }
        }
    }

    public void a(n nVar) {
        this.bav.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(final JSONObject jSONObject, final String str) {
        this.bwA.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jXe != null) {
                    d.this.jXe.m(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(final JSONObject jSONObject) {
        this.bwA.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jXe != null) {
                    d.this.jXe.bT(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(final String str, final boolean z) {
        this.bav.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jXe != null) {
                    if (z) {
                        d.this.jXe.kK(str);
                    } else {
                        d.this.jXe.kL(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.jXc = com.baidu.ubc.e.cDx();
            d.this.jXe = new com.baidu.ubc.c(d.this.mContext);
            d.this.jXe.XB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jXi;

        b(String str, String str2, int i) {
            this.jXi = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jXi = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jXi = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jXi = new j(str, str2, i, str3, j, i2);
        }

        public void dr(boolean z) {
            if (this.jXi != null) {
                this.jXi.dr(z);
            }
        }

        public void Hb(String str) {
            if (this.jXi != null) {
                this.jXi.rO(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXe != null) {
                this.jXi.XU();
                if (!TextUtils.isEmpty(d.this.jXc.kP(this.jXi.getId()))) {
                    this.jXi.setCategory(d.this.jXc.kP(this.jXi.getId()));
                }
                if ((this.jXi.getOption() & 8) != 0) {
                    d.this.jXe.b(this.jXi);
                } else {
                    d.this.jXe.a(this.jXi);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0444d implements Runnable {
        private k jXj;

        RunnableC0444d(Flow flow, String str) {
            this.jXj = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jXj.ai(flow.getStartTime());
            this.jXj.kV("1");
            d.d(d.this);
        }

        RunnableC0444d(Flow flow, JSONObject jSONObject) {
            this.jXj = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jXj.ai(flow.getStartTime());
            this.jXj.kV("1");
            d.d(d.this);
        }

        public void dr(boolean z) {
            if (this.jXj != null) {
                this.jXj.dr(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXe != null) {
                this.jXj.XU();
                if (!TextUtils.isEmpty(d.this.jXc.kP(this.jXj.getId()))) {
                    this.jXj.setCategory(d.this.jXc.kP(this.jXj.getId()));
                }
                d.this.jXe.b(this.jXj);
                com.baidu.f.b.cDB().putInt("ubc_key_flow_handle", d.this.bwC);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aFY;
        private int bws;
        private String mValue;

        f(String str, int i, String str2) {
            this.aFY = str;
            this.bws = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXe != null) {
                d.this.jXe.c(this.aFY, this.bws, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aFY;
        private long aGT = System.currentTimeMillis();
        private int bws;
        private JSONArray bwy;

        e(String str, int i, JSONArray jSONArray) {
            this.aFY = str;
            this.bws = i;
            this.bwy = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXe != null) {
                d.this.jXe.a(this.aFY, this.bws, this.aGT, this.bwy);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aFY;
        private int bws;

        c(String str, int i) {
            this.aFY = str;
            this.bws = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXe != null) {
                d.this.jXe.t(this.aFY, this.bws);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jXh;

        a(n nVar) {
            this.jXh = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXe != null) {
                d.this.jXe.a(this.jXh);
            }
        }
    }
}
