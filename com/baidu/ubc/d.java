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
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d oSs;
    private ExecutorService eyM;
    private int eyO;
    private boolean eyP = false;
    private Context mContext;
    public ScheduledExecutorService oSt;
    private com.baidu.ubc.g oSu;
    private com.baidu.ubc.c oSv;
    private v oSw;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.eyO;
        dVar.eyO = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d eht() {
        if (oSs == null) {
            synchronized (d.class) {
                if (oSs == null) {
                    oSs = new d();
                }
            }
        }
        return oSs;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.eyO = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oSt = Executors.newSingleThreadScheduledExecutor();
            this.oSt.execute(new g());
            this.eyM = Executors.newSingleThreadExecutor();
            this.oSw = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        this.oSt.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oSt.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.Xb(str3);
        }
        this.oSt.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oSt.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oSt.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow cg;
        cg = cg(str, i);
        if (cg != null && cg.getValid()) {
            RunnableC0950d runnableC0950d = new RunnableC0950d(cg, str2);
            if (this.oSu != null && this.oSu.yB(str)) {
                runnableC0950d.iJ(true);
            }
            this.oSt.execute(runnableC0950d);
        }
        return cg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow cg;
        cg = cg(str, i);
        if (cg != null && cg.getValid()) {
            RunnableC0950d runnableC0950d = new RunnableC0950d(cg, jSONObject);
            if (this.oSu != null && this.oSu.yB(str)) {
                runnableC0950d.iJ(true);
            }
            this.oSt.execute(runnableC0950d);
        }
        return cg;
    }

    Flow cg(String str, int i) {
        Flow flow = new Flow(str, this.eyO, i);
        if (this.oSu != null && !this.oSu.al(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().qe(str)) {
            flow.setValid(false);
        } else if (this.oSu != null && this.oSu.Xc(str)) {
            flow.setValid(false);
        } else if (this.oSu != null && this.oSu.yA(str)) {
            flow.setValid(false);
        } else if (this.oSu != null && !this.oSu.Xe(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oSt.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oSt.execute(new e(str, i, jSONArray));
    }

    public void O(String str, int i) {
        this.oSt.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oSv != null ? this.oSv.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ehu() {
        this.oSt.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oSv != null) {
                    d.this.oSv.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oSt.execute(new a(wVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eP(JSONObject jSONObject) {
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
        r ehv = ehv();
        if (ehv != null && !ehv.dKj()) {
            z2 = false;
        }
        if (z2) {
            this.eyM.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oSv == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oSv.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beB() {
        this.oSt.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oSv == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oSv.beB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.oSt.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oSv == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oSv.yt(str);
                } else {
                    d.this.oSv.yu(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oSt.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private static final r ehv() {
        return com.baidu.tieba.q.t.dKk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oSu = com.baidu.ubc.g.ehx();
            d.this.oSv = new com.baidu.ubc.c(d.this.mContext);
            d.this.oSv.beC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oSF;

        b(String str, String str2, int i) {
            this.oSF = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oSF = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oSF = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oSF = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iJ(boolean z) {
            if (this.oSF != null) {
                this.oSF.iJ(z);
            }
        }

        public void Xb(String str) {
            if (this.oSF != null) {
                this.oSF.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSv == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oSw != null && d.this.oSu != null && d.this.oSu.Xj(this.mLogId) == 1) {
                ehw();
            }
            if (this.oSF.beT() == -1) {
                if (ch(this.oSF.getId(), this.oSF.getOption())) {
                    if (d.this.oSu != null && d.this.oSu.yB(this.oSF.getId())) {
                        iJ(true);
                    }
                } else {
                    return;
                }
            }
            this.oSF.beX();
            String id = this.oSF.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oSu != null) {
                    String yy = d.this.oSu.yy(id);
                    if (!TextUtils.isEmpty(yy)) {
                        this.oSF.setCategory(yy);
                    }
                }
                if (d.this.oSw != null && d.this.oSu != null && d.this.oSu.Xj(this.mLogId) == 2) {
                    ehw();
                }
                if (this.oSF.beT() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oSv.d(this.oSF);
                } else if ((this.oSF.getOption() & 8) != 0) {
                    d.this.oSv.c(this.oSF);
                } else if (this.oSF == null || d.this.oSu == null || !d.this.oSu.Xf(id)) {
                    d.this.oSv.b(this.oSF);
                } else {
                    d.this.oSv.f(this.oSF);
                }
            }
        }

        private boolean ch(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().qe(str)) {
                if (d.this.oSu == null || d.this.oSu.al(str, i)) {
                    if (d.this.oSu == null || !d.this.oSu.yA(str)) {
                        if (d.this.oSu == null || !d.this.oSu.Xc(str)) {
                            return d.this.oSu == null || !d.this.oSu.Xi(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private void ehw() {
            JSONObject beV;
            if (this.oSF != null) {
                String id = this.oSF.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oSF.getContent();
                    if (TextUtils.isEmpty(content) && (beV = this.oSF.beV()) != null) {
                        try {
                            content = beV.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oSw.hb(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oSw.ha(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0950d implements Runnable {
        private p oSG;

        RunnableC0950d(Flow flow, String str) {
            this.oSG = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oSG.dC(flow.getStartTime());
            this.oSG.yH("1");
            d.e(d.this);
        }

        RunnableC0950d(Flow flow, JSONObject jSONObject) {
            this.oSG = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oSG.dC(flow.getStartTime());
            this.oSG.yH("1");
            d.e(d.this);
        }

        public void iJ(boolean z) {
            if (this.oSG != null) {
                this.oSG.iJ(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSv == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oSG.beX();
            if (!TextUtils.isEmpty(d.this.oSu.yy(this.oSG.getId()))) {
                this.oSG.setCategory(d.this.oSu.yy(this.oSG.getId()));
            }
            d.this.oSv.a(this.oSG);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.eyO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f implements Runnable {
        private String eyE;
        private int eyF;
        private String mValue;

        f(String str, int i, String str2) {
            this.eyE = str;
            this.eyF = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSv == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSv.i(this.eyE, this.eyF, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        private String eyE;
        private int eyF;
        private JSONArray eyK;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eyE = str;
            this.eyF = i;
            this.eyK = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSv == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSv.a(this.eyE, this.eyF, this.mEndTime, this.eyK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {
        private String eyE;
        private int eyF;

        c(String str, int i) {
            this.eyE = str;
            this.eyF = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSv == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSv.O(this.eyE, this.eyF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        private w oSC;
        private boolean oSD;
        private s oSE;

        a(w wVar, boolean z, s sVar) {
            this.oSC = wVar;
            this.oSD = z;
            this.oSE = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSv == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSv.a(this.oSC, this.oSD, this.oSE);
        }
    }
}
