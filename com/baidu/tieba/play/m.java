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
    private String aYl;
    private w fBL;
    private String fBN;
    private t fBT;
    private Context mContext;
    private String fBM = "1";
    private boolean fBO = false;
    private long fBP = 0;
    private long fBQ = 0;
    private long mStartTime = 0;
    private long fBR = 0;
    private int fBS = 0;
    private Runnable fBU = new Runnable() { // from class: com.baidu.tieba.play.m.2
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bgq()) {
                r.af(m.this.mContext, m.this.fBN);
            } else if (!m.this.fBO) {
                r.hC(m.this.fBN);
            }
        }
    };
    private i.c fBn = new i.c() { // from class: com.baidu.tieba.play.m.3
        @Override // com.baidu.tieba.play.i.c
        public void bgi() {
            m.e(m.this);
        }
    };
    private i bHK = new i();

    static /* synthetic */ int e(m mVar) {
        int i = mVar.fBS;
        mVar.fBS = i + 1;
        return i;
    }

    public m(Context context) {
        this.mContext = context;
        this.bHK.a(this.fBn);
        this.fBT = new t();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hA(String str) {
        this.fBN = str;
        this.aYl = this.fBO ? this.fBN : r.hA(str);
        if (this.fBT != null) {
            u.a("start_play", this.fBN, bgq(), (int) this.fBT.bgy(), this.fBT.getDuration());
        }
        this.fBQ = System.currentTimeMillis();
        return this.aYl;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bgm() {
        return this.fBN;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPrepared() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fBU);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.fBU, 200L);
        if (this.fBQ > 0) {
            this.fBR = System.currentTimeMillis() - this.fBQ;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.m.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!al.isEmpty(m.this.fBN) && (parse = Uri.parse(m.this.fBN)) != null) {
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
        if (this.bHK != null) {
            this.bHK.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fBU);
        if (bgq()) {
            r.ag(this.mContext, this.fBN);
        }
        if (this.mStartTime > 0) {
            this.fBP += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fBP > 0 && this.fBP < 86400000) {
            aj ajVar = new aj("c11244");
            ajVar.g("obj_duration", this.fBP);
            ajVar.aa("obj_type", this.fBM);
            if (this.fBL != null) {
                this.fBL.f(ajVar);
            }
            TiebaStatic.log(ajVar);
        }
        if (this.bHK != null) {
            this.bHK.stop();
        }
        if (this.fBR > 0 && this.fBT != null) {
            aj ajVar2 = new aj("c11685");
            ajVar2.aa("service_ip", this.Cc);
            ajVar2.aa("video_url", this.fBN);
            ajVar2.g("video_size", this.fBT.bgy());
            ajVar2.r("video_duration", this.fBT.getDuration());
            ajVar2.aa("video_resolution", this.fBT.bgz());
            ajVar2.r("loading_count", this.fBS);
            ajVar2.g("user_watch_time", this.fBP / 1000);
            ajVar2.g("start_play_time", this.fBR);
            TiebaStatic.log(ajVar2);
        }
        if (this.fBT != null && this.fBR > 0) {
            u.a("stop_play", this.fBN, bgq(), (int) this.fBT.bgy(), this.fBT.getDuration());
        }
        this.fBR = 0L;
        this.fBP = 0L;
        this.fBS = 0;
        this.fBQ = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fBP += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fBP += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bgn() {
        return r.hB(this.fBN) != null;
    }

    public void bgo() {
        this.fBO = true;
    }

    public void qO(String str) {
        this.fBM = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public i getMediaProgressObserver() {
        return this.bHK;
    }

    public t bgp() {
        return this.fBT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgq() {
        return (this.fBO || this.aYl == null || this.aYl.equals(this.fBN)) ? false : true;
    }

    public void setVideoStatsData(w wVar) {
        this.fBL = wVar;
    }
}
