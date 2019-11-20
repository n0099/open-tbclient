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
    private String aFg;
    private z ixb;
    private String ixd;
    private v ixi;
    private com.baidu.tieba.video.b ixj;
    private boolean ixk;
    private long ixp;
    private Context mContext;
    private String su;
    private String ixc = "1";
    private boolean ixe = false;
    private long fAT = 0;
    private long ixf = 0;
    private long mStartTime = 0;
    private long ixg = 0;
    private int ixh = 0;
    private boolean ixl = false;
    private boolean ixm = false;
    private int ixn = 8;
    private int ixo = 16;
    private Runnable ixq = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ixl && n.this.ixm && n.this.cca() && n.this.ccy()) {
                t.d(n.this.mContext, n.this.ixd, -1);
            }
        }
    };
    private Runnable ixr = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ccy()) {
                t.an(n.this.mContext, n.this.ixd);
            } else if (!n.this.ixe) {
                t.qZ(n.this.ixd);
            }
        }
    };
    private j.c ivU = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aJg() {
            n.g(n.this);
        }
    };
    private j dvH = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.ixh;
        nVar.ixh = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dvH.a(this.ivU);
        this.ixi = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String qX(String str) {
        this.ixl = com.baidu.tbadk.coreExtra.model.f.arS();
        this.ixm = com.baidu.tbadk.coreExtra.model.f.arT();
        this.ixn = com.baidu.tbadk.coreExtra.model.f.arU();
        this.ixo = com.baidu.tbadk.coreExtra.model.f.arV();
        this.ixd = str;
        this.aFg = this.ixe ? this.ixd : t.ar(str, this.ixl);
        if (this.ixi != null) {
            w.a("start_play", this.ixd, ccy(), (int) this.ixi.ccJ(), this.ixi.getDuration());
        }
        this.ixf = System.currentTimeMillis();
        return this.aFg;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cca() {
        return !StringUtils.isNull(this.aFg) && this.aFg.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean ccb() {
        return this.ixl;
    }

    @Override // com.baidu.tieba.play.d
    public boolean ccc() {
        return this.ixm;
    }

    @Override // com.baidu.tieba.play.d
    public int ccd() {
        return com.baidu.tbadk.coreExtra.model.f.arW() ? this.ixn : this.ixo;
    }

    @Override // com.baidu.tieba.play.d
    public String cbY() {
        return this.ixd;
    }

    @Override // com.baidu.tieba.play.d
    public void cce() {
        if (this.ixl && this.ixm && cca() && ccy()) {
            t.d(this.mContext, this.ixd, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dN(long j) {
        this.ixp = j;
        ccx();
        if (this.ixf > 0) {
            this.ixg = System.currentTimeMillis() - this.ixf;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.ixd) && (parse = Uri.parse(n.this.ixd)) != null) {
                    try {
                        n.this.su = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fAT += currentTimeMillis;
            dO(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dvH != null) {
            this.dvH.start();
        }
        this.ixk = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixr);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixq);
        ccg();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fAT += currentTimeMillis;
            dO(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ccu();
        if (this.dvH != null) {
            this.dvH.stop();
        }
        if (this.ixg > 0 && this.ixi != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.bS("service_ip", this.su);
            anVar.bS("video_url", this.ixd);
            anVar.p("video_size", this.ixi.ccJ());
            anVar.O("video_duration", this.ixi.getDuration());
            anVar.bS("video_resolution", this.ixi.ccK());
            anVar.O("loading_count", this.ixh);
            anVar.p("user_watch_time", this.fAT / 1000);
            anVar.p("start_play_time", this.ixg);
            TiebaStatic.log(anVar);
        }
        if (this.ixi != null && this.ixg > 0) {
            w.a("stop_play", this.ixd, ccy(), (int) this.ixi.ccJ(), this.ixi.getDuration());
        }
        cct();
        this.ixg = 0L;
        this.fAT = 0L;
        this.ixh = 0;
        this.ixf = 0L;
        this.mStartTime = 0L;
        this.ixk = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.ixj = bVar;
    }

    private void dO(long j) {
        if (this.ixj != null) {
            this.ixj.setVideoWatchDuration(this.ixj.getVideoWatchDuration() + j);
        }
    }

    private void cct() {
        if (this.ixj != null && this.ixk) {
            TbSingleton.getInstance().putVideoRecord(this.ixj.getThreadId(), (int) (this.ixj.getVideoWatchDuration() / 1000));
        }
    }

    private void ccu() {
        if (this.fAT >= 0 && this.fAT < 86400000) {
            if (this.fAT > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.p("obj_duration", this.fAT);
                anVar.bS("obj_type", this.ixc);
                anVar.p("playduration", this.ixp);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bS("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ixb != null) {
                    this.ixb.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fAT, this.ixc, this.ixb, "", this.ixp);
            } else if (this.ixk) {
                l.a(this.fAT, this.ixc, this.ixb, "", this.ixp);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fAT += currentTimeMillis;
            dO(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cct();
        this.ixk = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fAT += currentTimeMillis;
            dO(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cct();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbZ() {
        return t.qY(this.ixd) != null;
    }

    public void ccv() {
        this.ixe = true;
    }

    public void BQ(String str) {
        this.ixc = str;
    }

    @Override // com.baidu.tieba.play.d
    public j ccf() {
        return this.dvH;
    }

    public void a(j.b bVar) {
        if (this.dvH != null) {
            this.dvH.a(bVar);
        }
    }

    public v ccw() {
        return this.ixi;
    }

    public void ccx() {
        if (!this.ixl) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixr);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.ixr, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void xE(int i) {
        if (ccy()) {
            t.d(this.mContext, this.ixd, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixq);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.ixq, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void ccg() {
        if (ccy()) {
            t.ao(this.mContext, this.ixd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccy() {
        return (this.ixe || this.aFg == null || this.aFg.equals(this.ixd)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.ixb = zVar;
    }

    public z ccz() {
        return this.ixb;
    }
}
