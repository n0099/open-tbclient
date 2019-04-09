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
    private static volatile d jvU;
    private int bpB;
    private boolean bpC = false;
    private ExecutorService bpy;
    private ExecutorService bpz;
    private com.baidu.ubc.e jvT;
    private com.baidu.ubc.c jvV;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bpB;
        dVar.bpB = i + 1;
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
        if (jvU == null) {
            synchronized (d.class) {
                if (jvU == null) {
                    jvU = new d();
                }
            }
        }
        return jvU;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpB = com.baidu.f.b.csk().getInt("ubc_key_flow_handle", 0);
            this.bpy = Executors.newSingleThreadExecutor();
            this.bpy.execute(new g(this, null));
            this.bpz = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jvT != null && this.jvT.jN(str)) {
                bVar.cV(true);
            }
            this.bpy.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jvT != null && this.jvT.jN(str)) {
                bVar.cV(true);
            }
            this.bpy.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, String str3, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.EI(str3);
            }
            if (this.jvT != null && this.jvT.jN(str)) {
                bVar.cV(true);
            }
            this.bpy.execute(bVar);
        }
    }

    boolean P(String str, int i) {
        if (this.jvT == null || this.jvT.O(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fv(str)) {
                if (this.jvT != null && this.jvT.jL(str) > 0) {
                    if (new Random().nextInt(100) >= this.jvT.jL(str)) {
                        return true;
                    }
                }
                return this.jvT != null && this.jvT.jM(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpy.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpy.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0420d runnableC0420d = new RunnableC0420d(by, str2);
            if (this.jvT != null && this.jvT.jN(str)) {
                runnableC0420d.cV(true);
            }
            this.bpy.execute(runnableC0420d);
        }
        return by;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0420d runnableC0420d = new RunnableC0420d(by, jSONObject);
            if (this.jvT != null && this.jvT.jN(str)) {
                runnableC0420d.cV(true);
            }
            this.bpy.execute(runnableC0420d);
        }
        return by;
    }

    Flow by(String str, int i) {
        Flow flow = new Flow(str, this.bpB, i);
        if (this.jvT != null && !this.jvT.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fv(str)) {
            flow.setValid(false);
        } else {
            if (this.jvT != null && this.jvT.jL(str) > 0) {
                if (new Random().nextInt(100) >= this.jvT.jL(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jvT != null && this.jvT.jM(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void c(String str, int i, String str2) {
        this.bpy.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.bpy.execute(new e(str, i, jSONArray));
    }

    public void y(String str, int i) {
        this.bpy.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jvW;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jvW.jvV != null) {
                this.jvW.jvV.SQ();
            }
        }
    }

    public void a(n nVar) {
        this.bpy.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final JSONObject jSONObject, final String str) {
        this.bpz.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvV != null) {
                    d.this.jvV.n(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(final JSONObject jSONObject) {
        this.bpz.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvV != null) {
                    d.this.jvV.bH(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpy.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jvV != null) {
                    if (z) {
                        d.this.jvV.jG(str);
                    } else {
                        d.this.jvV.jH(str);
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
            d.this.jvT = com.baidu.ubc.e.crW();
            d.this.jvV = new com.baidu.ubc.c(d.this.mContext);
            d.this.jvV.ST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jvZ;

        b(String str, String str2, int i) {
            this.jvZ = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jvZ = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jvZ = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jvZ = new j(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.jvZ != null) {
                this.jvZ.cV(z);
            }
        }

        public void EI(String str) {
            if (this.jvZ != null) {
                this.jvZ.qo(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvV != null) {
                this.jvZ.Tf();
                if (!TextUtils.isEmpty(d.this.jvT.jK(this.jvZ.getId()))) {
                    this.jvZ.setCategory(d.this.jvT.jK(this.jvZ.getId()));
                }
                if ((this.jvZ.getOption() & 8) != 0) {
                    d.this.jvV.b(this.jvZ);
                } else {
                    d.this.jvV.a(this.jvZ);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0420d implements Runnable {
        private k jwa;

        RunnableC0420d(Flow flow, String str) {
            this.jwa = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jwa.X(flow.getStartTime());
            this.jwa.jP("1");
            d.d(d.this);
        }

        RunnableC0420d(Flow flow, JSONObject jSONObject) {
            this.jwa = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jwa.X(flow.getStartTime());
            this.jwa.jP("1");
            d.d(d.this);
        }

        public void cV(boolean z) {
            if (this.jwa != null) {
                this.jwa.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvV != null) {
                this.jwa.Tf();
                if (!TextUtils.isEmpty(d.this.jvT.jK(this.jwa.getId()))) {
                    this.jwa.setCategory(d.this.jvT.jK(this.jwa.getId()));
                }
                d.this.jvV.b(this.jwa);
                com.baidu.f.b.csk().putInt("ubc_key_flow_handle", d.this.bpB);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aDy;
        private int bpr;
        private String mValue;

        f(String str, int i, String str2) {
            this.aDy = str;
            this.bpr = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvV != null) {
                d.this.jvV.c(this.aDy, this.bpr, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aDy;
        private long aEt = System.currentTimeMillis();
        private int bpr;
        private JSONArray bpw;

        e(String str, int i, JSONArray jSONArray) {
            this.aDy = str;
            this.bpr = i;
            this.bpw = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvV != null) {
                d.this.jvV.a(this.aDy, this.bpr, this.aEt, this.bpw);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aDy;
        private int bpr;

        c(String str, int i) {
            this.aDy = str;
            this.bpr = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvV != null) {
                d.this.jvV.y(this.aDy, this.bpr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jvY;

        a(n nVar) {
            this.jvY = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jvV != null) {
                d.this.jvV.a(this.jvY);
            }
        }
    }
}
