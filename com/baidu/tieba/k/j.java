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
    private String Pj;
    private String ipS;
    private int ipT;
    private int ipU;
    private com.baidu.tieba.k.a.b ipX;
    private com.baidu.tieba.k.a.d ipY;
    private List<com.baidu.tieba.k.a.c> ipZ;
    private long iqd;
    private long iqe;
    private long iqf;
    private boolean iqg;
    private boolean iqk;
    private String iql;
    private List<b> iqm;
    private int iqn;
    private long iqo;
    private long iqp;
    private long iqq;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean iqh = true;
    private boolean iqi = false;
    private boolean iqj = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> ipW = new HashMap();
    private List<com.baidu.tieba.n.c> ipV = new ArrayList();
    private long iqa = 0;
    private long iqb = 0;
    private long iqc = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.Pj = str;
        this.mVideoUrl = str2;
        this.ipS = str3;
        cgR();
    }

    @Override // com.baidu.tieba.k.i
    public void cgC() {
        this.iqa = System.currentTimeMillis();
        this.ipV.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void Fc(String str) {
        Fh(str);
        this.ipV.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void oQ(boolean z) {
        this.iqg = z;
        this.ipV.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void Fh(String str) {
        if (!StringUtils.isNull(str)) {
            this.ipU = VideoPlatformStatic.wK(str);
            if (this.ipU != 0) {
                this.iqg = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cgD() {
        this.ipV.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void cgE() {
        if (this.mCurrentState != 2) {
            this.iqa = System.currentTimeMillis();
            this.ipV.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.iqa = System.currentTimeMillis();
        Fh(str);
        this.ipV.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void yh(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.ipT = i;
            this.iqh = true;
            long currentTimeMillis = System.currentTimeMillis() - this.iqa;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.ipW.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.iqa = 0L;
            this.ipV.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yi(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.ipT = i;
            this.iqh = true;
            this.iqi = true;
            this.ipW.put("loadingTime", 1L);
            this.iqa = 0L;
            this.ipV.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yj(int i) {
        if (this.mCurrentState == 5) {
            cgK();
        } else if (this.mCurrentState == 3) {
            this.ipT = i;
            this.iqb = System.currentTimeMillis();
            this.ipV.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cgF() {
        if (this.iqb != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.iqc += currentTimeMillis - this.iqb;
            this.iqb = currentTimeMillis;
        }
        this.iqd++;
        this.iqf = System.currentTimeMillis();
        this.ipV.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void cgG() {
        this.iqb = System.currentTimeMillis();
        if (this.iqf != 0) {
            this.iqe += System.currentTimeMillis() - this.iqf;
        }
        this.ipV.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void cgH() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.iqb != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.iqc = (currentTimeMillis - this.iqb) + this.iqc;
                this.iqb = 0L;
            }
            this.ipV.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cgK() {
        if (this.mCurrentState == 5) {
            this.iqb = System.currentTimeMillis();
            this.ipV.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fd(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.wL(str);
            cgM();
            this.ipV.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            Wk();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Fe(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.wL(str);
        cgM();
        this.ipW.put("stallDuration", Long.valueOf(this.iqe));
        this.ipV.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        Wk();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Ff(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.wL(str);
        cgM();
        this.ipV.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Wk();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.ipY == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.ipY = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.ipY);
            }
            if (this.ipY != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.ipY.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aMa())) {
            if (this.ipX == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.ipX = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.ipX);
            }
            if (this.ipX != null) {
                if (this.ipX.size() == 0) {
                    this.iqn = i2;
                }
                this.ipX.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.ipZ == null) {
            this.ipZ = new ArrayList();
        }
        this.ipZ.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.ipT = i;
        this.iqh = false;
        this.iqj = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.wL(str);
        cgM();
        if (!v.isEmpty(this.ipZ)) {
            int size = this.ipZ.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.ipZ.get(i4);
                if (cVar != null) {
                    cVar.chb();
                }
            }
        }
        this.ipV.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, cgL()));
        this.mCurrentState = -1;
        Wk();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] cgL() {
        if (this.ipZ == null || this.ipZ.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.ipZ.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ipZ.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.ipZ.get(i2).cgZ();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fg(String str) {
        this.iql = str;
    }

    private void cgM() {
        if (this.iqb != 0) {
            this.iqc += System.currentTimeMillis() - this.iqb;
        }
        this.ipW.put("playDuration", Long.valueOf(this.iqc));
        this.ipW.put("stallCount", Long.valueOf(this.iqd));
        this.ipW.put("stallDuration", Long.valueOf(this.iqe));
        if (!this.ipW.containsKey("loadingTime")) {
            this.ipW.put("loadingTime", 0L);
        }
        this.iqa = 0L;
        this.iqb = 0L;
        this.iqc = 0L;
        this.iqd = 0L;
        this.iqe = 0L;
        this.iqf = 0L;
    }

    public void Wk() {
        if (!this.iqk) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aLV() || !this.iqh) && reportType != 3) {
                this.iqk = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aXz());
                            jSONObject.put("kpiInfo", j.this.cgN());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.iqh)) {
                                JSONObject cgP = j.this.cgP();
                                cgP.put("running", j.this.cgQ());
                                jSONObject.put("debugInfo", cgP);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cgP());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.cOM().e(jSONObject, j.this.iqh ? false : true);
                        if (j.this.iqm != null) {
                            j.this.iqm.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXz() {
        JSONObject aXz = VideoPlatformStatic.aXz();
        if (this.iqm != null) {
            try {
                int size = this.iqm.size();
                for (int i = 0; i < size; i++) {
                    this.iqm.get(i).cZ(aXz);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aXz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cgN() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.ipW.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.ipW.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.ipW.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.ipW.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.ipW.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.iqg ? 1 : 0);
            jSONObject.put("playSuccess", this.iqh ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cgO());
            jSONObject.put("retryError", this.iqj ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.iqm != null) {
                int size = this.iqm.size();
                for (int i = 0; i < size; i++) {
                    this.iqm.get(i).da(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cgO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.iqo);
            jSONObject.put("startTime", this.iqp);
            jSONObject.put("totalTime", this.iqq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cgR();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cgP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.ipS)) {
                jSONObject.put("parentUuid", this.ipS);
            }
            jSONObject.put("tid", this.Pj);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.nZ(this.ipT));
            jSONObject.put("urlType", this.ipU);
            jSONObject.put("sub_error", this.iqn);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.iqi ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            if (!StringUtils.isNull(this.iql)) {
                jSONObject.put("error_stack", this.iql);
            }
            if (this.iqm != null) {
                int size = this.iqm.size();
                for (int i = 0; i < size; i++) {
                    this.iqm.get(i).db(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cgQ() {
        JSONArray jSONArray = new JSONArray();
        if (this.ipV == null) {
            return jSONArray;
        }
        int size = this.ipV.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.ipV.get(i).czM());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.iqm == null) {
            this.iqm = new ArrayList();
        }
        this.iqm.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void oR(boolean z) {
        this.iqh = z;
    }

    @Override // com.baidu.tieba.k.i
    public String cgI() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String cgJ() {
        return this.iqn + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.iqo = j;
        this.iqp = j2;
        this.iqq = j3;
    }

    private void cgR() {
        this.iqo = 0L;
        this.iqp = 0L;
        this.iqq = 0L;
    }
}
