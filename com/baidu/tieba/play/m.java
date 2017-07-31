package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.i;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class m implements QuickVideoView.a {
    private String Ca;
    private String aYj;
    private w fzQ;
    private String fzS;
    private t fzY;
    private Context mContext;
    private String fzR = "1";
    private boolean fzT = false;
    private long fzU = 0;
    private long fzV = 0;
    private long mStartTime = 0;
    private long fzW = 0;
    private int fzX = 0;
    private Runnable fzZ = new Runnable() { // from class: com.baidu.tieba.play.m.2
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bfP()) {
                r.af(m.this.mContext, m.this.fzS);
            } else if (!m.this.fzT) {
                r.hz(m.this.fzS);
            }
        }
    };
    private i.c fzs = new i.c() { // from class: com.baidu.tieba.play.m.3
        @Override // com.baidu.tieba.play.i.c
        public void bfH() {
            m.e(m.this);
        }
    };
    private i bHa = new i();

    static /* synthetic */ int e(m mVar) {
        int i = mVar.fzX;
        mVar.fzX = i + 1;
        return i;
    }

    public m(Context context) {
        this.mContext = context;
        this.bHa.a(this.fzs);
        this.fzY = new t();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hx(String str) {
        this.fzS = str;
        this.aYj = this.fzT ? this.fzS : r.hx(str);
        if (this.fzY != null) {
            u.a("start_play", this.fzS, bfP(), (int) this.fzY.bfX(), this.fzY.getDuration());
        }
        this.fzV = System.currentTimeMillis();
        return this.aYj;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bfL() {
        return this.fzS;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPrepared() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fzZ);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.fzZ, 200L);
        if (this.fzV > 0) {
            this.fzW = System.currentTimeMillis() - this.fzV;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.m.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!al.isEmpty(m.this.fzS) && (parse = Uri.parse(m.this.fzS)) != null) {
                    try {
                        m.this.Ca = InetAddress.getByName(parse.getHost()).getHostAddress();
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
        if (this.bHa != null) {
            this.bHa.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fzZ);
        if (bfP()) {
            r.ag(this.mContext, this.fzS);
        }
        if (this.mStartTime > 0) {
            this.fzU += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fzU > 0 && this.fzU < 86400000) {
            aj ajVar = new aj("c11244");
            ajVar.g("obj_duration", this.fzU);
            ajVar.aa("obj_type", this.fzR);
            if (this.fzQ != null) {
                this.fzQ.f(ajVar);
            }
            TiebaStatic.log(ajVar);
        }
        if (this.bHa != null) {
            this.bHa.stop();
        }
        if (this.fzW > 0 && this.fzY != null) {
            aj ajVar2 = new aj("c11685");
            ajVar2.aa("service_ip", this.Ca);
            ajVar2.aa("video_url", this.fzS);
            ajVar2.g("video_size", this.fzY.bfX());
            ajVar2.r("video_duration", this.fzY.getDuration());
            ajVar2.aa("video_resolution", this.fzY.bfY());
            ajVar2.r("loading_count", this.fzX);
            ajVar2.g("user_watch_time", this.fzU / 1000);
            ajVar2.g("start_play_time", this.fzW);
            TiebaStatic.log(ajVar2);
        }
        if (this.fzY != null && this.fzW > 0) {
            u.a("stop_play", this.fzS, bfP(), (int) this.fzY.bfX(), this.fzY.getDuration());
        }
        this.fzW = 0L;
        this.fzU = 0L;
        this.fzX = 0;
        this.fzV = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fzU += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fzU += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bfM() {
        return r.hy(this.fzS) != null;
    }

    public void bfN() {
        this.fzT = true;
    }

    public void qH(String str) {
        this.fzR = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public i getMediaProgressObserver() {
        return this.bHa;
    }

    public t bfO() {
        return this.fzY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfP() {
        return (this.fzT || this.aYj == null || this.aYj.equals(this.fzS)) ? false : true;
    }

    public void setVideoStatsData(w wVar) {
        this.fzQ = wVar;
    }
}
