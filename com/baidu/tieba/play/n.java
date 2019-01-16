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
    private v gHC;
    private com.baidu.tieba.video.b gHD;
    private boolean gHE;
    private long gHJ;
    private z gHv;
    private String gHx;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String gHw = "1";
    private boolean gHy = false;
    private long dQY = 0;
    private long gHz = 0;
    private long mStartTime = 0;
    private long gHA = 0;
    private int gHB = 0;
    private boolean gHF = false;
    private boolean gHG = false;
    private int gHH = 8;
    private int gHI = 16;
    private Runnable gHK = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gHF && n.this.gHG && n.this.bsG() && n.this.btd()) {
                t.g(n.this.mContext, n.this.gHx, -1);
            }
        }
    };
    private Runnable gHL = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.btd()) {
                t.aq(n.this.mContext, n.this.gHx);
            } else if (!n.this.gHy) {
                t.jT(n.this.gHx);
            }
        }
    };
    private j.c gGk = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aaL() {
            n.g(n.this);
        }
    };
    private j bPc = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gHB;
        nVar.gHB = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bPc.a(this.gGk);
        this.gHC = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String jR(String str) {
        this.gHF = com.baidu.tbadk.coreExtra.model.f.Kl();
        this.gHG = com.baidu.tbadk.coreExtra.model.f.Km();
        this.gHH = com.baidu.tbadk.coreExtra.model.f.Kn();
        this.gHI = com.baidu.tbadk.coreExtra.model.f.Ko();
        this.gHx = str;
        this.mVideoPath = this.gHy ? this.gHx : t.Y(str, this.gHF);
        if (this.gHC != null) {
            w.a("start_play", this.gHx, btd(), (int) this.gHC.btp(), this.gHC.getDuration());
        }
        this.gHz = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsG() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains(NetworkDef.IP_LOOPBACK);
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsH() {
        return this.gHF;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsI() {
        return this.gHG;
    }

    @Override // com.baidu.tieba.play.d
    public int bsJ() {
        return com.baidu.tbadk.coreExtra.model.f.Kp() ? this.gHH : this.gHI;
    }

    @Override // com.baidu.tieba.play.d
    public String bsE() {
        return this.gHx;
    }

    @Override // com.baidu.tieba.play.d
    public void bsK() {
        if (this.gHF && this.gHG && bsG() && btd()) {
            t.g(this.mContext, this.gHx, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dd(long j) {
        this.gHJ = j;
        btc();
        if (this.gHz > 0) {
            this.gHA = System.currentTimeMillis() - this.gHz;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gHx) && (parse = Uri.parse(n.this.gHx)) != null) {
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
            this.dQY += currentTimeMillis;
            de(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bPc != null) {
            this.bPc.start();
        }
        this.gHE = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHL);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHK);
        bsM();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQY += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsZ();
        if (this.bPc != null) {
            this.bPc.stop();
        }
        if (this.gHA > 0 && this.gHC != null) {
            am amVar = new am("c11685");
            amVar.aB("service_ip", this.mHost);
            amVar.aB(WebVideoActivityConfig.KEY_VIDEO_URL, this.gHx);
            amVar.i("video_size", this.gHC.btp());
            amVar.y(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gHC.getDuration());
            amVar.aB("video_resolution", this.gHC.btq());
            amVar.y("loading_count", this.gHB);
            amVar.i("user_watch_time", this.dQY / 1000);
            amVar.i("start_play_time", this.gHA);
            TiebaStatic.log(amVar);
        }
        if (this.gHC != null && this.gHA > 0) {
            w.a("stop_play", this.gHx, btd(), (int) this.gHC.btp(), this.gHC.getDuration());
        }
        bsY();
        this.gHA = 0L;
        this.dQY = 0L;
        this.gHB = 0;
        this.gHz = 0L;
        this.mStartTime = 0L;
        this.gHE = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gHD = bVar;
    }

    private void de(long j) {
        if (this.gHD != null) {
            this.gHD.setVideoWatchDuration(this.gHD.getVideoWatchDuration() + j);
        }
    }

    private void bsY() {
        if (this.gHD != null && this.gHE) {
            TbSingleton.getInstance().putVideoRecord(this.gHD.getThreadId(), (int) (this.gHD.getVideoWatchDuration() / 1000));
        }
    }

    private void bsZ() {
        if (this.dQY >= 0 && this.dQY < 86400000) {
            if (this.dQY > 0) {
                am amVar = new am("c11244");
                amVar.i("obj_duration", this.dQY);
                amVar.aB("obj_type", this.gHw);
                amVar.i("playduration", this.gHJ);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.aB("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gHv != null) {
                    this.gHv.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dQY, this.gHw, this.gHv, "", this.gHJ);
            } else if (this.gHE) {
                l.a(this.dQY, this.gHw, this.gHv, "", this.gHJ);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQY += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsY();
        this.gHE = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQY += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsY();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsF() {
        return t.jS(this.gHx) != null;
    }

    public void bta() {
        this.gHy = true;
    }

    public void un(String str) {
        this.gHw = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bsL() {
        return this.bPc;
    }

    public void a(j.b bVar) {
        if (this.bPc != null) {
            this.bPc.a(bVar);
        }
    }

    public v btb() {
        return this.gHC;
    }

    public void btc() {
        if (!this.gHF) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHL);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gHL, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tE(int i) {
        if (btd()) {
            t.g(this.mContext, this.gHx, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHK);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gHK, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bsM() {
        if (btd()) {
            t.ar(this.mContext, this.gHx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btd() {
        return (this.gHy || this.mVideoPath == null || this.mVideoPath.equals(this.gHx)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.gHv = zVar;
    }

    public z bte() {
        return this.gHv;
    }
}
