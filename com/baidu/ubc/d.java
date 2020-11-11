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
/* loaded from: classes20.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d oqb;
    private ExecutorService emm;
    private int emo;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g oqc;
    private com.baidu.ubc.c oqd;
    private boolean emp = false;
    private ad opO = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.emo;
        dVar.emo = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d edd() {
        if (oqb == null) {
            synchronized (d.class) {
                if (oqb == null) {
                    oqb = new d();
                }
            }
        }
        return oqb;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.emo = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g());
            this.emm = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str, String str2, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.oqc != null && this.oqc.yS(str)) {
                bVar.hY(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, String str3, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.WB(str3);
            }
            if (this.oqc != null && this.oqc.yS(str)) {
                bVar.hY(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.oqc != null && this.oqc.yS(str)) {
                bVar.hY(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ah(String str, int i) {
        if ((i & 16) == 0 || UBC.getUBCContext().qD(str)) {
            if (this.oqc == null || this.oqc.ag(str, i)) {
                if (this.oqc == null || !this.oqc.yR(str)) {
                    if (this.oqc == null || !this.oqc.WC(str)) {
                        return this.oqc != null && this.oqc.WI(str);
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
        Flow bU;
        bU = bU(str, i);
        if (bU != null && bU.getValid()) {
            RunnableC0929d runnableC0929d = new RunnableC0929d(bU, str2);
            if (this.oqc != null && this.oqc.yS(str)) {
                runnableC0929d.hY(true);
            }
            this.mExecutorService.execute(runnableC0929d);
        }
        return bU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bU;
        bU = bU(str, i);
        if (bU != null && bU.getValid()) {
            RunnableC0929d runnableC0929d = new RunnableC0929d(bU, jSONObject);
            if (this.oqc != null && this.oqc.yS(str)) {
                runnableC0929d.hY(true);
            }
            this.mExecutorService.execute(runnableC0929d);
        }
        return bU;
    }

    Flow bU(String str, int i) {
        Flow flow = new Flow(str, this.emo, i);
        if (this.oqc != null && !this.oqc.ag(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().qD(str)) {
            flow.setValid(false);
        } else if (this.oqc != null && this.oqc.WC(str)) {
            flow.setValid(false);
        } else if (this.oqc != null && this.oqc.yR(str)) {
            flow.setValid(false);
        } else if (this.oqc != null && !this.oqc.WE(str)) {
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
        return this.oqd != null ? this.oqd.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadLocalDatas() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oqd != null) {
                    d.this.oqd.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eE(JSONObject jSONObject) {
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
        r ede = ede();
        if (ede != null && !ede.dGO()) {
            z2 = false;
        }
        if (z2) {
            this.emm.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oqd == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oqd.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdm() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oqd == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oqd.bdm();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oqd == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oqd.yK(str);
                } else {
                    d.this.oqd.yL(str);
                }
            }
        });
    }

    private static final r ede() {
        return com.baidu.tieba.q.j.dGP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oqc = com.baidu.ubc.g.edf();
            d.this.oqd = new com.baidu.ubc.c(d.this.mContext);
            d.this.oqd.bdn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class b implements Runnable {
        private n oqm;

        b(String str, String str2, int i) {
            this.oqm = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oqm = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oqm = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oqm = new n(str, str2, i, str3, j, i2);
        }

        public void hY(boolean z) {
            if (this.oqm != null) {
                this.oqm.hY(z);
            }
        }

        public void WB(String str) {
            if (this.oqm != null) {
                this.oqm.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oqd == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oqm.bdI();
            String id = this.oqm.getId();
            if (!TextUtils.isEmpty(id)) {
                String yP = d.this.oqc.yP(id);
                if (!TextUtils.isEmpty(yP)) {
                    this.oqm.setCategory(yP);
                }
                if ((this.oqm.getOption() & 8) != 0) {
                    d.this.oqd.b(this.oqm);
                } else if (this.oqm == null || !d.this.oqc.WF(id)) {
                    d.this.oqd.a(this.oqm);
                } else {
                    d.this.oqd.c(this.oqm);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class RunnableC0929d implements Runnable {
        private p oqn;

        RunnableC0929d(Flow flow, String str) {
            this.oqn = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oqn.cX(flow.getStartTime());
            this.oqn.yY("1");
            d.d(d.this);
        }

        RunnableC0929d(Flow flow, JSONObject jSONObject) {
            this.oqn = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oqn.cX(flow.getStartTime());
            this.oqn.yY("1");
            d.d(d.this);
        }

        public void hY(boolean z) {
            if (this.oqn != null) {
                this.oqn.hY(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oqd == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oqn.bdI();
            if (!TextUtils.isEmpty(d.this.oqc.yP(this.oqn.getId()))) {
                this.oqn.setCategory(d.this.oqc.yP(this.oqn.getId()));
            }
            d.this.oqd.a(this.oqn);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.emo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class f implements Runnable {
        private String eme;
        private int emf;
        private String mValue;

        f(String str, int i, String str2) {
            this.eme = str;
            this.emf = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oqd == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oqd.i(this.eme, this.emf, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class e implements Runnable {
        private String eme;
        private int emf;
        private JSONArray emk;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eme = str;
            this.emf = i;
            this.emk = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oqd == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oqd.a(this.eme, this.emf, this.mEndTime, this.emk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class c implements Runnable {
        private String eme;
        private int emf;

        c(String str, int i) {
            this.eme = str;
            this.emf = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oqd == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oqd.K(this.eme, this.emf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a implements Runnable {
        private v oqj;
        private boolean oqk;
        private s oql;

        a(v vVar, boolean z, s sVar) {
            this.oqj = vVar;
            this.oqk = z;
            this.oql = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oqd == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oqd.a(this.oqj, this.oqk, this.oql);
        }
    }
}
