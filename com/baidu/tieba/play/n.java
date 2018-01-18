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
    private String aog;
    private String bRe;
    private aa gsE;
    private String gsG;
    private w gsM;
    private boolean gsN;
    private long gsS;
    private Context mContext;
    private String gsF = "1";
    private boolean gsH = false;
    private long gsI = 0;
    private long gsJ = 0;
    private long mStartTime = 0;
    private long gsK = 0;
    private int gsL = 0;
    private boolean gsO = false;
    private boolean gsP = false;
    private int gsQ = 8;
    private int gsR = 16;
    private Runnable gsT = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gsO && n.this.gsP && n.this.bjS() && n.this.bkn()) {
                t.f(n.this.mContext, n.this.gsG, -1);
            }
        }
    };
    private Runnable gsU = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bkn()) {
                t.ac(n.this.mContext, n.this.gsG);
            } else if (!n.this.gsH) {
                t.hH(n.this.gsG);
            }
        }
    };
    private j.c grF = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Wg() {
            n.g(n.this);
        }
    };
    private j bYI = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gsL;
        nVar.gsL = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bYI.a(this.grF);
        this.gsM = new w();
    }

    @Override // com.baidu.tieba.play.d
    public String hF(String str) {
        this.gsO = com.baidu.tbadk.coreExtra.model.f.If();
        this.gsP = com.baidu.tbadk.coreExtra.model.f.Ig();
        this.gsQ = com.baidu.tbadk.coreExtra.model.f.Ih();
        this.gsR = com.baidu.tbadk.coreExtra.model.f.Ii();
        this.gsG = str;
        this.bRe = this.gsH ? this.gsG : t.V(str, this.gsO);
        if (this.gsM != null) {
            x.a("start_play", this.gsG, bkn(), (int) this.gsM.bkz(), this.gsM.getDuration());
        }
        this.gsJ = System.currentTimeMillis();
        return this.bRe;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjS() {
        return !StringUtils.isNull(this.bRe) && this.bRe.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjT() {
        return this.gsO;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjU() {
        return this.gsP;
    }

    @Override // com.baidu.tieba.play.d
    public int bjV() {
        return com.baidu.tbadk.coreExtra.model.f.Ij() ? this.gsQ : this.gsR;
    }

    @Override // com.baidu.tieba.play.d
    public String bjQ() {
        return this.gsG;
    }

    @Override // com.baidu.tieba.play.d
    public void bjW() {
        if (this.gsO && this.gsP && bjS() && bkn()) {
            t.f(this.mContext, this.gsG, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cJ(long j) {
        this.gsS = j;
        bkm();
        if (this.gsJ > 0) {
            this.gsK = System.currentTimeMillis() - this.gsJ;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.gsG) && (parse = Uri.parse(n.this.gsG)) != null) {
                    try {
                        n.this.aog = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.gsI += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bYI != null) {
            this.bYI.start();
        }
        this.gsN = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsU);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsT);
        bjY();
        if (this.mStartTime > 0) {
            this.gsI += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bkj();
        this.gsN = false;
        if (this.bYI != null) {
            this.bYI.stop();
        }
        if (this.gsK > 0 && this.gsM != null) {
            ak akVar = new ak("c11685");
            akVar.ab("service_ip", this.aog);
            akVar.ab("video_url", this.gsG);
            akVar.f("video_size", this.gsM.bkz());
            akVar.s("video_duration", this.gsM.getDuration());
            akVar.ab("video_resolution", this.gsM.bkA());
            akVar.s("loading_count", this.gsL);
            akVar.f("user_watch_time", this.gsI / 1000);
            akVar.f("start_play_time", this.gsK);
            TiebaStatic.log(akVar);
        }
        if (this.gsM != null && this.gsK > 0) {
            x.a("stop_play", this.gsG, bkn(), (int) this.gsM.bkz(), this.gsM.getDuration());
        }
        this.gsK = 0L;
        this.gsI = 0L;
        this.gsL = 0;
        this.gsJ = 0L;
        this.mStartTime = 0L;
    }

    private void bkj() {
        if (this.gsI >= 0 && this.gsI < 86400000) {
            if (this.gsI > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.gsI);
                akVar.ab("obj_type", this.gsF);
                akVar.f("playduration", this.gsS);
                if (this.gsE != null) {
                    this.gsE.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.gsI, this.gsF, this.gsE, "", this.gsS);
            } else if (this.gsN) {
                l.a(this.gsI, this.gsF, this.gsE, "", this.gsS);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.gsI += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.gsI += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjR() {
        return t.hG(this.gsG) != null;
    }

    public void bkk() {
        this.gsH = true;
    }

    public void qV(String str) {
        this.gsF = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bjX() {
        return this.bYI;
    }

    public w bkl() {
        return this.gsM;
    }

    public void bkm() {
        if (!this.gsO) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsU);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.gsU, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tT(int i) {
        if (bkn()) {
            t.f(this.mContext, this.gsG, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gsT);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gsT, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bjY() {
        if (bkn()) {
            t.ad(this.mContext, this.gsG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkn() {
        return (this.gsH || this.bRe == null || this.bRe.equals(this.gsG)) ? false : true;
    }

    public void setVideoStatsData(aa aaVar) {
        this.gsE = aaVar;
    }

    public aa bko() {
        return this.gsE;
    }
}
