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
    private static volatile d jwd;
    private ExecutorService bpu;
    private ExecutorService bpv;
    private int bpx;
    private boolean bpy = false;
    private com.baidu.ubc.e jwc;
    private com.baidu.ubc.c jwe;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bpx;
        dVar.bpx = i + 1;
        return i;
    }

    static {
        String aq = com.baidu.f.e.aq(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(aq)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.EM(aq));
            nVar.csi();
            crX().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d crX() {
        if (jwd == null) {
            synchronized (d.class) {
                if (jwd == null) {
                    jwd = new d();
                }
            }
        }
        return jwd;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpx = com.baidu.f.b.csm().getInt("ubc_key_flow_handle", 0);
            this.bpu = Executors.newSingleThreadExecutor();
            this.bpu.execute(new g(this, null));
            this.bpv = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jwc != null && this.jwc.jM(str)) {
                bVar.cV(true);
            }
            this.bpu.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jwc != null && this.jwc.jM(str)) {
                bVar.cV(true);
            }
            this.bpu.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, String str3, int i) {
        if (!P(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.EJ(str3);
            }
            if (this.jwc != null && this.jwc.jM(str)) {
                bVar.cV(true);
            }
            this.bpu.execute(bVar);
        }
    }

    boolean P(String str, int i) {
        if (this.jwc == null || this.jwc.O(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fu(str)) {
                if (this.jwc != null && this.jwc.jK(str) > 0) {
                    if (new Random().nextInt(100) >= this.jwc.jK(str)) {
                        return true;
                    }
                }
                return this.jwc != null && this.jwc.jL(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpu.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpu.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0420d runnableC0420d = new RunnableC0420d(by, str2);
            if (this.jwc != null && this.jwc.jM(str)) {
                runnableC0420d.cV(true);
            }
            this.bpu.execute(runnableC0420d);
        }
        return by;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow by;
        by = by(str, i);
        if (by != null && by.getValid()) {
            RunnableC0420d runnableC0420d = new RunnableC0420d(by, jSONObject);
            if (this.jwc != null && this.jwc.jM(str)) {
                runnableC0420d.cV(true);
            }
            this.bpu.execute(runnableC0420d);
        }
        return by;
    }

    Flow by(String str, int i) {
        Flow flow = new Flow(str, this.bpx, i);
        if (this.jwc != null && !this.jwc.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fu(str)) {
            flow.setValid(false);
        } else {
            if (this.jwc != null && this.jwc.jK(str) > 0) {
                if (new Random().nextInt(100) >= this.jwc.jK(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jwc != null && this.jwc.jL(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void c(String str, int i, String str2) {
        this.bpu.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.bpu.execute(new e(str, i, jSONArray));
    }

    public void y(String str, int i) {
        this.bpu.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jwf;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jwf.jwe != null) {
                this.jwf.jwe.SS();
            }
        }
    }

    public void a(n nVar) {
        this.bpu.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(final JSONObject jSONObject, final String str) {
        this.bpv.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jwe != null) {
                    d.this.jwe.n(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(final JSONObject jSONObject) {
        this.bpv.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jwe != null) {
                    d.this.jwe.bH(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpu.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jwe != null) {
                    if (z) {
                        d.this.jwe.jF(str);
                    } else {
                        d.this.jwe.jG(str);
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
            d.this.jwc = com.baidu.ubc.e.crY();
            d.this.jwe = new com.baidu.ubc.c(d.this.mContext);
            d.this.jwe.SV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jwi;

        b(String str, String str2, int i) {
            this.jwi = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jwi = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jwi = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jwi = new j(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.jwi != null) {
                this.jwi.cV(z);
            }
        }

        public void EJ(String str) {
            if (this.jwi != null) {
                this.jwi.qn(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwe != null) {
                this.jwi.Th();
                if (!TextUtils.isEmpty(d.this.jwc.jJ(this.jwi.getId()))) {
                    this.jwi.setCategory(d.this.jwc.jJ(this.jwi.getId()));
                }
                if ((this.jwi.getOption() & 8) != 0) {
                    d.this.jwe.b(this.jwi);
                } else {
                    d.this.jwe.a(this.jwi);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0420d implements Runnable {
        private k jwj;

        RunnableC0420d(Flow flow, String str) {
            this.jwj = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jwj.X(flow.getStartTime());
            this.jwj.jO("1");
            d.d(d.this);
        }

        RunnableC0420d(Flow flow, JSONObject jSONObject) {
            this.jwj = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jwj.X(flow.getStartTime());
            this.jwj.jO("1");
            d.d(d.this);
        }

        public void cV(boolean z) {
            if (this.jwj != null) {
                this.jwj.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwe != null) {
                this.jwj.Th();
                if (!TextUtils.isEmpty(d.this.jwc.jJ(this.jwj.getId()))) {
                    this.jwj.setCategory(d.this.jwc.jJ(this.jwj.getId()));
                }
                d.this.jwe.b(this.jwj);
                com.baidu.f.b.csm().putInt("ubc_key_flow_handle", d.this.bpx);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aDu;
        private int bpn;
        private String mValue;

        f(String str, int i, String str2) {
            this.aDu = str;
            this.bpn = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwe != null) {
                d.this.jwe.c(this.aDu, this.bpn, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aDu;
        private long aEp = System.currentTimeMillis();
        private int bpn;
        private JSONArray bps;

        e(String str, int i, JSONArray jSONArray) {
            this.aDu = str;
            this.bpn = i;
            this.bps = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwe != null) {
                d.this.jwe.a(this.aDu, this.bpn, this.aEp, this.bps);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aDu;
        private int bpn;

        c(String str, int i) {
            this.aDu = str;
            this.bpn = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwe != null) {
                d.this.jwe.y(this.aDu, this.bpn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jwh;

        a(n nVar) {
            this.jwh = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jwe != null) {
                d.this.jwe.a(this.jwh);
            }
        }
    }
}
