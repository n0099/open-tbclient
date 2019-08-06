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
    private long ixC;
    private z ixo;
    private String ixq;
    private v ixv;
    private com.baidu.tieba.video.b ixw;
    private boolean ixx;
    private Context mContext;
    private String ixp = "1";
    private boolean ixr = false;
    private long fAG = 0;
    private long ixs = 0;
    private long mStartTime = 0;
    private long ixt = 0;
    private int ixu = 0;
    private boolean ixy = false;
    private boolean ixz = false;
    private int ixA = 8;
    private int ixB = 16;
    private Runnable ixD = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ixy && n.this.ixz && n.this.cel() && n.this.ceK()) {
                t.f(n.this.mContext, n.this.ixq, -1);
            }
        }
    };
    private Runnable ixE = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ceK()) {
                t.aq(n.this.mContext, n.this.ixq);
            } else if (!n.this.ixr) {
                t.se(n.this.ixq);
            }
        }
    };
    private j.c iwi = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aJd() {
            n.g(n.this);
        }
    };
    private j dnC = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.ixu;
        nVar.ixu = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dnC.a(this.iwi);
        this.ixv = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String sc(String str) {
        this.ixy = com.baidu.tbadk.coreExtra.model.f.apO();
        this.ixz = com.baidu.tbadk.coreExtra.model.f.apP();
        this.ixA = com.baidu.tbadk.coreExtra.model.f.apQ();
        this.ixB = com.baidu.tbadk.coreExtra.model.f.apR();
        this.ixq = str;
        this.alH = this.ixr ? this.ixq : t.aw(str, this.ixy);
        if (this.ixv != null) {
            w.a("start_play", this.ixq, ceK(), (int) this.ixv.ceW(), this.ixv.getDuration());
        }
        this.ixs = System.currentTimeMillis();
        return this.alH;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cel() {
        return !StringUtils.isNull(this.alH) && this.alH.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cem() {
        return this.ixy;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cen() {
        return this.ixz;
    }

    @Override // com.baidu.tieba.play.d
    public int ceo() {
        return com.baidu.tbadk.coreExtra.model.f.apS() ? this.ixA : this.ixB;
    }

    @Override // com.baidu.tieba.play.d
    public String cej() {
        return this.ixq;
    }

    @Override // com.baidu.tieba.play.d
    public void cep() {
        if (this.ixy && this.ixz && cel() && ceK()) {
            t.f(this.mContext, this.ixq, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void eq(long j) {
        this.ixC = j;
        ceJ();
        if (this.ixs > 0) {
            this.ixt = System.currentTimeMillis() - this.ixs;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.ixq) && (parse = Uri.parse(n.this.ixq)) != null) {
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
            this.fAG += currentTimeMillis;
            er(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dnC != null) {
            this.dnC.start();
        }
        this.ixx = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixE);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixD);
        cer();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fAG += currentTimeMillis;
            er(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ceG();
        if (this.dnC != null) {
            this.dnC.stop();
        }
        if (this.ixt > 0 && this.ixv != null) {
            an anVar = new an("c11685");
            anVar.bT("service_ip", this.FI);
            anVar.bT(WebVideoActivityConfig.KEY_VIDEO_URL, this.ixq);
            anVar.l("video_size", this.ixv.ceW());
            anVar.P(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.ixv.getDuration());
            anVar.bT("video_resolution", this.ixv.ceX());
            anVar.P("loading_count", this.ixu);
            anVar.l("user_watch_time", this.fAG / 1000);
            anVar.l("start_play_time", this.ixt);
            TiebaStatic.log(anVar);
        }
        if (this.ixv != null && this.ixt > 0) {
            w.a("stop_play", this.ixq, ceK(), (int) this.ixv.ceW(), this.ixv.getDuration());
        }
        ceF();
        this.ixt = 0L;
        this.fAG = 0L;
        this.ixu = 0;
        this.ixs = 0L;
        this.mStartTime = 0L;
        this.ixx = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.ixw = bVar;
    }

    private void er(long j) {
        if (this.ixw != null) {
            this.ixw.setVideoWatchDuration(this.ixw.getVideoWatchDuration() + j);
        }
    }

    private void ceF() {
        if (this.ixw != null && this.ixx) {
            TbSingleton.getInstance().putVideoRecord(this.ixw.getThreadId(), (int) (this.ixw.getVideoWatchDuration() / 1000));
        }
    }

    private void ceG() {
        if (this.fAG >= 0 && this.fAG < 86400000) {
            if (this.fAG > 0) {
                an anVar = new an("c11244");
                anVar.l("obj_duration", this.fAG);
                anVar.bT("obj_type", this.ixp);
                anVar.l("playduration", this.ixC);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bT("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ixo != null) {
                    this.ixo.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fAG, this.ixp, this.ixo, "", this.ixC);
            } else if (this.ixx) {
                l.a(this.fAG, this.ixp, this.ixo, "", this.ixC);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fAG += currentTimeMillis;
            er(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ceF();
        this.ixx = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fAG += currentTimeMillis;
            er(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ceF();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cek() {
        return t.sd(this.ixq) != null;
    }

    public void ceH() {
        this.ixr = true;
    }

    public void CY(String str) {
        this.ixp = str;
    }

    @Override // com.baidu.tieba.play.d
    public j ceq() {
        return this.dnC;
    }

    public void a(j.b bVar) {
        if (this.dnC != null) {
            this.dnC.a(bVar);
        }
    }

    public v ceI() {
        return this.ixv;
    }

    public void ceJ() {
        if (!this.ixy) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixE);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.ixE, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void yX(int i) {
        if (ceK()) {
            t.f(this.mContext, this.ixq, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixD);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.ixD, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void cer() {
        if (ceK()) {
            t.ar(this.mContext, this.ixq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceK() {
        return (this.ixr || this.alH == null || this.alH.equals(this.ixq)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.ixo = zVar;
    }

    public z ceL() {
        return this.ixo;
    }
}
