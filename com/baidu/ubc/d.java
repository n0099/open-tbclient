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
    private static volatile d jwl;
    private ExecutorService bpt;
    private ExecutorService bpu;
    private int bpw;
    private boolean bpx = false;
    private com.baidu.ubc.e jwk;
    private com.baidu.ubc.c jwm;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bpw;
        dVar.bpw = i + 1;
        return i;
    }

    static {
        String aq = com.baidu.f.e.aq(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(aq)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.EO(aq));
            nVar.csf();
            crU().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d crU() {
        if (jwl == null) {
            synchronized (d.class) {
                if (jwl == null) {
                    jwl = new d();
                }
            }
        }
        return jwl;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpw = com.baidu.f.b.csj().getInt("ubc_key_flow_handle", 0);
            this.bpt = Executors.newSingleThreadExecutor();
            this.bpt.execute(new g(this, null));
            this.bpu = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jwk != null && this.jwk.jM(str)) {
                bVar.cV(true);
            }
            this.bpt.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jwk != null && this.jwk.jM(str)) {
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
                bVar.EL(str3);
            }
            if (this.jwk != null && this.jwk.jM(str)) {
                bVar.cV(true);
            }
            this.bpt.execute(bVar);
        }
    }

    boolean P(String str, int i) {
        if (this.jwk == null || this.jwk.O(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fu(str)) {
                if (this.jwk != null && this.jwk.jK(str) > 0) {
                    if (new Random().nextInt(100) >= this.jwk.jK(str)) {
                        return true;
                    }
                }
                return this.jwk != null && this.jwk.jL(str);
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
            RunnableC0327d runnableC0327d = new RunnableC0327d(by, str2);
            if (this.jwk != null && this.jwk.jM(str)) {
                runnableC0327d.cV(true);
            }
            this.bpt.execute(runnableC0327d);
        }
        return by;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0327d runnableC0327d = new RunnableC0327d(by, jSONObject);
            if (this.jwk != null && this.jwk.jM(str)) {
                runnableC0327d.cV(true);
            }
            this.bpt.execute(runnableC0327d);
        }
        return by;
    }

    Flow by(String str, int i) {
        Flow flow = new Flow(str, this.bpw, i);
        if (this.jwk != null && !this.jwk.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fu(str)) {
            flow.setValid(false);
        } else {
            if (this.jwk != null && this.jwk.jK(str) > 0) {
                if (new Random().nextInt(100) >= this.jwk.jK(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jwk != null && this.jwk.jL(str)) {
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
        final /* synthetic */ d jwn;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jwn.jwm != null) {
                this.jwn.jwm.SS();
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
                if (d.this.jwm != null) {
                    d.this.jwm.n(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(final JSONObject jSONObject) {
        this.bpu.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jwm != null) {
                    d.this.jwm.bH(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpt.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jwm != null) {
                    if (z) {
                        d.this.jwm.jF(str);
                    } else {
                        d.this.jwm.jG(str);
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
            d.this.jwk = com.baidu.ubc.e.crV();
            d.this.jwm = new com.baidu.ubc.c(d.this.mContext);
            d.this.jwm.SV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jwq;

        b(String str, String str2, int i) {
            this.jwq = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jwq = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jwq = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jwq = new j(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.jwq != null) {
                this.jwq.cV(z);
            }
        }

        public void EL(String str) {
            if (this.jwq != null) {
                this.jwq.qp(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwm != null) {
                this.jwq.Th();
                if (!TextUtils.isEmpty(d.this.jwk.jJ(this.jwq.getId()))) {
                    this.jwq.setCategory(d.this.jwk.jJ(this.jwq.getId()));
                }
                if ((this.jwq.getOption() & 8) != 0) {
                    d.this.jwm.b(this.jwq);
                } else {
                    d.this.jwm.a(this.jwq);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0327d implements Runnable {
        private k jwr;

        RunnableC0327d(Flow flow, String str) {
            this.jwr = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jwr.X(flow.getStartTime());
            this.jwr.jO("1");
            d.d(d.this);
        }

        RunnableC0327d(Flow flow, JSONObject jSONObject) {
            this.jwr = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jwr.X(flow.getStartTime());
            this.jwr.jO("1");
            d.d(d.this);
        }

        public void cV(boolean z) {
            if (this.jwr != null) {
                this.jwr.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwm != null) {
                this.jwr.Th();
                if (!TextUtils.isEmpty(d.this.jwk.jJ(this.jwr.getId()))) {
                    this.jwr.setCategory(d.this.jwk.jJ(this.jwr.getId()));
                }
                d.this.jwm.b(this.jwr);
                com.baidu.f.b.csj().putInt("ubc_key_flow_handle", d.this.bpw);
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
            if (d.this.jwm != null) {
                d.this.jwm.c(this.aDt, this.bpm, this.mValue);
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
            if (d.this.jwm != null) {
                d.this.jwm.a(this.aDt, this.bpm, this.aEo, this.bpr);
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
            if (d.this.jwm != null) {
                d.this.jwm.y(this.aDt, this.bpm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jwp;

        a(n nVar) {
            this.jwp = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwm != null) {
                d.this.jwm.a(this.jwp);
            }
        }
    }
}
