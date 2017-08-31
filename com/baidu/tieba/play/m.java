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
    private String aXX;
    private w fAo;
    private String fAq;
    private t fAw;
    private Context mContext;
    private String zV;
    private String fAp = "1";
    private boolean fAr = false;
    private long fAs = 0;
    private long fAt = 0;
    private long mStartTime = 0;
    private long fAu = 0;
    private int fAv = 0;
    private Runnable fAx = new Runnable() { // from class: com.baidu.tieba.play.m.2
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bfG()) {
                r.af(m.this.mContext, m.this.fAq);
            } else if (!m.this.fAr) {
                r.hy(m.this.fAq);
            }
        }
    };
    private i.c fzP = new i.c() { // from class: com.baidu.tieba.play.m.3
        @Override // com.baidu.tieba.play.i.c
        public void bfw() {
            m.e(m.this);
        }
    };
    private i bKE = new i();

    static /* synthetic */ int e(m mVar) {
        int i = mVar.fAv;
        mVar.fAv = i + 1;
        return i;
    }

    public m(Context context) {
        this.mContext = context;
        this.bKE.a(this.fzP);
        this.fAw = new t();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hw(String str) {
        this.fAq = str;
        this.aXX = this.fAr ? this.fAq : r.hw(str);
        if (this.fAw != null) {
            u.a("start_play", this.fAq, bfG(), (int) this.fAw.bfO(), this.fAw.getDuration());
        }
        this.fAt = System.currentTimeMillis();
        return this.aXX;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bfC() {
        return this.fAq;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPrepared() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fAx);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.fAx, 200L);
        if (this.fAt > 0) {
            this.fAu = System.currentTimeMillis() - this.fAt;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.m.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!am.isEmpty(m.this.fAq) && (parse = Uri.parse(m.this.fAq)) != null) {
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
        if (this.bKE != null) {
            this.bKE.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fAx);
        if (bfG()) {
            r.ag(this.mContext, this.fAq);
        }
        long j = this.mStartTime;
        if (this.mStartTime > 0) {
            this.fAs += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (j > 0 && this.fAs >= 0 && this.fAs < 86400000) {
            if (this.fAs > 0) {
                ak akVar = new ak("c11244");
                akVar.f("obj_duration", this.fAs);
                akVar.ad("obj_type", this.fAp);
                if (this.fAo != null) {
                    this.fAo.f(akVar);
                }
                TiebaStatic.log(akVar);
                k.a(this.fAs, this.fAp, this.fAo, "");
            } else {
                k.a(this.fAs, this.fAp, this.fAo, "");
            }
        }
        if (this.bKE != null) {
            this.bKE.stop();
        }
        if (this.fAu > 0 && this.fAw != null) {
            ak akVar2 = new ak("c11685");
            akVar2.ad("service_ip", this.zV);
            akVar2.ad("video_url", this.fAq);
            akVar2.f("video_size", this.fAw.bfO());
            akVar2.r("video_duration", this.fAw.getDuration());
            akVar2.ad("video_resolution", this.fAw.bfP());
            akVar2.r("loading_count", this.fAv);
            akVar2.f("user_watch_time", this.fAs / 1000);
            akVar2.f("start_play_time", this.fAu);
            TiebaStatic.log(akVar2);
        }
        if (this.fAw != null && this.fAu > 0) {
            u.a("stop_play", this.fAq, bfG(), (int) this.fAw.bfO(), this.fAw.getDuration());
        }
        this.fAu = 0L;
        this.fAs = 0L;
        this.fAv = 0;
        this.fAt = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fAs += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fAs += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bfD() {
        return r.hx(this.fAq) != null;
    }

    public void bfE() {
        this.fAr = true;
    }

    public void qA(String str) {
        this.fAp = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public i getMediaProgressObserver() {
        return this.bKE;
    }

    public t bfF() {
        return this.fAw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfG() {
        return (this.fAr || this.aXX == null || this.aXX.equals(this.fAq)) ? false : true;
    }

    public void setVideoStatsData(w wVar) {
        this.fAo = wVar;
    }
}
