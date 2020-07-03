package com.baidu.tieba.k;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes10.dex */
public class j implements i {
    private String ajO;
    private boolean jJB;
    private boolean jJF;
    private String jJG;
    private List<b> jJH;
    private int jJI;
    private long jJJ;
    private long jJK;
    private long jJL;
    private String jJm;
    private int jJn;
    private int jJo;
    private com.baidu.tieba.k.a.b jJr;
    private com.baidu.tieba.k.a.d jJs;
    private List<com.baidu.tieba.k.a.c> jJt;
    private long jJx;
    private long jJy;
    private long jJz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean jJC = true;
    private boolean jJD = false;
    private boolean jJE = false;
    private boolean jJM = false;
    private boolean jJN = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> jJq = new HashMap();
    private List<com.baidu.tieba.n.c> jJp = new ArrayList();
    private long jJu = 0;
    private long jJv = 0;
    private long jJw = 0;
    private ArrayList<Integer> jJA = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ajO = str;
        this.mVideoUrl = str2;
        this.jJm = str3;
        cCK();
    }

    @Override // com.baidu.tieba.k.i
    public void cCv() {
        this.jJu = System.currentTimeMillis();
        this.jJp.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void IZ(String str) {
        Je(str);
        this.jJp.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void qH(boolean z) {
        this.jJB = z;
        this.jJp.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void Je(String str) {
        if (!StringUtils.isNull(str)) {
            this.jJo = VideoPlatformStatic.Aa(str);
            if (this.jJo != 0) {
                this.jJB = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cCw() {
        this.jJp.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void cCx() {
        if (this.mCurrentState != 2) {
            this.jJu = System.currentTimeMillis();
            this.jJp.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void ad(boolean z, boolean z2) {
        this.jJM = z;
        this.jJN = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.jJu = System.currentTimeMillis();
        Je(str);
        this.jJp.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void Am(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jJn = i;
            this.jJC = true;
            long currentTimeMillis = System.currentTimeMillis() - this.jJu;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.jJq.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.jJu = 0L;
            this.jJp.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void An(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jJn = i;
            this.jJC = true;
            this.jJD = true;
            this.jJq.put("loadingTime", 1L);
            this.jJu = 0L;
            this.jJp.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Ao(int i) {
        if (this.mCurrentState == 5) {
            cCD();
        } else if (this.mCurrentState == 3) {
            this.jJn = i;
            this.jJv = System.currentTimeMillis();
            this.jJp.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cCy() {
        if (this.jJv != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.jJw += currentTimeMillis - this.jJv;
            this.jJv = currentTimeMillis;
        }
        this.jJx++;
        this.jJz = System.currentTimeMillis();
        this.jJp.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void cCz() {
        this.jJv = System.currentTimeMillis();
        if (this.jJz != 0) {
            this.jJy += System.currentTimeMillis() - this.jJz;
        }
        this.jJp.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void s(long j, int i) {
        this.jJx++;
        this.jJy += j;
        this.jJA.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cCA() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.jJv != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.jJw = (currentTimeMillis - this.jJv) + this.jJw;
                this.jJv = 0L;
            }
            this.jJp.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cCD() {
        if (this.mCurrentState == 5) {
            this.jJv = System.currentTimeMillis();
            this.jJp.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Ja(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.Ab(str);
            cCF();
            this.jJp.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            ait();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Jb(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Ab(str);
        cCF();
        this.jJq.put("stallDuration", Long.valueOf(this.jJy));
        this.jJp.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        ait();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Jc(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Ab(str);
        cCF();
        this.jJp.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        ait();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.jJs == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jJs = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.jJs);
            }
            if (this.jJs != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.jJs.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.bcP())) {
            if (this.jJr == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jJr = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.jJr);
            }
            if (this.jJr != null) {
                if (this.jJr.size() == 0) {
                    this.jJI = i2;
                }
                this.jJr.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.jJt == null) {
            this.jJt = new ArrayList();
        }
        this.jJt.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.jJn = i;
        this.jJC = false;
        this.jJE = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.Ab(str);
        cCF();
        if (!w.isEmpty(this.jJt)) {
            int size = this.jJt.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.jJt.get(i4);
                if (cVar != null) {
                    cVar.cCU();
                }
            }
        }
        this.jJp.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, cCE()));
        this.mCurrentState = -1;
        ait();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] cCE() {
        if (this.jJt == null || this.jJt.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.jJt.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jJt.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.jJt.get(i2).cCS();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Jd(String str) {
        this.jJG = str;
    }

    private void cCF() {
        if (this.jJv != 0) {
            this.jJw += System.currentTimeMillis() - this.jJv;
        }
        this.jJq.put("playDuration", Long.valueOf(this.jJw));
        this.jJq.put("stallCount", Long.valueOf(this.jJx));
        this.jJq.put("stallDuration", Long.valueOf(this.jJy));
        if (!this.jJq.containsKey("loadingTime")) {
            this.jJq.put("loadingTime", 0L);
        }
        this.jJu = 0L;
        this.jJv = 0L;
        this.jJw = 0L;
        this.jJx = 0L;
        this.jJy = 0L;
        this.jJz = 0L;
    }

    public void ait() {
        if (!this.jJF) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.bcK() || !this.jJC) && reportType != 3) {
                this.jJF = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bow());
                            jSONObject.put("kpiInfo", j.this.cCG());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.jJC)) {
                                JSONObject cCI = j.this.cCI();
                                cCI.put("running", j.this.cCJ());
                                jSONObject.put("debugInfo", cCI);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cCI());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dlO().g(jSONObject, j.this.jJC ? false : true);
                        if (j.this.jJH != null) {
                            j.this.jJH.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bow() {
        JSONObject bow = VideoPlatformStatic.bow();
        if (this.jJH != null) {
            try {
                int size = this.jJH.size();
                for (int i = 0; i < size; i++) {
                    this.jJH.get(i).dB(bow);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cCG() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.jJq.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.jJq.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.jJq.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.jJq.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.jJq.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.jJB ? 1 : 0);
            jSONObject.put("playSuccess", this.jJC ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cCH());
            jSONObject.put("retryError", this.jJE ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.jJH != null) {
                int size = this.jJH.size();
                for (int i = 0; i < size; i++) {
                    this.jJH.get(i).dC(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cCH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.jJJ);
            jSONObject.put("startTime", this.jJK);
            jSONObject.put("totalTime", this.jJL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cCK();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cCI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.jJm)) {
                jSONObject.put("parentUuid", this.jJm);
            }
            jSONObject.put("tid", this.ajO);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.pw(this.jJn));
            jSONObject.put("urlType", this.jJo);
            jSONObject.put("sub_error", this.jJI);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.jJD ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.jJA);
            jSONObject.put("pcdn_used", this.jJM ? "1" : "0");
            jSONObject.put("p2p_used", this.jJN ? "1" : "0");
            if (!StringUtils.isNull(this.jJG)) {
                jSONObject.put("error_stack", this.jJG);
            }
            if (this.jJH != null) {
                int size = this.jJH.size();
                for (int i = 0; i < size; i++) {
                    this.jJH.get(i).dD(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cCJ() {
        JSONArray jSONArray = new JSONArray();
        if (this.jJp == null) {
            return jSONArray;
        }
        int size = this.jJp.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.jJp.get(i).cWx());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.jJH == null) {
            this.jJH = new ArrayList();
        }
        this.jJH.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void qI(boolean z) {
        this.jJC = z;
    }

    @Override // com.baidu.tieba.k.i
    public String cCB() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String cCC() {
        return this.jJI + "";
    }

    @Override // com.baidu.tieba.k.i
    public void h(long j, long j2, long j3) {
        this.jJJ = j;
        this.jJK = j2;
        this.jJL = j3;
    }

    private void cCK() {
        this.jJJ = 0L;
        this.jJK = 0L;
        this.jJL = 0L;
    }
}
