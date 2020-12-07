package com.baidu.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d oGD;
    private ExecutorService erI;
    private int erK;
    private boolean erL = false;
    private Context mContext;
    public ScheduledExecutorService oGE;
    private com.baidu.ubc.g oGF;
    private com.baidu.ubc.c oGG;
    private v oGH;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.erK;
        dVar.erK = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d eiH() {
        if (oGD == null) {
            synchronized (d.class) {
                if (oGD == null) {
                    oGD = new d();
                }
            }
        }
        return oGD;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.erK = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oGE = Executors.newSingleThreadScheduledExecutor();
            this.oGE.execute(new g());
            this.erI = Executors.newSingleThreadExecutor();
            this.oGH = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str, String str2, int i) {
        this.oGE.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oGE.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.XB(str3);
        }
        this.oGE.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oGE.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oGE.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bW;
        bW = bW(str, i);
        if (bW != null && bW.getValid()) {
            RunnableC0949d runnableC0949d = new RunnableC0949d(bW, str2);
            if (this.oGF != null && this.oGF.zu(str)) {
                runnableC0949d.iq(true);
            }
            this.oGE.execute(runnableC0949d);
        }
        return bW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bW;
        bW = bW(str, i);
        if (bW != null && bW.getValid()) {
            RunnableC0949d runnableC0949d = new RunnableC0949d(bW, jSONObject);
            if (this.oGF != null && this.oGF.zu(str)) {
                runnableC0949d.iq(true);
            }
            this.oGE.execute(runnableC0949d);
        }
        return bW;
    }

    Flow bW(String str, int i) {
        Flow flow = new Flow(str, this.erK, i);
        if (this.oGF != null && !this.oGF.ah(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().re(str)) {
            flow.setValid(false);
        } else if (this.oGF != null && this.oGF.XC(str)) {
            flow.setValid(false);
        } else if (this.oGF != null && this.oGF.zt(str)) {
            flow.setValid(false);
        } else if (this.oGF != null && !this.oGF.XE(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oGE.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oGE.execute(new e(str, i, jSONArray));
    }

    public void L(String str, int i) {
        this.oGE.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oGG != null ? this.oGG.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eiI() {
        this.oGE.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oGG != null) {
                    d.this.oGG.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oGE.execute(new a(wVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eA(JSONObject jSONObject) {
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
        r eiJ = eiJ();
        if (eiJ != null && !eiJ.dLW()) {
            z2 = false;
        }
        if (z2) {
            this.erI.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oGG == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oGG.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfK() {
        this.oGE.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oGG == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oGG.bfK();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.oGE.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oGG == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oGG.zm(str);
                } else {
                    d.this.oGG.zn(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oGE.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private static final r eiJ() {
        return com.baidu.tieba.r.r.dLX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oGF = com.baidu.ubc.g.eiL();
            d.this.oGG = new com.baidu.ubc.c(d.this.mContext);
            d.this.oGG.bfL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oGQ;

        b(String str, String str2, int i) {
            this.oGQ = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oGQ = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oGQ = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oGQ = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iq(boolean z) {
            if (this.oGQ != null) {
                this.oGQ.iq(z);
            }
        }

        public void XB(String str) {
            if (this.oGQ != null) {
                this.oGQ.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGG == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oGH != null && d.this.oGF != null && d.this.oGF.XJ(this.mLogId) == 1) {
                eiK();
            }
            if (this.oGQ.bgc() == -1) {
                if (bX(this.oGQ.getId(), this.oGQ.getOption())) {
                    if (d.this.oGF != null && d.this.oGF.zu(this.oGQ.getId())) {
                        iq(true);
                    }
                } else {
                    return;
                }
            }
            this.oGQ.bgg();
            String id = this.oGQ.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oGF != null) {
                    String zr = d.this.oGF.zr(id);
                    if (!TextUtils.isEmpty(zr)) {
                        this.oGQ.setCategory(zr);
                    }
                }
                if (d.this.oGH != null && d.this.oGF != null && d.this.oGF.XJ(this.mLogId) == 2) {
                    eiK();
                }
                if (this.oGQ.bgc() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oGG.d(this.oGQ);
                } else if ((this.oGQ.getOption() & 8) != 0) {
                    d.this.oGG.c(this.oGQ);
                } else if (this.oGQ == null || d.this.oGF == null || !d.this.oGF.XF(id)) {
                    d.this.oGG.b(this.oGQ);
                } else {
                    d.this.oGG.f(this.oGQ);
                }
            }
        }

        private boolean bX(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().re(str)) {
                if (d.this.oGF == null || d.this.oGF.ah(str, i)) {
                    if (d.this.oGF == null || !d.this.oGF.zt(str)) {
                        if (d.this.oGF == null || !d.this.oGF.XC(str)) {
                            return d.this.oGF == null || !d.this.oGF.XI(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private void eiK() {
            JSONObject bge;
            if (this.oGQ != null) {
                String id = this.oGQ.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oGQ.getContent();
                    if (TextUtils.isEmpty(content) && (bge = this.oGQ.bge()) != null) {
                        try {
                            content = bge.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oGH.gX(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oGH.gW(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC0949d implements Runnable {
        private p oGR;

        RunnableC0949d(Flow flow, String str) {
            this.oGR = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oGR.dw(flow.getStartTime());
            this.oGR.zA("1");
            d.e(d.this);
        }

        RunnableC0949d(Flow flow, JSONObject jSONObject) {
            this.oGR = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oGR.dw(flow.getStartTime());
            this.oGR.zA("1");
            d.e(d.this);
        }

        public void iq(boolean z) {
            if (this.oGR != null) {
                this.oGR.iq(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGG == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oGR.bgg();
            if (!TextUtils.isEmpty(d.this.oGF.zr(this.oGR.getId()))) {
                this.oGR.setCategory(d.this.oGF.zr(this.oGR.getId()));
            }
            d.this.oGG.a(this.oGR);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.erK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class f implements Runnable {
        private String erA;
        private int erB;
        private String mValue;

        f(String str, int i, String str2) {
            this.erA = str;
            this.erB = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGG == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGG.i(this.erA, this.erB, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class e implements Runnable {
        private String erA;
        private int erB;
        private JSONArray erG;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.erA = str;
            this.erB = i;
            this.erG = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGG == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGG.a(this.erA, this.erB, this.mEndTime, this.erG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        private String erA;
        private int erB;

        c(String str, int i) {
            this.erA = str;
            this.erB = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGG == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGG.L(this.erA, this.erB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        private w oGN;
        private boolean oGO;
        private s oGP;

        a(w wVar, boolean z, s sVar) {
            this.oGN = wVar;
            this.oGO = z;
            this.oGP = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGG == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGG.a(this.oGN, this.oGO, this.oGP);
        }
    }
}
