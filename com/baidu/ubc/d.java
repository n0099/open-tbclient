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
    private static volatile d jWI;
    private ExecutorService bOO;
    private int bOQ;
    private boolean bOR = false;
    private ExecutorService btb;
    private com.baidu.ubc.e jWH;
    private com.baidu.ubc.c jWJ;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bOQ;
        dVar.bOQ = i + 1;
        return i;
    }

    static {
        String ac = com.baidu.f.e.ac(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(ac)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.FU(ac));
            nVar.ada();
            cAS().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d cAS() {
        if (jWI == null) {
            synchronized (d.class) {
                if (jWI == null) {
                    jWI = new d();
                }
            }
        }
        return jWI;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bOQ = com.baidu.f.b.cAX().getInt("ubc_key_flow_handle", 0);
            this.btb = Executors.newSingleThreadExecutor();
            this.btb.execute(new g(this, null));
            this.bOO = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jWH != null && this.jWH.lw(str)) {
                bVar.dI(true);
            }
            this.btb.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jWH != null && this.jWH.lw(str)) {
                bVar.dI(true);
            }
            this.btb.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.FS(str3);
            }
            if (this.jWH != null && this.jWH.lw(str)) {
                bVar.dI(true);
            }
            this.btb.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        if (this.jWH == null || this.jWH.J(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().gv(str)) {
                if (this.jWH != null && this.jWH.lu(str) > 0) {
                    if (new Random().nextInt(100) >= this.jWH.lu(str)) {
                        return true;
                    }
                }
                return this.jWH != null && this.jWH.lv(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.btb.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.btb.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bs;
        bs = bs(str, i);
        if (bs != null && bs.getValid()) {
            RunnableC0550d runnableC0550d = new RunnableC0550d(bs, str2);
            if (this.jWH != null && this.jWH.lw(str)) {
                runnableC0550d.dI(true);
            }
            this.btb.execute(runnableC0550d);
        }
        return bs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bs;
        bs = bs(str, i);
        if (bs != null && bs.getValid()) {
            RunnableC0550d runnableC0550d = new RunnableC0550d(bs, jSONObject);
            if (this.jWH != null && this.jWH.lw(str)) {
                runnableC0550d.dI(true);
            }
            this.btb.execute(runnableC0550d);
        }
        return bs;
    }

    Flow bs(String str, int i) {
        Flow flow = new Flow(str, this.bOQ, i);
        if (this.jWH != null && !this.jWH.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().gv(str)) {
            flow.setValid(false);
        } else {
            if (this.jWH != null && this.jWH.lu(str) > 0) {
                if (new Random().nextInt(100) >= this.jWH.lu(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jWH != null && this.jWH.lv(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void e(String str, int i, String str2) {
        this.btb.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.btb.execute(new e(str, i, jSONArray));
    }

    public void t(String str, int i) {
        this.btb.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jWK;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jWK.jWJ != null) {
                this.jWK.jWJ.aco();
            }
        }
    }

    public void a(n nVar) {
        this.btb.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(final JSONObject jSONObject, final String str) {
        this.bOO.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jWJ != null) {
                    d.this.jWJ.m(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ct(final JSONObject jSONObject) {
        this.bOO.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jWJ != null) {
                    d.this.jWJ.ct(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(final String str, final boolean z) {
        this.btb.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jWJ != null) {
                    if (z) {
                        d.this.jWJ.lo(str);
                    } else {
                        d.this.jWJ.lp(str);
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
            d.this.jWH = com.baidu.ubc.e.cAT();
            d.this.jWJ = new com.baidu.ubc.c(d.this.mContext);
            d.this.jWJ.acs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jWN;

        b(String str, String str2, int i) {
            this.jWN = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jWN = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jWN = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jWN = new j(str, str2, i, str3, j, i2);
        }

        public void dI(boolean z) {
            if (this.jWN != null) {
                this.jWN.dI(z);
            }
        }

        public void FS(String str) {
            if (this.jWN != null) {
                this.jWN.qJ(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jWJ != null) {
                this.jWN.acL();
                if (!TextUtils.isEmpty(d.this.jWH.lt(this.jWN.getId()))) {
                    this.jWN.setCategory(d.this.jWH.lt(this.jWN.getId()));
                }
                if ((this.jWN.getOption() & 8) != 0) {
                    d.this.jWJ.b(this.jWN);
                } else {
                    d.this.jWJ.a(this.jWN);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0550d implements Runnable {
        private k jWO;

        RunnableC0550d(Flow flow, String str) {
            this.jWO = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jWO.aA(flow.getStartTime());
            this.jWO.lz("1");
            d.d(d.this);
        }

        RunnableC0550d(Flow flow, JSONObject jSONObject) {
            this.jWO = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jWO.aA(flow.getStartTime());
            this.jWO.lz("1");
            d.d(d.this);
        }

        public void dI(boolean z) {
            if (this.jWO != null) {
                this.jWO.dI(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jWJ != null) {
                this.jWO.acL();
                if (!TextUtils.isEmpty(d.this.jWH.lt(this.jWO.getId()))) {
                    this.jWO.setCategory(d.this.jWH.lt(this.jWO.getId()));
                }
                d.this.jWJ.b(this.jWO);
                com.baidu.f.b.cAX().putInt("ubc_key_flow_handle", d.this.bOQ);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aZt;
        private int bOG;
        private String mValue;

        f(String str, int i, String str2) {
            this.aZt = str;
            this.bOG = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jWJ != null) {
                d.this.jWJ.e(this.aZt, this.bOG, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aZt;
        private int bOG;
        private JSONArray bOM;
        private long ban = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.aZt = str;
            this.bOG = i;
            this.bOM = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jWJ != null) {
                d.this.jWJ.a(this.aZt, this.bOG, this.ban, this.bOM);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aZt;
        private int bOG;

        c(String str, int i) {
            this.aZt = str;
            this.bOG = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jWJ != null) {
                d.this.jWJ.t(this.aZt, this.bOG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jWM;

        a(n nVar) {
            this.jWM = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jWJ != null) {
                d.this.jWJ.a(this.jWM);
            }
        }
    }
}
