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
    private boolean gGA;
    private long gGF;
    private z gGr;
    private String gGt;
    private v gGy;
    private com.baidu.tieba.video.b gGz;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String gGs = "1";
    private boolean gGu = false;
    private long dQp = 0;
    private long gGv = 0;
    private long mStartTime = 0;
    private long gGw = 0;
    private int gGx = 0;
    private boolean gGB = false;
    private boolean gGC = false;
    private int gGD = 8;
    private int gGE = 16;
    private Runnable gGG = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gGB && n.this.gGC && n.this.brX() && n.this.bsu()) {
                t.g(n.this.mContext, n.this.gGt, -1);
            }
        }
    };
    private Runnable gGH = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bsu()) {
                t.as(n.this.mContext, n.this.gGt);
            } else if (!n.this.gGu) {
                t.jD(n.this.gGt);
            }
        }
    };
    private j.c gFg = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aao() {
            n.g(n.this);
        }
    };
    private j bOr = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gGx;
        nVar.gGx = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bOr.a(this.gFg);
        this.gGy = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String jB(String str) {
        this.gGB = com.baidu.tbadk.coreExtra.model.f.JW();
        this.gGC = com.baidu.tbadk.coreExtra.model.f.JX();
        this.gGD = com.baidu.tbadk.coreExtra.model.f.JY();
        this.gGE = com.baidu.tbadk.coreExtra.model.f.JZ();
        this.gGt = str;
        this.mVideoPath = this.gGu ? this.gGt : t.Z(str, this.gGB);
        if (this.gGy != null) {
            w.a("start_play", this.gGt, bsu(), (int) this.gGy.bsG(), this.gGy.getDuration());
        }
        this.gGv = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean brX() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains(NetworkDef.IP_LOOPBACK);
    }

    @Override // com.baidu.tieba.play.d
    public boolean brY() {
        return this.gGB;
    }

    @Override // com.baidu.tieba.play.d
    public boolean brZ() {
        return this.gGC;
    }

    @Override // com.baidu.tieba.play.d
    public int bsa() {
        return com.baidu.tbadk.coreExtra.model.f.Ka() ? this.gGD : this.gGE;
    }

    @Override // com.baidu.tieba.play.d
    public String brV() {
        return this.gGt;
    }

    @Override // com.baidu.tieba.play.d
    public void bsb() {
        if (this.gGB && this.gGC && brX() && bsu()) {
            t.g(this.mContext, this.gGt, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dd(long j) {
        this.gGF = j;
        bst();
        if (this.gGv > 0) {
            this.gGw = System.currentTimeMillis() - this.gGv;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gGt) && (parse = Uri.parse(n.this.gGt)) != null) {
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
            this.dQp += currentTimeMillis;
            de(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bOr != null) {
            this.bOr.start();
        }
        this.gGA = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGH);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGG);
        bsd();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQp += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsq();
        if (this.bOr != null) {
            this.bOr.stop();
        }
        if (this.gGw > 0 && this.gGy != null) {
            am amVar = new am("c11685");
            amVar.aA("service_ip", this.mHost);
            amVar.aA(WebVideoActivityConfig.KEY_VIDEO_URL, this.gGt);
            amVar.i("video_size", this.gGy.bsG());
            amVar.x(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gGy.getDuration());
            amVar.aA("video_resolution", this.gGy.bsH());
            amVar.x("loading_count", this.gGx);
            amVar.i("user_watch_time", this.dQp / 1000);
            amVar.i("start_play_time", this.gGw);
            TiebaStatic.log(amVar);
        }
        if (this.gGy != null && this.gGw > 0) {
            w.a("stop_play", this.gGt, bsu(), (int) this.gGy.bsG(), this.gGy.getDuration());
        }
        bsp();
        this.gGw = 0L;
        this.dQp = 0L;
        this.gGx = 0;
        this.gGv = 0L;
        this.mStartTime = 0L;
        this.gGA = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gGz = bVar;
    }

    private void de(long j) {
        if (this.gGz != null) {
            this.gGz.setVideoWatchDuration(this.gGz.getVideoWatchDuration() + j);
        }
    }

    private void bsp() {
        if (this.gGz != null && this.gGA) {
            TbSingleton.getInstance().putVideoRecord(this.gGz.getThreadId(), (int) (this.gGz.getVideoWatchDuration() / 1000));
        }
    }

    private void bsq() {
        if (this.dQp >= 0 && this.dQp < 86400000) {
            if (this.dQp > 0) {
                am amVar = new am("c11244");
                amVar.i("obj_duration", this.dQp);
                amVar.aA("obj_type", this.gGs);
                amVar.i("playduration", this.gGF);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.aA("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gGr != null) {
                    this.gGr.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dQp, this.gGs, this.gGr, "", this.gGF);
            } else if (this.gGA) {
                l.a(this.dQp, this.gGs, this.gGr, "", this.gGF);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQp += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsp();
        this.gGA = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQp += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsp();
    }

    @Override // com.baidu.tieba.play.d
    public boolean brW() {
        return t.jC(this.gGt) != null;
    }

    public void bsr() {
        this.gGu = true;
    }

    public void tX(String str) {
        this.gGs = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bsc() {
        return this.bOr;
    }

    public void a(j.b bVar) {
        if (this.bOr != null) {
            this.bOr.a(bVar);
        }
    }

    public v bss() {
        return this.gGy;
    }

    public void bst() {
        if (!this.gGB) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGH);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gGH, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tA(int i) {
        if (bsu()) {
            t.g(this.mContext, this.gGt, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGG);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gGG, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bsd() {
        if (bsu()) {
            t.at(this.mContext, this.gGt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsu() {
        return (this.gGu || this.mVideoPath == null || this.mVideoPath.equals(this.gGt)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.gGr = zVar;
    }

    public z bsv() {
        return this.gGr;
    }
}
