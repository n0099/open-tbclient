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
    private String aoj;
    private String bRm;
    private aa gsZ;
    private String gtb;
    private w gth;
    private boolean gti;
    private long gtn;
    private Context mContext;
    private String gta = "1";
    private boolean gtc = false;
    private long gtd = 0;
    private long gte = 0;
    private long mStartTime = 0;
    private long gtf = 0;
    private int gtg = 0;
    private boolean gtj = false;
    private boolean gtk = false;
    private int gtl = 8;
    private int gtm = 16;
    private Runnable gto = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gtj && n.this.gtk && n.this.bjT() && n.this.bko()) {
                t.f(n.this.mContext, n.this.gtb, -1);
            }
        }
    };
    private Runnable gtp = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bko()) {
                t.ab(n.this.mContext, n.this.gtb);
            } else if (!n.this.gtc) {
                t.hO(n.this.gtb);
            }
        }
    };
    private j.c gsa = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Wi() {
            n.g(n.this);
        }
    };
    private j bYQ = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gtg;
        nVar.gtg = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bYQ.a(this.gsa);
        this.gth = new w();
    }

    @Override // com.baidu.tieba.play.d
    public String hM(String str) {
        this.gtj = com.baidu.tbadk.coreExtra.model.f.Ih();
        this.gtk = com.baidu.tbadk.coreExtra.model.f.Ii();
        this.gtl = com.baidu.tbadk.coreExtra.model.f.Ij();
        this.gtm = com.baidu.tbadk.coreExtra.model.f.Ik();
        this.gtb = str;
        this.bRm = this.gtc ? this.gtb : t.V(str, this.gtj);
        if (this.gth != null) {
            x.a("start_play", this.gtb, bko(), (int) this.gth.bkA(), this.gth.getDuration());
        }
        this.gte = System.currentTimeMillis();
        return this.bRm;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjT() {
        return !StringUtils.isNull(this.bRm) && this.bRm.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjU() {
        return this.gtj;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjV() {
        return this.gtk;
    }

    @Override // com.baidu.tieba.play.d
    public int bjW() {
        return com.baidu.tbadk.coreExtra.model.f.Il() ? this.gtl : this.gtm;
    }

    @Override // com.baidu.tieba.play.d
    public String bjR() {
        return this.gtb;
    }

    @Override // com.baidu.tieba.play.d
    public void bjX() {
        if (this.gtj && this.gtk && bjT() && bko()) {
            t.f(this.mContext, this.gtb, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cL(long j) {
        this.gtn = j;
        bkn();
        if (this.gte > 0) {
            this.gtf = System.currentTimeMillis() - this.gte;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.gtb) && (parse = Uri.parse(n.this.gtb)) != null) {
                    try {
                        n.this.aoj = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.gtd += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bYQ != null) {
            this.bYQ.start();
        }
        this.gti = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtp);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gto);
        bjZ();
        if (this.mStartTime > 0) {
            this.gtd += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bkk();
        this.gti = false;
        if (this.bYQ != null) {
            this.bYQ.stop();
        }
        if (this.gtf > 0 && this.gth != null) {
            ak akVar = new ak("c11685");
            akVar.aa("service_ip", this.aoj);
            akVar.aa("video_url", this.gtb);
            akVar.f("video_size", this.gth.bkA());
            akVar.s("video_duration", this.gth.getDuration());
            akVar.aa("video_resolution", this.gth.bkB());
            akVar.s("loading_count", this.gtg);
            akVar.f("user_watch_time", this.gtd / 1000);
            akVar.f("start_play_time", this.gtf);
            TiebaStatic.log(akVar);
        }
        if (this.gth != null && this.gtf > 0) {
            x.a("stop_play", this.gtb, bko(), (int) this.gth.bkA(), this.gth.getDuration());
        }
        this.gtf = 0L;
        this.gtd = 0L;
        this.gtg = 0;
        this.gte = 0L;
        this.mStartTime = 0L;
    }

    private void bkk() {
        if (this.gtd >= 0 && this.gtd < 86400000) {
            if (this.gtd > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.gtd);
                akVar.aa("obj_type", this.gta);
                akVar.f("playduration", this.gtn);
                if (this.gsZ != null) {
                    this.gsZ.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.gtd, this.gta, this.gsZ, "", this.gtn);
            } else if (this.gti) {
                l.a(this.gtd, this.gta, this.gsZ, "", this.gtn);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.gtd += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.gtd += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean bjS() {
        return t.hN(this.gtb) != null;
    }

    public void bkl() {
        this.gtc = true;
    }

    public void rc(String str) {
        this.gta = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bjY() {
        return this.bYQ;
    }

    public w bkm() {
        return this.gth;
    }

    public void bkn() {
        if (!this.gtj) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtp);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.gtp, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tT(int i) {
        if (bko()) {
            t.f(this.mContext, this.gtb, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gto);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gto, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bjZ() {
        if (bko()) {
            t.ac(this.mContext, this.gtb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bko() {
        return (this.gtc || this.bRm == null || this.bRm.equals(this.gtb)) ? false : true;
    }

    public void setVideoStatsData(aa aaVar) {
        this.gsZ = aaVar;
    }

    public aa bkp() {
        return this.gsZ;
    }
}
