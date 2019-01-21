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
    private v gHD;
    private com.baidu.tieba.video.b gHE;
    private boolean gHF;
    private long gHK;
    private z gHw;
    private String gHy;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String gHx = "1";
    private boolean gHz = false;
    private long dQZ = 0;
    private long gHA = 0;
    private long mStartTime = 0;
    private long gHB = 0;
    private int gHC = 0;
    private boolean gHG = false;
    private boolean gHH = false;
    private int gHI = 8;
    private int gHJ = 16;
    private Runnable gHL = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gHG && n.this.gHH && n.this.bsG() && n.this.btd()) {
                t.g(n.this.mContext, n.this.gHy, -1);
            }
        }
    };
    private Runnable gHM = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.btd()) {
                t.aq(n.this.mContext, n.this.gHy);
            } else if (!n.this.gHz) {
                t.jT(n.this.gHy);
            }
        }
    };
    private j.c gGl = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aaL() {
            n.g(n.this);
        }
    };
    private j bPd = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gHC;
        nVar.gHC = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bPd.a(this.gGl);
        this.gHD = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String jR(String str) {
        this.gHG = com.baidu.tbadk.coreExtra.model.f.Kl();
        this.gHH = com.baidu.tbadk.coreExtra.model.f.Km();
        this.gHI = com.baidu.tbadk.coreExtra.model.f.Kn();
        this.gHJ = com.baidu.tbadk.coreExtra.model.f.Ko();
        this.gHy = str;
        this.mVideoPath = this.gHz ? this.gHy : t.Y(str, this.gHG);
        if (this.gHD != null) {
            w.a("start_play", this.gHy, btd(), (int) this.gHD.btp(), this.gHD.getDuration());
        }
        this.gHA = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsG() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains(NetworkDef.IP_LOOPBACK);
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsH() {
        return this.gHG;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsI() {
        return this.gHH;
    }

    @Override // com.baidu.tieba.play.d
    public int bsJ() {
        return com.baidu.tbadk.coreExtra.model.f.Kp() ? this.gHI : this.gHJ;
    }

    @Override // com.baidu.tieba.play.d
    public String bsE() {
        return this.gHy;
    }

    @Override // com.baidu.tieba.play.d
    public void bsK() {
        if (this.gHG && this.gHH && bsG() && btd()) {
            t.g(this.mContext, this.gHy, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dd(long j) {
        this.gHK = j;
        btc();
        if (this.gHA > 0) {
            this.gHB = System.currentTimeMillis() - this.gHA;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gHy) && (parse = Uri.parse(n.this.gHy)) != null) {
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
            this.dQZ += currentTimeMillis;
            de(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bPd != null) {
            this.bPd.start();
        }
        this.gHF = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHM);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHL);
        bsM();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQZ += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsZ();
        if (this.bPd != null) {
            this.bPd.stop();
        }
        if (this.gHB > 0 && this.gHD != null) {
            am amVar = new am("c11685");
            amVar.aB("service_ip", this.mHost);
            amVar.aB(WebVideoActivityConfig.KEY_VIDEO_URL, this.gHy);
            amVar.i("video_size", this.gHD.btp());
            amVar.y(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gHD.getDuration());
            amVar.aB("video_resolution", this.gHD.btq());
            amVar.y("loading_count", this.gHC);
            amVar.i("user_watch_time", this.dQZ / 1000);
            amVar.i("start_play_time", this.gHB);
            TiebaStatic.log(amVar);
        }
        if (this.gHD != null && this.gHB > 0) {
            w.a("stop_play", this.gHy, btd(), (int) this.gHD.btp(), this.gHD.getDuration());
        }
        bsY();
        this.gHB = 0L;
        this.dQZ = 0L;
        this.gHC = 0;
        this.gHA = 0L;
        this.mStartTime = 0L;
        this.gHF = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gHE = bVar;
    }

    private void de(long j) {
        if (this.gHE != null) {
            this.gHE.setVideoWatchDuration(this.gHE.getVideoWatchDuration() + j);
        }
    }

    private void bsY() {
        if (this.gHE != null && this.gHF) {
            TbSingleton.getInstance().putVideoRecord(this.gHE.getThreadId(), (int) (this.gHE.getVideoWatchDuration() / 1000));
        }
    }

    private void bsZ() {
        if (this.dQZ >= 0 && this.dQZ < 86400000) {
            if (this.dQZ > 0) {
                am amVar = new am("c11244");
                amVar.i("obj_duration", this.dQZ);
                amVar.aB("obj_type", this.gHx);
                amVar.i("playduration", this.gHK);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.aB("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gHw != null) {
                    this.gHw.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dQZ, this.gHx, this.gHw, "", this.gHK);
            } else if (this.gHF) {
                l.a(this.dQZ, this.gHx, this.gHw, "", this.gHK);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQZ += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsY();
        this.gHF = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dQZ += currentTimeMillis;
            de(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bsY();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bsF() {
        return t.jS(this.gHy) != null;
    }

    public void bta() {
        this.gHz = true;
    }

    public void un(String str) {
        this.gHx = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bsL() {
        return this.bPd;
    }

    public void a(j.b bVar) {
        if (this.bPd != null) {
            this.bPd.a(bVar);
        }
    }

    public v btb() {
        return this.gHD;
    }

    public void btc() {
        if (!this.gHG) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHM);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gHM, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void tE(int i) {
        if (btd()) {
            t.g(this.mContext, this.gHy, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHL);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gHL, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bsM() {
        if (btd()) {
            t.ar(this.mContext, this.gHy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btd() {
        return (this.gHz || this.mVideoPath == null || this.mVideoPath.equals(this.gHy)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.gHw = zVar;
    }

    public z bte() {
        return this.gHw;
    }
}
