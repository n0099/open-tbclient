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
/* loaded from: classes23.dex */
public class j implements i {
    private String amY;
    private int cnU;
    private int eFC;
    private boolean llD;
    private String llE;
    private List<b> llF;
    private int llG;
    private long llH;
    private long llI;
    private long llJ;
    private String llo;
    private int llp;
    private long llv;
    private long llw;
    private long llx;
    private boolean llz;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean llA = true;
    private boolean llB = false;
    private boolean llC = false;
    private boolean llK = false;
    private boolean llL = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> llr = new HashMap();
    private List<com.baidu.tieba.o.b> llq = new ArrayList();
    private long lls = 0;
    private long llt = 0;
    private long llu = 0;
    private ArrayList<Integer> lly = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.cnU = 0;
        this.cnU = 0;
        this.amY = str;
        this.mVideoUrl = str2;
        this.llo = str3;
        diX();
    }

    @Override // com.baidu.tieba.l.i
    public void diP() {
        this.lls = System.currentTimeMillis();
        this.llq.add(new com.baidu.tieba.o.a(3));
        this.cnU = 0;
    }

    @Override // com.baidu.tieba.l.i
    public void tQ(boolean z) {
        this.llz = z;
        this.llq.add(new com.baidu.tieba.o.a(1));
        this.cnU = 1;
    }

    @Override // com.baidu.tieba.l.i
    public void am(boolean z, boolean z2) {
        this.llK = z;
        this.llL = z2;
    }

    @Override // com.baidu.tieba.l.i
    public void Ge(int i) {
        if (this.cnU != 4 && this.cnU != 5 && this.cnU != 7 && this.cnU != 8) {
            this.llp = i;
            this.llA = true;
            long currentTimeMillis = System.currentTimeMillis() - this.lls;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.llr.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.lls = 0L;
            this.llq.add(new com.baidu.tieba.o.a(102));
            this.cnU = 3;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Gf(int i) {
        if (this.cnU != 4 && this.cnU != 5 && this.cnU != 7 && this.cnU != 8) {
            this.llp = i;
            this.llA = true;
            this.llB = true;
            this.llr.put("loadingTime", 1L);
            this.lls = 0L;
            this.llq.add(new com.baidu.tieba.o.a(103));
            this.cnU = 3;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Gg(int i) {
        if (this.cnU == 5) {
            diR();
        } else if (this.cnU == 3) {
            this.llp = i;
            this.llt = System.currentTimeMillis();
            this.llq.add(new com.baidu.tieba.o.a(200));
            this.cnU = 4;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void G(long j, int i) {
        this.llv++;
        this.llw += j;
        this.lly.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.i
    public void diQ() {
        if (this.cnU == 4 || this.cnU == 3) {
            if (this.llt != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.llu = (currentTimeMillis - this.llt) + this.llu;
                this.llt = 0L;
            }
            this.llq.add(new com.baidu.tieba.o.a(203));
            this.cnU = 5;
        }
    }

    public void diR() {
        if (this.cnU == 5) {
            this.llt = System.currentTimeMillis();
            this.llq.add(new com.baidu.tieba.o.a(204));
            this.cnU = 4;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Pq(String str) {
        if (this.cnU != 8 && this.cnU != 7 && this.cnU != 6 && this.cnU != -1) {
            this.mSource = VideoPlatformStatic.Fl(str);
            diS();
            this.llq.add(new com.baidu.tieba.o.a(205));
            this.cnU = 8;
            awr();
        }
    }

    @Override // com.baidu.tieba.l.i
    public String Pr(String str) {
        if (this.cnU == 8 || this.cnU == 7 || this.cnU == 6 || this.cnU == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Fl(str);
        diS();
        this.llr.put("stallDuration", Long.valueOf(this.llw));
        this.llq.add(new com.baidu.tieba.o.a(206));
        this.cnU = 6;
        awr();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.l.i
    public boolean Ps(String str) {
        if (this.cnU == 8 || this.cnU == 7 || this.cnU == 6 || this.cnU == -1 || this.cnU == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Fl(str);
        diS();
        this.llq.add(new com.baidu.tieba.o.a(207));
        this.cnU = 7;
        awr();
        return true;
    }

    private void diS() {
        if (this.llt != 0) {
            this.llu += System.currentTimeMillis() - this.llt;
        }
        this.llr.put("playDuration", Long.valueOf(this.llu));
        this.llr.put("stallCount", Long.valueOf(this.llv));
        this.llr.put("stallDuration", Long.valueOf(this.llw));
        if (!this.llr.containsKey("loadingTime")) {
            this.llr.put("loadingTime", 0L);
        }
        this.lls = 0L;
        this.llt = 0L;
        this.llu = 0L;
        this.llv = 0L;
        this.llw = 0L;
        this.llx = 0L;
    }

    public void awr() {
        if (!this.llD) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bAc() || !this.llA) && reportType != 3) {
                this.llD = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bLQ());
                            jSONObject.put("kpiInfo", j.this.diT());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.llA)) {
                                JSONObject diV = j.this.diV();
                                diV.put("running", j.this.diW());
                                jSONObject.put("debugInfo", diV);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.diV());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.v.e.dTo().g(jSONObject, j.this.llA ? false : true);
                        if (j.this.llF != null) {
                            j.this.llF.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bLQ() {
        JSONObject bLQ = VideoPlatformStatic.bLQ();
        if (this.llF != null) {
            try {
                int size = this.llF.size();
                for (int i = 0; i < size; i++) {
                    this.llF.get(i).en(bLQ);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bLQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject diT() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.llr.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.llr.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.llr.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.llr.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.llr.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.llz ? 1 : 0);
            jSONObject.put("playSuccess", this.llA ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", diU());
            jSONObject.put("retryError", this.llC ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.llF != null) {
                int size = this.llF.size();
                for (int i = 0; i < size; i++) {
                    this.llF.get(i).eo(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject diU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.llH);
            jSONObject.put("startTime", this.llI);
            jSONObject.put("totalTime", this.llJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        diX();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject diV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.llo)) {
                jSONObject.put("parentUuid", this.llo);
            }
            jSONObject.put("tid", this.amY);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.uj(this.llp));
            jSONObject.put("urlType", this.eFC);
            jSONObject.put("sub_error", this.llG);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.llB ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.lly);
            jSONObject.put("pcdn_used", this.llK ? "1" : "0");
            jSONObject.put("p2p_used", this.llL ? "1" : "0");
            if (!StringUtils.isNull(this.llE)) {
                jSONObject.put("error_stack", this.llE);
            }
            if (this.llF != null) {
                int size = this.llF.size();
                for (int i = 0; i < size; i++) {
                    this.llF.get(i).ep(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray diW() {
        JSONArray jSONArray = new JSONArray();
        if (this.llq == null) {
            return jSONArray;
        }
        int size = this.llq.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.llq.get(i).dCL());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.i
    public void h(long j, long j2, long j3) {
        this.llH = j;
        this.llI = j2;
        this.llJ = j3;
    }

    private void diX() {
        this.llH = 0L;
        this.llI = 0L;
        this.llJ = 0L;
    }
}
