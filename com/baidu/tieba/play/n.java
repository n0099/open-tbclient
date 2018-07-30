package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String EL;
    private String bnB;
    private long ggA;
    private y ggm;
    private String ggo;
    private u ggt;
    private com.baidu.tieba.video.b ggu;
    private boolean ggv;
    private Context mContext;
    private String ggn = "1";
    private boolean ggp = false;
    private long drz = 0;
    private long ggq = 0;
    private long mStartTime = 0;
    private long ggr = 0;
    private int ggs = 0;
    private boolean ggw = false;
    private boolean ggx = false;
    private int ggy = 8;
    private int ggz = 16;
    private Runnable ggB = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ggw && n.this.ggx && n.this.bkg() && n.this.bkC()) {
                s.f(n.this.mContext, n.this.ggo, -1);
            }
        }
    };
    private Runnable ggC = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bkC()) {
                s.ac(n.this.mContext, n.this.ggo);
            } else if (!n.this.ggp) {
                s.it(n.this.ggo);
            }
        }
    };
    private j.c gff = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Ty() {
            n.g(n.this);
        }
    };
    private j bvq = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.ggs;
        nVar.ggs = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bvq.a(this.gff);
        this.ggt = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String ir(String str) {
        this.ggw = com.baidu.tbadk.coreExtra.model.f.Fo();
        this.ggx = com.baidu.tbadk.coreExtra.model.f.Fp();
        this.ggy = com.baidu.tbadk.coreExtra.model.f.Fq();
        this.ggz = com.baidu.tbadk.coreExtra.model.f.Fr();
        this.ggo = str;
        this.bnB = this.ggp ? this.ggo : s.P(str, this.ggw);
        if (this.ggt != null) {
            v.a("start_play", this.ggo, bkC(), (int) this.ggt.bkO(), this.ggt.getDuration());
        }
        this.ggq = System.currentTimeMillis();
        return this.bnB;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bkg() {
        return !StringUtils.isNull(this.bnB) && this.bnB.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bkh() {
        return this.ggw;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bki() {
        return this.ggx;
    }

    @Override // com.baidu.tieba.play.d
    public int bkj() {
        return com.baidu.tbadk.coreExtra.model.f.Fs() ? this.ggy : this.ggz;
    }

    @Override // com.baidu.tieba.play.d
    public String bke() {
        return this.ggo;
    }

    @Override // com.baidu.tieba.play.d
    public void bkk() {
        if (this.ggw && this.ggx && bkg() && bkC()) {
            s.f(this.mContext, this.ggo, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cL(long j) {
        this.ggA = j;
        bkB();
        if (this.ggq > 0) {
            this.ggr = System.currentTimeMillis() - this.ggq;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.ggo) && (parse = Uri.parse(n.this.ggo)) != null) {
                    try {
                        n.this.EL = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.drz += currentTimeMillis;
            cM(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bvq != null) {
            this.bvq.start();
        }
        this.ggv = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggC);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggB);
        bkm();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.drz += currentTimeMillis;
            cM(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bky();
        if (this.bvq != null) {
            this.bvq.stop();
        }
        if (this.ggr > 0 && this.ggt != null) {
            an anVar = new an("c11685");
            anVar.af("service_ip", this.EL);
            anVar.af(WebVideoActivityConfig.KEY_VIDEO_URL, this.ggo);
            anVar.f("video_size", this.ggt.bkO());
            anVar.r(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.ggt.getDuration());
            anVar.af("video_resolution", this.ggt.bkP());
            anVar.r("loading_count", this.ggs);
            anVar.f("user_watch_time", this.drz / 1000);
            anVar.f("start_play_time", this.ggr);
            TiebaStatic.log(anVar);
        }
        if (this.ggt != null && this.ggr > 0) {
            v.a("stop_play", this.ggo, bkC(), (int) this.ggt.bkO(), this.ggt.getDuration());
        }
        bkx();
        this.ggr = 0L;
        this.drz = 0L;
        this.ggs = 0;
        this.ggq = 0L;
        this.mStartTime = 0L;
        this.ggv = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.ggu = bVar;
    }

    private void cM(long j) {
        if (this.ggu != null) {
            this.ggu.setVideoWatchDuration(this.ggu.getVideoWatchDuration() + j);
        }
    }

    private void bkx() {
        if (this.ggu != null && this.ggv) {
            TbSingleton.getInstance().putVideoRecord(this.ggu.getThreadId(), (int) (this.ggu.getVideoWatchDuration() / 1000));
        }
    }

    private void bky() {
        if (this.drz >= 0 && this.drz < 86400000) {
            if (this.drz > 0) {
                an anVar = new an("c11244");
                anVar.f("obj_duration", this.drz);
                anVar.af("obj_type", this.ggn);
                anVar.f("playduration", this.ggA);
                if (this.ggm != null) {
                    this.ggm.b(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.drz, this.ggn, this.ggm, "", this.ggA);
            } else if (this.ggv) {
                l.a(this.drz, this.ggn, this.ggm, "", this.ggA);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.drz += currentTimeMillis;
            cM(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bkx();
        this.ggv = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.drz += currentTimeMillis;
            cM(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bkx();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bkf() {
        return s.is(this.ggo) != null;
    }

    public void bkz() {
        this.ggp = true;
    }

    public void sc(String str) {
        this.ggn = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bkl() {
        return this.bvq;
    }

    public void a(j.b bVar) {
        if (this.bvq != null) {
            this.bvq.a(bVar);
        }
    }

    public u bkA() {
        return this.ggt;
    }

    public void bkB() {
        if (!this.ggw) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggC);
            com.baidu.adp.lib.g.e.in().postDelayed(this.ggC, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void rG(int i) {
        if (bkC()) {
            s.f(this.mContext, this.ggo, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggB);
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggB, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bkm() {
        if (bkC()) {
            s.ad(this.mContext, this.ggo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkC() {
        return (this.ggp || this.bnB == null || this.bnB.equals(this.ggo)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.ggm = yVar;
    }

    public y bkD() {
        return this.ggm;
    }
}
