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
    private static volatile d mLK;
    private ExecutorService dAG;
    private int dAI;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g mLL;
    private com.baidu.ubc.c mLM;
    private boolean dAJ = false;
    private ad mLx = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dAI;
        dVar.dAI = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dzX() {
        if (mLK == null) {
            synchronized (d.class) {
                if (mLK == null) {
                    mLK = new d();
                }
            }
        }
        return mLK;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dAI = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g(this, null));
            this.dAG = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!ac(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.mLL != null && this.mLL.uU(str)) {
                bVar.gN(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!ac(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Qy(str3);
            }
            if (this.mLL != null && this.mLL.uU(str)) {
                bVar.gN(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ac(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.mLL != null && this.mLL.uU(str)) {
                bVar.gN(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ac(String str, int i) {
        if (this.mLL == null || this.mLL.ab(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().mR(str)) {
                if (this.mLx.dAm() && this.mLL != null && this.mLL.uS(str) > 0) {
                    if (new Random().nextInt(100) >= this.mLL.uS(str)) {
                        return true;
                    }
                }
                return this.mLL != null && this.mLL.uT(str);
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
        Flow bJ;
        bJ = bJ(str, i);
        if (bJ != null && bJ.getValid()) {
            RunnableC0795d runnableC0795d = new RunnableC0795d(bJ, str2);
            if (this.mLL != null && this.mLL.uU(str)) {
                runnableC0795d.gN(true);
            }
            this.mExecutorService.execute(runnableC0795d);
        }
        return bJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bJ;
        bJ = bJ(str, i);
        if (bJ != null && bJ.getValid()) {
            RunnableC0795d runnableC0795d = new RunnableC0795d(bJ, jSONObject);
            if (this.mLL != null && this.mLL.uU(str)) {
                runnableC0795d.gN(true);
            }
            this.mExecutorService.execute(runnableC0795d);
        }
        return bJ;
    }

    Flow bJ(String str, int i) {
        Flow flow = new Flow(str, this.dAI, i);
        if (this.mLL != null && !this.mLL.ab(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().mR(str)) {
            flow.setValid(false);
        } else {
            if (this.mLx.dAm() && this.mLL != null && this.mLL.uS(str) > 0) {
                int uS = this.mLL.uS(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + uS);
                }
                if (nextInt >= uS) {
                    flow.setValid(false);
                }
            }
            if (this.mLL != null && this.mLL.uT(str)) {
                flow.setValid(false);
            } else if (this.mLL != null && !this.mLL.QA(str)) {
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
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d mLN;

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLN.mLM == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.mLN.mLM.aMW();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dU(JSONObject jSONObject) {
        C(jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(JSONObject jSONObject, String str) {
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
        r dzY = dzY();
        if (dzY != null && !dzY.dia()) {
            z2 = false;
        }
        if (z2) {
            this.dAG.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.mLM == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.mLM.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMZ() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mLM == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.mLM.aMZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ak(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mLM == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.mLM.uM(str);
                } else {
                    d.this.mLM.uN(str);
                }
            }
        });
    }

    private static final r dzY() {
        return com.baidu.tieba.q.j.dib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.mLL = com.baidu.ubc.g.dzZ();
            d.this.mLM = new com.baidu.ubc.c(d.this.mContext);
            d.this.mLM.aNa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        private n mLV;

        b(String str, String str2, int i) {
            this.mLV = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.mLV = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.mLV = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.mLV = new n(str, str2, i, str3, j, i2);
        }

        public void gN(boolean z) {
            if (this.mLV != null) {
                this.mLV.gN(z);
            }
        }

        public void Qy(String str) {
            if (this.mLV != null) {
                this.mLV.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mLM == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mLV.aNv();
            String id = this.mLV.getId();
            if (!TextUtils.isEmpty(id)) {
                String uR = d.this.mLL.uR(id);
                if (!TextUtils.isEmpty(uR)) {
                    this.mLV.setCategory(uR);
                }
                if ((this.mLV.getOption() & 8) != 0) {
                    d.this.mLM.b(this.mLV);
                } else if (this.mLV == null || !d.this.mLL.QB(id)) {
                    d.this.mLM.a(this.mLV);
                } else {
                    d.this.mLM.c(this.mLV);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC0795d implements Runnable {
        private p mLW;

        RunnableC0795d(Flow flow, String str) {
            this.mLW = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.mLW.cg(flow.getStartTime());
            this.mLW.va("1");
            d.d(d.this);
        }

        RunnableC0795d(Flow flow, JSONObject jSONObject) {
            this.mLW = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.mLW.cg(flow.getStartTime());
            this.mLW.va("1");
            d.d(d.this);
        }

        public void gN(boolean z) {
            if (this.mLW != null) {
                this.mLW.gN(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mLM == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mLW.aNv();
            if (!TextUtils.isEmpty(d.this.mLL.uR(this.mLW.getId()))) {
                this.mLW.setCategory(d.this.mLL.uR(this.mLW.getId()));
            }
            d.this.mLM.a(this.mLW);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.dAI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class f implements Runnable {
        private String dAy;
        private int dAz;
        private String mValue;

        f(String str, int i, String str2) {
            this.dAy = str;
            this.dAz = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mLM == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mLM.f(this.dAy, this.dAz, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class e implements Runnable {
        private JSONArray dAE;
        private String dAy;
        private int dAz;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dAy = str;
            this.dAz = i;
            this.dAE = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mLM == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mLM.a(this.dAy, this.dAz, this.mEndTime, this.dAE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        private String dAy;
        private int dAz;

        c(String str, int i) {
            this.dAy = str;
            this.dAz = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mLM == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mLM.G(this.dAy, this.dAz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private v mLS;
        private boolean mLT;
        private s mLU;

        a(v vVar, boolean z, s sVar) {
            this.mLS = vVar;
            this.mLT = z;
            this.mLU = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mLM == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mLM.a(this.mLS, this.mLT, this.mLU);
        }
    }
}
