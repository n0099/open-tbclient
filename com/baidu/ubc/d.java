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
    private static volatile d jXz;
    private ExecutorService bPF;
    private int bPH;
    private boolean bPI = false;
    private ExecutorService btS;
    private com.baidu.ubc.c jXA;
    private com.baidu.ubc.e jXy;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bPH;
        dVar.bPH = i + 1;
        return i;
    }

    static {
        String ac = com.baidu.f.e.ac(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(ac)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.FU(ac));
            nVar.adc();
            cAU().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d cAU() {
        if (jXz == null) {
            synchronized (d.class) {
                if (jXz == null) {
                    jXz = new d();
                }
            }
        }
        return jXz;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bPH = com.baidu.f.b.cAZ().getInt("ubc_key_flow_handle", 0);
            this.btS = Executors.newSingleThreadExecutor();
            this.btS.execute(new g(this, null));
            this.bPF = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jXy != null && this.jXy.lw(str)) {
                bVar.dI(true);
            }
            this.btS.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jXy != null && this.jXy.lw(str)) {
                bVar.dI(true);
            }
            this.btS.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.FS(str3);
            }
            if (this.jXy != null && this.jXy.lw(str)) {
                bVar.dI(true);
            }
            this.btS.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        if (this.jXy == null || this.jXy.J(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().gv(str)) {
                if (this.jXy != null && this.jXy.lu(str) > 0) {
                    if (new Random().nextInt(100) >= this.jXy.lu(str)) {
                        return true;
                    }
                }
                return this.jXy != null && this.jXy.lv(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.btS.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.btS.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bs;
        bs = bs(str, i);
        if (bs != null && bs.getValid()) {
            RunnableC0550d runnableC0550d = new RunnableC0550d(bs, str2);
            if (this.jXy != null && this.jXy.lw(str)) {
                runnableC0550d.dI(true);
            }
            this.btS.execute(runnableC0550d);
        }
        return bs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bs;
        bs = bs(str, i);
        if (bs != null && bs.getValid()) {
            RunnableC0550d runnableC0550d = new RunnableC0550d(bs, jSONObject);
            if (this.jXy != null && this.jXy.lw(str)) {
                runnableC0550d.dI(true);
            }
            this.btS.execute(runnableC0550d);
        }
        return bs;
    }

    Flow bs(String str, int i) {
        Flow flow = new Flow(str, this.bPH, i);
        if (this.jXy != null && !this.jXy.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().gv(str)) {
            flow.setValid(false);
        } else {
            if (this.jXy != null && this.jXy.lu(str) > 0) {
                if (new Random().nextInt(100) >= this.jXy.lu(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jXy != null && this.jXy.lv(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void e(String str, int i, String str2) {
        this.btS.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.btS.execute(new e(str, i, jSONArray));
    }

    public void t(String str, int i) {
        this.btS.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jXB;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jXB.jXA != null) {
                this.jXB.jXA.acq();
            }
        }
    }

    public void a(n nVar) {
        this.btS.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(final JSONObject jSONObject, final String str) {
        this.bPF.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jXA != null) {
                    d.this.jXA.m(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cs(final JSONObject jSONObject) {
        this.bPF.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jXA != null) {
                    d.this.jXA.cs(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(final String str, final boolean z) {
        this.btS.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jXA != null) {
                    if (z) {
                        d.this.jXA.lo(str);
                    } else {
                        d.this.jXA.lp(str);
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
            d.this.jXy = com.baidu.ubc.e.cAV();
            d.this.jXA = new com.baidu.ubc.c(d.this.mContext);
            d.this.jXA.acu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jXE;

        b(String str, String str2, int i) {
            this.jXE = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jXE = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jXE = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jXE = new j(str, str2, i, str3, j, i2);
        }

        public void dI(boolean z) {
            if (this.jXE != null) {
                this.jXE.dI(z);
            }
        }

        public void FS(String str) {
            if (this.jXE != null) {
                this.jXE.qJ(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXA != null) {
                this.jXE.acN();
                if (!TextUtils.isEmpty(d.this.jXy.lt(this.jXE.getId()))) {
                    this.jXE.setCategory(d.this.jXy.lt(this.jXE.getId()));
                }
                if ((this.jXE.getOption() & 8) != 0) {
                    d.this.jXA.b(this.jXE);
                } else {
                    d.this.jXA.a(this.jXE);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0550d implements Runnable {
        private k jXF;

        RunnableC0550d(Flow flow, String str) {
            this.jXF = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jXF.aB(flow.getStartTime());
            this.jXF.lz("1");
            d.d(d.this);
        }

        RunnableC0550d(Flow flow, JSONObject jSONObject) {
            this.jXF = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jXF.aB(flow.getStartTime());
            this.jXF.lz("1");
            d.d(d.this);
        }

        public void dI(boolean z) {
            if (this.jXF != null) {
                this.jXF.dI(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXA != null) {
                this.jXF.acN();
                if (!TextUtils.isEmpty(d.this.jXy.lt(this.jXF.getId()))) {
                    this.jXF.setCategory(d.this.jXy.lt(this.jXF.getId()));
                }
                d.this.jXA.b(this.jXF);
                com.baidu.f.b.cAZ().putInt("ubc_key_flow_handle", d.this.bPH);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aZL;
        private int bPx;
        private String mValue;

        f(String str, int i, String str2) {
            this.aZL = str;
            this.bPx = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXA != null) {
                d.this.jXA.e(this.aZL, this.bPx, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aZL;
        private JSONArray bPD;
        private int bPx;
        private long baF = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.aZL = str;
            this.bPx = i;
            this.bPD = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXA != null) {
                d.this.jXA.a(this.aZL, this.bPx, this.baF, this.bPD);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aZL;
        private int bPx;

        c(String str, int i) {
            this.aZL = str;
            this.bPx = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXA != null) {
                d.this.jXA.t(this.aZL, this.bPx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jXD;

        a(n nVar) {
            this.jXD = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jXA != null) {
                d.this.jXA.a(this.jXD);
            }
        }
    }
}
