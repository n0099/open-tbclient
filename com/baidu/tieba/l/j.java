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
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class j implements i {
    private String alZ;
    private int chm;
    private int eyD;
    private String kXT;
    private int kXU;
    private long kYa;
    private long kYb;
    private long kYc;
    private boolean kYe;
    private boolean kYi;
    private String kYj;
    private List<b> kYk;
    private int kYl;
    private long kYm;
    private long kYn;
    private long kYo;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean kYf = true;
    private boolean kYg = false;
    private boolean kYh = false;
    private boolean kYp = false;
    private boolean kYq = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> kXW = new HashMap();
    private List<com.baidu.tieba.o.b> kXV = new ArrayList();
    private long kXX = 0;
    private long kXY = 0;
    private long kXZ = 0;
    private ArrayList<Integer> kYd = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.chm = 0;
        this.chm = 0;
        this.alZ = str;
        this.mVideoUrl = str2;
        this.kXT = str3;
        ddL();
    }

    @Override // com.baidu.tieba.l.i
    public void ddD() {
        this.kXX = System.currentTimeMillis();
        this.kXV.add(new com.baidu.tieba.o.a(3));
        this.chm = 0;
    }

    @Override // com.baidu.tieba.l.i
    public void to(boolean z) {
        this.kYe = z;
        this.kXV.add(new com.baidu.tieba.o.a(1));
        this.chm = 1;
    }

    @Override // com.baidu.tieba.l.i
    public void am(boolean z, boolean z2) {
        this.kYp = z;
        this.kYq = z2;
    }

    @Override // com.baidu.tieba.l.i
    public void Fp(int i) {
        if (this.chm != 4 && this.chm != 5 && this.chm != 7 && this.chm != 8) {
            this.kXU = i;
            this.kYf = true;
            long currentTimeMillis = System.currentTimeMillis() - this.kXX;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.kXW.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.kXX = 0L;
            this.kXV.add(new com.baidu.tieba.o.a(102));
            this.chm = 3;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Fq(int i) {
        if (this.chm != 4 && this.chm != 5 && this.chm != 7 && this.chm != 8) {
            this.kXU = i;
            this.kYf = true;
            this.kYg = true;
            this.kXW.put("loadingTime", 1L);
            this.kXX = 0L;
            this.kXV.add(new com.baidu.tieba.o.a(103));
            this.chm = 3;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Fr(int i) {
        if (this.chm == 5) {
            ddF();
        } else if (this.chm == 3) {
            this.kXU = i;
            this.kXY = System.currentTimeMillis();
            this.kXV.add(new com.baidu.tieba.o.a(200));
            this.chm = 4;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void E(long j, int i) {
        this.kYa++;
        this.kYb += j;
        this.kYd.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.i
    public void ddE() {
        if (this.chm == 4 || this.chm == 3) {
            if (this.kXY != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.kXZ = (currentTimeMillis - this.kXY) + this.kXZ;
                this.kXY = 0L;
            }
            this.kXV.add(new com.baidu.tieba.o.a(203));
            this.chm = 5;
        }
    }

    public void ddF() {
        if (this.chm == 5) {
            this.kXY = System.currentTimeMillis();
            this.kXV.add(new com.baidu.tieba.o.a(204));
            this.chm = 4;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Oj(String str) {
        if (this.chm != 8 && this.chm != 7 && this.chm != 6 && this.chm != -1) {
            this.mSource = VideoPlatformStatic.Ex(str);
            ddG();
            this.kXV.add(new com.baidu.tieba.o.a(205));
            this.chm = 8;
            atj();
        }
    }

    @Override // com.baidu.tieba.l.i
    public String Ok(String str) {
        if (this.chm == 8 || this.chm == 7 || this.chm == 6 || this.chm == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Ex(str);
        ddG();
        this.kXW.put("stallDuration", Long.valueOf(this.kYb));
        this.kXV.add(new com.baidu.tieba.o.a(206));
        this.chm = 6;
        atj();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.l.i
    public boolean Ol(String str) {
        if (this.chm == 8 || this.chm == 7 || this.chm == 6 || this.chm == -1 || this.chm == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Ex(str);
        ddG();
        this.kXV.add(new com.baidu.tieba.o.a(HttpStatus.SC_MULTI_STATUS));
        this.chm = 7;
        atj();
        return true;
    }

    private void ddG() {
        if (this.kXY != 0) {
            this.kXZ += System.currentTimeMillis() - this.kXY;
        }
        this.kXW.put("playDuration", Long.valueOf(this.kXZ));
        this.kXW.put("stallCount", Long.valueOf(this.kYa));
        this.kXW.put("stallDuration", Long.valueOf(this.kYb));
        if (!this.kXW.containsKey("loadingTime")) {
            this.kXW.put("loadingTime", 0L);
        }
        this.kXX = 0L;
        this.kXY = 0L;
        this.kXZ = 0L;
        this.kYa = 0L;
        this.kYb = 0L;
        this.kYc = 0L;
    }

    public void atj() {
        if (!this.kYi) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bwC() || !this.kYf) && reportType != 3) {
                this.kYi = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bIh());
                            jSONObject.put("kpiInfo", j.this.ddH());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.kYf)) {
                                JSONObject ddJ = j.this.ddJ();
                                ddJ.put("running", j.this.ddK());
                                jSONObject.put("debugInfo", ddJ);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.ddJ());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.v.e.dNV().g(jSONObject, j.this.kYf ? false : true);
                        if (j.this.kYk != null) {
                            j.this.kYk.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bIh() {
        JSONObject bIh = VideoPlatformStatic.bIh();
        if (this.kYk != null) {
            try {
                int size = this.kYk.size();
                for (int i = 0; i < size; i++) {
                    this.kYk.get(i).el(bIh);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bIh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ddH() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.kXW.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.kXW.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.kXW.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.kXW.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.kXW.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.kYe ? 1 : 0);
            jSONObject.put("playSuccess", this.kYf ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", ddI());
            jSONObject.put("retryError", this.kYh ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.kYk != null) {
                int size = this.kYk.size();
                for (int i = 0; i < size; i++) {
                    this.kYk.get(i).em(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject ddI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.kYm);
            jSONObject.put("startTime", this.kYn);
            jSONObject.put("totalTime", this.kYo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ddL();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ddJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.kXT)) {
                jSONObject.put("parentUuid", this.kXT);
            }
            jSONObject.put("tid", this.alZ);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.tF(this.kXU));
            jSONObject.put("urlType", this.eyD);
            jSONObject.put("sub_error", this.kYl);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.kYg ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.kYd);
            jSONObject.put("pcdn_used", this.kYp ? "1" : "0");
            jSONObject.put("p2p_used", this.kYq ? "1" : "0");
            if (!StringUtils.isNull(this.kYj)) {
                jSONObject.put("error_stack", this.kYj);
            }
            if (this.kYk != null) {
                int size = this.kYk.size();
                for (int i = 0; i < size; i++) {
                    this.kYk.get(i).en(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray ddK() {
        JSONArray jSONArray = new JSONArray();
        if (this.kXV == null) {
            return jSONArray;
        }
        int size = this.kXV.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.kXV.get(i).dxt());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.i
    public void h(long j, long j2, long j3) {
        this.kYm = j;
        this.kYn = j2;
        this.kYo = j3;
    }

    private void ddL() {
        this.kYm = 0L;
        this.kYn = 0L;
        this.kYo = 0L;
    }
}
