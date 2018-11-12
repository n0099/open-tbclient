package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private z gwK;
    private String gwM;
    private v gwR;
    private com.baidu.tieba.video.b gwS;
    private boolean gwT;
    private long gwY;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String gwL = "1";
    private boolean gwN = false;
    private long dHc = 0;
    private long gwO = 0;
    private long mStartTime = 0;
    private long gwP = 0;
    private int gwQ = 0;
    private boolean gwU = false;
    private boolean gwV = false;
    private int gwW = 8;
    private int gwX = 16;
    private Runnable gwZ = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gwU && n.this.gwV && n.this.bpt() && n.this.bpQ()) {
                t.g(n.this.mContext, n.this.gwM, -1);
            }
        }
    };
    private Runnable gxa = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bpQ()) {
                t.ap(n.this.mContext, n.this.gwM);
            } else if (!n.this.gwN) {
                t.jk(n.this.gwM);
            }
        }
    };
    private j.c gvz = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Zg() {
            n.g(n.this);
        }
    };
    private j bKz = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gwQ;
        nVar.gwQ = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bKz.a(this.gvz);
        this.gwR = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String ji(String str) {
        this.gwU = com.baidu.tbadk.coreExtra.model.f.IR();
        this.gwV = com.baidu.tbadk.coreExtra.model.f.IS();
        this.gwW = com.baidu.tbadk.coreExtra.model.f.IT();
        this.gwX = com.baidu.tbadk.coreExtra.model.f.IU();
        this.gwM = str;
        this.mVideoPath = this.gwN ? this.gwM : t.X(str, this.gwU);
        if (this.gwR != null) {
            w.a("start_play", this.gwM, bpQ(), (int) this.gwR.bqc(), this.gwR.getDuration());
        }
        this.gwO = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpt() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains(NetworkDef.IP_LOOPBACK);
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpu() {
        return this.gwU;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bpv() {
        return this.gwV;
    }

    @Override // com.baidu.tieba.play.d
    public int bpw() {
        return com.baidu.tbadk.coreExtra.model.f.IV() ? this.gwW : this.gwX;
    }

    @Override // com.baidu.tieba.play.d
    public String bpr() {
        return this.gwM;
    }

    @Override // com.baidu.tieba.play.d
    public void bpx() {
        if (this.gwU && this.gwV && bpt() && bpQ()) {
            t.g(this.mContext, this.gwM, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cR(long j) {
        this.gwY = j;
        bpP();
        if (this.gwO > 0) {
            this.gwP = System.currentTimeMillis() - this.gwO;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gwM) && (parse = Uri.parse(n.this.gwM)) != null) {
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
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(2);
        bdAsyncTask.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.d
    public void onStart() {
        if (this.mStartTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dHc += currentTimeMillis;
            cS(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bKz != null) {
            this.bKz.start();
        }
        this.gwT = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gxa);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwZ);
        bpz();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dHc += currentTimeMillis;
            cS(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bpM();
        if (this.bKz != null) {
            this.bKz.stop();
        }
        if (this.gwP > 0 && this.gwR != null) {
            am amVar = new am("c11685");
            amVar.ax("service_ip", this.mHost);
            amVar.ax(WebVideoActivityConfig.KEY_VIDEO_URL, this.gwM);
            amVar.h("video_size", this.gwR.bqc());
            amVar.x(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gwR.getDuration());
            amVar.ax("video_resolution", this.gwR.bqd());
            amVar.x("loading_count", this.gwQ);
            amVar.h("user_watch_time", this.dHc / 1000);
            amVar.h("start_play_time", this.gwP);
            TiebaStatic.log(amVar);
        }
        if (this.gwR != null && this.gwP > 0) {
            w.a("stop_play", this.gwM, bpQ(), (int) this.gwR.bqc(), this.gwR.getDuration());
        }
        bpL();
        this.gwP = 0L;
        this.dHc = 0L;
        this.gwQ = 0;
        this.gwO = 0L;
        this.mStartTime = 0L;
        this.gwT = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gwS = bVar;
    }

    private void cS(long j) {
        if (this.gwS != null) {
            this.gwS.setVideoWatchDuration(this.gwS.getVideoWatchDuration() + j);
        }
    }

    private void bpL() {
        if (this.gwS != null && this.gwT) {
            TbSingleton.getInstance().putVideoRecord(this.gwS.getThreadId(), (int) (this.gwS.getVideoWatchDuration() / 1000));
        }
    }

    private void bpM() {
        if (this.dHc >= 0 && this.dHc < 86400000) {
            if (this.dHc > 0) {
                am amVar = new am("c11244");
                amVar.h("obj_duration", this.dHc);
                amVar.ax("obj_type", this.gwL);
                amVar.h("playduration", this.gwY);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.ax("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gwK != null) {
                    this.gwK.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dHc, this.gwL, this.gwK, "", this.gwY);
            } else if (this.gwT) {
                l.a(this.dHc, this.gwL, this.gwK, "", this.gwY);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dHc += currentTimeMillis;
            cS(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bpL();
        this.gwT = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dHc += currentTimeMillis;
            cS(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bpL();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bps() {
        return t.jj(this.gwM) != null;
    }

    public void bpN() {
        this.gwN = true;
    }

    public void ts(String str) {
        this.gwL = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bpy() {
        return this.bKz;
    }

    public void a(j.b bVar) {
        if (this.bKz != null) {
            this.bKz.a(bVar);
        }
    }

    public v bpO() {
        return this.gwR;
    }

    public void bpP() {
        if (!this.gwU) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gxa);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gxa, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void sT(int i) {
        if (bpQ()) {
            t.g(this.mContext, this.gwM, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gwZ);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gwZ, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bpz() {
        if (bpQ()) {
            t.aq(this.mContext, this.gwM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpQ() {
        return (this.gwN || this.mVideoPath == null || this.mVideoPath.equals(this.gwM)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.gwK = zVar;
    }

    public z bpR() {
        return this.gwK;
    }
}
