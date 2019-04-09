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
    private String akR;
    private z hXl;
    private String hXn;
    private v hXs;
    private com.baidu.tieba.video.b hXt;
    private boolean hXu;
    private long hXz;
    private Context mContext;
    private String hXm = "1";
    private boolean hXo = false;
    private long feH = 0;
    private long hXp = 0;
    private long mStartTime = 0;
    private long hXq = 0;
    private int hXr = 0;
    private boolean hXv = false;
    private boolean hXw = false;
    private int hXx = 8;
    private int hXy = 16;
    private Runnable hXA = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.hXv && n.this.hXw && n.this.bSZ() && n.this.bTx()) {
                t.g(n.this.mContext, n.this.hXn, -1);
            }
        }
    };
    private Runnable hXB = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bTx()) {
                t.aD(n.this.mContext, n.this.hXn);
            } else if (!n.this.hXo) {
                t.qE(n.this.hXn);
            }
        }
    };
    private j.c hVZ = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aBk() {
            n.g(n.this);
        }
    };
    private j dbh = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.hXr;
        nVar.hXr = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dbh.a(this.hVZ);
        this.hXs = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String qC(String str) {
        this.hXv = com.baidu.tbadk.coreExtra.model.f.ajF();
        this.hXw = com.baidu.tbadk.coreExtra.model.f.ajG();
        this.hXx = com.baidu.tbadk.coreExtra.model.f.ajH();
        this.hXy = com.baidu.tbadk.coreExtra.model.f.ajI();
        this.hXn = str;
        this.akR = this.hXo ? this.hXn : t.aq(str, this.hXv);
        if (this.hXs != null) {
            w.a("start_play", this.hXn, bTx(), (int) this.hXs.bTJ(), this.hXs.getDuration());
        }
        this.hXp = System.currentTimeMillis();
        return this.akR;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bSZ() {
        return !StringUtils.isNull(this.akR) && this.akR.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTa() {
        return this.hXv;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTb() {
        return this.hXw;
    }

    @Override // com.baidu.tieba.play.d
    public int bTc() {
        return com.baidu.tbadk.coreExtra.model.f.ajJ() ? this.hXx : this.hXy;
    }

    @Override // com.baidu.tieba.play.d
    public String bSX() {
        return this.hXn;
    }

    @Override // com.baidu.tieba.play.d
    public void bTd() {
        if (this.hXv && this.hXw && bSZ() && bTx()) {
            t.g(this.mContext, this.hXn, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dI(long j) {
        this.hXz = j;
        bTw();
        if (this.hXp > 0) {
            this.hXq = System.currentTimeMillis() - this.hXp;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.hXn) && (parse = Uri.parse(n.this.hXn)) != null) {
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
            this.feH += currentTimeMillis;
            dJ(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dbh != null) {
            this.dbh.start();
        }
        this.hXu = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXB);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXA);
        bTf();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feH += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTt();
        if (this.dbh != null) {
            this.dbh.stop();
        }
        if (this.hXq > 0 && this.hXs != null) {
            am amVar = new am("c11685");
            amVar.bJ("service_ip", this.HR);
            amVar.bJ(WebVideoActivityConfig.KEY_VIDEO_URL, this.hXn);
            amVar.k("video_size", this.hXs.bTJ());
            amVar.T(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.hXs.getDuration());
            amVar.bJ("video_resolution", this.hXs.bTK());
            amVar.T("loading_count", this.hXr);
            amVar.k("user_watch_time", this.feH / 1000);
            amVar.k("start_play_time", this.hXq);
            TiebaStatic.log(amVar);
        }
        if (this.hXs != null && this.hXq > 0) {
            w.a("stop_play", this.hXn, bTx(), (int) this.hXs.bTJ(), this.hXs.getDuration());
        }
        bTs();
        this.hXq = 0L;
        this.feH = 0L;
        this.hXr = 0;
        this.hXp = 0L;
        this.mStartTime = 0L;
        this.hXu = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.hXt = bVar;
    }

    private void dJ(long j) {
        if (this.hXt != null) {
            this.hXt.setVideoWatchDuration(this.hXt.getVideoWatchDuration() + j);
        }
    }

    private void bTs() {
        if (this.hXt != null && this.hXu) {
            TbSingleton.getInstance().putVideoRecord(this.hXt.getThreadId(), (int) (this.hXt.getVideoWatchDuration() / 1000));
        }
    }

    private void bTt() {
        if (this.feH >= 0 && this.feH < 86400000) {
            if (this.feH > 0) {
                am amVar = new am("c11244");
                amVar.k("obj_duration", this.feH);
                amVar.bJ("obj_type", this.hXm);
                amVar.k("playduration", this.hXz);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bJ("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.hXl != null) {
                    this.hXl.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.feH, this.hXm, this.hXl, "", this.hXz);
            } else if (this.hXu) {
                l.a(this.feH, this.hXm, this.hXl, "", this.hXz);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feH += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTs();
        this.hXu = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feH += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTs();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bSY() {
        return t.qD(this.hXn) != null;
    }

    public void bTu() {
        this.hXo = true;
    }

    public void AQ(String str) {
        this.hXm = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bTe() {
        return this.dbh;
    }

    public void a(j.b bVar) {
        if (this.dbh != null) {
            this.dbh.a(bVar);
        }
    }

    public v bTv() {
        return this.hXs;
    }

    public void bTw() {
        if (!this.hXv) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXB);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXB, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void xj(int i) {
        if (bTx()) {
            t.g(this.mContext, this.hXn, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXA);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXA, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bTf() {
        if (bTx()) {
            t.aE(this.mContext, this.hXn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTx() {
        return (this.hXo || this.akR == null || this.akR.equals(this.hXn)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.hXl = zVar;
    }

    public z bTy() {
        return this.hXl;
    }
}
