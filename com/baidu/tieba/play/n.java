package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String EO;
    private String bmV;
    private y gfM;
    private String gfO;
    private u gfU;
    private boolean gfV;
    private long gga;
    private Context mContext;
    private String gfN = "1";
    private boolean gfP = false;
    private long gfQ = 0;
    private long gfR = 0;
    private long mStartTime = 0;
    private long gfS = 0;
    private int gfT = 0;
    private boolean gfW = false;
    private boolean gfX = false;
    private int gfY = 8;
    private int gfZ = 16;
    private Runnable ggb = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gfW && n.this.gfX && n.this.blO() && n.this.bmj()) {
                s.e(n.this.mContext, n.this.gfO, -1);
            }
        }
    };
    private Runnable ggc = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bmj()) {
                s.aa(n.this.mContext, n.this.gfO);
            } else if (!n.this.gfP) {
                s.iw(n.this.gfO);
            }
        }
    };
    private j.c geN = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Tq() {
            n.g(n.this);
        }
    };
    private j buK = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gfT;
        nVar.gfT = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.buK.a(this.geN);
        this.gfU = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String iu(String str) {
        this.gfW = com.baidu.tbadk.coreExtra.model.f.Fs();
        this.gfX = com.baidu.tbadk.coreExtra.model.f.Ft();
        this.gfY = com.baidu.tbadk.coreExtra.model.f.Fu();
        this.gfZ = com.baidu.tbadk.coreExtra.model.f.Fv();
        this.gfO = str;
        this.bmV = this.gfP ? this.gfO : s.Q(str, this.gfW);
        if (this.gfU != null) {
            v.a("start_play", this.gfO, bmj(), (int) this.gfU.bmv(), this.gfU.getDuration());
        }
        this.gfR = System.currentTimeMillis();
        return this.bmV;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blO() {
        return !StringUtils.isNull(this.bmV) && this.bmV.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean blP() {
        return this.gfW;
    }

    @Override // com.baidu.tieba.play.d
    public boolean blQ() {
        return this.gfX;
    }

    @Override // com.baidu.tieba.play.d
    public int blR() {
        return com.baidu.tbadk.coreExtra.model.f.Fw() ? this.gfY : this.gfZ;
    }

    @Override // com.baidu.tieba.play.d
    public String blM() {
        return this.gfO;
    }

    @Override // com.baidu.tieba.play.d
    public void blS() {
        if (this.gfW && this.gfX && blO() && bmj()) {
            s.e(this.mContext, this.gfO, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cP(long j) {
        this.gga = j;
        bmi();
        if (this.gfR > 0) {
            this.gfS = System.currentTimeMillis() - this.gfR;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.gfO) && (parse = Uri.parse(n.this.gfO)) != null) {
                    try {
                        n.this.EO = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.gfQ += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.buK != null) {
            this.buK.start();
        }
        this.gfV = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ggc);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ggb);
        blU();
        if (this.mStartTime > 0) {
            this.gfQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        bmf();
        this.gfV = false;
        if (this.buK != null) {
            this.buK.stop();
        }
        if (this.gfS > 0 && this.gfU != null) {
            an anVar = new an("c11685");
            anVar.ah("service_ip", this.EO);
            anVar.ah(WebVideoActivityConfig.KEY_VIDEO_URL, this.gfO);
            anVar.f("video_size", this.gfU.bmv());
            anVar.r(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gfU.getDuration());
            anVar.ah("video_resolution", this.gfU.bmw());
            anVar.r("loading_count", this.gfT);
            anVar.f("user_watch_time", this.gfQ / 1000);
            anVar.f("start_play_time", this.gfS);
            TiebaStatic.log(anVar);
        }
        if (this.gfU != null && this.gfS > 0) {
            v.a("stop_play", this.gfO, bmj(), (int) this.gfU.bmv(), this.gfU.getDuration());
        }
        this.gfS = 0L;
        this.gfQ = 0L;
        this.gfT = 0;
        this.gfR = 0L;
        this.mStartTime = 0L;
    }

    private void bmf() {
        if (this.gfQ >= 0 && this.gfQ < 86400000) {
            if (this.gfQ > 0) {
                an anVar = new an("c11244");
                anVar.f("obj_duration", this.gfQ);
                anVar.ah("obj_type", this.gfN);
                anVar.f("playduration", this.gga);
                if (this.gfM != null) {
                    this.gfM.b(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.gfQ, this.gfN, this.gfM, "", this.gga);
            } else if (this.gfV) {
                l.a(this.gfQ, this.gfN, this.gfM, "", this.gga);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.gfQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.gfQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean blN() {
        return s.iv(this.gfO) != null;
    }

    public void bmg() {
        this.gfP = true;
    }

    public void si(String str) {
        this.gfN = str;
    }

    @Override // com.baidu.tieba.play.d
    public j blT() {
        return this.buK;
    }

    public u bmh() {
        return this.gfU;
    }

    public void bmi() {
        if (!this.gfW) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.ggc);
            com.baidu.adp.lib.g.e.im().postDelayed(this.ggc, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void rJ(int i) {
        if (bmj()) {
            s.e(this.mContext, this.gfO, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ggb);
        com.baidu.adp.lib.g.e.im().postDelayed(this.ggb, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void blU() {
        if (bmj()) {
            s.ab(this.mContext, this.gfO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmj() {
        return (this.gfP || this.bmV == null || this.bmV.equals(this.gfO)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.gfM = yVar;
    }

    public y bmk() {
        return this.gfM;
    }
}
