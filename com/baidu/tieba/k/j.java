package com.baidu.tieba.k;

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
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class j implements i {
    private String ala;
    private int bMf;
    private int dXH;
    private long khD;
    private long khE;
    private long khF;
    private boolean khH;
    private boolean khL;
    private String khM;
    private List<b> khN;
    private int khO;
    private long khP;
    private long khQ;
    private long khR;
    private String khw;
    private int khx;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean khI = true;
    private boolean khJ = false;
    private boolean khK = false;
    private boolean khS = false;
    private boolean khT = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> khz = new HashMap();
    private List<com.baidu.tieba.n.b> khy = new ArrayList();
    private long khA = 0;
    private long khB = 0;
    private long khC = 0;
    private ArrayList<Integer> khG = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.bMf = 0;
        this.bMf = 0;
        this.ala = str;
        this.mVideoUrl = str2;
        this.khw = str3;
        cRp();
    }

    @Override // com.baidu.tieba.k.i
    public void cRh() {
        this.khA = System.currentTimeMillis();
        this.khy.add(new com.baidu.tieba.n.a(3));
        this.bMf = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void rW(boolean z) {
        this.khH = z;
        this.khy.add(new com.baidu.tieba.n.a(1));
        this.bMf = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void ai(boolean z, boolean z2) {
        this.khS = z;
        this.khT = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void De(int i) {
        if (this.bMf != 4 && this.bMf != 5 && this.bMf != 7 && this.bMf != 8) {
            this.khx = i;
            this.khI = true;
            long currentTimeMillis = System.currentTimeMillis() - this.khA;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.khz.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.khA = 0L;
            this.khy.add(new com.baidu.tieba.n.a(102));
            this.bMf = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Df(int i) {
        if (this.bMf != 4 && this.bMf != 5 && this.bMf != 7 && this.bMf != 8) {
            this.khx = i;
            this.khI = true;
            this.khJ = true;
            this.khz.put("loadingTime", 1L);
            this.khA = 0L;
            this.khy.add(new com.baidu.tieba.n.a(103));
            this.bMf = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Dg(int i) {
        if (this.bMf == 5) {
            cRj();
        } else if (this.bMf == 3) {
            this.khx = i;
            this.khB = System.currentTimeMillis();
            this.khy.add(new com.baidu.tieba.n.a(200));
            this.bMf = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void t(long j, int i) {
        this.khD++;
        this.khE += j;
        this.khG.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cRi() {
        if (this.bMf == 4 || this.bMf == 3) {
            if (this.khB != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.khC = (currentTimeMillis - this.khB) + this.khC;
                this.khB = 0L;
            }
            this.khy.add(new com.baidu.tieba.n.a(203));
            this.bMf = 5;
        }
    }

    public void cRj() {
        if (this.bMf == 5) {
            this.khB = System.currentTimeMillis();
            this.khy.add(new com.baidu.tieba.n.a(204));
            this.bMf = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void MH(String str) {
        if (this.bMf != 8 && this.bMf != 7 && this.bMf != 6 && this.bMf != -1) {
            this.mSource = VideoPlatformStatic.Dh(str);
            cRk();
            this.khy.add(new com.baidu.tieba.n.a(205));
            this.bMf = 8;
            ama();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String MI(String str) {
        if (this.bMf == 8 || this.bMf == 7 || this.bMf == 6 || this.bMf == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Dh(str);
        cRk();
        this.khz.put("stallDuration", Long.valueOf(this.khE));
        this.khy.add(new com.baidu.tieba.n.a(206));
        this.bMf = 6;
        ama();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean MJ(String str) {
        if (this.bMf == 8 || this.bMf == 7 || this.bMf == 6 || this.bMf == -1 || this.bMf == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Dh(str);
        cRk();
        this.khy.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.bMf = 7;
        ama();
        return true;
    }

    private void cRk() {
        if (this.khB != 0) {
            this.khC += System.currentTimeMillis() - this.khB;
        }
        this.khz.put("playDuration", Long.valueOf(this.khC));
        this.khz.put("stallCount", Long.valueOf(this.khD));
        this.khz.put("stallDuration", Long.valueOf(this.khE));
        if (!this.khz.containsKey("loadingTime")) {
            this.khz.put("loadingTime", 0L);
        }
        this.khA = 0L;
        this.khB = 0L;
        this.khC = 0L;
        this.khD = 0L;
        this.khE = 0L;
        this.khF = 0L;
    }

    public void ama() {
        if (!this.khL) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bpp() || !this.khI) && reportType != 3) {
                this.khL = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bAx());
                            jSONObject.put("kpiInfo", j.this.cRl());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.khI)) {
                                JSONObject cRn = j.this.cRn();
                                cRn.put("running", j.this.cRo());
                                jSONObject.put("debugInfo", cRn);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cRn());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dAG().g(jSONObject, j.this.khI ? false : true);
                        if (j.this.khN != null) {
                            j.this.khN.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bAx() {
        JSONObject bAx = VideoPlatformStatic.bAx();
        if (this.khN != null) {
            try {
                int size = this.khN.size();
                for (int i = 0; i < size; i++) {
                    this.khN.get(i).dT(bAx);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bAx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cRl() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.khz.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.khz.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.khz.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.khz.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.khz.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.khH ? 1 : 0);
            jSONObject.put("playSuccess", this.khI ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cRm());
            jSONObject.put("retryError", this.khK ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.khN != null) {
                int size = this.khN.size();
                for (int i = 0; i < size; i++) {
                    this.khN.get(i).dU(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cRm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.khP);
            jSONObject.put("startTime", this.khQ);
            jSONObject.put("totalTime", this.khR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cRp();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cRn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.khw)) {
                jSONObject.put("parentUuid", this.khw);
            }
            jSONObject.put("tid", this.ala);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.rW(this.khx));
            jSONObject.put("urlType", this.dXH);
            jSONObject.put("sub_error", this.khO);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.khJ ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.khG);
            jSONObject.put("pcdn_used", this.khS ? "1" : "0");
            jSONObject.put("p2p_used", this.khT ? "1" : "0");
            if (!StringUtils.isNull(this.khM)) {
                jSONObject.put("error_stack", this.khM);
            }
            if (this.khN != null) {
                int size = this.khN.size();
                for (int i = 0; i < size; i++) {
                    this.khN.get(i).dV(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cRo() {
        JSONArray jSONArray = new JSONArray();
        if (this.khy == null) {
            return jSONArray;
        }
        int size = this.khy.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.khy.get(i).dkS());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.khP = j;
        this.khQ = j2;
        this.khR = j3;
    }

    private void cRp() {
        this.khP = 0L;
        this.khQ = 0L;
        this.khR = 0L;
    }
}
