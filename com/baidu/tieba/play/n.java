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
    private String bdg;
    private y fPD;
    private String fPF;
    private v fPL;
    private boolean fPM;
    private Context mContext;
    private String zY;
    private String fPE = "1";
    private boolean fPG = false;
    private long fPH = 0;
    private long fPI = 0;
    private long mStartTime = 0;
    private long fPJ = 0;
    private int fPK = 0;
    private boolean fPN = false;
    private boolean fPO = false;
    private int fPP = 8;
    private int fPQ = 16;
    private Runnable fPR = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.fPN && n.this.fPO && n.this.biW() && n.this.bjr()) {
                s.f(n.this.mContext, n.this.fPF, -1);
            }
        }
    };
    private Runnable fPS = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bjr()) {
                s.ab(n.this.mContext, n.this.fPF);
            } else if (!n.this.fPG) {
                s.hG(n.this.fPF);
            }
        }
    };
    private j.c fOz = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void OT() {
            n.g(n.this);
        }
    };
    private j bll = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.fPK;
        nVar.fPK = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bll.a(this.fOz);
        this.fPL = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String hE(String str) {
        this.fPN = com.baidu.tbadk.coreExtra.model.f.AJ();
        this.fPO = com.baidu.tbadk.coreExtra.model.f.AK();
        this.fPP = com.baidu.tbadk.coreExtra.model.f.AL();
        this.fPQ = com.baidu.tbadk.coreExtra.model.f.AM();
        this.fPF = str;
        this.bdg = this.fPG ? this.fPF : s.T(str, this.fPN);
        if (this.fPL != null) {
            w.a("start_play", this.fPF, bjr(), (int) this.fPL.bjA(), this.fPL.getDuration());
        }
        this.fPI = System.currentTimeMillis();
        return this.bdg;
    }

    @Override // com.baidu.tieba.play.d
    public boolean biW() {
        return !StringUtils.isNull(this.bdg) && this.bdg.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean biX() {
        return this.fPN;
    }

    @Override // com.baidu.tieba.play.d
    public boolean biY() {
        return this.fPO;
    }

    @Override // com.baidu.tieba.play.d
    public int biZ() {
        return com.baidu.tbadk.coreExtra.model.f.AN() ? this.fPP : this.fPQ;
    }

    @Override // com.baidu.tieba.play.d
    public String biV() {
        return this.fPF;
    }

    @Override // com.baidu.tieba.play.d
    public void bja() {
        if (this.fPN && this.fPO && biW() && bjr()) {
            s.f(this.mContext, this.fPF, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPrepared() {
        bjj();
        if (this.fPI > 0) {
            this.fPJ = System.currentTimeMillis() - this.fPI;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fPF) && (parse = Uri.parse(n.this.fPF)) != null) {
                    try {
                        n.this.zY = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fPH += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bll != null) {
            this.bll.start();
        }
        this.fPM = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPS);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPR);
        if (bjr()) {
            s.ac(this.mContext, this.fPF);
        }
        if (this.mStartTime > 0) {
            this.fPH += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fPH >= 0 && this.fPH < 86400000) {
            if (this.fPH > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fPH);
                akVar.ac("obj_type", this.fPE);
                if (this.fPD != null) {
                    this.fPD.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fPH, this.fPE, this.fPD, "");
            } else if (this.fPM) {
                l.a(this.fPH, this.fPE, this.fPD, "");
            }
        }
        this.fPM = false;
        if (this.bll != null) {
            this.bll.stop();
        }
        if (this.fPJ > 0 && this.fPL != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ac("service_ip", this.zY);
            akVar2.ac("video_url", this.fPF);
            akVar2.f("video_size", this.fPL.bjA());
            akVar2.r("video_duration", this.fPL.getDuration());
            akVar2.ac("video_resolution", this.fPL.bjB());
            akVar2.r("loading_count", this.fPK);
            akVar2.f("user_watch_time", this.fPH / 1000);
            akVar2.f("start_play_time", this.fPJ);
            TiebaStatic.log(akVar2);
        }
        if (this.fPL != null && this.fPJ > 0) {
            w.a("stop_play", this.fPF, bjr(), (int) this.fPL.bjA(), this.fPL.getDuration());
        }
        this.fPJ = 0L;
        this.fPH = 0L;
        this.fPK = 0;
        this.fPI = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fPH += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fPH += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bjo() {
        return s.hF(this.fPF) != null;
    }

    public void bjp() {
        this.fPG = true;
    }

    public void rq(String str) {
        this.fPE = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.bll;
    }

    public v bjq() {
        return this.fPL;
    }

    public void bjj() {
        if (!this.fPN) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPS);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.fPS, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void bjb() {
        if (!this.fPN) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPS);
            com.baidu.adp.lib.g.e.fP().post(this.fPS);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void sq(int i) {
        if (bjr()) {
            s.f(this.mContext, this.fPF, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPR);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fPR, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjr() {
        return (this.fPG || this.bdg == null || this.bdg.equals(this.fPF)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.fPD = yVar;
    }

    public y bjs() {
        return this.fPD;
    }
}
