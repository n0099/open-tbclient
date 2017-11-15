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
    private String aZU;
    private x fGC;
    private String fGE;
    private u fGK;
    private boolean fGL;
    private Context mContext;
    private String zY;
    private String fGD = "1";
    private boolean fGF = false;
    private long fGG = 0;
    private long fGH = 0;
    private long mStartTime = 0;
    private long fGI = 0;
    private int fGJ = 0;
    private Runnable fGM = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bhH()) {
                s.aa(n.this.mContext, n.this.fGE);
            } else if (!n.this.fGF) {
                s.hD(n.this.fGE);
            }
        }
    };
    private j.c fFO = new j.c() { // from class: com.baidu.tieba.play.n.3
        @Override // com.baidu.tieba.play.j.c
        public void bhv() {
            n.e(n.this);
        }
    };
    private j bSx = new j();

    static /* synthetic */ int e(n nVar) {
        int i = nVar.fGJ;
        nVar.fGJ = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bSx.a(this.fFO);
        this.fGK = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String hB(String str) {
        this.fGE = str;
        this.aZU = this.fGF ? this.fGE : s.hB(str);
        if (this.fGK != null) {
            v.a("start_play", this.fGE, bhH(), (int) this.fGK.bhQ(), this.fGK.getDuration());
        }
        this.fGH = System.currentTimeMillis();
        return this.aZU;
    }

    @Override // com.baidu.tieba.play.d
    public String bhs() {
        return this.fGE;
    }

    @Override // com.baidu.tieba.play.d
    public void onPrepared() {
        bhB();
        if (this.fGH > 0) {
            this.fGI = System.currentTimeMillis() - this.fGH;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fGE) && (parse = Uri.parse(n.this.fGE)) != null) {
                    try {
                        n.this.zY = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fGG += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bSx != null) {
            this.bSx.start();
        }
        this.fGL = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGM);
        if (bhH()) {
            s.ab(this.mContext, this.fGE);
        }
        if (this.mStartTime > 0) {
            this.fGG += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fGG >= 0 && this.fGG < 86400000) {
            if (this.fGG > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fGG);
                akVar.ac("obj_type", this.fGD);
                if (this.fGC != null) {
                    this.fGC.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fGG, this.fGD, this.fGC, "");
            } else if (this.fGL) {
                l.a(this.fGG, this.fGD, this.fGC, "");
            }
        }
        this.fGL = false;
        if (this.bSx != null) {
            this.bSx.stop();
        }
        if (this.fGI > 0 && this.fGK != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ac("service_ip", this.zY);
            akVar2.ac("video_url", this.fGE);
            akVar2.f("video_size", this.fGK.bhQ());
            akVar2.r("video_duration", this.fGK.getDuration());
            akVar2.ac("video_resolution", this.fGK.bhR());
            akVar2.r("loading_count", this.fGJ);
            akVar2.f("user_watch_time", this.fGG / 1000);
            akVar2.f("start_play_time", this.fGI);
            TiebaStatic.log(akVar2);
        }
        if (this.fGK != null && this.fGI > 0) {
            v.a("stop_play", this.fGE, bhH(), (int) this.fGK.bhQ(), this.fGK.getDuration());
        }
        this.fGI = 0L;
        this.fGG = 0L;
        this.fGJ = 0;
        this.fGH = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fGG += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fGG += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bhE() {
        return s.hC(this.fGE) != null;
    }

    public void bhF() {
        this.fGF = true;
    }

    public void qW(String str) {
        this.fGD = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.bSx;
    }

    public u bhG() {
        return this.fGK;
    }

    public void bhB() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGM);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fGM, 100L);
    }

    @Override // com.baidu.tieba.play.d
    public void bht() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGM);
        com.baidu.adp.lib.g.e.fP().post(this.fGM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhH() {
        return (this.fGF || this.aZU == null || this.aZU.equals(this.fGE)) ? false : true;
    }

    public void setVideoStatsData(x xVar) {
        this.fGC = xVar;
    }

    public x bhI() {
        return this.fGC;
    }
}
