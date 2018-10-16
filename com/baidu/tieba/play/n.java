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
    private z gvi;
    private String gvk;
    private v gvp;
    private com.baidu.tieba.video.b gvq;
    private boolean gvr;
    private long gvw;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String gvj = "1";
    private boolean gvl = false;
    private long dFN = 0;
    private long gvm = 0;
    private long mStartTime = 0;
    private long gvn = 0;
    private int gvo = 0;
    private boolean gvs = false;
    private boolean gvt = false;
    private int gvu = 8;
    private int gvv = 16;
    private Runnable gvx = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gvs && n.this.gvt && n.this.bpX() && n.this.bqu()) {
                t.g(n.this.mContext, n.this.gvk, -1);
            }
        }
    };
    private Runnable gvy = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bqu()) {
                t.ar(n.this.mContext, n.this.gvk);
            } else if (!n.this.gvl) {
                t.ji(n.this.gvk);
            }
        }
    };
    private j.c gtY = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void YV() {
            n.g(n.this);
        }
    };
    private j bJO = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gvo;
        nVar.gvo = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bJO.a(this.gtY);
        this.gvp = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String jg(String str) {
        this.gvs = com.baidu.tbadk.coreExtra.model.f.IF();
        this.gvt = com.baidu.tbadk.coreExtra.model.f.IG();
        this.gvu = com.baidu.tbadk.coreExtra.model.f.IH();
        this.gvv = com.baidu.tbadk.coreExtra.model.f.II();
        this.gvk = str;
        this.mVideoPath = this.gvl ? this.gvk : t.X(str, this.gvs);
        if (this.gvp != null) {
            w.a("start_play", this.gvk, bqu(), (int) this.gvp.bqG(), this.gvp.getDuration());
        }
        this.gvm = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpX() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains(NetworkDef.IP_LOOPBACK);
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpY() {
        return this.gvs;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpZ() {
        return this.gvt;
    }

    @Override // com.baidu.tieba.play.d
    public int bqa() {
        return com.baidu.tbadk.coreExtra.model.f.IJ() ? this.gvu : this.gvv;
    }

    @Override // com.baidu.tieba.play.d
    public String bpV() {
        return this.gvk;
    }

    @Override // com.baidu.tieba.play.d
    public void bqb() {
        if (this.gvs && this.gvt && bpX() && bqu()) {
            t.g(this.mContext, this.gvk, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cW(long j) {
        this.gvw = j;
        bqt();
        if (this.gvm > 0) {
            this.gvn = System.currentTimeMillis() - this.gvm;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gvk) && (parse = Uri.parse(n.this.gvk)) != null) {
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
        this.gvr = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvy);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvx);
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
        if (this.gvn > 0 && this.gvp != null) {
            am amVar = new am("c11685");
            amVar.ax("service_ip", this.mHost);
            amVar.ax(WebVideoActivityConfig.KEY_VIDEO_URL, this.gvk);
            amVar.h("video_size", this.gvp.bqG());
            amVar.x(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gvp.getDuration());
            amVar.ax("video_resolution", this.gvp.bqH());
            amVar.x("loading_count", this.gvo);
            amVar.h("user_watch_time", this.dFN / 1000);
            amVar.h("start_play_time", this.gvn);
            TiebaStatic.log(amVar);
        }
        if (this.gvp != null && this.gvn > 0) {
            w.a("stop_play", this.gvk, bqu(), (int) this.gvp.bqG(), this.gvp.getDuration());
        }
        bqp();
        this.gvn = 0L;
        this.dFN = 0L;
        this.gvo = 0;
        this.gvm = 0L;
        this.mStartTime = 0L;
        this.gvr = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gvq = bVar;
    }

    private void cX(long j) {
        if (this.gvq != null) {
            this.gvq.setVideoWatchDuration(this.gvq.getVideoWatchDuration() + j);
        }
    }

    private void bqp() {
        if (this.gvq != null && this.gvr) {
            TbSingleton.getInstance().putVideoRecord(this.gvq.getThreadId(), (int) (this.gvq.getVideoWatchDuration() / 1000));
        }
    }

    private void bqq() {
        if (this.dFN >= 0 && this.dFN < 86400000) {
            if (this.dFN > 0) {
                am amVar = new am("c11244");
                amVar.h("obj_duration", this.dFN);
                amVar.ax("obj_type", this.gvj);
                amVar.h("playduration", this.gvw);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.ax("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gvi != null) {
                    this.gvi.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dFN, this.gvj, this.gvi, "", this.gvw);
            } else if (this.gvr) {
                l.a(this.dFN, this.gvj, this.gvi, "", this.gvw);
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
        this.gvr = false;
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
        return t.jh(this.gvk) != null;
    }

    public void bqr() {
        this.gvl = true;
    }

    public void tn(String str) {
        this.gvj = str;
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
        return this.gvp;
    }

    public void bqt() {
        if (!this.gvs) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvy);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.gvy, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void sA(int i) {
        if (bqu()) {
            t.g(this.mContext, this.gvk, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvx);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvx, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bqd() {
        if (bqu()) {
            t.as(this.mContext, this.gvk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqu() {
        return (this.gvl || this.mVideoPath == null || this.mVideoPath.equals(this.gvk)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.gvi = zVar;
    }

    public z bqv() {
        return this.gvi;
    }
}
