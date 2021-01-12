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
/* loaded from: classes7.dex */
public class i implements h {
    private String amM;
    private int cqj;
    private int eKH;
    private boolean lmD;
    private String lmE;
    private List<b> lmF;
    private int lmG;
    private long lmH;
    private long lmI;
    private long lmJ;
    private String lmo;
    private int lmp;
    private long lmv;
    private long lmw;
    private long lmx;
    private boolean lmz;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean lmA = true;
    private boolean lmB = false;
    private boolean lmC = false;
    private boolean lmK = false;
    private boolean lmL = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> lmr = new HashMap();
    private List<com.baidu.tieba.n.b> lmq = new ArrayList();
    private long lms = 0;
    private long lmt = 0;
    private long lmu = 0;
    private ArrayList<Integer> lmy = new ArrayList<>();

    public i(String str, String str2, String str3) {
        this.cqj = 0;
        this.cqj = 0;
        this.amM = str;
        this.mVideoUrl = str2;
        this.lmo = str3;
        deT();
    }

    @Override // com.baidu.tieba.l.h
    public void deL() {
        this.lms = System.currentTimeMillis();
        this.lmq.add(new com.baidu.tieba.n.a(3));
        this.cqj = 0;
    }

    @Override // com.baidu.tieba.l.h
    public void tN(boolean z) {
        this.lmz = z;
        this.lmq.add(new com.baidu.tieba.n.a(1));
        this.cqj = 1;
    }

    @Override // com.baidu.tieba.l.h
    public void ao(boolean z, boolean z2) {
        this.lmK = z;
        this.lmL = z2;
    }

