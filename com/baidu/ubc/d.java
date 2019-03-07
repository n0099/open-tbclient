package com.baidu.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static volatile d jvS;
    private ExecutorService bpt;
    private ExecutorService bpu;
    private int bpw;
    private boolean bpx = false;
    private com.baidu.ubc.e jvR;
    private com.baidu.ubc.c jvT;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bpw;
        dVar.bpw = i + 1;
        return i;
    }

    static {
        String aq = com.baidu.f.e.aq(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(aq)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.EL(aq));
            nVar.crV();
            crK().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d crK() {
        if (jvS == null) {
            synchronized (d.class) {
                if (jvS == null) {
                    jvS = new d();
                }
            }
        }
        return jvS;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpw = com.baidu.f.b.crZ().getInt("ubc_key_flow_handle", 0);
            this.bpt = Executors.newSingleThreadExecutor();
            this.bpt.execute(new g(this, null));
            this.bpu = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jvR != null && this.jvR.jM(str)) {
                bVar.cV(true);
            }
            this.bpt.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jvR != null && this.jvR.jM(str)) {
                bVar.cV(true);
            }
            this.bpt.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, String str3, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.EI(str3);
            }
            if (this.jvR != null && this.jvR.jM(str)) {
                bVar.cV(true);
            }
            this.bpt.execute(bVar);
        }
    }

    boolean P(String str, int i) {
        if (this.jvR == null || this.jvR.O(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fu(str)) {
                if (this.jvR != null && this.jvR.jK(str) > 0) {
                    if (new Random().nextInt(100) >= this.jvR.jK(str)) {
                        return true;
                    }
                }
                return this.jvR != null && this.jvR.jL(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpt.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpt.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0324d runnableC0324d = new RunnableC0324d(by, str2);
            if (this.jvR != null && this.jvR.jM(str)) {
                runnableC0324d.cV(true);
            }
            this.bpt.execute(runnableC0324d);
        }
        return by;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0324d runnableC0324d = new RunnableC0324d(by, jSONObject);
            if (this.jvR != null && this.jvR.jM(str)) {
                runnableC0324d.cV(true);
            }
            this.bpt.execute(runnableC0324d);
        }
        return by;
    }

    Flow by(String str, int i) {
        Flow flow = new Flow(str, this.bpw, i);
        if (this.jvR != null && !this.jvR.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fu(str)) {
            flow.setValid(false);
        } else {
            if (this.jvR != null && this.jvR.jK(str) > 0) {
                if (new Random().nextInt(100) >= this.jvR.jK(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jvR != null && this.jvR.jL(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void c(String str, int i, String str2) {
        this.bpt.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.bpt.execute(new e(str, i, jSONArray));
    }

    public void y(String str, int i) {
        this.bpt.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jvU;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jvU.jvT != null) {
                this.jvU.jvT.SS();
            }
        }
    }

    public void a(n nVar) {
        this.bpt.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final JSONObject jSONObject, final String str) {
        this.bpu.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvT != null) {
                    d.this.jvT.n(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(final JSONObject jSONObject) {
        this.bpu.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvT != null) {
                    d.this.jvT.bH(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpt.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvT != null) {
                    if (z) {
                        d.this.jvT.jF(str);
                    } else {
                        d.this.jvT.jG(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.jvR = com.baidu.ubc.e.crL();
            d.this.jvT = new com.baidu.ubc.c(d.this.mContext);
            d.this.jvT.SV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jvX;

        b(String str, String str2, int i) {
            this.jvX = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jvX = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jvX = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jvX = new j(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.jvX != null) {
                this.jvX.cV(z);
            }
        }

        public void EI(String str) {
            if (this.jvX != null) {
                this.jvX.qo(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvT != null) {
                this.jvX.Th();
                if (!TextUtils.isEmpty(d.this.jvR.jJ(this.jvX.getId()))) {
                    this.jvX.setCategory(d.this.jvR.jJ(this.jvX.getId()));
                }
                if ((this.jvX.getOption() & 8) != 0) {
                    d.this.jvT.b(this.jvX);
                } else {
                    d.this.jvT.a(this.jvX);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0324d implements Runnable {
        private k jvY;

        RunnableC0324d(Flow flow, String str) {
            this.jvY = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jvY.X(flow.getStartTime());
            this.jvY.jO("1");
            d.d(d.this);
        }

        RunnableC0324d(Flow flow, JSONObject jSONObject) {
            this.jvY = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jvY.X(flow.getStartTime());
            this.jvY.jO("1");
            d.d(d.this);
        }

        public void cV(boolean z) {
            if (this.jvY != null) {
                this.jvY.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvT != null) {
                this.jvY.Th();
                if (!TextUtils.isEmpty(d.this.jvR.jJ(this.jvY.getId()))) {
                    this.jvY.setCategory(d.this.jvR.jJ(this.jvY.getId()));
                }
                d.this.jvT.b(this.jvY);
                com.baidu.f.b.crZ().putInt("ubc_key_flow_handle", d.this.bpw);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aDt;
        private int bpm;
        private String mValue;

        f(String str, int i, String str2) {
            this.aDt = str;
            this.bpm = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvT != null) {
                d.this.jvT.c(this.aDt, this.bpm, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aDt;
        private long aEo = System.currentTimeMillis();
        private int bpm;
        private JSONArray bpr;

        e(String str, int i, JSONArray jSONArray) {
            this.aDt = str;
            this.bpm = i;
            this.bpr = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvT != null) {
                d.this.jvT.a(this.aDt, this.bpm, this.aEo, this.bpr);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aDt;
        private int bpm;

        c(String str, int i) {
            this.aDt = str;
            this.bpm = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvT != null) {
                d.this.jvT.y(this.aDt, this.bpm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jvW;

        a(n nVar) {
            this.jvW = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvT != null) {
                d.this.jvT.a(this.jvW);
            }
        }
    }
}
