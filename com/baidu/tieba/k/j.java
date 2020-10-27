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
/* loaded from: classes23.dex */
public class j implements i {
    private String alT;
    private int cdn;
    private int eut;
    private String kRF;
    private int kRG;
    private long kRM;
    private long kRN;
    private long kRO;
    private boolean kRQ;
    private boolean kRU;
    private String kRV;
    private List<b> kRW;
    private int kRX;
    private long kRY;
    private long kRZ;
    private long kSa;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean kRR = true;
    private boolean kRS = false;
    private boolean kRT = false;
    private boolean kSb = false;
    private boolean kSc = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> kRI = new HashMap();
    private List<com.baidu.tieba.n.b> kRH = new ArrayList();
    private long kRJ = 0;
    private long kRK = 0;
    private long kRL = 0;
    private ArrayList<Integer> kRP = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.cdn = 0;
        this.cdn = 0;
        this.alT = str;
        this.mVideoUrl = str2;
        this.kRF = str3;
        dbM();
    }

    @Override // com.baidu.tieba.k.i
    public void dbE() {
        this.kRJ = System.currentTimeMillis();
        this.kRH.add(new com.baidu.tieba.n.a(3));
        this.cdn = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void tc(boolean z) {
        this.kRQ = z;
        this.kRH.add(new com.baidu.tieba.n.a(1));
        this.cdn = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void am(boolean z, boolean z2) {
        this.kSb = z;
        this.kSc = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void EE(int i) {
        if (this.cdn != 4 && this.cdn != 5 && this.cdn != 7 && this.cdn != 8) {
            this.kRG = i;
            this.kRR = true;
            long currentTimeMillis = System.currentTimeMillis() - this.kRJ;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.kRI.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.kRJ = 0L;
            this.kRH.add(new com.baidu.tieba.n.a(102));
            this.cdn = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void EF(int i) {
        if (this.cdn != 4 && this.cdn != 5 && this.cdn != 7 && this.cdn != 8) {
            this.kRG = i;
            this.kRR = true;
            this.kRS = true;
            this.kRI.put("loadingTime", 1L);
            this.kRJ = 0L;
            this.kRH.add(new com.baidu.tieba.n.a(103));
            this.cdn = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void EG(int i) {
        if (this.cdn == 5) {
            dbG();
        } else if (this.cdn == 3) {
            this.kRG = i;
            this.kRK = System.currentTimeMillis();
            this.kRH.add(new com.baidu.tieba.n.a(200));
            this.cdn = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void A(long j, int i) {
        this.kRM++;
        this.kRN += j;
        this.kRP.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void dbF() {
        if (this.cdn == 4 || this.cdn == 3) {
            if (this.kRK != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.kRL = (currentTimeMillis - this.kRK) + this.kRL;
                this.kRK = 0L;
            }
            this.kRH.add(new com.baidu.tieba.n.a(203));
            this.cdn = 5;
        }
    }

    public void dbG() {
        if (this.cdn == 5) {
            this.kRK = System.currentTimeMillis();
            this.kRH.add(new com.baidu.tieba.n.a(204));
            this.cdn = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Ow(String str) {
        if (this.cdn != 8 && this.cdn != 7 && this.cdn != 6 && this.cdn != -1) {
            this.mSource = VideoPlatformStatic.EI(str);
            dbH();
            this.kRH.add(new com.baidu.tieba.n.a(205));
            this.cdn = 8;
            arq();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Ox(String str) {
        if (this.cdn == 8 || this.cdn == 7 || this.cdn == 6 || this.cdn == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.EI(str);
        dbH();
        this.kRI.put("stallDuration", Long.valueOf(this.kRN));
        this.kRH.add(new com.baidu.tieba.n.a(206));
        this.cdn = 6;
        arq();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Oy(String str) {
        if (this.cdn == 8 || this.cdn == 7 || this.cdn == 6 || this.cdn == -1 || this.cdn == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.EI(str);
        dbH();
        this.kRH.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.cdn = 7;
        arq();
        return true;
    }

    private void dbH() {
        if (this.kRK != 0) {
            this.kRL += System.currentTimeMillis() - this.kRK;
        }
        this.kRI.put("playDuration", Long.valueOf(this.kRL));
        this.kRI.put("stallCount", Long.valueOf(this.kRM));
        this.kRI.put("stallDuration", Long.valueOf(this.kRN));
        if (!this.kRI.containsKey("loadingTime")) {
            this.kRI.put("loadingTime", 0L);
        }
        this.kRJ = 0L;
        this.kRK = 0L;
        this.kRL = 0L;
        this.kRM = 0L;
        this.kRN = 0L;
        this.kRO = 0L;
    }

    public void arq() {
        if (!this.kRU) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.buM() || !this.kRR) && reportType != 3) {
                this.kRU = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bGo());
                            jSONObject.put("kpiInfo", j.this.dbI());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.kRR)) {
                                JSONObject dbK = j.this.dbK();
                                dbK.put("running", j.this.dbL());
                                jSONObject.put("debugInfo", dbK);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.dbK());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dLu().g(jSONObject, j.this.kRR ? false : true);
                        if (j.this.kRW != null) {
                            j.this.kRW.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bGo() {
        JSONObject bGo = VideoPlatformStatic.bGo();
        if (this.kRW != null) {
            try {
                int size = this.kRW.size();
                for (int i = 0; i < size; i++) {
                    this.kRW.get(i).el(bGo);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bGo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dbI() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.kRI.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.kRI.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.kRI.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.kRI.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.kRI.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.kRQ ? 1 : 0);
            jSONObject.put("playSuccess", this.kRR ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", dbJ());
            jSONObject.put("retryError", this.kRT ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.kRW != null) {
                int size = this.kRW.size();
                for (int i = 0; i < size; i++) {
                    this.kRW.get(i).em(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject dbJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.kRY);
            jSONObject.put("startTime", this.kRZ);
            jSONObject.put("totalTime", this.kSa);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dbM();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dbK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.kRF)) {
                jSONObject.put("parentUuid", this.kRF);
            }
            jSONObject.put("tid", this.alT);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.sX(this.kRG));
            jSONObject.put("urlType", this.eut);
            jSONObject.put("sub_error", this.kRX);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.kRS ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.kRP);
            jSONObject.put("pcdn_used", this.kSb ? "1" : "0");
            jSONObject.put("p2p_used", this.kSc ? "1" : "0");
            if (!StringUtils.isNull(this.kRV)) {
                jSONObject.put("error_stack", this.kRV);
            }
            if (this.kRW != null) {
                int size = this.kRW.size();
                for (int i = 0; i < size; i++) {
                    this.kRW.get(i).en(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray dbL() {
        JSONArray jSONArray = new JSONArray();
        if (this.kRH == null) {
            return jSONArray;
        }
        int size = this.kRH.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.kRH.get(i).dvr());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.kRY = j;
        this.kRZ = j2;
        this.kSa = j3;
    }

    private void dbM() {
        this.kRY = 0L;
        this.kRZ = 0L;
        this.kSa = 0L;
    }
}
