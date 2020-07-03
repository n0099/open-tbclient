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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.play.j;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class n implements d {
    private y kUg;
    private String kUi;
    private u kUn;
    private com.baidu.tieba.video.c kUo;
    private boolean kUp;
    private long kUv;
    private Context mContext;
    private String mHost;
    private String mVideoPath;
    private String kUh = "1";
    private boolean kUj = false;
    private long hGx = 0;
    private long kUk = 0;
    private long mStartTime = 0;
    private long kUl = 0;
    private int kUm = 0;
    public boolean kUq = false;
    private boolean kUr = false;
    private boolean kUs = false;
    private int kUt = 8;
    private int kUu = 16;
    private Runnable kUw = new Runnable() { // from class: com.baidu.tieba.play.n.2
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.kUr && n.this.kUs && n.this.cVc() && n.this.cVE()) {
                s.d(n.this.mContext, n.this.kUi, -1);
            }
        }
    };
    private Runnable kUx = new Runnable() { // from class: com.baidu.tieba.play.n.3
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.cVE()) {
                s.aq(n.this.mContext, n.this.kUi);
            } else if (!n.this.kUj) {
                s.zW(n.this.kUi);
            }
        }
    };
    private j.c kSR = new j.c() { // from class: com.baidu.tieba.play.n.4
        @Override // com.baidu.tieba.play.j.c
        public void btG() {
            n.g(n.this);
        }
    };
    private j fni = new j();

    static /* synthetic */ int g(n nVar) {
        int i = nVar.kUm;
        nVar.kUm = i + 1;
        return i;
    }

    public n(Context context) {
        this.mContext = context;
        this.fni.a(this.kSR);
        this.kUn = new u();
    }

    @Override // com.baidu.tieba.play.d
    public String zU(String str) {
        this.kUr = com.baidu.tbadk.coreExtra.model.f.bcU();
        this.kUs = com.baidu.tbadk.coreExtra.model.f.bcV();
        this.kUt = com.baidu.tbadk.coreExtra.model.f.bcW();
        this.kUu = com.baidu.tbadk.coreExtra.model.f.bcX();
        this.kUi = str;
        this.mVideoPath = this.kUj ? this.kUi : s.aR(str, this.kUr);
        if (this.kUn != null) {
            v.a("start_play", this.kUi, cVE(), (int) this.kUn.cVO(), this.kUn.getDuration());
        }
        this.kUk = System.currentTimeMillis();
        return this.mVideoPath;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cVc() {
        return !StringUtils.isNull(this.mVideoPath) && this.mVideoPath.contains("127.0.0.1");
    }

    @Override // com.baidu.tieba.play.d
    public boolean cVd() {
        return this.kUr;
    }

    @Override // com.baidu.tieba.play.d
    public boolean cVe() {
        return this.kUs;
    }

    @Override // com.baidu.tieba.play.d
    public int cVf() {
        return com.baidu.tbadk.coreExtra.model.f.bcY() ? this.kUt : this.kUu;
    }

    @Override // com.baidu.tieba.play.d
    public String cUZ() {
        return this.kUi;
    }

    @Override // com.baidu.tieba.play.d
    public void cVg() {
        if (this.kUr && this.kUs && cVc() && cVE()) {
            s.d(this.mContext, this.kUi, -1);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void fm(long j) {
        this.kUv = j;
        cVD();
        if (this.kUk > 0) {
            this.kUl = System.currentTimeMillis() - this.kUk;
        }
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.n.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                Uri parse;
                if (!ar.isEmpty(n.this.kUi) && (parse = Uri.parse(n.this.kUi)) != null) {
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
            this.hGx += currentTimeMillis;
            fn(currentTimeMillis);
        }
        this.mStartTime = System.currentTimeMillis();
        if (this.fni != null) {
            this.fni.start();
        }
        this.kUp = true;
    }

    @Override // com.baidu.tieba.play.d
    public void KX(String str) {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUx);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUw);
        zZ(str);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.hGx += currentTimeMillis;
            fn(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cVA();
        if (this.fni != null) {
            this.fni.stop();
        }
        if (this.kUl > 0 && this.kUn != null) {
            ao aoVar = new ao(CommonStatisticKey.VIDEO_PLAY_STATE);
            aoVar.dk("service_ip", this.mHost);
            aoVar.dk("video_url", this.kUi);
            aoVar.s("video_size", this.kUn.cVO());
            aoVar.ag("video_duration", this.kUn.getDuration());
            aoVar.dk("video_resolution", this.kUn.cVP());
            aoVar.ag("loading_count", this.kUm);
            aoVar.s("user_watch_time", this.hGx / 1000);
            aoVar.s("start_play_time", this.kUl);
            TiebaStatic.log(aoVar);
        }
        if (this.kUn != null && this.kUl > 0) {
            v.a("stop_play", this.kUi, cVE(), (int) this.kUn.cVO(), this.kUn.getDuration());
        }
        cVz();
        this.kUl = 0L;
        this.hGx = 0L;
        this.kUm = 0;
        this.kUk = 0L;
        this.mStartTime = 0L;
        this.kUp = false;
    }

    public void a(com.baidu.tieba.video.c cVar) {
        this.kUo = cVar;
    }

    private void fn(long j) {
        if (this.kUo != null) {
            this.kUo.setVideoWatchDuration(this.kUo.getVideoWatchDuration() + j);
        }
    }

    private void cVz() {
        if (this.kUo != null && this.kUp) {
            TbSingleton.getInstance().putVideoRecord(this.kUo.getThreadId(), (int) (this.kUo.getVideoWatchDuration() / 1000));
        }
    }

    private void cVA() {
        if (this.hGx >= 0 && this.hGx < 86400000) {
            if (this.hGx > 0) {
                ao aoVar = new ao(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aoVar.s("obj_duration", this.hGx);
                aoVar.dk("obj_type", this.kUh);
                aoVar.s("playduration", this.kUv);
                aoVar.ag("player_type", 0);
                if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aoVar.dk("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.kUg != null) {
                    this.kUg.f(aoVar);
                }
                com.baidu.tbadk.pageInfo.c.a(this.mContext, aoVar);
                if (!aoVar.wG("obj_param5") && this.kUn.aPS() != null) {
                    if (this.kUn.aPS().getBaijiahaoData() != null) {
                        if (this.kUn.aPS().getBaijiahaoData().oriUgcType == 2) {
                            aoVar.ag("obj_param5", 3);
                        } else if (this.kUn.aPS().getBaijiahaoData().oriUgcType == 4) {
                            aoVar.ag("obj_param5", 2);
                        }
                    } else {
                        aoVar.ag("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aoVar);
                l.a(this.hGx, this.kUh, this.kUg, "", this.kUv);
            } else if (this.kUp) {
                l.a(this.hGx, this.kUh, this.kUg, "", this.kUv);
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cVa() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUx);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUw);
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.hGx += currentTimeMillis;
            fn(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cVA();
        if (this.fni != null) {
            this.fni.stop();
        }
        if (this.kUl > 0 && this.kUn != null) {
            ao aoVar = new ao(CommonStatisticKey.VIDEO_PLAY_STATE);
            aoVar.dk("service_ip", this.mHost);
            aoVar.dk("video_url", this.kUi);
            aoVar.s("video_size", this.kUn.cVO());
            aoVar.ag("video_duration", this.kUn.getDuration());
            aoVar.dk("video_resolution", this.kUn.cVP());
            aoVar.ag("loading_count", this.kUm);
            aoVar.s("user_watch_time", this.hGx / 1000);
            aoVar.s("start_play_time", this.kUl);
            TiebaStatic.log(aoVar);
        }
        if (this.kUn != null && this.kUl > 0) {
            v.a("stop_play", this.kUi, cVE(), (int) this.kUn.cVO(), this.kUn.getDuration());
        }
        cVz();
        this.kUl = 0L;
        this.hGx = 0L;
        this.kUm = 0;
        this.kUk = 0L;
        this.mStartTime = 0L;
        this.kUp = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onPause() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.hGx += currentTimeMillis;
            fn(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cVz();
        this.kUp = false;
    }

    @Override // com.baidu.tieba.play.d
    public void onCompletion() {
        if (this.mStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.hGx += currentTimeMillis;
            fn(currentTimeMillis);
            this.mStartTime = 0L;
        }
        cVz();
    }

    @Override // com.baidu.tieba.play.d
    public boolean cVb() {
        return s.zV(this.kUi) != null;
    }

    public void cVB() {
        this.kUj = true;
    }

    public void La(String str) {
        this.kUh = str;
    }

    @Override // com.baidu.tieba.play.d
    public j cVh() {
        return this.fni;
    }

    public void a(j.b bVar) {
        if (this.fni != null) {
            this.fni.a(bVar);
        }
    }

    public u cVC() {
        return this.kUn;
    }

    public void cVD() {
        if (!this.kUr) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUx);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.kUx, 100L);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void CL(int i) {
        if (cVE()) {
            s.d(this.mContext, this.kUi, i);
        }
    }

    @Override // com.baidu.tieba.play.d
    public void onSeekComplete() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUw);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kUw, 1000L);
    }

    @Override // com.baidu.tieba.play.d
    public void zZ(String str) {
        if (cVE()) {
            s.ar(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVE() {
        return (this.kUj || this.mVideoPath == null || this.mVideoPath.equals(this.kUi)) ? false : true;
    }

    public void setVideoStatsData(y yVar) {
        this.kUg = yVar;
    }

    public y cVF() {
        return this.kUg;
    }
}
