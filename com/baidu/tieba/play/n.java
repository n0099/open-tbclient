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
    private String bTi;
    private aa guK;
    private String guM;
    private w guS;
    private boolean guT;
    private long guY;
    private Context mContext;
    private String guL = "1";
    private boolean guN = false;
    private long guO = 0;
    private long guP = 0;
    private long mStartTime = 0;
    private long guQ = 0;
    private int guR = 0;
    private boolean guU = false;
    private boolean guV = false;
    private int guW = 8;
    private int guX = 16;
    private Runnable guZ = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.guU && n.this.guV && n.this.blg() && n.this.blB()) {
                t.f(n.this.mContext, n.this.guM, -1);
            }
        }
    };
    private Runnable gva = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.blB()) {
                t.ad(n.this.mContext, n.this.guM);
            } else if (!n.this.guN) {
                t.hY(n.this.guM);
            }
        }
    };
    private j.c gtL = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void WZ() {
            n.g(n.this);
        }
    };
    private j caQ = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.guR;
        nVar.guR = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.caQ.a(this.gtL);
        this.guS = new w();
    }

    @Override // com.baidu.tieba.play.d
    public String hW(String str) {
        this.guU = com.baidu.tbadk.coreExtra.model.f.IN();
        this.guV = com.baidu.tbadk.coreExtra.model.f.IO();
        this.guW = com.baidu.tbadk.coreExtra.model.f.IP();
        this.guX = com.baidu.tbadk.coreExtra.model.f.IQ();
        this.guM = str;
        this.bTi = this.guN ? this.guM : t.T(str, this.guU);
        if (this.guS != null) {
            x.a("start_play", this.guM, blB(), (int) this.guS.blN(), this.guS.getDuration());
        }
        this.guP = System.currentTimeMillis();
        return this.bTi;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blg() {
        return !StringUtils.isNull(this.bTi) && this.bTi.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean blh() {
        return this.guU;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bli() {
        return this.guV;
    }

    @Override // com.baidu.tieba.play.d
    public int blj() {
        return com.baidu.tbadk.coreExtra.model.f.IR() ? this.guW : this.guX;
    }

    @Override // com.baidu.tieba.play.d
    public String ble() {
        return this.guM;
    }

    @Override // com.baidu.tieba.play.d
    public void blk() {
        if (this.guU && this.guV && blg() && blB()) {
            t.f(this.mContext, this.guM, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cK(long j) {
        this.guY = j;
        blA();
        if (this.guP > 0) {
            this.guQ = System.currentTimeMillis() - this.guP;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.guM) && (parse = Uri.parse(n.this.guM)) != null) {
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
            this.guO += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.caQ != null) {
            this.caQ.start();
        }
        this.guT = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gva);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guZ);
        blm();
        if (this.mStartTime > 0) {
            this.guO += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        blx();
        this.guT = false;
        if (this.caQ != null) {
            this.caQ.stop();
        }
        if (this.guQ > 0 && this.guS != null) {
            ak akVar = new ak("c11685");
            akVar.ab("service_ip", this.aoc);
            akVar.ab(WebVideoActivityConfig.KEY_VIDEO_URL, this.guM);
            akVar.f("video_size", this.guS.blN());
            akVar.s(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.guS.getDuration());
            akVar.ab("video_resolution", this.guS.blO());
            akVar.s("loading_count", this.guR);
            akVar.f("user_watch_time", this.guO / 1000);
            akVar.f("start_play_time", this.guQ);
            TiebaStatic.log(akVar);
        }
        if (this.guS != null && this.guQ > 0) {
            x.a("stop_play", this.guM, blB(), (int) this.guS.blN(), this.guS.getDuration());
        }
        this.guQ = 0L;
        this.guO = 0L;
        this.guR = 0;
        this.guP = 0L;
        this.mStartTime = 0L;
    }

    private void blx() {
        if (this.guO >= 0 && this.guO < 86400000) {
            if (this.guO > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.guO);
                akVar.ab("obj_type", this.guL);
                akVar.f("playduration", this.guY);
                if (this.guK != null) {
                    this.guK.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.guO, this.guL, this.guK, "", this.guY);
            } else if (this.guT) {
                l.a(this.guO, this.guL, this.guK, "", this.guY);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.guO += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.guO += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean blf() {
        return t.hX(this.guM) != null;
    }

    public void bly() {
        this.guN = true;
    }

    public void rj(String str) {
        this.guL = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bll() {
        return this.caQ;
    }

    public w blz() {
        return this.guS;
    }

    public void blA() {
        if (!this.guU) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gva);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.gva, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tS(int i) {
        if (blB()) {
            t.f(this.mContext, this.guM, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guZ);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.guZ, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void blm() {
        if (blB()) {
            t.ae(this.mContext, this.guM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blB() {
        return (this.guN || this.bTi == null || this.bTi.equals(this.guM)) ? false : true;
    }

    public void setVideoStatsData(aa aaVar) {
        this.guK = aaVar;
    }

    public aa blC() {
        return this.guK;
    }
}
