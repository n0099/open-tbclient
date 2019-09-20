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
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String FI;
    private String amf;
    private long izE;
    private z izq;
    private String izs;
    private v izx;
    private com.baidu.tieba.video.b izy;
    private boolean izz;
    private Context mContext;
    private String izr = "1";
    private boolean izt = false;
    private long fCt = 0;
    private long izu = 0;
    private long mStartTime = 0;
    private long izv = 0;
    private int izw = 0;
    private boolean izA = false;
    private boolean izB = false;
    private int izC = 8;
    private int izD = 16;
    private Runnable izF = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.izA && n.this.izB && n.this.cfa() && n.this.cfy()) {
                t.f(n.this.mContext, n.this.izs, -1);
            }
        }
    };
    private Runnable izG = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cfy()) {
                t.aq(n.this.mContext, n.this.izs);
            } else if (!n.this.izt) {
                t.sp(n.this.izs);
            }
        }
    };
    private j.c iyj = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aJH() {
            n.g(n.this);
        }
    };
    private j dpo = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.izw;
        nVar.izw = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dpo.a(this.iyj);
        this.izx = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String sn(String str) {
        this.izA = com.baidu.tbadk.coreExtra.model.f.aqa();
        this.izB = com.baidu.tbadk.coreExtra.model.f.aqb();
        this.izC = com.baidu.tbadk.coreExtra.model.f.aqc();
        this.izD = com.baidu.tbadk.coreExtra.model.f.aqd();
        this.izs = str;
        this.amf = this.izt ? this.izs : t.aw(str, this.izA);
        if (this.izx != null) {
            w.a("start_play", this.izs, cfy(), (int) this.izx.cfK(), this.izx.getDuration());
        }
        this.izu = System.currentTimeMillis();
        return this.amf;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cfa() {
        return !StringUtils.isNull(this.amf) && this.amf.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cfb() {
        return this.izA;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cfc() {
        return this.izB;
    }

    @Override // com.baidu.tieba.play.d
    public int cfd() {
        return com.baidu.tbadk.coreExtra.model.f.aqe() ? this.izC : this.izD;
    }

    @Override // com.baidu.tieba.play.d
    public String ceY() {
        return this.izs;
    }

    @Override // com.baidu.tieba.play.d
    public void cfe() {
        if (this.izA && this.izB && cfa() && cfy()) {
            t.f(this.mContext, this.izs, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void et(long j) {
        this.izE = j;
        cfx();
        if (this.izu > 0) {
            this.izv = System.currentTimeMillis() - this.izu;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.izs) && (parse = Uri.parse(n.this.izs)) != null) {
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
            this.fCt += currentTimeMillis;
            eu(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dpo != null) {
            this.dpo.start();
        }
        this.izz = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izG);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izF);
        cfg();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fCt += currentTimeMillis;
            eu(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cfu();
        if (this.dpo != null) {
            this.dpo.stop();
        }
        if (this.izv > 0 && this.izx != null) {
            an anVar = new an("c11685");
            anVar.bT("service_ip", this.FI);
            anVar.bT("video_url", this.izs);
            anVar.n("video_size", this.izx.cfK());
            anVar.P("video_duration", this.izx.getDuration());
            anVar.bT("video_resolution", this.izx.cfL());
            anVar.P("loading_count", this.izw);
            anVar.n("user_watch_time", this.fCt / 1000);
            anVar.n("start_play_time", this.izv);
            TiebaStatic.log(anVar);
        }
        if (this.izx != null && this.izv > 0) {
            w.a("stop_play", this.izs, cfy(), (int) this.izx.cfK(), this.izx.getDuration());
        }
        cft();
        this.izv = 0L;
        this.fCt = 0L;
        this.izw = 0;
        this.izu = 0L;
        this.mStartTime = 0L;
        this.izz = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.izy = bVar;
    }

    private void eu(long j) {
        if (this.izy != null) {
            this.izy.setVideoWatchDuration(this.izy.getVideoWatchDuration() + j);
        }
    }

    private void cft() {
        if (this.izy != null && this.izz) {
            TbSingleton.getInstance().putVideoRecord(this.izy.getThreadId(), (int) (this.izy.getVideoWatchDuration() / 1000));
        }
    }

    private void cfu() {
        if (this.fCt >= 0 && this.fCt < 86400000) {
            if (this.fCt > 0) {
                an anVar = new an("c11244");
                anVar.n("obj_duration", this.fCt);
                anVar.bT("obj_type", this.izr);
                anVar.n("playduration", this.izE);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bT("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.izq != null) {
                    this.izq.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fCt, this.izr, this.izq, "", this.izE);
            } else if (this.izz) {
                l.a(this.fCt, this.izr, this.izq, "", this.izE);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fCt += currentTimeMillis;
            eu(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cft();
        this.izz = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fCt += currentTimeMillis;
            eu(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cft();
    }

    @Override // com.baidu.tieba.play.d
    public boolean ceZ() {
        return t.so(this.izs) != null;
    }

    public void cfv() {
        this.izt = true;
    }

    public void Dx(String str) {
        this.izr = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cff() {
        return this.dpo;
    }

    public void a(j.b bVar) {
        if (this.dpo != null) {
            this.dpo.a(bVar);
        }
    }

    public v cfw() {
        return this.izx;
    }

    public void cfx() {
        if (!this.izA) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izG);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.izG, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void za(int i) {
        if (cfy()) {
            t.f(this.mContext, this.izs, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izF);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.izF, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void cfg() {
        if (cfy()) {
            t.ar(this.mContext, this.izs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfy() {
        return (this.izt || this.amf == null || this.amf.equals(this.izs)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.izq = zVar;
    }

    public z cfz() {
        return this.izq;
    }
}
