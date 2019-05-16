package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.play.j;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String FC;
    private String ald;
    private z ipR;
    private String ipT;
    private v ipY;
    private com.baidu.tieba.video.b ipZ;
    private boolean iqa;
    private long iqf;
    private Context mContext;
    private String ipS = "1";
    private boolean ipU = false;
    private long fuV = 0;
    private long ipV = 0;
    private long mStartTime = 0;
    private long ipW = 0;
    private int ipX = 0;
    private boolean iqb = false;
    private boolean iqc = false;
    private int iqd = 8;
    private int iqe = 16;
    private Runnable iqg = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.iqb && n.this.iqc && n.this.cba() && n.this.cby()) {
                t.f(n.this.mContext, n.this.ipT, -1);
            }
        }
    };
    private Runnable iqh = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cby()) {
                t.ar(n.this.mContext, n.this.ipT);
            } else if (!n.this.ipU) {
                t.rN(n.this.ipT);
            }
        }
    };
    private j.c ioL = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aHB() {
            n.g(n.this);
        }
    };
    private j dlM = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.ipX;
        nVar.ipX = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dlM.a(this.ioL);
        this.ipY = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String rL(String str) {
        this.iqb = com.baidu.tbadk.coreExtra.model.f.aoG();
        this.iqc = com.baidu.tbadk.coreExtra.model.f.aoH();
        this.iqd = com.baidu.tbadk.coreExtra.model.f.aoI();
        this.iqe = com.baidu.tbadk.coreExtra.model.f.aoJ();
        this.ipT = str;
        this.ald = this.ipU ? this.ipT : t.as(str, this.iqb);
        if (this.ipY != null) {
            w.a("start_play", this.ipT, cby(), (int) this.ipY.cbK(), this.ipY.getDuration());
        }
        this.ipV = System.currentTimeMillis();
        return this.ald;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cba() {
        return !StringUtils.isNull(this.ald) && this.ald.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbb() {
        return this.iqb;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbc() {
        return this.iqc;
    }

    @Override // com.baidu.tieba.play.d
    public int cbd() {
        return com.baidu.tbadk.coreExtra.model.f.aoK() ? this.iqd : this.iqe;
    }

    @Override // com.baidu.tieba.play.d
    public String caY() {
        return this.ipT;
    }

    @Override // com.baidu.tieba.play.d
    public void cbe() {
        if (this.iqb && this.iqc && cba() && cby()) {
            t.f(this.mContext, this.ipT, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void eg(long j) {
        this.iqf = j;
        cbx();
        if (this.ipV > 0) {
            this.ipW = System.currentTimeMillis() - this.ipV;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.ipT) && (parse = Uri.parse(n.this.ipT)) != null) {
                    try {
                        n.this.FC = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fuV += currentTimeMillis;
            eh(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dlM != null) {
            this.dlM.start();
        }
        this.iqa = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqh);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqg);
        cbg();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuV += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cbu();
        if (this.dlM != null) {
            this.dlM.stop();
        }
        if (this.ipW > 0 && this.ipY != null) {
            am amVar = new am("c11685");
            amVar.bT("service_ip", this.FC);
            amVar.bT(WebVideoActivityConfig.KEY_VIDEO_URL, this.ipT);
            amVar.l("video_size", this.ipY.cbK());
            amVar.P(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.ipY.getDuration());
            amVar.bT("video_resolution", this.ipY.cbL());
            amVar.P("loading_count", this.ipX);
            amVar.l("user_watch_time", this.fuV / 1000);
            amVar.l("start_play_time", this.ipW);
            TiebaStatic.log(amVar);
        }
        if (this.ipY != null && this.ipW > 0) {
            w.a("stop_play", this.ipT, cby(), (int) this.ipY.cbK(), this.ipY.getDuration());
        }
        cbt();
        this.ipW = 0L;
        this.fuV = 0L;
        this.ipX = 0;
        this.ipV = 0L;
        this.mStartTime = 0L;
        this.iqa = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.ipZ = bVar;
    }

    private void eh(long j) {
        if (this.ipZ != null) {
            this.ipZ.setVideoWatchDuration(this.ipZ.getVideoWatchDuration() + j);
        }
    }

    private void cbt() {
        if (this.ipZ != null && this.iqa) {
            TbSingleton.getInstance().putVideoRecord(this.ipZ.getThreadId(), (int) (this.ipZ.getVideoWatchDuration() / 1000));
        }
    }

    private void cbu() {
        if (this.fuV >= 0 && this.fuV < 86400000) {
            if (this.fuV > 0) {
                am amVar = new am("c11244");
                amVar.l("obj_duration", this.fuV);
                amVar.bT("obj_type", this.ipS);
                amVar.l("playduration", this.iqf);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bT("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ipR != null) {
                    this.ipR.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.fuV, this.ipS, this.ipR, "", this.iqf);
            } else if (this.iqa) {
                l.a(this.fuV, this.ipS, this.ipR, "", this.iqf);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuV += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cbt();
        this.iqa = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuV += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cbt();
    }

    @Override // com.baidu.tieba.play.d
    public boolean caZ() {
        return t.rM(this.ipT) != null;
    }

    public void cbv() {
        this.ipU = true;
    }

    public void Ci(String str) {
        this.ipS = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cbf() {
        return this.dlM;
    }

    public void a(j.b bVar) {
        if (this.dlM != null) {
            this.dlM.a(bVar);
        }
    }

    public v cbw() {
        return this.ipY;
    }

    public void cbx() {
        if (!this.iqb) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqh);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.iqh, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void yq(int i) {
        if (cby()) {
            t.f(this.mContext, this.ipT, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqg);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqg, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void cbg() {
        if (cby()) {
            t.as(this.mContext, this.ipT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cby() {
        return (this.ipU || this.ald == null || this.ald.equals(this.ipT)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.ipR = zVar;
    }

    public z cbz() {
        return this.ipR;
    }
}
