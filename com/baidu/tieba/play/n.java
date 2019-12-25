package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.play.j;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private y jrb;
    private String jrd;
    private u jri;
    private com.baidu.tieba.video.b jrj;
    private boolean jrk;
    private long jrp;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String jrc = "1";
    private boolean jre = false;
    private long gpp = 0;
    private long jrf = 0;
    private long mStartTime = 0;
    private long jrg = 0;
    private int jrh = 0;
    private boolean jrl = false;
    private boolean jrm = false;
    private int jrn = 8;
    private int jro = 16;
    private Runnable jrq = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.jrl && n.this.jrm && n.this.cvV() && n.this.cww()) {
                s.d(n.this.mContext, n.this.jrd, -1);
            }
        }
    };
    private Runnable jrr = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cww()) {
                s.aG(n.this.mContext, n.this.jrd);
            } else if (!n.this.jre) {
                s.wi(n.this.jrd);
            }
        }
    };
    private j.c jpU = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aZE() {
            n.g(n.this);
        }
    };
    private j egJ = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.jrh;
        nVar.jrh = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.egJ.a(this.jpU);
        this.jri = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String wg(String str) {
        this.jrl = com.baidu.tbadk.coreExtra.model.f.aJr();
        this.jrm = com.baidu.tbadk.coreExtra.model.f.aJs();
        this.jrn = com.baidu.tbadk.coreExtra.model.f.aJt();
        this.jro = com.baidu.tbadk.coreExtra.model.f.aJu();
        this.jrd = str;
        this.mVideoPath = this.jre ? this.jrd : s.aw(str, this.jrl);
        if (this.jri != null) {
            v.a("start_play", this.jrd, cww(), (int) this.jri.cwG(), this.jri.getDuration());
        }
        this.jrf = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cvV() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cvW() {
        return this.jrl;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cvX() {
        return this.jrm;
    }

    @Override // com.baidu.tieba.play.d
    public int cvY() {
        return com.baidu.tbadk.coreExtra.model.f.aJv() ? this.jrn : this.jro;
    }

    @Override // com.baidu.tieba.play.d
    public String cvS() {
        return this.jrd;
    }

    @Override // com.baidu.tieba.play.d
    public void cvZ() {
        if (this.jrl && this.jrm && cvV() && cww()) {
            s.d(this.mContext, this.jrd, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void eu(long j) {
        this.jrp = j;
        cwv();
        if (this.jrf > 0) {
            this.jrg = System.currentTimeMillis() - this.jrf;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.jrd) && (parse = Uri.parse(n.this.jrd)) != null) {
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
        bdAsyncTask.setPriority(2);
        bdAsyncTask.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.d
    public void onStart() {
        if (this.mStartTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gpp += currentTimeMillis;
            ev(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.egJ != null) {
            this.egJ.start();
        }
        this.jrk = true;
    }

    @Override // com.baidu.tieba.play.d
    public void GA(String str) {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrr);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrq);
        wl(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gpp += currentTimeMillis;
            ev(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cws();
        if (this.egJ != null) {
            this.egJ.stop();
        }
        if (this.jrg > 0 && this.jri != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cp("service_ip", this.mHost);
            anVar.cp("video_url", this.jrd);
            anVar.s("video_size", this.jri.cwG());
            anVar.Z("video_duration", this.jri.getDuration());
            anVar.cp("video_resolution", this.jri.cwH());
            anVar.Z("loading_count", this.jrh);
            anVar.s("user_watch_time", this.gpp / 1000);
            anVar.s("start_play_time", this.jrg);
            TiebaStatic.log(anVar);
        }
        if (this.jri != null && this.jrg > 0) {
            v.a("stop_play", this.jrd, cww(), (int) this.jri.cwG(), this.jri.getDuration());
        }
        cwr();
        this.jrg = 0L;
        this.gpp = 0L;
        this.jrh = 0;
        this.jrf = 0L;
        this.mStartTime = 0L;
        this.jrk = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.jrj = bVar;
    }

    private void ev(long j) {
        if (this.jrj != null) {
            this.jrj.setVideoWatchDuration(this.jrj.getVideoWatchDuration() + j);
        }
    }

    private void cwr() {
        if (this.jrj != null && this.jrk) {
            TbSingleton.getInstance().putVideoRecord(this.jrj.getThreadId(), (int) (this.jrj.getVideoWatchDuration() / 1000));
        }
    }

    private void cws() {
        if (this.gpp >= 0 && this.gpp < 86400000) {
            if (this.gpp > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gpp);
                anVar.cp("obj_type", this.jrc);
                anVar.s("playduration", this.jrp);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cp("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jrb != null) {
                    this.jrb.d(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (this.jri.axx() != null) {
                    if (this.jri.axx().getBaijiahaoData() != null) {
                        if (this.jri.axx().getBaijiahaoData().oriUgcType == 2) {
                            anVar.Z("obj_param5", 3);
                        } else if (this.jri.axx().getBaijiahaoData().oriUgcType == 4) {
                            anVar.Z("obj_param5", 2);
                        }
                    } else {
                        anVar.Z("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.gpp, this.jrc, this.jrb, "", this.jrp);
            } else if (this.jrk) {
                l.a(this.gpp, this.jrc, this.jrb, "", this.jrp);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cvT() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrr);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrq);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gpp += currentTimeMillis;
            ev(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cws();
        if (this.egJ != null) {
            this.egJ.stop();
        }
        if (this.jrg > 0 && this.jri != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cp("service_ip", this.mHost);
            anVar.cp("video_url", this.jrd);
            anVar.s("video_size", this.jri.cwG());
            anVar.Z("video_duration", this.jri.getDuration());
            anVar.cp("video_resolution", this.jri.cwH());
            anVar.Z("loading_count", this.jrh);
            anVar.s("user_watch_time", this.gpp / 1000);
            anVar.s("start_play_time", this.jrg);
            TiebaStatic.log(anVar);
        }
        if (this.jri != null && this.jrg > 0) {
            v.a("stop_play", this.jrd, cww(), (int) this.jri.cwG(), this.jri.getDuration());
        }
        cwr();
        this.jrg = 0L;
        this.gpp = 0L;
        this.jrh = 0;
        this.jrf = 0L;
        this.mStartTime = 0L;
        this.jrk = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gpp += currentTimeMillis;
            ev(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cwr();
        this.jrk = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gpp += currentTimeMillis;
            ev(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cwr();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cvU() {
        return s.wh(this.jrd) != null;
    }

    public void cwt() {
        this.jre = true;
    }

    public void GD(String str) {
        this.jrc = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cwa() {
        return this.egJ;
    }

    public void a(j.b bVar) {
        if (this.egJ != null) {
            this.egJ.a(bVar);
        }
    }

    public u cwu() {
        return this.jri;
    }

    public void cwv() {
        if (!this.jrl) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrr);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.jrr, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void Ab(int i) {
        if (cww()) {
            s.d(this.mContext, this.jrd, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrq);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.jrq, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void wl(String str) {
        if (cww()) {
            s.aH(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cww() {
        return (this.jre || this.mVideoPath == null || this.mVideoPath.equals(this.jrd)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.jrb = yVar;
    }

    public y cwx() {
        return this.jrb;
    }
}
