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
    private String bdh;
    private v fQD;
    private boolean fQE;
    private long fQJ;
    private y fQv;
    private String fQx;
    private Context mContext;
    private String zV;
    private String fQw = "1";
    private boolean fQy = false;
    private long fQz = 0;
    private long fQA = 0;
    private long mStartTime = 0;
    private long fQB = 0;
    private int fQC = 0;
    private boolean fQF = false;
    private boolean fQG = false;
    private int fQH = 8;
    private int fQI = 16;
    private Runnable fQK = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.fQF && n.this.fQG && n.this.bje() && n.this.bjz()) {
                s.f(n.this.mContext, n.this.fQx, -1);
            }
        }
    };
    private Runnable fQL = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bjz()) {
                s.aa(n.this.mContext, n.this.fQx);
            } else if (!n.this.fQy) {
                s.hE(n.this.fQx);
            }
        }
    };
    private j.c fPs = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void OT() {
            n.g(n.this);
        }
    };
    private j blm = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.fQC;
        nVar.fQC = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.blm.a(this.fPs);
        this.fQD = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String hC(String str) {
        this.fQF = com.baidu.tbadk.coreExtra.model.f.AK();
        this.fQG = com.baidu.tbadk.coreExtra.model.f.AL();
        this.fQH = com.baidu.tbadk.coreExtra.model.f.AM();
        this.fQI = com.baidu.tbadk.coreExtra.model.f.AN();
        this.fQx = str;
        this.bdh = this.fQy ? this.fQx : s.U(str, this.fQF);
        if (this.fQD != null) {
            w.a("start_play", this.fQx, bjz(), (int) this.fQD.bjI(), this.fQD.getDuration());
        }
        this.fQA = System.currentTimeMillis();
        return this.bdh;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bje() {
        return !StringUtils.isNull(this.bdh) && this.bdh.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjf() {
        return this.fQF;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjg() {
        return this.fQG;
    }

    @Override // com.baidu.tieba.play.d
    public int bjh() {
        return com.baidu.tbadk.coreExtra.model.f.AO() ? this.fQH : this.fQI;
    }

    @Override // com.baidu.tieba.play.d
    public String bjd() {
        return this.fQx;
    }

    @Override // com.baidu.tieba.play.d
    public void bji() {
        if (this.fQF && this.fQG && bje() && bjz()) {
            s.f(this.mContext, this.fQx, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cI(long j) {
        this.fQJ = j;
        bjr();
        if (this.fQA > 0) {
            this.fQB = System.currentTimeMillis() - this.fQA;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fQx) && (parse = Uri.parse(n.this.fQx)) != null) {
                    try {
                        n.this.zV = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fQz += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.blm != null) {
            this.blm.start();
        }
        this.fQE = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQL);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQK);
        bjk();
        if (this.mStartTime > 0) {
            this.fQz += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bjv();
        this.fQE = false;
        if (this.blm != null) {
            this.blm.stop();
        }
        if (this.fQB > 0 && this.fQD != null) {
            ak akVar = new ak("c11685");
            akVar.ac("service_ip", this.zV);
            akVar.ac("video_url", this.fQx);
            akVar.f("video_size", this.fQD.bjI());
            akVar.r("video_duration", this.fQD.getDuration());
            akVar.ac("video_resolution", this.fQD.bjJ());
            akVar.r("loading_count", this.fQC);
            akVar.f("user_watch_time", this.fQz / 1000);
            akVar.f("start_play_time", this.fQB);
            TiebaStatic.log(akVar);
        }
        if (this.fQD != null && this.fQB > 0) {
            w.a("stop_play", this.fQx, bjz(), (int) this.fQD.bjI(), this.fQD.getDuration());
        }
        this.fQB = 0L;
        this.fQz = 0L;
        this.fQC = 0;
        this.fQA = 0L;
        this.mStartTime = 0L;
    }

    private void bjv() {
        if (this.fQz >= 0 && this.fQz < 86400000) {
            if (this.fQz > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fQz);
                akVar.ac("obj_type", this.fQw);
                akVar.f("playduration", this.fQJ);
                if (this.fQv != null) {
                    this.fQv.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fQz, this.fQw, this.fQv, "", this.fQJ);
            } else if (this.fQE) {
                l.a(this.fQz, this.fQw, this.fQv, "", this.fQJ);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fQz += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fQz += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bjw() {
        return s.hD(this.fQx) != null;
    }

    public void bjx() {
        this.fQy = true;
    }

    public void rq(String str) {
        this.fQw = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.blm;
    }

    public v bjy() {
        return this.fQD;
    }

    public void bjr() {
        if (!this.fQF) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQL);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.fQL, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void bjj() {
        if (!this.fQF) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQL);
            com.baidu.adp.lib.g.e.fP().post(this.fQL);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void sx(int i) {
        if (bjz()) {
            s.f(this.mContext, this.fQx, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQK);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fQK, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bjk() {
        if (bjz()) {
            s.ab(this.mContext, this.fQx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjz() {
        return (this.fQy || this.bdh == null || this.bdh.equals(this.fQx)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.fQv = yVar;
    }

    public y bjA() {
        return this.fQv;
    }
}
