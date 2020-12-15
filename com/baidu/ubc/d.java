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
    private static volatile d oGF;
    private ExecutorService erI;
    private int erK;
    private boolean erL = false;
    private Context mContext;
    public ScheduledExecutorService oGG;
    private com.baidu.ubc.g oGH;
    private com.baidu.ubc.c oGI;
    private v oGJ;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.erK;
        dVar.erK = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d eiI() {
        if (oGF == null) {
            synchronized (d.class) {
                if (oGF == null) {
                    oGF = new d();
                }
            }
        }
        return oGF;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.erK = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oGG = Executors.newSingleThreadScheduledExecutor();
            this.oGG.execute(new g());
            this.erI = Executors.newSingleThreadExecutor();
            this.oGJ = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str, String str2, int i) {
        this.oGG.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oGG.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.XB(str3);
        }
        this.oGG.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oGG.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oGG.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bW;
        bW = bW(str, i);
        if (bW != null && bW.getValid()) {
            RunnableC0949d runnableC0949d = new RunnableC0949d(bW, str2);
            if (this.oGH != null && this.oGH.zu(str)) {
                runnableC0949d.iq(true);
            }
            this.oGG.execute(runnableC0949d);
        }
        return bW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bW;
        bW = bW(str, i);
        if (bW != null && bW.getValid()) {
            RunnableC0949d runnableC0949d = new RunnableC0949d(bW, jSONObject);
            if (this.oGH != null && this.oGH.zu(str)) {
                runnableC0949d.iq(true);
            }
            this.oGG.execute(runnableC0949d);
        }
        return bW;
    }

    Flow bW(String str, int i) {
        Flow flow = new Flow(str, this.erK, i);
        if (this.oGH != null && !this.oGH.ah(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().re(str)) {
            flow.setValid(false);
        } else if (this.oGH != null && this.oGH.XC(str)) {
            flow.setValid(false);
        } else if (this.oGH != null && this.oGH.zt(str)) {
            flow.setValid(false);
        } else if (this.oGH != null && !this.oGH.XE(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oGG.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oGG.execute(new e(str, i, jSONArray));
    }

    public void L(String str, int i) {
        this.oGG.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oGI != null ? this.oGI.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eiJ() {
        this.oGG.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oGI != null) {
                    d.this.oGI.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oGG.execute(new a(wVar, z, sVar));
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
        r eiK = eiK();
        if (eiK != null && !eiK.dLX()) {
            z2 = false;
        }
        if (z2) {
            this.erI.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oGI == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oGI.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfK() {
        this.oGG.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oGI == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oGI.bfK();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.oGG.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oGI == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oGI.zm(str);
                } else {
                    d.this.oGI.zn(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oGG.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private static final r eiK() {
        return com.baidu.tieba.r.r.dLY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oGH = com.baidu.ubc.g.eiM();
            d.this.oGI = new com.baidu.ubc.c(d.this.mContext);
            d.this.oGI.bfL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oGS;

        b(String str, String str2, int i) {
            this.oGS = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oGS = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oGS = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oGS = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iq(boolean z) {
            if (this.oGS != null) {
                this.oGS.iq(z);
            }
        }

        public void XB(String str) {
            if (this.oGS != null) {
                this.oGS.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oGJ != null && d.this.oGH != null && d.this.oGH.XJ(this.mLogId) == 1) {
                eiL();
            }
            if (this.oGS.bgc() == -1) {
                if (bX(this.oGS.getId(), this.oGS.getOption())) {
                    if (d.this.oGH != null && d.this.oGH.zu(this.oGS.getId())) {
                        iq(true);
                    }
                } else {
                    return;
                }
            }
            this.oGS.bgg();
            String id = this.oGS.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oGH != null) {
                    String zr = d.this.oGH.zr(id);
                    if (!TextUtils.isEmpty(zr)) {
                        this.oGS.setCategory(zr);
                    }
                }
                if (d.this.oGJ != null && d.this.oGH != null && d.this.oGH.XJ(this.mLogId) == 2) {
                    eiL();
                }
                if (this.oGS.bgc() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oGI.d(this.oGS);
                } else if ((this.oGS.getOption() & 8) != 0) {
                    d.this.oGI.c(this.oGS);
                } else if (this.oGS == null || d.this.oGH == null || !d.this.oGH.XF(id)) {
                    d.this.oGI.b(this.oGS);
                } else {
                    d.this.oGI.f(this.oGS);
                }
            }
        }

        private boolean bX(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().re(str)) {
                if (d.this.oGH == null || d.this.oGH.ah(str, i)) {
                    if (d.this.oGH == null || !d.this.oGH.zt(str)) {
                        if (d.this.oGH == null || !d.this.oGH.XC(str)) {
                            return d.this.oGH == null || !d.this.oGH.XI(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private void eiL() {
            JSONObject bge;
            if (this.oGS != null) {
                String id = this.oGS.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oGS.getContent();
                    if (TextUtils.isEmpty(content) && (bge = this.oGS.bge()) != null) {
                        try {
                            content = bge.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oGJ.gX(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oGJ.gW(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC0949d implements Runnable {
        private p oGT;

        RunnableC0949d(Flow flow, String str) {
            this.oGT = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oGT.dw(flow.getStartTime());
            this.oGT.zA("1");
            d.e(d.this);
        }

        RunnableC0949d(Flow flow, JSONObject jSONObject) {
            this.oGT = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oGT.dw(flow.getStartTime());
            this.oGT.zA("1");
            d.e(d.this);
        }

        public void iq(boolean z) {
            if (this.oGT != null) {
                this.oGT.iq(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oGT.bgg();
            if (!TextUtils.isEmpty(d.this.oGH.zr(this.oGT.getId()))) {
                this.oGT.setCategory(d.this.oGH.zr(this.oGT.getId()));
            }
            d.this.oGI.a(this.oGT);
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
            if (d.this.oGI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGI.i(this.erA, this.erB, this.mValue);
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
            if (d.this.oGI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGI.a(this.erA, this.erB, this.mEndTime, this.erG);
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
            if (d.this.oGI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGI.L(this.erA, this.erB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        private w oGP;
        private boolean oGQ;
        private s oGR;

        a(w wVar, boolean z, s sVar) {
            this.oGP = wVar;
            this.oGQ = z;
            this.oGR = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oGI == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oGI.a(this.oGP, this.oGQ, this.oGR);
        }
    }
}
