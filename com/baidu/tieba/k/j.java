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
    private List<b> iqA;
    private int iqB;
    private long iqC;
    private long iqD;
    private long iqE;
    private String iqg;
    private int iqh;
    private int iqi;
    private com.baidu.tieba.k.a.b iql;
    private com.baidu.tieba.k.a.d iqm;
    private List<com.baidu.tieba.k.a.c> iqn;
    private long iqr;
    private long iqs;
    private long iqt;
    private boolean iqu;
    private boolean iqy;
    private String iqz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean iqv = true;
    private boolean iqw = false;
    private boolean iqx = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> iqk = new HashMap();
    private List<com.baidu.tieba.n.c> iqj = new ArrayList();
    private long iqo = 0;
    private long iqp = 0;
    private long iqq = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.Pj = str;
        this.mVideoUrl = str2;
        this.iqg = str3;
        cgU();
    }

    @Override // com.baidu.tieba.k.i
    public void cgF() {
        this.iqo = System.currentTimeMillis();
        this.iqj.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void Fd(String str) {
        Fi(str);
        this.iqj.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void oQ(boolean z) {
        this.iqu = z;
        this.iqj.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void Fi(String str) {
        if (!StringUtils.isNull(str)) {
            this.iqi = VideoPlatformStatic.wL(str);
            if (this.iqi != 0) {
                this.iqu = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cgG() {
        this.iqj.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void cgH() {
        if (this.mCurrentState != 2) {
            this.iqo = System.currentTimeMillis();
            this.iqj.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.iqo = System.currentTimeMillis();
        Fi(str);
        this.iqj.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void yh(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.iqh = i;
            this.iqv = true;
            long currentTimeMillis = System.currentTimeMillis() - this.iqo;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.iqk.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.iqo = 0L;
            this.iqj.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yi(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.iqh = i;
            this.iqv = true;
            this.iqw = true;
            this.iqk.put("loadingTime", 1L);
            this.iqo = 0L;
            this.iqj.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yj(int i) {
        if (this.mCurrentState == 5) {
            cgN();
        } else if (this.mCurrentState == 3) {
            this.iqh = i;
            this.iqp = System.currentTimeMillis();
            this.iqj.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cgI() {
        if (this.iqp != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.iqq += currentTimeMillis - this.iqp;
            this.iqp = currentTimeMillis;
        }
        this.iqr++;
        this.iqt = System.currentTimeMillis();
        this.iqj.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void cgJ() {
        this.iqp = System.currentTimeMillis();
        if (this.iqt != 0) {
            this.iqs += System.currentTimeMillis() - this.iqt;
        }
        this.iqj.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void cgK() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.iqp != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.iqq = (currentTimeMillis - this.iqp) + this.iqq;
                this.iqp = 0L;
            }
            this.iqj.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cgN() {
        if (this.mCurrentState == 5) {
            this.iqp = System.currentTimeMillis();
            this.iqj.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fe(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.wM(str);
            cgP();
            this.iqj.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            Wm();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Ff(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.wM(str);
        cgP();
        this.iqk.put("stallDuration", Long.valueOf(this.iqs));
        this.iqj.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        Wm();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Fg(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.wM(str);
        cgP();
        this.iqj.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Wm();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.iqm == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.iqm = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.iqm);
            }
            if (this.iqm != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.iqm.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aMd())) {
            if (this.iql == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.iql = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.iql);
            }
            if (this.iql != null) {
                if (this.iql.size() == 0) {
                    this.iqB = i2;
                }
                this.iql.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.iqn == null) {
            this.iqn = new ArrayList();
        }
        this.iqn.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.iqh = i;
        this.iqv = false;
        this.iqx = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.wM(str);
        cgP();
        if (!v.isEmpty(this.iqn)) {
            int size = this.iqn.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.iqn.get(i4);
                if (cVar != null) {
                    cVar.che();
                }
            }
        }
        this.iqj.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, cgO()));
        this.mCurrentState = -1;
        Wm();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] cgO() {
        if (this.iqn == null || this.iqn.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.iqn.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iqn.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.iqn.get(i2).chc();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fh(String str) {
        this.iqz = str;
    }

    private void cgP() {
        if (this.iqp != 0) {
            this.iqq += System.currentTimeMillis() - this.iqp;
        }
        this.iqk.put("playDuration", Long.valueOf(this.iqq));
        this.iqk.put("stallCount", Long.valueOf(this.iqr));
        this.iqk.put("stallDuration", Long.valueOf(this.iqs));
        if (!this.iqk.containsKey("loadingTime")) {
            this.iqk.put("loadingTime", 0L);
        }
        this.iqo = 0L;
        this.iqp = 0L;
        this.iqq = 0L;
        this.iqr = 0L;
        this.iqs = 0L;
        this.iqt = 0L;
    }

    public void Wm() {
        if (!this.iqy) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aLY() || !this.iqv) && reportType != 3) {
                this.iqy = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aXC());
                            jSONObject.put("kpiInfo", j.this.cgQ());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.iqv)) {
                                JSONObject cgS = j.this.cgS();
                                cgS.put("running", j.this.cgT());
                                jSONObject.put("debugInfo", cgS);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cgS());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.cOP().e(jSONObject, j.this.iqv ? false : true);
                        if (j.this.iqA != null) {
                            j.this.iqA.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXC() {
        JSONObject aXC = VideoPlatformStatic.aXC();
        if (this.iqA != null) {
            try {
                int size = this.iqA.size();
                for (int i = 0; i < size; i++) {
                    this.iqA.get(i).cZ(aXC);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aXC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cgQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.iqk.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.iqk.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.iqk.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.iqk.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.iqk.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.iqu ? 1 : 0);
            jSONObject.put("playSuccess", this.iqv ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cgR());
            jSONObject.put("retryError", this.iqx ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.iqA != null) {
                int size = this.iqA.size();
                for (int i = 0; i < size; i++) {
                    this.iqA.get(i).da(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cgR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.iqC);
            jSONObject.put("startTime", this.iqD);
            jSONObject.put("totalTime", this.iqE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cgU();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cgS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.iqg)) {
                jSONObject.put("parentUuid", this.iqg);
            }
            jSONObject.put("tid", this.Pj);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.nZ(this.iqh));
            jSONObject.put("urlType", this.iqi);
            jSONObject.put("sub_error", this.iqB);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.iqw ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            if (!StringUtils.isNull(this.iqz)) {
                jSONObject.put("error_stack", this.iqz);
            }
            if (this.iqA != null) {
                int size = this.iqA.size();
                for (int i = 0; i < size; i++) {
                    this.iqA.get(i).db(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cgT() {
        JSONArray jSONArray = new JSONArray();
        if (this.iqj == null) {
            return jSONArray;
        }
        int size = this.iqj.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.iqj.get(i).czP());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.iqA == null) {
            this.iqA = new ArrayList();
        }
        this.iqA.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void oR(boolean z) {
        this.iqv = z;
    }

    @Override // com.baidu.tieba.k.i
    public String cgL() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String cgM() {
        return this.iqB + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.iqC = j;
        this.iqD = j2;
        this.iqE = j3;
    }

    private void cgU() {
        this.iqC = 0L;
        this.iqD = 0L;
        this.iqE = 0L;
    }
}
