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
    private String jRR;
    private int jRS;
    private int jRT;
    private long jRZ;
    private long jSa;
    private long jSb;
    private boolean jSd;
    private boolean jSh;
    private String jSi;
    private List<b> jSj;
    private int jSk;
    private long jSl;
    private long jSm;
    private long jSn;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean jSe = true;
    private boolean jSf = false;
    private boolean jSg = false;
    private boolean jSo = false;
    private boolean jSp = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> jRV = new HashMap();
    private List<com.baidu.tieba.n.b> jRU = new ArrayList();
    private long jRW = 0;
    private long jRX = 0;
    private long jRY = 0;
    private ArrayList<Integer> jSc = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.bGB = 0;
        this.bGB = 0;
        this.ajJ = str;
        this.mVideoUrl = str2;
        this.jRR = str3;
        cGz();
    }

    @Override // com.baidu.tieba.k.i
    public void cGr() {
        this.jRW = System.currentTimeMillis();
        this.jRU.add(new com.baidu.tieba.n.a(3));
        this.bGB = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void ro(boolean z) {
        this.jSd = z;
        this.jRU.add(new com.baidu.tieba.n.a(1));
        this.bGB = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void ae(boolean z, boolean z2) {
        this.jSo = z;
        this.jSp = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void AL(int i) {
        if (this.bGB != 4 && this.bGB != 5 && this.bGB != 7 && this.bGB != 8) {
            this.jRS = i;
            this.jSe = true;
            long currentTimeMillis = System.currentTimeMillis() - this.jRW;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.jRV.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.jRW = 0L;
            this.jRU.add(new com.baidu.tieba.n.a(102));
            this.bGB = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void AM(int i) {
        if (this.bGB != 4 && this.bGB != 5 && this.bGB != 7 && this.bGB != 8) {
            this.jRS = i;
            this.jSe = true;
            this.jSf = true;
            this.jRV.put("loadingTime", 1L);
            this.jRW = 0L;
            this.jRU.add(new com.baidu.tieba.n.a(103));
            this.bGB = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void AN(int i) {
        if (this.bGB == 5) {
            cGt();
        } else if (this.bGB == 3) {
            this.jRS = i;
            this.jRX = System.currentTimeMillis();
            this.jRU.add(new com.baidu.tieba.n.a(200));
            this.bGB = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void t(long j, int i) {
        this.jRZ++;
        this.jSa += j;
        this.jSc.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cGs() {
        if (this.bGB == 4 || this.bGB == 3) {
            if (this.jRX != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.jRY = (currentTimeMillis - this.jRX) + this.jRY;
                this.jRX = 0L;
            }
            this.jRU.add(new com.baidu.tieba.n.a(203));
            this.bGB = 5;
        }
    }

    public void cGt() {
        if (this.bGB == 5) {
            this.jRX = System.currentTimeMillis();
            this.jRU.add(new com.baidu.tieba.n.a(204));
            this.bGB = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void JO(String str) {
        if (this.bGB != 8 && this.bGB != 7 && this.bGB != 6 && this.bGB != -1) {
            this.mSource = VideoPlatformStatic.AM(str);
            cGu();
            this.jRU.add(new com.baidu.tieba.n.a(205));
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
        this.jRV.put("stallDuration", Long.valueOf(this.jSa));
        this.jRU.add(new com.baidu.tieba.n.a(206));
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
        this.jRU.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.bGB = 7;
        aeU();
        return true;
    }

    private void cGu() {
        if (this.jRX != 0) {
            this.jRY += System.currentTimeMillis() - this.jRX;
        }
        this.jRV.put("playDuration", Long.valueOf(this.jRY));
        this.jRV.put("stallCount", Long.valueOf(this.jRZ));
        this.jRV.put("stallDuration", Long.valueOf(this.jSa));
        if (!this.jRV.containsKey("loadingTime")) {
            this.jRV.put("loadingTime", 0L);
        }
        this.jRW = 0L;
        this.jRX = 0L;
        this.jRY = 0L;
        this.jRZ = 0L;
        this.jSa = 0L;
        this.jSb = 0L;
    }

    public void aeU() {
        if (!this.jSh) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.bgD() || !this.jSe) && reportType != 3) {
                this.jSh = true;
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
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.jSe)) {
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
                        com.baidu.tieba.u.e.dpb().g(jSONObject, j.this.jSe ? false : true);
                        if (j.this.jSj != null) {
                            j.this.jSj.clear();
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
        if (this.jSj != null) {
            try {
                int size = this.jSj.size();
                for (int i = 0; i < size; i++) {
                    this.jSj.get(i).dI(brz);
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
            for (Map.Entry<String, Long> entry : this.jRV.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.jRV.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.jRV.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.jRV.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.jRV.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.jSd ? 1 : 0);
            jSONObject.put("playSuccess", this.jSe ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cGw());
            jSONObject.put("retryError", this.jSg ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.jSj != null) {
                int size = this.jSj.size();
                for (int i = 0; i < size; i++) {
                    this.jSj.get(i).dJ(jSONObject);
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
            jSONObject.put("preparedTime", this.jSl);
            jSONObject.put("startTime", this.jSm);
            jSONObject.put("totalTime", this.jSn);
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
            if (!StringUtils.isNull(this.jRR)) {
                jSONObject.put("parentUuid", this.jRR);
            }
            jSONObject.put("tid", this.ajJ);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.pK(this.jRS));
            jSONObject.put("urlType", this.jRT);
            jSONObject.put("sub_error", this.jSk);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.jSf ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.jSc);
            jSONObject.put("pcdn_used", this.jSo ? "1" : "0");
            jSONObject.put("p2p_used", this.jSp ? "1" : "0");
            if (!StringUtils.isNull(this.jSi)) {
                jSONObject.put("error_stack", this.jSi);
            }
            if (this.jSj != null) {
                int size = this.jSj.size();
                for (int i = 0; i < size; i++) {
                    this.jSj.get(i).dK(jSONObject);
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
        if (this.jRU == null) {
            return jSONArray;
        }
        int size = this.jRU.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.jRU.get(i).cZL());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.jSl = j;
        this.jSm = j2;
        this.jSn = j3;
    }

    private void cGz() {
        this.jSl = 0L;
        this.jSm = 0L;
        this.jSn = 0L;
    }
}
