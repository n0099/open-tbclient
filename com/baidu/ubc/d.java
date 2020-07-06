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
    private static volatile d mDG;
    private ExecutorService duR;
    private int duT;
    private Context mContext;
    private com.baidu.ubc.g mDH;
    private com.baidu.ubc.c mDI;
    public ExecutorService mExecutorService;
    private boolean duU = false;
    private ad mDr = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.duT;
        dVar.duT = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dwK() {
        if (mDG == null) {
            synchronized (d.class) {
                if (mDG == null) {
                    mDG = new d();
                }
            }
        }
        return mDG;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.duT = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g(this, null));
            this.duR = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.mDH != null && this.mDH.tR(str)) {
                bVar.gs(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.PN(str3);
            }
            if (this.mDH != null && this.mDH.tR(str)) {
                bVar.gs(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.mDH != null && this.mDH.tR(str)) {
                bVar.gs(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ab(String str, int i) {
        if (this.mDH == null || this.mDH.aa(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().mr(str)) {
                if (this.mDr.dwZ() && this.mDH != null && this.mDH.tP(str) > 0) {
                    if (new Random().nextInt(100) >= this.mDH.tP(str)) {
                        return true;
                    }
                }
                return this.mDH != null && this.mDH.tQ(str);
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
            RunnableC0785d runnableC0785d = new RunnableC0785d(bL, str2);
            if (this.mDH != null && this.mDH.tR(str)) {
                runnableC0785d.gs(true);
            }
            this.mExecutorService.execute(runnableC0785d);
        }
        return bL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bL;
        bL = bL(str, i);
        if (bL != null && bL.getValid()) {
            RunnableC0785d runnableC0785d = new RunnableC0785d(bL, jSONObject);
            if (this.mDH != null && this.mDH.tR(str)) {
                runnableC0785d.gs(true);
            }
            this.mExecutorService.execute(runnableC0785d);
        }
        return bL;
    }

    Flow bL(String str, int i) {
        Flow flow = new Flow(str, this.duT, i);
        if (this.mDH != null && !this.mDH.aa(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().mr(str)) {
            flow.setValid(false);
        } else {
            if (this.mDr.dwZ() && this.mDH != null && this.mDH.tP(str) > 0) {
                int tP = this.mDH.tP(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + tP);
                }
                if (nextInt >= tP) {
                    flow.setValid(false);
                }
            }
            if (this.mDH != null && this.mDH.tQ(str)) {
                flow.setValid(false);
            } else if (this.mDH != null && !this.mDH.PP(str)) {
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

    public void G(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d mDJ;

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDJ.mDI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.mDJ.mDI.aJe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dN(JSONObject jSONObject) {
        A(jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(JSONObject jSONObject, String str) {
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
        r dwL = dwL();
        if (dwL != null && !dwL.deR()) {
            z2 = false;
        }
        if (z2) {
            this.duR.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.mDI == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.mDI.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJh() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mDI == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.mDI.aJh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mDI == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.mDI.tJ(str);
                } else {
                    d.this.mDI.tK(str);
                }
            }
        });
    }

    private static final r dwL() {
        return com.baidu.tieba.q.j.deS();
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
            d.this.mDH = com.baidu.ubc.g.dwM();
            d.this.mDI = new com.baidu.ubc.c(d.this.mContext);
            d.this.mDI.aJi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements Runnable {
        private n mDR;

        b(String str, String str2, int i) {
            this.mDR = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.mDR = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.mDR = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.mDR = new n(str, str2, i, str3, j, i2);
        }

        public void gs(boolean z) {
            if (this.mDR != null) {
                this.mDR.gs(z);
            }
        }

        public void PN(String str) {
            if (this.mDR != null) {
                this.mDR.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mDI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mDR.aJD();
            String id = this.mDR.getId();
            if (!TextUtils.isEmpty(id)) {
                String tO = d.this.mDH.tO(id);
                if (!TextUtils.isEmpty(tO)) {
                    this.mDR.setCategory(tO);
                }
                if ((this.mDR.getOption() & 8) != 0) {
                    d.this.mDI.b(this.mDR);
                } else if (this.mDR == null || !d.this.mDH.PQ(id)) {
                    d.this.mDI.a(this.mDR);
                } else {
                    d.this.mDI.c(this.mDR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0785d implements Runnable {
        private p mDS;

        RunnableC0785d(Flow flow, String str) {
            this.mDS = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.mDS.bR(flow.getStartTime());
            this.mDS.tX("1");
            d.d(d.this);
        }

        RunnableC0785d(Flow flow, JSONObject jSONObject) {
            this.mDS = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.mDS.bR(flow.getStartTime());
            this.mDS.tX("1");
            d.d(d.this);
        }

        public void gs(boolean z) {
            if (this.mDS != null) {
                this.mDS.gs(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mDI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mDS.aJD();
            if (!TextUtils.isEmpty(d.this.mDH.tO(this.mDS.getId()))) {
                this.mDS.setCategory(d.this.mDH.tO(this.mDS.getId()));
            }
            d.this.mDI.a(this.mDS);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.duT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class f implements Runnable {
        private String duJ;
        private int duK;
        private String mValue;

        f(String str, int i, String str2) {
            this.duJ = str;
            this.duK = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mDI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mDI.f(this.duJ, this.duK, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class e implements Runnable {
        private String duJ;
        private int duK;
        private JSONArray duP;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.duJ = str;
            this.duK = i;
            this.duP = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mDI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mDI.a(this.duJ, this.duK, this.mEndTime, this.duP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c implements Runnable {
        private String duJ;
        private int duK;

        c(String str, int i) {
            this.duJ = str;
            this.duK = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mDI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mDI.G(this.duJ, this.duK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements Runnable {
        private v mDO;
        private boolean mDP;
        private s mDQ;

        a(v vVar, boolean z, s sVar) {
            this.mDO = vVar;
            this.mDP = z;
            this.mDQ = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mDI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mDI.a(this.mDO, this.mDP, this.mDQ);
        }
    }
}
