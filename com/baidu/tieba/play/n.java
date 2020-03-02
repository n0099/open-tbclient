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
    private String jvA;
    private u jvF;
    private com.baidu.tieba.video.b jvG;
    private boolean jvH;
    private long jvN;
    private y jvy;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String jvz = "1";
    private boolean jvB = false;
    private long guB = 0;
    private long jvC = 0;
    private long mStartTime = 0;
    private long jvD = 0;
    private int jvE = 0;
    public boolean jvI = false;
    private boolean jvJ = false;
    private boolean jvK = false;
    private int jvL = 8;
    private int jvM = 16;
    private Runnable jvO = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.jvJ && n.this.jvK && n.this.cyz() && n.this.czb()) {
                s.d(n.this.mContext, n.this.jvA, -1);
            }
        }
    };
    private Runnable jvP = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.czb()) {
                s.aH(n.this.mContext, n.this.jvA);
            } else if (!n.this.jvB) {
                s.wG(n.this.jvA);
            }
        }
    };
    private j.c jup = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bcr() {
            n.g(n.this);
        }
    };
    private j ekY = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.jvE;
        nVar.jvE = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.ekY.a(this.jup);
        this.jvF = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String wE(String str) {
        this.jvJ = com.baidu.tbadk.coreExtra.model.f.aMh();
        this.jvK = com.baidu.tbadk.coreExtra.model.f.aMi();
        this.jvL = com.baidu.tbadk.coreExtra.model.f.aMj();
        this.jvM = com.baidu.tbadk.coreExtra.model.f.aMk();
        this.jvA = str;
        this.mVideoPath = this.jvB ? this.jvA : s.aw(str, this.jvJ);
        if (this.jvF != null) {
            v.a("start_play", this.jvA, czb(), (int) this.jvF.czl(), this.jvF.getDuration());
        }
        this.jvC = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyz() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyA() {
        return this.jvJ;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyB() {
        return this.jvK;
    }

    @Override // com.baidu.tieba.play.d
    public int cyC() {
        return com.baidu.tbadk.coreExtra.model.f.aMl() ? this.jvL : this.jvM;
    }

    @Override // com.baidu.tieba.play.d
    public String cyw() {
        return this.jvA;
    }

    @Override // com.baidu.tieba.play.d
    public void cyD() {
        if (this.jvJ && this.jvK && cyz() && czb()) {
            s.d(this.mContext, this.jvA, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ew(long j) {
        this.jvN = j;
        cza();
        if (this.jvC > 0) {
            this.jvD = System.currentTimeMillis() - this.jvC;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.jvA) && (parse = Uri.parse(n.this.jvA)) != null) {
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
            this.guB += currentTimeMillis;
            ex(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.ekY != null) {
            this.ekY.start();
        }
        this.jvH = true;
    }

    @Override // com.baidu.tieba.play.d
    public void GY(String str) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvP);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvO);
        wJ(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guB += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyX();
        if (this.ekY != null) {
            this.ekY.stop();
        }
        if (this.jvD > 0 && this.jvF != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cy("service_ip", this.mHost);
            anVar.cy("video_url", this.jvA);
            anVar.s("video_size", this.jvF.czl());
            anVar.X("video_duration", this.jvF.getDuration());
            anVar.cy("video_resolution", this.jvF.czm());
            anVar.X("loading_count", this.jvE);
            anVar.s("user_watch_time", this.guB / 1000);
            anVar.s("start_play_time", this.jvD);
            TiebaStatic.log(anVar);
        }
        if (this.jvF != null && this.jvD > 0) {
            v.a("stop_play", this.jvA, czb(), (int) this.jvF.czl(), this.jvF.getDuration());
        }
        cyW();
        this.jvD = 0L;
        this.guB = 0L;
        this.jvE = 0;
        this.jvC = 0L;
        this.mStartTime = 0L;
        this.jvH = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.jvG = bVar;
    }

    private void ex(long j) {
        if (this.jvG != null) {
            this.jvG.setVideoWatchDuration(this.jvG.getVideoWatchDuration() + j);
        }
    }

    private void cyW() {
        if (this.jvG != null && this.jvH) {
            TbSingleton.getInstance().putVideoRecord(this.jvG.getThreadId(), (int) (this.jvG.getVideoWatchDuration() / 1000));
        }
    }

    private void cyX() {
        if (this.guB >= 0 && this.guB < 86400000) {
            if (this.guB > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.guB);
                anVar.cy("obj_type", this.jvz);
                anVar.s("playduration", this.jvN);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cy("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jvy != null) {
                    this.jvy.e(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.tu("obj_param5") && this.jvF.aAg() != null) {
                    if (this.jvF.aAg().getBaijiahaoData() != null) {
                        if (this.jvF.aAg().getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.jvF.aAg().getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.guB, this.jvz, this.jvy, "", this.jvN);
            } else if (this.jvH) {
                l.a(this.guB, this.jvz, this.jvy, "", this.jvN);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cyx() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvP);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvO);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guB += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyX();
        if (this.ekY != null) {
            this.ekY.stop();
        }
        if (this.jvD > 0 && this.jvF != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cy("service_ip", this.mHost);
            anVar.cy("video_url", this.jvA);
            anVar.s("video_size", this.jvF.czl());
            anVar.X("video_duration", this.jvF.getDuration());
            anVar.cy("video_resolution", this.jvF.czm());
            anVar.X("loading_count", this.jvE);
            anVar.s("user_watch_time", this.guB / 1000);
            anVar.s("start_play_time", this.jvD);
            TiebaStatic.log(anVar);
        }
        if (this.jvF != null && this.jvD > 0) {
            v.a("stop_play", this.jvA, czb(), (int) this.jvF.czl(), this.jvF.getDuration());
        }
        cyW();
        this.jvD = 0L;
        this.guB = 0L;
        this.jvE = 0;
        this.jvC = 0L;
        this.mStartTime = 0L;
        this.jvH = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guB += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyW();
        this.jvH = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guB += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyW();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyy() {
        return s.wF(this.jvA) != null;
    }

    public void cyY() {
        this.jvB = true;
    }

    public void Hb(String str) {
        this.jvz = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cyE() {
        return this.ekY;
    }

    public void a(j.b bVar) {
        if (this.ekY != null) {
            this.ekY.a(bVar);
        }
    }

    public u cyZ() {
        return this.jvF;
    }

    public void cza() {
        if (!this.jvJ) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvP);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jvP, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void Ap(int i) {
        if (czb()) {
            s.d(this.mContext, this.jvA, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvO);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvO, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void wJ(String str) {
        if (czb()) {
            s.aI(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czb() {
        return (this.jvB || this.mVideoPath == null || this.mVideoPath.equals(this.jvA)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.jvy = yVar;
    }

    public y czc() {
        return this.jvy;
    }
}
