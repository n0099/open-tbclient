package com.baidu.tieba.k;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.v;
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
    private String ahL;
    private String jbI;
    private int jbJ;
    private int jbK;
    private com.baidu.tieba.k.a.b jbN;
    private com.baidu.tieba.k.a.d jbO;
    private List<com.baidu.tieba.k.a.c> jbP;
    private long jbT;
    private long jbU;
    private long jbV;
    private boolean jbX;
    private boolean jcb;
    private String jcc;
    private List<b> jcd;
    private int jce;
    private long jcf;
    private long jcg;
    private long jch;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean jbY = true;
    private boolean jbZ = false;
    private boolean jca = false;
    private boolean jci = false;
    private boolean jcj = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> jbM = new HashMap();
    private List<com.baidu.tieba.n.c> jbL = new ArrayList();
    private long jbQ = 0;
    private long jbR = 0;
    private long jbS = 0;
    private ArrayList<Integer> jbW = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ahL = str;
        this.mVideoUrl = str2;
        this.jbI = str3;
        crV();
    }

    @Override // com.baidu.tieba.k.i
    public void crG() {
        this.jbQ = System.currentTimeMillis();
        this.jbL.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void GK(String str) {
        GP(str);
        this.jbL.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void qa(boolean z) {
        this.jbX = z;
        this.jbL.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void GP(String str) {
        if (!StringUtils.isNull(str)) {
            this.jbK = VideoPlatformStatic.xY(str);
            if (this.jbK != 0) {
                this.jbX = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void crH() {
        this.jbL.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void crI() {
        if (this.mCurrentState != 2) {
            this.jbQ = System.currentTimeMillis();
            this.jbL.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Z(boolean z, boolean z2) {
        this.jci = z;
        this.jcj = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.jbQ = System.currentTimeMillis();
        GP(str);
        this.jbL.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void yQ(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jbJ = i;
            this.jbY = true;
            long currentTimeMillis = System.currentTimeMillis() - this.jbQ;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.jbM.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.jbQ = 0L;
            this.jbL.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yR(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jbJ = i;
            this.jbY = true;
            this.jbZ = true;
            this.jbM.put("loadingTime", 1L);
            this.jbQ = 0L;
            this.jbL.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yS(int i) {
        if (this.mCurrentState == 5) {
            crO();
        } else if (this.mCurrentState == 3) {
            this.jbJ = i;
            this.jbR = System.currentTimeMillis();
            this.jbL.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void crJ() {
        if (this.jbR != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.jbS += currentTimeMillis - this.jbR;
            this.jbR = currentTimeMillis;
        }
        this.jbT++;
        this.jbV = System.currentTimeMillis();
        this.jbL.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void crK() {
        this.jbR = System.currentTimeMillis();
        if (this.jbV != 0) {
            this.jbU += System.currentTimeMillis() - this.jbV;
        }
        this.jbL.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void s(long j, int i) {
        this.jbT++;
        this.jbU += j;
        this.jbW.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void crL() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.jbR != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.jbS = (currentTimeMillis - this.jbR) + this.jbS;
                this.jbR = 0L;
            }
            this.jbL.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void crO() {
        if (this.mCurrentState == 5) {
            this.jbR = System.currentTimeMillis();
            this.jbL.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void GL(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.xZ(str);
            crQ();
            this.jbL.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            aee();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String GM(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.xZ(str);
        crQ();
        this.jbM.put("stallDuration", Long.valueOf(this.jbU));
        this.jbL.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        aee();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean GN(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.xZ(str);
        crQ();
        this.jbL.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aee();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.jbO == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jbO = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.jbO);
            }
            if (this.jbO != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.jbO.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aUE())) {
            if (this.jbN == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jbN = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.jbN);
            }
            if (this.jbN != null) {
                if (this.jbN.size() == 0) {
                    this.jce = i2;
                }
                this.jbN.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.jbP == null) {
            this.jbP = new ArrayList();
        }
        this.jbP.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.jbJ = i;
        this.jbY = false;
        this.jca = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.xZ(str);
        crQ();
        if (!v.isEmpty(this.jbP)) {
            int size = this.jbP.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.jbP.get(i4);
                if (cVar != null) {
                    cVar.csf();
                }
            }
        }
        this.jbL.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, crP()));
        this.mCurrentState = -1;
        aee();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] crP() {
        if (this.jbP == null || this.jbP.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.jbP.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jbP.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.jbP.get(i2).csd();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void GO(String str) {
        this.jcc = str;
    }

    private void crQ() {
        if (this.jbR != 0) {
            this.jbS += System.currentTimeMillis() - this.jbR;
        }
        this.jbM.put("playDuration", Long.valueOf(this.jbS));
        this.jbM.put("stallCount", Long.valueOf(this.jbT));
        this.jbM.put("stallDuration", Long.valueOf(this.jbU));
        if (!this.jbM.containsKey("loadingTime")) {
            this.jbM.put("loadingTime", 0L);
        }
        this.jbQ = 0L;
        this.jbR = 0L;
        this.jbS = 0L;
        this.jbT = 0L;
        this.jbU = 0L;
        this.jbV = 0L;
    }

    public void aee() {
        if (!this.jcb) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aUz() || !this.jbY) && reportType != 3) {
                this.jcb = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bfL());
                            jSONObject.put("kpiInfo", j.this.crR());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.jbY)) {
                                JSONObject crT = j.this.crT();
                                crT.put("running", j.this.crU());
                                jSONObject.put("debugInfo", crT);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.crT());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.daf().e(jSONObject, j.this.jbY ? false : true);
                        if (j.this.jcd != null) {
                            j.this.jcd.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bfL() {
        JSONObject bfL = VideoPlatformStatic.bfL();
        if (this.jcd != null) {
            try {
                int size = this.jcd.size();
                for (int i = 0; i < size; i++) {
                    this.jcd.get(i).dk(bfL);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bfL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject crR() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.jbM.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.jbM.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.jbM.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.jbM.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.jbM.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.jbX ? 1 : 0);
            jSONObject.put("playSuccess", this.jbY ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", crS());
            jSONObject.put("retryError", this.jca ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.jcd != null) {
                int size = this.jcd.size();
                for (int i = 0; i < size; i++) {
                    this.jcd.get(i).dl(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject crS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.jcf);
            jSONObject.put("startTime", this.jcg);
            jSONObject.put("totalTime", this.jch);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        crV();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject crT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.jbI)) {
                jSONObject.put("parentUuid", this.jbI);
            }
            jSONObject.put("tid", this.ahL);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.oo(this.jbJ));
            jSONObject.put("urlType", this.jbK);
            jSONObject.put("sub_error", this.jce);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.jbZ ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.jbW);
            jSONObject.put("pcdn_used", this.jci ? "1" : "0");
            jSONObject.put("p2p_used", this.jcj ? "1" : "0");
            if (!StringUtils.isNull(this.jcc)) {
                jSONObject.put("error_stack", this.jcc);
            }
            if (this.jcd != null) {
                int size = this.jcd.size();
                for (int i = 0; i < size; i++) {
                    this.jcd.get(i).dm(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray crU() {
        JSONArray jSONArray = new JSONArray();
        if (this.jbL == null) {
            return jSONArray;
        }
        int size = this.jbL.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.jbL.get(i).cKT());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.jcd == null) {
            this.jcd = new ArrayList();
        }
        this.jcd.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void qb(boolean z) {
        this.jbY = z;
    }

    @Override // com.baidu.tieba.k.i
    public String crM() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String crN() {
        return this.jce + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.jcf = j;
        this.jcg = j2;
        this.jch = j3;
    }

    private void crV() {
        this.jcf = 0L;
        this.jcg = 0L;
        this.jch = 0L;
    }
}
