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
    private y juH;
    private String juJ;
    private u juO;
    private com.baidu.tieba.video.b juP;
    private boolean juQ;
    private long juV;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String juI = "1";
    private boolean juK = false;
    private long gsy = 0;
    private long juL = 0;
    private long mStartTime = 0;
    private long juM = 0;
    private int juN = 0;
    private boolean juR = false;
    private boolean juS = false;
    private int juT = 8;
    private int juU = 16;
    private Runnable juW = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.juR && n.this.juS && n.this.cxe() && n.this.cxF()) {
                s.d(n.this.mContext, n.this.juJ, -1);
            }
        }
    };
    private Runnable juX = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cxF()) {
                s.aH(n.this.mContext, n.this.juJ);
            } else if (!n.this.juK) {
                s.wm(n.this.juJ);
            }
        }
    };
    private j.c jtA = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aZZ() {
            n.g(n.this);
        }
    };
    private j egT = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.juN;
        nVar.juN = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.egT.a(this.jtA);
        this.juO = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String wk(String str) {
        this.juR = com.baidu.tbadk.coreExtra.model.f.aJL();
        this.juS = com.baidu.tbadk.coreExtra.model.f.aJM();
        this.juT = com.baidu.tbadk.coreExtra.model.f.aJN();
        this.juU = com.baidu.tbadk.coreExtra.model.f.aJO();
        this.juJ = str;
        this.mVideoPath = this.juK ? this.juJ : s.aw(str, this.juR);
        if (this.juO != null) {
            v.a("start_play", this.juJ, cxF(), (int) this.juO.cxP(), this.juO.getDuration());
        }
        this.juL = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxe() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxf() {
        return this.juR;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxg() {
        return this.juS;
    }

    @Override // com.baidu.tieba.play.d
    public int cxh() {
        return com.baidu.tbadk.coreExtra.model.f.aJP() ? this.juT : this.juU;
    }

    @Override // com.baidu.tieba.play.d
    public String cxb() {
        return this.juJ;
    }

    @Override // com.baidu.tieba.play.d
    public void cxi() {
        if (this.juR && this.juS && cxe() && cxF()) {
            s.d(this.mContext, this.juJ, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ez(long j) {
        this.juV = j;
        cxE();
        if (this.juL > 0) {
            this.juM = System.currentTimeMillis() - this.juL;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.juJ) && (parse = Uri.parse(n.this.juJ)) != null) {
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
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.egT != null) {
            this.egT.start();
        }
        this.juQ = true;
    }

    @Override // com.baidu.tieba.play.d
    public void GK(String str) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juX);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juW);
        wp(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxB();
        if (this.egT != null) {
            this.egT.stop();
        }
        if (this.juM > 0 && this.juO != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cp("service_ip", this.mHost);
            anVar.cp("video_url", this.juJ);
            anVar.s("video_size", this.juO.cxP());
            anVar.Z("video_duration", this.juO.getDuration());
            anVar.cp("video_resolution", this.juO.cxQ());
            anVar.Z("loading_count", this.juN);
            anVar.s("user_watch_time", this.gsy / 1000);
            anVar.s("start_play_time", this.juM);
            TiebaStatic.log(anVar);
        }
        if (this.juO != null && this.juM > 0) {
            v.a("stop_play", this.juJ, cxF(), (int) this.juO.cxP(), this.juO.getDuration());
        }
        cxA();
        this.juM = 0L;
        this.gsy = 0L;
        this.juN = 0;
        this.juL = 0L;
        this.mStartTime = 0L;
        this.juQ = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.juP = bVar;
    }

    private void eA(long j) {
        if (this.juP != null) {
            this.juP.setVideoWatchDuration(this.juP.getVideoWatchDuration() + j);
        }
    }

    private void cxA() {
        if (this.juP != null && this.juQ) {
            TbSingleton.getInstance().putVideoRecord(this.juP.getThreadId(), (int) (this.juP.getVideoWatchDuration() / 1000));
        }
    }

    private void cxB() {
        if (this.gsy >= 0 && this.gsy < 86400000) {
            if (this.gsy > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gsy);
                anVar.cp("obj_type", this.juI);
                anVar.s("playduration", this.juV);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cp("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.juH != null) {
                    this.juH.d(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.te("obj_param5") && this.juO.axQ() != null) {
                    if (this.juO.axQ().getBaijiahaoData() != null) {
                        if (this.juO.axQ().getBaijiahaoData().oriUgcType == 2) {
                            anVar.Z("obj_param5", 3);
                        } else if (this.juO.axQ().getBaijiahaoData().oriUgcType == 4) {
                            anVar.Z("obj_param5", 2);
                        }
                    } else {
                        anVar.Z("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.gsy, this.juI, this.juH, "", this.juV);
            } else if (this.juQ) {
                l.a(this.gsy, this.juI, this.juH, "", this.juV);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cxc() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juX);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juW);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxB();
        if (this.egT != null) {
            this.egT.stop();
        }
        if (this.juM > 0 && this.juO != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cp("service_ip", this.mHost);
            anVar.cp("video_url", this.juJ);
            anVar.s("video_size", this.juO.cxP());
            anVar.Z("video_duration", this.juO.getDuration());
            anVar.cp("video_resolution", this.juO.cxQ());
            anVar.Z("loading_count", this.juN);
            anVar.s("user_watch_time", this.gsy / 1000);
            anVar.s("start_play_time", this.juM);
            TiebaStatic.log(anVar);
        }
        if (this.juO != null && this.juM > 0) {
            v.a("stop_play", this.juJ, cxF(), (int) this.juO.cxP(), this.juO.getDuration());
        }
        cxA();
        this.juM = 0L;
        this.gsy = 0L;
        this.juN = 0;
        this.juL = 0L;
        this.mStartTime = 0L;
        this.juQ = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxA();
        this.juQ = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxA();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxd() {
        return s.wl(this.juJ) != null;
    }

    public void cxC() {
        this.juK = true;
    }

    public void GN(String str) {
        this.juI = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cxj() {
        return this.egT;
    }

    public void a(j.b bVar) {
        if (this.egT != null) {
            this.egT.a(bVar);
        }
    }

    public u cxD() {
        return this.juO;
    }

    public void cxE() {
        if (!this.juR) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juX);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.juX, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void Ag(int i) {
        if (cxF()) {
            s.d(this.mContext, this.juJ, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juW);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.juW, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void wp(String str) {
        if (cxF()) {
            s.aI(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxF() {
        return (this.juK || this.mVideoPath == null || this.mVideoPath.equals(this.juJ)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.juH = yVar;
    }

    public y cxG() {
        return this.juH;
    }
}
