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
    private z ipU;
    private String ipW;
    private v iqb;
    private com.baidu.tieba.video.b iqc;
    private boolean iqd;
    private long iqi;
    private Context mContext;
    private String ipV = "1";
    private boolean ipX = false;
    private long fuW = 0;
    private long ipY = 0;
    private long mStartTime = 0;
    private long ipZ = 0;
    private int iqa = 0;
    private boolean iqe = false;
    private boolean iqf = false;
    private int iqg = 8;
    private int iqh = 16;
    private Runnable iqj = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.iqe && n.this.iqf && n.this.cbd() && n.this.cbB()) {
                t.f(n.this.mContext, n.this.ipW, -1);
            }
        }
    };
    private Runnable iqk = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cbB()) {
                t.ar(n.this.mContext, n.this.ipW);
            } else if (!n.this.ipX) {
                t.rN(n.this.ipW);
            }
        }
    };
    private j.c ioO = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aHE() {
            n.g(n.this);
        }
    };
    private j dlN = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.iqa;
        nVar.iqa = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dlN.a(this.ioO);
        this.iqb = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String rL(String str) {
        this.iqe = com.baidu.tbadk.coreExtra.model.f.aoG();
        this.iqf = com.baidu.tbadk.coreExtra.model.f.aoH();
        this.iqg = com.baidu.tbadk.coreExtra.model.f.aoI();
        this.iqh = com.baidu.tbadk.coreExtra.model.f.aoJ();
        this.ipW = str;
        this.ald = this.ipX ? this.ipW : t.as(str, this.iqe);
        if (this.iqb != null) {
            w.a("start_play", this.ipW, cbB(), (int) this.iqb.cbN(), this.iqb.getDuration());
        }
        this.ipY = System.currentTimeMillis();
        return this.ald;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbd() {
        return !StringUtils.isNull(this.ald) && this.ald.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbe() {
        return this.iqe;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbf() {
        return this.iqf;
    }

    @Override // com.baidu.tieba.play.d
    public int cbg() {
        return com.baidu.tbadk.coreExtra.model.f.aoK() ? this.iqg : this.iqh;
    }

    @Override // com.baidu.tieba.play.d
    public String cbb() {
        return this.ipW;
    }

    @Override // com.baidu.tieba.play.d
    public void cbh() {
        if (this.iqe && this.iqf && cbd() && cbB()) {
            t.f(this.mContext, this.ipW, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void eg(long j) {
        this.iqi = j;
        cbA();
        if (this.ipY > 0) {
            this.ipZ = System.currentTimeMillis() - this.ipY;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.ipW) && (parse = Uri.parse(n.this.ipW)) != null) {
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
            this.fuW += currentTimeMillis;
            eh(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dlN != null) {
            this.dlN.start();
        }
        this.iqd = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqk);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqj);
        cbj();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuW += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cbx();
        if (this.dlN != null) {
            this.dlN.stop();
        }
        if (this.ipZ > 0 && this.iqb != null) {
            am amVar = new am("c11685");
            amVar.bT("service_ip", this.FC);
            amVar.bT(WebVideoActivityConfig.KEY_VIDEO_URL, this.ipW);
            amVar.l("video_size", this.iqb.cbN());
            amVar.P(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.iqb.getDuration());
            amVar.bT("video_resolution", this.iqb.cbO());
            amVar.P("loading_count", this.iqa);
            amVar.l("user_watch_time", this.fuW / 1000);
            amVar.l("start_play_time", this.ipZ);
            TiebaStatic.log(amVar);
        }
        if (this.iqb != null && this.ipZ > 0) {
            w.a("stop_play", this.ipW, cbB(), (int) this.iqb.cbN(), this.iqb.getDuration());
        }
        cbw();
        this.ipZ = 0L;
        this.fuW = 0L;
        this.iqa = 0;
        this.ipY = 0L;
        this.mStartTime = 0L;
        this.iqd = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.iqc = bVar;
    }

    private void eh(long j) {
        if (this.iqc != null) {
            this.iqc.setVideoWatchDuration(this.iqc.getVideoWatchDuration() + j);
        }
    }

    private void cbw() {
        if (this.iqc != null && this.iqd) {
            TbSingleton.getInstance().putVideoRecord(this.iqc.getThreadId(), (int) (this.iqc.getVideoWatchDuration() / 1000));
        }
    }

    private void cbx() {
        if (this.fuW >= 0 && this.fuW < 86400000) {
            if (this.fuW > 0) {
                am amVar = new am("c11244");
                amVar.l("obj_duration", this.fuW);
                amVar.bT("obj_type", this.ipV);
                amVar.l("playduration", this.iqi);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bT("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ipU != null) {
                    this.ipU.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.fuW, this.ipV, this.ipU, "", this.iqi);
            } else if (this.iqd) {
                l.a(this.fuW, this.ipV, this.ipU, "", this.iqi);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuW += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cbw();
        this.iqd = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuW += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cbw();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbc() {
        return t.rM(this.ipW) != null;
    }

    public void cby() {
        this.ipX = true;
    }

    public void Ci(String str) {
        this.ipV = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cbi() {
        return this.dlN;
    }

    public void a(j.b bVar) {
        if (this.dlN != null) {
            this.dlN.a(bVar);
        }
    }

    public v cbz() {
        return this.iqb;
    }

    public void cbA() {
        if (!this.iqe) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqk);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.iqk, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void yq(int i) {
        if (cbB()) {
            t.f(this.mContext, this.ipW, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqj);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqj, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void cbj() {
        if (cbB()) {
            t.as(this.mContext, this.ipW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbB() {
        return (this.ipX || this.ald == null || this.ald.equals(this.ipW)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.ipU = zVar;
    }

    public z cbC() {
        return this.ipU;
    }
}
