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
    private static volatile d oMO;
    private ExecutorService eBs;
    private int eBu;
    private boolean eBv = false;
    private Context mContext;
    public ScheduledExecutorService oMP;
    private com.baidu.ubc.g oMQ;
    private com.baidu.ubc.c oMR;
    private v oMS;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.eBu;
        dVar.eBu = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d eiS() {
        if (oMO == null) {
            synchronized (d.class) {
                if (oMO == null) {
                    oMO = new d();
                }
            }
        }
        return oMO;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.eBu = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oMP = Executors.newSingleThreadScheduledExecutor();
            this.oMP.execute(new g());
            this.eBs = Executors.newSingleThreadExecutor();
            this.oMS = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        this.oMP.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oMP.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.Xk(str3);
        }
        this.oMP.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oMP.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oMP.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow ce;
        ce = ce(str, i);
        if (ce != null && ce.getValid()) {
            RunnableC0925d runnableC0925d = new RunnableC0925d(ce, str2);
            if (this.oMQ != null && this.oMQ.zt(str)) {
                runnableC0925d.iL(true);
            }
            this.oMP.execute(runnableC0925d);
        }
        return ce;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow ce;
        ce = ce(str, i);
        if (ce != null && ce.getValid()) {
            RunnableC0925d runnableC0925d = new RunnableC0925d(ce, jSONObject);
            if (this.oMQ != null && this.oMQ.zt(str)) {
                runnableC0925d.iL(true);
            }
            this.oMP.execute(runnableC0925d);
        }
        return ce;
    }

    Flow ce(String str, int i) {
        Flow flow = new Flow(str, this.eBu, i);
        if (this.oMQ != null && !this.oMQ.aj(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().qX(str)) {
            flow.setValid(false);
        } else if (this.oMQ != null && this.oMQ.Xl(str)) {
            flow.setValid(false);
        } else if (this.oMQ != null && this.oMQ.zs(str)) {
            flow.setValid(false);
        } else if (this.oMQ != null && !this.oMQ.Xn(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oMP.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oMP.execute(new e(str, i, jSONArray));
    }

    public void M(String str, int i) {
        this.oMP.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oMR != null ? this.oMR.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eiT() {
        this.oMP.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oMR != null) {
                    d.this.oMR.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oMP.execute(new a(wVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eO(JSONObject jSONObject) {
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
        r eiU = eiU();
        if (eiU != null && !eiU.dLP()) {
            z2 = false;
        }
        if (z2) {
            this.eBs.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oMR == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oMR.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bih() {
        this.oMP.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oMR == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oMR.bih();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.oMP.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oMR == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oMR.zl(str);
                } else {
                    d.this.oMR.zm(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oMP.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private static final r eiU() {
        return com.baidu.tieba.q.t.dLQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oMQ = com.baidu.ubc.g.eiW();
            d.this.oMR = new com.baidu.ubc.c(d.this.mContext);
            d.this.oMR.bii();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oNb;

        b(String str, String str2, int i) {
            this.oNb = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oNb = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oNb = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oNb = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iL(boolean z) {
            if (this.oNb != null) {
                this.oNb.iL(z);
            }
        }

        public void Xk(String str) {
            if (this.oNb != null) {
                this.oNb.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oMR == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oMS != null && d.this.oMQ != null && d.this.oMQ.Xs(this.mLogId) == 1) {
                eiV();
            }
            if (this.oNb.biz() == -1) {
                if (cf(this.oNb.getId(), this.oNb.getOption())) {
                    if (d.this.oMQ != null && d.this.oMQ.zt(this.oNb.getId())) {
                        iL(true);
                    }
                } else {
                    return;
                }
            }
            this.oNb.biD();
            String id = this.oNb.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oMQ != null) {
                    String zq = d.this.oMQ.zq(id);
                    if (!TextUtils.isEmpty(zq)) {
                        this.oNb.setCategory(zq);
                    }
                }
                if (d.this.oMS != null && d.this.oMQ != null && d.this.oMQ.Xs(this.mLogId) == 2) {
                    eiV();
                }
                if (this.oNb.biz() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oMR.d(this.oNb);
                } else if ((this.oNb.getOption() & 8) != 0) {
                    d.this.oMR.c(this.oNb);
                } else if (this.oNb == null || d.this.oMQ == null || !d.this.oMQ.Xo(id)) {
                    d.this.oMR.b(this.oNb);
                } else {
                    d.this.oMR.f(this.oNb);
                }
            }
        }

        private boolean cf(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().qX(str)) {
                if (d.this.oMQ == null || d.this.oMQ.aj(str, i)) {
                    if (d.this.oMQ == null || !d.this.oMQ.zs(str)) {
                        if (d.this.oMQ == null || !d.this.oMQ.Xl(str)) {
                            return d.this.oMQ == null || !d.this.oMQ.Xr(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private void eiV() {
            JSONObject biB;
            if (this.oNb != null) {
                String id = this.oNb.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oNb.getContent();
                    if (TextUtils.isEmpty(content) && (biB = this.oNb.biB()) != null) {
                        try {
                            content = biB.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oMS.gV(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oMS.gU(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0925d implements Runnable {
        private p oNc;

        RunnableC0925d(Flow flow, String str) {
            this.oNc = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oNc.dw(flow.getStartTime());
            this.oNc.zz("1");
            d.e(d.this);
        }

        RunnableC0925d(Flow flow, JSONObject jSONObject) {
            this.oNc = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oNc.dw(flow.getStartTime());
            this.oNc.zz("1");
            d.e(d.this);
        }

        public void iL(boolean z) {
            if (this.oNc != null) {
                this.oNc.iL(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oMR == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oNc.biD();
            if (!TextUtils.isEmpty(d.this.oMQ.zq(this.oNc.getId()))) {
                this.oNc.setCategory(d.this.oMQ.zq(this.oNc.getId()));
            }
            d.this.oMR.a(this.oNc);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.eBu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class f implements Runnable {
        private String eBk;
        private int eBl;
        private String mValue;

        f(String str, int i, String str2) {
            this.eBk = str;
            this.eBl = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oMR == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oMR.i(this.eBk, this.eBl, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class e implements Runnable {
        private String eBk;
        private int eBl;
        private JSONArray eBq;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eBk = str;
            this.eBl = i;
            this.eBq = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oMR == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oMR.a(this.eBk, this.eBl, this.mEndTime, this.eBq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c implements Runnable {
        private String eBk;
        private int eBl;

        c(String str, int i) {
            this.eBk = str;
            this.eBl = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oMR == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oMR.M(this.eBk, this.eBl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private w oMY;
        private boolean oMZ;
        private s oNa;

        a(w wVar, boolean z, s sVar) {
            this.oMY = wVar;
            this.oMZ = z;
            this.oNa = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oMR == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oMR.a(this.oMY, this.oMZ, this.oNa);
        }
    }
}
