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
    private y khe;
    private String khg;
    private u khl;
    private com.baidu.tieba.video.b khm;
    private boolean khn;
    private long kht;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String khf = "1";
    private boolean khh = false;
    private long heC = 0;
    private long khi = 0;
    private long mStartTime = 0;
    private long khj = 0;
    private int khk = 0;
    public boolean kho = false;
    private boolean khp = false;
    private boolean khq = false;
    private int khr = 8;
    private int khs = 16;
    private Runnable khu = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.khp && n.this.khq && n.this.cJy() && n.this.cKa()) {
                s.d(n.this.mContext, n.this.khg, -1);
            }
        }
    };
    private Runnable khv = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cKa()) {
                s.aB(n.this.mContext, n.this.khg);
            } else if (!n.this.khh) {
                s.xU(n.this.khg);
            }
        }
    };
    private j.c kfU = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bln() {
            n.g(n.this);
        }
    };
    private j ePb = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.khk;
        nVar.khk = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.ePb.a(this.kfU);
        this.khl = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String xS(String str) {
        this.khp = com.baidu.tbadk.coreExtra.model.f.aUJ();
        this.khq = com.baidu.tbadk.coreExtra.model.f.aUK();
        this.khr = com.baidu.tbadk.coreExtra.model.f.aUL();
        this.khs = com.baidu.tbadk.coreExtra.model.f.aUM();
        this.khg = str;
        this.mVideoPath = this.khh ? this.khg : s.aC(str, this.khp);
        if (this.khl != null) {
            v.a("start_play", this.khg, cKa(), (int) this.khl.cKk(), this.khl.getDuration());
        }
        this.khi = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJy() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJz() {
        return this.khp;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJA() {
        return this.khq;
    }

    @Override // com.baidu.tieba.play.d
    public int cJB() {
        return com.baidu.tbadk.coreExtra.model.f.aUN() ? this.khr : this.khs;
    }

    @Override // com.baidu.tieba.play.d
    public String cJv() {
        return this.khg;
    }

    @Override // com.baidu.tieba.play.d
    public void cJC() {
        if (this.khp && this.khq && cJy() && cKa()) {
            s.d(this.mContext, this.khg, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void fj(long j) {
        this.kht = j;
        cJZ();
        if (this.khi > 0) {
            this.khj = System.currentTimeMillis() - this.khi;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.khg) && (parse = Uri.parse(n.this.khg)) != null) {
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
            this.heC += currentTimeMillis;
            fk(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.ePb != null) {
            this.ePb.start();
        }
        this.khn = true;
    }

    @Override // com.baidu.tieba.play.d
    public void IG(String str) {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khv);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khu);
        xX(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heC += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJW();
        if (this.ePb != null) {
            this.ePb.stop();
        }
        if (this.khj > 0 && this.khl != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cI("service_ip", this.mHost);
            anVar.cI("video_url", this.khg);
            anVar.t("video_size", this.khl.cKk());
            anVar.af("video_duration", this.khl.getDuration());
            anVar.cI("video_resolution", this.khl.cKl());
            anVar.af("loading_count", this.khk);
            anVar.t("user_watch_time", this.heC / 1000);
            anVar.t("start_play_time", this.khj);
            TiebaStatic.log(anVar);
        }
        if (this.khl != null && this.khj > 0) {
            v.a("stop_play", this.khg, cKa(), (int) this.khl.cKk(), this.khl.getDuration());
        }
        cJV();
        this.khj = 0L;
        this.heC = 0L;
        this.khk = 0;
        this.khi = 0L;
        this.mStartTime = 0L;
        this.khn = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.khm = bVar;
    }

    private void fk(long j) {
        if (this.khm != null) {
            this.khm.setVideoWatchDuration(this.khm.getVideoWatchDuration() + j);
        }
    }

    private void cJV() {
        if (this.khm != null && this.khn) {
            TbSingleton.getInstance().putVideoRecord(this.khm.getThreadId(), (int) (this.khm.getVideoWatchDuration() / 1000));
        }
    }

    private void cJW() {
        if (this.heC >= 0 && this.heC < 86400000) {
            if (this.heC > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.t("obj_duration", this.heC);
                anVar.cI("obj_type", this.khf);
                anVar.t("playduration", this.kht);
                anVar.af("player_type", 0);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cI("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.khe != null) {
                    this.khe.f(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.uH("obj_param5") && this.khl.aIw() != null) {
                    if (this.khl.aIw().getBaijiahaoData() != null) {
                        if (this.khl.aIw().getBaijiahaoData().oriUgcType == 2) {
                            anVar.af("obj_param5", 3);
                        } else if (this.khl.aIw().getBaijiahaoData().oriUgcType == 4) {
                            anVar.af("obj_param5", 2);
                        }
                    } else {
                        anVar.af("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.heC, this.khf, this.khe, "", this.kht);
            } else if (this.khn) {
                l.a(this.heC, this.khf, this.khe, "", this.kht);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cJw() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khv);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khu);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heC += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJW();
        if (this.ePb != null) {
            this.ePb.stop();
        }
        if (this.khj > 0 && this.khl != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cI("service_ip", this.mHost);
            anVar.cI("video_url", this.khg);
            anVar.t("video_size", this.khl.cKk());
            anVar.af("video_duration", this.khl.getDuration());
            anVar.cI("video_resolution", this.khl.cKl());
            anVar.af("loading_count", this.khk);
            anVar.t("user_watch_time", this.heC / 1000);
            anVar.t("start_play_time", this.khj);
            TiebaStatic.log(anVar);
        }
        if (this.khl != null && this.khj > 0) {
            v.a("stop_play", this.khg, cKa(), (int) this.khl.cKk(), this.khl.getDuration());
        }
        cJV();
        this.khj = 0L;
        this.heC = 0L;
        this.khk = 0;
        this.khi = 0L;
        this.mStartTime = 0L;
        this.khn = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heC += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJV();
        this.khn = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heC += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJV();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJx() {
        return s.xT(this.khg) != null;
    }

    public void cJX() {
        this.khh = true;
    }

    public void IJ(String str) {
        this.khf = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cJD() {
        return this.ePb;
    }

    public void a(j.b bVar) {
        if (this.ePb != null) {
            this.ePb.a(bVar);
        }
    }

    public u cJY() {
        return this.khl;
    }

    public void cJZ() {
        if (!this.khp) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khv);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.khv, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void AX(int i) {
        if (cKa()) {
            s.d(this.mContext, this.khg, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khu);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khu, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void xX(String str) {
        if (cKa()) {
            s.aC(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKa() {
        return (this.khh || this.mVideoPath == null || this.mVideoPath.equals(this.khg)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.khe = yVar;
    }

    public y cKb() {
        return this.khe;
    }
}
