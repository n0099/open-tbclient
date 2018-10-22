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
    private static volatile d hSn;
    private com.baidu.ubc.e hSm;
    private ExecutorService hSo;
    private ExecutorService hSp;
    private com.baidu.ubc.c hSq;
    private int hSr;
    private boolean hSs = false;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.hSr;
        dVar.hSr = i + 1;
        return i;
    }

    static {
        String readAssetData = com.baidu.g.e.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(readAssetData)) {
            n nVar = new n("ubc_sign", com.baidu.g.e.xI(readAssetData));
            nVar.bPJ();
            bPk().a(nVar);
        }
    }

    private d() {
        init(o.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bPk() {
        if (hSn == null) {
            synchronized (d.class) {
                if (hSn == null) {
                    hSn = new d();
                }
            }
        }
        return hSn;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.hSr = com.baidu.g.b.bQa().getInt("ubc_key_flow_handle", 0);
            this.hSo = Executors.newSingleThreadExecutor();
            this.hSo.execute(new g(this, null));
            this.hSp = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str, String str2, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.hSm != null && this.hSm.xv(str)) {
                bVar.ou(true);
            }
            this.hSo.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.hSm != null && this.hSm.xv(str)) {
                bVar.ou(true);
            }
            this.hSo.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, String str2, String str3, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.xp(str3);
            }
            if (this.hSm != null && this.hSm.xv(str)) {
                bVar.ou(true);
            }
            this.hSo.execute(bVar);
        }
    }

    boolean bb(String str, int i) {
        if (this.hSm == null || this.hSm.bd(str, i)) {
            if ((i & 16) == 0 || o.bPN().kl(str)) {
                if (this.hSm != null && this.hSm.xt(str) > 0) {
                    if (new Random().nextInt(100) >= this.hSm.xt(str)) {
                        return true;
                    }
                }
                return this.hSm != null && this.hSm.xu(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.hSo.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.hSo.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow n(String str, String str2, int i) {
        Flow bc;
        bc = bc(str, i);
        if (bc != null && bc.bPD()) {
            RunnableC0305d runnableC0305d = new RunnableC0305d(bc, str2);
            if (this.hSm != null && this.hSm.xv(str)) {
                runnableC0305d.ou(true);
            }
            this.hSo.execute(runnableC0305d);
        }
        return bc;
    }

    Flow bc(String str, int i) {
        Flow flow = new Flow(str, this.hSr, i);
        if (this.hSm != null && !this.hSm.bd(str, i)) {
            flow.ov(false);
        } else if ((i & 16) != 0 && !o.bPN().kl(str)) {
            flow.ov(false);
        } else {
            if (this.hSm != null && this.hSm.xt(str) > 0) {
                if (new Random().nextInt(100) >= this.hSm.xt(str)) {
                    flow.ov(false);
                }
            }
            if (this.hSm != null && this.hSm.xu(str)) {
                flow.ov(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.hSo.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.hSo.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ba(String str, int i) {
        this.hSo.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d hSt;

        @Override // java.lang.Runnable
        public void run() {
            if (this.hSt.hSq != null) {
                this.hSt.hSq.bPg();
            }
        }
    }

    void a(n nVar) {
        this.hSo.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final JSONObject jSONObject, final String str) {
        this.hSp.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hSq != null) {
                    d.this.hSq.j(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(final JSONObject jSONObject) {
        this.hSp.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hSq != null) {
                    d.this.hSq.aw(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ae(final String str, final boolean z) {
        this.hSo.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hSq != null) {
                    if (z) {
                        d.this.hSq.xn(str);
                    } else {
                        d.this.hSq.xo(str);
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
            d.this.hSm = com.baidu.ubc.e.bPl();
            d.this.hSq = new com.baidu.ubc.c(d.this.mContext);
            d.this.hSq.bPj();
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private j hSx;

        b(String str, String str2, int i) {
            this.hSx = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.hSx = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.hSx = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.hSx = new j(str, str2, i, str3, j, i2);
        }

        public void ou(boolean z) {
            if (this.hSx != null) {
                this.hSx.ou(z);
            }
        }

        public void xp(String str) {
            if (this.hSx != null) {
                this.hSx.iS(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSq != null) {
                this.hSx.bPC();
                if (!TextUtils.isEmpty(d.this.hSm.xs(this.hSx.getId()))) {
                    this.hSx.setCategory(d.this.hSm.xs(this.hSx.getId()));
                }
                if ((this.hSx.bPz() & 8) != 0) {
                    d.this.hSq.b(this.hSx);
                } else {
                    d.this.hSq.a(this.hSx);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0305d implements Runnable {
        private k hSz;

        RunnableC0305d(Flow flow, String str) {
            this.hSz = new k(flow.getId(), flow.getHandle(), str, flow.bPz());
            this.hSz.dl(flow.getStartTime());
            this.hSz.xA("1");
            d.d(d.this);
        }

        public void ou(boolean z) {
            if (this.hSz != null) {
                this.hSz.ou(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSq != null) {
                this.hSz.bPC();
                if (!TextUtils.isEmpty(d.this.hSm.xs(this.hSz.getId()))) {
                    this.hSz.setCategory(d.this.hSm.xs(this.hSz.getId()));
                }
                d.this.hSq.b(this.hSz);
                com.baidu.g.b.bQa().putInt("ubc_key_flow_handle", d.this.hSr);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private int hSy;
        private String mFlowId;
        private String mValue;

        f(String str, int i, String str2) {
            this.mFlowId = str;
            this.hSy = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSq != null) {
                d.this.hSq.n(this.mFlowId, this.hSy, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private JSONArray hSA;
        private int hSy;
        private long mEndTime = System.currentTimeMillis();
        private String mFlowId;

        e(String str, int i, JSONArray jSONArray) {
            this.mFlowId = str;
            this.hSy = i;
            this.hSA = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSq != null) {
                d.this.hSq.a(this.mFlowId, this.hSy, this.mEndTime, this.hSA);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private int hSy;
        private String mFlowId;

        c(String str, int i) {
            this.mFlowId = str;
            this.hSy = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSq != null) {
                d.this.hSq.ba(this.mFlowId, this.hSy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n hSw;

        a(n nVar) {
            this.hSw = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSq != null) {
                d.this.hSq.a(this.hSw);
            }
        }
    }
}
