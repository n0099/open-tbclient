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
/* loaded from: classes20.dex */
public class d {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile d nEu;
    private ExecutorService dXY;
    private int dYa;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g nEv;
    private com.baidu.ubc.c nEw;
    private boolean dYb = false;
    private ad nEh = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.dYa;
        dVar.dYa = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dTD() {
        if (nEu == null) {
            synchronized (d.class) {
                if (nEu == null) {
                    nEu = new d();
                }
            }
        }
        return nEu;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dYa = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g());
            this.dXY = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.nEv != null && this.nEv.yl(str)) {
                bVar.hC(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, String str3, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.UK(str3);
            }
            if (this.nEv != null && this.nEv.yl(str)) {
                bVar.hC(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.nEv != null && this.nEv.yl(str)) {
                bVar.hC(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean af(String str, int i) {
        if ((i & 16) == 0 || UBC.getUBCContext().pW(str)) {
            if (this.nEv == null || this.nEv.ae(str, i)) {
                if (this.nEv == null || !this.nEv.yk(str)) {
                    if (this.nEv == null || !this.nEv.UL(str)) {
                        return this.nEv != null && this.nEv.UR(str);
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
        Flow bP;
        bP = bP(str, i);
        if (bP != null && bP.getValid()) {
            RunnableC0863d runnableC0863d = new RunnableC0863d(bP, str2);
            if (this.nEv != null && this.nEv.yl(str)) {
                runnableC0863d.hC(true);
            }
            this.mExecutorService.execute(runnableC0863d);
        }
        return bP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bP;
        bP = bP(str, i);
        if (bP != null && bP.getValid()) {
            RunnableC0863d runnableC0863d = new RunnableC0863d(bP, jSONObject);
            if (this.nEv != null && this.nEv.yl(str)) {
                runnableC0863d.hC(true);
            }
            this.mExecutorService.execute(runnableC0863d);
        }
        return bP;
    }

    Flow bP(String str, int i) {
        Flow flow = new Flow(str, this.dYa, i);
        if (this.nEv != null && !this.nEv.ae(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().pW(str)) {
            flow.setValid(false);
        } else if (this.nEv != null && this.nEv.UL(str)) {
            flow.setValid(false);
        } else if (this.nEv != null && this.nEv.yk(str)) {
            flow.setValid(false);
        } else if (this.nEv != null && !this.nEv.UN(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void h(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    public void I(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.nEw != null ? this.nEw.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadLocalDatas() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.nEw != null) {
                    d.this.nEw.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void er(JSONObject jSONObject) {
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
        r dTE = dTE();
        if (dTE != null && !dTE.dBe()) {
            z2 = false;
        }
        if (z2) {
            this.dXY.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.nEw == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.nEw.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYT() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.nEw == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.nEw.aYT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void as(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.nEw == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.nEw.yd(str);
                } else {
                    d.this.nEw.ye(str);
                }
            }
        });
    }

    private static final r dTE() {
        return com.baidu.tieba.q.j.dBf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.nEv = com.baidu.ubc.g.dTF();
            d.this.nEw = new com.baidu.ubc.c(d.this.mContext);
            d.this.nEw.aYU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class b implements Runnable {
        private n nEF;

        b(String str, String str2, int i) {
            this.nEF = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.nEF = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.nEF = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.nEF = new n(str, str2, i, str3, j, i2);
        }

        public void hC(boolean z) {
            if (this.nEF != null) {
                this.nEF.hC(z);
            }
        }

        public void UK(String str) {
            if (this.nEF != null) {
                this.nEF.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nEw == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.nEF.aZp();
            String id = this.nEF.getId();
            if (!TextUtils.isEmpty(id)) {
                String yi = d.this.nEv.yi(id);
                if (!TextUtils.isEmpty(yi)) {
                    this.nEF.setCategory(yi);
                }
                if ((this.nEF.getOption() & 8) != 0) {
                    d.this.nEw.b(this.nEF);
                } else if (this.nEF == null || !d.this.nEv.UO(id)) {
                    d.this.nEw.a(this.nEF);
                } else {
                    d.this.nEw.c(this.nEF);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class RunnableC0863d implements Runnable {
        private p nEG;

        RunnableC0863d(Flow flow, String str) {
            this.nEG = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.nEG.cz(flow.getStartTime());
            this.nEG.yr("1");
            d.d(d.this);
        }

        RunnableC0863d(Flow flow, JSONObject jSONObject) {
            this.nEG = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.nEG.cz(flow.getStartTime());
            this.nEG.yr("1");
            d.d(d.this);
        }

        public void hC(boolean z) {
            if (this.nEG != null) {
                this.nEG.hC(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nEw == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.nEG.aZp();
            if (!TextUtils.isEmpty(d.this.nEv.yi(this.nEG.getId()))) {
                this.nEG.setCategory(d.this.nEv.yi(this.nEG.getId()));
            }
            d.this.nEw.a(this.nEG);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.dYa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class f implements Runnable {
        private String dXQ;
        private int dXR;
        private String mValue;

        f(String str, int i, String str2) {
            this.dXQ = str;
            this.dXR = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nEw == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nEw.h(this.dXQ, this.dXR, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class e implements Runnable {
        private String dXQ;
        private int dXR;
        private JSONArray dXW;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dXQ = str;
            this.dXR = i;
            this.dXW = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nEw == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nEw.a(this.dXQ, this.dXR, this.mEndTime, this.dXW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class c implements Runnable {
        private String dXQ;
        private int dXR;

        c(String str, int i) {
            this.dXQ = str;
            this.dXR = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nEw == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nEw.I(this.dXQ, this.dXR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a implements Runnable {
        private v nEC;
        private boolean nED;
        private s nEE;

        a(v vVar, boolean z, s sVar) {
            this.nEC = vVar;
            this.nED = z;
            this.nEE = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nEw == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.nEw.a(this.nEC, this.nED, this.nEE);
        }
    }
}
