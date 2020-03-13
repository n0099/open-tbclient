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
    private y jvK;
    private String jvM;
    private u jvR;
    private com.baidu.tieba.video.b jvS;
    private boolean jvT;
    private long jvZ;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String jvL = "1";
    private boolean jvN = false;
    private long guN = 0;
    private long jvO = 0;
    private long mStartTime = 0;
    private long jvP = 0;
    private int jvQ = 0;
    public boolean jvU = false;
    private boolean jvV = false;
    private boolean jvW = false;
    private int jvX = 8;
    private int jvY = 16;
    private Runnable jwa = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.jvV && n.this.jvW && n.this.cyA() && n.this.czc()) {
                s.d(n.this.mContext, n.this.jvM, -1);
            }
        }
    };
    private Runnable jwb = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.czc()) {
                s.aH(n.this.mContext, n.this.jvM);
            } else if (!n.this.jvN) {
                s.wH(n.this.jvM);
            }
        }
    };
    private j.c juB = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bcs() {
            n.g(n.this);
        }
    };
    private j ell = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.jvQ;
        nVar.jvQ = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.ell.a(this.juB);
        this.jvR = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String wF(String str) {
        this.jvV = com.baidu.tbadk.coreExtra.model.f.aMi();
        this.jvW = com.baidu.tbadk.coreExtra.model.f.aMj();
        this.jvX = com.baidu.tbadk.coreExtra.model.f.aMk();
        this.jvY = com.baidu.tbadk.coreExtra.model.f.aMl();
        this.jvM = str;
        this.mVideoPath = this.jvN ? this.jvM : s.aw(str, this.jvV);
        if (this.jvR != null) {
            v.a("start_play", this.jvM, czc(), (int) this.jvR.czm(), this.jvR.getDuration());
        }
        this.jvO = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyA() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyB() {
        return this.jvV;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyC() {
        return this.jvW;
    }

    @Override // com.baidu.tieba.play.d
    public int cyD() {
        return com.baidu.tbadk.coreExtra.model.f.aMm() ? this.jvX : this.jvY;
    }

    @Override // com.baidu.tieba.play.d
    public String cyx() {
        return this.jvM;
    }

    @Override // com.baidu.tieba.play.d
    public void cyE() {
        if (this.jvV && this.jvW && cyA() && czc()) {
            s.d(this.mContext, this.jvM, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ew(long j) {
        this.jvZ = j;
        czb();
        if (this.jvO > 0) {
            this.jvP = System.currentTimeMillis() - this.jvO;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.jvM) && (parse = Uri.parse(n.this.jvM)) != null) {
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
            this.guN += currentTimeMillis;
            ex(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.ell != null) {
            this.ell.start();
        }
        this.jvT = true;
    }

    @Override // com.baidu.tieba.play.d
    public void GZ(String str) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwb);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwa);
        wK(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guN += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyY();
        if (this.ell != null) {
            this.ell.stop();
        }
        if (this.jvP > 0 && this.jvR != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cy("service_ip", this.mHost);
            anVar.cy("video_url", this.jvM);
            anVar.s("video_size", this.jvR.czm());
            anVar.X("video_duration", this.jvR.getDuration());
            anVar.cy("video_resolution", this.jvR.czn());
            anVar.X("loading_count", this.jvQ);
            anVar.s("user_watch_time", this.guN / 1000);
            anVar.s("start_play_time", this.jvP);
            TiebaStatic.log(anVar);
        }
        if (this.jvR != null && this.jvP > 0) {
            v.a("stop_play", this.jvM, czc(), (int) this.jvR.czm(), this.jvR.getDuration());
        }
        cyX();
        this.jvP = 0L;
        this.guN = 0L;
        this.jvQ = 0;
        this.jvO = 0L;
        this.mStartTime = 0L;
        this.jvT = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.jvS = bVar;
    }

    private void ex(long j) {
        if (this.jvS != null) {
            this.jvS.setVideoWatchDuration(this.jvS.getVideoWatchDuration() + j);
        }
    }

    private void cyX() {
        if (this.jvS != null && this.jvT) {
            TbSingleton.getInstance().putVideoRecord(this.jvS.getThreadId(), (int) (this.jvS.getVideoWatchDuration() / 1000));
        }
    }

    private void cyY() {
        if (this.guN >= 0 && this.guN < 86400000) {
            if (this.guN > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.guN);
                anVar.cy("obj_type", this.jvL);
                anVar.s("playduration", this.jvZ);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cy("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jvK != null) {
                    this.jvK.e(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.tu("obj_param5") && this.jvR.aAg() != null) {
                    if (this.jvR.aAg().getBaijiahaoData() != null) {
                        if (this.jvR.aAg().getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.jvR.aAg().getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.guN, this.jvL, this.jvK, "", this.jvZ);
            } else if (this.jvT) {
                l.a(this.guN, this.jvL, this.jvK, "", this.jvZ);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cyy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwb);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwa);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guN += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyY();
        if (this.ell != null) {
            this.ell.stop();
        }
        if (this.jvP > 0 && this.jvR != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cy("service_ip", this.mHost);
            anVar.cy("video_url", this.jvM);
            anVar.s("video_size", this.jvR.czm());
            anVar.X("video_duration", this.jvR.getDuration());
            anVar.cy("video_resolution", this.jvR.czn());
            anVar.X("loading_count", this.jvQ);
            anVar.s("user_watch_time", this.guN / 1000);
            anVar.s("start_play_time", this.jvP);
            TiebaStatic.log(anVar);
        }
        if (this.jvR != null && this.jvP > 0) {
            v.a("stop_play", this.jvM, czc(), (int) this.jvR.czm(), this.jvR.getDuration());
        }
        cyX();
        this.jvP = 0L;
        this.guN = 0L;
        this.jvQ = 0;
        this.jvO = 0L;
        this.mStartTime = 0L;
        this.jvT = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guN += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyX();
        this.jvT = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.guN += currentTimeMillis;
            ex(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cyX();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyz() {
        return s.wG(this.jvM) != null;
    }

    public void cyZ() {
        this.jvN = true;
    }

    public void Hc(String str) {
        this.jvL = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cyF() {
        return this.ell;
    }

    public void a(j.b bVar) {
        if (this.ell != null) {
            this.ell.a(bVar);
        }
    }

    public u cza() {
        return this.jvR;
    }

    public void czb() {
        if (!this.jvV) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwb);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jwb, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void Ap(int i) {
        if (czc()) {
            s.d(this.mContext, this.jvM, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwa);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jwa, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void wK(String str) {
        if (czc()) {
            s.aI(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czc() {
        return (this.jvN || this.mVideoPath == null || this.mVideoPath.equals(this.jvM)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.jvK = yVar;
    }

    public y czd() {
        return this.jvK;
    }
}
