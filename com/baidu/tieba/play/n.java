package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String bdm;
    private String fQB;
    private u fQH;
    private boolean fQI;
    private long fQN;
    private y fQz;
    private Context mContext;
    private String yE;
    private String fQA = "1";
    private boolean fQC = false;
    private long fQD = 0;
    private long fQE = 0;
    private long mStartTime = 0;
    private long fQF = 0;
    private int fQG = 0;
    private boolean fQJ = false;
    private boolean fQK = false;
    private int fQL = 8;
    private int fQM = 16;
    private Runnable fQO = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.fQJ && n.this.fQK && n.this.bgm() && n.this.bgH()) {
                s.e(n.this.mContext, n.this.fQB, -1);
            }
        }
    };
    private Runnable fQP = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bgH()) {
                s.Y(n.this.mContext, n.this.fQB);
            } else if (!n.this.fQC) {
                s.hS(n.this.fQB);
            }
        }
    };
    private j.c fPA = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Pw() {
            n.g(n.this);
        }
    };
    private j blf = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.fQG;
        nVar.fQG = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.blf.a(this.fPA);
        this.fQH = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String hQ(String str) {
        this.fQJ = com.baidu.tbadk.coreExtra.model.f.Bz();
        this.fQK = com.baidu.tbadk.coreExtra.model.f.BA();
        this.fQL = com.baidu.tbadk.coreExtra.model.f.BB();
        this.fQM = com.baidu.tbadk.coreExtra.model.f.BC();
        this.fQB = str;
        this.bdm = this.fQC ? this.fQB : s.P(str, this.fQJ);
        if (this.fQH != null) {
            v.a("start_play", this.fQB, bgH(), (int) this.fQH.bgT(), this.fQH.getDuration());
        }
        this.fQE = System.currentTimeMillis();
        return this.bdm;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgm() {
        return !StringUtils.isNull(this.bdm) && this.bdm.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgn() {
        return this.fQJ;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgo() {
        return this.fQK;
    }

    @Override // com.baidu.tieba.play.d
    public int bgp() {
        return com.baidu.tbadk.coreExtra.model.f.BD() ? this.fQL : this.fQM;
    }

    @Override // com.baidu.tieba.play.d
    public String bgk() {
        return this.fQB;
    }

    @Override // com.baidu.tieba.play.d
    public void bgq() {
        if (this.fQJ && this.fQK && bgm() && bgH()) {
            s.e(this.mContext, this.fQB, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cO(long j) {
        this.fQN = j;
        bgG();
        if (this.fQE > 0) {
            this.fQF = System.currentTimeMillis() - this.fQE;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!an.isEmpty(n.this.fQB) && (parse = Uri.parse(n.this.fQB)) != null) {
                    try {
                        n.this.yE = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fQD += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.blf != null) {
            this.blf.start();
        }
        this.fQI = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQP);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQO);
        bgs();
        if (this.mStartTime > 0) {
            this.fQD += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bgD();
        this.fQI = false;
        if (this.blf != null) {
            this.blf.stop();
        }
        if (this.fQF > 0 && this.fQH != null) {
            al alVar = new al("c11685");
            alVar.ac("service_ip", this.yE);
            alVar.ac(WebVideoActivityConfig.KEY_VIDEO_URL, this.fQB);
            alVar.f("video_size", this.fQH.bgT());
            alVar.r(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.fQH.getDuration());
            alVar.ac("video_resolution", this.fQH.bgU());
            alVar.r("loading_count", this.fQG);
            alVar.f("user_watch_time", this.fQD / 1000);
            alVar.f("start_play_time", this.fQF);
            TiebaStatic.log(alVar);
        }
        if (this.fQH != null && this.fQF > 0) {
            v.a("stop_play", this.fQB, bgH(), (int) this.fQH.bgT(), this.fQH.getDuration());
        }
        this.fQF = 0L;
        this.fQD = 0L;
        this.fQG = 0;
        this.fQE = 0L;
        this.mStartTime = 0L;
    }

    private void bgD() {
        if (this.fQD >= 0 && this.fQD < 86400000) {
            if (this.fQD > 0) {
                al alVar = new al("c11244");
                alVar.f("obj_duration", this.fQD);
                alVar.ac("obj_type", this.fQA);
                alVar.f("playduration", this.fQN);
                if (this.fQz != null) {
                    this.fQz.b(alVar);
                }
                TiebaStatic.log(alVar);
                l.a(this.fQD, this.fQA, this.fQz, "", this.fQN);
            } else if (this.fQI) {
                l.a(this.fQD, this.fQA, this.fQz, "", this.fQN);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fQD += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fQD += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgl() {
        return s.hR(this.fQB) != null;
    }

    public void bgE() {
        this.fQC = true;
    }

    public void rs(String str) {
        this.fQA = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bgr() {
        return this.blf;
    }

    public u bgF() {
        return this.fQH;
    }

    public void bgG() {
        if (!this.fQJ) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQP);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fQP, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ro(int i) {
        if (bgH()) {
            s.e(this.mContext, this.fQB, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQO);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fQO, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bgs() {
        if (bgH()) {
            s.Z(this.mContext, this.fQB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgH() {
        return (this.fQC || this.bdm == null || this.bdm.equals(this.fQB)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.fQz = yVar;
    }

    public y bgI() {
        return this.fQz;
    }
}
