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
    private static volatile d ifC;
    private com.baidu.ubc.e ifB;
    private ExecutorService ifD;
    private ExecutorService ifE;
    private com.baidu.ubc.c ifF;
    private int ifG;
    private boolean ifH = false;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.ifG;
        dVar.ifG = i + 1;
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
        if (ifC == null) {
            synchronized (d.class) {
                if (ifC == null) {
                    ifC = new d();
                }
            }
        }
        return ifC;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ifG = com.baidu.g.b.bTd().getInt("ubc_key_flow_handle", 0);
            this.ifD = Executors.newSingleThreadExecutor();
            this.ifD.execute(new g(this, null));
            this.ifE = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, String str2, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ifB != null && this.ifB.yw(str)) {
                bVar.oO(true);
            }
            this.ifD.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ifB != null && this.ifB.yw(str)) {
                bVar.oO(true);
            }
            this.ifD.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, String str2, String str3, int i) {
        if (!bd(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.yq(str3);
            }
            if (this.ifB != null && this.ifB.yw(str)) {
                bVar.oO(true);
            }
            this.ifD.execute(bVar);
        }
    }

    boolean bd(String str, int i) {
        if (this.ifB == null || this.ifB.bf(str, i)) {
            if ((i & 16) == 0 || o.bSQ().kY(str)) {
                if (this.ifB != null && this.ifB.yu(str) > 0) {
                    if (new Random().nextInt(100) >= this.ifB.yu(str)) {
                        return true;
                    }
                }
                return this.ifB != null && this.ifB.yv(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.ifD.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.ifD.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow o(String str, String str2, int i) {
        Flow be;
        be = be(str, i);
        if (be != null && be.bSG()) {
            RunnableC0346d runnableC0346d = new RunnableC0346d(be, str2);
            if (this.ifB != null && this.ifB.yw(str)) {
                runnableC0346d.oO(true);
            }
            this.ifD.execute(runnableC0346d);
        }
        return be;
    }

    Flow be(String str, int i) {
        Flow flow = new Flow(str, this.ifG, i);
        if (this.ifB != null && !this.ifB.bf(str, i)) {
            flow.oP(false);
        } else if ((i & 16) != 0 && !o.bSQ().kY(str)) {
            flow.oP(false);
        } else {
            if (this.ifB != null && this.ifB.yu(str) > 0) {
                if (new Random().nextInt(100) >= this.ifB.yu(str)) {
                    flow.oP(false);
                }
            }
            if (this.ifB != null && this.ifB.yv(str)) {
                flow.oP(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.ifD.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.ifD.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(String str, int i) {
        this.ifD.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d ifI;

        @Override // java.lang.Runnable
        public void run() {
            if (this.ifI.ifF != null) {
                this.ifI.ifF.bSj();
            }
        }
    }

    void a(n nVar) {
        this.ifD.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final JSONObject jSONObject, final String str) {
        this.ifE.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ifF != null) {
                    d.this.ifF.k(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(final JSONObject jSONObject) {
        this.ifE.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ifF != null) {
                    d.this.ifF.ay(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(final String str, final boolean z) {
        this.ifD.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ifF != null) {
                    if (z) {
                        d.this.ifF.yo(str);
                    } else {
                        d.this.ifF.yp(str);
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
            d.this.ifB = com.baidu.ubc.e.bSo();
            d.this.ifF = new com.baidu.ubc.c(d.this.mContext);
            d.this.ifF.bSm();
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private j ifM;

        b(String str, String str2, int i) {
            this.ifM = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.ifM = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.ifM = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.ifM = new j(str, str2, i, str3, j, i2);
        }

        public void oO(boolean z) {
            if (this.ifM != null) {
                this.ifM.oO(z);
            }
        }

        public void yq(String str) {
            if (this.ifM != null) {
                this.ifM.jD(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifF != null) {
                this.ifM.bSF();
                if (!TextUtils.isEmpty(d.this.ifB.yt(this.ifM.getId()))) {
                    this.ifM.setCategory(d.this.ifB.yt(this.ifM.getId()));
                }
                if ((this.ifM.bSC() & 8) != 0) {
                    d.this.ifF.b(this.ifM);
                } else {
                    d.this.ifF.a(this.ifM);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0346d implements Runnable {
        private k ifO;

        RunnableC0346d(Flow flow, String str) {
            this.ifO = new k(flow.getId(), flow.getHandle(), str, flow.bSC());
            this.ifO.ds(flow.getStartTime());
            this.ifO.yB("1");
            d.d(d.this);
        }

        public void oO(boolean z) {
            if (this.ifO != null) {
                this.ifO.oO(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifF != null) {
                this.ifO.bSF();
                if (!TextUtils.isEmpty(d.this.ifB.yt(this.ifO.getId()))) {
                    this.ifO.setCategory(d.this.ifB.yt(this.ifO.getId()));
                }
                d.this.ifF.b(this.ifO);
                com.baidu.g.b.bTd().putInt("ubc_key_flow_handle", d.this.ifG);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private int ifN;
        private String mFlowId;
        private String mValue;

        f(String str, int i, String str2) {
            this.mFlowId = str;
            this.ifN = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifF != null) {
                d.this.ifF.n(this.mFlowId, this.ifN, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private int ifN;
        private JSONArray ifP;
        private long mEndTime = System.currentTimeMillis();
        private String mFlowId;

        e(String str, int i, JSONArray jSONArray) {
            this.mFlowId = str;
            this.ifN = i;
            this.ifP = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifF != null) {
                d.this.ifF.a(this.mFlowId, this.ifN, this.mEndTime, this.ifP);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private int ifN;
        private String mFlowId;

        c(String str, int i) {
            this.mFlowId = str;
            this.ifN = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifF != null) {
                d.this.ifF.bc(this.mFlowId, this.ifN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n ifL;

        a(n nVar) {
            this.ifL = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ifF != null) {
                d.this.ifF.a(this.ifL);
            }
        }
    }
}
