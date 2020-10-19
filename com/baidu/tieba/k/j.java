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
    private String alS;
    private int bUO;
    private int elT;
    private int kFA;
    private long kFB;
    private long kFC;
    private long kFD;
    private String kFi;
    private int kFj;
    private long kFp;
    private long kFq;
    private long kFr;
    private boolean kFt;
    private boolean kFx;
    private String kFy;
    private List<b> kFz;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean kFu = true;
    private boolean kFv = false;
    private boolean kFw = false;
    private boolean kFE = false;
    private boolean kFF = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> kFl = new HashMap();
    private List<com.baidu.tieba.n.b> kFk = new ArrayList();
    private long kFm = 0;
    private long kFn = 0;
    private long kFo = 0;
    private ArrayList<Integer> kFs = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.bUO = 0;
        this.bUO = 0;
        this.alS = str;
        this.mVideoUrl = str2;
        this.kFi = str3;
        cYE();
    }

    @Override // com.baidu.tieba.k.i
    public void cYw() {
        this.kFm = System.currentTimeMillis();
        this.kFk.add(new com.baidu.tieba.n.a(3));
        this.bUO = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void sL(boolean z) {
        this.kFt = z;
        this.kFk.add(new com.baidu.tieba.n.a(1));
        this.bUO = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void aj(boolean z, boolean z2) {
        this.kFE = z;
        this.kFF = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void El(int i) {
        if (this.bUO != 4 && this.bUO != 5 && this.bUO != 7 && this.bUO != 8) {
            this.kFj = i;
            this.kFu = true;
            long currentTimeMillis = System.currentTimeMillis() - this.kFm;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.kFl.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.kFm = 0L;
            this.kFk.add(new com.baidu.tieba.n.a(102));
            this.bUO = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Em(int i) {
        if (this.bUO != 4 && this.bUO != 5 && this.bUO != 7 && this.bUO != 8) {
            this.kFj = i;
            this.kFu = true;
            this.kFv = true;
            this.kFl.put("loadingTime", 1L);
            this.kFm = 0L;
            this.kFk.add(new com.baidu.tieba.n.a(103));
            this.bUO = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void En(int i) {
        if (this.bUO == 5) {
            cYy();
        } else if (this.bUO == 3) {
            this.kFj = i;
            this.kFn = System.currentTimeMillis();
            this.kFk.add(new com.baidu.tieba.n.a(200));
            this.bUO = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void A(long j, int i) {
        this.kFp++;
        this.kFq += j;
        this.kFs.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cYx() {
        if (this.bUO == 4 || this.bUO == 3) {
            if (this.kFn != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.kFo = (currentTimeMillis - this.kFn) + this.kFo;
                this.kFn = 0L;
            }
            this.kFk.add(new com.baidu.tieba.n.a(203));
            this.bUO = 5;
        }
    }

    public void cYy() {
        if (this.bUO == 5) {
            this.kFn = System.currentTimeMillis();
            this.kFk.add(new com.baidu.tieba.n.a(204));
            this.bUO = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void NY(String str) {
        if (this.bUO != 8 && this.bUO != 7 && this.bUO != 6 && this.bUO != -1) {
            this.mSource = VideoPlatformStatic.Ep(str);
            cYz();
            this.kFk.add(new com.baidu.tieba.n.a(205));
            this.bUO = 8;
            apw();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String NZ(String str) {
        if (this.bUO == 8 || this.bUO == 7 || this.bUO == 6 || this.bUO == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Ep(str);
        cYz();
        this.kFl.put("stallDuration", Long.valueOf(this.kFq));
        this.kFk.add(new com.baidu.tieba.n.a(206));
        this.bUO = 6;
        apw();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Oa(String str) {
        if (this.bUO == 8 || this.bUO == 7 || this.bUO == 6 || this.bUO == -1 || this.bUO == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Ep(str);
        cYz();
        this.kFk.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.bUO = 7;
        apw();
        return true;
    }

    private void cYz() {
        if (this.kFn != 0) {
            this.kFo += System.currentTimeMillis() - this.kFn;
        }
        this.kFl.put("playDuration", Long.valueOf(this.kFo));
        this.kFl.put("stallCount", Long.valueOf(this.kFp));
        this.kFl.put("stallDuration", Long.valueOf(this.kFq));
        if (!this.kFl.containsKey("loadingTime")) {
            this.kFl.put("loadingTime", 0L);
        }
        this.kFm = 0L;
        this.kFn = 0L;
        this.kFo = 0L;
        this.kFp = 0L;
        this.kFq = 0L;
        this.kFr = 0L;
    }

    public void apw() {
        if (!this.kFx) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bsT() || !this.kFu) && reportType != 3) {
                this.kFx = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bEv());
                            jSONObject.put("kpiInfo", j.this.cYA());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.kFu)) {
                                JSONObject cYC = j.this.cYC();
                                cYC.put("running", j.this.cYD());
                                jSONObject.put("debugInfo", cYC);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cYC());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dIm().g(jSONObject, j.this.kFu ? false : true);
                        if (j.this.kFz != null) {
                            j.this.kFz.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bEv() {
        JSONObject bEv = VideoPlatformStatic.bEv();
        if (this.kFz != null) {
            try {
                int size = this.kFz.size();
                for (int i = 0; i < size; i++) {
                    this.kFz.get(i).ef(bEv);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bEv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cYA() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.kFl.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.kFl.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.kFl.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.kFl.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.kFl.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.kFt ? 1 : 0);
            jSONObject.put("playSuccess", this.kFu ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cYB());
            jSONObject.put("retryError", this.kFw ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.kFz != null) {
                int size = this.kFz.size();
                for (int i = 0; i < size; i++) {
                    this.kFz.get(i).eg(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cYB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.kFB);
            jSONObject.put("startTime", this.kFC);
            jSONObject.put("totalTime", this.kFD);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cYE();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cYC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.kFi)) {
                jSONObject.put("parentUuid", this.kFi);
            }
            jSONObject.put("tid", this.alS);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.sM(this.kFj));
            jSONObject.put("urlType", this.elT);
            jSONObject.put("sub_error", this.kFA);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.kFv ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.kFs);
            jSONObject.put("pcdn_used", this.kFE ? "1" : "0");
            jSONObject.put("p2p_used", this.kFF ? "1" : "0");
            if (!StringUtils.isNull(this.kFy)) {
                jSONObject.put("error_stack", this.kFy);
            }
            if (this.kFz != null) {
                int size = this.kFz.size();
                for (int i = 0; i < size; i++) {
                    this.kFz.get(i).eh(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cYD() {
        JSONArray jSONArray = new JSONArray();
        if (this.kFk == null) {
            return jSONArray;
        }
        int size = this.kFk.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.kFk.get(i).dsk());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.kFB = j;
        this.kFC = j2;
        this.kFD = j3;
    }

    private void cYE() {
        this.kFB = 0L;
        this.kFC = 0L;
        this.kFD = 0L;
    }
}
