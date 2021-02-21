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
    private static volatile d oSS;
    private ExecutorService eyM;
    private int eyO;
    private boolean eyP = false;
    private Context mContext;
    public ScheduledExecutorService oST;
    private com.baidu.ubc.g oSU;
    private com.baidu.ubc.c oSV;
    private v oSW;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.eyO;
        dVar.eyO = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d ehB() {
        if (oSS == null) {
            synchronized (d.class) {
                if (oSS == null) {
                    oSS = new d();
                }
            }
        }
        return oSS;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.eyO = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oST = Executors.newSingleThreadScheduledExecutor();
            this.oST.execute(new g());
            this.eyM = Executors.newSingleThreadExecutor();
            this.oSW = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        this.oST.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oST.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.Xn(str3);
        }
        this.oST.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oST.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oST.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow cg;
        cg = cg(str, i);
        if (cg != null && cg.getValid()) {
            RunnableC0952d runnableC0952d = new RunnableC0952d(cg, str2);
            if (this.oSU != null && this.oSU.yB(str)) {
                runnableC0952d.iJ(true);
            }
            this.oST.execute(runnableC0952d);
        }
        return cg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow cg;
        cg = cg(str, i);
        if (cg != null && cg.getValid()) {
            RunnableC0952d runnableC0952d = new RunnableC0952d(cg, jSONObject);
            if (this.oSU != null && this.oSU.yB(str)) {
                runnableC0952d.iJ(true);
            }
            this.oST.execute(runnableC0952d);
        }
        return cg;
    }

    Flow cg(String str, int i) {
        Flow flow = new Flow(str, this.eyO, i);
        if (this.oSU != null && !this.oSU.al(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().qe(str)) {
            flow.setValid(false);
        } else if (this.oSU != null && this.oSU.Xo(str)) {
            flow.setValid(false);
        } else if (this.oSU != null && this.oSU.yA(str)) {
            flow.setValid(false);
        } else if (this.oSU != null && !this.oSU.Xq(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oST.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oST.execute(new e(str, i, jSONArray));
    }

    public void O(String str, int i) {
        this.oST.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oSV != null ? this.oSV.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ehC() {
        this.oST.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oSV != null) {
                    d.this.oSV.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oST.execute(new a(wVar, z, sVar));
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
        r ehD = ehD();
        if (ehD != null && !ehD.dKr()) {
            z2 = false;
        }
        if (z2) {
            this.eyM.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oSV == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oSV.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beB() {
        this.oST.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oSV == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oSV.beB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.oST.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oSV == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oSV.yt(str);
                } else {
                    d.this.oSV.yu(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oST.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private static final r ehD() {
        return com.baidu.tieba.q.t.dKs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oSU = com.baidu.ubc.g.ehF();
            d.this.oSV = new com.baidu.ubc.c(d.this.mContext);
            d.this.oSV.beC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oTf;

        b(String str, String str2, int i) {
            this.oTf = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oTf = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oTf = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oTf = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iJ(boolean z) {
            if (this.oTf != null) {
                this.oTf.iJ(z);
            }
        }

        public void Xn(String str) {
            if (this.oTf != null) {
                this.oTf.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSV == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oSW != null && d.this.oSU != null && d.this.oSU.Xv(this.mLogId) == 1) {
                ehE();
            }
            if (this.oTf.beT() == -1) {
                if (ch(this.oTf.getId(), this.oTf.getOption())) {
                    if (d.this.oSU != null && d.this.oSU.yB(this.oTf.getId())) {
                        iJ(true);
                    }
                } else {
                    return;
                }
            }
            this.oTf.beX();
            String id = this.oTf.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oSU != null) {
                    String yy = d.this.oSU.yy(id);
                    if (!TextUtils.isEmpty(yy)) {
                        this.oTf.setCategory(yy);
                    }
                }
                if (d.this.oSW != null && d.this.oSU != null && d.this.oSU.Xv(this.mLogId) == 2) {
                    ehE();
                }
                if (this.oTf.beT() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oSV.d(this.oTf);
                } else if ((this.oTf.getOption() & 8) != 0) {
                    d.this.oSV.c(this.oTf);
                } else if (this.oTf == null || d.this.oSU == null || !d.this.oSU.Xr(id)) {
                    d.this.oSV.b(this.oTf);
                } else {
                    d.this.oSV.f(this.oTf);
                }
            }
        }

        private boolean ch(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().qe(str)) {
                if (d.this.oSU == null || d.this.oSU.al(str, i)) {
                    if (d.this.oSU == null || !d.this.oSU.yA(str)) {
                        if (d.this.oSU == null || !d.this.oSU.Xo(str)) {
                            return d.this.oSU == null || !d.this.oSU.Xu(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private void ehE() {
            JSONObject beV;
            if (this.oTf != null) {
                String id = this.oTf.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oTf.getContent();
                    if (TextUtils.isEmpty(content) && (beV = this.oTf.beV()) != null) {
                        try {
                            content = beV.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oSW.hd(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oSW.hc(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0952d implements Runnable {
        private p oTg;

        RunnableC0952d(Flow flow, String str) {
            this.oTg = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oTg.dC(flow.getStartTime());
            this.oTg.yH("1");
            d.e(d.this);
        }

        RunnableC0952d(Flow flow, JSONObject jSONObject) {
            this.oTg = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oTg.dC(flow.getStartTime());
            this.oTg.yH("1");
            d.e(d.this);
        }

        public void iJ(boolean z) {
            if (this.oTg != null) {
                this.oTg.iJ(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSV == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oTg.beX();
            if (!TextUtils.isEmpty(d.this.oSU.yy(this.oTg.getId()))) {
                this.oTg.setCategory(d.this.oSU.yy(this.oTg.getId()));
            }
            d.this.oSV.a(this.oTg);
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
            if (d.this.oSV == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSV.i(this.eyE, this.eyF, this.mValue);
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
            if (d.this.oSV == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSV.a(this.eyE, this.eyF, this.mEndTime, this.eyK);
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
            if (d.this.oSV == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSV.O(this.eyE, this.eyF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        private w oTc;
        private boolean oTd;
        private s oTe;

        a(w wVar, boolean z, s sVar) {
            this.oTc = wVar;
            this.oTd = z;
            this.oTe = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oSV == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oSV.a(this.oTc, this.oTd, this.oTe);
        }
    }
}
