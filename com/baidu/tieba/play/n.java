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
    private y kzd;
    private String kzf;
    private u kzk;
    private com.baidu.tieba.video.b kzl;
    private boolean kzm;
    private long kzs;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String kze = "1";
    private boolean kzg = false;
    private long htw = 0;
    private long kzh = 0;
    private long mStartTime = 0;
    private long kzi = 0;
    private int kzj = 0;
    public boolean kzn = false;
    private boolean kzo = false;
    private boolean kzp = false;
    private int kzq = 8;
    private int kzr = 16;
    private Runnable kzt = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.kzo && n.this.kzp && n.this.cQv() && n.this.cQX()) {
                s.d(n.this.mContext, n.this.kzf, -1);
            }
        }
    };
    private Runnable kzu = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cQX()) {
                s.aq(n.this.mContext, n.this.kzf);
            } else if (!n.this.kzg) {
                s.zD(n.this.kzf);
            }
        }
    };
    private j.c kxO = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void bqH() {
            n.g(n.this);
        }
    };
    private j fbN = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.kzj;
        nVar.kzj = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.fbN.a(this.kxO);
        this.kzk = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String zB(String str) {
        this.kzo = com.baidu.tbadk.coreExtra.model.f.baR();
        this.kzp = com.baidu.tbadk.coreExtra.model.f.baS();
        this.kzq = com.baidu.tbadk.coreExtra.model.f.baT();
        this.kzr = com.baidu.tbadk.coreExtra.model.f.baU();
        this.kzf = str;
        this.mVideoPath = this.kzg ? this.kzf : s.aP(str, this.kzo);
        if (this.kzk != null) {
            v.a("start_play", this.kzf, cQX(), (int) this.kzk.cRh(), this.kzk.getDuration());
        }
        this.kzh = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQv() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQw() {
        return this.kzo;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQx() {
        return this.kzp;
    }

    @Override // com.baidu.tieba.play.d
    public int cQy() {
        return com.baidu.tbadk.coreExtra.model.f.baV() ? this.kzq : this.kzr;
    }

    @Override // com.baidu.tieba.play.d
    public String cQs() {
        return this.kzf;
    }

    @Override // com.baidu.tieba.play.d
    public void cQz() {
        if (this.kzo && this.kzp && cQv() && cQX()) {
            s.d(this.mContext, this.kzf, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void fj(long j) {
        this.kzs = j;
        cQW();
        if (this.kzh > 0) {
            this.kzi = System.currentTimeMillis() - this.kzh;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!aq.isEmpty(n.this.kzf) && (parse = Uri.parse(n.this.kzf)) != null) {
                    try {
                        n.this.mHost = InetAddress.getByName(parse.getHost()).getHostAddress();
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
            this.htw += currentTimeMillis;
            fk(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.fbN != null) {
            this.fbN.start();
        }
        this.kzm = true;
    }

    @Override // com.baidu.tieba.play.d
    public void Kv(String str) {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzu);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzt);
        zG(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htw += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cQT();
        if (this.fbN != null) {
            this.fbN.stop();
        }
        if (this.kzi > 0 && this.kzk != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.dh("service_ip", this.mHost);
            anVar.dh("video_url", this.kzf);
            anVar.s("video_size", this.kzk.cRh());
            anVar.ag("video_duration", this.kzk.getDuration());
            anVar.dh("video_resolution", this.kzk.cRi());
            anVar.ag("loading_count", this.kzj);
            anVar.s("user_watch_time", this.htw / 1000);
            anVar.s("start_play_time", this.kzi);
            TiebaStatic.log(anVar);
        }
        if (this.kzk != null && this.kzi > 0) {
            v.a("stop_play", this.kzf, cQX(), (int) this.kzk.cRh(), this.kzk.getDuration());
        }
        cQS();
        this.kzi = 0L;
        this.htw = 0L;
        this.kzj = 0;
        this.kzh = 0L;
        this.mStartTime = 0L;
        this.kzm = false;
    }

    public void a(com.baidu.tieba.video.b bVar) {
        this.kzl = bVar;
    }

    private void fk(long j) {
        if (this.kzl != null) {
            this.kzl.setVideoWatchDuration(this.kzl.getVideoWatchDuration() + j);
        }
    }

    private void cQS() {
        if (this.kzl != null && this.kzm) {
            TbSingleton.getInstance().putVideoRecord(this.kzl.getThreadId(), (int) (this.kzl.getVideoWatchDuration() / 1000));
        }
    }

    private void cQT() {
        if (this.htw >= 0 && this.htw < 86400000) {
            if (this.htw > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.htw);
                anVar.dh("obj_type", this.kze);
                anVar.s("playduration", this.kzs);
                anVar.ag("player_type", 0);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.dh("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.kzd != null) {
                    this.kzd.f(anVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, anVar);
                if (!anVar.wq("obj_param5") && this.kzk.aOi() != null) {
                    if (this.kzk.aOi().getBaijiahaoData() != null) {
                        if (this.kzk.aOi().getBaijiahaoData().oriUgcType == 2) {
                            anVar.ag("obj_param5", 3);
                        } else if (this.kzk.aOi().getBaijiahaoData().oriUgcType == 4) {
                            anVar.ag("obj_param5", 2);
                        }
                    } else {
                        anVar.ag("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.htw, this.kze, this.kzd, "", this.kzs);
            } else if (this.kzm) {
                l.a(this.htw, this.kze, this.kzd, "", this.kzs);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cQt() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzu);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzt);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htw += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cQT();
        if (this.fbN != null) {
            this.fbN.stop();
        }
        if (this.kzi > 0 && this.kzk != null) {
            an anVar = new an(CommonStatisticKey.VIDEO_PLAY_STATE);
            anVar.dh("service_ip", this.mHost);
            anVar.dh("video_url", this.kzf);
            anVar.s("video_size", this.kzk.cRh());
            anVar.ag("video_duration", this.kzk.getDuration());
            anVar.dh("video_resolution", this.kzk.cRi());
            anVar.ag("loading_count", this.kzj);
            anVar.s("user_watch_time", this.htw / 1000);
            anVar.s("start_play_time", this.kzi);
            TiebaStatic.log(anVar);
        }
        if (this.kzk != null && this.kzi > 0) {
            v.a("stop_play", this.kzf, cQX(), (int) this.kzk.cRh(), this.kzk.getDuration());
        }
        cQS();
        this.kzi = 0L;
        this.htw = 0L;
        this.kzj = 0;
        this.kzh = 0L;
        this.mStartTime = 0L;
        this.kzm = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htw += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cQS();
        this.kzm = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.htw += currentTimeMillis;
            fk(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cQS();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cQu() {
        return s.zC(this.kzf) != null;
    }

    public void cQU() {
        this.kzg = true;
    }

    public void Ky(String str) {
        this.kze = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cQA() {
        return this.fbN;
    }

    public void a(j.b bVar) {
        if (this.fbN != null) {
            this.fbN.a(bVar);
        }
    }

    public u cQV() {
        return this.kzk;
    }

    public void cQW() {
        if (!this.kzo) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzu);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kzu, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void BH(int i) {
        if (cQX()) {
            s.d(this.mContext, this.kzf, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzt);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kzt, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void zG(String str) {
        if (cQX()) {
            s.ar(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQX() {
        return (this.kzg || this.mVideoPath == null || this.mVideoPath.equals(this.kzf)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.kzd = yVar;
    }

    public y cQY() {
        return this.kzd;
    }
}
