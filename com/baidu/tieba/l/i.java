package com.baidu.tieba.l;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.VideoPlatformStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i implements h {
    private String anD;
    private int cvb;
    private int ePs;
    private String lqY;
    private int lqZ;
    private long lrf;
    private long lrg;
    private long lrh;
    private boolean lrj;
    private boolean lrn;
    private String lro;
    private List<b> lrp;
    private int lrq;
    private long lrr;
    private long lrs;
    private long lrt;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean lrk = true;
    private boolean lrl = false;
    private boolean lrm = false;
    private boolean lru = false;
    private boolean lrv = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> lrb = new HashMap();
    private List<com.baidu.tieba.n.b> lra = new ArrayList();
    private long lrc = 0;
    private long lrd = 0;
    private long lre = 0;
    private ArrayList<Integer> lri = new ArrayList<>();

    public i(String str, String str2, String str3) {
        this.cvb = 0;
        this.cvb = 0;
        this.anD = str;
        this.mVideoUrl = str2;
        this.lqY = str3;
        diL();
    }

    @Override // com.baidu.tieba.l.h
    public void diD() {
        this.lrc = System.currentTimeMillis();
        this.lra.add(new com.baidu.tieba.n.a(3));
        this.cvb = 0;
    }

    @Override // com.baidu.tieba.l.h
    public void tR(boolean z) {
        this.lrj = z;
        this.lra.add(new com.baidu.tieba.n.a(1));
        this.cvb = 1;
    }

    @Override // com.baidu.tieba.l.h
    public void ao(boolean z, boolean z2) {
        this.lru = z;
        this.lrv = z2;
    }

    @Override // com.baidu.tieba.l.h
    public void FX(int i) {
        if (this.cvb != 4 && this.cvb != 5 && this.cvb != 7 && this.cvb != 8) {
            this.lqZ = i;
            this.lrk = true;
            long currentTimeMillis = System.currentTimeMillis() - this.lrc;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.lrb.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.lrc = 0L;
            this.lra.add(new com.baidu.tieba.n.a(102));
            this.cvb = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void FY(int i) {
        if (this.cvb != 4 && this.cvb != 5 && this.cvb != 7 && this.cvb != 8) {
            this.lqZ = i;
            this.lrk = true;
            this.lrl = true;
            this.lrb.put("loadingTime", 1L);
            this.lrc = 0L;
            this.lra.add(new com.baidu.tieba.n.a(103));
            this.cvb = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void FZ(int i) {
        if (this.cvb == 5) {
            diF();
        } else if (this.cvb == 3) {
            this.lqZ = i;
            this.lrd = System.currentTimeMillis();
            this.lra.add(new com.baidu.tieba.n.a(200));
            this.cvb = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void H(long j, int i) {
        this.lrf++;
        this.lrg += j;
        this.lri.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.h
    public void diE() {
        if (this.cvb == 4 || this.cvb == 3) {
            if (this.lrd != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.lre = (currentTimeMillis - this.lrd) + this.lre;
                this.lrd = 0L;
            }
            this.lra.add(new com.baidu.tieba.n.a(203));
            this.cvb = 5;
        }
    }

    public void diF() {
        if (this.cvb == 5) {
            this.lrd = System.currentTimeMillis();
            this.lra.add(new com.baidu.tieba.n.a(204));
            this.cvb = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void OX(String str) {
        if (this.cvb != 8 && this.cvb != 7 && this.cvb != 6 && this.cvb != -1) {
            this.mSource = VideoPlatformStatic.Fi(str);
            diG();
            this.lra.add(new com.baidu.tieba.n.a(205));
            this.cvb = 8;
            axK();
        }
    }

    @Override // com.baidu.tieba.l.h
    public String OY(String str) {
        if (this.cvb == 8 || this.cvb == 7 || this.cvb == 6 || this.cvb == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Fi(str);
        diG();
        this.lrb.put("stallDuration", Long.valueOf(this.lrg));
        this.lra.add(new com.baidu.tieba.n.a(206));
        this.cvb = 6;
        axK();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public boolean OZ(String str) {
        if (this.cvb == 8 || this.cvb == 7 || this.cvb == 6 || this.cvb == -1 || this.cvb == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Fi(str);
        diG();
        this.lra.add(new com.baidu.tieba.n.a(207));
        this.cvb = 7;
        axK();
        return true;
    }

    private void diG() {
        if (this.lrd != 0) {
            this.lre += System.currentTimeMillis() - this.lrd;
        }
        this.lrb.put("playDuration", Long.valueOf(this.lre));
        this.lrb.put("stallCount", Long.valueOf(this.lrf));
        this.lrb.put("stallDuration", Long.valueOf(this.lrg));
        if (!this.lrb.containsKey("loadingTime")) {
            this.lrb.put("loadingTime", 0L);
        }
        this.lrc = 0L;
        this.lrd = 0L;
        this.lre = 0L;
        this.lrf = 0L;
        this.lrg = 0L;
        this.lrh = 0L;
    }

    public void axK() {
        if (!this.lrn) {
            int bCy = com.baidu.tbadk.coreExtra.model.g.bCy();
            if ((com.baidu.tbadk.coreExtra.model.g.bCx() || !this.lrk) && bCy != 3) {
                this.lrn = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.i.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int bCy2 = com.baidu.tbadk.coreExtra.model.g.bCy();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", i.this.bOj());
                            jSONObject.put("kpiInfo", i.this.diH());
                            if (bCy2 == 0 || (bCy2 == 4 && i.this.lrk)) {
                                JSONObject diJ = i.this.diJ();
                                diJ.put("running", i.this.diK());
                                jSONObject.put("debugInfo", diJ);
                            } else if (bCy2 == 2) {
                                jSONObject.put("debugInfo", i.this.diJ());
                            } else if (bCy2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dTg().i(jSONObject, i.this.lrk ? false : true);
                        if (i.this.lrp != null) {
                            i.this.lrp.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bOj() {
        JSONObject bOj = VideoPlatformStatic.bOj();
        if (this.lrp != null) {
            try {
                int size = this.lrp.size();
                for (int i = 0; i < size; i++) {
                    this.lrp.get(i).eB(bOj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bOj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject diH() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.lrb.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.lrb.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.lrb.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.lrb.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.lrb.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.lrj ? 1 : 0);
            jSONObject.put("playSuccess", this.lrk ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", diI());
            jSONObject.put("retryError", this.lrm ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.lrp != null) {
                int size = this.lrp.size();
                for (int i = 0; i < size; i++) {
                    this.lrp.get(i).eC(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject diI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.lrr);
            jSONObject.put("startTime", this.lrs);
            jSONObject.put("totalTime", this.lrt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        diL();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject diJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.lqY)) {
                jSONObject.put("parentUuid", this.lqY);
            }
            jSONObject.put("tid", this.anD);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.uv(this.lqZ));
            jSONObject.put("urlType", this.ePs);
            jSONObject.put("sub_error", this.lrq);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.lrl ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.lri);
            jSONObject.put("pcdn_used", this.lru ? "1" : "0");
            jSONObject.put("p2p_used", this.lrv ? "1" : "0");
            if (!StringUtils.isNull(this.lro)) {
                jSONObject.put("error_stack", this.lro);
            }
            if (this.lrp != null) {
                int size = this.lrp.size();
                for (int i = 0; i < size; i++) {
                    this.lrp.get(i).eD(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray diK() {
        JSONArray jSONArray = new JSONArray();
        if (this.lra == null) {
            return jSONArray;
        }
        int size = this.lra.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.lra.get(i).dCB());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.h
    public void h(long j, long j2, long j3) {
        this.lrr = j;
        this.lrs = j2;
        this.lrt = j3;
    }

    private void diL() {
        this.lrr = 0L;
        this.lrs = 0L;
        this.lrt = 0L;
    }
}
