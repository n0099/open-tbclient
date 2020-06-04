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
    private y kAj;
    private String kAl;
    private u kAq;
    private com.baidu.tieba.video.b kAr;
    private boolean kAs;
    private long kAy;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String kAk = "1";
    private boolean kAm = false;
    private long htH = 0;
    private long kAn = 0;
    private long mStartTime = 0;
    private long kAo = 0;
    private int kAp = 0;
    public boolean kAt = false;
    private boolean kAu = false;
    private boolean kAv = false;
    private int kAw = 8;
    private int kAx = 16;
    private Runnable kAz = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.kAu && n.this.kAv && n.this.cQL() && n.this.cRn()) {
                s.d(n.this.mContext, n.this.kAl, -1);
            }
        }
    };
    private Runnable kAA = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cRn()) {
                s.aq(n.this.mContext, n.this.kAl);
            } else if (!n.this.kAm) {
                s.zD(n.this.kAl);
            }
        }
    };
    private j.c kyU = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bqJ() {
            n.g(n.this);
        }
    };
    private j fbY = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.kAp;
        nVar.kAp = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.fbY.a(this.kyU);
        this.kAq = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String zB(String str) {
        this.kAu = com.baidu.tbadk.coreExtra.model.f.baS();
        this.kAv = com.baidu.tbadk.coreExtra.model.f.baT();
        this.kAw = com.baidu.tbadk.coreExtra.model.f.baU();
        this.kAx = com.baidu.tbadk.coreExtra.model.f.baV();
        this.kAl = str;
        this.mVideoPath = this.kAm ? this.kAl : s.aP(str, this.kAu);
        if (this.kAq != null) {
            v.a("start_play", this.kAl, cRn(), (int) this.kAq.cRx(), this.kAq.getDuration());
        }
        this.kAn = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQL() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQM() {
        return this.kAu;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQN() {
        return this.kAv;
    }

    @Override // com.baidu.tieba.play.d
    public int cQO() {
        return com.baidu.tbadk.coreExtra.model.f.baW() ? this.kAw : this.kAx;
    }

    @Override // com.baidu.tieba.play.d
    public String cQI() {
        return this.kAl;
    }

    @Override // com.baidu.tieba.play.d
    public void cQP() {
        if (this.kAu && this.kAv && cQL() && cRn()) {
            s.d(this.mContext, this.kAl, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void fj(long j) {
        this.kAy = j;
        cRm();
        if (this.kAn > 0) {
            this.kAo = System.currentTimeMillis() - this.kAn;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.kAl) && (parse = Uri.parse(n.this.kAl)) != null) {
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
            this.htH += currentTimeMillis;
            fk(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.fbY != null) {
            this.fbY.start();
        }
        this.kAs = true;
    }

    @Override // com.baidu.tieba.play.d
    public void Kw(String str) {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAA);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAz);
        zG(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htH += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cRj();
        if (this.fbY != null) {
            this.fbY.stop();
        }
        if (this.kAo > 0 && this.kAq != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.dh("service_ip", this.mHost);
            anVar.dh("video_url", this.kAl);
            anVar.s("video_size", this.kAq.cRx());
            anVar.ag("video_duration", this.kAq.getDuration());
            anVar.dh("video_resolution", this.kAq.cRy());
            anVar.ag("loading_count", this.kAp);
            anVar.s("user_watch_time", this.htH / 1000);
            anVar.s("start_play_time", this.kAo);
            TiebaStatic.log(anVar);
        }
        if (this.kAq != null && this.kAo > 0) {
            v.a("stop_play", this.kAl, cRn(), (int) this.kAq.cRx(), this.kAq.getDuration());
        }
        cRi();
        this.kAo = 0L;
        this.htH = 0L;
        this.kAp = 0;
        this.kAn = 0L;
        this.mStartTime = 0L;
        this.kAs = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.kAr = bVar;
    }

    private void fk(long j) {
        if (this.kAr != null) {
            this.kAr.setVideoWatchDuration(this.kAr.getVideoWatchDuration() + j);
        }
    }

    private void cRi() {
        if (this.kAr != null && this.kAs) {
            TbSingleton.getInstance().putVideoRecord(this.kAr.getThreadId(), (int) (this.kAr.getVideoWatchDuration() / 1000));
        }
    }

    private void cRj() {
        if (this.htH >= 0 && this.htH < 86400000) {
            if (this.htH > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.htH);
                anVar.dh("obj_type", this.kAk);
                anVar.s("playduration", this.kAy);
                anVar.ag("player_type", 0);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.dh("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.kAj != null) {
                    this.kAj.f(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.wq("obj_param5") && this.kAq.aOi() != null) {
                    if (this.kAq.aOi().getBaijiahaoData() != null) {
                        if (this.kAq.aOi().getBaijiahaoData().oriUgcType == 2) {
                            anVar.ag("obj_param5", 3);
                        } else if (this.kAq.aOi().getBaijiahaoData().oriUgcType == 4) {
                            anVar.ag("obj_param5", 2);
                        }
                    } else {
                        anVar.ag("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.htH, this.kAk, this.kAj, "", this.kAy);
            } else if (this.kAs) {
                l.a(this.htH, this.kAk, this.kAj, "", this.kAy);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cQJ() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAA);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAz);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htH += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cRj();
        if (this.fbY != null) {
            this.fbY.stop();
        }
        if (this.kAo > 0 && this.kAq != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.dh("service_ip", this.mHost);
            anVar.dh("video_url", this.kAl);
            anVar.s("video_size", this.kAq.cRx());
            anVar.ag("video_duration", this.kAq.getDuration());
            anVar.dh("video_resolution", this.kAq.cRy());
            anVar.ag("loading_count", this.kAp);
            anVar.s("user_watch_time", this.htH / 1000);
            anVar.s("start_play_time", this.kAo);
            TiebaStatic.log(anVar);
        }
        if (this.kAq != null && this.kAo > 0) {
            v.a("stop_play", this.kAl, cRn(), (int) this.kAq.cRx(), this.kAq.getDuration());
        }
        cRi();
        this.kAo = 0L;
        this.htH = 0L;
        this.kAp = 0;
        this.kAn = 0L;
        this.mStartTime = 0L;
        this.kAs = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htH += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cRi();
        this.kAs = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htH += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cRi();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQK() {
        return s.zC(this.kAl) != null;
    }

    public void cRk() {
        this.kAm = true;
    }

    public void Kz(String str) {
        this.kAk = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cQQ() {
        return this.fbY;
    }

    public void a(j.b bVar) {
        if (this.fbY != null) {
            this.fbY.a(bVar);
        }
    }

    public u cRl() {
        return this.kAq;
    }

    public void cRm() {
        if (!this.kAu) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAA);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kAA, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void BJ(int i) {
        if (cRn()) {
            s.d(this.mContext, this.kAl, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAz);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kAz, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void zG(String str) {
        if (cRn()) {
            s.ar(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRn() {
        return (this.kAm || this.mVideoPath == null || this.mVideoPath.equals(this.kAl)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.kAj = yVar;
    }

    public y cRo() {
        return this.kAj;
    }
}
