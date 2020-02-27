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
    private u jvD;
    private com.baidu.tieba.video.b jvE;
    private boolean jvF;
    private long jvL;
    private y jvw;
    private String jvy;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String jvx = "1";
    private boolean jvz = false;
    private long guz = 0;
    private long jvA = 0;
    private long mStartTime = 0;
    private long jvB = 0;
    private int jvC = 0;
    public boolean jvG = false;
    private boolean jvH = false;
    private boolean jvI = false;
    private int jvJ = 8;
    private int jvK = 16;
    private Runnable jvM = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.jvH && n.this.jvI && n.this.cyx() && n.this.cyZ()) {
                s.d(n.this.mContext, n.this.jvy, -1);
            }
        }
    };
    private Runnable jvN = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cyZ()) {
                s.aH(n.this.mContext, n.this.jvy);
            } else if (!n.this.jvz) {
                s.wG(n.this.jvy);
            }
        }
    };
    private j.c jun = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bcp() {
            n.g(n.this);
        }
    };
    private j ekX = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.jvC;
        nVar.jvC = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.ekX.a(this.jun);
        this.jvD = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String wE(String str) {
        this.jvH = com.baidu.tbadk.coreExtra.model.f.aMf();
        this.jvI = com.baidu.tbadk.coreExtra.model.f.aMg();
        this.jvJ = com.baidu.tbadk.coreExtra.model.f.aMh();
        this.jvK = com.baidu.tbadk.coreExtra.model.f.aMi();
        this.jvy = str;
        this.mVideoPath = this.jvz ? this.jvy : s.aw(str, this.jvH);
        if (this.jvD != null) {
            v.a("start_play", this.jvy, cyZ(), (int) this.jvD.czj(), this.jvD.getDuration());
        }
        this.jvA = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyx() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyy() {
        return this.jvH;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyz() {
        return this.jvI;
    }

    @Override // com.baidu.tieba.play.d
    public int cyA() {
        return com.baidu.tbadk.coreExtra.model.f.aMj() ? this.jvJ : this.jvK;
    }

    @Override // com.baidu.tieba.play.d
    public String cyu() {
        return this.jvy;
    }

    @Override // com.baidu.tieba.play.d
    public void cyB() {
        if (this.jvH && this.jvI && cyx() && cyZ()) {
            s.d(this.mContext, this.jvy, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ew(long j) {
        this.jvL = j;
        cyY();
        if (this.jvA > 0) {
            this.jvB = System.currentTimeMillis() - this.jvA;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.jvy) && (parse = Uri.parse(n.this.jvy)) != null) {
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
            this.guz += currentTimeMillis;
            ex(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.ekX != null) {
            this.ekX.start();
        }
        this.jvF = true;
    }

    @Override // com.baidu.tieba.play.d
    public void GY(String str) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvN);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvM);
        wJ(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guz += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyV();
        if (this.ekX != null) {
            this.ekX.stop();
        }
        if (this.jvB > 0 && this.jvD != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cy("service_ip", this.mHost);
            anVar.cy("video_url", this.jvy);
            anVar.s("video_size", this.jvD.czj());
            anVar.X("video_duration", this.jvD.getDuration());
            anVar.cy("video_resolution", this.jvD.czk());
            anVar.X("loading_count", this.jvC);
            anVar.s("user_watch_time", this.guz / 1000);
            anVar.s("start_play_time", this.jvB);
            TiebaStatic.log(anVar);
        }
        if (this.jvD != null && this.jvB > 0) {
            v.a("stop_play", this.jvy, cyZ(), (int) this.jvD.czj(), this.jvD.getDuration());
        }
        cyU();
        this.jvB = 0L;
        this.guz = 0L;
        this.jvC = 0;
        this.jvA = 0L;
        this.mStartTime = 0L;
        this.jvF = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.jvE = bVar;
    }

    private void ex(long j) {
        if (this.jvE != null) {
            this.jvE.setVideoWatchDuration(this.jvE.getVideoWatchDuration() + j);
        }
    }

    private void cyU() {
        if (this.jvE != null && this.jvF) {
            TbSingleton.getInstance().putVideoRecord(this.jvE.getThreadId(), (int) (this.jvE.getVideoWatchDuration() / 1000));
        }
    }

    private void cyV() {
        if (this.guz >= 0 && this.guz < 86400000) {
            if (this.guz > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.guz);
                anVar.cy("obj_type", this.jvx);
                anVar.s("playduration", this.jvL);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cy("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jvw != null) {
                    this.jvw.e(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.tu("obj_param5") && this.jvD.aAe() != null) {
                    if (this.jvD.aAe().getBaijiahaoData() != null) {
                        if (this.jvD.aAe().getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.jvD.aAe().getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.guz, this.jvx, this.jvw, "", this.jvL);
            } else if (this.jvF) {
                l.a(this.guz, this.jvx, this.jvw, "", this.jvL);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cyv() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvN);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvM);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guz += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyV();
        if (this.ekX != null) {
            this.ekX.stop();
        }
        if (this.jvB > 0 && this.jvD != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cy("service_ip", this.mHost);
            anVar.cy("video_url", this.jvy);
            anVar.s("video_size", this.jvD.czj());
            anVar.X("video_duration", this.jvD.getDuration());
            anVar.cy("video_resolution", this.jvD.czk());
            anVar.X("loading_count", this.jvC);
            anVar.s("user_watch_time", this.guz / 1000);
            anVar.s("start_play_time", this.jvB);
            TiebaStatic.log(anVar);
        }
        if (this.jvD != null && this.jvB > 0) {
            v.a("stop_play", this.jvy, cyZ(), (int) this.jvD.czj(), this.jvD.getDuration());
        }
        cyU();
        this.jvB = 0L;
        this.guz = 0L;
        this.jvC = 0;
        this.jvA = 0L;
        this.mStartTime = 0L;
        this.jvF = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guz += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyU();
        this.jvF = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guz += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyU();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyw() {
        return s.wF(this.jvy) != null;
    }

    public void cyW() {
        this.jvz = true;
    }

    public void Hb(String str) {
        this.jvx = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cyC() {
        return this.ekX;
    }

    public void a(j.b bVar) {
        if (this.ekX != null) {
            this.ekX.a(bVar);
        }
    }

    public u cyX() {
        return this.jvD;
    }

    public void cyY() {
        if (!this.jvH) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvN);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jvN, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void Ap(int i) {
        if (cyZ()) {
            s.d(this.mContext, this.jvy, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvM);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvM, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void wJ(String str) {
        if (cyZ()) {
            s.aI(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyZ() {
        return (this.jvz || this.mVideoPath == null || this.mVideoPath.equals(this.jvy)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.jvw = yVar;
    }

    public y cza() {
        return this.jvw;
    }
}
