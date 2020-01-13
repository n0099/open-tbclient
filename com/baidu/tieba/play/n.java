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
    private y juC;
    private String juE;
    private u juJ;
    private com.baidu.tieba.video.b juK;
    private boolean juL;
    private long juQ;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String juD = "1";
    private boolean juF = false;
    private long gsy = 0;
    private long juG = 0;
    private long mStartTime = 0;
    private long juH = 0;
    private int juI = 0;
    private boolean juM = false;
    private boolean juN = false;
    private int juO = 8;
    private int juP = 16;
    private Runnable juR = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.juM && n.this.juN && n.this.cxc() && n.this.cxD()) {
                s.d(n.this.mContext, n.this.juE, -1);
            }
        }
    };
    private Runnable juS = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cxD()) {
                s.aH(n.this.mContext, n.this.juE);
            } else if (!n.this.juF) {
                s.wm(n.this.juE);
            }
        }
    };
    private j.c jtv = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aZZ() {
            n.g(n.this);
        }
    };
    private j egT = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.juI;
        nVar.juI = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.egT.a(this.jtv);
        this.juJ = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String wk(String str) {
        this.juM = com.baidu.tbadk.coreExtra.model.f.aJL();
        this.juN = com.baidu.tbadk.coreExtra.model.f.aJM();
        this.juO = com.baidu.tbadk.coreExtra.model.f.aJN();
        this.juP = com.baidu.tbadk.coreExtra.model.f.aJO();
        this.juE = str;
        this.mVideoPath = this.juF ? this.juE : s.aw(str, this.juM);
        if (this.juJ != null) {
            v.a("start_play", this.juE, cxD(), (int) this.juJ.cxN(), this.juJ.getDuration());
        }
        this.juG = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxc() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxd() {
        return this.juM;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxe() {
        return this.juN;
    }

    @Override // com.baidu.tieba.play.d
    public int cxf() {
        return com.baidu.tbadk.coreExtra.model.f.aJP() ? this.juO : this.juP;
    }

    @Override // com.baidu.tieba.play.d
    public String cwZ() {
        return this.juE;
    }

    @Override // com.baidu.tieba.play.d
    public void cxg() {
        if (this.juM && this.juN && cxc() && cxD()) {
            s.d(this.mContext, this.juE, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ez(long j) {
        this.juQ = j;
        cxC();
        if (this.juG > 0) {
            this.juH = System.currentTimeMillis() - this.juG;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.juE) && (parse = Uri.parse(n.this.juE)) != null) {
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
        this.juL = true;
    }

    @Override // com.baidu.tieba.play.d
    public void GK(String str) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juS);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juR);
        wp(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxz();
        if (this.egT != null) {
            this.egT.stop();
        }
        if (this.juH > 0 && this.juJ != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cp("service_ip", this.mHost);
            anVar.cp("video_url", this.juE);
            anVar.s("video_size", this.juJ.cxN());
            anVar.Z("video_duration", this.juJ.getDuration());
            anVar.cp("video_resolution", this.juJ.cxO());
            anVar.Z("loading_count", this.juI);
            anVar.s("user_watch_time", this.gsy / 1000);
            anVar.s("start_play_time", this.juH);
            TiebaStatic.log(anVar);
        }
        if (this.juJ != null && this.juH > 0) {
            v.a("stop_play", this.juE, cxD(), (int) this.juJ.cxN(), this.juJ.getDuration());
        }
        cxy();
        this.juH = 0L;
        this.gsy = 0L;
        this.juI = 0;
        this.juG = 0L;
        this.mStartTime = 0L;
        this.juL = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.juK = bVar;
    }

    private void eA(long j) {
        if (this.juK != null) {
            this.juK.setVideoWatchDuration(this.juK.getVideoWatchDuration() + j);
        }
    }

    private void cxy() {
        if (this.juK != null && this.juL) {
            TbSingleton.getInstance().putVideoRecord(this.juK.getThreadId(), (int) (this.juK.getVideoWatchDuration() / 1000));
        }
    }

    private void cxz() {
        if (this.gsy >= 0 && this.gsy < 86400000) {
            if (this.gsy > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gsy);
                anVar.cp("obj_type", this.juD);
                anVar.s("playduration", this.juQ);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cp("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.juC != null) {
                    this.juC.d(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.te("obj_param5") && this.juJ.axQ() != null) {
                    if (this.juJ.axQ().getBaijiahaoData() != null) {
                        if (this.juJ.axQ().getBaijiahaoData().oriUgcType == 2) {
                            anVar.Z("obj_param5", 3);
                        } else if (this.juJ.axQ().getBaijiahaoData().oriUgcType == 4) {
                            anVar.Z("obj_param5", 2);
                        }
                    } else {
                        anVar.Z("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.gsy, this.juD, this.juC, "", this.juQ);
            } else if (this.juL) {
                l.a(this.gsy, this.juD, this.juC, "", this.juQ);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cxa() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juS);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juR);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxz();
        if (this.egT != null) {
            this.egT.stop();
        }
        if (this.juH > 0 && this.juJ != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.cp("service_ip", this.mHost);
            anVar.cp("video_url", this.juE);
            anVar.s("video_size", this.juJ.cxN());
            anVar.Z("video_duration", this.juJ.getDuration());
            anVar.cp("video_resolution", this.juJ.cxO());
            anVar.Z("loading_count", this.juI);
            anVar.s("user_watch_time", this.gsy / 1000);
            anVar.s("start_play_time", this.juH);
            TiebaStatic.log(anVar);
        }
        if (this.juJ != null && this.juH > 0) {
            v.a("stop_play", this.juE, cxD(), (int) this.juJ.cxN(), this.juJ.getDuration());
        }
        cxy();
        this.juH = 0L;
        this.gsy = 0L;
        this.juI = 0;
        this.juG = 0L;
        this.mStartTime = 0L;
        this.juL = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxy();
        this.juL = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.gsy += currentTimeMillis;
            eA(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cxy();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cxb() {
        return s.wl(this.juE) != null;
    }

    public void cxA() {
        this.juF = true;
    }

    public void GN(String str) {
        this.juD = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cxh() {
        return this.egT;
    }

    public void a(j.b bVar) {
        if (this.egT != null) {
            this.egT.a(bVar);
        }
    }

    public u cxB() {
        return this.juJ;
    }

    public void cxC() {
        if (!this.juM) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juS);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.juS, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void Ag(int i) {
        if (cxD()) {
            s.d(this.mContext, this.juE, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juR);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.juR, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void wp(String str) {
        if (cxD()) {
            s.aI(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxD() {
        return (this.juF || this.mVideoPath == null || this.mVideoPath.equals(this.juE)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.juC = yVar;
    }

    public y cxE() {
        return this.juC;
    }
}
