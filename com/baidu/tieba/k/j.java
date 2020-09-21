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
/* loaded from: classes22.dex */
public class j implements i {
    private String alA;
    private int bOf;
    private int dZR;
    private String kpW;
    private int kpX;
    private long kqd;
    private long kqe;
    private long kqf;
    private boolean kqh;
    private boolean kql;
    private String kqm;
    private List<b> kqn;
    private int kqo;
    private long kqp;
    private long kqq;
    private long kqr;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean kqi = true;
    private boolean kqj = false;
    private boolean kqk = false;
    private boolean kqs = false;
    private boolean kqt = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> kpZ = new HashMap();
    private List<com.baidu.tieba.n.b> kpY = new ArrayList();
    private long kqa = 0;
    private long kqb = 0;
    private long kqc = 0;
    private ArrayList<Integer> kqg = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.bOf = 0;
        this.bOf = 0;
        this.alA = str;
        this.mVideoUrl = str2;
        this.kpW = str3;
        cUV();
    }

    @Override // com.baidu.tieba.k.i
    public void cUN() {
        this.kqa = System.currentTimeMillis();
        this.kpY.add(new com.baidu.tieba.n.a(3));
        this.bOf = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void se(boolean z) {
        this.kqh = z;
        this.kpY.add(new com.baidu.tieba.n.a(1));
        this.bOf = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void ak(boolean z, boolean z2) {
        this.kqs = z;
        this.kqt = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void DF(int i) {
        if (this.bOf != 4 && this.bOf != 5 && this.bOf != 7 && this.bOf != 8) {
            this.kpX = i;
            this.kqi = true;
            long currentTimeMillis = System.currentTimeMillis() - this.kqa;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.kpZ.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.kqa = 0L;
            this.kpY.add(new com.baidu.tieba.n.a(102));
            this.bOf = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void DG(int i) {
        if (this.bOf != 4 && this.bOf != 5 && this.bOf != 7 && this.bOf != 8) {
            this.kpX = i;
            this.kqi = true;
            this.kqj = true;
            this.kpZ.put("loadingTime", 1L);
            this.kqa = 0L;
            this.kpY.add(new com.baidu.tieba.n.a(103));
            this.bOf = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void DH(int i) {
        if (this.bOf == 5) {
            cUP();
        } else if (this.bOf == 3) {
            this.kpX = i;
            this.kqb = System.currentTimeMillis();
            this.kpY.add(new com.baidu.tieba.n.a(200));
            this.bOf = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void w(long j, int i) {
        this.kqd++;
        this.kqe += j;
        this.kqg.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cUO() {
        if (this.bOf == 4 || this.bOf == 3) {
            if (this.kqb != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.kqc = (currentTimeMillis - this.kqb) + this.kqc;
                this.kqb = 0L;
            }
            this.kpY.add(new com.baidu.tieba.n.a(203));
            this.bOf = 5;
        }
    }

    public void cUP() {
        if (this.bOf == 5) {
            this.kqb = System.currentTimeMillis();
            this.kpY.add(new com.baidu.tieba.n.a(204));
            this.bOf = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Nj(String str) {
        if (this.bOf != 8 && this.bOf != 7 && this.bOf != 6 && this.bOf != -1) {
            this.mSource = VideoPlatformStatic.DE(str);
            cUQ();
            this.kpY.add(new com.baidu.tieba.n.a(205));
            this.bOf = 8;
            amK();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Nk(String str) {
        if (this.bOf == 8 || this.bOf == 7 || this.bOf == 6 || this.bOf == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.DE(str);
        cUQ();
        this.kpZ.put("stallDuration", Long.valueOf(this.kqe));
        this.kpY.add(new com.baidu.tieba.n.a(206));
        this.bOf = 6;
        amK();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Nl(String str) {
        if (this.bOf == 8 || this.bOf == 7 || this.bOf == 6 || this.bOf == -1 || this.bOf == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.DE(str);
        cUQ();
        this.kpY.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.bOf = 7;
        amK();
        return true;
    }

    private void cUQ() {
        if (this.kqb != 0) {
            this.kqc += System.currentTimeMillis() - this.kqb;
        }
        this.kpZ.put("playDuration", Long.valueOf(this.kqc));
        this.kpZ.put("stallCount", Long.valueOf(this.kqd));
        this.kpZ.put("stallDuration", Long.valueOf(this.kqe));
        if (!this.kpZ.containsKey("loadingTime")) {
            this.kpZ.put("loadingTime", 0L);
        }
        this.kqa = 0L;
        this.kqb = 0L;
        this.kqc = 0L;
        this.kqd = 0L;
        this.kqe = 0L;
        this.kqf = 0L;
    }

    public void amK() {
        if (!this.kql) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bqj() || !this.kqi) && reportType != 3) {
                this.kql = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bBJ());
                            jSONObject.put("kpiInfo", j.this.cUR());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.kqi)) {
                                JSONObject cUT = j.this.cUT();
                                cUT.put("running", j.this.cUU());
                                jSONObject.put("debugInfo", cUT);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cUT());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dEA().g(jSONObject, j.this.kqi ? false : true);
                        if (j.this.kqn != null) {
                            j.this.kqn.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bBJ() {
        JSONObject bBJ = VideoPlatformStatic.bBJ();
        if (this.kqn != null) {
            try {
                int size = this.kqn.size();
                for (int i = 0; i < size; i++) {
                    this.kqn.get(i).eb(bBJ);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bBJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cUR() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.kpZ.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.kpZ.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.kpZ.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.kpZ.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.kpZ.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.kqh ? 1 : 0);
            jSONObject.put("playSuccess", this.kqi ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cUS());
            jSONObject.put("retryError", this.kqk ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.kqn != null) {
                int size = this.kqn.size();
                for (int i = 0; i < size; i++) {
                    this.kqn.get(i).ec(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cUS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.kqp);
            jSONObject.put("startTime", this.kqq);
            jSONObject.put("totalTime", this.kqr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cUV();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cUT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.kpW)) {
                jSONObject.put("parentUuid", this.kpW);
            }
            jSONObject.put("tid", this.alA);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.so(this.kpX));
            jSONObject.put("urlType", this.dZR);
            jSONObject.put("sub_error", this.kqo);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.kqj ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.kqg);
            jSONObject.put("pcdn_used", this.kqs ? "1" : "0");
            jSONObject.put("p2p_used", this.kqt ? "1" : "0");
            if (!StringUtils.isNull(this.kqm)) {
                jSONObject.put("error_stack", this.kqm);
            }
            if (this.kqn != null) {
                int size = this.kqn.size();
                for (int i = 0; i < size; i++) {
                    this.kqn.get(i).ed(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cUU() {
        JSONArray jSONArray = new JSONArray();
        if (this.kpY == null) {
            return jSONArray;
        }
        int size = this.kpY.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.kpY.get(i).doz());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.kqp = j;
        this.kqq = j2;
        this.kqr = j3;
    }

    private void cUV() {
        this.kqp = 0L;
        this.kqq = 0L;
        this.kqr = 0L;
    }
}
