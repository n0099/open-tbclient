package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.play.j;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String aZI;
    private u fxE;
    private x fxw;
    private String fxy;
    private Context mContext;
    private String zX;
    private String fxx = "1";
    private boolean fxz = false;
    private long fxA = 0;
    private long fxB = 0;
    private long mStartTime = 0;
    private long fxC = 0;
    private int fxD = 0;
    private Runnable fxF = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.beu()) {
                s.af(n.this.mContext, n.this.fxy);
            } else if (!n.this.fxz) {
                s.hv(n.this.fxy);
            }
        }
    };
    private j.c fwW = new j.c() { // from class: com.baidu.tieba.play.n.3
        @Override // com.baidu.tieba.play.j.c
        public void bek() {
            n.e(n.this);
        }
    };
    private j bKQ = new j();

    static /* synthetic */ int e(n nVar) {
        int i = nVar.fxD;
        nVar.fxD = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bKQ.a(this.fwW);
        this.fxE = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String ht(String str) {
        this.fxy = str;
        this.aZI = this.fxz ? this.fxy : s.ht(str);
        if (this.fxE != null) {
            v.a("start_play", this.fxy, beu(), (int) this.fxE.beC(), this.fxE.getDuration());
        }
        this.fxB = System.currentTimeMillis();
        return this.aZI;
    }

    @Override // com.baidu.tieba.play.d
    public String bei() {
        return this.fxy;
    }

    @Override // com.baidu.tieba.play.d
    public void onPrepared() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fxF);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fxF, 200L);
        if (this.fxB > 0) {
            this.fxC = System.currentTimeMillis() - this.fxB;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fxy) && (parse = Uri.parse(n.this.fxy)) != null) {
                    try {
                        n.this.zX = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fxA += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bKQ != null) {
            this.bKQ.start();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fxF);
        if (beu()) {
            s.ag(this.mContext, this.fxy);
        }
        if (this.mStartTime > 0) {
            this.fxA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fxA >= 0 && this.fxA < 86400000) {
            if (this.fxA > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fxA);
                akVar.ad("obj_type", this.fxx);
                if (this.fxw != null) {
                    this.fxw.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fxA, this.fxx, this.fxw, "");
            } else {
                l.a(this.fxA, this.fxx, this.fxw, "");
            }
        }
        if (this.bKQ != null) {
            this.bKQ.stop();
        }
        if (this.fxC > 0 && this.fxE != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ad("service_ip", this.zX);
            akVar2.ad("video_url", this.fxy);
            akVar2.f("video_size", this.fxE.beC());
            akVar2.r("video_duration", this.fxE.getDuration());
            akVar2.ad("video_resolution", this.fxE.beD());
            akVar2.r("loading_count", this.fxD);
            akVar2.f("user_watch_time", this.fxA / 1000);
            akVar2.f("start_play_time", this.fxC);
            TiebaStatic.log(akVar2);
        }
        if (this.fxE != null && this.fxC > 0) {
            v.a("stop_play", this.fxy, beu(), (int) this.fxE.beC(), this.fxE.getDuration());
        }
        this.fxC = 0L;
        this.fxA = 0L;
        this.fxD = 0;
        this.fxB = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fxA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fxA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean ber() {
        return s.hu(this.fxy) != null;
    }

    public void bes() {
        this.fxz = true;
    }

    public void qm(String str) {
        this.fxx = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.bKQ;
    }

    public u bet() {
        return this.fxE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beu() {
        return (this.fxz || this.aZI == null || this.aZI.equals(this.fxy)) ? false : true;
    }

    public void setVideoStatsData(x xVar) {
        this.fxw = xVar;
    }
}
