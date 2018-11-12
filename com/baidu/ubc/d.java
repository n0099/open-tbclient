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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    private static volatile d hTX;
    private com.baidu.ubc.e hTW;
    private ExecutorService hTY;
    private ExecutorService hTZ;
    private com.baidu.ubc.c hUa;
    private int hUb;
    private boolean hUc = false;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.hUb;
        dVar.hUb = i + 1;
        return i;
    }

    static {
        String readAssetData = com.baidu.g.e.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(readAssetData)) {
            n nVar = new n("ubc_sign", com.baidu.g.e.xN(readAssetData));
            nVar.bPi();
            bOJ().a(nVar);
        }
    }

    private d() {
        init(o.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bOJ() {
        if (hTX == null) {
            synchronized (d.class) {
                if (hTX == null) {
                    hTX = new d();
                }
            }
        }
        return hTX;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.hUb = com.baidu.g.b.bPz().getInt("ubc_key_flow_handle", 0);
            this.hTY = Executors.newSingleThreadExecutor();
            this.hTY.execute(new g(this, null));
            this.hTZ = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str, String str2, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.hTW != null && this.hTW.xA(str)) {
                bVar.oI(true);
            }
            this.hTY.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.hTW != null && this.hTW.xA(str)) {
                bVar.oI(true);
            }
            this.hTY.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, String str2, String str3, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.xu(str3);
            }
            if (this.hTW != null && this.hTW.xA(str)) {
                bVar.oI(true);
            }
            this.hTY.execute(bVar);
        }
    }

    boolean bb(String str, int i) {
        if (this.hTW == null || this.hTW.bd(str, i)) {
            if ((i & 16) == 0 || o.bPm().kn(str)) {
                if (this.hTW != null && this.hTW.xy(str) > 0) {
                    if (new Random().nextInt(100) >= this.hTW.xy(str)) {
                        return true;
                    }
                }
                return this.hTW != null && this.hTW.xz(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.hTY.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.hTY.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow n(String str, String str2, int i) {
        Flow bc;
        bc = bc(str, i);
        if (bc != null && bc.bPc()) {
            RunnableC0333d runnableC0333d = new RunnableC0333d(bc, str2);
            if (this.hTW != null && this.hTW.xA(str)) {
                runnableC0333d.oI(true);
            }
            this.hTY.execute(runnableC0333d);
        }
        return bc;
    }

    Flow bc(String str, int i) {
        Flow flow = new Flow(str, this.hUb, i);
        if (this.hTW != null && !this.hTW.bd(str, i)) {
            flow.oJ(false);
        } else if ((i & 16) != 0 && !o.bPm().kn(str)) {
            flow.oJ(false);
        } else {
            if (this.hTW != null && this.hTW.xy(str) > 0) {
                if (new Random().nextInt(100) >= this.hTW.xy(str)) {
                    flow.oJ(false);
                }
            }
            if (this.hTW != null && this.hTW.xz(str)) {
                flow.oJ(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.hTY.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.hTY.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ba(String str, int i) {
        this.hTY.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d hUd;

        @Override // java.lang.Runnable
        public void run() {
            if (this.hUd.hUa != null) {
                this.hUd.hUa.bOF();
            }
        }
    }

    void a(n nVar) {
        this.hTY.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final JSONObject jSONObject, final String str) {
        this.hTZ.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hUa != null) {
                    d.this.hUa.k(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(final JSONObject jSONObject) {
        this.hTZ.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hUa != null) {
                    d.this.hUa.aw(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ae(final String str, final boolean z) {
        this.hTY.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hUa != null) {
                    if (z) {
                        d.this.hUa.xs(str);
                    } else {
                        d.this.hUa.xt(str);
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
            d.this.hTW = com.baidu.ubc.e.bOK();
            d.this.hUa = new com.baidu.ubc.c(d.this.mContext);
            d.this.hUa.bOI();
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private j hUh;

        b(String str, String str2, int i) {
            this.hUh = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.hUh = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.hUh = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.hUh = new j(str, str2, i, str3, j, i2);
        }

        public void oI(boolean z) {
            if (this.hUh != null) {
                this.hUh.oI(z);
            }
        }

        public void xu(String str) {
            if (this.hUh != null) {
                this.hUh.iU(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hUa != null) {
                this.hUh.bPb();
                if (!TextUtils.isEmpty(d.this.hTW.xx(this.hUh.getId()))) {
                    this.hUh.setCategory(d.this.hTW.xx(this.hUh.getId()));
                }
                if ((this.hUh.bOY() & 8) != 0) {
                    d.this.hUa.b(this.hUh);
                } else {
                    d.this.hUa.a(this.hUh);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0333d implements Runnable {
        private k hUj;

        RunnableC0333d(Flow flow, String str) {
            this.hUj = new k(flow.getId(), flow.getHandle(), str, flow.bOY());
            this.hUj.dg(flow.getStartTime());
            this.hUj.xF("1");
            d.d(d.this);
        }

        public void oI(boolean z) {
            if (this.hUj != null) {
                this.hUj.oI(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hUa != null) {
                this.hUj.bPb();
                if (!TextUtils.isEmpty(d.this.hTW.xx(this.hUj.getId()))) {
                    this.hUj.setCategory(d.this.hTW.xx(this.hUj.getId()));
                }
                d.this.hUa.b(this.hUj);
                com.baidu.g.b.bPz().putInt("ubc_key_flow_handle", d.this.hUb);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private int hUi;
        private String mFlowId;
        private String mValue;

        f(String str, int i, String str2) {
            this.mFlowId = str;
            this.hUi = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hUa != null) {
                d.this.hUa.n(this.mFlowId, this.hUi, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private int hUi;
        private JSONArray hUk;
        private long mEndTime = System.currentTimeMillis();
        private String mFlowId;

        e(String str, int i, JSONArray jSONArray) {
            this.mFlowId = str;
            this.hUi = i;
            this.hUk = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hUa != null) {
                d.this.hUa.a(this.mFlowId, this.hUi, this.mEndTime, this.hUk);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private int hUi;
        private String mFlowId;

        c(String str, int i) {
            this.mFlowId = str;
            this.hUi = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hUa != null) {
                d.this.hUa.ba(this.mFlowId, this.hUi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n hUg;

        a(n nVar) {
            this.hUg = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hUa != null) {
                d.this.hUa.a(this.hUg);
            }
        }
    }
}
