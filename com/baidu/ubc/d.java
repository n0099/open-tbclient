package com.baidu.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d orF;
    private ExecutorService ekF;
    private int ekH;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g orG;
    private com.baidu.ubc.c orH;
    private boolean ekI = false;
    private ad ors = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.ekH;
        dVar.ekH = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d edc() {
        if (orF == null) {
            synchronized (d.class) {
                if (orF == null) {
                    orF = new d();
                }
            }
        }
        return orF;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ekH = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g());
            this.ekF = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str, String str2, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.orG != null && this.orG.yN(str)) {
                bVar.ib(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, String str3, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Wm(str3);
            }
            if (this.orG != null && this.orG.yN(str)) {
                bVar.ib(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.orG != null && this.orG.yN(str)) {
                bVar.ib(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ah(String str, int i) {
        if ((i & 16) == 0 || UBC.getUBCContext().qx(str)) {
            if (this.orG == null || this.orG.ag(str, i)) {
                if (this.orG == null || !this.orG.yM(str)) {
                    if (this.orG == null || !this.orG.Wn(str)) {
                        return this.orG != null && this.orG.Wt(str);
                    }
                    return true;
                }
                return true;
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
        Flow bT;
        bT = bT(str, i);
        if (bT != null && bT.getValid()) {
            RunnableC0932d runnableC0932d = new RunnableC0932d(bT, str2);
            if (this.orG != null && this.orG.yN(str)) {
                runnableC0932d.ib(true);
            }
            this.mExecutorService.execute(runnableC0932d);
        }
        return bT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bT;
        bT = bT(str, i);
        if (bT != null && bT.getValid()) {
            RunnableC0932d runnableC0932d = new RunnableC0932d(bT, jSONObject);
            if (this.orG != null && this.orG.yN(str)) {
                runnableC0932d.ib(true);
            }
            this.mExecutorService.execute(runnableC0932d);
        }
        return bT;
    }

    Flow bT(String str, int i) {
        Flow flow = new Flow(str, this.ekH, i);
        if (this.orG != null && !this.orG.ag(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().qx(str)) {
            flow.setValid(false);
        } else if (this.orG != null && this.orG.Wn(str)) {
            flow.setValid(false);
        } else if (this.orG != null && this.orG.yM(str)) {
            flow.setValid(false);
        } else if (this.orG != null && !this.orG.Wp(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    public void K(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.orH != null ? this.orH.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadLocalDatas() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.orH != null) {
                    d.this.orH.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ez(JSONObject jSONObject) {
        B(jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(JSONObject jSONObject, String str) {
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
        r edd = edd();
        if (edd != null && !edd.dGF()) {
            z2 = false;
        }
        if (z2) {
            this.ekF.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.orH == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.orH.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcF() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.orH == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.orH.bcF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.orH == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.orH.yF(str);
                } else {
                    d.this.orH.yG(str);
                }
            }
        });
    }

    private static final r edd() {
        return com.baidu.tieba.r.j.dGG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.orG = com.baidu.ubc.g.ede();
            d.this.orH = new com.baidu.ubc.c(d.this.mContext);
            d.this.orH.bcG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        private n orQ;

        b(String str, String str2, int i) {
            this.orQ = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.orQ = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.orQ = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.orQ = new n(str, str2, i, str3, j, i2);
        }

        public void ib(boolean z) {
            if (this.orQ != null) {
                this.orQ.ib(z);
            }
        }

        public void Wm(String str) {
            if (this.orQ != null) {
                this.orQ.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.orH == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.orQ.bdb();
            String id = this.orQ.getId();
            if (!TextUtils.isEmpty(id)) {
                String yK = d.this.orG.yK(id);
                if (!TextUtils.isEmpty(yK)) {
                    this.orQ.setCategory(yK);
                }
                if ((this.orQ.getOption() & 8) != 0) {
                    d.this.orH.b(this.orQ);
                } else if (this.orQ == null || !d.this.orG.Wq(id)) {
                    d.this.orH.a(this.orQ);
                } else {
                    d.this.orH.c(this.orQ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC0932d implements Runnable {
        private p orR;

        RunnableC0932d(Flow flow, String str) {
            this.orR = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.orR.cX(flow.getStartTime());
            this.orR.yT("1");
            d.d(d.this);
        }

        RunnableC0932d(Flow flow, JSONObject jSONObject) {
            this.orR = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.orR.cX(flow.getStartTime());
            this.orR.yT("1");
            d.d(d.this);
        }

        public void ib(boolean z) {
            if (this.orR != null) {
                this.orR.ib(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.orH == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.orR.bdb();
            if (!TextUtils.isEmpty(d.this.orG.yK(this.orR.getId()))) {
                this.orR.setCategory(d.this.orG.yK(this.orR.getId()));
            }
            d.this.orH.a(this.orR);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.ekH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class f implements Runnable {
        private String ekx;
        private int eky;
        private String mValue;

        f(String str, int i, String str2) {
            this.ekx = str;
            this.eky = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.orH == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.orH.i(this.ekx, this.eky, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class e implements Runnable {
        private JSONArray ekD;
        private String ekx;
        private int eky;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.ekx = str;
            this.eky = i;
            this.ekD = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.orH == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.orH.a(this.ekx, this.eky, this.mEndTime, this.ekD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        private String ekx;
        private int eky;

        c(String str, int i) {
            this.ekx = str;
            this.eky = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.orH == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.orH.K(this.ekx, this.eky);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        private v orN;
        private boolean orO;
        private s orP;

        a(v vVar, boolean z, s sVar) {
            this.orN = vVar;
            this.orO = z;
            this.orP = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.orH == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.orH.a(this.orN, this.orO, this.orP);
        }
    }
}
