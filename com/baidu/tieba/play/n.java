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
    private String bdl;
    private u fPB;
    private boolean fPC;
    private long fPH;
    private y fPt;
    private String fPv;
    private Context mContext;
    private String yF;
    private String fPu = "1";
    private boolean fPw = false;
    private long fPx = 0;
    private long fPy = 0;
    private long mStartTime = 0;
    private long fPz = 0;
    private int fPA = 0;
    private boolean fPD = false;
    private boolean fPE = false;
    private int fPF = 8;
    private int fPG = 16;
    private Runnable fPI = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.fPD && n.this.fPE && n.this.bgm() && n.this.bgH()) {
                s.e(n.this.mContext, n.this.fPv, -1);
            }
        }
    };
    private Runnable fPJ = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bgH()) {
                s.Y(n.this.mContext, n.this.fPv);
            } else if (!n.this.fPw) {
                s.hR(n.this.fPv);
            }
        }
    };
    private j.c fOu = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Pz() {
            n.g(n.this);
        }
    };
    private j bkQ = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.fPA;
        nVar.fPA = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bkQ.a(this.fOu);
        this.fPB = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String hP(String str) {
        this.fPD = com.baidu.tbadk.coreExtra.model.f.BB();
        this.fPE = com.baidu.tbadk.coreExtra.model.f.BC();
        this.fPF = com.baidu.tbadk.coreExtra.model.f.BD();
        this.fPG = com.baidu.tbadk.coreExtra.model.f.BE();
        this.fPv = str;
        this.bdl = this.fPw ? this.fPv : s.P(str, this.fPD);
        if (this.fPB != null) {
            v.a("start_play", this.fPv, bgH(), (int) this.fPB.bgT(), this.fPB.getDuration());
        }
        this.fPy = System.currentTimeMillis();
        return this.bdl;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgm() {
        return !StringUtils.isNull(this.bdl) && this.bdl.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgn() {
        return this.fPD;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgo() {
        return this.fPE;
    }

    @Override // com.baidu.tieba.play.d
    public int bgp() {
        return com.baidu.tbadk.coreExtra.model.f.BF() ? this.fPF : this.fPG;
    }

    @Override // com.baidu.tieba.play.d
    public String bgk() {
        return this.fPv;
    }

    @Override // com.baidu.tieba.play.d
    public void bgq() {
        if (this.fPD && this.fPE && bgm() && bgH()) {
            s.e(this.mContext, this.fPv, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cO(long j) {
        this.fPH = j;
        bgG();
        if (this.fPy > 0) {
            this.fPz = System.currentTimeMillis() - this.fPy;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!an.isEmpty(n.this.fPv) && (parse = Uri.parse(n.this.fPv)) != null) {
                    try {
                        n.this.yF = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fPx += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bkQ != null) {
            this.bkQ.start();
        }
        this.fPC = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPJ);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPI);
        bgs();
        if (this.mStartTime > 0) {
            this.fPx += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bgD();
        this.fPC = false;
        if (this.bkQ != null) {
            this.bkQ.stop();
        }
        if (this.fPz > 0 && this.fPB != null) {
            al alVar = new al("c11685");
            alVar.ac("service_ip", this.yF);
            alVar.ac(WebVideoActivityConfig.KEY_VIDEO_URL, this.fPv);
            alVar.f("video_size", this.fPB.bgT());
            alVar.r(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.fPB.getDuration());
            alVar.ac("video_resolution", this.fPB.bgU());
            alVar.r("loading_count", this.fPA);
            alVar.f("user_watch_time", this.fPx / 1000);
            alVar.f("start_play_time", this.fPz);
            TiebaStatic.log(alVar);
        }
        if (this.fPB != null && this.fPz > 0) {
            v.a("stop_play", this.fPv, bgH(), (int) this.fPB.bgT(), this.fPB.getDuration());
        }
        this.fPz = 0L;
        this.fPx = 0L;
        this.fPA = 0;
        this.fPy = 0L;
        this.mStartTime = 0L;
    }

    private void bgD() {
        if (this.fPx >= 0 && this.fPx < 86400000) {
            if (this.fPx > 0) {
                al alVar = new al("c11244");
                alVar.f("obj_duration", this.fPx);
                alVar.ac("obj_type", this.fPu);
                alVar.f("playduration", this.fPH);
                if (this.fPt != null) {
                    this.fPt.b(alVar);
                }
                TiebaStatic.log(alVar);
                l.a(this.fPx, this.fPu, this.fPt, "", this.fPH);
            } else if (this.fPC) {
                l.a(this.fPx, this.fPu, this.fPt, "", this.fPH);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fPx += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fPx += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgl() {
        return s.hQ(this.fPv) != null;
    }

    public void bgE() {
        this.fPw = true;
    }

    public void rp(String str) {
        this.fPu = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bgr() {
        return this.bkQ;
    }

    public u bgF() {
        return this.fPB;
    }

    public void bgG() {
        if (!this.fPD) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPJ);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fPJ, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void rp(int i) {
        if (bgH()) {
            s.e(this.mContext, this.fPv, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPI);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fPI, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bgs() {
        if (bgH()) {
            s.Z(this.mContext, this.fPv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgH() {
        return (this.fPw || this.bdl == null || this.bdl.equals(this.fPv)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.fPt = yVar;
    }

    public y bgI() {
        return this.fPt;
    }
}
