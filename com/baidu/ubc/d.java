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
    private static volatile d jZA;
    private ExecutorService baT;
    private ExecutorService bwY;
    private int bxa;
    private boolean bxb = false;
    private com.baidu.ubc.c jZB;
    private com.baidu.ubc.e jZz;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.bxa;
        dVar.bxa = i + 1;
        return i;
    }

    static {
        String ad = com.baidu.f.e.ad(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(ad)) {
            n nVar = new n("ubc_sign", com.baidu.f.e.HD(ad));
            nVar.Ym();
            cEk().a(nVar);
        }
    }

    private d() {
        init(UBC.getContext());
    }

    public static d cEk() {
        if (jZA == null) {
            synchronized (d.class) {
                if (jZA == null) {
                    jZA = new d();
                }
            }
        }
        return jZA;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bxa = com.baidu.f.b.cEp().getInt("ubc_key_flow_handle", 0);
            this.baT = Executors.newSingleThreadExecutor();
            this.baT.execute(new g(this, null));
            this.bwY = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.jZz != null && this.jZz.kU(str)) {
                bVar.dr(true);
            }
            this.baT.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.jZz != null && this.jZz.kU(str)) {
                bVar.dr(true);
            }
            this.baT.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, String str3, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.HB(str3);
            }
            if (this.jZz != null && this.jZz.kU(str)) {
                bVar.dr(true);
            }
            this.baT.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        if (this.jZz == null || this.jZz.J(str, i)) {
            if ((i & 16) == 0 || UBC.getUBCContext().fQ(str)) {
                if (this.jZz != null && this.jZz.kS(str) > 0) {
                    if (new Random().nextInt(100) >= this.jZz.kS(str)) {
                        return true;
                    }
                }
                return this.jZz != null && this.jZz.kT(str);
            }
            return true;
        }
        return true;
    }

    public void a(String str, String str2, int i, String str3, int i2) {
        this.baT.execute(new b(str, str2, i, str3, i2));
    }

    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.baT.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, String str2, int i) {
        Flow bx;
        bx = bx(str, i);
        if (bx != null && bx.getValid()) {
            RunnableC0455d runnableC0455d = new RunnableC0455d(bx, str2);
            if (this.jZz != null && this.jZz.kU(str)) {
                runnableC0455d.dr(true);
            }
            this.baT.execute(runnableC0455d);
        }
        return bx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow beginFlow(String str, JSONObject jSONObject, int i) {
        Flow bx;
        bx = bx(str, i);
        if (bx != null && bx.getValid()) {
            RunnableC0455d runnableC0455d = new RunnableC0455d(bx, jSONObject);
            if (this.jZz != null && this.jZz.kU(str)) {
                runnableC0455d.dr(true);
            }
            this.baT.execute(runnableC0455d);
        }
        return bx;
    }

    Flow bx(String str, int i) {
        Flow flow = new Flow(str, this.bxa, i);
        if (this.jZz != null && !this.jZz.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !UBC.getUBCContext().fQ(str)) {
            flow.setValid(false);
        } else {
            if (this.jZz != null && this.jZz.kS(str) > 0) {
                if (new Random().nextInt(100) >= this.jZz.kS(str)) {
                    flow.setValid(false);
                }
            }
            if (this.jZz != null && this.jZz.kT(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    public void c(String str, int i, String str2) {
        this.baT.execute(new f(str, i, str2));
    }

    public void a(String str, int i, JSONArray jSONArray) {
        this.baT.execute(new e(str, i, jSONArray));
    }

    public void t(String str, int i) {
        this.baT.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d jZC;

        @Override // java.lang.Runnable
        public void run() {
            if (this.jZC.jZB != null) {
                this.jZC.jZB.XB();
            }
        }
    }

    public void a(n nVar) {
        this.baT.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(final JSONObject jSONObject, final String str) {
        this.bwY.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jZB != null) {
                    d.this.jZB.m(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(final JSONObject jSONObject) {
        this.bwY.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jZB != null) {
                    d.this.jZB.bT(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(final String str, final boolean z) {
        this.baT.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jZB != null) {
                    if (z) {
                        d.this.jZB.kM(str);
                    } else {
                        d.this.jZB.kN(str);
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
            d.this.jZz = com.baidu.ubc.e.cEl();
            d.this.jZB = new com.baidu.ubc.c(d.this.mContext);
            d.this.jZB.XF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private j jZF;

        b(String str, String str2, int i) {
            this.jZF = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.jZF = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.jZF = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.jZF = new j(str, str2, i, str3, j, i2);
        }

        public void dr(boolean z) {
            if (this.jZF != null) {
                this.jZF.dr(z);
            }
        }

        public void HB(String str) {
            if (this.jZF != null) {
                this.jZF.rZ(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jZB != null) {
                this.jZF.XY();
                if (!TextUtils.isEmpty(d.this.jZz.kR(this.jZF.getId()))) {
                    this.jZF.setCategory(d.this.jZz.kR(this.jZF.getId()));
                }
                if ((this.jZF.getOption() & 8) != 0) {
                    d.this.jZB.b(this.jZF);
                } else {
                    d.this.jZB.a(this.jZF);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0455d implements Runnable {
        private k jZG;

        RunnableC0455d(Flow flow, String str) {
            this.jZG = new k(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.jZG.ai(flow.getStartTime());
            this.jZG.kX("1");
            d.d(d.this);
        }

        RunnableC0455d(Flow flow, JSONObject jSONObject) {
            this.jZG = new k(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.jZG.ai(flow.getStartTime());
            this.jZG.kX("1");
            d.d(d.this);
        }

        public void dr(boolean z) {
            if (this.jZG != null) {
                this.jZG.dr(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jZB != null) {
                this.jZG.XY();
                if (!TextUtils.isEmpty(d.this.jZz.kR(this.jZG.getId()))) {
                    this.jZG.setCategory(d.this.jZz.kR(this.jZG.getId()));
                }
                d.this.jZB.b(this.jZG);
                com.baidu.f.b.cEp().putInt("ubc_key_flow_handle", d.this.bxa);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private String aGw;
        private int bwQ;
        private String mValue;

        f(String str, int i, String str2) {
            this.aGw = str;
            this.bwQ = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jZB != null) {
                d.this.jZB.c(this.aGw, this.bwQ, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private String aGw;
        private long aHr = System.currentTimeMillis();
        private int bwQ;
        private JSONArray bwW;

        e(String str, int i, JSONArray jSONArray) {
            this.aGw = str;
            this.bwQ = i;
            this.bwW = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jZB != null) {
                d.this.jZB.a(this.aGw, this.bwQ, this.aHr, this.bwW);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private String aGw;
        private int bwQ;

        c(String str, int i) {
            this.aGw = str;
            this.bwQ = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jZB != null) {
                d.this.jZB.t(this.aGw, this.bwQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n jZE;

        a(n nVar) {
            this.jZE = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jZB != null) {
                d.this.jZB.a(this.jZE);
            }
        }
    }
}
