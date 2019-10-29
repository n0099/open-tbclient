package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.play.j;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private String aFy;
    private z ixS;
    private String ixU;
    private v ixZ;
    private com.baidu.tieba.video.b iya;
    private boolean iyb;
    private long iyg;
    private Context mContext;
    private String sT;
    private String ixT = "1";
    private boolean ixV = false;
    private long fBK = 0;
    private long ixW = 0;
    private long mStartTime = 0;
    private long ixX = 0;
    private int ixY = 0;
    private boolean iyc = false;
    private boolean iyd = false;
    private int iye = 8;
    private int iyf = 16;
    private Runnable iyh = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.iyc && n.this.iyd && n.this.ccc() && n.this.ccA()) {
                t.d(n.this.mContext, n.this.ixU, -1);
            }
        }
    };
    private Runnable iyi = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ccA()) {
                t.an(n.this.mContext, n.this.ixU);
            } else if (!n.this.ixV) {
                t.qZ(n.this.ixU);
            }
        }
    };
    private j.c iwL = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void aJi() {
            n.g(n.this);
        }
    };
    private j dwy = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.ixY;
        nVar.ixY = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.dwy.a(this.iwL);
        this.ixZ = new v();
    }

    @Override // com.baidu.tieba.play.d
    public String qX(String str) {
        this.iyc = com.baidu.tbadk.coreExtra.model.f.arU();
        this.iyd = com.baidu.tbadk.coreExtra.model.f.arV();
        this.iye = com.baidu.tbadk.coreExtra.model.f.arW();
        this.iyf = com.baidu.tbadk.coreExtra.model.f.arX();
        this.ixU = str;
        this.aFy = this.ixV ? this.ixU : t.ar(str, this.iyc);
        if (this.ixZ != null) {
            w.a("start_play", this.ixU, ccA(), (int) this.ixZ.ccL(), this.ixZ.getDuration());
        }
        this.ixW = System.currentTimeMillis();
        return this.aFy;
    }

    @Override // com.baidu.tieba.play.d
    public boolean ccc() {
        return !StringUtils.isNull(this.aFy) && this.aFy.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean ccd() {
        return this.iyc;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cce() {
        return this.iyd;
    }

    @Override // com.baidu.tieba.play.d
    public int ccf() {
        return com.baidu.tbadk.coreExtra.model.f.arY() ? this.iye : this.iyf;
    }

    @Override // com.baidu.tieba.play.d
    public String cca() {
        return this.ixU;
    }

    @Override // com.baidu.tieba.play.d
    public void ccg() {
        if (this.iyc && this.iyd && ccc() && ccA()) {
            t.d(this.mContext, this.ixU, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dO(long j) {
        this.iyg = j;
        ccz();
        if (this.ixW > 0) {
            this.ixX = System.currentTimeMillis() - this.ixW;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.ixU) && (parse = Uri.parse(n.this.ixU)) != null) {
                    try {
                        n.this.sT = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.fBK += currentTimeMillis;
            dP(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.dwy != null) {
            this.dwy.start();
        }
        this.iyb = true;
    }

    @Override // com.baidu.tieba.play.d
    public void onStop() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iyi);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iyh);
        cci();
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fBK += currentTimeMillis;
            dP(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ccw();
        if (this.dwy != null) {
            this.dwy.stop();
        }
        if (this.ixX > 0 && this.ixZ != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.bS("service_ip", this.sT);
            anVar.bS("video_url", this.ixU);
            anVar.p("video_size", this.ixZ.ccL());
            anVar.O("video_duration", this.ixZ.getDuration());
            anVar.bS("video_resolution", this.ixZ.ccM());
            anVar.O("loading_count", this.ixY);
            anVar.p("user_watch_time", this.fBK / 1000);
            anVar.p("start_play_time", this.ixX);
            TiebaStatic.log(anVar);
        }
        if (this.ixZ != null && this.ixX > 0) {
            w.a("stop_play", this.ixU, ccA(), (int) this.ixZ.ccL(), this.ixZ.getDuration());
        }
        ccv();
        this.ixX = 0L;
        this.fBK = 0L;
        this.ixY = 0;
        this.ixW = 0L;
        this.mStartTime = 0L;
        this.iyb = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.iya = bVar;
    }

    private void dP(long j) {
        if (this.iya != null) {
            this.iya.setVideoWatchDuration(this.iya.getVideoWatchDuration() + j);
        }
    }

    private void ccv() {
        if (this.iya != null && this.iyb) {
            TbSingleton.getInstance().putVideoRecord(this.iya.getThreadId(), (int) (this.iya.getVideoWatchDuration() / 1000));
        }
    }

    private void ccw() {
        if (this.fBK >= 0 && this.fBK < 86400000) {
            if (this.fBK > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.p("obj_duration", this.fBK);
                anVar.bS("obj_type", this.ixT);
                anVar.p("playduration", this.iyg);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bS("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ixS != null) {
                    this.ixS.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fBK, this.ixT, this.ixS, "", this.iyg);
            } else if (this.iyb) {
                l.a(this.fBK, this.ixT, this.ixS, "", this.iyg);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fBK += currentTimeMillis;
            dP(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ccv();
        this.iyb = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.fBK += currentTimeMillis;
            dP(currentTimeMillis);
            this.mStartTime = 0L;
        }
        ccv();
    }

    @Override // com.baidu.tieba.play.d
    public boolean ccb() {
        return t.qY(this.ixU) != null;
    }

    public void ccx() {
        this.ixV = true;
    }

    public void BQ(String str) {
        this.ixT = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cch() {
        return this.dwy;
    }

    public void a(j.b bVar) {
        if (this.dwy != null) {
            this.dwy.a(bVar);
        }
    }

    public v ccy() {
        return this.ixZ;
    }

    public void ccz() {
        if (!this.iyc) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iyi);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.iyi, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void xF(int i) {
        if (ccA()) {
            t.d(this.mContext, this.ixU, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iyh);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iyh, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void cci() {
        if (ccA()) {
            t.ao(this.mContext, this.ixU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ccA() {
        return (this.ixV || this.aFy == null || this.aFy.equals(this.ixU)) ? false : true;
    }

    public void setVideoStatsData(z zVar) {
        this.ixS = zVar;
    }

    public z ccB() {
        return this.ixS;
    }
}
