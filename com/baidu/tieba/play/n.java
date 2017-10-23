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
    private String aZu;
    private x fxg;
    private String fxi;
    private u fxp;
    private Context mContext;
    private String zY;
    private String fxh = "1";
    private boolean fxj = false;
    private long fxl = 0;
    private long fxm = 0;
    private long mStartTime = 0;
    private long fxn = 0;
    private int fxo = 0;
    private Runnable fxq = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.beo()) {
                s.aa(n.this.mContext, n.this.fxi);
            } else if (!n.this.fxj) {
                s.hu(n.this.fxi);
            }
        }
    };
    private j.c fwH = new j.c() { // from class: com.baidu.tieba.play.n.3
        @Override // com.baidu.tieba.play.j.c
        public void bee() {
            n.e(n.this);
        }
    };
    private j bKE = new j();

    static /* synthetic */ int e(n nVar) {
        int i = nVar.fxo;
        nVar.fxo = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bKE.a(this.fwH);
        this.fxp = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String hs(String str) {
        this.fxi = str;
        this.aZu = this.fxj ? this.fxi : s.hs(str);
        if (this.fxp != null) {
            v.a("start_play", this.fxi, beo(), (int) this.fxp.bew(), this.fxp.getDuration());
        }
        this.fxm = System.currentTimeMillis();
        return this.aZu;
    }

    @Override // com.baidu.tieba.play.d
    public String bec() {
        return this.fxi;
    }

    @Override // com.baidu.tieba.play.d
    public void onPrepared() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fxq);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fxq, 200L);
        if (this.fxm > 0) {
            this.fxn = System.currentTimeMillis() - this.fxm;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(n.this.fxi) && (parse = Uri.parse(n.this.fxi)) != null) {
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
            this.fxl += System.currentTimeMillis() - this.mStartTime;
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bKE != null) {
            this.bKE.start();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fxq);
        if (beo()) {
            s.ab(this.mContext, this.fxi);
        }
        if (this.mStartTime > 0) {
            this.fxl += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fxl >= 0 && this.fxl < 86400000) {
            if (this.fxl > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fxl);
                akVar.ac("obj_type", this.fxh);
                if (this.fxg != null) {
                    this.fxg.f(akVar);
                }
                TiebaStatic.log(akVar);
                l.a(this.fxl, this.fxh, this.fxg, "");
            } else {
                l.a(this.fxl, this.fxh, this.fxg, "");
            }
        }
        if (this.bKE != null) {
            this.bKE.stop();
        }
        if (this.fxn > 0 && this.fxp != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ac("service_ip", this.zY);
            akVar2.ac("video_url", this.fxi);
            akVar2.f("video_size", this.fxp.bew());
            akVar2.r("video_duration", this.fxp.getDuration());
            akVar2.ac("video_resolution", this.fxp.bex());
            akVar2.r("loading_count", this.fxo);
            akVar2.f("user_watch_time", this.fxl / 1000);
            akVar2.f("start_play_time", this.fxn);
            TiebaStatic.log(akVar2);
        }
        if (this.fxp != null && this.fxn > 0) {
            v.a("stop_play", this.fxi, beo(), (int) this.fxp.bew(), this.fxp.getDuration());
        }
        this.fxn = 0L;
        this.fxl = 0L;
        this.fxo = 0;
        this.fxm = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fxl += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fxl += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bel() {
        return s.ht(this.fxi) != null;
    }

    public void bem() {
        this.fxj = true;
    }

    public void ql(String str) {
        this.fxh = str;
    }

    @Override // com.baidu.tieba.play.d
    public j getMediaProgressObserver() {
        return this.bKE;
    }

    public u ben() {
        return this.fxp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beo() {
        return (this.fxj || this.aZu == null || this.aZu.equals(this.fxi)) ? false : true;
    }

    public void setVideoStatsData(x xVar) {
        this.fxg = xVar;
    }
}
