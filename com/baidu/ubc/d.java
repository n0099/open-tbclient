package com.baidu.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d lNj;
    private ExecutorService dek;
    private int dem;
    private boolean den = false;
    private ad lMW = new ad();
    private com.baidu.ubc.g lNk;
    private com.baidu.ubc.c lNl;
    private Context mContext;
    public ExecutorService mExecutorService;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dem;
        dVar.dem = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dkw() {
        if (lNj == null) {
            synchronized (d.class) {
                if (lNj == null) {
                    lNj = new d();
                }
            }
        }
        return lNj;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dem = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g(this, null));
            this.dek = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.lNk != null && this.lNk.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, String str3, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Nm(str3);
            }
            if (this.lNk != null && this.lNk.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.lNk != null && this.lNk.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean aa(String str, int i) {
        if (this.lNk == null || this.lNk.Z(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().kV(str)) {
                if (this.lMW.dkL() && this.lNk != null && this.lNk.se(str) > 0) {
                    if (new Random().nextInt(100) >= this.lNk.se(str)) {
                        return true;
                    }
                }
                return this.lNk != null && this.lNk.sf(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.mExecutorService.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.mExecutorService.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bL;
        bL = bL(str, i);
        if (bL != null && bL.getValid()) {
            RunnableC0711d runnableC0711d = new RunnableC0711d(bL, str2);
            if (this.lNk != null && this.lNk.sg(str)) {
                runnableC0711d.gc(true);
            }
            this.mExecutorService.execute(runnableC0711d);
        }
        return bL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bL;
        bL = bL(str, i);
        if (bL != null && bL.getValid()) {
            RunnableC0711d runnableC0711d = new RunnableC0711d(bL, jSONObject);
            if (this.lNk != null && this.lNk.sg(str)) {
                runnableC0711d.gc(true);
            }
            this.mExecutorService.execute(runnableC0711d);
        }
        return bL;
    }

    Flow bL(String str, int i) {
        Flow flow = new Flow(str, this.dem, i);
        if (this.lNk != null && !this.lNk.Z(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().kV(str)) {
            flow.setValid(false);
        } else {
            if (this.lMW.dkL() && this.lNk != null && this.lNk.se(str) > 0) {
                int se = this.lNk.se(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + se);
                }
                if (nextInt >= se) {
                    flow.setValid(false);
                }
            }
            if (this.lNk != null && this.lNk.sf(str)) {
                flow.setValid(false);
            } else if (this.lNk != null && !this.lNk.No(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void f(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    public void C(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d lNm;

        @Override // java.lang.Runnable
        public void run() {
            if (this.lNm.lNl == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.lNm.lNl.aDr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dw(JSONObject jSONObject) {
        s(jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(JSONObject jSONObject, String str) {
        a(jSONObject, str, false, (n) null, (t) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, boolean z, n nVar, t tVar) {
        a(jSONObject, (String) null, z, nVar, tVar);
    }

    void a(final JSONObject jSONObject, final String str, final boolean z, final n nVar, final t tVar) {
        if (DEBUG) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("UBCDEBUG", jSONObject.toString());
        }
        boolean z2 = true;
        r dkx = dkx();
        if (dkx != null && !dkx.cTf()) {
            z2 = false;
        }
        if (z2) {
            this.dek.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.lNl == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.lNl.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDu() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lNl == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.lNl.aDu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lNl == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.lNl.rY(str);
                } else {
                    d.this.lNl.rZ(str);
                }
            }
        });
    }

    private static final r dkx() {
        return com.baidu.tieba.q.j.cTg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.lNk = com.baidu.ubc.g.dky();
            d.this.lNl = new com.baidu.ubc.c(d.this.mContext);
            d.this.lNl.aDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements Runnable {
        private n lNu;

        b(String str, String str2, int i) {
            this.lNu = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.lNu = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.lNu = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.lNu = new n(str, str2, i, str3, j, i2);
        }

        public void gc(boolean z) {
            if (this.lNu != null) {
                this.lNu.gc(z);
            }
        }

        public void Nm(String str) {
            if (this.lNu != null) {
                this.lNu.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNl == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.lNu.aDN();
            String id = this.lNu.getId();
            if (!TextUtils.isEmpty(id)) {
                String sd = d.this.lNk.sd(id);
                if (!TextUtils.isEmpty(sd)) {
                    this.lNu.setCategory(sd);
                }
                if ((this.lNu.getOption() & 8) != 0) {
                    d.this.lNl.b(this.lNu);
                } else if (this.lNu == null || !d.this.lNk.Np(id)) {
                    d.this.lNl.a(this.lNu);
                } else {
                    d.this.lNl.c(this.lNu);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0711d implements Runnable {
        private p lNv;

        RunnableC0711d(Flow flow, String str) {
            this.lNv = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.lNv.bR(flow.getStartTime());
            this.lNv.sj("1");
            d.d(d.this);
        }

        RunnableC0711d(Flow flow, JSONObject jSONObject) {
            this.lNv = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.lNv.bR(flow.getStartTime());
            this.lNv.sj("1");
            d.d(d.this);
        }

        public void gc(boolean z) {
            if (this.lNv != null) {
                this.lNv.gc(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNl == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.lNv.aDN();
            if (!TextUtils.isEmpty(d.this.lNk.sd(this.lNv.getId()))) {
                this.lNv.setCategory(d.this.lNk.sd(this.lNv.getId()));
            }
            d.this.lNl.a(this.lNv);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.dem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class f implements Runnable {
        private String cgr;
        private int ded;
        private String mValue;

        f(String str, int i, String str2) {
            this.cgr = str;
            this.ded = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNl == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNl.f(this.cgr, this.ded, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class e implements Runnable {
        private String cgr;
        private int ded;
        private JSONArray dei;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.cgr = str;
            this.ded = i;
            this.dei = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNl == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNl.a(this.cgr, this.ded, this.mEndTime, this.dei);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c implements Runnable {
        private String cgr;
        private int ded;

        c(String str, int i) {
            this.cgr = str;
            this.ded = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNl == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNl.C(this.cgr, this.ded);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements Runnable {
        private v lNr;
        private boolean lNs;
        private s lNt;

        a(v vVar, boolean z, s sVar) {
            this.lNr = vVar;
            this.lNs = z;
            this.lNt = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNl == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNl.a(this.lNr, this.lNs, this.lNt);
        }
    }
}
