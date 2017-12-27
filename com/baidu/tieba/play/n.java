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
    private String aoh;
    private String bQX;
    private w gDF;
    private boolean gDG;
    private long gDL;
    private aa gDx;
    private String gDz;
    private Context mContext;
    private String gDy = "1";
    private boolean gDA = false;
    private long gDB = 0;
    private long gDC = 0;
    private long mStartTime = 0;
    private long gDD = 0;
    private int gDE = 0;
    private boolean gDH = false;
    private boolean gDI = false;
    private int gDJ = 8;
    private int gDK = 16;
    private Runnable gDM = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gDH && n.this.gDI && n.this.bqz() && n.this.bqU()) {
                t.f(n.this.mContext, n.this.gDz, -1);
            }
        }
    };
    private Runnable gDN = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bqU()) {
                t.ad(n.this.mContext, n.this.gDz);
            } else if (!n.this.gDA) {
                t.hG(n.this.gDz);
            }
        }
    };
    private j.c gCy = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Ws() {
            n.g(n.this);
        }
    };
    private j bYB = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gDE;
        nVar.gDE = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bYB.a(this.gCy);
        this.gDF = new w();
    }

    @Override // com.baidu.tieba.play.d
    public String hE(String str) {
        this.gDH = com.baidu.tbadk.coreExtra.model.f.Im();
        this.gDI = com.baidu.tbadk.coreExtra.model.f.In();
        this.gDJ = com.baidu.tbadk.coreExtra.model.f.Io();
        this.gDK = com.baidu.tbadk.coreExtra.model.f.Ip();
        this.gDz = str;
        this.bQX = this.gDA ? this.gDz : t.V(str, this.gDH);
        if (this.gDF != null) {
            x.a("start_play", this.gDz, bqU(), (int) this.gDF.brg(), this.gDF.getDuration());
        }
        this.gDC = System.currentTimeMillis();
        return this.bQX;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bqz() {
        return !StringUtils.isNull(this.bQX) && this.bQX.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bqA() {
        return this.gDH;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bqB() {
        return this.gDI;
    }

    @Override // com.baidu.tieba.play.d
    public int bqC() {
        return com.baidu.tbadk.coreExtra.model.f.Iq() ? this.gDJ : this.gDK;
    }

    @Override // com.baidu.tieba.play.d
    public String bqx() {
        return this.gDz;
    }

    @Override // com.baidu.tieba.play.d
    public void bqD() {
        if (this.gDH && this.gDI && bqz() && bqU()) {
            t.f(this.mContext, this.gDz, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cR(long j) {
        this.gDL = j;
        bqT();
        if (this.gDC > 0) {
            this.gDD = System.currentTimeMillis() - this.gDC;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.gDz) && (parse = Uri.parse(n.this.gDz)) != null) {
                    try {
                        n.this.aoh = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.gDB += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bYB != null) {
            this.bYB.start();
        }
        this.gDG = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDN);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDM);
        bqF();
        if (this.mStartTime > 0) {
            this.gDB += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bqQ();
        this.gDG = false;
        if (this.bYB != null) {
            this.bYB.stop();
        }
        if (this.gDD > 0 && this.gDF != null) {
            ak akVar = new ak("c11685");
            akVar.ab("service_ip", this.aoh);
            akVar.ab("video_url", this.gDz);
            akVar.f("video_size", this.gDF.brg());
            akVar.s("video_duration", this.gDF.getDuration());
            akVar.ab("video_resolution", this.gDF.brh());
            akVar.s("loading_count", this.gDE);
            akVar.f("user_watch_time", this.gDB / 1000);
            akVar.f("start_play_time", this.gDD);
            TiebaStatic.log(akVar);
        }
        if (this.gDF != null && this.gDD > 0) {
            x.a("stop_play", this.gDz, bqU(), (int) this.gDF.brg(), this.gDF.getDuration());
        }
        this.gDD = 0L;
        this.gDB = 0L;
        this.gDE = 0;
        this.gDC = 0L;
        this.mStartTime = 0L;
    }

    private void bqQ() {
        if (this.gDB >= 0 && this.gDB < 86400000) {
            if (this.gDB > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.gDB);
                akVar.ab("obj_type", this.gDy);
                akVar.f("playduration", this.gDL);
                if (this.gDx != null) {
                    this.gDx.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.gDB, this.gDy, this.gDx, "", this.gDL);
            } else if (this.gDG) {
                l.a(this.gDB, this.gDy, this.gDx, "", this.gDL);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.gDB += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.gDB += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean bqy() {
        return t.hF(this.gDz) != null;
    }

    public void bqR() {
        this.gDA = true;
    }

    public void rB(String str) {
        this.gDy = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bqE() {
        return this.bYB;
    }

    public w bqS() {
        return this.gDF;
    }

    public void bqT() {
        if (!this.gDH) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDN);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.gDN, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void vs(int i) {
        if (bqU()) {
            t.f(this.mContext, this.gDz, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gDM);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gDM, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bqF() {
        if (bqU()) {
            t.ae(this.mContext, this.gDz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqU() {
        return (this.gDA || this.bQX == null || this.bQX.equals(this.gDz)) ? false : true;
    }

    public void setVideoStatsData(aa aaVar) {
        this.gDx = aaVar;
    }

    public aa bqV() {
        return this.gDx;
    }
}
