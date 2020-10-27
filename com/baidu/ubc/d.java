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
    private static volatile d ogW;
    private ExecutorService egv;
    private int egx;
    private Context mContext;
    public ExecutorService mExecutorService;
    private com.baidu.ubc.g ogX;
    private com.baidu.ubc.c ogY;
    private boolean egy = false;
    private ad ogJ = new ad();

    static /* synthetic */ int d(d dVar) {
        int i = dVar.egx;
        dVar.egx = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d dZv() {
        if (ogW == null) {
            synchronized (d.class) {
                if (ogW == null) {
                    ogW = new d();
                }
            }
        }
        return ogW;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.egx = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.mExecutorService = Executors.newSingleThreadExecutor();
            this.mExecutorService.execute(new g());
            this.egv = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ogX != null && this.ogX.yE(str)) {
                bVar.hP(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, String str3, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.VY(str3);
            }
            if (this.ogX != null && this.ogX.yE(str)) {
                bVar.hP(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ogX != null && this.ogX.yE(str)) {
                bVar.hP(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean af(String str, int i) {
        if ((i & 16) == 0 || UBC.getUBCContext().qp(str)) {
            if (this.ogX == null || this.ogX.ae(str, i)) {
                if (this.ogX == null || !this.ogX.yD(str)) {
                    if (this.ogX == null || !this.ogX.VZ(str)) {
                        return this.ogX != null && this.ogX.Wf(str);
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
        Flow bS;
        bS = bS(str, i);
        if (bS != null && bS.getValid()) {
            RunnableC0913d runnableC0913d = new RunnableC0913d(bS, str2);
            if (this.ogX != null && this.ogX.yE(str)) {
                runnableC0913d.hP(true);
            }
            this.mExecutorService.execute(runnableC0913d);
        }
        return bS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bS;
        bS = bS(str, i);
        if (bS != null && bS.getValid()) {
            RunnableC0913d runnableC0913d = new RunnableC0913d(bS, jSONObject);
            if (this.ogX != null && this.ogX.yE(str)) {
                runnableC0913d.hP(true);
            }
            this.mExecutorService.execute(runnableC0913d);
        }
        return bS;
    }

    Flow bS(String str, int i) {
        Flow flow = new Flow(str, this.egx, i);
        if (this.ogX != null && !this.ogX.ae(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().qp(str)) {
            flow.setValid(false);
        } else if (this.ogX != null && this.ogX.VZ(str)) {
            flow.setValid(false);
        } else if (this.ogX != null && this.ogX.yD(str)) {
            flow.setValid(false);
        } else if (this.ogX != null && !this.ogX.Wb(str)) {
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
        return this.ogY != null ? this.ogY.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadLocalDatas() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ogY != null) {
                    d.this.ogY.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        this.mExecutorService.execute(new a(vVar, z, sVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ey(JSONObject jSONObject) {
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
        r dZw = dZw();
        if (dZw != null && !dZw.dEm()) {
            z2 = false;
        }
        if (z2) {
            this.egv.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ogY == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.ogY.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baM() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ogY == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.ogY.baM();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ogY == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.ogY.yw(str);
                } else {
                    d.this.ogY.yx(str);
                }
            }
        });
    }

    private static final r dZw() {
        return com.baidu.tieba.q.j.dEn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.ogX = com.baidu.ubc.g.dZx();
            d.this.ogY = new com.baidu.ubc.c(d.this.mContext);
            d.this.ogY.baN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class b implements Runnable {
        private n ohh;

        b(String str, String str2, int i) {
            this.ohh = new n(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.ohh = new n(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.ohh = new n(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.ohh = new n(str, str2, i, str3, j, i2);
        }

        public void hP(boolean z) {
            if (this.ohh != null) {
                this.ohh.hP(z);
            }
        }

        public void VY(String str) {
            if (this.ohh != null) {
                this.ohh.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ogY == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.ohh.bbi();
            String id = this.ohh.getId();
            if (!TextUtils.isEmpty(id)) {
                String yB = d.this.ogX.yB(id);
                if (!TextUtils.isEmpty(yB)) {
                    this.ohh.setCategory(yB);
                }
                if ((this.ohh.getOption() & 8) != 0) {
                    d.this.ogY.b(this.ohh);
                } else if (this.ohh == null || !d.this.ogX.Wc(id)) {
                    d.this.ogY.a(this.ohh);
                } else {
                    d.this.ogY.c(this.ohh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class RunnableC0913d implements Runnable {
        private p ohi;

        RunnableC0913d(Flow flow, String str) {
            this.ohi = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.ohi.cB(flow.getStartTime());
            this.ohi.yK("1");
            d.d(d.this);
        }

        RunnableC0913d(Flow flow, JSONObject jSONObject) {
            this.ohi = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.ohi.cB(flow.getStartTime());
            this.ohi.yK("1");
            d.d(d.this);
        }

        public void hP(boolean z) {
            if (this.ohi != null) {
                this.ohi.hP(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ogY == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.ohi.bbi();
            if (!TextUtils.isEmpty(d.this.ogX.yB(this.ohi.getId()))) {
                this.ohi.setCategory(d.this.ogX.yB(this.ohi.getId()));
            }
            d.this.ogY.a(this.ohi);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.egx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class f implements Runnable {
        private String egn;
        private int ego;
        private String mValue;

        f(String str, int i, String str2) {
            this.egn = str;
            this.ego = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ogY == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.ogY.h(this.egn, this.ego, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class e implements Runnable {
        private String egn;
        private int ego;
        private JSONArray egt;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.egn = str;
            this.ego = i;
            this.egt = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ogY == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.ogY.a(this.egn, this.ego, this.mEndTime, this.egt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class c implements Runnable {
        private String egn;
        private int ego;

        c(String str, int i) {
            this.egn = str;
            this.ego = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ogY == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.ogY.I(this.egn, this.ego);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a implements Runnable {
        private v ohe;
        private boolean ohf;
        private s ohg;

        a(v vVar, boolean z, s sVar) {
            this.ohe = vVar;
            this.ohf = z;
            this.ohg = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ogY == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.ogY.a(this.ohe, this.ohf, this.ohg);
        }
    }
}
