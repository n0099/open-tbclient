package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String HR;
    private String akL;
    private z hXD;
    private String hXF;
    private v hXK;
    private com.baidu.tieba.video.b hXL;
    private boolean hXM;
    private long hXR;
    private Context mContext;
    private String hXE = "1";
    private boolean hXG = false;
    private long feV = 0;
    private long hXH = 0;
    private long mStartTime = 0;
    private long hXI = 0;
    private int hXJ = 0;
    private boolean hXN = false;
    private boolean hXO = false;
    private int hXP = 8;
    private int hXQ = 16;
    private Runnable hXS = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.hXN && n.this.hXO && n.this.bTa() && n.this.bTy()) {
                t.g(n.this.mContext, n.this.hXF, -1);
            }
        }
    };
    private Runnable hXT = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bTy()) {
                t.aE(n.this.mContext, n.this.hXF);
            } else if (!n.this.hXG) {
                t.qE(n.this.hXF);
            }
        }
    };
    private j.c hWr = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aBn() {
            n.g(n.this);
        }
    };
    private j dbh = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.hXJ;
        nVar.hXJ = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dbh.a(this.hWr);
        this.hXK = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String qC(String str) {
        this.hXN = com.baidu.tbadk.coreExtra.model.f.ajJ();
        this.hXO = com.baidu.tbadk.coreExtra.model.f.ajK();
        this.hXP = com.baidu.tbadk.coreExtra.model.f.ajL();
        this.hXQ = com.baidu.tbadk.coreExtra.model.f.ajM();
        this.hXF = str;
        this.akL = this.hXG ? this.hXF : t.ap(str, this.hXN);
        if (this.hXK != null) {
            w.a("start_play", this.hXF, bTy(), (int) this.hXK.bTK(), this.hXK.getDuration());
        }
        this.hXH = System.currentTimeMillis();
        return this.akL;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTa() {
        return !StringUtils.isNull(this.akL) && this.akL.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTb() {
        return this.hXN;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTc() {
        return this.hXO;
    }

    @Override // com.baidu.tieba.play.d
    public int bTd() {
        return com.baidu.tbadk.coreExtra.model.f.ajN() ? this.hXP : this.hXQ;
    }

    @Override // com.baidu.tieba.play.d
    public String bSY() {
        return this.hXF;
    }

    @Override // com.baidu.tieba.play.d
    public void bTe() {
        if (this.hXN && this.hXO && bTa() && bTy()) {
            t.g(this.mContext, this.hXF, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dI(long j) {
        this.hXR = j;
        bTx();
        if (this.hXH > 0) {
            this.hXI = System.currentTimeMillis() - this.hXH;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.hXF) && (parse = Uri.parse(n.this.hXF)) != null) {
                    try {
                        n.this.HR = InetAddress.getByName(parse.getHost()).getHostAddress();
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(2);
        bdAsyncTask.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.d
    public void onStart() {
        if (this.mStartTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feV += currentTimeMillis;
            dJ(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dbh != null) {
            this.dbh.start();
        }
        this.hXM = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXT);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXS);
        bTg();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feV += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTu();
        if (this.dbh != null) {
            this.dbh.stop();
        }
        if (this.hXI > 0 && this.hXK != null) {
            am amVar = new am("c11685");
            amVar.bJ("service_ip", this.HR);
            amVar.bJ(WebVideoActivityConfig.KEY_VIDEO_URL, this.hXF);
            amVar.k("video_size", this.hXK.bTK());
            amVar.T(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.hXK.getDuration());
            amVar.bJ("video_resolution", this.hXK.bTL());
            amVar.T("loading_count", this.hXJ);
            amVar.k("user_watch_time", this.feV / 1000);
            amVar.k("start_play_time", this.hXI);
            TiebaStatic.log(amVar);
        }
        if (this.hXK != null && this.hXI > 0) {
            w.a("stop_play", this.hXF, bTy(), (int) this.hXK.bTK(), this.hXK.getDuration());
        }
        bTt();
        this.hXI = 0L;
        this.feV = 0L;
        this.hXJ = 0;
        this.hXH = 0L;
        this.mStartTime = 0L;
        this.hXM = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.hXL = bVar;
    }

    private void dJ(long j) {
        if (this.hXL != null) {
            this.hXL.setVideoWatchDuration(this.hXL.getVideoWatchDuration() + j);
        }
    }

    private void bTt() {
        if (this.hXL != null && this.hXM) {
            TbSingleton.getInstance().putVideoRecord(this.hXL.getThreadId(), (int) (this.hXL.getVideoWatchDuration() / 1000));
        }
    }

    private void bTu() {
        if (this.feV >= 0 && this.feV < 86400000) {
            if (this.feV > 0) {
                am amVar = new am("c11244");
                amVar.k("obj_duration", this.feV);
                amVar.bJ("obj_type", this.hXE);
                amVar.k("playduration", this.hXR);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bJ("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.hXD != null) {
                    this.hXD.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.feV, this.hXE, this.hXD, "", this.hXR);
            } else if (this.hXM) {
                l.a(this.feV, this.hXE, this.hXD, "", this.hXR);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feV += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTt();
        this.hXM = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feV += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTt();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bSZ() {
        return t.qD(this.hXF) != null;
    }

    public void bTv() {
        this.hXG = true;
    }

    public void AS(String str) {
        this.hXE = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bTf() {
        return this.dbh;
    }

    public void a(j.b bVar) {
        if (this.dbh != null) {
            this.dbh.a(bVar);
        }
    }

    public v bTw() {
        return this.hXK;
    }

    public void bTx() {
        if (!this.hXN) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXT);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXT, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void xn(int i) {
        if (bTy()) {
            t.g(this.mContext, this.hXF, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXS);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXS, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bTg() {
        if (bTy()) {
            t.aF(this.mContext, this.hXF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTy() {
        return (this.hXG || this.akL == null || this.akL.equals(this.hXF)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.hXD = zVar;
    }

    public z bTz() {
        return this.hXD;
    }
}
