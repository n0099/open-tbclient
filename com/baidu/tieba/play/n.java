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
    private String aZL;
    private x fFX;
    private String fFZ;
    private u fGf;
    private boolean fGg;
    private Context mContext;
    private String zY;
    private String fFY = "1";
    private boolean fGa = false;
    private long fGb = 0;
    private long fGc = 0;
    private long mStartTime = 0;
    private long fGd = 0;
    private int fGe = 0;
    private Runnable fGh = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bhz()) {
                s.aa(n.this.mContext, n.this.fFZ);
            } else if (!n.this.fGa) {
                s.hC(n.this.fFZ);
            }
        }
    };
    private j.c fFr = new j.c() { // from class: com.baidu.tieba.play.n.3
        @Override // com.baidu.tieba.play.j.c
        public void bhn() {
            n.e(n.this);
        }
    };
    private j bSk = new j();

    static /* synthetic */ int e(n nVar) {
        int i = nVar.fGe;
        nVar.fGe = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bSk.a(this.fFr);
        this.fGf = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String hA(String str) {
        this.fFZ = str;
        this.aZL = this.fGa ? this.fFZ : s.hA(str);
        if (this.fGf != null) {
            v.a("start_play", this.fFZ, bhz(), (int) this.fGf.bhI(), this.fGf.getDuration());
        }
        this.fGc = System.currentTimeMillis();
        return this.aZL;
    }

    @Override // com.baidu.tieba.play.d
    public String bhk() {
        return this.fFZ;
    }

    @Override // com.baidu.tieba.play.d
    public void onPrepared() {
        bht();
        if (this.fGc > 0) {
            this.fGd = System.currentTimeMillis() - this.fGc;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fFZ) && (parse = Uri.parse(n.this.fFZ)) != null) {
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
            this.fGb += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bSk != null) {
            this.bSk.start();
        }
        this.fGg = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGh);
        if (bhz()) {
            s.ab(this.mContext, this.fFZ);
        }
        if (this.mStartTime > 0) {
            this.fGb += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fGb >= 0 && this.fGb < 86400000) {
            if (this.fGb > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fGb);
                akVar.ac("obj_type", this.fFY);
                if (this.fFX != null) {
                    this.fFX.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fGb, this.fFY, this.fFX, "");
            } else if (this.fGg) {
                l.a(this.fGb, this.fFY, this.fFX, "");
            }
        }
        this.fGg = false;
        if (this.bSk != null) {
            this.bSk.stop();
        }
        if (this.fGd > 0 && this.fGf != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ac("service_ip", this.zY);
            akVar2.ac("video_url", this.fFZ);
            akVar2.f("video_size", this.fGf.bhI());
            akVar2.r("video_duration", this.fGf.getDuration());
            akVar2.ac("video_resolution", this.fGf.bhJ());
            akVar2.r("loading_count", this.fGe);
            akVar2.f("user_watch_time", this.fGb / 1000);
            akVar2.f("start_play_time", this.fGd);
            TiebaStatic.log(akVar2);
        }
        if (this.fGf != null && this.fGd > 0) {
            v.a("stop_play", this.fFZ, bhz(), (int) this.fGf.bhI(), this.fGf.getDuration());
        }
        this.fGd = 0L;
        this.fGb = 0L;
        this.fGe = 0;
        this.fGc = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fGb += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fGb += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bhw() {
        return s.hB(this.fFZ) != null;
    }

    public void bhx() {
        this.fGa = true;
    }

    public void qS(String str) {
        this.fFY = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.bSk;
    }

    public u bhy() {
        return this.fGf;
    }

    public void bht() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGh);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fGh, 100L);
    }

    @Override // com.baidu.tieba.play.d
    public void bhl() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGh);
        com.baidu.adp.lib.g.e.fP().post(this.fGh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhz() {
        return (this.fGa || this.aZL == null || this.aZL.equals(this.fFZ)) ? false : true;
    }

    public void setVideoStatsData(x xVar) {
        this.fFX = xVar;
    }

    public x bhA() {
        return this.fFX;
    }
}
