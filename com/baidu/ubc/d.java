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
/* loaded from: classes6.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d oUX;
    private ExecutorService eAn;
    private int eAp;
    private boolean eAq = false;
    private Context mContext;
    public ScheduledExecutorService oUY;
    private com.baidu.ubc.g oUZ;
    private com.baidu.ubc.c oVa;
    private v oVb;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.eAp;
        dVar.eAp = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d ehJ() {
        if (oUX == null) {
            synchronized (d.class) {
                if (oUX == null) {
                    oUX = new d();
                }
            }
        }
        return oUX;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.eAp = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oUY = Executors.newSingleThreadScheduledExecutor();
            this.oUY.execute(new g());
            this.eAn = Executors.newSingleThreadExecutor();
            this.oVb = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        this.oUY.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oUY.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.Xu(str3);
        }
        this.oUY.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oUY.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oUY.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow cg;
        cg = cg(str, i);
        if (cg != null && cg.getValid()) {
            RunnableC0958d runnableC0958d = new RunnableC0958d(cg, str2);
            if (this.oUZ != null && this.oUZ.yI(str)) {
                runnableC0958d.iJ(true);
            }
            this.oUY.execute(runnableC0958d);
        }
        return cg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow cg;
        cg = cg(str, i);
        if (cg != null && cg.getValid()) {
            RunnableC0958d runnableC0958d = new RunnableC0958d(cg, jSONObject);
            if (this.oUZ != null && this.oUZ.yI(str)) {
                runnableC0958d.iJ(true);
            }
            this.oUY.execute(runnableC0958d);
        }
        return cg;
    }

    Flow cg(String str, int i) {
        Flow flow = new Flow(str, this.eAp, i);
        if (this.oUZ != null && !this.oUZ.am(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().ql(str)) {
            flow.setValid(false);
        } else if (this.oUZ != null && this.oUZ.Xv(str)) {
            flow.setValid(false);
        } else if (this.oUZ != null && this.oUZ.yH(str)) {
            flow.setValid(false);
        } else if (this.oUZ != null && !this.oUZ.Xx(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oUY.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oUY.execute(new e(str, i, jSONArray));
    }

    public void P(String str, int i) {
        this.oUY.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oVa != null ? this.oVa.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ehK() {
        this.oUY.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oVa != null) {
                    d.this.oVa.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oUY.execute(new a(wVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eS(JSONObject jSONObject) {
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
        r ehL = ehL();
        if (ehL != null && !ehL.dKz()) {
            z2 = false;
        }
        if (z2) {
            this.eAn.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oVa == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oVa.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beD() {
        this.oUY.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oVa == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oVa.beD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.oUY.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oVa == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oVa.yA(str);
                } else {
                    d.this.oVa.yB(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oUY.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private static final r ehL() {
        return com.baidu.tieba.q.t.dKA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oUZ = com.baidu.ubc.g.ehN();
            d.this.oVa = new com.baidu.ubc.c(d.this.mContext);
            d.this.oVa.beE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oVk;

        b(String str, String str2, int i) {
            this.oVk = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oVk = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oVk = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oVk = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iJ(boolean z) {
            if (this.oVk != null) {
                this.oVk.iJ(z);
            }
        }

        public void Xu(String str) {
            if (this.oVk != null) {
                this.oVk.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oVa == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oVb != null && d.this.oUZ != null && d.this.oUZ.XC(this.mLogId) == 1) {
                ehM();
            }
            if (this.oVk.beV() == -1) {
                if (ch(this.oVk.getId(), this.oVk.getOption())) {
                    if (d.this.oUZ != null && d.this.oUZ.yI(this.oVk.getId())) {
                        iJ(true);
                    }
                } else {
                    return;
                }
            }
            this.oVk.beZ();
            String id = this.oVk.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oUZ != null) {
                    String yF = d.this.oUZ.yF(id);
                    if (!TextUtils.isEmpty(yF)) {
                        this.oVk.setCategory(yF);
                    }
                }
                if (d.this.oVb != null && d.this.oUZ != null && d.this.oUZ.XC(this.mLogId) == 2) {
                    ehM();
                }
                if (this.oVk.beV() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oVa.d(this.oVk);
                } else if ((this.oVk.getOption() & 8) != 0) {
                    d.this.oVa.c(this.oVk);
                } else if (this.oVk == null || d.this.oUZ == null || !d.this.oUZ.Xy(id)) {
                    d.this.oVa.b(this.oVk);
                } else {
                    d.this.oVa.f(this.oVk);
                }
            }
        }

        private boolean ch(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().ql(str)) {
                if (d.this.oUZ == null || d.this.oUZ.am(str, i)) {
                    if (d.this.oUZ == null || !d.this.oUZ.yH(str)) {
                        if (d.this.oUZ == null || !d.this.oUZ.Xv(str)) {
                            return d.this.oUZ == null || !d.this.oUZ.XB(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private void ehM() {
            JSONObject beX;
            if (this.oVk != null) {
                String id = this.oVk.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oVk.getContent();
                    if (TextUtils.isEmpty(content) && (beX = this.oVk.beX()) != null) {
                        try {
                            content = beX.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oVb.hd(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oVb.hc(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0958d implements Runnable {
        private p oVl;

        RunnableC0958d(Flow flow, String str) {
            this.oVl = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oVl.dC(flow.getStartTime());
            this.oVl.yO("1");
            d.e(d.this);
        }

        RunnableC0958d(Flow flow, JSONObject jSONObject) {
            this.oVl = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oVl.dC(flow.getStartTime());
            this.oVl.yO("1");
            d.e(d.this);
        }

        public void iJ(boolean z) {
            if (this.oVl != null) {
                this.oVl.iJ(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oVa == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oVl.beZ();
            if (!TextUtils.isEmpty(d.this.oUZ.yF(this.oVl.getId()))) {
                this.oVl.setCategory(d.this.oUZ.yF(this.oVl.getId()));
            }
            d.this.oVa.a(this.oVl);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.eAp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f implements Runnable {
        private String eAf;
        private int eAg;
        private String mValue;

        f(String str, int i, String str2) {
            this.eAf = str;
            this.eAg = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oVa == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oVa.i(this.eAf, this.eAg, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        private String eAf;
        private int eAg;
        private JSONArray eAl;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eAf = str;
            this.eAg = i;
            this.eAl = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oVa == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oVa.a(this.eAf, this.eAg, this.mEndTime, this.eAl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {
        private String eAf;
        private int eAg;

        c(String str, int i) {
            this.eAf = str;
            this.eAg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oVa == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oVa.P(this.eAf, this.eAg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        private w oVh;
        private boolean oVi;
        private s oVj;

        a(w wVar, boolean z, s sVar) {
            this.oVh = wVar;
            this.oVi = z;
            this.oVj = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oVa == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oVa.a(this.oVh, this.oVi, this.oVj);
        }
    }
}
