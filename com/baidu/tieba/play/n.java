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
    private y khi;
    private String khk;
    private u khp;
    private com.baidu.tieba.video.b khq;
    private boolean khr;
    private long khx;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String khj = "1";
    private boolean khl = false;
    private long heI = 0;
    private long khm = 0;
    private long mStartTime = 0;
    private long khn = 0;
    private int kho = 0;
    public boolean khs = false;
    private boolean kht = false;
    private boolean khu = false;
    private int khv = 8;
    private int khw = 16;
    private Runnable khy = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.kht && n.this.khu && n.this.cJw() && n.this.cJY()) {
                s.d(n.this.mContext, n.this.khk, -1);
            }
        }
    };
    private Runnable khz = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cJY()) {
                s.ap(n.this.mContext, n.this.khk);
            } else if (!n.this.khl) {
                s.xX(n.this.khk);
            }
        }
    };
    private j.c kfY = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bll() {
            n.g(n.this);
        }
    };
    private j ePg = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.kho;
        nVar.kho = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.ePg.a(this.kfY);
        this.khp = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String xV(String str) {
        this.kht = com.baidu.tbadk.coreExtra.model.f.aUH();
        this.khu = com.baidu.tbadk.coreExtra.model.f.aUI();
        this.khv = com.baidu.tbadk.coreExtra.model.f.aUJ();
        this.khw = com.baidu.tbadk.coreExtra.model.f.aUK();
        this.khk = str;
        this.mVideoPath = this.khl ? this.khk : s.aC(str, this.kht);
        if (this.khp != null) {
            v.a("start_play", this.khk, cJY(), (int) this.khp.cKi(), this.khp.getDuration());
        }
        this.khm = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJw() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJx() {
        return this.kht;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJy() {
        return this.khu;
    }

    @Override // com.baidu.tieba.play.d
    public int cJz() {
        return com.baidu.tbadk.coreExtra.model.f.aUL() ? this.khv : this.khw;
    }

    @Override // com.baidu.tieba.play.d
    public String cJt() {
        return this.khk;
    }

    @Override // com.baidu.tieba.play.d
    public void cJA() {
        if (this.kht && this.khu && cJw() && cJY()) {
            s.d(this.mContext, this.khk, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void fj(long j) {
        this.khx = j;
        cJX();
        if (this.khm > 0) {
            this.khn = System.currentTimeMillis() - this.khm;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.khk) && (parse = Uri.parse(n.this.khk)) != null) {
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
            this.heI += currentTimeMillis;
            fk(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.ePg != null) {
            this.ePg.start();
        }
        this.khr = true;
    }

    @Override // com.baidu.tieba.play.d
    public void IJ(String str) {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khz);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khy);
        ya(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heI += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJU();
        if (this.ePg != null) {
            this.ePg.stop();
        }
        if (this.khn > 0 && this.khp != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cI("service_ip", this.mHost);
            anVar.cI("video_url", this.khk);
            anVar.t("video_size", this.khp.cKi());
            anVar.af("video_duration", this.khp.getDuration());
            anVar.cI("video_resolution", this.khp.cKj());
            anVar.af("loading_count", this.kho);
            anVar.t("user_watch_time", this.heI / 1000);
            anVar.t("start_play_time", this.khn);
            TiebaStatic.log(anVar);
        }
        if (this.khp != null && this.khn > 0) {
            v.a("stop_play", this.khk, cJY(), (int) this.khp.cKi(), this.khp.getDuration());
        }
        cJT();
        this.khn = 0L;
        this.heI = 0L;
        this.kho = 0;
        this.khm = 0L;
        this.mStartTime = 0L;
        this.khr = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.khq = bVar;
    }

    private void fk(long j) {
        if (this.khq != null) {
            this.khq.setVideoWatchDuration(this.khq.getVideoWatchDuration() + j);
        }
    }

    private void cJT() {
        if (this.khq != null && this.khr) {
            TbSingleton.getInstance().putVideoRecord(this.khq.getThreadId(), (int) (this.khq.getVideoWatchDuration() / 1000));
        }
    }

    private void cJU() {
        if (this.heI >= 0 && this.heI < 86400000) {
            if (this.heI > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.t("obj_duration", this.heI);
                anVar.cI("obj_type", this.khj);
                anVar.t("playduration", this.khx);
                anVar.af("player_type", 0);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cI("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.khi != null) {
                    this.khi.f(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.uK("obj_param5") && this.khp.aIu() != null) {
                    if (this.khp.aIu().getBaijiahaoData() != null) {
                        if (this.khp.aIu().getBaijiahaoData().oriUgcType == 2) {
                            anVar.af("obj_param5", 3);
                        } else if (this.khp.aIu().getBaijiahaoData().oriUgcType == 4) {
                            anVar.af("obj_param5", 2);
                        }
                    } else {
                        anVar.af("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.heI, this.khj, this.khi, "", this.khx);
            } else if (this.khr) {
                l.a(this.heI, this.khj, this.khi, "", this.khx);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cJu() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khz);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khy);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heI += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJU();
        if (this.ePg != null) {
            this.ePg.stop();
        }
        if (this.khn > 0 && this.khp != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cI("service_ip", this.mHost);
            anVar.cI("video_url", this.khk);
            anVar.t("video_size", this.khp.cKi());
            anVar.af("video_duration", this.khp.getDuration());
            anVar.cI("video_resolution", this.khp.cKj());
            anVar.af("loading_count", this.kho);
            anVar.t("user_watch_time", this.heI / 1000);
            anVar.t("start_play_time", this.khn);
            TiebaStatic.log(anVar);
        }
        if (this.khp != null && this.khn > 0) {
            v.a("stop_play", this.khk, cJY(), (int) this.khp.cKi(), this.khp.getDuration());
        }
        cJT();
        this.khn = 0L;
        this.heI = 0L;
        this.kho = 0;
        this.khm = 0L;
        this.mStartTime = 0L;
        this.khr = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heI += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJT();
        this.khr = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.heI += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cJT();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cJv() {
        return s.xW(this.khk) != null;
    }

    public void cJV() {
        this.khl = true;
    }

    public void IM(String str) {
        this.khj = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cJB() {
        return this.ePg;
    }

    public void a(j.b bVar) {
        if (this.ePg != null) {
            this.ePg.a(bVar);
        }
    }

    public u cJW() {
        return this.khp;
    }

    public void cJX() {
        if (!this.kht) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khz);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.khz, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void AX(int i) {
        if (cJY()) {
            s.d(this.mContext, this.khk, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khy);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khy, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void ya(String str) {
        if (cJY()) {
            s.aq(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJY() {
        return (this.khl || this.mVideoPath == null || this.mVideoPath.equals(this.khk)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.khi = yVar;
    }

    public y cJZ() {
        return this.khi;
    }
}
