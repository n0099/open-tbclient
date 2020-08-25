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
/* loaded from: classes14.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d neI;
    private ExecutorService dJP;
    private int dJR;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g neJ;
    private com.baidu.ubc.c neK;
    private boolean dJS = false;
    private ad nev = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dJR;
        dVar.dJR = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dLL() {
        if (neI == null) {
            synchronized (d.class) {
                if (neI == null) {
                    neI = new d();
                }
            }
        }
        return neI;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dJR = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g(this, null));
            this.dJP = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.neJ != null && this.neJ.xf(str)) {
                bVar.hh(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Tx(str3);
            }
            if (this.neJ != null && this.neJ.xf(str)) {
                bVar.hh(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.neJ != null && this.neJ.xf(str)) {
                bVar.hh(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ae(String str, int i) {
        if (this.neJ == null || this.neJ.ad(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().oQ(str)) {
                if (this.nev.dMa() && this.neJ != null && this.neJ.xd(str) > 0) {
                    if (new Random().nextInt(100) >= this.neJ.xd(str)) {
                        return true;
                    }
                }
                return this.neJ != null && this.neJ.xe(str);
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
        Flow bO;
        bO = bO(str, i);
        if (bO != null && bO.getValid()) {
            RunnableC0848d runnableC0848d = new RunnableC0848d(bO, str2);
            if (this.neJ != null && this.neJ.xf(str)) {
                runnableC0848d.hh(true);
            }
            this.mExecutorService.execute(runnableC0848d);
        }
        return bO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bO;
        bO = bO(str, i);
        if (bO != null && bO.getValid()) {
            RunnableC0848d runnableC0848d = new RunnableC0848d(bO, jSONObject);
            if (this.neJ != null && this.neJ.xf(str)) {
                runnableC0848d.hh(true);
            }
            this.mExecutorService.execute(runnableC0848d);
        }
        return bO;
    }

    Flow bO(String str, int i) {
        Flow flow = new Flow(str, this.dJR, i);
        if (this.neJ != null && !this.neJ.ad(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().oQ(str)) {
            flow.setValid(false);
        } else {
            if (this.nev.dMa() && this.neJ != null && this.neJ.xd(str) > 0) {
                int xd = this.neJ.xd(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + xd);
                }
                if (nextInt >= xd) {
                    flow.setValid(false);
                }
            }
            if (this.neJ != null && this.neJ.xe(str)) {
                flow.setValid(false);
            } else if (this.neJ != null && !this.neJ.Tz(str)) {
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

    public void H(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d neL;

        @Override // java.lang.Runnable
        public void run() {
            if (this.neL.neK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.neL.neK.aVw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ef(JSONObject jSONObject) {
        E(jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(JSONObject jSONObject, String str) {
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
        r dLM = dLM();
        if (dLM != null && !dLM.dtv()) {
            z2 = false;
        }
        if (z2) {
            this.dJP.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.neK == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.neK.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVz() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.neK == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.neK.aVz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.neK == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.neK.wX(str);
                } else {
                    d.this.neK.wY(str);
                }
            }
        });
    }

    private static final r dLM() {
        return com.baidu.tieba.q.j.dtw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.neJ = com.baidu.ubc.g.dLN();
            d.this.neK = new com.baidu.ubc.c(d.this.mContext);
            d.this.neK.aVA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b implements Runnable {
        private n neT;

        b(String str, String str2, int i) {
            this.neT = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.neT = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.neT = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.neT = new n(str, str2, i, str3, j, i2);
        }

        public void hh(boolean z) {
            if (this.neT != null) {
                this.neT.hh(z);
            }
        }

        public void Tx(String str) {
            if (this.neT != null) {
                this.neT.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.neK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.neT.aVV();
            String id = this.neT.getId();
            if (!TextUtils.isEmpty(id)) {
                String xc = d.this.neJ.xc(id);
                if (!TextUtils.isEmpty(xc)) {
                    this.neT.setCategory(xc);
                }
                if ((this.neT.getOption() & 8) != 0) {
                    d.this.neK.b(this.neT);
                } else if (this.neT == null || !d.this.neJ.TA(id)) {
                    d.this.neK.a(this.neT);
                } else {
                    d.this.neK.c(this.neT);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class RunnableC0848d implements Runnable {
        private p neU;

        RunnableC0848d(Flow flow, String str) {
            this.neU = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.neU.cq(flow.getStartTime());
            this.neU.xl("1");
            d.d(d.this);
        }

        RunnableC0848d(Flow flow, JSONObject jSONObject) {
            this.neU = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.neU.cq(flow.getStartTime());
            this.neU.xl("1");
            d.d(d.this);
        }

        public void hh(boolean z) {
            if (this.neU != null) {
                this.neU.hh(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.neK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.neU.aVV();
            if (!TextUtils.isEmpty(d.this.neJ.xc(this.neU.getId()))) {
                this.neU.setCategory(d.this.neJ.xc(this.neU.getId()));
            }
            d.this.neK.a(this.neU);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.dJR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class f implements Runnable {
        private String dJH;
        private int dJI;
        private String mValue;

        f(String str, int i, String str2) {
            this.dJH = str;
            this.dJI = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.neK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.neK.f(this.dJH, this.dJI, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class e implements Runnable {
        private String dJH;
        private int dJI;
        private JSONArray dJN;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dJH = str;
            this.dJI = i;
            this.dJN = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.neK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.neK.a(this.dJH, this.dJI, this.mEndTime, this.dJN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class c implements Runnable {
        private String dJH;
        private int dJI;

        c(String str, int i) {
            this.dJH = str;
            this.dJI = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.neK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.neK.H(this.dJH, this.dJI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a implements Runnable {
        private v neQ;
        private boolean neR;
        private s neS;

        a(v vVar, boolean z, s sVar) {
            this.neQ = vVar;
            this.neR = z;
            this.neS = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.neK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.neK.a(this.neQ, this.neR, this.neS);
        }
    }
}
