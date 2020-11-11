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
    private int ciY;
    private int eAm;
    private String kXB;
    private int kXC;
    private long kXI;
    private long kXJ;
    private long kXK;
    private boolean kXM;
    private boolean kXQ;
    private String kXR;
    private List<b> kXS;
    private int kXT;
    private long kXU;
    private long kXV;
    private long kXW;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean kXN = true;
    private boolean kXO = false;
    private boolean kXP = false;
    private boolean kXX = false;
    private boolean kXY = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> kXE = new HashMap();
    private List<com.baidu.tieba.n.b> kXD = new ArrayList();
    private long kXF = 0;
    private long kXG = 0;
    private long kXH = 0;
    private ArrayList<Integer> kXL = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.ciY = 0;
        this.ciY = 0;
        this.alT = str;
        this.mVideoUrl = str2;
        this.kXB = str3;
        deo();
    }

    @Override // com.baidu.tieba.k.i
    public void deg() {
        this.kXF = System.currentTimeMillis();
        this.kXD.add(new com.baidu.tieba.n.a(3));
        this.ciY = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void tl(boolean z) {
        this.kXM = z;
        this.kXD.add(new com.baidu.tieba.n.a(1));
        this.ciY = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void am(boolean z, boolean z2) {
        this.kXX = z;
        this.kXY = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void ER(int i) {
        if (this.ciY != 4 && this.ciY != 5 && this.ciY != 7 && this.ciY != 8) {
            this.kXC = i;
            this.kXN = true;
            long currentTimeMillis = System.currentTimeMillis() - this.kXF;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.kXE.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.kXF = 0L;
            this.kXD.add(new com.baidu.tieba.n.a(102));
            this.ciY = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void ES(int i) {
        if (this.ciY != 4 && this.ciY != 5 && this.ciY != 7 && this.ciY != 8) {
            this.kXC = i;
            this.kXN = true;
            this.kXO = true;
            this.kXE.put("loadingTime", 1L);
            this.kXF = 0L;
            this.kXD.add(new com.baidu.tieba.n.a(103));
            this.ciY = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void ET(int i) {
        if (this.ciY == 5) {
            dei();
        } else if (this.ciY == 3) {
            this.kXC = i;
            this.kXG = System.currentTimeMillis();
            this.kXD.add(new com.baidu.tieba.n.a(200));
            this.ciY = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void E(long j, int i) {
        this.kXI++;
        this.kXJ += j;
        this.kXL.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void deh() {
        if (this.ciY == 4 || this.ciY == 3) {
            if (this.kXG != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.kXH = (currentTimeMillis - this.kXG) + this.kXH;
                this.kXG = 0L;
            }
            this.kXD.add(new com.baidu.tieba.n.a(203));
            this.ciY = 5;
        }
    }

    public void dei() {
        if (this.ciY == 5) {
            this.kXG = System.currentTimeMillis();
            this.kXD.add(new com.baidu.tieba.n.a(204));
            this.ciY = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void ON(String str) {
        if (this.ciY != 8 && this.ciY != 7 && this.ciY != 6 && this.ciY != -1) {
            this.mSource = VideoPlatformStatic.EW(str);
            dej();
            this.kXD.add(new com.baidu.tieba.n.a(205));
            this.ciY = 8;
            atR();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String OO(String str) {
        if (this.ciY == 8 || this.ciY == 7 || this.ciY == 6 || this.ciY == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.EW(str);
        dej();
        this.kXE.put("stallDuration", Long.valueOf(this.kXJ));
        this.kXD.add(new com.baidu.tieba.n.a(206));
        this.ciY = 6;
        atR();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean OP(String str) {
        if (this.ciY == 8 || this.ciY == 7 || this.ciY == 6 || this.ciY == -1 || this.ciY == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.EW(str);
        dej();
        this.kXD.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.ciY = 7;
        atR();
        return true;
    }

    private void dej() {
        if (this.kXG != 0) {
            this.kXH += System.currentTimeMillis() - this.kXG;
        }
        this.kXE.put("playDuration", Long.valueOf(this.kXH));
        this.kXE.put("stallCount", Long.valueOf(this.kXI));
        this.kXE.put("stallDuration", Long.valueOf(this.kXJ));
        if (!this.kXE.containsKey("loadingTime")) {
            this.kXE.put("loadingTime", 0L);
        }
        this.kXF = 0L;
        this.kXG = 0L;
        this.kXH = 0L;
        this.kXI = 0L;
        this.kXJ = 0L;
        this.kXK = 0L;
    }

    public void atR() {
        if (!this.kXQ) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bxm() || !this.kXN) && reportType != 3) {
                this.kXQ = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bIN());
                            jSONObject.put("kpiInfo", j.this.dek());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.kXN)) {
                                JSONObject dem = j.this.dem();
                                dem.put("running", j.this.den());
                                jSONObject.put("debugInfo", dem);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.dem());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dNW().g(jSONObject, j.this.kXN ? false : true);
                        if (j.this.kXS != null) {
                            j.this.kXS.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bIN() {
        JSONObject bIN = VideoPlatformStatic.bIN();
        if (this.kXS != null) {
            try {
                int size = this.kXS.size();
                for (int i = 0; i < size; i++) {
                    this.kXS.get(i).er(bIN);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bIN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dek() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.kXE.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.kXE.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.kXE.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.kXE.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.kXE.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.kXM ? 1 : 0);
            jSONObject.put("playSuccess", this.kXN ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", del());
            jSONObject.put("retryError", this.kXP ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.kXS != null) {
                int size = this.kXS.size();
                for (int i = 0; i < size; i++) {
                    this.kXS.get(i).es(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject del() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.kXU);
            jSONObject.put("startTime", this.kXV);
            jSONObject.put("totalTime", this.kXW);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        deo();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dem() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.kXB)) {
                jSONObject.put("parentUuid", this.kXB);
            }
            jSONObject.put("tid", this.alT);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.th(this.kXC));
            jSONObject.put("urlType", this.eAm);
            jSONObject.put("sub_error", this.kXT);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.kXO ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.kXL);
            jSONObject.put("pcdn_used", this.kXX ? "1" : "0");
            jSONObject.put("p2p_used", this.kXY ? "1" : "0");
            if (!StringUtils.isNull(this.kXR)) {
                jSONObject.put("error_stack", this.kXR);
            }
            if (this.kXS != null) {
                int size = this.kXS.size();
                for (int i = 0; i < size; i++) {
                    this.kXS.get(i).et(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray den() {
        JSONArray jSONArray = new JSONArray();
        if (this.kXD == null) {
            return jSONArray;
        }
        int size = this.kXD.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.kXD.get(i).dxT());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.kXU = j;
        this.kXV = j2;
        this.kXW = j3;
    }

    private void deo() {
        this.kXU = 0L;
        this.kXV = 0L;
        this.kXW = 0L;
    }
}
