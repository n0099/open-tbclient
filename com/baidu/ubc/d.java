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
    private static volatile d jvT;
    private int bpA;
    private boolean bpB = false;
    private ExecutorService bpx;
    private ExecutorService bpy;
    private com.baidu.ubc.e jvS;
    private com.baidu.ubc.c jvU;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bpA;
        dVar.bpA = i + 1;
        return i;
    }

    static {
        String aq = com.baidu.f.e.aq(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(aq)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.EL(aq));
            nVar.csg();
            crV().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d crV() {
        if (jvT == null) {
            synchronized (d.class) {
                if (jvT == null) {
                    jvT = new d();
                }
            }
        }
        return jvT;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpA = com.baidu.f.b.csk().getInt("ubc_key_flow_handle", 0);
            this.bpx = Executors.newSingleThreadExecutor();
            this.bpx.execute(new g(this, null));
            this.bpy = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jvS != null && this.jvS.jN(str)) {
                bVar.cV(true);
            }
            this.bpx.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jvS != null && this.jvS.jN(str)) {
                bVar.cV(true);
            }
            this.bpx.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, String str3, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.EI(str3);
            }
            if (this.jvS != null && this.jvS.jN(str)) {
                bVar.cV(true);
            }
            this.bpx.execute(bVar);
        }
    }

    boolean P(String str, int i) {
        if (this.jvS == null || this.jvS.O(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fv(str)) {
                if (this.jvS != null && this.jvS.jL(str) > 0) {
                    if (new Random().nextInt(100) >= this.jvS.jL(str)) {
                        return true;
                    }
                }
                return this.jvS != null && this.jvS.jM(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpx.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpx.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0420d runnableC0420d = new RunnableC0420d(by, str2);
            if (this.jvS != null && this.jvS.jN(str)) {
                runnableC0420d.cV(true);
            }
            this.bpx.execute(runnableC0420d);
        }
        return by;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0420d runnableC0420d = new RunnableC0420d(by, jSONObject);
            if (this.jvS != null && this.jvS.jN(str)) {
                runnableC0420d.cV(true);
            }
            this.bpx.execute(runnableC0420d);
        }
        return by;
    }

    Flow by(String str, int i) {
        Flow flow = new Flow(str, this.bpA, i);
        if (this.jvS != null && !this.jvS.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fv(str)) {
            flow.setValid(false);
        } else {
            if (this.jvS != null && this.jvS.jL(str) > 0) {
                if (new Random().nextInt(100) >= this.jvS.jL(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jvS != null && this.jvS.jM(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void c(String str, int i, String str2) {
        this.bpx.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.bpx.execute(new e(str, i, jSONArray));
    }

    public void y(String str, int i) {
        this.bpx.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jvV;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jvV.jvU != null) {
                this.jvV.jvU.SQ();
            }
        }
    }

    public void a(n nVar) {
        this.bpx.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final JSONObject jSONObject, final String str) {
        this.bpy.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvU != null) {
                    d.this.jvU.n(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(final JSONObject jSONObject) {
        this.bpy.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvU != null) {
                    d.this.jvU.bH(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpx.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvU != null) {
                    if (z) {
                        d.this.jvU.jG(str);
                    } else {
                        d.this.jvU.jH(str);
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
            d.this.jvS = com.baidu.ubc.e.crW();
            d.this.jvU = new com.baidu.ubc.c(d.this.mContext);
            d.this.jvU.ST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jvY;

        b(String str, String str2, int i) {
            this.jvY = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jvY = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jvY = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jvY = new j(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.jvY != null) {
                this.jvY.cV(z);
            }
        }

        public void EI(String str) {
            if (this.jvY != null) {
                this.jvY.qo(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvU != null) {
                this.jvY.Tf();
                if (!TextUtils.isEmpty(d.this.jvS.jK(this.jvY.getId()))) {
                    this.jvY.setCategory(d.this.jvS.jK(this.jvY.getId()));
                }
                if ((this.jvY.getOption() & 8) != 0) {
                    d.this.jvU.b(this.jvY);
                } else {
                    d.this.jvU.a(this.jvY);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0420d implements Runnable {
        private k jvZ;

        RunnableC0420d(Flow flow, String str) {
            this.jvZ = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jvZ.X(flow.getStartTime());
            this.jvZ.jP("1");
            d.d(d.this);
        }

        RunnableC0420d(Flow flow, JSONObject jSONObject) {
            this.jvZ = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jvZ.X(flow.getStartTime());
            this.jvZ.jP("1");
            d.d(d.this);
        }

        public void cV(boolean z) {
            if (this.jvZ != null) {
                this.jvZ.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvU != null) {
                this.jvZ.Tf();
                if (!TextUtils.isEmpty(d.this.jvS.jK(this.jvZ.getId()))) {
                    this.jvZ.setCategory(d.this.jvS.jK(this.jvZ.getId()));
                }
                d.this.jvU.b(this.jvZ);
                com.baidu.f.b.csk().putInt("ubc_key_flow_handle", d.this.bpA);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aDx;
        private int bpq;
        private String mValue;

        f(String str, int i, String str2) {
            this.aDx = str;
            this.bpq = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvU != null) {
                d.this.jvU.c(this.aDx, this.bpq, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aDx;
        private long aEs = System.currentTimeMillis();
        private int bpq;
        private JSONArray bpv;

        e(String str, int i, JSONArray jSONArray) {
            this.aDx = str;
            this.bpq = i;
            this.bpv = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvU != null) {
                d.this.jvU.a(this.aDx, this.bpq, this.aEs, this.bpv);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aDx;
        private int bpq;

        c(String str, int i) {
            this.aDx = str;
            this.bpq = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvU != null) {
                d.this.jvU.y(this.aDx, this.bpq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jvX;

        a(n nVar) {
            this.jvX = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvU != null) {
                d.this.jvU.a(this.jvX);
            }
        }
    }
}
