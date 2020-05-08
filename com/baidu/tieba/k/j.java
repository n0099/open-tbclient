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
    private String ahO;
    private String jbM;
    private int jbN;
    private int jbO;
    private com.baidu.tieba.k.a.b jbR;
    private com.baidu.tieba.k.a.d jbS;
    private List<com.baidu.tieba.k.a.c> jbT;
    private long jbX;
    private long jbY;
    private long jbZ;
    private boolean jcb;
    private boolean jcf;
    private String jcg;
    private List<b> jch;
    private int jci;
    private long jcj;
    private long jck;
    private long jcl;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean jcc = true;
    private boolean jcd = false;
    private boolean jce = false;
    private boolean jcm = false;
    private boolean jcn = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> jbQ = new HashMap();
    private List<com.baidu.tieba.n.c> jbP = new ArrayList();
    private long jbU = 0;
    private long jbV = 0;
    private long jbW = 0;
    private ArrayList<Integer> jca = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ahO = str;
        this.mVideoUrl = str2;
        this.jbM = str3;
        crS();
    }

    @Override // com.baidu.tieba.k.i
    public void crD() {
        this.jbU = System.currentTimeMillis();
        this.jbP.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void GN(String str) {
        GS(str);
        this.jbP.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void qa(boolean z) {
        this.jcb = z;
        this.jbP.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void GS(String str) {
        if (!StringUtils.isNull(str)) {
            this.jbO = VideoPlatformStatic.yb(str);
            if (this.jbO != 0) {
                this.jcb = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void crE() {
        this.jbP.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void crF() {
        if (this.mCurrentState != 2) {
            this.jbU = System.currentTimeMillis();
            this.jbP.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Z(boolean z, boolean z2) {
        this.jcm = z;
        this.jcn = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.jbU = System.currentTimeMillis();
        GS(str);
        this.jbP.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void yQ(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jbN = i;
            this.jcc = true;
            long currentTimeMillis = System.currentTimeMillis() - this.jbU;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.jbQ.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.jbU = 0L;
            this.jbP.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yR(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jbN = i;
            this.jcc = true;
            this.jcd = true;
            this.jbQ.put("loadingTime", 1L);
            this.jbU = 0L;
            this.jbP.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yS(int i) {
        if (this.mCurrentState == 5) {
            crL();
        } else if (this.mCurrentState == 3) {
            this.jbN = i;
            this.jbV = System.currentTimeMillis();
            this.jbP.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void crG() {
        if (this.jbV != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.jbW += currentTimeMillis - this.jbV;
            this.jbV = currentTimeMillis;
        }
        this.jbX++;
        this.jbZ = System.currentTimeMillis();
        this.jbP.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void crH() {
        this.jbV = System.currentTimeMillis();
        if (this.jbZ != 0) {
            this.jbY += System.currentTimeMillis() - this.jbZ;
        }
        this.jbP.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void s(long j, int i) {
        this.jbX++;
        this.jbY += j;
        this.jca.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void crI() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.jbV != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.jbW = (currentTimeMillis - this.jbV) + this.jbW;
                this.jbV = 0L;
            }
            this.jbP.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void crL() {
        if (this.mCurrentState == 5) {
            this.jbV = System.currentTimeMillis();
            this.jbP.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void GO(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.yc(str);
            crN();
            this.jbP.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            aed();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String GP(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.yc(str);
        crN();
        this.jbQ.put("stallDuration", Long.valueOf(this.jbY));
        this.jbP.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        aed();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean GQ(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.yc(str);
        crN();
        this.jbP.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aed();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.jbS == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jbS = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.jbS);
            }
            if (this.jbS != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.jbS.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aUC())) {
            if (this.jbR == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jbR = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.jbR);
            }
            if (this.jbR != null) {
                if (this.jbR.size() == 0) {
                    this.jci = i2;
                }
                this.jbR.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.jbT == null) {
            this.jbT = new ArrayList();
        }
        this.jbT.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.jbN = i;
        this.jcc = false;
        this.jce = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.yc(str);
        crN();
        if (!v.isEmpty(this.jbT)) {
            int size = this.jbT.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.jbT.get(i4);
                if (cVar != null) {
                    cVar.csc();
                }
            }
        }
        this.jbP.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, crM()));
        this.mCurrentState = -1;
        aed();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] crM() {
        if (this.jbT == null || this.jbT.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.jbT.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jbT.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.jbT.get(i2).csa();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void GR(String str) {
        this.jcg = str;
    }

    private void crN() {
        if (this.jbV != 0) {
            this.jbW += System.currentTimeMillis() - this.jbV;
        }
        this.jbQ.put("playDuration", Long.valueOf(this.jbW));
        this.jbQ.put("stallCount", Long.valueOf(this.jbX));
        this.jbQ.put("stallDuration", Long.valueOf(this.jbY));
        if (!this.jbQ.containsKey("loadingTime")) {
            this.jbQ.put("loadingTime", 0L);
        }
        this.jbU = 0L;
        this.jbV = 0L;
        this.jbW = 0L;
        this.jbX = 0L;
        this.jbY = 0L;
        this.jbZ = 0L;
    }

    public void aed() {
        if (!this.jcf) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aUx() || !this.jcc) && reportType != 3) {
                this.jcf = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.bfJ());
                            jSONObject.put("kpiInfo", j.this.crO());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.jcc)) {
                                JSONObject crQ = j.this.crQ();
                                crQ.put("running", j.this.crR());
                                jSONObject.put("debugInfo", crQ);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.crQ());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dac().e(jSONObject, j.this.jcc ? false : true);
                        if (j.this.jch != null) {
                            j.this.jch.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bfJ() {
        JSONObject bfJ = VideoPlatformStatic.bfJ();
        if (this.jch != null) {
            try {
                int size = this.jch.size();
                for (int i = 0; i < size; i++) {
                    this.jch.get(i).dk(bfJ);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bfJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject crO() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.jbQ.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.jbQ.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.jbQ.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.jbQ.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.jbQ.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.jcb ? 1 : 0);
            jSONObject.put("playSuccess", this.jcc ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", crP());
            jSONObject.put("retryError", this.jce ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.jch != null) {
                int size = this.jch.size();
                for (int i = 0; i < size; i++) {
                    this.jch.get(i).dl(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject crP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.jcj);
            jSONObject.put("startTime", this.jck);
            jSONObject.put("totalTime", this.jcl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        crS();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject crQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.jbM)) {
                jSONObject.put("parentUuid", this.jbM);
            }
            jSONObject.put("tid", this.ahO);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.oo(this.jbN));
            jSONObject.put("urlType", this.jbO);
            jSONObject.put("sub_error", this.jci);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.jcd ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.jca);
            jSONObject.put("pcdn_used", this.jcm ? "1" : "0");
            jSONObject.put("p2p_used", this.jcn ? "1" : "0");
            if (!StringUtils.isNull(this.jcg)) {
                jSONObject.put("error_stack", this.jcg);
            }
            if (this.jch != null) {
                int size = this.jch.size();
                for (int i = 0; i < size; i++) {
                    this.jch.get(i).dm(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray crR() {
        JSONArray jSONArray = new JSONArray();
        if (this.jbP == null) {
            return jSONArray;
        }
        int size = this.jbP.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.jbP.get(i).cKQ());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.jch == null) {
            this.jch = new ArrayList();
        }
        this.jch.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void qb(boolean z) {
        this.jcc = z;
    }

    @Override // com.baidu.tieba.k.i
    public String crJ() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String crK() {
        return this.jci + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.jcj = j;
        this.jck = j2;
        this.jcl = j3;
    }

    private void crS() {
        this.jcj = 0L;
        this.jck = 0L;
        this.jcl = 0L;
    }
}
