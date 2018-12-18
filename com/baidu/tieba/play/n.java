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
    private z gDA;
    private String gDC;
    private v gDH;
    private com.baidu.tieba.video.b gDI;
    private boolean gDJ;
    private long gDO;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String gDB = "1";
    private boolean gDD = false;
    private long dNB = 0;
    private long gDE = 0;
    private long mStartTime = 0;
    private long gDF = 0;
    private int gDG = 0;
    private boolean gDK = false;
    private boolean gDL = false;
    private int gDM = 8;
    private int gDN = 16;
    private Runnable gDP = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gDK && n.this.gDL && n.this.brl() && n.this.brI()) {
                t.g(n.this.mContext, n.this.gDC, -1);
            }
        }
    };
    private Runnable gDQ = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.brI()) {
                t.as(n.this.mContext, n.this.gDC);
            } else if (!n.this.gDD) {
                t.jC(n.this.gDC);
            }
        }
    };
    private j.c gCp = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aam() {
            n.g(n.this);
        }
    };
    private j bOo = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gDG;
        nVar.gDG = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bOo.a(this.gCp);
        this.gDH = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String jA(String str) {
        this.gDK = com.baidu.tbadk.coreExtra.model.f.JV();
        this.gDL = com.baidu.tbadk.coreExtra.model.f.JW();
        this.gDM = com.baidu.tbadk.coreExtra.model.f.JX();
        this.gDN = com.baidu.tbadk.coreExtra.model.f.JY();
        this.gDC = str;
        this.mVideoPath = this.gDD ? this.gDC : t.Z(str, this.gDK);
        if (this.gDH != null) {
            w.a("start_play", this.gDC, brI(), (int) this.gDH.brU(), this.gDH.getDuration());
        }
        this.gDE = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean brl() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains(NetworkDef.IP_LOOPBACK);
    }

    @Override // com.baidu.tieba.play.d
    public boolean brm() {
        return this.gDK;
    }

    @Override // com.baidu.tieba.play.d
    public boolean brn() {
        return this.gDL;
    }

    @Override // com.baidu.tieba.play.d
    public int bro() {
        return com.baidu.tbadk.coreExtra.model.f.JZ() ? this.gDM : this.gDN;
    }

    @Override // com.baidu.tieba.play.d
    public String brj() {
        return this.gDC;
    }

    @Override // com.baidu.tieba.play.d
    public void brp() {
        if (this.gDK && this.gDL && brl() && brI()) {
            t.g(this.mContext, this.gDC, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cY(long j) {
        this.gDO = j;
        brH();
        if (this.gDE > 0) {
            this.gDF = System.currentTimeMillis() - this.gDE;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gDC) && (parse = Uri.parse(n.this.gDC)) != null) {
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
            this.dNB += currentTimeMillis;
            cZ(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bOo != null) {
            this.bOo.start();
        }
        this.gDJ = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDQ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDP);
        brr();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dNB += currentTimeMillis;
            cZ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        brE();
        if (this.bOo != null) {
            this.bOo.stop();
        }
        if (this.gDF > 0 && this.gDH != null) {
            am amVar = new am("c11685");
            amVar.aA("service_ip", this.mHost);
            amVar.aA(WebVideoActivityConfig.KEY_VIDEO_URL, this.gDC);
            amVar.i("video_size", this.gDH.brU());
            amVar.x(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gDH.getDuration());
            amVar.aA("video_resolution", this.gDH.brV());
            amVar.x("loading_count", this.gDG);
            amVar.i("user_watch_time", this.dNB / 1000);
            amVar.i("start_play_time", this.gDF);
            TiebaStatic.log(amVar);
        }
        if (this.gDH != null && this.gDF > 0) {
            w.a("stop_play", this.gDC, brI(), (int) this.gDH.brU(), this.gDH.getDuration());
        }
        brD();
        this.gDF = 0L;
        this.dNB = 0L;
        this.gDG = 0;
        this.gDE = 0L;
        this.mStartTime = 0L;
        this.gDJ = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gDI = bVar;
    }

    private void cZ(long j) {
        if (this.gDI != null) {
            this.gDI.setVideoWatchDuration(this.gDI.getVideoWatchDuration() + j);
        }
    }

    private void brD() {
        if (this.gDI != null && this.gDJ) {
            TbSingleton.getInstance().putVideoRecord(this.gDI.getThreadId(), (int) (this.gDI.getVideoWatchDuration() / 1000));
        }
    }

    private void brE() {
        if (this.dNB >= 0 && this.dNB < 86400000) {
            if (this.dNB > 0) {
                am amVar = new am("c11244");
                amVar.i("obj_duration", this.dNB);
                amVar.aA("obj_type", this.gDB);
                amVar.i("playduration", this.gDO);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.aA("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gDA != null) {
                    this.gDA.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dNB, this.gDB, this.gDA, "", this.gDO);
            } else if (this.gDJ) {
                l.a(this.dNB, this.gDB, this.gDA, "", this.gDO);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dNB += currentTimeMillis;
            cZ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        brD();
        this.gDJ = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dNB += currentTimeMillis;
            cZ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        brD();
    }

    @Override // com.baidu.tieba.play.d
    public boolean brk() {
        return t.jB(this.gDC) != null;
    }

    public void brF() {
        this.gDD = true;
    }

    public void tU(String str) {
        this.gDB = str;
    }

    @Override // com.baidu.tieba.play.d
    public j brq() {
        return this.bOo;
    }

    public void a(j.b bVar) {
        if (this.bOo != null) {
            this.bOo.a(bVar);
        }
    }

    public v brG() {
        return this.gDH;
    }

    public void brH() {
        if (!this.gDK) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDQ);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gDQ, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tn(int i) {
        if (brI()) {
            t.g(this.mContext, this.gDC, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gDP);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gDP, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void brr() {
        if (brI()) {
            t.at(this.mContext, this.gDC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brI() {
        return (this.gDD || this.mVideoPath == null || this.mVideoPath.equals(this.gDC)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.gDA = zVar;
    }

    public z brJ() {
        return this.gDA;
    }
}
