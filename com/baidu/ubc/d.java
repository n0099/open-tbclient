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
    private static volatile d hSm;
    private com.baidu.ubc.e hSl;
    private ExecutorService hSn;
    private ExecutorService hSo;
    private com.baidu.ubc.c hSp;
    private int hSq;
    private boolean hSr = false;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.hSq;
        dVar.hSq = i + 1;
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
        if (hSm == null) {
            synchronized (d.class) {
                if (hSm == null) {
                    hSm = new d();
                }
            }
        }
        return hSm;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.hSq = com.baidu.g.b.bQa().getInt("ubc_key_flow_handle", 0);
            this.hSn = Executors.newSingleThreadExecutor();
            this.hSn.execute(new g(this, null));
            this.hSo = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str, String str2, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.hSl != null && this.hSl.xv(str)) {
                bVar.ou(true);
            }
            this.hSn.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.hSl != null && this.hSl.xv(str)) {
                bVar.ou(true);
            }
            this.hSn.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, String str2, String str3, int i) {
        if (!bb(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.xp(str3);
            }
            if (this.hSl != null && this.hSl.xv(str)) {
                bVar.ou(true);
            }
            this.hSn.execute(bVar);
        }
    }

    boolean bb(String str, int i) {
        if (this.hSl == null || this.hSl.bd(str, i)) {
            if ((i & 16) == 0 || o.bPN().kl(str)) {
                if (this.hSl != null && this.hSl.xt(str) > 0) {
                    if (new Random().nextInt(100) >= this.hSl.xt(str)) {
                        return true;
                    }
                }
                return this.hSl != null && this.hSl.xu(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.hSn.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.hSn.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow n(String str, String str2, int i) {
        Flow bc;
        bc = bc(str, i);
        if (bc != null && bc.bPD()) {
            RunnableC0305d runnableC0305d = new RunnableC0305d(bc, str2);
            if (this.hSl != null && this.hSl.xv(str)) {
                runnableC0305d.ou(true);
            }
            this.hSn.execute(runnableC0305d);
        }
        return bc;
    }

    Flow bc(String str, int i) {
        Flow flow = new Flow(str, this.hSq, i);
        if (this.hSl != null && !this.hSl.bd(str, i)) {
            flow.ov(false);
        } else if ((i & 16) != 0 && !o.bPN().kl(str)) {
            flow.ov(false);
        } else {
            if (this.hSl != null && this.hSl.xt(str) > 0) {
                if (new Random().nextInt(100) >= this.hSl.xt(str)) {
                    flow.ov(false);
                }
            }
            if (this.hSl != null && this.hSl.xu(str)) {
                flow.ov(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.hSn.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.hSn.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ba(String str, int i) {
        this.hSn.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d hSs;

        @Override // java.lang.Runnable
        public void run() {
            if (this.hSs.hSp != null) {
                this.hSs.hSp.bPg();
            }
        }
    }

    void a(n nVar) {
        this.hSn.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final JSONObject jSONObject, final String str) {
        this.hSo.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hSp != null) {
                    d.this.hSp.j(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(final JSONObject jSONObject) {
        this.hSo.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hSp != null) {
                    d.this.hSp.aw(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ae(final String str, final boolean z) {
        this.hSn.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hSp != null) {
                    if (z) {
                        d.this.hSp.xn(str);
                    } else {
                        d.this.hSp.xo(str);
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
            d.this.hSl = com.baidu.ubc.e.bPl();
            d.this.hSp = new com.baidu.ubc.c(d.this.mContext);
            d.this.hSp.bPj();
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private j hSw;

        b(String str, String str2, int i) {
            this.hSw = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.hSw = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.hSw = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.hSw = new j(str, str2, i, str3, j, i2);
        }

        public void ou(boolean z) {
            if (this.hSw != null) {
                this.hSw.ou(z);
            }
        }

        public void xp(String str) {
            if (this.hSw != null) {
                this.hSw.iS(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSp != null) {
                this.hSw.bPC();
                if (!TextUtils.isEmpty(d.this.hSl.xs(this.hSw.getId()))) {
                    this.hSw.setCategory(d.this.hSl.xs(this.hSw.getId()));
                }
                if ((this.hSw.bPz() & 8) != 0) {
                    d.this.hSp.b(this.hSw);
                } else {
                    d.this.hSp.a(this.hSw);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0305d implements Runnable {
        private k hSy;

        RunnableC0305d(Flow flow, String str) {
            this.hSy = new k(flow.getId(), flow.getHandle(), str, flow.bPz());
            this.hSy.dl(flow.getStartTime());
            this.hSy.xA("1");
            d.d(d.this);
        }

        public void ou(boolean z) {
            if (this.hSy != null) {
                this.hSy.ou(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSp != null) {
                this.hSy.bPC();
                if (!TextUtils.isEmpty(d.this.hSl.xs(this.hSy.getId()))) {
                    this.hSy.setCategory(d.this.hSl.xs(this.hSy.getId()));
                }
                d.this.hSp.b(this.hSy);
                com.baidu.g.b.bQa().putInt("ubc_key_flow_handle", d.this.hSq);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private int hSx;
        private String mFlowId;
        private String mValue;

        f(String str, int i, String str2) {
            this.mFlowId = str;
            this.hSx = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSp != null) {
                d.this.hSp.n(this.mFlowId, this.hSx, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private int hSx;
        private JSONArray hSz;
        private long mEndTime = System.currentTimeMillis();
        private String mFlowId;

        e(String str, int i, JSONArray jSONArray) {
            this.mFlowId = str;
            this.hSx = i;
            this.hSz = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSp != null) {
                d.this.hSp.a(this.mFlowId, this.hSx, this.mEndTime, this.hSz);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private int hSx;
        private String mFlowId;

        c(String str, int i) {
            this.mFlowId = str;
            this.hSx = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSp != null) {
                d.this.hSp.ba(this.mFlowId, this.hSx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n hSv;

        a(n nVar) {
            this.hSv = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hSp != null) {
                d.this.hSp.a(this.hSv);
            }
        }
    }
}
