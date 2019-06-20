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
    private static volatile d jOY;
    private ExecutorService aZL;
    private ExecutorService bvK;
    private int bvM;
    private boolean bvN = false;
    private com.baidu.ubc.e jOX;
    private com.baidu.ubc.c jOZ;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bvM;
        dVar.bvM = i + 1;
        return i;
    }

    static {
        String ae = com.baidu.f.e.ae(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(ae)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.Gi(ae));
            nVar.Xm();
            cAd().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d cAd() {
        if (jOY == null) {
            synchronized (d.class) {
                if (jOY == null) {
                    jOY = new d();
                }
            }
        }
        return jOY;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bvM = com.baidu.f.b.cAi().getInt("ubc_key_flow_handle", 0);
            this.aZL = Executors.newSingleThreadExecutor();
            this.aZL.execute(new g(this, null));
            this.bvK = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jOX != null && this.jOX.kK(str)) {
                bVar.dm(true);
            }
            this.aZL.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jOX != null && this.jOX.kK(str)) {
                bVar.dm(true);
            }
            this.aZL.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, String str3, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Gg(str3);
            }
            if (this.jOX != null && this.jOX.kK(str)) {
                bVar.dm(true);
            }
            this.aZL.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        if (this.jOX == null || this.jOX.J(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fJ(str)) {
                if (this.jOX != null && this.jOX.kI(str) > 0) {
                    if (new Random().nextInt(100) >= this.jOX.kI(str)) {
                        return true;
                    }
                }
                return this.jOX != null && this.jOX.kJ(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.aZL.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.aZL.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bu;
        bu = bu(str, i);
        if (bu != null && bu.getValid()) {
            RunnableC0439d runnableC0439d = new RunnableC0439d(bu, str2);
            if (this.jOX != null && this.jOX.kK(str)) {
                runnableC0439d.dm(true);
            }
            this.aZL.execute(runnableC0439d);
        }
        return bu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bu;
        bu = bu(str, i);
        if (bu != null && bu.getValid()) {
            RunnableC0439d runnableC0439d = new RunnableC0439d(bu, jSONObject);
            if (this.jOX != null && this.jOX.kK(str)) {
                runnableC0439d.dm(true);
            }
            this.aZL.execute(runnableC0439d);
        }
        return bu;
    }

    Flow bu(String str, int i) {
        Flow flow = new Flow(str, this.bvM, i);
        if (this.jOX != null && !this.jOX.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fJ(str)) {
            flow.setValid(false);
        } else {
            if (this.jOX != null && this.jOX.kI(str) > 0) {
                if (new Random().nextInt(100) >= this.jOX.kI(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jOX != null && this.jOX.kJ(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void c(String str, int i, String str2) {
        this.aZL.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.aZL.execute(new e(str, i, jSONArray));
    }

    public void t(String str, int i) {
        this.aZL.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jPa;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jPa.jOZ != null) {
                this.jPa.jOZ.WD();
            }
        }
    }

    public void a(n nVar) {
        this.aZL.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(final JSONObject jSONObject, final String str) {
        this.bvK.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jOZ != null) {
                    d.this.jOZ.m(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(final JSONObject jSONObject) {
        this.bvK.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jOZ != null) {
                    d.this.jOZ.bT(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(final String str, final boolean z) {
        this.aZL.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jOZ != null) {
                    if (z) {
                        d.this.jOZ.kC(str);
                    } else {
                        d.this.jOZ.kD(str);
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
            d.this.jOX = com.baidu.ubc.e.cAe();
            d.this.jOZ = new com.baidu.ubc.c(d.this.mContext);
            d.this.jOZ.WH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jPd;

        b(String str, String str2, int i) {
            this.jPd = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jPd = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jPd = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jPd = new j(str, str2, i, str3, j, i2);
        }

        public void dm(boolean z) {
            if (this.jPd != null) {
                this.jPd.dm(z);
            }
        }

        public void Gg(String str) {
            if (this.jPd != null) {
                this.jPd.rw(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jOZ != null) {
                this.jPd.WZ();
                if (!TextUtils.isEmpty(d.this.jOX.kH(this.jPd.getId()))) {
                    this.jPd.setCategory(d.this.jOX.kH(this.jPd.getId()));
                }
                if ((this.jPd.getOption() & 8) != 0) {
                    d.this.jOZ.b(this.jPd);
                } else {
                    d.this.jOZ.a(this.jPd);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0439d implements Runnable {
        private k jPe;

        RunnableC0439d(Flow flow, String str) {
            this.jPe = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jPe.ah(flow.getStartTime());
            this.jPe.kN("1");
            d.d(d.this);
        }

        RunnableC0439d(Flow flow, JSONObject jSONObject) {
            this.jPe = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jPe.ah(flow.getStartTime());
            this.jPe.kN("1");
            d.d(d.this);
        }

        public void dm(boolean z) {
            if (this.jPe != null) {
                this.jPe.dm(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jOZ != null) {
                this.jPe.WZ();
                if (!TextUtils.isEmpty(d.this.jOX.kH(this.jPe.getId()))) {
                    this.jPe.setCategory(d.this.jOX.kH(this.jPe.getId()));
                }
                d.this.jOZ.b(this.jPe);
                com.baidu.f.b.cAi().putInt("ubc_key_flow_handle", d.this.bvM);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aFq;
        private int bvC;
        private String mValue;

        f(String str, int i, String str2) {
            this.aFq = str;
            this.bvC = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jOZ != null) {
                d.this.jOZ.c(this.aFq, this.bvC, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aFq;
        private long aGl = System.currentTimeMillis();
        private int bvC;
        private JSONArray bvI;

        e(String str, int i, JSONArray jSONArray) {
            this.aFq = str;
            this.bvC = i;
            this.bvI = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jOZ != null) {
                d.this.jOZ.a(this.aFq, this.bvC, this.aGl, this.bvI);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aFq;
        private int bvC;

        c(String str, int i) {
            this.aFq = str;
            this.bvC = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jOZ != null) {
                d.this.jOZ.t(this.aFq, this.bvC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jPc;

        a(n nVar) {
            this.jPc = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jOZ != null) {
                d.this.jOZ.a(this.jPc);
            }
        }
    }
}
