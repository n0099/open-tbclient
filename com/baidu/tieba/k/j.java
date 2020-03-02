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
    private String ipU;
    private int ipV;
    private int ipW;
    private com.baidu.tieba.k.a.b ipZ;
    private com.baidu.tieba.k.a.d iqa;
    private List<com.baidu.tieba.k.a.c> iqb;
    private long iqf;
    private long iqg;
    private long iqh;
    private boolean iqi;
    private boolean iqm;
    private String iqn;
    private List<b> iqo;
    private int iqp;
    private long iqq;
    private long iqr;
    private long iqs;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean iqj = true;
    private boolean iqk = false;
    private boolean iql = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> ipY = new HashMap();
    private List<com.baidu.tieba.n.c> ipX = new ArrayList();
    private long iqc = 0;
    private long iqd = 0;
    private long iqe = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.Pj = str;
        this.mVideoUrl = str2;
        this.ipU = str3;
        cgT();
    }

    @Override // com.baidu.tieba.k.i
    public void cgE() {
        this.iqc = System.currentTimeMillis();
        this.ipX.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void Fc(String str) {
        Fh(str);
        this.ipX.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void oQ(boolean z) {
        this.iqi = z;
        this.ipX.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void Fh(String str) {
        if (!StringUtils.isNull(str)) {
            this.ipW = VideoPlatformStatic.wK(str);
            if (this.ipW != 0) {
                this.iqi = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cgF() {
        this.ipX.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void cgG() {
        if (this.mCurrentState != 2) {
            this.iqc = System.currentTimeMillis();
            this.ipX.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.iqc = System.currentTimeMillis();
        Fh(str);
        this.ipX.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void yh(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.ipV = i;
            this.iqj = true;
            long currentTimeMillis = System.currentTimeMillis() - this.iqc;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.ipY.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.iqc = 0L;
            this.ipX.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yi(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.ipV = i;
            this.iqj = true;
            this.iqk = true;
            this.ipY.put("loadingTime", 1L);
            this.iqc = 0L;
            this.ipX.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yj(int i) {
        if (this.mCurrentState == 5) {
            cgM();
        } else if (this.mCurrentState == 3) {
            this.ipV = i;
            this.iqd = System.currentTimeMillis();
            this.ipX.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cgH() {
        if (this.iqd != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.iqe += currentTimeMillis - this.iqd;
            this.iqd = currentTimeMillis;
        }
        this.iqf++;
        this.iqh = System.currentTimeMillis();
        this.ipX.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void cgI() {
        this.iqd = System.currentTimeMillis();
        if (this.iqh != 0) {
            this.iqg += System.currentTimeMillis() - this.iqh;
        }
        this.ipX.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void cgJ() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.iqd != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.iqe = (currentTimeMillis - this.iqd) + this.iqe;
                this.iqd = 0L;
            }
            this.ipX.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cgM() {
        if (this.mCurrentState == 5) {
            this.iqd = System.currentTimeMillis();
            this.ipX.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fd(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.wL(str);
            cgO();
            this.ipX.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            Wm();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Fe(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.wL(str);
        cgO();
        this.ipY.put("stallDuration", Long.valueOf(this.iqg));
        this.ipX.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        Wm();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Ff(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.wL(str);
        cgO();
        this.ipX.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Wm();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.iqa == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.iqa = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.iqa);
            }
            if (this.iqa != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.iqa.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aMc())) {
            if (this.ipZ == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.ipZ = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.ipZ);
            }
            if (this.ipZ != null) {
                if (this.ipZ.size() == 0) {
                    this.iqp = i2;
                }
                this.ipZ.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.iqb == null) {
            this.iqb = new ArrayList();
        }
        this.iqb.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.ipV = i;
        this.iqj = false;
        this.iql = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.wL(str);
        cgO();
        if (!v.isEmpty(this.iqb)) {
            int size = this.iqb.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.iqb.get(i4);
                if (cVar != null) {
                    cVar.chd();
                }
            }
        }
        this.ipX.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, cgN()));
        this.mCurrentState = -1;
        Wm();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] cgN() {
        if (this.iqb == null || this.iqb.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.iqb.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iqb.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.iqb.get(i2).chb();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fg(String str) {
        this.iqn = str;
    }

    private void cgO() {
        if (this.iqd != 0) {
            this.iqe += System.currentTimeMillis() - this.iqd;
        }
        this.ipY.put("playDuration", Long.valueOf(this.iqe));
        this.ipY.put("stallCount", Long.valueOf(this.iqf));
        this.ipY.put("stallDuration", Long.valueOf(this.iqg));
        if (!this.ipY.containsKey("loadingTime")) {
            this.ipY.put("loadingTime", 0L);
        }
        this.iqc = 0L;
        this.iqd = 0L;
        this.iqe = 0L;
        this.iqf = 0L;
        this.iqg = 0L;
        this.iqh = 0L;
    }

    public void Wm() {
        if (!this.iqm) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aLX() || !this.iqj) && reportType != 3) {
                this.iqm = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aXB());
                            jSONObject.put("kpiInfo", j.this.cgP());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.iqj)) {
                                JSONObject cgR = j.this.cgR();
                                cgR.put("running", j.this.cgS());
                                jSONObject.put("debugInfo", cgR);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cgR());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.cOO().e(jSONObject, j.this.iqj ? false : true);
                        if (j.this.iqo != null) {
                            j.this.iqo.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXB() {
        JSONObject aXB = VideoPlatformStatic.aXB();
        if (this.iqo != null) {
            try {
                int size = this.iqo.size();
                for (int i = 0; i < size; i++) {
                    this.iqo.get(i).cZ(aXB);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aXB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cgP() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.ipY.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.ipY.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.ipY.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.ipY.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.ipY.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.iqi ? 1 : 0);
            jSONObject.put("playSuccess", this.iqj ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cgQ());
            jSONObject.put("retryError", this.iql ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.iqo != null) {
                int size = this.iqo.size();
                for (int i = 0; i < size; i++) {
                    this.iqo.get(i).da(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cgQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.iqq);
            jSONObject.put("startTime", this.iqr);
            jSONObject.put("totalTime", this.iqs);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cgT();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cgR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.ipU)) {
                jSONObject.put("parentUuid", this.ipU);
            }
            jSONObject.put("tid", this.Pj);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.nZ(this.ipV));
            jSONObject.put("urlType", this.ipW);
            jSONObject.put("sub_error", this.iqp);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.iqk ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            if (!StringUtils.isNull(this.iqn)) {
                jSONObject.put("error_stack", this.iqn);
            }
            if (this.iqo != null) {
                int size = this.iqo.size();
                for (int i = 0; i < size; i++) {
                    this.iqo.get(i).db(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cgS() {
        JSONArray jSONArray = new JSONArray();
        if (this.ipX == null) {
            return jSONArray;
        }
        int size = this.ipX.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.ipX.get(i).czO());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.iqo == null) {
            this.iqo = new ArrayList();
        }
        this.iqo.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void oR(boolean z) {
        this.iqj = z;
    }

    @Override // com.baidu.tieba.k.i
    public String cgK() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String cgL() {
        return this.iqp + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.iqq = j;
        this.iqr = j2;
        this.iqs = j3;
    }

    private void cgT() {
        this.iqq = 0L;
        this.iqr = 0L;
        this.iqs = 0L;
    }
}
