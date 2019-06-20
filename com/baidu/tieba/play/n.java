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
    private String FB;
    private String ald;
    private z ipV;
    private String ipX;
    private v iqc;
    private com.baidu.tieba.video.b iqd;
    private boolean iqe;
    private long iqj;
    private Context mContext;
    private String ipW = "1";
    private boolean ipY = false;
    private long fuW = 0;
    private long ipZ = 0;
    private long mStartTime = 0;
    private long iqa = 0;
    private int iqb = 0;
    private boolean iqf = false;
    private boolean iqg = false;
    private int iqh = 8;
    private int iqi = 16;
    private Runnable iqk = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.iqf && n.this.iqg && n.this.cbe() && n.this.cbC()) {
                t.f(n.this.mContext, n.this.ipX, -1);
            }
        }
    };
    private Runnable iql = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cbC()) {
                t.ar(n.this.mContext, n.this.ipX);
            } else if (!n.this.ipY) {
                t.rM(n.this.ipX);
            }
        }
    };
    private j.c ioP = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aHE() {
            n.g(n.this);
        }
    };
    private j dlN = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.iqb;
        nVar.iqb = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dlN.a(this.ioP);
        this.iqc = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String rK(String str) {
        this.iqf = com.baidu.tbadk.coreExtra.model.f.aoG();
        this.iqg = com.baidu.tbadk.coreExtra.model.f.aoH();
        this.iqh = com.baidu.tbadk.coreExtra.model.f.aoI();
        this.iqi = com.baidu.tbadk.coreExtra.model.f.aoJ();
        this.ipX = str;
        this.ald = this.ipY ? this.ipX : t.as(str, this.iqf);
        if (this.iqc != null) {
            w.a("start_play", this.ipX, cbC(), (int) this.iqc.cbO(), this.iqc.getDuration());
        }
        this.ipZ = System.currentTimeMillis();
        return this.ald;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbe() {
        return !StringUtils.isNull(this.ald) && this.ald.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbf() {
        return this.iqf;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbg() {
        return this.iqg;
    }

    @Override // com.baidu.tieba.play.d
    public int cbh() {
        return com.baidu.tbadk.coreExtra.model.f.aoK() ? this.iqh : this.iqi;
    }

    @Override // com.baidu.tieba.play.d
    public String cbc() {
        return this.ipX;
    }

    @Override // com.baidu.tieba.play.d
    public void cbi() {
        if (this.iqf && this.iqg && cbe() && cbC()) {
            t.f(this.mContext, this.ipX, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void eg(long j) {
        this.iqj = j;
        cbB();
        if (this.ipZ > 0) {
            this.iqa = System.currentTimeMillis() - this.ipZ;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ap.isEmpty(n.this.ipX) && (parse = Uri.parse(n.this.ipX)) != null) {
                    try {
                        n.this.FB = InetAddress.getByName(parse.getHost()).getHostAddress();
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
        this.iqe = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iql);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqk);
        cbk();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuW += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cby();
        if (this.dlN != null) {
            this.dlN.stop();
        }
        if (this.iqa > 0 && this.iqc != null) {
            am amVar = new am("c11685");
            amVar.bT("service_ip", this.FB);
            amVar.bT(WebVideoActivityConfig.KEY_VIDEO_URL, this.ipX);
            amVar.l("video_size", this.iqc.cbO());
            amVar.P(WebVideoActivityConfig.KEY_VIDEO_DURATION, this.iqc.getDuration());
            amVar.bT("video_resolution", this.iqc.cbP());
            amVar.P("loading_count", this.iqb);
            amVar.l("user_watch_time", this.fuW / 1000);
            amVar.l("start_play_time", this.iqa);
            TiebaStatic.log(amVar);
        }
        if (this.iqc != null && this.iqa > 0) {
            w.a("stop_play", this.ipX, cbC(), (int) this.iqc.cbO(), this.iqc.getDuration());
        }
        cbx();
        this.iqa = 0L;
        this.fuW = 0L;
        this.iqb = 0;
        this.ipZ = 0L;
        this.mStartTime = 0L;
        this.iqe = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.iqd = bVar;
    }

    private void eh(long j) {
        if (this.iqd != null) {
            this.iqd.setVideoWatchDuration(this.iqd.getVideoWatchDuration() + j);
        }
    }

    private void cbx() {
        if (this.iqd != null && this.iqe) {
            TbSingleton.getInstance().putVideoRecord(this.iqd.getThreadId(), (int) (this.iqd.getVideoWatchDuration() / 1000));
        }
    }

    private void cby() {
        if (this.fuW >= 0 && this.fuW < 86400000) {
            if (this.fuW > 0) {
                am amVar = new am("c11244");
                amVar.l("obj_duration", this.fuW);
                amVar.bT("obj_type", this.ipW);
                amVar.l("playduration", this.iqj);
                if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    amVar.bT("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ipV != null) {
                    this.ipV.c(amVar);
                }
                TiebaStatic.log(amVar);
                l.a(this.fuW, this.ipW, this.ipV, "", this.iqj);
            } else if (this.iqe) {
                l.a(this.fuW, this.ipW, this.ipV, "", this.iqj);
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
        cbx();
        this.iqe = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fuW += currentTimeMillis;
            eh(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cbx();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cbd() {
        return t.rL(this.ipX) != null;
    }

    public void cbz() {
        this.ipY = true;
    }

    public void Ck(String str) {
        this.ipW = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cbj() {
        return this.dlN;
    }

    public void a(j.b bVar) {
        if (this.dlN != null) {
            this.dlN.a(bVar);
        }
    }

    public v cbA() {
        return this.iqc;
    }

    public void cbB() {
        if (!this.iqf) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iql);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.iql, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void yq(int i) {
        if (cbC()) {
            t.f(this.mContext, this.ipX, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqk);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqk, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void cbk() {
        if (cbC()) {
            t.as(this.mContext, this.ipX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbC() {
        return (this.ipY || this.ald == null || this.ald.equals(this.ipX)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.ipV = zVar;
    }

    public z cbD() {
        return this.ipV;
    }
}
