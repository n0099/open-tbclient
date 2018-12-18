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
    private static volatile d ibh;
    private com.baidu.ubc.e ibg;
    private ExecutorService ibi;
    private ExecutorService ibj;
    private com.baidu.ubc.c ibk;
    private int ibl;
    private boolean ibm = false;
    private Context mContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.ibl;
        dVar.ibl = i + 1;
        return i;
    }

    static {
        String readAssetData = com.baidu.g.e.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
        if (!TextUtils.isEmpty(readAssetData)) {
            n nVar = new n("ubc_sign", com.baidu.g.e.yq(readAssetData));
            nVar.bRn();
            bQO().a(nVar);
        }
    }

    private d() {
        init(o.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d bQO() {
        if (ibh == null) {
            synchronized (d.class) {
                if (ibh == null) {
                    ibh = new d();
                }
            }
        }
        return ibh;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ibl = com.baidu.g.b.bRE().getInt("ubc_key_flow_handle", 0);
            this.ibi = Executors.newSingleThreadExecutor();
            this.ibi.execute(new g(this, null));
            this.ibj = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str, String str2, int i) {
        if (!bc(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ibg != null && this.ibg.yd(str)) {
                bVar.oK(true);
            }
            this.ibi.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!bc(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ibg != null && this.ibg.yd(str)) {
                bVar.oK(true);
            }
            this.ibi.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, String str2, String str3, int i) {
        if (!bc(str, i)) {
            b bVar = new b(str, str2, i);
            if (!TextUtils.isEmpty(str3)) {
                bVar.xX(str3);
            }
            if (this.ibg != null && this.ibg.yd(str)) {
                bVar.oK(true);
            }
            this.ibi.execute(bVar);
        }
    }

    boolean bc(String str, int i) {
        if (this.ibg == null || this.ibg.be(str, i)) {
            if ((i & 16) == 0 || o.bRr().kH(str)) {
                if (this.ibg != null && this.ibg.yb(str) > 0) {
                    if (new Random().nextInt(100) >= this.ibg.yb(str)) {
                        return true;
                    }
                }
                return this.ibg != null && this.ibg.yc(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.ibi.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.ibi.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow n(String str, String str2, int i) {
        Flow bd;
        bd = bd(str, i);
        if (bd != null && bd.bRh()) {
            RunnableC0347d runnableC0347d = new RunnableC0347d(bd, str2);
            if (this.ibg != null && this.ibg.yd(str)) {
                runnableC0347d.oK(true);
            }
            this.ibi.execute(runnableC0347d);
        }
        return bd;
    }

    Flow bd(String str, int i) {
        Flow flow = new Flow(str, this.ibl, i);
        if (this.ibg != null && !this.ibg.be(str, i)) {
            flow.oL(false);
        } else if ((i & 16) != 0 && !o.bRr().kH(str)) {
            flow.oL(false);
        } else {
            if (this.ibg != null && this.ibg.yb(str) > 0) {
                if (new Random().nextInt(100) >= this.ibg.yb(str)) {
                    flow.oL(false);
                }
            }
            if (this.ibg != null && this.ibg.yc(str)) {
                flow.oL(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.ibi.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.ibi.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bb(String str, int i) {
        this.ibi.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ubc.d$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d ibn;

        @Override // java.lang.Runnable
        public void run() {
            if (this.ibn.ibk != null) {
                this.ibn.ibk.bQK();
            }
        }
    }

    void a(n nVar) {
        this.ibi.execute(new a(nVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final JSONObject jSONObject, final String str) {
        this.ibj.execute(new Runnable() { // from class: com.baidu.ubc.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ibk != null) {
                    d.this.ibk.k(jSONObject, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(final JSONObject jSONObject) {
        this.ibj.execute(new Runnable() { // from class: com.baidu.ubc.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ibk != null) {
                    d.this.ibk.ay(jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ag(final String str, final boolean z) {
        this.ibi.execute(new Runnable() { // from class: com.baidu.ubc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ibk != null) {
                    if (z) {
                        d.this.ibk.xV(str);
                    } else {
                        d.this.ibk.xW(str);
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
            d.this.ibg = com.baidu.ubc.e.bQP();
            d.this.ibk = new com.baidu.ubc.c(d.this.mContext);
            d.this.ibk.bQN();
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private j ibr;

        b(String str, String str2, int i) {
            this.ibr = new j(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.ibr = new j(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.ibr = new j(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.ibr = new j(str, str2, i, str3, j, i2);
        }

        public void oK(boolean z) {
            if (this.ibr != null) {
                this.ibr.oK(z);
            }
        }

        public void xX(String str) {
            if (this.ibr != null) {
                this.ibr.jm(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ibk != null) {
                this.ibr.bRg();
                if (!TextUtils.isEmpty(d.this.ibg.ya(this.ibr.getId()))) {
                    this.ibr.setCategory(d.this.ibg.ya(this.ibr.getId()));
                }
                if ((this.ibr.bRd() & 8) != 0) {
                    d.this.ibk.b(this.ibr);
                } else {
                    d.this.ibk.a(this.ibr);
                }
            }
        }
    }

    /* renamed from: com.baidu.ubc.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0347d implements Runnable {
        private k ibt;

        RunnableC0347d(Flow flow, String str) {
            this.ibt = new k(flow.getId(), flow.getHandle(), str, flow.bRd());
            this.ibt.dn(flow.getStartTime());
            this.ibt.yi("1");
            d.d(d.this);
        }

        public void oK(boolean z) {
            if (this.ibt != null) {
                this.ibt.oK(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ibk != null) {
                this.ibt.bRg();
                if (!TextUtils.isEmpty(d.this.ibg.ya(this.ibt.getId()))) {
                    this.ibt.setCategory(d.this.ibg.ya(this.ibt.getId()));
                }
                d.this.ibk.b(this.ibt);
                com.baidu.g.b.bRE().putInt("ubc_key_flow_handle", d.this.ibl);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class f implements Runnable {
        private int ibs;
        private String mFlowId;
        private String mValue;

        f(String str, int i, String str2) {
            this.mFlowId = str;
            this.ibs = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ibk != null) {
                d.this.ibk.n(this.mFlowId, this.ibs, this.mValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e implements Runnable {
        private int ibs;
        private JSONArray ibu;
        private long mEndTime = System.currentTimeMillis();
        private String mFlowId;

        e(String str, int i, JSONArray jSONArray) {
            this.mFlowId = str;
            this.ibs = i;
            this.ibu = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ibk != null) {
                d.this.ibk.a(this.mFlowId, this.ibs, this.mEndTime, this.ibu);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private int ibs;
        private String mFlowId;

        c(String str, int i) {
            this.mFlowId = str;
            this.ibs = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ibk != null) {
                d.this.ibk.bb(this.mFlowId, this.ibs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private n ibq;

        a(n nVar) {
            this.ibq = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ibk != null) {
                d.this.ibk.a(this.ibq);
            }
        }
    }
}
