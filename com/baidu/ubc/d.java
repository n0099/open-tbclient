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
/* loaded from: classes14.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d nfa;
    private ExecutorService dJT;
    private int dJV;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g nfb;
    private com.baidu.ubc.c nfc;
    private boolean dJW = false;
    private ad neN = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dJV;
        dVar.dJV = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dLU() {
        if (nfa == null) {
            synchronized (d.class) {
                if (nfa == null) {
                    nfa = new d();
                }
            }
        }
        return nfa;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dJV = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g(this, null));
            this.dJT = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.nfb != null && this.nfb.xg(str)) {
                bVar.hi(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.Tx(str3);
            }
            if (this.nfb != null && this.nfb.xg(str)) {
                bVar.hi(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.nfb != null && this.nfb.xg(str)) {
                bVar.hi(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ae(String str, int i) {
        if (this.nfb == null || this.nfb.ad(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().oR(str)) {
                if (this.neN.dMj() && this.nfb != null && this.nfb.xe(str) > 0) {
                    if (new Random().nextInt(100) >= this.nfb.xe(str)) {
                        return true;
                    }
                }
                return this.nfb != null && this.nfb.xf(str);
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
        Flow bO;
        bO = bO(str, i);
        if (bO != null && bO.getValid()) {
            RunnableC0848d runnableC0848d = new RunnableC0848d(bO, str2);
            if (this.nfb != null && this.nfb.xg(str)) {
                runnableC0848d.hi(true);
            }
            this.mExecutorService.execute(runnableC0848d);
        }
        return bO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bO;
        bO = bO(str, i);
        if (bO != null && bO.getValid()) {
            RunnableC0848d runnableC0848d = new RunnableC0848d(bO, jSONObject);
            if (this.nfb != null && this.nfb.xg(str)) {
                runnableC0848d.hi(true);
            }
            this.mExecutorService.execute(runnableC0848d);
        }
        return bO;
    }

    Flow bO(String str, int i) {
        Flow flow = new Flow(str, this.dJV, i);
        if (this.nfb != null && !this.nfb.ad(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().oR(str)) {
            flow.setValid(false);
        } else {
            if (this.neN.dMj() && this.nfb != null && this.nfb.xe(str) > 0) {
                int xe = this.nfb.xe(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + xe);
                }
                if (nextInt >= xe) {
                    flow.setValid(false);
                }
            }
            if (this.nfb != null && this.nfb.xf(str)) {
                flow.setValid(false);
            } else if (this.nfb != null && !this.nfb.Tz(str)) {
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

    public void H(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d nfd;

        @Override // java.lang.Runnable
        public void run() {
            if (this.nfd.nfc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.nfd.nfc.aVw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ef(JSONObject jSONObject) {
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
        r dLV = dLV();
        if (dLV != null && !dLV.dtA()) {
            z2 = false;
        }
        if (z2) {
            this.dJT.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.nfc == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.nfc.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVz() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.nfc == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.nfc.aVz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.nfc == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.nfc.wY(str);
                } else {
                    d.this.nfc.wZ(str);
                }
            }
        });
    }

    private static final r dLV() {
        return com.baidu.tieba.q.j.dtB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.nfb = com.baidu.ubc.g.dLW();
            d.this.nfc = new com.baidu.ubc.c(d.this.mContext);
            d.this.nfc.aVA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b implements Runnable {
        private n nfl;

        b(String str, String str2, int i) {
            this.nfl = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.nfl = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.nfl = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.nfl = new n(str, str2, i, str3, j, i2);
        }

        public void hi(boolean z) {
            if (this.nfl != null) {
                this.nfl.hi(z);
            }
        }

        public void Tx(String str) {
            if (this.nfl != null) {
                this.nfl.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nfc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.nfl.aVV();
            String id = this.nfl.getId();
            if (!TextUtils.isEmpty(id)) {
                String xd = d.this.nfb.xd(id);
                if (!TextUtils.isEmpty(xd)) {
                    this.nfl.setCategory(xd);
                }
                if ((this.nfl.getOption() & 8) != 0) {
                    d.this.nfc.b(this.nfl);
                } else if (this.nfl == null || !d.this.nfb.TA(id)) {
                    d.this.nfc.a(this.nfl);
                } else {
                    d.this.nfc.c(this.nfl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class RunnableC0848d implements Runnable {
        private p nfm;

        RunnableC0848d(Flow flow, String str) {
            this.nfm = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.nfm.cq(flow.getStartTime());
            this.nfm.xm("1");
            d.d(d.this);
        }

        RunnableC0848d(Flow flow, JSONObject jSONObject) {
            this.nfm = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.nfm.cq(flow.getStartTime());
            this.nfm.xm("1");
            d.d(d.this);
        }

        public void hi(boolean z) {
            if (this.nfm != null) {
                this.nfm.hi(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nfc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.nfm.aVV();
            if (!TextUtils.isEmpty(d.this.nfb.xd(this.nfm.getId()))) {
                this.nfm.setCategory(d.this.nfb.xd(this.nfm.getId()));
            }
            d.this.nfc.a(this.nfm);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.dJV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class f implements Runnable {
        private String dJL;
        private int dJM;
        private String mValue;

        f(String str, int i, String str2) {
            this.dJL = str;
            this.dJM = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nfc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nfc.f(this.dJL, this.dJM, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class e implements Runnable {
        private String dJL;
        private int dJM;
        private JSONArray dJR;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dJL = str;
            this.dJM = i;
            this.dJR = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nfc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nfc.a(this.dJL, this.dJM, this.mEndTime, this.dJR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class c implements Runnable {
        private String dJL;
        private int dJM;

        c(String str, int i) {
            this.dJL = str;
            this.dJM = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nfc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nfc.H(this.dJL, this.dJM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a implements Runnable {
        private v nfi;
        private boolean nfj;
        private s nfk;

        a(v vVar, boolean z, s sVar) {
            this.nfi = vVar;
            this.nfj = z;
            this.nfk = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nfc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nfc.a(this.nfi, this.nfj, this.nfk);
        }
    }
}
