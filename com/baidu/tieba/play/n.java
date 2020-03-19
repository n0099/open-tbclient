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
    private y jxj;
    private String jxl;
    private u jxq;
    private com.baidu.tieba.video.b jxr;
    private boolean jxs;
    private long jxy;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String jxk = "1";
    private boolean jxm = false;
    private long gvr = 0;
    private long jxn = 0;
    private long mStartTime = 0;
    private long jxo = 0;
    private int jxp = 0;
    public boolean jxt = false;
    private boolean jxu = false;
    private boolean jxv = false;
    private int jxw = 8;
    private int jxx = 16;
    private Runnable jxz = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.jxu && n.this.jxv && n.this.cyT() && n.this.czv()) {
                s.d(n.this.mContext, n.this.jxl, -1);
            }
        }
    };
    private Runnable jxA = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.czv()) {
                s.aH(n.this.mContext, n.this.jxl);
            } else if (!n.this.jxm) {
                s.wI(n.this.jxl);
            }
        }
    };
    private j.c jwa = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bcw() {
            n.g(n.this);
        }
    };
    private j elB = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.jxp;
        nVar.jxp = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.elB.a(this.jwa);
        this.jxq = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String wG(String str) {
        this.jxu = com.baidu.tbadk.coreExtra.model.f.aMm();
        this.jxv = com.baidu.tbadk.coreExtra.model.f.aMn();
        this.jxw = com.baidu.tbadk.coreExtra.model.f.aMo();
        this.jxx = com.baidu.tbadk.coreExtra.model.f.aMp();
        this.jxl = str;
        this.mVideoPath = this.jxm ? this.jxl : s.aw(str, this.jxu);
        if (this.jxq != null) {
            v.a("start_play", this.jxl, czv(), (int) this.jxq.czF(), this.jxq.getDuration());
        }
        this.jxn = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyT() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyU() {
        return this.jxu;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyV() {
        return this.jxv;
    }

    @Override // com.baidu.tieba.play.d
    public int cyW() {
        return com.baidu.tbadk.coreExtra.model.f.aMq() ? this.jxw : this.jxx;
    }

    @Override // com.baidu.tieba.play.d
    public String cyQ() {
        return this.jxl;
    }

    @Override // com.baidu.tieba.play.d
    public void cyX() {
        if (this.jxu && this.jxv && cyT() && czv()) {
            s.d(this.mContext, this.jxl, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ex(long j) {
        this.jxy = j;
        czu();
        if (this.jxn > 0) {
            this.jxo = System.currentTimeMillis() - this.jxn;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.jxl) && (parse = Uri.parse(n.this.jxl)) != null) {
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
            this.gvr += currentTimeMillis;
            ey(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.elB != null) {
            this.elB.start();
        }
        this.jxs = true;
    }

    @Override // com.baidu.tieba.play.d
    public void GZ(String str) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxA);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxz);
        wL(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gvr += currentTimeMillis;
            ey(currentTimeMillis);
            this.mStartTime = 0L;
        }
        czr();
        if (this.elB != null) {
            this.elB.stop();
        }
        if (this.jxo > 0 && this.jxq != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cx("service_ip", this.mHost);
            anVar.cx("video_url", this.jxl);
            anVar.s("video_size", this.jxq.czF());
            anVar.X("video_duration", this.jxq.getDuration());
            anVar.cx("video_resolution", this.jxq.czG());
            anVar.X("loading_count", this.jxp);
            anVar.s("user_watch_time", this.gvr / 1000);
            anVar.s("start_play_time", this.jxo);
            TiebaStatic.log(anVar);
        }
        if (this.jxq != null && this.jxo > 0) {
            v.a("stop_play", this.jxl, czv(), (int) this.jxq.czF(), this.jxq.getDuration());
        }
        czq();
        this.jxo = 0L;
        this.gvr = 0L;
        this.jxp = 0;
        this.jxn = 0L;
        this.mStartTime = 0L;
        this.jxs = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.jxr = bVar;
    }

    private void ey(long j) {
        if (this.jxr != null) {
            this.jxr.setVideoWatchDuration(this.jxr.getVideoWatchDuration() + j);
        }
    }

    private void czq() {
        if (this.jxr != null && this.jxs) {
            TbSingleton.getInstance().putVideoRecord(this.jxr.getThreadId(), (int) (this.jxr.getVideoWatchDuration() / 1000));
        }
    }

    private void czr() {
        if (this.gvr >= 0 && this.gvr < 86400000) {
            if (this.gvr > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gvr);
                anVar.cx("obj_type", this.jxk);
                anVar.s("playduration", this.jxy);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cx("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jxj != null) {
                    this.jxj.f(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.tu("obj_param5") && this.jxq.aAj() != null) {
                    if (this.jxq.aAj().getBaijiahaoData() != null) {
                        if (this.jxq.aAj().getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.jxq.aAj().getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.gvr, this.jxk, this.jxj, "", this.jxy);
            } else if (this.jxs) {
                l.a(this.gvr, this.jxk, this.jxj, "", this.jxy);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cyR() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxA);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxz);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gvr += currentTimeMillis;
            ey(currentTimeMillis);
            this.mStartTime = 0L;
        }
        czr();
        if (this.elB != null) {
            this.elB.stop();
        }
        if (this.jxo > 0 && this.jxq != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cx("service_ip", this.mHost);
            anVar.cx("video_url", this.jxl);
            anVar.s("video_size", this.jxq.czF());
            anVar.X("video_duration", this.jxq.getDuration());
            anVar.cx("video_resolution", this.jxq.czG());
            anVar.X("loading_count", this.jxp);
            anVar.s("user_watch_time", this.gvr / 1000);
            anVar.s("start_play_time", this.jxo);
            TiebaStatic.log(anVar);
        }
        if (this.jxq != null && this.jxo > 0) {
            v.a("stop_play", this.jxl, czv(), (int) this.jxq.czF(), this.jxq.getDuration());
        }
        czq();
        this.jxo = 0L;
        this.gvr = 0L;
        this.jxp = 0;
        this.jxn = 0L;
        this.mStartTime = 0L;
        this.jxs = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gvr += currentTimeMillis;
            ey(currentTimeMillis);
            this.mStartTime = 0L;
        }
        czq();
        this.jxs = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gvr += currentTimeMillis;
            ey(currentTimeMillis);
            this.mStartTime = 0L;
        }
        czq();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cyS() {
        return s.wH(this.jxl) != null;
    }

    public void czs() {
        this.jxm = true;
    }

    public void Hc(String str) {
        this.jxk = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cyY() {
        return this.elB;
    }

    public void a(j.b bVar) {
        if (this.elB != null) {
            this.elB.a(bVar);
        }
    }

    public u czt() {
        return this.jxq;
    }

    public void czu() {
        if (!this.jxu) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxA);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jxA, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void Ax(int i) {
        if (czv()) {
            s.d(this.mContext, this.jxl, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxz);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jxz, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void wL(String str) {
        if (czv()) {
            s.aI(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czv() {
        return (this.jxm || this.mVideoPath == null || this.mVideoPath.equals(this.jxl)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.jxj = yVar;
    }

    public y czw() {
        return this.jxj;
    }
}
