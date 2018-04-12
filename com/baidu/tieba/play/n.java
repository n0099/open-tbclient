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
    private u fPE;
    private boolean fPF;
    private long fPK;
    private y fPw;
    private String fPy;
    private Context mContext;
    private String yF;
    private String fPx = "1";
    private boolean fPz = false;
    private long fPA = 0;
    private long fPB = 0;
    private long mStartTime = 0;
    private long fPC = 0;
    private int fPD = 0;
    private boolean fPG = false;
    private boolean fPH = false;
    private int fPI = 8;
    private int fPJ = 16;
    private Runnable fPL = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.fPG && n.this.fPH && n.this.bgm() && n.this.bgH()) {
                s.e(n.this.mContext, n.this.fPy, -1);
            }
        }
    };
    private Runnable fPM = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bgH()) {
                s.Y(n.this.mContext, n.this.fPy);
            } else if (!n.this.fPz) {
                s.hR(n.this.fPy);
            }
        }
    };
    private j.c fOx = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Pz() {
            n.g(n.this);
        }
    };
    private j bkQ = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.fPD;
        nVar.fPD = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bkQ.a(this.fOx);
        this.fPE = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String hP(String str) {
        this.fPG = com.baidu.tbadk.coreExtra.model.f.BB();
        this.fPH = com.baidu.tbadk.coreExtra.model.f.BC();
        this.fPI = com.baidu.tbadk.coreExtra.model.f.BD();
        this.fPJ = com.baidu.tbadk.coreExtra.model.f.BE();
        this.fPy = str;
        this.bdl = this.fPz ? this.fPy : s.P(str, this.fPG);
        if (this.fPE != null) {
            v.a("start_play", this.fPy, bgH(), (int) this.fPE.bgT(), this.fPE.getDuration());
        }
        this.fPB = System.currentTimeMillis();
        return this.bdl;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgm() {
        return !StringUtils.isNull(this.bdl) && this.bdl.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgn() {
        return this.fPG;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgo() {
        return this.fPH;
    }

    @Override // com.baidu.tieba.play.d
    public int bgp() {
        return com.baidu.tbadk.coreExtra.model.f.BF() ? this.fPI : this.fPJ;
    }

    @Override // com.baidu.tieba.play.d
    public String bgk() {
        return this.fPy;
    }

    @Override // com.baidu.tieba.play.d
    public void bgq() {
        if (this.fPG && this.fPH && bgm() && bgH()) {
            s.e(this.mContext, this.fPy, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cO(long j) {
        this.fPK = j;
        bgG();
        if (this.fPB > 0) {
            this.fPC = System.currentTimeMillis() - this.fPB;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!an.isEmpty(n.this.fPy) && (parse = Uri.parse(n.this.fPy)) != null) {
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
            this.fPA += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bkQ != null) {
            this.bkQ.start();
        }
        this.fPF = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPM);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPL);
        bgs();
        if (this.mStartTime > 0) {
            this.fPA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bgD();
        this.fPF = false;
        if (this.bkQ != null) {
            this.bkQ.stop();
        }
        if (this.fPC > 0 && this.fPE != null) {
            al alVar = new al("c11685");
            alVar.ac("service_ip", this.yF);
            alVar.ac(WebVideoActivityConfig.KEY_VIDEO_URL, this.fPy);
            alVar.f("video_size", this.fPE.bgT());
            alVar.r(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.fPE.getDuration());
            alVar.ac("video_resolution", this.fPE.bgU());
            alVar.r("loading_count", this.fPD);
            alVar.f("user_watch_time", this.fPA / 1000);
            alVar.f("start_play_time", this.fPC);
            TiebaStatic.log(alVar);
        }
        if (this.fPE != null && this.fPC > 0) {
            v.a("stop_play", this.fPy, bgH(), (int) this.fPE.bgT(), this.fPE.getDuration());
        }
        this.fPC = 0L;
        this.fPA = 0L;
        this.fPD = 0;
        this.fPB = 0L;
        this.mStartTime = 0L;
    }

    private void bgD() {
        if (this.fPA >= 0 && this.fPA < 86400000) {
            if (this.fPA > 0) {
                al alVar = new al("c11244");
                alVar.f("obj_duration", this.fPA);
                alVar.ac("obj_type", this.fPx);
                alVar.f("playduration", this.fPK);
                if (this.fPw != null) {
                    this.fPw.b(alVar);
                }
                TiebaStatic.log(alVar);
                l.a(this.fPA, this.fPx, this.fPw, "", this.fPK);
            } else if (this.fPF) {
                l.a(this.fPA, this.fPx, this.fPw, "", this.fPK);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fPA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fPA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean bgl() {
        return s.hQ(this.fPy) != null;
    }

    public void bgE() {
        this.fPz = true;
    }

    public void rp(String str) {
        this.fPx = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bgr() {
        return this.bkQ;
    }

    public u bgF() {
        return this.fPE;
    }

    public void bgG() {
        if (!this.fPG) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPM);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fPM, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void rq(int i) {
        if (bgH()) {
            s.e(this.mContext, this.fPy, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPL);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fPL, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bgs() {
        if (bgH()) {
            s.Z(this.mContext, this.fPy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgH() {
        return (this.fPz || this.bdl == null || this.bdl.equals(this.fPy)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.fPw = yVar;
    }

    public y bgI() {
        return this.fPw;
    }
}
