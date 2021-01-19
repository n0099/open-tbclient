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
    private static volatile d oIk;
    private ExecutorService ewD;
    private int ewF;
    private boolean ewG = false;
    private Context mContext;
    public ScheduledExecutorService oIl;
    private com.baidu.ubc.g oIm;
    private com.baidu.ubc.c oIn;
    private v oIo;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.ewF;
        dVar.ewF = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d efb() {
        if (oIk == null) {
            synchronized (d.class) {
                if (oIk == null) {
                    oIk = new d();
                }
            }
        }
        return oIk;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ewF = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oIl = Executors.newSingleThreadScheduledExecutor();
            this.oIl.execute(new g());
            this.ewD = Executors.newSingleThreadExecutor();
            this.oIo = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        this.oIl.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oIl.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.Wc(str3);
        }
        this.oIl.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oIl.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oIl.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow cf;
        cf = cf(str, i);
        if (cf != null && cf.getValid()) {
            RunnableC0946d runnableC0946d = new RunnableC0946d(cf, str2);
            if (this.oIm != null && this.oIm.yi(str)) {
                runnableC0946d.iH(true);
            }
            this.oIl.execute(runnableC0946d);
        }
        return cf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow cf;
        cf = cf(str, i);
        if (cf != null && cf.getValid()) {
            RunnableC0946d runnableC0946d = new RunnableC0946d(cf, jSONObject);
            if (this.oIm != null && this.oIm.yi(str)) {
                runnableC0946d.iH(true);
            }
            this.oIl.execute(runnableC0946d);
        }
        return cf;
    }

    Flow cf(String str, int i) {
        Flow flow = new Flow(str, this.ewF, i);
        if (this.oIm != null && !this.oIm.aj(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().pM(str)) {
            flow.setValid(false);
        } else if (this.oIm != null && this.oIm.Wd(str)) {
            flow.setValid(false);
        } else if (this.oIm != null && this.oIm.yh(str)) {
            flow.setValid(false);
        } else if (this.oIm != null && !this.oIm.Wf(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oIl.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oIl.execute(new e(str, i, jSONArray));
    }

    public void M(String str, int i) {
        this.oIl.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oIn != null ? this.oIn.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void efc() {
        this.oIl.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oIn != null) {
                    d.this.oIn.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oIl.execute(new a(wVar, z, sVar));
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
        r efd = efd();
        if (efd != null && !efd.dHY()) {
            z2 = false;
        }
        if (z2) {
            this.ewD.execute(new Runnable() { // from class: com.baidu.ubc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oIn == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oIn.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beo() {
        this.oIl.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oIn == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oIn.beo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.oIl.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oIn == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oIn.ya(str);
                } else {
                    d.this.oIn.yb(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oIl.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private static final r efd() {
        return com.baidu.tieba.q.t.dHZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.oIm = com.baidu.ubc.g.eff();
            d.this.oIn = new com.baidu.ubc.c(d.this.mContext);
            d.this.oIn.bep();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oIx;

        b(String str, String str2, int i) {
            this.oIx = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oIx = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oIx = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oIx = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iH(boolean z) {
            if (this.oIx != null) {
                this.oIx.iH(z);
            }
        }

        public void Wc(String str) {
            if (this.oIx != null) {
                this.oIx.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIn == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oIo != null && d.this.oIm != null && d.this.oIm.Wk(this.mLogId) == 1) {
                efe();
            }
            if (this.oIx.beG() == -1) {
                if (cg(this.oIx.getId(), this.oIx.getOption())) {
                    if (d.this.oIm != null && d.this.oIm.yi(this.oIx.getId())) {
                        iH(true);
                    }
                } else {
                    return;
                }
            }
            this.oIx.beK();
            String id = this.oIx.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oIm != null) {
                    String yf = d.this.oIm.yf(id);
                    if (!TextUtils.isEmpty(yf)) {
                        this.oIx.setCategory(yf);
                    }
                }
                if (d.this.oIo != null && d.this.oIm != null && d.this.oIm.Wk(this.mLogId) == 2) {
                    efe();
                }
                if (this.oIx.beG() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oIn.d(this.oIx);
                } else if ((this.oIx.getOption() & 8) != 0) {
                    d.this.oIn.c(this.oIx);
                } else if (this.oIx == null || d.this.oIm == null || !d.this.oIm.Wg(id)) {
                    d.this.oIn.b(this.oIx);
                } else {
                    d.this.oIn.f(this.oIx);
                }
            }
        }

        private boolean cg(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().pM(str)) {
                if (d.this.oIm == null || d.this.oIm.aj(str, i)) {
                    if (d.this.oIm == null || !d.this.oIm.yh(str)) {
                        if (d.this.oIm == null || !d.this.oIm.Wd(str)) {
                            return d.this.oIm == null || !d.this.oIm.Wj(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private void efe() {
            JSONObject beI;
            if (this.oIx != null) {
                String id = this.oIx.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oIx.getContent();
                    if (TextUtils.isEmpty(content) && (beI = this.oIx.beI()) != null) {
                        try {
                            content = beI.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oIo.gU(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oIo.gT(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0946d implements Runnable {
        private p oIy;

        RunnableC0946d(Flow flow, String str) {
            this.oIy = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oIy.dw(flow.getStartTime());
            this.oIy.yo("1");
            d.e(d.this);
        }

        RunnableC0946d(Flow flow, JSONObject jSONObject) {
            this.oIy = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oIy.dw(flow.getStartTime());
            this.oIy.yo("1");
            d.e(d.this);
        }

        public void iH(boolean z) {
            if (this.oIy != null) {
                this.oIy.iH(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIn == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oIy.beK();
            if (!TextUtils.isEmpty(d.this.oIm.yf(this.oIy.getId()))) {
                this.oIy.setCategory(d.this.oIm.yf(this.oIy.getId()));
            }
            d.this.oIn.a(this.oIy);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.ewF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f implements Runnable {
        private String ewv;
        private int eww;
        private String mValue;

        f(String str, int i, String str2) {
            this.ewv = str;
            this.eww = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIn == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIn.i(this.ewv, this.eww, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        private JSONArray ewB;
        private String ewv;
        private int eww;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.ewv = str;
            this.eww = i;
            this.ewB = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIn == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIn.a(this.ewv, this.eww, this.mEndTime, this.ewB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {
        private String ewv;
        private int eww;

        c(String str, int i) {
            this.ewv = str;
            this.eww = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIn == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIn.M(this.ewv, this.eww);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        private w oIu;
        private boolean oIv;
        private s oIw;

        a(w wVar, boolean z, s sVar) {
            this.oIu = wVar;
            this.oIv = z;
            this.oIw = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIn == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIn.a(this.oIu, this.oIv, this.oIw);
        }
    }
}
