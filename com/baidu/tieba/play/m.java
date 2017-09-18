package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.i;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class m implements QuickVideoView.a {
    private String aXU;
    private w fBh;
    private String fBj;
    private t fBp;
    private Context mContext;
    private String zV;
    private String fBi = "1";
    private boolean fBk = false;
    private long fBl = 0;
    private long fBm = 0;
    private long mStartTime = 0;
    private long fBn = 0;
    private int fBo = 0;
    private Runnable fBq = new Runnable() { // from class: com.baidu.tieba.play.m.2
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bfR()) {
                r.af(m.this.mContext, m.this.fBj);
            } else if (!m.this.fBk) {
                r.hy(m.this.fBj);
            }
        }
    };
    private i.c fAI = new i.c() { // from class: com.baidu.tieba.play.m.3
        @Override // com.baidu.tieba.play.i.c
        public void bfH() {
            m.e(m.this);
        }
    };
    private i bLv = new i();

    static /* synthetic */ int e(m mVar) {
        int i = mVar.fBo;
        mVar.fBo = i + 1;
        return i;
    }

    public m(Context context) {
        this.mContext = context;
        this.bLv.a(this.fAI);
        this.fBp = new t();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hw(String str) {
        this.fBj = str;
        this.aXU = this.fBk ? this.fBj : r.hw(str);
        if (this.fBp != null) {
            u.a("start_play", this.fBj, bfR(), (int) this.fBp.bfZ(), this.fBp.getDuration());
        }
        this.fBm = System.currentTimeMillis();
        return this.aXU;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bfN() {
        return this.fBj;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPrepared() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fBq);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.fBq, 200L);
        if (this.fBm > 0) {
            this.fBn = System.currentTimeMillis() - this.fBm;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.m.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(m.this.fBj) && (parse = Uri.parse(m.this.fBj)) != null) {
                    try {
                        m.this.zV = InetAddress.getByName(parse.getHost()).getHostAddress();
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

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.bLv != null) {
            this.bLv.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fBq);
        if (bfR()) {
            r.ag(this.mContext, this.fBj);
        }
        long j = this.mStartTime;
        if (this.mStartTime > 0) {
            this.fBl += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (j > 0 && this.fBl >= 0 && this.fBl < 86400000) {
            if (this.fBl > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fBl);
                akVar.ad("obj_type", this.fBi);
                if (this.fBh != null) {
                    this.fBh.f(akVar);
                }
                TiebaStatic.log(akVar);
                k.a(this.fBl, this.fBi, this.fBh, "");
            } else {
                k.a(this.fBl, this.fBi, this.fBh, "");
            }
        }
        if (this.bLv != null) {
            this.bLv.stop();
        }
        if (this.fBn > 0 && this.fBp != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ad("service_ip", this.zV);
            akVar2.ad("video_url", this.fBj);
            akVar2.f("video_size", this.fBp.bfZ());
            akVar2.r("video_duration", this.fBp.getDuration());
            akVar2.ad("video_resolution", this.fBp.bga());
            akVar2.r("loading_count", this.fBo);
            akVar2.f("user_watch_time", this.fBl / 1000);
            akVar2.f("start_play_time", this.fBn);
            TiebaStatic.log(akVar2);
        }
        if (this.fBp != null && this.fBn > 0) {
            u.a("stop_play", this.fBj, bfR(), (int) this.fBp.bfZ(), this.fBp.getDuration());
        }
        this.fBn = 0L;
        this.fBl = 0L;
        this.fBo = 0;
        this.fBm = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fBl += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fBl += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bfO() {
        return r.hx(this.fBj) != null;
    }

    public void bfP() {
        this.fBk = true;
    }

    public void qC(String str) {
        this.fBi = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public i getMediaProgressObserver() {
        return this.bLv;
    }

    public t bfQ() {
        return this.fBp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfR() {
        return (this.fBk || this.aXU == null || this.aXU.equals(this.fBj)) ? false : true;
    }

    public void setVideoStatsData(w wVar) {
        this.fBh = wVar;
    }
}
