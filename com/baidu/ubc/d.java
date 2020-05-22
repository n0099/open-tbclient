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
    private static volatile d mgy;
    private ExecutorService dqf;
    private int dqh;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.c mgA;
    private com.baidu.ubc.g mgz;
    private boolean dqi = false;
    private ad mgl = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dqh;
        dVar.dqh = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d drN() {
        if (mgy == null) {
            synchronized (d.class) {
                if (mgy == null) {
                    mgy = new d();
                }
            }
        }
        return mgy;
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
            if (this.mgz != null && this.mgz.tJ(str)) {
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
                bVar.OZ(str3);
            }
            if (this.mgz != null && this.mgz.tJ(str)) {
                bVar.gn(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.mgz != null && this.mgz.tJ(str)) {
                bVar.gn(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ab(String str, int i) {
        if (this.mgz == null || this.mgz.aa(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().mj(str)) {
                if (this.mgl.dsc() && this.mgz != null && this.mgz.tH(str) > 0) {
                    if (new Random().nextInt(100) >= this.mgz.tH(str)) {
                        return true;
                    }
                }
                return this.mgz != null && this.mgz.tI(str);
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
            RunnableC0764d runnableC0764d = new RunnableC0764d(bM, str2);
            if (this.mgz != null && this.mgz.tJ(str)) {
                runnableC0764d.gn(true);
            }
            this.mExecutorService.execute(runnableC0764d);
        }
        return bM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bM;
        bM = bM(str, i);
        if (bM != null && bM.getValid()) {
            RunnableC0764d runnableC0764d = new RunnableC0764d(bM, jSONObject);
            if (this.mgz != null && this.mgz.tJ(str)) {
                runnableC0764d.gn(true);
            }
            this.mExecutorService.execute(runnableC0764d);
        }
        return bM;
    }

    Flow bM(String str, int i) {
        Flow flow = new Flow(str, this.dqh, i);
        if (this.mgz != null && !this.mgz.aa(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().mj(str)) {
            flow.setValid(false);
        } else {
            if (this.mgl.dsc() && this.mgz != null && this.mgz.tH(str) > 0) {
                int tH = this.mgz.tH(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + tH);
                }
                if (nextInt >= tH) {
                    flow.setValid(false);
                }
            }
            if (this.mgz != null && this.mgz.tI(str)) {
                flow.setValid(false);
            } else if (this.mgz != null && !this.mgz.Pb(str)) {
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
        final /* synthetic */ d mgB;

        @Override // java.lang.Runnable
        public void run() {
            if (this.mgB.mgA == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.mgB.mgA.aHY();
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
        r drO = drO();
        if (drO != null && !drO.dak()) {
            z2 = false;
        }
        if (z2) {
            this.dqf.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.mgA == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.mgA.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIb() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mgA == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.mgA.aIb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.mgA == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.mgA.tB(str);
                } else {
                    d.this.mgA.tC(str);
                }
            }
        });
    }

    private static final r drO() {
        return com.baidu.tieba.q.j.dal();
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
            d.this.mgz = com.baidu.ubc.g.drP();
            d.this.mgA = new com.baidu.ubc.c(d.this.mContext);
            d.this.mgA.aIc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements Runnable {
        private n mgJ;

        b(String str, String str2, int i) {
            this.mgJ = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.mgJ = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.mgJ = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.mgJ = new n(str, str2, i, str3, j, i2);
        }

        public void gn(boolean z) {
            if (this.mgJ != null) {
                this.mgJ.gn(z);
            }
        }

        public void OZ(String str) {
            if (this.mgJ != null) {
                this.mgJ.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mgA == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mgJ.aIx();
            String id = this.mgJ.getId();
            if (!TextUtils.isEmpty(id)) {
                String tG = d.this.mgz.tG(id);
                if (!TextUtils.isEmpty(tG)) {
                    this.mgJ.setCategory(tG);
                }
                if ((this.mgJ.getOption() & 8) != 0) {
                    d.this.mgA.b(this.mgJ);
                } else if (this.mgJ == null || !d.this.mgz.Pc(id)) {
                    d.this.mgA.a(this.mgJ);
                } else {
                    d.this.mgA.c(this.mgJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0764d implements Runnable {
        private p mgK;

        RunnableC0764d(Flow flow, String str) {
            this.mgK = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.mgK.bR(flow.getStartTime());
            this.mgK.tP("1");
            d.d(d.this);
        }

        RunnableC0764d(Flow flow, JSONObject jSONObject) {
            this.mgK = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.mgK.bR(flow.getStartTime());
            this.mgK.tP("1");
            d.d(d.this);
        }

        public void gn(boolean z) {
            if (this.mgK != null) {
                this.mgK.gn(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mgA == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.mgK.aIx();
            if (!TextUtils.isEmpty(d.this.mgz.tG(this.mgK.getId()))) {
                this.mgK.setCategory(d.this.mgz.tG(this.mgK.getId()));
            }
            d.this.mgA.a(this.mgK);
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
            if (d.this.mgA == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mgA.f(this.dpX, this.dpY, this.mValue);
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
            if (d.this.mgA == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mgA.a(this.dpX, this.dpY, this.mEndTime, this.dqd);
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
            if (d.this.mgA == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mgA.G(this.dpX, this.dpY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements Runnable {
        private v mgG;
        private boolean mgH;
        private s mgI;

        a(v vVar, boolean z, s sVar) {
            this.mgG = vVar;
            this.mgH = z;
            this.mgI = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mgA == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.mgA.a(this.mgG, this.mgH, this.mgI);
        }
    }
}