    @Override // com.baidu.tieba.l.h
    public void Er(int i) {
        if (this.cqj != 4 && this.cqj != 5 && this.cqj != 7 && this.cqj != 8) {
            this.lmp = i;
            this.lmA = true;
            long currentTimeMillis = System.currentTimeMillis() - this.lms;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.lmr.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.lms = 0L;
            this.lmq.add(new com.baidu.tieba.n.a(102));
            this.cqj = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void Es(int i) {
        if (this.cqj != 4 && this.cqj != 5 && this.cqj != 7 && this.cqj != 8) {
            this.lmp = i;
            this.lmA = true;
            this.lmB = true;
            this.lmr.put("loadingTime", 1L);
            this.lms = 0L;
            this.lmq.add(new com.baidu.tieba.n.a(103));
            this.cqj = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void Et(int i) {
        if (this.cqj == 5) {
            deN();
        } else if (this.cqj == 3) {
            this.lmp = i;
            this.lmt = System.currentTimeMillis();
            this.lmq.add(new com.baidu.tieba.n.a(200));
            this.cqj = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void H(long j, int i) {
        this.lmv++;
        this.lmw += j;
        this.lmy.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.h
    public void deM() {
        if (this.cqj == 4 || this.cqj == 3) {
            if (this.lmt != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.lmu = (currentTimeMillis - this.lmt) + this.lmu;
                this.lmt = 0L;
            }
            this.lmq.add(new com.baidu.tieba.n.a(203));
            this.cqj = 5;
        }
    }

    public void deN() {
        if (this.cqj == 5) {
            this.lmt = System.currentTimeMillis();
            this.lmq.add(new com.baidu.tieba.n.a(204));
            this.cqj = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void NP(String str) {
        if (this.cqj != 8 && this.cqj != 7 && this.cqj != 6 && this.cqj != -1) {
            this.mSource = VideoPlatformStatic.DX(str);
            deO();
            this.lmq.add(new com.baidu.tieba.n.a(205));
            this.cqj = 8;
            atQ();
        }
    }

    @Override // com.baidu.tieba.l.h
    public String NQ(String str) {
        if (this.cqj == 8 || this.cqj == 7 || this.cqj == 6 || this.cqj == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.DX(str);
        deO();
        this.lmr.put("stallDuration", Long.valueOf(this.lmw));
        this.lmq.add(new com.baidu.tieba.n.a(206));
        this.cqj = 6;
        atQ();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public boolean NR(String str) {
        if (this.cqj == 8 || this.cqj == 7 || this.cqj == 6 || this.cqj == -1 || this.cqj == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.DX(str);
        deO();
        this.lmq.add(new com.baidu.tieba.n.a(207));
        this.cqj = 7;
        atQ();
        return true;
    }

    private void deO() {
        if (this.lmt != 0) {
            this.lmu += System.currentTimeMillis() - this.lmt;
        }
        this.lmr.put("playDuration", Long.valueOf(this.lmu));
        this.lmr.put("stallCount", Long.valueOf(this.lmv));
        this.lmr.put("stallDuration", Long.valueOf(this.lmw));
        if (!this.lmr.containsKey("loadingTime")) {
            this.lmr.put("loadingTime", 0L);
        }
        this.lms = 0L;
        this.lmt = 0L;
        this.lmu = 0L;
        this.lmv = 0L;
        this.lmw = 0L;
        this.lmx = 0L;
    }

    public void atQ() {
        if (!this.lmD) {
            int byE = com.baidu.tbadk.coreExtra.model.g.byE();
            if ((com.baidu.tbadk.coreExtra.model.g.byD() || !this.lmA) && byE != 3) {
                this.lmD = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.i.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int byE2 = com.baidu.tbadk.coreExtra.model.g.byE();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", i.this.bKr());
                            jSONObject.put("kpiInfo", i.this.deP());
                            if (byE2 == 0 || (byE2 == 4 && i.this.lmA)) {
                                JSONObject deR = i.this.deR();
                                deR.put("running", i.this.deS());
                                jSONObject.put("debugInfo", deR);
                            } else if (byE2 == 2) {
                                jSONObject.put("debugInfo", i.this.deR());
                            } else if (byE2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dPo().i(jSONObject, i.this.lmA ? false : true);
                        if (i.this.lmF != null) {
                            i.this.lmF.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKr() {
        JSONObject bKr = VideoPlatformStatic.bKr();
        if (this.lmF != null) {
            try {
                int size = this.lmF.size();
                for (int i = 0; i < size; i++) {
                    this.lmF.get(i).eB(bKr);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bKr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject deP() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.lmr.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.lmr.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.lmr.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.lmr.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.lmr.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.lmz ? 1 : 0);
            jSONObject.put("playSuccess", this.lmA ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", deQ());
            jSONObject.put("retryError", this.lmC ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.lmF != null) {
                int size = this.lmF.size();
                for (int i = 0; i < size; i++) {
                    this.lmF.get(i).eC(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject deQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.lmH);
            jSONObject.put("startTime", this.lmI);
            jSONObject.put("totalTime", this.lmJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        deT();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject deR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.lmo)) {
                jSONObject.put("parentUuid", this.lmo);
            }
            jSONObject.put("tid", this.amM);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.sP(this.lmp));
            jSONObject.put("urlType", this.eKH);
            jSONObject.put("sub_error", this.lmG);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.lmB ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.lmy);
            jSONObject.put("pcdn_used", this.lmK ? "1" : "0");
            jSONObject.put("p2p_used", this.lmL ? "1" : "0");
            if (!StringUtils.isNull(this.lmE)) {
                jSONObject.put("error_stack", this.lmE);
            }
            if (this.lmF != null) {
                int size = this.lmF.size();
                for (int i = 0; i < size; i++) {
                    this.lmF.get(i).eD(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray deS() {
        JSONArray jSONArray = new JSONArray();
        if (this.lmq == null) {
            return jSONArray;
        }
        int size = this.lmq.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.lmq.get(i).dyJ());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.h
    public void h(long j, long j2, long j3) {
        this.lmH = j;
        this.lmI = j2;
        this.lmJ = j3;
    }

    private void deT() {
        this.lmH = 0L;
        this.lmI = 0L;
        this.lmJ = 0L;
    }
}
