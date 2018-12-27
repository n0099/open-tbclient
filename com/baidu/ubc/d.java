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
    private static volatile d ieu;
    private com.baidu.ubc.e iet;
    private ExecutorService iev;
    private ExecutorService iew;
    private com.baidu.ubc.c iex;
    private int iey;
    private boolean iez = false;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.iey;
        dVar.iey = i + 1;
        return i;
    }

    static {
        String readAssetData = com.baidu.g.e.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(readAssetData)) {
            n nVar = new n("ubc_sign", com.baidu.g.e.yt(readAssetData));
            nVar.bSe();
            bRF().a(nVar);
        }
    }

    private d() {
        init(o.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bRF() {
        if (ieu == null) {
            synchronized (d.class) {
                if (ieu == null) {
                    ieu = new d();
                }
            }
        }
        return ieu;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.iey = com.baidu.g.b.bSv().getInt("ubc_key_flow_handle", 0);
            this.iev = Executors.newSingleThreadExecutor();
            this.iev.execute(new g(this, null));
            this.iew = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str, String str2, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.iet != null && this.iet.yg(str)) {
                bVar.oN(true);
            }
            this.iev.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.iet != null && this.iet.yg(str)) {
                bVar.oN(true);
            }
            this.iev.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, String str2, String str3, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.ya(str3);
            }
            if (this.iet != null && this.iet.yg(str)) {
                bVar.oN(true);
            }
            this.iev.execute(bVar);
        }
    }

    boolean bd(String str, int i) {
        if (this.iet == null || this.iet.bf(str, i)) {
            if ((i & 16) == 0 || o.bSi().kI(str)) {
                if (this.iet != null && this.iet.ye(str) > 0) {
                    if (new Random().nextInt(100) >= this.iet.ye(str)) {
                        return true;
                    }
                }
                return this.iet != null && this.iet.yf(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.iev.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.iev.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow n(String str, String str2, int i) {
        Flow be;
        be = be(str, i);
        if (be != null && be.bRY()) {
            RunnableC0347d runnableC0347d = new RunnableC0347d(be, str2);
            if (this.iet != null && this.iet.yg(str)) {
                runnableC0347d.oN(true);
            }
            this.iev.execute(runnableC0347d);
        }
        return be;
    }

    Flow be(String str, int i) {
        Flow flow = new Flow(str, this.iey, i);
        if (this.iet != null && !this.iet.bf(str, i)) {
            flow.oO(false);
        } else if ((i & 16) != 0 && !o.bSi().kI(str)) {
            flow.oO(false);
        } else {
            if (this.iet != null && this.iet.ye(str) > 0) {
                if (new Random().nextInt(100) >= this.iet.ye(str)) {
                    flow.oO(false);
                }
            }
            if (this.iet != null && this.iet.yf(str)) {
                flow.oO(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.iev.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.iev.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(String str, int i) {
        this.iev.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d ieA;

        @Override // java.lang.Runnable
        public void run() {
            if (this.ieA.iex != null) {
                this.ieA.iex.bRB();
            }
        }
    }

    void a(n nVar) {
        this.iev.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final JSONObject jSONObject, final String str) {
        this.iew.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.iex != null) {
                    d.this.iex.k(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(final JSONObject jSONObject) {
        this.iew.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.iex != null) {
                    d.this.iex.ay(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ag(final String str, final boolean z) {
        this.iev.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.iex != null) {
                    if (z) {
                        d.this.iex.xY(str);
                    } else {
                        d.this.iex.xZ(str);
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
            d.this.iet = com.baidu.ubc.e.bRG();
            d.this.iex = new com.baidu.ubc.c(d.this.mContext);
            d.this.iex.bRE();
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private j ieE;

        b(String str, String str2, int i) {
            this.ieE = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.ieE = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.ieE = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.ieE = new j(str, str2, i, str3, j, i2);
        }

        public void oN(boolean z) {
            if (this.ieE != null) {
                this.ieE.oN(z);
            }
        }

        public void ya(String str) {
            if (this.ieE != null) {
                this.ieE.jn(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.iex != null) {
                this.ieE.bRX();
                if (!TextUtils.isEmpty(d.this.iet.yd(this.ieE.getId()))) {
                    this.ieE.setCategory(d.this.iet.yd(this.ieE.getId()));
                }
                if ((this.ieE.bRU() & 8) != 0) {
                    d.this.iex.b(this.ieE);
                } else {
                    d.this.iex.a(this.ieE);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0347d implements Runnable {
        private k ieG;

        RunnableC0347d(Flow flow, String str) {
            this.ieG = new k(flow.getId(), flow.getHandle(), str, flow.bRU());
            this.ieG.ds(flow.getStartTime());
            this.ieG.yl("1");
            d.d(d.this);
        }

        public void oN(boolean z) {
            if (this.ieG != null) {
                this.ieG.oN(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.iex != null) {
                this.ieG.bRX();
                if (!TextUtils.isEmpty(d.this.iet.yd(this.ieG.getId()))) {
                    this.ieG.setCategory(d.this.iet.yd(this.ieG.getId()));
                }
                d.this.iex.b(this.ieG);
                com.baidu.g.b.bSv().putInt("ubc_key_flow_handle", d.this.iey);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private int ieF;
        private String mFlowId;
        private String mValue;

        f(String str, int i, String str2) {
            this.mFlowId = str;
            this.ieF = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.iex != null) {
                d.this.iex.n(this.mFlowId, this.ieF, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private int ieF;
        private JSONArray ieH;
        private long mEndTime = System.currentTimeMillis();
        private String mFlowId;

        e(String str, int i, JSONArray jSONArray) {
            this.mFlowId = str;
            this.ieF = i;
            this.ieH = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.iex != null) {
                d.this.iex.a(this.mFlowId, this.ieF, this.mEndTime, this.ieH);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private int ieF;
        private String mFlowId;

        c(String str, int i) {
            this.mFlowId = str;
            this.ieF = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.iex != null) {
                d.this.iex.bc(this.mFlowId, this.ieF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n ieD;

        a(n nVar) {
            this.ieD = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.iex != null) {
                d.this.iex.a(this.ieD);
            }
        }
    }
}
