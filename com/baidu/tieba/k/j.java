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
    private String ajJ;
    private int bGB;
    private String jRT;
    private int jRU;
    private int jRV;
    private long jSb;
    private long jSc;
    private long jSd;
    private boolean jSf;
    private boolean jSj;
    private String jSk;
    private List<b> jSl;
    private int jSm;
    private long jSn;
    private long jSo;
    private long jSp;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean jSg = true;
    private boolean jSh = false;
    private boolean jSi = false;
    private boolean jSq = false;
    private boolean jSr = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> jRX = new HashMap();
    private List<com.baidu.tieba.n.b> jRW = new ArrayList();
    private long jRY = 0;
    private long jRZ = 0;
    private long jSa = 0;
    private ArrayList<Integer> jSe = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.bGB = 0;
        this.bGB = 0;
        this.ajJ = str;
        this.mVideoUrl = str2;
        this.jRT = str3;
        cGz();
    }

    @Override // com.baidu.tieba.k.i
    public void cGr() {
        this.jRY = System.currentTimeMillis();
        this.jRW.add(new com.baidu.tieba.n.a(3));
        this.bGB = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void ro(boolean z) {
        this.jSf = z;
        this.jRW.add(new com.baidu.tieba.n.a(1));
        this.bGB = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void ae(boolean z, boolean z2) {
        this.jSq = z;
        this.jSr = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void AL(int i) {
        if (this.bGB != 4 && this.bGB != 5 && this.bGB != 7 && this.bGB != 8) {
            this.jRU = i;
            this.jSg = true;
            long currentTimeMillis = System.currentTimeMillis() - this.jRY;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.jRX.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.jRY = 0L;
            this.jRW.add(new com.baidu.tieba.n.a(102));
            this.bGB = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void AM(int i) {
        if (this.bGB != 4 && this.bGB != 5 && this.bGB != 7 && this.bGB != 8) {
            this.jRU = i;
            this.jSg = true;
            this.jSh = true;
            this.jRX.put("loadingTime", 1L);
            this.jRY = 0L;
            this.jRW.add(new com.baidu.tieba.n.a(103));
            this.bGB = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void AN(int i) {
        if (this.bGB == 5) {
            cGt();
        } else if (this.bGB == 3) {
            this.jRU = i;
            this.jRZ = System.currentTimeMillis();
            this.jRW.add(new com.baidu.tieba.n.a(200));
            this.bGB = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void t(long j, int i) {
        this.jSb++;
        this.jSc += j;
        this.jSe.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cGs() {
        if (this.bGB == 4 || this.bGB == 3) {
            if (this.jRZ != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.jSa = (currentTimeMillis - this.jRZ) + this.jSa;
                this.jRZ = 0L;
            }
            this.jRW.add(new com.baidu.tieba.n.a(203));
            this.bGB = 5;
        }
    }

    public void cGt() {
        if (this.bGB == 5) {
            this.jRZ = System.currentTimeMillis();
            this.jRW.add(new com.baidu.tieba.n.a(204));
            this.bGB = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void JO(String str) {
        if (this.bGB != 8 && this.bGB != 7 && this.bGB != 6 && this.bGB != -1) {
            this.mSource = VideoPlatformStatic.AM(str);
            cGu();
            this.jRW.add(new com.baidu.tieba.n.a(205));
            this.bGB = 8;
            aeU();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String JP(String str) {
        if (this.bGB == 8 || this.bGB == 7 || this.bGB == 6 || this.bGB == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.AM(str);
        cGu();
        this.jRX.put("stallDuration", Long.valueOf(this.jSc));
        this.jRW.add(new com.baidu.tieba.n.a(206));
        this.bGB = 6;
        aeU();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean JQ(String str) {
        if (this.bGB == 8 || this.bGB == 7 || this.bGB == 6 || this.bGB == -1 || this.bGB == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.AM(str);
        cGu();
        this.jRW.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.bGB = 7;
        aeU();
        return true;
    }

    private void cGu() {
        if (this.jRZ != 0) {
            this.jSa += System.currentTimeMillis() - this.jRZ;
        }
        this.jRX.put("playDuration", Long.valueOf(this.jSa));
        this.jRX.put("stallCount", Long.valueOf(this.jSb));
        this.jRX.put("stallDuration", Long.valueOf(this.jSc));
        if (!this.jRX.containsKey("loadingTime")) {
            this.jRX.put("loadingTime", 0L);
        }
        this.jRY = 0L;
        this.jRZ = 0L;
        this.jSa = 0L;
        this.jSb = 0L;
        this.jSc = 0L;
        this.jSd = 0L;
    }

    public void aeU() {
        if (!this.jSj) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.bgD() || !this.jSg) && reportType != 3) {
                this.jSj = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.brz());
                            jSONObject.put("kpiInfo", j.this.cGv());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.jSg)) {
                                JSONObject cGx = j.this.cGx();
                                cGx.put("running", j.this.cGy());
                                jSONObject.put("debugInfo", cGx);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cGx());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dpc().g(jSONObject, j.this.jSg ? false : true);
                        if (j.this.jSl != null) {
                            j.this.jSl.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject brz() {
        JSONObject brz = VideoPlatformStatic.brz();
        if (this.jSl != null) {
            try {
                int size = this.jSl.size();
                for (int i = 0; i < size; i++) {
                    this.jSl.get(i).dI(brz);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return brz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cGv() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.jRX.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.jRX.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.jRX.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.jRX.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.jRX.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.jSf ? 1 : 0);
            jSONObject.put("playSuccess", this.jSg ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cGw());
            jSONObject.put("retryError", this.jSi ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.jSl != null) {
                int size = this.jSl.size();
                for (int i = 0; i < size; i++) {
                    this.jSl.get(i).dJ(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cGw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.jSn);
            jSONObject.put("startTime", this.jSo);
            jSONObject.put("totalTime", this.jSp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cGz();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cGx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.jRT)) {
                jSONObject.put("parentUuid", this.jRT);
            }
            jSONObject.put("tid", this.ajJ);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.pK(this.jRU));
            jSONObject.put("urlType", this.jRV);
            jSONObject.put("sub_error", this.jSm);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.jSh ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.jSe);
            jSONObject.put("pcdn_used", this.jSq ? "1" : "0");
            jSONObject.put("p2p_used", this.jSr ? "1" : "0");
            if (!StringUtils.isNull(this.jSk)) {
                jSONObject.put("error_stack", this.jSk);
            }
            if (this.jSl != null) {
                int size = this.jSl.size();
                for (int i = 0; i < size; i++) {
                    this.jSl.get(i).dK(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cGy() {
        JSONArray jSONArray = new JSONArray();
        if (this.jRW == null) {
            return jSONArray;
        }
        int size = this.jRW.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.jRW.get(i).cZL());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.jSn = j;
        this.jSo = j2;
        this.jSp = j3;
    }

    private void cGz() {
        this.jSn = 0L;
        this.jSo = 0L;
        this.jSp = 0L;
    }
}
