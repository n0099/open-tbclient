package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String EM;
    private String blw;
    private y gbL;
    private String gbN;
    private u gbT;
    private boolean gbU;
    private long gbZ;
    private Context mContext;
    private String gbM = "1";
    private boolean gbO = false;
    private long gbP = 0;
    private long gbQ = 0;
    private long mStartTime = 0;
    private long gbR = 0;
    private int gbS = 0;
    private boolean gbV = false;
    private boolean gbW = false;
    private int gbX = 8;
    private int gbY = 16;
    private Runnable gca = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gbV && n.this.gbW && n.this.blk() && n.this.blF()) {
                s.e(n.this.mContext, n.this.gbN, -1);
            }
        }
    };
    private Runnable gcb = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.blF()) {
                s.aa(n.this.mContext, n.this.gbN);
            } else if (!n.this.gbO) {
                s.ir(n.this.gbN);
            }
        }
    };
    private j.c gaM = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void SU() {
            n.g(n.this);
        }
    };
    private j btj = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gbS;
        nVar.gbS = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.btj.a(this.gaM);
        this.gbT = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String ip(String str) {
        this.gbV = com.baidu.tbadk.coreExtra.model.f.Fa();
        this.gbW = com.baidu.tbadk.coreExtra.model.f.Fb();
        this.gbX = com.baidu.tbadk.coreExtra.model.f.Fc();
        this.gbY = com.baidu.tbadk.coreExtra.model.f.Fd();
        this.gbN = str;
        this.blw = this.gbO ? this.gbN : s.P(str, this.gbV);
        if (this.gbT != null) {
            v.a("start_play", this.gbN, blF(), (int) this.gbT.blR(), this.gbT.getDuration());
        }
        this.gbQ = System.currentTimeMillis();
        return this.blw;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blk() {
        return !StringUtils.isNull(this.blw) && this.blw.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bll() {
        return this.gbV;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blm() {
        return this.gbW;
    }

    @Override // com.baidu.tieba.play.d
    public int bln() {
        return com.baidu.tbadk.coreExtra.model.f.Fe() ? this.gbX : this.gbY;
    }

    @Override // com.baidu.tieba.play.d
    public String bli() {
        return this.gbN;
    }

    @Override // com.baidu.tieba.play.d
    public void blo() {
        if (this.gbV && this.gbW && blk() && blF()) {
            s.e(this.mContext, this.gbN, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cU(long j) {
        this.gbZ = j;
        blE();
        if (this.gbQ > 0) {
            this.gbR = System.currentTimeMillis() - this.gbQ;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gbN) && (parse = Uri.parse(n.this.gbN)) != null) {
                    try {
                        n.this.EM = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.gbP += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.btj != null) {
            this.btj.start();
        }
        this.gbU = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gcb);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gca);
        blq();
        if (this.mStartTime > 0) {
            this.gbP += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        blB();
        this.gbU = false;
        if (this.btj != null) {
            this.btj.stop();
        }
        if (this.gbR > 0 && this.gbT != null) {
            am amVar = new am("c11685");
            amVar.ah("service_ip", this.EM);
            amVar.ah(WebVideoActivityConfig.KEY_VIDEO_URL, this.gbN);
            amVar.f("video_size", this.gbT.blR());
            amVar.r(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gbT.getDuration());
            amVar.ah("video_resolution", this.gbT.blS());
            amVar.r("loading_count", this.gbS);
            amVar.f("user_watch_time", this.gbP / 1000);
            amVar.f("start_play_time", this.gbR);
            TiebaStatic.log(amVar);
        }
        if (this.gbT != null && this.gbR > 0) {
            v.a("stop_play", this.gbN, blF(), (int) this.gbT.blR(), this.gbT.getDuration());
        }
        this.gbR = 0L;
        this.gbP = 0L;
        this.gbS = 0;
        this.gbQ = 0L;
        this.mStartTime = 0L;
    }

    private void blB() {
        if (this.gbP >= 0 && this.gbP < 86400000) {
            if (this.gbP > 0) {
                am amVar = new am("c11244");
                amVar.f("obj_duration", this.gbP);
                amVar.ah("obj_type", this.gbM);
                amVar.f("playduration", this.gbZ);
                if (this.gbL != null) {
                    this.gbL.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.gbP, this.gbM, this.gbL, "", this.gbZ);
            } else if (this.gbU) {
                l.a(this.gbP, this.gbM, this.gbL, "", this.gbZ);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.gbP += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.gbP += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean blj() {
        return s.iq(this.gbN) != null;
    }

    public void blC() {
        this.gbO = true;
    }

    public void sj(String str) {
        this.gbM = str;
    }

    @Override // com.baidu.tieba.play.d
    public j blp() {
        return this.btj;
    }

    public u blD() {
        return this.gbT;
    }

    public void blE() {
        if (!this.gbV) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gcb);
            com.baidu.adp.lib.g.e.im().postDelayed(this.gcb, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void rA(int i) {
        if (blF()) {
            s.e(this.mContext, this.gbN, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gca);
        com.baidu.adp.lib.g.e.im().postDelayed(this.gca, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void blq() {
        if (blF()) {
            s.ab(this.mContext, this.gbN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blF() {
        return (this.gbO || this.blw == null || this.blw.equals(this.gbN)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.gbL = yVar;
    }

    public y blG() {
        return this.gbL;
    }
}
