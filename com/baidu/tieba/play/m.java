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
    private String Cc;
    private String aYk;
    private w fBJ;
    private String fBL;
    private t fBR;
    private Context mContext;
    private String fBK = "1";
    private boolean fBM = false;
    private long fBN = 0;
    private long fBO = 0;
    private long mStartTime = 0;
    private long fBP = 0;
    private int fBQ = 0;
    private Runnable fBS = new Runnable() { // from class: com.baidu.tieba.play.m.2
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bgv()) {
                r.af(m.this.mContext, m.this.fBL);
            } else if (!m.this.fBM) {
                r.hz(m.this.fBL);
            }
        }
    };
    private i.c fBl = new i.c() { // from class: com.baidu.tieba.play.m.3
        @Override // com.baidu.tieba.play.i.c
        public void bgn() {
            m.e(m.this);
        }
    };
    private i bHJ = new i();

    static /* synthetic */ int e(m mVar) {
        int i = mVar.fBQ;
        mVar.fBQ = i + 1;
        return i;
    }

    public m(Context context) {
        this.mContext = context;
        this.bHJ.a(this.fBl);
        this.fBR = new t();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hx(String str) {
        this.fBL = str;
        this.aYk = this.fBM ? this.fBL : r.hx(str);
        if (this.fBR != null) {
            u.a("start_play", this.fBL, bgv(), (int) this.fBR.bgD(), this.fBR.getDuration());
        }
        this.fBO = System.currentTimeMillis();
        return this.aYk;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bgr() {
        return this.fBL;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPrepared() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fBS);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.fBS, 200L);
        if (this.fBO > 0) {
            this.fBP = System.currentTimeMillis() - this.fBO;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.m.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!al.isEmpty(m.this.fBL) && (parse = Uri.parse(m.this.fBL)) != null) {
                    try {
                        m.this.Cc = InetAddress.getByName(parse.getHost()).getHostAddress();
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
        if (this.bHJ != null) {
            this.bHJ.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fBS);
        if (bgv()) {
            r.ag(this.mContext, this.fBL);
        }
        if (this.mStartTime > 0) {
            this.fBN += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fBN > 0 && this.fBN < 86400000) {
            aj ajVar = new aj("c11244");
            ajVar.g("obj_duration", this.fBN);
            ajVar.aa("obj_type", this.fBK);
            if (this.fBJ != null) {
                this.fBJ.f(ajVar);
            }
            TiebaStatic.log(ajVar);
        }
        if (this.bHJ != null) {
            this.bHJ.stop();
        }
        if (this.fBP > 0 && this.fBR != null) {
            aj ajVar2 = new aj("c11685");
            ajVar2.aa("service_ip", this.Cc);
            ajVar2.aa("video_url", this.fBL);
            ajVar2.g("video_size", this.fBR.bgD());
            ajVar2.r("video_duration", this.fBR.getDuration());
            ajVar2.aa("video_resolution", this.fBR.bgE());
            ajVar2.r("loading_count", this.fBQ);
            ajVar2.g("user_watch_time", this.fBN / 1000);
            ajVar2.g("start_play_time", this.fBP);
            TiebaStatic.log(ajVar2);
        }
        if (this.fBR != null && this.fBP > 0) {
            u.a("stop_play", this.fBL, bgv(), (int) this.fBR.bgD(), this.fBR.getDuration());
        }
        this.fBP = 0L;
        this.fBN = 0L;
        this.fBQ = 0;
        this.fBO = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fBN += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fBN += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bgs() {
        return r.hy(this.fBL) != null;
    }

    public void bgt() {
        this.fBM = true;
    }

    public void qJ(String str) {
        this.fBK = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public i getMediaProgressObserver() {
        return this.bHJ;
    }

    public t bgu() {
        return this.fBR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgv() {
        return (this.fBM || this.aYk == null || this.aYk.equals(this.fBL)) ? false : true;
    }

    public void setVideoStatsData(w wVar) {
        this.fBJ = wVar;
    }
}
