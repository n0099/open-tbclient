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
    private z hXE;
    private String hXG;
    private v hXL;
    private com.baidu.tieba.video.b hXM;
    private boolean hXN;
    private long hXS;
    private Context mContext;
    private String hXF = "1";
    private boolean hXH = false;
    private long feV = 0;
    private long hXI = 0;
    private long mStartTime = 0;
    private long hXJ = 0;
    private int hXK = 0;
    private boolean hXO = false;
    private boolean hXP = false;
    private int hXQ = 8;
    private int hXR = 16;
    private Runnable hXT = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.hXO && n.this.hXP && n.this.bTb() && n.this.bTz()) {
                t.g(n.this.mContext, n.this.hXG, -1);
            }
        }
    };
    private Runnable hXU = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bTz()) {
                t.aE(n.this.mContext, n.this.hXG);
            } else if (!n.this.hXH) {
                t.qF(n.this.hXG);
            }
        }
    };
    private j.c hWs = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aBo() {
            n.g(n.this);
        }
    };
    private j dbh = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.hXK;
        nVar.hXK = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dbh.a(this.hWs);
        this.hXL = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String qD(String str) {
        this.hXO = com.baidu.tbadk.coreExtra.model.f.ajJ();
        this.hXP = com.baidu.tbadk.coreExtra.model.f.ajK();
        this.hXQ = com.baidu.tbadk.coreExtra.model.f.ajL();
        this.hXR = com.baidu.tbadk.coreExtra.model.f.ajM();
        this.hXG = str;
        this.akL = this.hXH ? this.hXG : t.aq(str, this.hXO);
        if (this.hXL != null) {
            w.a("start_play", this.hXG, bTz(), (int) this.hXL.bTL(), this.hXL.getDuration());
        }
        this.hXI = System.currentTimeMillis();
        return this.akL;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTb() {
        return !StringUtils.isNull(this.akL) && this.akL.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTc() {
        return this.hXO;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTd() {
        return this.hXP;
    }

    @Override // com.baidu.tieba.play.d
    public int bTe() {
        return com.baidu.tbadk.coreExtra.model.f.ajN() ? this.hXQ : this.hXR;
    }

    @Override // com.baidu.tieba.play.d
    public String bSZ() {
        return this.hXG;
    }

    @Override // com.baidu.tieba.play.d
    public void bTf() {
        if (this.hXO && this.hXP && bTb() && bTz()) {
            t.g(this.mContext, this.hXG, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dI(long j) {
        this.hXS = j;
        bTy();
        if (this.hXI > 0) {
            this.hXJ = System.currentTimeMillis() - this.hXI;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.hXG) && (parse = Uri.parse(n.this.hXG)) != null) {
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
        this.hXN = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXU);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXT);
        bTh();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feV += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTv();
        if (this.dbh != null) {
            this.dbh.stop();
        }
        if (this.hXJ > 0 && this.hXL != null) {
            am amVar = new am("c11685");
            amVar.bJ("service_ip", this.HR);
            amVar.bJ(WebVideoActivityConfig.KEY_VIDEO_URL, this.hXG);
            amVar.k("video_size", this.hXL.bTL());
            amVar.T(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.hXL.getDuration());
            amVar.bJ("video_resolution", this.hXL.bTM());
            amVar.T("loading_count", this.hXK);
            amVar.k("user_watch_time", this.feV / 1000);
            amVar.k("start_play_time", this.hXJ);
            TiebaStatic.log(amVar);
        }
        if (this.hXL != null && this.hXJ > 0) {
            w.a("stop_play", this.hXG, bTz(), (int) this.hXL.bTL(), this.hXL.getDuration());
        }
        bTu();
        this.hXJ = 0L;
        this.feV = 0L;
        this.hXK = 0;
        this.hXI = 0L;
        this.mStartTime = 0L;
        this.hXN = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.hXM = bVar;
    }

    private void dJ(long j) {
        if (this.hXM != null) {
            this.hXM.setVideoWatchDuration(this.hXM.getVideoWatchDuration() + j);
        }
    }

    private void bTu() {
        if (this.hXM != null && this.hXN) {
            TbSingleton.getInstance().putVideoRecord(this.hXM.getThreadId(), (int) (this.hXM.getVideoWatchDuration() / 1000));
        }
    }

    private void bTv() {
        if (this.feV >= 0 && this.feV < 86400000) {
            if (this.feV > 0) {
                am amVar = new am("c11244");
                amVar.k("obj_duration", this.feV);
                amVar.bJ("obj_type", this.hXF);
                amVar.k("playduration", this.hXS);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bJ("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.hXE != null) {
                    this.hXE.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.feV, this.hXF, this.hXE, "", this.hXS);
            } else if (this.hXN) {
                l.a(this.feV, this.hXF, this.hXE, "", this.hXS);
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
        bTu();
        this.hXN = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feV += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTu();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTa() {
        return t.qE(this.hXG) != null;
    }

    public void bTw() {
        this.hXH = true;
    }

    public void AT(String str) {
        this.hXF = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bTg() {
        return this.dbh;
    }

    public void a(j.b bVar) {
        if (this.dbh != null) {
            this.dbh.a(bVar);
        }
    }

    public v bTx() {
        return this.hXL;
    }

    public void bTy() {
        if (!this.hXO) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXU);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXU, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void xn(int i) {
        if (bTz()) {
            t.g(this.mContext, this.hXG, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXT);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXT, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bTh() {
        if (bTz()) {
            t.aF(this.mContext, this.hXG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTz() {
        return (this.hXH || this.akL == null || this.akL.equals(this.hXG)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.hXE = zVar;
    }

    public z bTA() {
        return this.hXE;
    }
}
