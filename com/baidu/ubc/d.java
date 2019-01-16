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
    private static volatile d ifB;
    private com.baidu.ubc.e ifA;
    private ExecutorService ifC;
    private ExecutorService ifD;
    private com.baidu.ubc.c ifE;
    private int ifF;
    private boolean ifG = false;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.ifF;
        dVar.ifF = i + 1;
        return i;
    }

    static {
        String readAssetData = com.baidu.g.e.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(readAssetData)) {
            n nVar = new n("ubc_sign", com.baidu.g.e.yJ(readAssetData));
            nVar.bSM();
            bSn().a(nVar);
        }
    }

    private d() {
        init(o.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bSn() {
        if (ifB == null) {
            synchronized (d.class) {
                if (ifB == null) {
                    ifB = new d();
                }
            }
        }
        return ifB;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ifF = com.baidu.g.b.bTd().getInt("ubc_key_flow_handle", 0);
            this.ifC = Executors.newSingleThreadExecutor();
            this.ifC.execute(new g(this, null));
            this.ifD = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ifA != null && this.ifA.yw(str)) {
                bVar.oO(true);
            }
            this.ifC.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ifA != null && this.ifA.yw(str)) {
                bVar.oO(true);
            }
            this.ifC.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, String str2, String str3, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.yq(str3);
            }
            if (this.ifA != null && this.ifA.yw(str)) {
                bVar.oO(true);
            }
            this.ifC.execute(bVar);
        }
    }

    boolean bd(String str, int i) {
        if (this.ifA == null || this.ifA.bf(str, i)) {
            if ((i & 16) == 0 || o.bSQ().kY(str)) {
                if (this.ifA != null && this.ifA.yu(str) > 0) {
                    if (new Random().nextInt(100) >= this.ifA.yu(str)) {
                        return true;
                    }
                }
                return this.ifA != null && this.ifA.yv(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.ifC.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.ifC.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow o(String str, String str2, int i) {
        Flow be;
        be = be(str, i);
        if (be != null && be.bSG()) {
            RunnableC0346d runnableC0346d = new RunnableC0346d(be, str2);
            if (this.ifA != null && this.ifA.yw(str)) {
                runnableC0346d.oO(true);
            }
            this.ifC.execute(runnableC0346d);
        }
        return be;
    }

    Flow be(String str, int i) {
        Flow flow = new Flow(str, this.ifF, i);
        if (this.ifA != null && !this.ifA.bf(str, i)) {
            flow.oP(false);
        } else if ((i & 16) != 0 && !o.bSQ().kY(str)) {
            flow.oP(false);
        } else {
            if (this.ifA != null && this.ifA.yu(str) > 0) {
                if (new Random().nextInt(100) >= this.ifA.yu(str)) {
                    flow.oP(false);
                }
            }
            if (this.ifA != null && this.ifA.yv(str)) {
                flow.oP(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.ifC.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.ifC.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(String str, int i) {
        this.ifC.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d ifH;

        @Override // java.lang.Runnable
        public void run() {
            if (this.ifH.ifE != null) {
                this.ifH.ifE.bSj();
            }
        }
    }

    void a(n nVar) {
        this.ifC.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final JSONObject jSONObject, final String str) {
        this.ifD.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ifE != null) {
                    d.this.ifE.k(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(final JSONObject jSONObject) {
        this.ifD.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ifE != null) {
                    d.this.ifE.ay(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(final String str, final boolean z) {
        this.ifC.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ifE != null) {
                    if (z) {
                        d.this.ifE.yo(str);
                    } else {
                        d.this.ifE.yp(str);
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
            d.this.ifA = com.baidu.ubc.e.bSo();
            d.this.ifE = new com.baidu.ubc.c(d.this.mContext);
            d.this.ifE.bSm();
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private j ifL;

        b(String str, String str2, int i) {
            this.ifL = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.ifL = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.ifL = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.ifL = new j(str, str2, i, str3, j, i2);
        }

        public void oO(boolean z) {
            if (this.ifL != null) {
                this.ifL.oO(z);
            }
        }

        public void yq(String str) {
            if (this.ifL != null) {
                this.ifL.jD(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifE != null) {
                this.ifL.bSF();
                if (!TextUtils.isEmpty(d.this.ifA.yt(this.ifL.getId()))) {
                    this.ifL.setCategory(d.this.ifA.yt(this.ifL.getId()));
                }
                if ((this.ifL.bSC() & 8) != 0) {
                    d.this.ifE.b(this.ifL);
                } else {
                    d.this.ifE.a(this.ifL);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0346d implements Runnable {
        private k ifN;

        RunnableC0346d(Flow flow, String str) {
            this.ifN = new k(flow.getId(), flow.getHandle(), str, flow.bSC());
            this.ifN.ds(flow.getStartTime());
            this.ifN.yB("1");
            d.d(d.this);
        }

        public void oO(boolean z) {
            if (this.ifN != null) {
                this.ifN.oO(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifE != null) {
                this.ifN.bSF();
                if (!TextUtils.isEmpty(d.this.ifA.yt(this.ifN.getId()))) {
                    this.ifN.setCategory(d.this.ifA.yt(this.ifN.getId()));
                }
                d.this.ifE.b(this.ifN);
                com.baidu.g.b.bTd().putInt("ubc_key_flow_handle", d.this.ifF);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private int ifM;
        private String mFlowId;
        private String mValue;

        f(String str, int i, String str2) {
            this.mFlowId = str;
            this.ifM = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifE != null) {
                d.this.ifE.n(this.mFlowId, this.ifM, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private int ifM;
        private JSONArray ifO;
        private long mEndTime = System.currentTimeMillis();
        private String mFlowId;

        e(String str, int i, JSONArray jSONArray) {
            this.mFlowId = str;
            this.ifM = i;
            this.ifO = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifE != null) {
                d.this.ifE.a(this.mFlowId, this.ifM, this.mEndTime, this.ifO);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private int ifM;
        private String mFlowId;

        c(String str, int i) {
            this.mFlowId = str;
            this.ifM = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifE != null) {
                d.this.ifE.bc(this.mFlowId, this.ifM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n ifK;

        a(n nVar) {
            this.ifK = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifE != null) {
                d.this.ifE.a(this.ifK);
            }
        }
    }
}
