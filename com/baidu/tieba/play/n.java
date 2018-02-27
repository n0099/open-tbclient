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
    private String aoc;
    private String bTf;
    private w guC;
    private boolean guD;
    private long guI;
    private aa guu;
    private String guw;
    private Context mContext;
    private String guv = "1";
    private boolean gux = false;
    private long guy = 0;
    private long guz = 0;
    private long mStartTime = 0;
    private long guA = 0;
    private int guB = 0;
    private boolean guE = false;
    private boolean guF = false;
    private int guG = 8;
    private int guH = 16;
    private Runnable guJ = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.guE && n.this.guF && n.this.blf() && n.this.blA()) {
                t.f(n.this.mContext, n.this.guw, -1);
            }
        }
    };
    private Runnable guK = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.blA()) {
                t.ad(n.this.mContext, n.this.guw);
            } else if (!n.this.gux) {
                t.hY(n.this.guw);
            }
        }
    };
    private j.c gtv = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void WY() {
            n.g(n.this);
        }
    };
    private j caN = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.guB;
        nVar.guB = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.caN.a(this.gtv);
        this.guC = new w();
    }

    @Override // com.baidu.tieba.play.d
    public String hW(String str) {
        this.guE = com.baidu.tbadk.coreExtra.model.f.IM();
        this.guF = com.baidu.tbadk.coreExtra.model.f.IN();
        this.guG = com.baidu.tbadk.coreExtra.model.f.IO();
        this.guH = com.baidu.tbadk.coreExtra.model.f.IP();
        this.guw = str;
        this.bTf = this.gux ? this.guw : t.T(str, this.guE);
        if (this.guC != null) {
            x.a("start_play", this.guw, blA(), (int) this.guC.blM(), this.guC.getDuration());
        }
        this.guz = System.currentTimeMillis();
        return this.bTf;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blf() {
        return !StringUtils.isNull(this.bTf) && this.bTf.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean blg() {
        return this.guE;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blh() {
        return this.guF;
    }

    @Override // com.baidu.tieba.play.d
    public int bli() {
        return com.baidu.tbadk.coreExtra.model.f.IQ() ? this.guG : this.guH;
    }

    @Override // com.baidu.tieba.play.d
    public String bld() {
        return this.guw;
    }

    @Override // com.baidu.tieba.play.d
    public void blj() {
        if (this.guE && this.guF && blf() && blA()) {
            t.f(this.mContext, this.guw, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cK(long j) {
        this.guI = j;
        blz();
        if (this.guz > 0) {
            this.guA = System.currentTimeMillis() - this.guz;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.guw) && (parse = Uri.parse(n.this.guw)) != null) {
                    try {
                        n.this.aoc = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.guy += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.caN != null) {
            this.caN.start();
        }
        this.guD = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guK);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guJ);
        bll();
        if (this.mStartTime > 0) {
            this.guy += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        blw();
        this.guD = false;
        if (this.caN != null) {
            this.caN.stop();
        }
        if (this.guA > 0 && this.guC != null) {
            ak akVar = new ak("c11685");
            akVar.ab("service_ip", this.aoc);
            akVar.ab(WebVideoActivityConfig.KEY_VIDEO_URL, this.guw);
            akVar.f("video_size", this.guC.blM());
            akVar.s(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.guC.getDuration());
            akVar.ab("video_resolution", this.guC.blN());
            akVar.s("loading_count", this.guB);
            akVar.f("user_watch_time", this.guy / 1000);
            akVar.f("start_play_time", this.guA);
            TiebaStatic.log(akVar);
        }
        if (this.guC != null && this.guA > 0) {
            x.a("stop_play", this.guw, blA(), (int) this.guC.blM(), this.guC.getDuration());
        }
        this.guA = 0L;
        this.guy = 0L;
        this.guB = 0;
        this.guz = 0L;
        this.mStartTime = 0L;
    }

    private void blw() {
        if (this.guy >= 0 && this.guy < 86400000) {
            if (this.guy > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.guy);
                akVar.ab("obj_type", this.guv);
                akVar.f("playduration", this.guI);
                if (this.guu != null) {
                    this.guu.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.guy, this.guv, this.guu, "", this.guI);
            } else if (this.guD) {
                l.a(this.guy, this.guv, this.guu, "", this.guI);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.guy += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.guy += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean ble() {
        return t.hX(this.guw) != null;
    }

    public void blx() {
        this.gux = true;
    }

    public void rj(String str) {
        this.guv = str;
    }

    @Override // com.baidu.tieba.play.d
    public j blk() {
        return this.caN;
    }

    public w bly() {
        return this.guC;
    }

    public void blz() {
        if (!this.guE) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guK);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.guK, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tS(int i) {
        if (blA()) {
            t.f(this.mContext, this.guw, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guJ);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.guJ, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bll() {
        if (blA()) {
            t.ae(this.mContext, this.guw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blA() {
        return (this.gux || this.bTf == null || this.bTf.equals(this.guw)) ? false : true;
    }

    public void setVideoStatsData(aa aaVar) {
        this.guu = aaVar;
    }

    public aa blB() {
        return this.guu;
    }
}
