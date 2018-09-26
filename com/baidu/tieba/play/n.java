package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String Hh;
    private String btt;
    private y gnF;
    private String gnH;
    private u gnM;
    private com.baidu.tieba.video.b gnN;
    private boolean gnO;
    private long gnT;
    private Context mContext;
    private String gnG = "1";
    private boolean gnI = false;
    private long dxM = 0;
    private long gnJ = 0;
    private long mStartTime = 0;
    private long gnK = 0;
    private int gnL = 0;
    private boolean gnP = false;
    private boolean gnQ = false;
    private int gnR = 8;
    private int gnS = 16;
    private Runnable gnU = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.gnP && n.this.gnQ && n.this.bmJ() && n.this.bnf()) {
                s.g(n.this.mContext, n.this.gnH, -1);
            }
        }
    };
    private Runnable gnV = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.bnf()) {
                s.ar(n.this.mContext, n.this.gnH);
            } else if (!n.this.gnI) {
                s.iV(n.this.gnH);
            }
        }
    };
    private j.c gmw = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void Vo() {
            n.g(n.this);
        }
    };
    private j bBh = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.gnL;
        nVar.gnL = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.bBh.a(this.gmw);
        this.gnM = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String iT(String str) {
        this.gnP = com.baidu.tbadk.coreExtra.model.f.GE();
        this.gnQ = com.baidu.tbadk.coreExtra.model.f.GF();
        this.gnR = com.baidu.tbadk.coreExtra.model.f.GG();
        this.gnS = com.baidu.tbadk.coreExtra.model.f.GH();
        this.gnH = str;
        this.btt = this.gnI ? this.gnH : s.Q(str, this.gnP);
        if (this.gnM != null) {
            v.a("start_play", this.gnH, bnf(), (int) this.gnM.bnr(), this.gnM.getDuration());
        }
        this.gnJ = System.currentTimeMillis();
        return this.btt;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bmJ() {
        return !StringUtils.isNull(this.btt) && this.btt.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean bmK() {
        return this.gnP;
    }

    @Override // com.baidu.tieba.play.d
    public boolean bmL() {
        return this.gnQ;
    }

    @Override // com.baidu.tieba.play.d
    public int bmM() {
        return com.baidu.tbadk.coreExtra.model.f.GI() ? this.gnR : this.gnS;
    }

    @Override // com.baidu.tieba.play.d
    public String bmH() {
        return this.gnH;
    }

    @Override // com.baidu.tieba.play.d
    public void bmN() {
        if (this.gnP && this.gnQ && bmJ() && bnf()) {
            s.g(this.mContext, this.gnH, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cP(long j) {
        this.gnT = j;
        bne();
        if (this.gnJ > 0) {
            this.gnK = System.currentTimeMillis() - this.gnJ;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ao.isEmpty(n.this.gnH) && (parse = Uri.parse(n.this.gnH)) != null) {
                    try {
                        n.this.Hh = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.dxM += currentTimeMillis;
            cQ(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.bBh != null) {
            this.bBh.start();
        }
        this.gnO = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnV);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnU);
        bmP();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dxM += currentTimeMillis;
            cQ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bnb();
        if (this.bBh != null) {
            this.bBh.stop();
        }
        if (this.gnK > 0 && this.gnM != null) {
            am amVar = new am("c11685");
            amVar.al("service_ip", this.Hh);
            amVar.al(WebVideoActivityConfig.KEY_VIDEO_URL, this.gnH);
            amVar.g("video_size", this.gnM.bnr());
            amVar.w(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.gnM.getDuration());
            amVar.al("video_resolution", this.gnM.bns());
            amVar.w("loading_count", this.gnL);
            amVar.g("user_watch_time", this.dxM / 1000);
            amVar.g("start_play_time", this.gnK);
            TiebaStatic.log(amVar);
        }
        if (this.gnM != null && this.gnK > 0) {
            v.a("stop_play", this.gnH, bnf(), (int) this.gnM.bnr(), this.gnM.getDuration());
        }
        bna();
        this.gnK = 0L;
        this.dxM = 0L;
        this.gnL = 0;
        this.gnJ = 0L;
        this.mStartTime = 0L;
        this.gnO = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.gnN = bVar;
    }

    private void cQ(long j) {
        if (this.gnN != null) {
            this.gnN.setVideoWatchDuration(this.gnN.getVideoWatchDuration() + j);
        }
    }

    private void bna() {
        if (this.gnN != null && this.gnO) {
            TbSingleton.getInstance().putVideoRecord(this.gnN.getThreadId(), (int) (this.gnN.getVideoWatchDuration() / 1000));
        }
    }

    private void bnb() {
        if (this.dxM >= 0 && this.dxM < 86400000) {
            if (this.dxM > 0) {
                am amVar = new am("c11244");
                amVar.g("obj_duration", this.dxM);
                amVar.al("obj_type", this.gnG);
                amVar.g("playduration", this.gnT);
                if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.al("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.gnF != null) {
                    this.gnF.b(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.dxM, this.gnG, this.gnF, "", this.gnT);
            } else if (this.gnO) {
                l.a(this.dxM, this.gnG, this.gnF, "", this.gnT);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dxM += currentTimeMillis;
            cQ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bna();
        this.gnO = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.dxM += currentTimeMillis;
            cQ(currentTimeMillis);
            this.mStartTime = 0L;
        }
        bna();
    }

    @Override // com.baidu.tieba.play.d
    public boolean bmI() {
        return s.iU(this.gnH) != null;
    }

    public void bnc() {
        this.gnI = true;
    }

    public void sN(String str) {
        this.gnG = str;
    }

    @Override // com.baidu.tieba.play.d
    public j bmO() {
        return this.bBh;
    }

    public void a(j.b bVar) {
        if (this.bBh != null) {
            this.bBh.a(bVar);
        }
    }

    public u bnd() {
        return this.gnM;
    }

    public void bne() {
        if (!this.gnP) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnV);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.gnV, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void sd(int i) {
        if (bnf()) {
            s.g(this.mContext, this.gnH, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gnU);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.gnU, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void bmP() {
        if (bnf()) {
            s.as(this.mContext, this.gnH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bnf() {
        return (this.gnI || this.btt == null || this.btt.equals(this.gnH)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.gnF = yVar;
    }

    public y bng() {
        return this.gnF;
    }
}
