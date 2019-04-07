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
    private String akQ;
    private z hXk;
    private String hXm;
    private v hXr;
    private com.baidu.tieba.video.b hXs;
    private boolean hXt;
    private long hXy;
    private Context mContext;
    private String hXl = "1";
    private boolean hXn = false;
    private long feH = 0;
    private long hXo = 0;
    private long mStartTime = 0;
    private long hXp = 0;
    private int hXq = 0;
    private boolean hXu = false;
    private boolean hXv = false;
    private int hXw = 8;
    private int hXx = 16;
    private Runnable hXz = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.hXu && n.this.hXv && n.this.bSZ() && n.this.bTx()) {
                t.g(n.this.mContext, n.this.hXm, -1);
            }
        }
    };
    private Runnable hXA = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bTx()) {
                t.aD(n.this.mContext, n.this.hXm);
            } else if (!n.this.hXn) {
                t.qE(n.this.hXm);
            }
        }
    };
    private j.c hVY = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aBk() {
            n.g(n.this);
        }
    };
    private j dbg = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.hXq;
        nVar.hXq = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dbg.a(this.hVY);
        this.hXr = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String qC(String str) {
        this.hXu = com.baidu.tbadk.coreExtra.model.f.ajF();
        this.hXv = com.baidu.tbadk.coreExtra.model.f.ajG();
        this.hXw = com.baidu.tbadk.coreExtra.model.f.ajH();
        this.hXx = com.baidu.tbadk.coreExtra.model.f.ajI();
        this.hXm = str;
        this.akQ = this.hXn ? this.hXm : t.aq(str, this.hXu);
        if (this.hXr != null) {
            w.a("start_play", this.hXm, bTx(), (int) this.hXr.bTJ(), this.hXr.getDuration());
        }
        this.hXo = System.currentTimeMillis();
        return this.akQ;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bSZ() {
        return !StringUtils.isNull(this.akQ) && this.akQ.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTa() {
        return this.hXu;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bTb() {
        return this.hXv;
    }

    @Override // com.baidu.tieba.play.d
    public int bTc() {
        return com.baidu.tbadk.coreExtra.model.f.ajJ() ? this.hXw : this.hXx;
    }

    @Override // com.baidu.tieba.play.d
    public String bSX() {
        return this.hXm;
    }

    @Override // com.baidu.tieba.play.d
    public void bTd() {
        if (this.hXu && this.hXv && bSZ() && bTx()) {
            t.g(this.mContext, this.hXm, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dI(long j) {
        this.hXy = j;
        bTw();
        if (this.hXo > 0) {
            this.hXp = System.currentTimeMillis() - this.hXo;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.hXm) && (parse = Uri.parse(n.this.hXm)) != null) {
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
        if (this.dbg != null) {
            this.dbg.start();
        }
        this.hXt = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXA);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXz);
        bTf();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.feH += currentTimeMillis;
            dJ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bTt();
        if (this.dbg != null) {
            this.dbg.stop();
        }
        if (this.hXp > 0 && this.hXr != null) {
            am amVar = new am("c11685");
            amVar.bJ("service_ip", this.HR);
            amVar.bJ(WebVideoActivityConfig.KEY_VIDEO_URL, this.hXm);
            amVar.k("video_size", this.hXr.bTJ());
            amVar.T(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.hXr.getDuration());
            amVar.bJ("video_resolution", this.hXr.bTK());
            amVar.T("loading_count", this.hXq);
            amVar.k("user_watch_time", this.feH / 1000);
            amVar.k("start_play_time", this.hXp);
            TiebaStatic.log(amVar);
        }
        if (this.hXr != null && this.hXp > 0) {
            w.a("stop_play", this.hXm, bTx(), (int) this.hXr.bTJ(), this.hXr.getDuration());
        }
        bTs();
        this.hXp = 0L;
        this.feH = 0L;
        this.hXq = 0;
        this.hXo = 0L;
        this.mStartTime = 0L;
        this.hXt = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.hXs = bVar;
    }

    private void dJ(long j) {
        if (this.hXs != null) {
            this.hXs.setVideoWatchDuration(this.hXs.getVideoWatchDuration() + j);
        }
    }

    private void bTs() {
        if (this.hXs != null && this.hXt) {
            TbSingleton.getInstance().putVideoRecord(this.hXs.getThreadId(), (int) (this.hXs.getVideoWatchDuration() / 1000));
        }
    }

    private void bTt() {
        if (this.feH >= 0 && this.feH < 86400000) {
            if (this.feH > 0) {
                am amVar = new am("c11244");
                amVar.k("obj_duration", this.feH);
                amVar.bJ("obj_type", this.hXl);
                amVar.k("playduration", this.hXy);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bJ("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.hXk != null) {
                    this.hXk.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.feH, this.hXl, this.hXk, "", this.hXy);
            } else if (this.hXt) {
                l.a(this.feH, this.hXl, this.hXk, "", this.hXy);
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
        this.hXt = false;
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
        return t.qD(this.hXm) != null;
    }

    public void bTu() {
        this.hXn = true;
    }

    public void AQ(String str) {
        this.hXl = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bTe() {
        return this.dbg;
    }

    public void a(j.b bVar) {
        if (this.dbg != null) {
            this.dbg.a(bVar);
        }
    }

    public v bTv() {
        return this.hXr;
    }

    public void bTw() {
        if (!this.hXu) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXA);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hXA, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void xj(int i) {
        if (bTx()) {
            t.g(this.mContext, this.hXm, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXz);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXz, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bTf() {
        if (bTx()) {
            t.aE(this.mContext, this.hXm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTx() {
        return (this.hXn || this.akQ == null || this.akQ.equals(this.hXm)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.hXk = zVar;
    }

    public z bTy() {
        return this.hXk;
    }
}
