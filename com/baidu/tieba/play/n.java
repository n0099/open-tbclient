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
    private u fxD;
    private x fxv;
    private String fxx;
    private Context mContext;
    private String zX;
    private String fxw = "1";
    private boolean fxy = false;
    private long fxz = 0;
    private long fxA = 0;
    private long mStartTime = 0;
    private long fxB = 0;
    private int fxC = 0;
    private Runnable fxE = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bet()) {
                s.af(n.this.mContext, n.this.fxx);
            } else if (!n.this.fxy) {
                s.hv(n.this.fxx);
            }
        }
    };
    private j.c fwV = new j.c() { // from class: com.baidu.tieba.play.n.3
        @Override // com.baidu.tieba.play.j.c
        public void bej() {
            n.e(n.this);
        }
    };
    private j bKQ = new j();

    static /* synthetic */ int e(n nVar) {
        int i = nVar.fxC;
        nVar.fxC = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bKQ.a(this.fwV);
        this.fxD = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String ht(String str) {
        this.fxx = str;
        this.aZI = this.fxy ? this.fxx : s.ht(str);
        if (this.fxD != null) {
            v.a("start_play", this.fxx, bet(), (int) this.fxD.beB(), this.fxD.getDuration());
        }
        this.fxA = System.currentTimeMillis();
        return this.aZI;
    }

    @Override // com.baidu.tieba.play.d
    public String beh() {
        return this.fxx;
    }

    @Override // com.baidu.tieba.play.d
    public void onPrepared() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fxE);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fxE, 200L);
        if (this.fxA > 0) {
            this.fxB = System.currentTimeMillis() - this.fxA;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fxx) && (parse = Uri.parse(n.this.fxx)) != null) {
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
            this.fxz += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bKQ != null) {
            this.bKQ.start();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fxE);
        if (bet()) {
            s.ag(this.mContext, this.fxx);
        }
        if (this.mStartTime > 0) {
            this.fxz += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fxz >= 0 && this.fxz < 86400000) {
            if (this.fxz > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fxz);
                akVar.ad("obj_type", this.fxw);
                if (this.fxv != null) {
                    this.fxv.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fxz, this.fxw, this.fxv, "");
            } else {
                l.a(this.fxz, this.fxw, this.fxv, "");
            }
        }
        if (this.bKQ != null) {
            this.bKQ.stop();
        }
        if (this.fxB > 0 && this.fxD != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ad("service_ip", this.zX);
            akVar2.ad("video_url", this.fxx);
            akVar2.f("video_size", this.fxD.beB());
            akVar2.r("video_duration", this.fxD.getDuration());
            akVar2.ad("video_resolution", this.fxD.beC());
            akVar2.r("loading_count", this.fxC);
            akVar2.f("user_watch_time", this.fxz / 1000);
            akVar2.f("start_play_time", this.fxB);
            TiebaStatic.log(akVar2);
        }
        if (this.fxD != null && this.fxB > 0) {
            v.a("stop_play", this.fxx, bet(), (int) this.fxD.beB(), this.fxD.getDuration());
        }
        this.fxB = 0L;
        this.fxz = 0L;
        this.fxC = 0;
        this.fxA = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fxz += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fxz += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean beq() {
        return s.hu(this.fxx) != null;
    }

    public void ber() {
        this.fxy = true;
    }

    public void qm(String str) {
        this.fxw = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.bKQ;
    }

    public u bes() {
        return this.fxD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bet() {
        return (this.fxy || this.aZI == null || this.aZI.equals(this.fxx)) ? false : true;
    }

    public void setVideoStatsData(x xVar) {
        this.fxv = xVar;
    }
}
