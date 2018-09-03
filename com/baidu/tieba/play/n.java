package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String EL;
    private String bnE;
    private y ggl;
    private String ggn;
    private u ggs;
    private com.baidu.tieba.video.b ggt;
    private boolean ggu;
    private long ggz;
    private Context mContext;
    private String ggm = "1";
    private boolean ggo = false;
    private long drw = 0;
    private long ggp = 0;
    private long mStartTime = 0;
    private long ggq = 0;
    private int ggr = 0;
    private boolean ggv = false;
    private boolean ggw = false;
    private int ggx = 8;
    private int ggy = 16;
    private Runnable ggA = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ggv && n.this.ggw && n.this.bkd() && n.this.bkz()) {
                s.f(n.this.mContext, n.this.ggn, -1);
            }
        }
    };
    private Runnable ggB = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bkz()) {
                s.ac(n.this.mContext, n.this.ggn);
            } else if (!n.this.ggo) {
                s.iu(n.this.ggn);
            }
        }
    };
    private j.c gfe = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void TB() {
            n.g(n.this);
        }
    };
    private j bvs = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.ggr;
        nVar.ggr = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bvs.a(this.gfe);
        this.ggs = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String is(String str) {
        this.ggv = com.baidu.tbadk.coreExtra.model.f.Fo();
        this.ggw = com.baidu.tbadk.coreExtra.model.f.Fp();
        this.ggx = com.baidu.tbadk.coreExtra.model.f.Fq();
        this.ggy = com.baidu.tbadk.coreExtra.model.f.Fr();
        this.ggn = str;
        this.bnE = this.ggo ? this.ggn : s.P(str, this.ggv);
        if (this.ggs != null) {
            v.a("start_play", this.ggn, bkz(), (int) this.ggs.bkL(), this.ggs.getDuration());
        }
        this.ggp = System.currentTimeMillis();
        return this.bnE;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bkd() {
        return !StringUtils.isNull(this.bnE) && this.bnE.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bke() {
        return this.ggv;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bkf() {
        return this.ggw;
    }

    @Override // com.baidu.tieba.play.d
    public int bkg() {
        return com.baidu.tbadk.coreExtra.model.f.Fs() ? this.ggx : this.ggy;
    }

    @Override // com.baidu.tieba.play.d
    public String bkb() {
        return this.ggn;
    }

    @Override // com.baidu.tieba.play.d
    public void bkh() {
        if (this.ggv && this.ggw && bkd() && bkz()) {
            s.f(this.mContext, this.ggn, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cL(long j) {
        this.ggz = j;
        bky();
        if (this.ggp > 0) {
            this.ggq = System.currentTimeMillis() - this.ggp;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.ggn) && (parse = Uri.parse(n.this.ggn)) != null) {
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
            this.drw += currentTimeMillis;
            cM(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bvs != null) {
            this.bvs.start();
        }
        this.ggu = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggB);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggA);
        bkj();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.drw += currentTimeMillis;
            cM(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bkv();
        if (this.bvs != null) {
            this.bvs.stop();
        }
        if (this.ggq > 0 && this.ggs != null) {
            an anVar = new an("c11685");
            anVar.ae("service_ip", this.EL);
            anVar.ae(WebVideoActivityConfig.KEY_VIDEO_URL, this.ggn);
            anVar.f("video_size", this.ggs.bkL());
            anVar.r(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.ggs.getDuration());
            anVar.ae("video_resolution", this.ggs.bkM());
            anVar.r("loading_count", this.ggr);
            anVar.f("user_watch_time", this.drw / 1000);
            anVar.f("start_play_time", this.ggq);
            TiebaStatic.log(anVar);
        }
        if (this.ggs != null && this.ggq > 0) {
            v.a("stop_play", this.ggn, bkz(), (int) this.ggs.bkL(), this.ggs.getDuration());
        }
        bku();
        this.ggq = 0L;
        this.drw = 0L;
        this.ggr = 0;
        this.ggp = 0L;
        this.mStartTime = 0L;
        this.ggu = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.ggt = bVar;
    }

    private void cM(long j) {
        if (this.ggt != null) {
            this.ggt.setVideoWatchDuration(this.ggt.getVideoWatchDuration() + j);
        }
    }

    private void bku() {
        if (this.ggt != null && this.ggu) {
            TbSingleton.getInstance().putVideoRecord(this.ggt.getThreadId(), (int) (this.ggt.getVideoWatchDuration() / 1000));
        }
    }

    private void bkv() {
        if (this.drw >= 0 && this.drw < 86400000) {
            if (this.drw > 0) {
                an anVar = new an("c11244");
                anVar.f("obj_duration", this.drw);
                anVar.ae("obj_type", this.ggm);
                anVar.f("playduration", this.ggz);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.ae("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ggl != null) {
                    this.ggl.b(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.drw, this.ggm, this.ggl, "", this.ggz);
            } else if (this.ggu) {
                l.a(this.drw, this.ggm, this.ggl, "", this.ggz);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.drw += currentTimeMillis;
            cM(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bku();
        this.ggu = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.drw += currentTimeMillis;
            cM(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bku();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bkc() {
        return s.it(this.ggn) != null;
    }

    public void bkw() {
        this.ggo = true;
    }

    public void sf(String str) {
        this.ggm = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bki() {
        return this.bvs;
    }

    public void a(j.b bVar) {
        if (this.bvs != null) {
            this.bvs.a(bVar);
        }
    }

    public u bkx() {
        return this.ggs;
    }

    public void bky() {
        if (!this.ggv) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggB);
            com.baidu.adp.lib.g.e.in().postDelayed(this.ggB, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void rG(int i) {
        if (bkz()) {
            s.f(this.mContext, this.ggn, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggA);
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggA, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bkj() {
        if (bkz()) {
            s.ad(this.mContext, this.ggn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkz() {
        return (this.ggo || this.bnE == null || this.bnE.equals(this.ggn)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.ggl = yVar;
    }

    public y bkA() {
        return this.ggl;
    }
}
