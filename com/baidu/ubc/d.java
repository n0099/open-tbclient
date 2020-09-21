package com.baidu.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d npa;
    private ExecutorService dLX;
    private int dLZ;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g npb;
    private com.baidu.ubc.c npc;
    private boolean dMa = false;
    private ad noN = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dLZ;
        dVar.dLZ = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dPS() {
        if (npa == null) {
            synchronized (d.class) {
                if (npa == null) {
                    npa = new d();
                }
            }
        }
        return npa;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dLZ = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g());
            this.dLX = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.npb != null && this.npb.xz(str)) {
                bVar.hg(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.TW(str3);
            }
            if (this.npb != null && this.npb.xz(str)) {
                bVar.hg(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.npb != null && this.npb.xz(str)) {
                bVar.hg(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ae(String str, int i) {
        if ((i & 16) == 0 || UBC.getUBCContext().pk(str)) {
            if (this.npb == null || this.npb.ad(str, i)) {
                if (this.npb == null || !this.npb.xy(str)) {
                    if (this.npb == null || !this.npb.TX(str)) {
                        return this.npb != null && this.npb.Ud(str);
                    }
                    return true;
                }
                return true;
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
            RunnableC0845d runnableC0845d = new RunnableC0845d(bO, str2);
            if (this.npb != null && this.npb.xz(str)) {
                runnableC0845d.hg(true);
            }
            this.mExecutorService.execute(runnableC0845d);
        }
        return bO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bO;
        bO = bO(str, i);
        if (bO != null && bO.getValid()) {
            RunnableC0845d runnableC0845d = new RunnableC0845d(bO, jSONObject);
            if (this.npb != null && this.npb.xz(str)) {
                runnableC0845d.hg(true);
            }
            this.mExecutorService.execute(runnableC0845d);
        }
        return bO;
    }

    Flow bO(String str, int i) {
        Flow flow = new Flow(str, this.dLZ, i);
        if (this.npb != null && !this.npb.ad(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().pk(str)) {
            flow.setValid(false);
        } else if (this.npb != null && this.npb.TX(str)) {
            flow.setValid(false);
        } else if (this.npb != null && this.npb.xy(str)) {
            flow.setValid(false);
        } else if (this.npb != null && !this.npb.TZ(str)) {
            flow.setValid(false);
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
    public String getUploadType(String str) {
        return this.npc != null ? this.npc.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadLocalDatas() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.npc != null) {
                    d.this.npc.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void en(JSONObject jSONObject) {
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
        r dPT = dPT();
        if (dPT != null && !dPT.dxt()) {
            z2 = false;
        }
        if (z2) {
            this.dLX.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.npc == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.npc.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aWl() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.npc == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.npc.aWl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.npc == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.npc.xr(str);
                } else {
                    d.this.npc.xs(str);
                }
            }
        });
    }

    private static final r dPT() {
        return com.baidu.tieba.q.j.dxu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.npb = com.baidu.ubc.g.dPU();
            d.this.npc = new com.baidu.ubc.c(d.this.mContext);
            d.this.npc.aWm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private n npl;

        b(String str, String str2, int i) {
            this.npl = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.npl = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.npl = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.npl = new n(str, str2, i, str3, j, i2);
        }

        public void hg(boolean z) {
            if (this.npl != null) {
                this.npl.hg(z);
            }
        }

        public void TW(String str) {
            if (this.npl != null) {
                this.npl.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.npc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.npl.aWH();
            String id = this.npl.getId();
            if (!TextUtils.isEmpty(id)) {
                String xw = d.this.npb.xw(id);
                if (!TextUtils.isEmpty(xw)) {
                    this.npl.setCategory(xw);
                }
                if ((this.npl.getOption() & 8) != 0) {
                    d.this.npc.b(this.npl);
                } else if (this.npl == null || !d.this.npb.Ua(id)) {
                    d.this.npc.a(this.npl);
                } else {
                    d.this.npc.c(this.npl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class RunnableC0845d implements Runnable {
        private p npm;

        RunnableC0845d(Flow flow, String str) {
            this.npm = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.npm.cr(flow.getStartTime());
            this.npm.xF("1");
            d.d(d.this);
        }

        RunnableC0845d(Flow flow, JSONObject jSONObject) {
            this.npm = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.npm.cr(flow.getStartTime());
            this.npm.xF("1");
            d.d(d.this);
        }

        public void hg(boolean z) {
            if (this.npm != null) {
                this.npm.hg(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.npc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.npm.aWH();
            if (!TextUtils.isEmpty(d.this.npb.xw(this.npm.getId()))) {
                this.npm.setCategory(d.this.npb.xw(this.npm.getId()));
            }
            d.this.npc.a(this.npm);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.dLZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class f implements Runnable {
        private String dLP;
        private int dLQ;
        private String mValue;

        f(String str, int i, String str2) {
            this.dLP = str;
            this.dLQ = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.npc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.npc.f(this.dLP, this.dLQ, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e implements Runnable {
        private String dLP;
        private int dLQ;
        private JSONArray dLV;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dLP = str;
            this.dLQ = i;
            this.dLV = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.npc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.npc.a(this.dLP, this.dLQ, this.mEndTime, this.dLV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements Runnable {
        private String dLP;
        private int dLQ;

        c(String str, int i) {
            this.dLP = str;
            this.dLQ = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.npc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.npc.H(this.dLP, this.dLQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private v npi;
        private boolean npj;
        private s npk;

        a(v vVar, boolean z, s sVar) {
            this.npi = vVar;
            this.npj = z;
            this.npk = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.npc == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.npc.a(this.npi, this.npj, this.npk);
        }
    }
}
