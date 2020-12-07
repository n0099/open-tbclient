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
    private boolean llB;
    private String llC;
    private List<b> llD;
    private int llE;
    private long llF;
    private long llG;
    private long llH;
    private String llm;
    private int lln;
    private long llt;
    private long llu;
    private long llv;
    private boolean llx;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean lly = true;
    private boolean llz = false;
    private boolean llA = false;
    private boolean llI = false;
    private boolean llJ = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> llp = new HashMap();
    private List<com.baidu.tieba.o.b> llo = new ArrayList();
    private long llq = 0;
    private long llr = 0;
    private long lls = 0;
    private ArrayList<Integer> llw = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.cnU = 0;
        this.cnU = 0;
        this.amY = str;
        this.mVideoUrl = str2;
        this.llm = str3;
        diW();
    }

    @Override // com.baidu.tieba.l.i
    public void diO() {
        this.llq = System.currentTimeMillis();
        this.llo.add(new com.baidu.tieba.o.a(3));
        this.cnU = 0;
    }

    @Override // com.baidu.tieba.l.i
    public void tQ(boolean z) {
        this.llx = z;
        this.llo.add(new com.baidu.tieba.o.a(1));
        this.cnU = 1;
    }

    @Override // com.baidu.tieba.l.i
    public void am(boolean z, boolean z2) {
        this.llI = z;
        this.llJ = z2;
    }

    @Override // com.baidu.tieba.l.i
    public void Ge(int i) {
        if (this.cnU != 4 && this.cnU != 5 && this.cnU != 7 && this.cnU != 8) {
            this.lln = i;
            this.lly = true;
            long currentTimeMillis = System.currentTimeMillis() - this.llq;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.llp.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.llq = 0L;
            this.llo.add(new com.baidu.tieba.o.a(102));
            this.cnU = 3;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Gf(int i) {
        if (this.cnU != 4 && this.cnU != 5 && this.cnU != 7 && this.cnU != 8) {
            this.lln = i;
            this.lly = true;
            this.llz = true;
            this.llp.put("loadingTime", 1L);
            this.llq = 0L;
            this.llo.add(new com.baidu.tieba.o.a(103));
            this.cnU = 3;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Gg(int i) {
        if (this.cnU == 5) {
            diQ();
        } else if (this.cnU == 3) {
            this.lln = i;
            this.llr = System.currentTimeMillis();
            this.llo.add(new com.baidu.tieba.o.a(200));
            this.cnU = 4;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void G(long j, int i) {
        this.llt++;
        this.llu += j;
        this.llw.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.i
    public void diP() {
        if (this.cnU == 4 || this.cnU == 3) {
            if (this.llr != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.lls = (currentTimeMillis - this.llr) + this.lls;
                this.llr = 0L;
            }
            this.llo.add(new com.baidu.tieba.o.a(203));
            this.cnU = 5;
        }
    }

    public void diQ() {
        if (this.cnU == 5) {
            this.llr = System.currentTimeMillis();
            this.llo.add(new com.baidu.tieba.o.a(204));
            this.cnU = 4;
        }
    }

    @Override // com.baidu.tieba.l.i
    public void Pq(String str) {
        if (this.cnU != 8 && this.cnU != 7 && this.cnU != 6 && this.cnU != -1) {
            this.mSource = VideoPlatformStatic.Fl(str);
            diR();
            this.llo.add(new com.baidu.tieba.o.a(205));
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
        diR();
        this.llp.put("stallDuration", Long.valueOf(this.llu));
        this.llo.add(new com.baidu.tieba.o.a(206));
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
        diR();
        this.llo.add(new com.baidu.tieba.o.a(207));
        this.cnU = 7;
        awr();
        return true;
    }

    private void diR() {
        if (this.llr != 0) {
            this.lls += System.currentTimeMillis() - this.llr;
        }
        this.llp.put("playDuration", Long.valueOf(this.lls));
        this.llp.put("stallCount", Long.valueOf(this.llt));
        this.llp.put("stallDuration", Long.valueOf(this.llu));
        if (!this.llp.containsKey("loadingTime")) {
            this.llp.put("loadingTime", 0L);
        }
        this.llq = 0L;
        this.llr = 0L;
        this.lls = 0L;
        this.llt = 0L;
        this.llu = 0L;
        this.llv = 0L;
    }

    public void awr() {
        if (!this.llB) {
            int reportType = com.baidu.tbadk.coreExtra.model.g.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.g.bAc() || !this.lly) && reportType != 3) {
                this.llB = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.g.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bLP());
                            jSONObject.put("kpiInfo", j.this.diS());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.lly)) {
                                JSONObject diU = j.this.diU();
                                diU.put("running", j.this.diV());
                                jSONObject.put("debugInfo", diU);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.diU());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.v.e.dTn().g(jSONObject, j.this.lly ? false : true);
                        if (j.this.llD != null) {
                            j.this.llD.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bLP() {
        JSONObject bLP = VideoPlatformStatic.bLP();
        if (this.llD != null) {
            try {
                int size = this.llD.size();
                for (int i = 0; i < size; i++) {
                    this.llD.get(i).en(bLP);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bLP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject diS() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.llp.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.llp.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.llp.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.llp.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.llp.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.llx ? 1 : 0);
            jSONObject.put("playSuccess", this.lly ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", diT());
            jSONObject.put("retryError", this.llA ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.llD != null) {
                int size = this.llD.size();
                for (int i = 0; i < size; i++) {
                    this.llD.get(i).eo(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject diT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.llF);
            jSONObject.put("startTime", this.llG);
            jSONObject.put("totalTime", this.llH);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        diW();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject diU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.llm)) {
                jSONObject.put("parentUuid", this.llm);
            }
            jSONObject.put("tid", this.amY);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.uj(this.lln));
            jSONObject.put("urlType", this.eFC);
            jSONObject.put("sub_error", this.llE);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.llz ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.llw);
            jSONObject.put("pcdn_used", this.llI ? "1" : "0");
            jSONObject.put("p2p_used", this.llJ ? "1" : "0");
            if (!StringUtils.isNull(this.llC)) {
                jSONObject.put("error_stack", this.llC);
            }
            if (this.llD != null) {
                int size = this.llD.size();
                for (int i = 0; i < size; i++) {
                    this.llD.get(i).ep(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray diV() {
        JSONArray jSONArray = new JSONArray();
        if (this.llo == null) {
            return jSONArray;
        }
        int size = this.llo.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.llo.get(i).dCK());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.i
    public void h(long j, long j2, long j3) {
        this.llF = j;
        this.llG = j2;
        this.llH = j3;
    }

    private void diW() {
        this.llF = 0L;
        this.llG = 0L;
        this.llH = 0L;
    }
}
