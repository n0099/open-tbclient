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
    private String akY;
    private int bMb;
    private int dXD;
    private boolean khA;
    private boolean khE;
    private String khF;
    private List<b> khG;
    private int khH;
    private long khI;
    private long khJ;
    private long khK;
    private String khp;
    private int khq;
    private long khw;
    private long khx;
    private long khy;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean khB = true;
    private boolean khC = false;
    private boolean khD = false;
    private boolean khL = false;
    private boolean khM = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> khs = new HashMap();
    private List<com.baidu.tieba.n.b> khr = new ArrayList();
    private long kht = 0;
    private long khu = 0;
    private long khv = 0;
    private ArrayList<Integer> khz = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.bMb = 0;
        this.bMb = 0;
        this.akY = str;
        this.mVideoUrl = str2;
        this.khp = str3;
        cRo();
    }

    @Override // com.baidu.tieba.k.i
    public void cRg() {
        this.kht = System.currentTimeMillis();
        this.khr.add(new com.baidu.tieba.n.a(3));
        this.bMb = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void rU(boolean z) {
        this.khA = z;
        this.khr.add(new com.baidu.tieba.n.a(1));
        this.bMb = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void ai(boolean z, boolean z2) {
        this.khL = z;
        this.khM = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void De(int i) {
        if (this.bMb != 4 && this.bMb != 5 && this.bMb != 7 && this.bMb != 8) {
            this.khq = i;
            this.khB = true;
            long currentTimeMillis = System.currentTimeMillis() - this.kht;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.khs.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.kht = 0L;
            this.khr.add(new com.baidu.tieba.n.a(102));
            this.bMb = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Df(int i) {
        if (this.bMb != 4 && this.bMb != 5 && this.bMb != 7 && this.bMb != 8) {
            this.khq = i;
            this.khB = true;
            this.khC = true;
            this.khs.put("loadingTime", 1L);
            this.kht = 0L;
            this.khr.add(new com.baidu.tieba.n.a(103));
            this.bMb = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Dg(int i) {
        if (this.bMb == 5) {
            cRi();
        } else if (this.bMb == 3) {
            this.khq = i;
            this.khu = System.currentTimeMillis();
            this.khr.add(new com.baidu.tieba.n.a(200));
            this.bMb = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void t(long j, int i) {
        this.khw++;
        this.khx += j;
        this.khz.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cRh() {
        if (this.bMb == 4 || this.bMb == 3) {
            if (this.khu != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.khv = (currentTimeMillis - this.khu) + this.khv;
                this.khu = 0L;
            }
            this.khr.add(new com.baidu.tieba.n.a(203));
            this.bMb = 5;
        }
    }

    public void cRi() {
        if (this.bMb == 5) {
            this.khu = System.currentTimeMillis();
            this.khr.add(new com.baidu.tieba.n.a(204));
            this.bMb = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void MG(String str) {
        if (this.bMb != 8 && this.bMb != 7 && this.bMb != 6 && this.bMb != -1) {
            this.mSource = VideoPlatformStatic.Dg(str);
            cRj();
            this.khr.add(new com.baidu.tieba.n.a(205));
            this.bMb = 8;
            ama();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String MH(String str) {
        if (this.bMb == 8 || this.bMb == 7 || this.bMb == 6 || this.bMb == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Dg(str);
        cRj();
        this.khs.put("stallDuration", Long.valueOf(this.khx));
        this.khr.add(new com.baidu.tieba.n.a(206));
        this.bMb = 6;
        ama();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean MI(String str) {
        if (this.bMb == 8 || this.bMb == 7 || this.bMb == 6 || this.bMb == -1 || this.bMb == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Dg(str);
        cRj();
        this.khr.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.bMb = 7;
        ama();
        return true;
    }

    private void cRj() {
        if (this.khu != 0) {
            this.khv += System.currentTimeMillis() - this.khu;
        }
        this.khs.put("playDuration", Long.valueOf(this.khv));
        this.khs.put("stallCount", Long.valueOf(this.khw));
        this.khs.put("stallDuration", Long.valueOf(this.khx));
        if (!this.khs.containsKey("loadingTime")) {
            this.khs.put("loadingTime", 0L);
        }
        this.kht = 0L;
        this.khu = 0L;
        this.khv = 0L;
        this.khw = 0L;
        this.khx = 0L;
        this.khy = 0L;
    }

    public void ama() {
        if (!this.khE) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bpo() || !this.khB) && reportType != 3) {
                this.khE = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bAw());
                            jSONObject.put("kpiInfo", j.this.cRk());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.khB)) {
                                JSONObject cRm = j.this.cRm();
                                cRm.put("running", j.this.cRn());
                                jSONObject.put("debugInfo", cRm);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cRm());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dAx().g(jSONObject, j.this.khB ? false : true);
                        if (j.this.khG != null) {
                            j.this.khG.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bAw() {
        JSONObject bAw = VideoPlatformStatic.bAw();
        if (this.khG != null) {
            try {
                int size = this.khG.size();
                for (int i = 0; i < size; i++) {
                    this.khG.get(i).dT(bAw);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bAw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cRk() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.khs.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.khs.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.khs.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.khs.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.khs.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.khA ? 1 : 0);
            jSONObject.put("playSuccess", this.khB ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cRl());
            jSONObject.put("retryError", this.khD ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.khG != null) {
                int size = this.khG.size();
                for (int i = 0; i < size; i++) {
                    this.khG.get(i).dU(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cRl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.khI);
            jSONObject.put("startTime", this.khJ);
            jSONObject.put("totalTime", this.khK);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cRo();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cRm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.khp)) {
                jSONObject.put("parentUuid", this.khp);
            }
            jSONObject.put("tid", this.akY);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.rW(this.khq));
            jSONObject.put("urlType", this.dXD);
            jSONObject.put("sub_error", this.khH);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.khC ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.khz);
            jSONObject.put("pcdn_used", this.khL ? "1" : "0");
            jSONObject.put("p2p_used", this.khM ? "1" : "0");
            if (!StringUtils.isNull(this.khF)) {
                jSONObject.put("error_stack", this.khF);
            }
            if (this.khG != null) {
                int size = this.khG.size();
                for (int i = 0; i < size; i++) {
                    this.khG.get(i).dV(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cRn() {
        JSONArray jSONArray = new JSONArray();
        if (this.khr == null) {
            return jSONArray;
        }
        int size = this.khr.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.khr.get(i).dkP());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.khI = j;
        this.khJ = j2;
        this.khK = j3;
    }

    private void cRo() {
        this.khI = 0L;
        this.khJ = 0L;
        this.khK = 0L;
    }
}
