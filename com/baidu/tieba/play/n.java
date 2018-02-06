package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String aoi;
    private String bTr;
    private aa guF;
    private String guH;
    private w guN;
    private boolean guO;
    private long guT;
    private Context mContext;
    private String guG = "1";
    private boolean guI = false;
    private long guJ = 0;
    private long guK = 0;
    private long mStartTime = 0;
    private long guL = 0;
    private int guM = 0;
    private boolean guP = false;
    private boolean guQ = false;
    private int guR = 8;
    private int guS = 16;
    private Runnable guU = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.guP && n.this.guQ && n.this.blg() && n.this.blB()) {
                t.f(n.this.mContext, n.this.guH, -1);
            }
        }
    };
    private Runnable guV = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.blB()) {
                t.ad(n.this.mContext, n.this.guH);
            } else if (!n.this.guI) {
                t.hY(n.this.guH);
            }
        }
    };
    private j.c gtG = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void WZ() {
            n.g(n.this);
        }
    };
    private j caZ = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.guM;
        nVar.guM = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.caZ.a(this.gtG);
        this.guN = new w();
    }

    @Override // com.baidu.tieba.play.d
    public String hW(String str) {
        this.guP = com.baidu.tbadk.coreExtra.model.f.IN();
        this.guQ = com.baidu.tbadk.coreExtra.model.f.IO();
        this.guR = com.baidu.tbadk.coreExtra.model.f.IP();
        this.guS = com.baidu.tbadk.coreExtra.model.f.IQ();
        this.guH = str;
        this.bTr = this.guI ? this.guH : t.U(str, this.guP);
        if (this.guN != null) {
            x.a("start_play", this.guH, blB(), (int) this.guN.blN(), this.guN.getDuration());
        }
        this.guK = System.currentTimeMillis();
        return this.bTr;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blg() {
        return !StringUtils.isNull(this.bTr) && this.bTr.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean blh() {
        return this.guP;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bli() {
        return this.guQ;
    }

    @Override // com.baidu.tieba.play.d
    public int blj() {
        return com.baidu.tbadk.coreExtra.model.f.IR() ? this.guR : this.guS;
    }

    @Override // com.baidu.tieba.play.d
    public String ble() {
        return this.guH;
    }

    @Override // com.baidu.tieba.play.d
    public void blk() {
        if (this.guP && this.guQ && blg() && blB()) {
            t.f(this.mContext, this.guH, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cK(long j) {
        this.guT = j;
        blA();
        if (this.guK > 0) {
            this.guL = System.currentTimeMillis() - this.guK;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.guH) && (parse = Uri.parse(n.this.guH)) != null) {
                    try {
                        n.this.aoi = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.guJ += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.caZ != null) {
            this.caZ.start();
        }
        this.guO = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guV);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guU);
        blm();
        if (this.mStartTime > 0) {
            this.guJ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        blx();
        this.guO = false;
        if (this.caZ != null) {
            this.caZ.stop();
        }
        if (this.guL > 0 && this.guN != null) {
            ak akVar = new ak("c11685");
            akVar.ab("service_ip", this.aoi);
            akVar.ab(WebVideoActivityConfig.KEY_VIDEO_URL, this.guH);
            akVar.f("video_size", this.guN.blN());
            akVar.s(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.guN.getDuration());
            akVar.ab("video_resolution", this.guN.blO());
            akVar.s("loading_count", this.guM);
            akVar.f("user_watch_time", this.guJ / 1000);
            akVar.f("start_play_time", this.guL);
            TiebaStatic.log(akVar);
        }
        if (this.guN != null && this.guL > 0) {
            x.a("stop_play", this.guH, blB(), (int) this.guN.blN(), this.guN.getDuration());
        }
        this.guL = 0L;
        this.guJ = 0L;
        this.guM = 0;
        this.guK = 0L;
        this.mStartTime = 0L;
    }

    private void blx() {
        if (this.guJ >= 0 && this.guJ < 86400000) {
            if (this.guJ > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.guJ);
                akVar.ab("obj_type", this.guG);
                akVar.f("playduration", this.guT);
                if (this.guF != null) {
                    this.guF.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.guJ, this.guG, this.guF, "", this.guT);
            } else if (this.guO) {
                l.a(this.guJ, this.guG, this.guF, "", this.guT);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.guJ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.guJ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean blf() {
        return t.hX(this.guH) != null;
    }

    public void bly() {
        this.guI = true;
    }

    public void rj(String str) {
        this.guG = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bll() {
        return this.caZ;
    }

    public w blz() {
        return this.guN;
    }

    public void blA() {
        if (!this.guP) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guV);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.guV, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tR(int i) {
        if (blB()) {
            t.f(this.mContext, this.guH, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guU);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.guU, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void blm() {
        if (blB()) {
            t.ae(this.mContext, this.guH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blB() {
        return (this.guI || this.bTr == null || this.bTr.equals(this.guH)) ? false : true;
    }

    public void setVideoStatsData(aa aaVar) {
        this.guF = aaVar;
    }

    public aa blC() {
        return this.guF;
    }
}
