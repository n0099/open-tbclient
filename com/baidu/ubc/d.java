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
    private static volatile d oIj;
    private ExecutorService ewD;
    private int ewF;
    private boolean ewG = false;
    private Context mContext;
    public ScheduledExecutorService oIk;
    private com.baidu.ubc.g oIl;
    private com.baidu.ubc.c oIm;
    private v oIn;

    static /* synthetic */ int e(d dVar) {
        int i = dVar.ewF;
        dVar.ewF = i + 1;
        return i;
    }

    private d() {
        init(UBC.getContext());
    }

    public static d efb() {
        if (oIj == null) {
            synchronized (d.class) {
                if (oIj == null) {
                    oIj = new d();
                }
            }
        }
        return oIj;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ewF = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.oIk = Executors.newSingleThreadScheduledExecutor();
            this.oIk.execute(new g());
            this.ewD = Executors.newSingleThreadExecutor();
            this.oIn = (v) com.baidu.pyramid.runtime.service.c.a(v.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        this.oIk.execute(new b(str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        this.oIk.execute(new b(str, jSONObject, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, String str3, int i) {
        b bVar = new b(str, str2, i);
        if (!TextUtils.isEmpty(str3)) {
            bVar.Wb(str3);
        }
        this.oIk.execute(bVar);
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.oIk.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.oIk.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow ce;
        ce = ce(str, i);
        if (ce != null && ce.getValid()) {
            RunnableC0946d runnableC0946d = new RunnableC0946d(ce, str2);
            if (this.oIl != null && this.oIl.yi(str)) {
                runnableC0946d.iH(true);
            }
            this.oIk.execute(runnableC0946d);
        }
        return ce;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow ce;
        ce = ce(str, i);
        if (ce != null && ce.getValid()) {
            RunnableC0946d runnableC0946d = new RunnableC0946d(ce, jSONObject);
            if (this.oIl != null && this.oIl.yi(str)) {
                runnableC0946d.iH(true);
            }
            this.oIk.execute(runnableC0946d);
        }
        return ce;
    }

    Flow ce(String str, int i) {
        Flow flow = new Flow(str, this.ewF, i);
        if (this.oIl != null && !this.oIl.aj(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().pM(str)) {
            flow.setValid(false);
        } else if (this.oIl != null && this.oIl.Wc(str)) {
            flow.setValid(false);
        } else if (this.oIl != null && this.oIl.yh(str)) {
            flow.setValid(false);
        } else if (this.oIl != null && !this.oIl.We(str)) {
            flow.setValid(false);
        }
        return flow;
    }

    public void i(String str, int i, String str2) {
        this.oIk.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.oIk.execute(new e(str, i, jSONArray));
    }

    public void M(String str, int i) {
        this.oIk.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oIm != null ? this.oIm.getUploadType(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void efc() {
        this.oIk.execute(new Runnable() { // from class: com.baidu.ubc.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oIm != null) {
                    d.this.oIm.uploadLocalDatas();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        this.oIk.execute(new a(wVar, z, sVar));
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
                    if (d.this.oIm == null) {
                        if (d.DEBUG) {
                            Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                            return;
                        }
                        return;
                    }
                    d.this.oIm.a(jSONObject, str, z, nVar, tVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beo() {
        this.oIk.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oIm == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                d.this.oIm.beo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.oIk.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.oIm == null) {
                    if (d.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    d.this.oIm.ya(str);
                } else {
                    d.this.oIm.yb(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j) {
        this.oIk.schedule(runnable, j, TimeUnit.MILLISECONDS);
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
            d.this.oIl = com.baidu.ubc.g.eff();
            d.this.oIm = new com.baidu.ubc.c(d.this.mContext);
            d.this.oIm.bep();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        private String mLogId;
        private n oIw;

        b(String str, String str2, int i) {
            this.oIw = new n(str, str2, i);
            this.mLogId = str;
        }

        b(String str, JSONObject jSONObject, int i) {
            this.oIw = new n(str, jSONObject, i);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.oIw = new n(str, str2, i, str3, i2);
            this.mLogId = str;
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.oIw = new n(str, str2, i, str3, j, i2);
            this.mLogId = str;
        }

        public void iH(boolean z) {
            if (this.oIw != null) {
                this.oIw.iH(z);
            }
        }

        public void Wb(String str) {
            if (this.oIw != null) {
                this.oIw.setFileName(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIm == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.oIn != null && d.this.oIl != null && d.this.oIl.Wj(this.mLogId) == 1) {
                efe();
            }
            if (this.oIw.beG() == -1) {
                if (cf(this.oIw.getId(), this.oIw.getOption())) {
                    if (d.this.oIl != null && d.this.oIl.yi(this.oIw.getId())) {
                        iH(true);
                    }
                } else {
                    return;
                }
            }
            this.oIw.beK();
            String id = this.oIw.getId();
            if (!TextUtils.isEmpty(id)) {
                if (d.this.oIl != null) {
                    String yf = d.this.oIl.yf(id);
                    if (!TextUtils.isEmpty(yf)) {
                        this.oIw.setCategory(yf);
                    }
                }
                if (d.this.oIn != null && d.this.oIl != null && d.this.oIl.Wj(this.mLogId) == 2) {
                    efe();
                }
                if (this.oIw.beG() == -1 && TextUtils.equals(id, "1876")) {
                    d.this.oIm.d(this.oIw);
                } else if ((this.oIw.getOption() & 8) != 0) {
                    d.this.oIm.c(this.oIw);
                } else if (this.oIw == null || d.this.oIl == null || !d.this.oIl.Wf(id)) {
                    d.this.oIm.b(this.oIw);
                } else {
                    d.this.oIm.f(this.oIw);
                }
            }
        }

        private boolean cf(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().pM(str)) {
                if (d.this.oIl == null || d.this.oIl.aj(str, i)) {
                    if (d.this.oIl == null || !d.this.oIl.yh(str)) {
                        if (d.this.oIl == null || !d.this.oIl.Wc(str)) {
                            return d.this.oIl == null || !d.this.oIl.Wi(str);
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
            if (this.oIw != null) {
                String id = this.oIw.getId();
                if (!TextUtils.isEmpty(id)) {
                    String content = this.oIw.getContent();
                    if (TextUtils.isEmpty(content) && (beI = this.oIw.beI()) != null) {
                        try {
                            content = beI.toString();
                        } catch (ConcurrentModificationException e) {
                            d.this.oIn.gU(id, e.toString());
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(content)) {
                        d.this.oIn.gT(id, content);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0946d implements Runnable {
        private p oIx;

        RunnableC0946d(Flow flow, String str) {
            this.oIx = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.oIx.dw(flow.getStartTime());
            this.oIx.yo("1");
            d.e(d.this);
        }

        RunnableC0946d(Flow flow, JSONObject jSONObject) {
            this.oIx = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.oIx.dw(flow.getStartTime());
            this.oIx.yo("1");
            d.e(d.this);
        }

        public void iH(boolean z) {
            if (this.oIx != null) {
                this.oIx.iH(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIm == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.oIx.beK();
            if (!TextUtils.isEmpty(d.this.oIl.yf(this.oIx.getId()))) {
                this.oIx.setCategory(d.this.oIl.yf(this.oIx.getId()));
            }
            d.this.oIm.a(this.oIx);
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
            if (d.this.oIm == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIm.i(this.ewv, this.eww, this.mValue);
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
            if (d.this.oIm == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIm.a(this.ewv, this.eww, this.mEndTime, this.ewB);
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
            if (d.this.oIm == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIm.M(this.ewv, this.eww);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        private w oIt;
        private boolean oIu;
        private s oIv;

        a(w wVar, boolean z, s sVar) {
            this.oIt = wVar;
            this.oIu = z;
            this.oIv = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.oIm == null) {
                if (d.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.oIm.a(this.oIt, this.oIu, this.oIv);
        }
    }
}
