package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private z gvj;
    private String gvl;
    private v gvq;
    private com.baidu.tieba.video.b gvr;
    private boolean gvs;
    private long gvx;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String gvk = "1";
    private boolean gvm = false;
    private long dFN = 0;
    private long gvn = 0;
    private long mStartTime = 0;
    private long gvo = 0;
    private int gvp = 0;
    private boolean gvt = false;
    private boolean gvu = false;
    private int gvv = 8;
    private int gvw = 16;
    private Runnable gvy = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gvt && n.this.gvu && n.this.bpX() && n.this.bqu()) {
                t.g(n.this.mContext, n.this.gvl, -1);
            }
        }
    };
    private Runnable gvz = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bqu()) {
                t.ar(n.this.mContext, n.this.gvl);
            } else if (!n.this.gvm) {
                t.ji(n.this.gvl);
            }
        }
    };
    private j.c gtZ = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void YW() {
            n.g(n.this);
        }
    };
    private j bJO = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gvp;
        nVar.gvp = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bJO.a(this.gtZ);
        this.gvq = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String jg(String str) {
        this.gvt = com.baidu.tbadk.coreExtra.model.f.IF();
        this.gvu = com.baidu.tbadk.coreExtra.model.f.IG();
        this.gvv = com.baidu.tbadk.coreExtra.model.f.IH();
        this.gvw = com.baidu.tbadk.coreExtra.model.f.II();
        this.gvl = str;
        this.mVideoPath = this.gvm ? this.gvl : t.X(str, this.gvt);
        if (this.gvq != null) {
            w.a("start_play", this.gvl, bqu(), (int) this.gvq.bqG(), this.gvq.getDuration());
        }
        this.gvn = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpX() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains(NetworkDef.IP_LOOPBACK);
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpY() {
        return this.gvt;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpZ() {
        return this.gvu;
    }

    @Override // com.baidu.tieba.play.d
    public int bqa() {
        return com.baidu.tbadk.coreExtra.model.f.IJ() ? this.gvv : this.gvw;
    }

    @Override // com.baidu.tieba.play.d
    public String bpV() {
        return this.gvl;
    }

    @Override // com.baidu.tieba.play.d
    public void bqb() {
        if (this.gvt && this.gvu && bpX() && bqu()) {
            t.g(this.mContext, this.gvl, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cW(long j) {
        this.gvx = j;
        bqt();
        if (this.gvn > 0) {
            this.gvo = System.currentTimeMillis() - this.gvn;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gvl) && (parse = Uri.parse(n.this.gvl)) != null) {
                    try {
                        n.this.mHost = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dFN += currentTimeMillis;
            cX(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bJO != null) {
            this.bJO.start();
        }
        this.gvs = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvz);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvy);
        bqd();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dFN += currentTimeMillis;
            cX(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bqq();
        if (this.bJO != null) {
            this.bJO.stop();
        }
        if (this.gvo > 0 && this.gvq != null) {
            am amVar = new am("c11685");
            amVar.ax("service_ip", this.mHost);
            amVar.ax(WebVideoActivityConfig.KEY_VIDEO_URL, this.gvl);
            amVar.h("video_size", this.gvq.bqG());
            amVar.x(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gvq.getDuration());
            amVar.ax("video_resolution", this.gvq.bqH());
            amVar.x("loading_count", this.gvp);
            amVar.h("user_watch_time", this.dFN / 1000);
            amVar.h("start_play_time", this.gvo);
            TiebaStatic.log(amVar);
        }
        if (this.gvq != null && this.gvo > 0) {
            w.a("stop_play", this.gvl, bqu(), (int) this.gvq.bqG(), this.gvq.getDuration());
        }
        bqp();
        this.gvo = 0L;
        this.dFN = 0L;
        this.gvp = 0;
        this.gvn = 0L;
        this.mStartTime = 0L;
        this.gvs = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gvr = bVar;
    }

    private void cX(long j) {
        if (this.gvr != null) {
            this.gvr.setVideoWatchDuration(this.gvr.getVideoWatchDuration() + j);
        }
    }

    private void bqp() {
        if (this.gvr != null && this.gvs) {
            TbSingleton.getInstance().putVideoRecord(this.gvr.getThreadId(), (int) (this.gvr.getVideoWatchDuration() / 1000));
        }
    }

    private void bqq() {
        if (this.dFN >= 0 && this.dFN < 86400000) {
            if (this.dFN > 0) {
                am amVar = new am("c11244");
                amVar.h("obj_duration", this.dFN);
                amVar.ax("obj_type", this.gvk);
                amVar.h("playduration", this.gvx);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.ax("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gvj != null) {
                    this.gvj.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dFN, this.gvk, this.gvj, "", this.gvx);
            } else if (this.gvs) {
                l.a(this.dFN, this.gvk, this.gvj, "", this.gvx);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dFN += currentTimeMillis;
            cX(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bqp();
        this.gvs = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dFN += currentTimeMillis;
            cX(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bqp();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpW() {
        return t.jh(this.gvl) != null;
    }

    public void bqr() {
        this.gvm = true;
    }

    public void tn(String str) {
        this.gvk = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bqc() {
        return this.bJO;
    }

    public void a(j.b bVar) {
        if (this.bJO != null) {
            this.bJO.a(bVar);
        }
    }

    public v bqs() {
        return this.gvq;
    }

    public void bqt() {
        if (!this.gvt) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvz);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.gvz, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void sA(int i) {
        if (bqu()) {
            t.g(this.mContext, this.gvl, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvy);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvy, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bqd() {
        if (bqu()) {
            t.as(this.mContext, this.gvl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqu() {
        return (this.gvm || this.mVideoPath == null || this.mVideoPath.equals(this.gvl)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.gvj = zVar;
    }

    public z bqv() {
        return this.gvj;
    }
}
