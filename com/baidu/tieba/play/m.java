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
    private String AA;
    private String aWY;
    private w fyE;
    private String fyG;
    private t fyM;
    private Context mContext;
    private String fyF = "1";
    private boolean fyH = false;
    private long fyI = 0;
    private long fyJ = 0;
    private long mStartTime = 0;
    private long fyK = 0;
    private int fyL = 0;
    private Runnable fyN = new Runnable() { // from class: com.baidu.tieba.play.m.2
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bfF()) {
                r.af(m.this.mContext, m.this.fyG);
            } else if (!m.this.fyH) {
                r.hu(m.this.fyG);
            }
        }
    };
    private i.c fyg = new i.c() { // from class: com.baidu.tieba.play.m.3
        @Override // com.baidu.tieba.play.i.c
        public void bfx() {
            m.e(m.this);
        }
    };
    private i bFQ = new i();

    static /* synthetic */ int e(m mVar) {
        int i = mVar.fyL;
        mVar.fyL = i + 1;
        return i;
    }

    public m(Context context) {
        this.mContext = context;
        this.bFQ.a(this.fyg);
        this.fyM = new t();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hs(String str) {
        this.fyG = str;
        this.aWY = this.fyH ? this.fyG : r.hs(str);
        if (this.fyM != null) {
            u.a("start_play", this.fyG, bfF(), (int) this.fyM.bfN(), this.fyM.getDuration());
        }
        this.fyJ = System.currentTimeMillis();
        return this.aWY;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bfB() {
        return this.fyG;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPrepared() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fyN);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fyN, 200L);
        if (this.fyJ > 0) {
            this.fyK = System.currentTimeMillis() - this.fyJ;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.m.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!al.isEmpty(m.this.fyG) && (parse = Uri.parse(m.this.fyG)) != null) {
                    try {
                        m.this.AA = InetAddress.getByName(parse.getHost()).getHostAddress();
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
        if (this.bFQ != null) {
            this.bFQ.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fyN);
        if (bfF()) {
            r.ag(this.mContext, this.fyG);
        }
        if (this.mStartTime > 0) {
            this.fyI += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fyI > 0 && this.fyI < 86400000) {
            aj ajVar = new aj("c11244");
            ajVar.f("obj_duration", this.fyI);
            ajVar.aa("obj_type", this.fyF);
            if (this.fyE != null) {
                this.fyE.f(ajVar);
            }
            TiebaStatic.log(ajVar);
        }
        if (this.bFQ != null) {
            this.bFQ.stop();
        }
        if (this.fyK > 0 && this.fyM != null) {
            aj ajVar2 = new aj("c11685");
            ajVar2.aa("service_ip", this.AA);
            ajVar2.aa("video_url", this.fyG);
            ajVar2.f("video_size", this.fyM.bfN());
            ajVar2.r("video_duration", this.fyM.getDuration());
            ajVar2.aa("video_resolution", this.fyM.bfO());
            ajVar2.r("loading_count", this.fyL);
            ajVar2.f("user_watch_time", this.fyI / 1000);
            ajVar2.f("start_play_time", this.fyK);
            TiebaStatic.log(ajVar2);
        }
        if (this.fyM != null && this.fyK > 0) {
            u.a("stop_play", this.fyG, bfF(), (int) this.fyM.bfN(), this.fyM.getDuration());
        }
        this.fyK = 0L;
        this.fyI = 0L;
        this.fyL = 0;
        this.fyJ = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fyI += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onCompletion() {
        if (this.mStartTime > 0) {
            this.fyI += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bfC() {
        return r.ht(this.fyG) != null;
    }

    public void bfD() {
        this.fyH = true;
    }

    public void qC(String str) {
        this.fyF = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public i getMediaProgressObserver() {
        return this.bFQ;
    }

    public t bfE() {
        return this.fyM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfF() {
        return (this.fyH || this.aWY == null || this.aWY.equals(this.fyG)) ? false : true;
    }

    public void setVideoStatsData(w wVar) {
        this.fyE = wVar;
    }
}
