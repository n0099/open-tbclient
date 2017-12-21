package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.play.j;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String bdl;
    private y fQA;
    private String fQC;
    private v fQI;
    private boolean fQJ;
    private long fQO;
    private Context mContext;
    private String zW;
    private String fQB = "1";
    private boolean fQD = false;
    private long fQE = 0;
    private long fQF = 0;
    private long mStartTime = 0;
    private long fQG = 0;
    private int fQH = 0;
    private boolean fQK = false;
    private boolean fQL = false;
    private int fQM = 8;
    private int fQN = 16;
    private Runnable fQP = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.fQK && n.this.fQL && n.this.bje() && n.this.bjz()) {
                s.f(n.this.mContext, n.this.fQC, -1);
            }
        }
    };
    private Runnable fQQ = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bjz()) {
                s.aa(n.this.mContext, n.this.fQC);
            } else if (!n.this.fQD) {
                s.hE(n.this.fQC);
            }
        }
    };
    private j.c fPx = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void OT() {
            n.g(n.this);
        }
    };
    private j blq = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.fQH;
        nVar.fQH = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.blq.a(this.fPx);
        this.fQI = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String hC(String str) {
        this.fQK = com.baidu.tbadk.coreExtra.model.f.AK();
        this.fQL = com.baidu.tbadk.coreExtra.model.f.AL();
        this.fQM = com.baidu.tbadk.coreExtra.model.f.AM();
        this.fQN = com.baidu.tbadk.coreExtra.model.f.AN();
        this.fQC = str;
        this.bdl = this.fQD ? this.fQC : s.U(str, this.fQK);
        if (this.fQI != null) {
            w.a("start_play", this.fQC, bjz(), (int) this.fQI.bjI(), this.fQI.getDuration());
        }
        this.fQF = System.currentTimeMillis();
        return this.bdl;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bje() {
        return !StringUtils.isNull(this.bdl) && this.bdl.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjf() {
        return this.fQK;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjg() {
        return this.fQL;
    }

    @Override // com.baidu.tieba.play.d
    public int bjh() {
        return com.baidu.tbadk.coreExtra.model.f.AO() ? this.fQM : this.fQN;
    }

    @Override // com.baidu.tieba.play.d
    public String bjd() {
        return this.fQC;
    }

    @Override // com.baidu.tieba.play.d
    public void bji() {
        if (this.fQK && this.fQL && bje() && bjz()) {
            s.f(this.mContext, this.fQC, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cI(long j) {
        this.fQO = j;
        bjr();
        if (this.fQF > 0) {
            this.fQG = System.currentTimeMillis() - this.fQF;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fQC) && (parse = Uri.parse(n.this.fQC)) != null) {
                    try {
                        n.this.zW = InetAddress.getByName(parse.getHost()).getHostAddress();
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(2);
        bdAsyncTask.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.d
    public void onStart() {
        if (this.mStartTime != 0) {
            this.fQE += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.blq != null) {
            this.blq.start();
        }
        this.fQJ = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQQ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQP);
        bjk();
        if (this.mStartTime > 0) {
            this.fQE += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bjv();
        this.fQJ = false;
        if (this.blq != null) {
            this.blq.stop();
        }
        if (this.fQG > 0 && this.fQI != null) {
            ak akVar = new ak("c11685");
            akVar.ac("service_ip", this.zW);
            akVar.ac("video_url", this.fQC);
            akVar.f("video_size", this.fQI.bjI());
            akVar.r("video_duration", this.fQI.getDuration());
            akVar.ac("video_resolution", this.fQI.bjJ());
            akVar.r("loading_count", this.fQH);
            akVar.f("user_watch_time", this.fQE / 1000);
            akVar.f("start_play_time", this.fQG);
            TiebaStatic.log(akVar);
        }
        if (this.fQI != null && this.fQG > 0) {
            w.a("stop_play", this.fQC, bjz(), (int) this.fQI.bjI(), this.fQI.getDuration());
        }
        this.fQG = 0L;
        this.fQE = 0L;
        this.fQH = 0;
        this.fQF = 0L;
        this.mStartTime = 0L;
    }

    private void bjv() {
        if (this.fQE >= 0 && this.fQE < 86400000) {
            if (this.fQE > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fQE);
                akVar.ac("obj_type", this.fQB);
                akVar.f("playduration", this.fQO);
                if (this.fQA != null) {
                    this.fQA.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fQE, this.fQB, this.fQA, "", this.fQO);
            } else if (this.fQJ) {
                l.a(this.fQE, this.fQB, this.fQA, "", this.fQO);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fQE += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fQE += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bjw() {
        return s.hD(this.fQC) != null;
    }

    public void bjx() {
        this.fQD = true;
    }

    public void rq(String str) {
        this.fQB = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.blq;
    }

    public v bjy() {
        return this.fQI;
    }

    public void bjr() {
        if (!this.fQK) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQQ);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.fQQ, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void bjj() {
        if (!this.fQK) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQQ);
            com.baidu.adp.lib.g.e.fP().post(this.fQQ);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void sx(int i) {
        if (bjz()) {
            s.f(this.mContext, this.fQC, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQP);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fQP, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bjk() {
        if (bjz()) {
            s.ab(this.mContext, this.fQC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjz() {
        return (this.fQD || this.bdl == null || this.bdl.equals(this.fQC)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.fQA = yVar;
    }

    public y bjA() {
        return this.fQA;
    }
}
