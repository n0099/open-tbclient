package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String FI;
    private String alH;
    private z iwl;
    private String iwn;
    private v iws;
    private com.baidu.tieba.video.b iwt;
    private boolean iwu;
    private long iwz;
    private Context mContext;
    private String iwm = "1";
    private boolean iwo = false;
    private long fzS = 0;
    private long iwp = 0;
    private long mStartTime = 0;
    private long iwq = 0;
    private int iwr = 0;
    private boolean iwv = false;
    private boolean iww = false;
    private int iwx = 8;
    private int iwy = 16;
    private Runnable iwA = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.iwv && n.this.iww && n.this.cdT() && n.this.ces()) {
                t.f(n.this.mContext, n.this.iwn, -1);
            }
        }
    };
    private Runnable iwB = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ces()) {
                t.aq(n.this.mContext, n.this.iwn);
            } else if (!n.this.iwo) {
                t.se(n.this.iwn);
            }
        }
    };
    private j.c ivf = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aJb() {
            n.g(n.this);
        }
    };
    private j dnv = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.iwr;
        nVar.iwr = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dnv.a(this.ivf);
        this.iws = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String sc(String str) {
        this.iwv = com.baidu.tbadk.coreExtra.model.f.apM();
        this.iww = com.baidu.tbadk.coreExtra.model.f.apN();
        this.iwx = com.baidu.tbadk.coreExtra.model.f.apO();
        this.iwy = com.baidu.tbadk.coreExtra.model.f.apP();
        this.iwn = str;
        this.alH = this.iwo ? this.iwn : t.aw(str, this.iwv);
        if (this.iws != null) {
            w.a("start_play", this.iwn, ces(), (int) this.iws.ceE(), this.iws.getDuration());
        }
        this.iwp = System.currentTimeMillis();
        return this.alH;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cdT() {
        return !StringUtils.isNull(this.alH) && this.alH.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cdU() {
        return this.iwv;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cdV() {
        return this.iww;
    }

    @Override // com.baidu.tieba.play.d
    public int cdW() {
        return com.baidu.tbadk.coreExtra.model.f.apQ() ? this.iwx : this.iwy;
    }

    @Override // com.baidu.tieba.play.d
    public String cdR() {
        return this.iwn;
    }

    @Override // com.baidu.tieba.play.d
    public void cdX() {
        if (this.iwv && this.iww && cdT() && ces()) {
            t.f(this.mContext, this.iwn, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void eq(long j) {
        this.iwz = j;
        cer();
        if (this.iwp > 0) {
            this.iwq = System.currentTimeMillis() - this.iwp;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.iwn) && (parse = Uri.parse(n.this.iwn)) != null) {
                    try {
                        n.this.FI = InetAddress.getByName(parse.getHost()).getHostAddress();
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(2);
        bdAsyncTask.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.d
    public void onStart() {
        if (this.mStartTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fzS += currentTimeMillis;
            er(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dnv != null) {
            this.dnv.start();
        }
        this.iwu = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwB);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwA);
        cdZ();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fzS += currentTimeMillis;
            er(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ceo();
        if (this.dnv != null) {
            this.dnv.stop();
        }
        if (this.iwq > 0 && this.iws != null) {
            an anVar = new an("c11685");
            anVar.bT("service_ip", this.FI);
            anVar.bT(WebVideoActivityConfig.KEY_VIDEO_URL, this.iwn);
            anVar.l("video_size", this.iws.ceE());
            anVar.P(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.iws.getDuration());
            anVar.bT("video_resolution", this.iws.ceF());
            anVar.P("loading_count", this.iwr);
            anVar.l("user_watch_time", this.fzS / 1000);
            anVar.l("start_play_time", this.iwq);
            TiebaStatic.log(anVar);
        }
        if (this.iws != null && this.iwq > 0) {
            w.a("stop_play", this.iwn, ces(), (int) this.iws.ceE(), this.iws.getDuration());
        }
        cen();
        this.iwq = 0L;
        this.fzS = 0L;
        this.iwr = 0;
        this.iwp = 0L;
        this.mStartTime = 0L;
        this.iwu = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.iwt = bVar;
    }

    private void er(long j) {
        if (this.iwt != null) {
            this.iwt.setVideoWatchDuration(this.iwt.getVideoWatchDuration() + j);
        }
    }

    private void cen() {
        if (this.iwt != null && this.iwu) {
            TbSingleton.getInstance().putVideoRecord(this.iwt.getThreadId(), (int) (this.iwt.getVideoWatchDuration() / 1000));
        }
    }

    private void ceo() {
        if (this.fzS >= 0 && this.fzS < 86400000) {
            if (this.fzS > 0) {
                an anVar = new an("c11244");
                anVar.l("obj_duration", this.fzS);
                anVar.bT("obj_type", this.iwm);
                anVar.l("playduration", this.iwz);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bT("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.iwl != null) {
                    this.iwl.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fzS, this.iwm, this.iwl, "", this.iwz);
            } else if (this.iwu) {
                l.a(this.fzS, this.iwm, this.iwl, "", this.iwz);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fzS += currentTimeMillis;
            er(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cen();
        this.iwu = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fzS += currentTimeMillis;
            er(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cen();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cdS() {
        return t.sd(this.iwn) != null;
    }

    public void cep() {
        this.iwo = true;
    }

    public void CX(String str) {
        this.iwm = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cdY() {
        return this.dnv;
    }

    public void a(j.b bVar) {
        if (this.dnv != null) {
            this.dnv.a(bVar);
        }
    }

    public v ceq() {
        return this.iws;
    }

    public void cer() {
        if (!this.iwv) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwB);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.iwB, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void yV(int i) {
        if (ces()) {
            t.f(this.mContext, this.iwn, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwA);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iwA, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void cdZ() {
        if (ces()) {
            t.ar(this.mContext, this.iwn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ces() {
        return (this.iwo || this.alH == null || this.alH.equals(this.iwn)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.iwl = zVar;
    }

    public z cet() {
        return this.iwl;
    }
}
