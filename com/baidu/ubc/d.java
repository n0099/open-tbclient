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
    private static volatile d mhI;
    private ExecutorService dqf;
    private int dqh;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g mhJ;
    private com.baidu.ubc.c mhK;
    private boolean dqi = false;
    private ad mhv = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dqh;
        dVar.dqh = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dsb() {
        if (mhI == null) {
            synchronized (d.class) {
                if (mhI == null) {
                    mhI = new d();
                }
            }
        }
        return mhI;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dqh = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g(this, null));
            this.dqf = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.mhJ != null && this.mhJ.tJ(str)) {
                bVar.gn(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Pa(str3);
            }
            if (this.mhJ != null && this.mhJ.tJ(str)) {
                bVar.gn(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.mhJ != null && this.mhJ.tJ(str)) {
                bVar.gn(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ab(String str, int i) {
        if (this.mhJ == null || this.mhJ.aa(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().mj(str)) {
                if (this.mhv.dsq() && this.mhJ != null && this.mhJ.tH(str) > 0) {
                    if (new Random().nextInt(100) >= this.mhJ.tH(str)) {
                        return true;
                    }
                }
                return this.mhJ != null && this.mhJ.tI(str);
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
        Flow bM;
        bM = bM(str, i);
        if (bM != null && bM.getValid()) {
            RunnableC0765d runnableC0765d = new RunnableC0765d(bM, str2);
            if (this.mhJ != null && this.mhJ.tJ(str)) {
                runnableC0765d.gn(true);
            }
            this.mExecutorService.execute(runnableC0765d);
        }
        return bM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bM;
        bM = bM(str, i);
        if (bM != null && bM.getValid()) {
            RunnableC0765d runnableC0765d = new RunnableC0765d(bM, jSONObject);
            if (this.mhJ != null && this.mhJ.tJ(str)) {
                runnableC0765d.gn(true);
            }
            this.mExecutorService.execute(runnableC0765d);
        }
        return bM;
    }

    Flow bM(String str, int i) {
        Flow flow = new Flow(str, this.dqh, i);
        if (this.mhJ != null && !this.mhJ.aa(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().mj(str)) {
            flow.setValid(false);
        } else {
            if (this.mhv.dsq() && this.mhJ != null && this.mhJ.tH(str) > 0) {
                int tH = this.mhJ.tH(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + tH);
                }
                if (nextInt >= tH) {
                    flow.setValid(false);
                }
            }
            if (this.mhJ != null && this.mhJ.tI(str)) {
                flow.setValid(false);
            } else if (this.mhJ != null && !this.mhJ.Pc(str)) {
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
    /* loaded from: classes13.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d mhL;

        @Override // java.lang.Runnable
        public void run() {
            if (this.mhL.mhK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.mhL.mhK.aHY();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dD(JSONObject jSONObject) {
        z(jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(JSONObject jSONObject, String str) {
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
        r dsc = dsc();
        if (dsc != null && !dsc.daA()) {
            z2 = false;
        }
        if (z2) {
            this.dqf.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.mhK == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.mhK.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIb() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mhK == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.mhK.aIb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mhK == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.mhK.tB(str);
                } else {
                    d.this.mhK.tC(str);
                }
            }
        });
    }

    private static final r dsc() {
        return com.baidu.tieba.q.j.daB();
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
            d.this.mhJ = com.baidu.ubc.g.dsd();
            d.this.mhK = new com.baidu.ubc.c(d.this.mContext);
            d.this.mhK.aIc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements Runnable {
        private n mhT;

        b(String str, String str2, int i) {
            this.mhT = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.mhT = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.mhT = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.mhT = new n(str, str2, i, str3, j, i2);
        }

        public void gn(boolean z) {
            if (this.mhT != null) {
                this.mhT.gn(z);
            }
        }

        public void Pa(String str) {
            if (this.mhT != null) {
                this.mhT.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mhK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mhT.aIx();
            String id = this.mhT.getId();
            if (!TextUtils.isEmpty(id)) {
                String tG = d.this.mhJ.tG(id);
                if (!TextUtils.isEmpty(tG)) {
                    this.mhT.setCategory(tG);
                }
                if ((this.mhT.getOption() & 8) != 0) {
                    d.this.mhK.b(this.mhT);
                } else if (this.mhT == null || !d.this.mhJ.Pd(id)) {
                    d.this.mhK.a(this.mhT);
                } else {
                    d.this.mhK.c(this.mhT);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0765d implements Runnable {
        private p mhU;

        RunnableC0765d(Flow flow, String str) {
            this.mhU = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.mhU.bR(flow.getStartTime());
            this.mhU.tP("1");
            d.d(d.this);
        }

        RunnableC0765d(Flow flow, JSONObject jSONObject) {
            this.mhU = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.mhU.bR(flow.getStartTime());
            this.mhU.tP("1");
            d.d(d.this);
        }

        public void gn(boolean z) {
            if (this.mhU != null) {
                this.mhU.gn(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mhK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mhU.aIx();
            if (!TextUtils.isEmpty(d.this.mhJ.tG(this.mhU.getId()))) {
                this.mhU.setCategory(d.this.mhJ.tG(this.mhU.getId()));
            }
            d.this.mhK.a(this.mhU);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.dqh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class f implements Runnable {
        private String dpX;
        private int dpY;
        private String mValue;

        f(String str, int i, String str2) {
            this.dpX = str;
            this.dpY = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mhK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mhK.f(this.dpX, this.dpY, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class e implements Runnable {
        private String dpX;
        private int dpY;
        private JSONArray dqd;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dpX = str;
            this.dpY = i;
            this.dqd = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mhK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mhK.a(this.dpX, this.dpY, this.mEndTime, this.dqd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c implements Runnable {
        private String dpX;
        private int dpY;

        c(String str, int i) {
            this.dpX = str;
            this.dpY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mhK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mhK.G(this.dpX, this.dpY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements Runnable {
        private v mhQ;
        private boolean mhR;
        private s mhS;

        a(v vVar, boolean z, s sVar) {
            this.mhQ = vVar;
            this.mhR = z;
            this.mhS = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mhK == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mhK.a(this.mhQ, this.mhR, this.mhS);
        }
    }
}
