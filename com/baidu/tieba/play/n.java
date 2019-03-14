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
    private String akM;
    private String hXA;
    private v hXF;
    private com.baidu.tieba.video.b hXG;
    private boolean hXH;
    private long hXM;
    private z hXy;
    private Context mContext;
    private String hXz = "1";
    private boolean hXB = false;
    private long feU = 0;
    private long hXC = 0;
    private long mStartTime = 0;
    private long hXD = 0;
    private int hXE = 0;
    private boolean hXI = false;
    private boolean hXJ = false;
    private int hXK = 8;
    private int hXL = 16;
    private Runnable hXN = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.hXI && n.this.hXJ && n.this.bTd() && n.this.bTB()) {
                t.g(n.this.mContext, n.this.hXA, -1);
            }
        }
    };
    private Runnable hXO = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bTB()) {
                t.aD(n.this.mContext, n.this.hXA);
            } else if (!n.this.hXB) {
                t.qD(n.this.hXA);
            }
        }
    };
    private j.c hWm = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aBn() {
            n.g(n.this);
        }
    };
    private j dbd = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.hXE;
        nVar.hXE = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dbd.a(this.hWm);
        this.hXF = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String qB(String str) {
        this.hXI = com.baidu.tbadk.coreExtra.model.f.ajI();
        this.hXJ = com.baidu.tbadk.coreExtra.model.f.ajJ();
        this.hXK = com.baidu.tbadk.coreExtra.model.f.ajK();
        this.hXL = com.baidu.tbadk.coreExtra.model.f.ajL();
        this.hXA = str;
        this.akM = this.hXB ? this.hXA : t.aq(str, this.hXI);
        if (this.hXF != null) {
            w.a("start_play", this.hXA, bTB(), (int) this.hXF.bTN(), this.hXF.getDuration());
        }
        this.hXC = System.currentTimeMillis();
        return this.akM;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTd() {
        return !StringUtils.isNull(this.akM) && this.akM.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTe() {
        return this.hXI;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTf() {
        return this.hXJ;
    }

    @Override // com.baidu.tieba.play.d
    public int bTg() {
        return com.baidu.tbadk.coreExtra.model.f.ajM() ? this.hXK : this.hXL;
    }

    @Override // com.baidu.tieba.play.d
    public String bTb() {
        return this.hXA;
    }

    @Override // com.baidu.tieba.play.d
    public void bTh() {
        if (this.hXI && this.hXJ && bTd() && bTB()) {
            t.g(this.mContext, this.hXA, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dI(long j) {
        this.hXM = j;
        bTA();
        if (this.hXC > 0) {
            this.hXD = System.currentTimeMillis() - this.hXC;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.hXA) && (parse = Uri.parse(n.this.hXA)) != null) {
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
            this.feU += currentTimeMillis;
            dJ(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dbd != null) {
            this.dbd.start();
        }
        this.hXH = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXO);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXN);
        bTj();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feU += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTx();
        if (this.dbd != null) {
            this.dbd.stop();
        }
        if (this.hXD > 0 && this.hXF != null) {
            am amVar = new am("c11685");
            amVar.bJ("service_ip", this.HR);
            amVar.bJ(WebVideoActivityConfig.KEY_VIDEO_URL, this.hXA);
            amVar.k("video_size", this.hXF.bTN());
            amVar.T(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.hXF.getDuration());
            amVar.bJ("video_resolution", this.hXF.bTO());
            amVar.T("loading_count", this.hXE);
            amVar.k("user_watch_time", this.feU / 1000);
            amVar.k("start_play_time", this.hXD);
            TiebaStatic.log(amVar);
        }
        if (this.hXF != null && this.hXD > 0) {
            w.a("stop_play", this.hXA, bTB(), (int) this.hXF.bTN(), this.hXF.getDuration());
        }
        bTw();
        this.hXD = 0L;
        this.feU = 0L;
        this.hXE = 0;
        this.hXC = 0L;
        this.mStartTime = 0L;
        this.hXH = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.hXG = bVar;
    }

    private void dJ(long j) {
        if (this.hXG != null) {
            this.hXG.setVideoWatchDuration(this.hXG.getVideoWatchDuration() + j);
        }
    }

    private void bTw() {
        if (this.hXG != null && this.hXH) {
            TbSingleton.getInstance().putVideoRecord(this.hXG.getThreadId(), (int) (this.hXG.getVideoWatchDuration() / 1000));
        }
    }

    private void bTx() {
        if (this.feU >= 0 && this.feU < 86400000) {
            if (this.feU > 0) {
                am amVar = new am("c11244");
                amVar.k("obj_duration", this.feU);
                amVar.bJ("obj_type", this.hXz);
                amVar.k("playduration", this.hXM);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bJ("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.hXy != null) {
                    this.hXy.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.feU, this.hXz, this.hXy, "", this.hXM);
            } else if (this.hXH) {
                l.a(this.feU, this.hXz, this.hXy, "", this.hXM);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feU += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTw();
        this.hXH = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feU += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTw();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTc() {
        return t.qC(this.hXA) != null;
    }

    public void bTy() {
        this.hXB = true;
    }

    public void AR(String str) {
        this.hXz = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bTi() {
        return this.dbd;
    }

    public void a(j.b bVar) {
        if (this.dbd != null) {
            this.dbd.a(bVar);
        }
    }

    public v bTz() {
        return this.hXF;
    }

    public void bTA() {
        if (!this.hXI) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXO);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXO, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void xn(int i) {
        if (bTB()) {
            t.g(this.mContext, this.hXA, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXN);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXN, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bTj() {
        if (bTB()) {
            t.aE(this.mContext, this.hXA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTB() {
        return (this.hXB || this.akM == null || this.akM.equals(this.hXA)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.hXy = zVar;
    }

    public z bTC() {
        return this.hXy;
    }
}
