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
    private static volatile d lNf;
    private ExecutorService def;
    private int deh;
    private boolean dei = false;
    private ad lMS = new ad();
    private com.baidu.ubc.g lNg;
    private com.baidu.ubc.c lNh;
    private Context mContext;
    public ExecutorService mExecutorService;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.deh;
        dVar.deh = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dkz() {
        if (lNf == null) {
            synchronized (d.class) {
                if (lNf == null) {
                    lNf = new d();
                }
            }
        }
        return lNf;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.deh = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g(this, null));
            this.def = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.lNg != null && this.lNg.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, String str3, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Nj(str3);
            }
            if (this.lNg != null && this.lNg.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!aa(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.lNg != null && this.lNg.sg(str)) {
                bVar.gc(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean aa(String str, int i) {
        if (this.lNg == null || this.lNg.Z(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().kV(str)) {
                if (this.lMS.dkO() && this.lNg != null && this.lNg.se(str) > 0) {
                    if (new Random().nextInt(100) >= this.lNg.se(str)) {
                        return true;
                    }
                }
                return this.lNg != null && this.lNg.sf(str);
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
            RunnableC0690d runnableC0690d = new RunnableC0690d(bL, str2);
            if (this.lNg != null && this.lNg.sg(str)) {
                runnableC0690d.gc(true);
            }
            this.mExecutorService.execute(runnableC0690d);
        }
        return bL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bL;
        bL = bL(str, i);
        if (bL != null && bL.getValid()) {
            RunnableC0690d runnableC0690d = new RunnableC0690d(bL, jSONObject);
            if (this.lNg != null && this.lNg.sg(str)) {
                runnableC0690d.gc(true);
            }
            this.mExecutorService.execute(runnableC0690d);
        }
        return bL;
    }

    Flow bL(String str, int i) {
        Flow flow = new Flow(str, this.deh, i);
        if (this.lNg != null && !this.lNg.Z(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().kV(str)) {
            flow.setValid(false);
        } else {
            if (this.lMS.dkO() && this.lNg != null && this.lNg.se(str) > 0) {
                int se = this.lNg.se(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + se);
                }
                if (nextInt >= se) {
                    flow.setValid(false);
                }
            }
            if (this.lNg != null && this.lNg.sf(str)) {
                flow.setValid(false);
            } else if (this.lNg != null && !this.lNg.Nl(str)) {
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

    public void C(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d lNi;

        @Override // java.lang.Runnable
        public void run() {
            if (this.lNi.lNh == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.lNi.lNh.aDr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dw(JSONObject jSONObject) {
        s(jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(JSONObject jSONObject, String str) {
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
        r dkA = dkA();
        if (dkA != null && !dkA.cTi()) {
            z2 = false;
        }
        if (z2) {
            this.def.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.lNh == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.lNh.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDu() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lNh == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.lNh.aDu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.lNh == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.lNh.rY(str);
                } else {
                    d.this.lNh.rZ(str);
                }
            }
        });
    }

    private static final r dkA() {
        return com.baidu.tieba.q.j.cTj();
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
            d.this.lNg = com.baidu.ubc.g.dkB();
            d.this.lNh = new com.baidu.ubc.c(d.this.mContext);
            d.this.lNh.aDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements Runnable {
        private n lNq;

        b(String str, String str2, int i) {
            this.lNq = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.lNq = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.lNq = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.lNq = new n(str, str2, i, str3, j, i2);
        }

        public void gc(boolean z) {
            if (this.lNq != null) {
                this.lNq.gc(z);
            }
        }

        public void Nj(String str) {
            if (this.lNq != null) {
                this.lNq.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNh == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.lNq.aDN();
            String id = this.lNq.getId();
            if (!TextUtils.isEmpty(id)) {
                String sd = d.this.lNg.sd(id);
                if (!TextUtils.isEmpty(sd)) {
                    this.lNq.setCategory(sd);
                }
                if ((this.lNq.getOption() & 8) != 0) {
                    d.this.lNh.b(this.lNq);
                } else if (this.lNq == null || !d.this.lNg.Nm(id)) {
                    d.this.lNh.a(this.lNq);
                } else {
                    d.this.lNh.c(this.lNq);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0690d implements Runnable {
        private p lNr;

        RunnableC0690d(Flow flow, String str) {
            this.lNr = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.lNr.bR(flow.getStartTime());
            this.lNr.sj("1");
            d.d(d.this);
        }

        RunnableC0690d(Flow flow, JSONObject jSONObject) {
            this.lNr = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.lNr.bR(flow.getStartTime());
            this.lNr.sj("1");
            d.d(d.this);
        }

        public void gc(boolean z) {
            if (this.lNr != null) {
                this.lNr.gc(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNh == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.lNr.aDN();
            if (!TextUtils.isEmpty(d.this.lNg.sd(this.lNr.getId()))) {
                this.lNr.setCategory(d.this.lNg.sd(this.lNr.getId()));
            }
            d.this.lNh.a(this.lNr);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.deh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class f implements Runnable {
        private String cgl;
        private int ddY;
        private String mValue;

        f(String str, int i, String str2) {
            this.cgl = str;
            this.ddY = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNh == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNh.f(this.cgl, this.ddY, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class e implements Runnable {
        private String cgl;
        private int ddY;
        private JSONArray ded;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.cgl = str;
            this.ddY = i;
            this.ded = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNh == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNh.a(this.cgl, this.ddY, this.mEndTime, this.ded);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c implements Runnable {
        private String cgl;
        private int ddY;

        c(String str, int i) {
            this.cgl = str;
            this.ddY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNh == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNh.C(this.cgl, this.ddY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements Runnable {
        private v lNn;
        private boolean lNo;
        private s lNp;

        a(v vVar, boolean z, s sVar) {
            this.lNn = vVar;
            this.lNo = z;
            this.lNp = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNh == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.lNh.a(this.lNn, this.lNo, this.lNp);
        }
    }
}
