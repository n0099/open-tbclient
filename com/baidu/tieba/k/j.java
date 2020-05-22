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
    private String ais;
    private String jqP;
    private int jqQ;
    private int jqR;
    private com.baidu.tieba.k.a.b jqU;
    private com.baidu.tieba.k.a.d jqV;
    private List<com.baidu.tieba.k.a.c> jqW;
    private long jra;
    private long jrb;
    private long jrc;
    private boolean jre;
    private boolean jri;
    private String jrj;
    private List<b> jrk;
    private int jrl;
    private long jrm;
    private long jrn;
    private long jro;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean jrf = true;
    private boolean jrg = false;
    private boolean jrh = false;
    private boolean jrp = false;
    private boolean jrq = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> jqT = new HashMap();
    private List<com.baidu.tieba.n.c> jqS = new ArrayList();
    private long jqX = 0;
    private long jqY = 0;
    private long jqZ = 0;
    private ArrayList<Integer> jrd = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ais = str;
        this.mVideoUrl = str2;
        this.jqP = str3;
        cyw();
    }

    @Override // com.baidu.tieba.k.i
    public void cyh() {
        this.jqX = System.currentTimeMillis();
        this.jqS.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void Iw(String str) {
        IB(str);
        this.jqS.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void qx(boolean z) {
        this.jre = z;
        this.jqS.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void IB(String str) {
        if (!StringUtils.isNull(str)) {
            this.jqR = VideoPlatformStatic.zH(str);
            if (this.jqR != 0) {
                this.jre = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cyi() {
        this.jqS.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void cyj() {
        if (this.mCurrentState != 2) {
            this.jqX = System.currentTimeMillis();
            this.jqS.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void ac(boolean z, boolean z2) {
        this.jrp = z;
        this.jrq = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.jqX = System.currentTimeMillis();
        IB(str);
        this.jqS.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void zy(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jqQ = i;
            this.jrf = true;
            long currentTimeMillis = System.currentTimeMillis() - this.jqX;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.jqT.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.jqX = 0L;
            this.jqS.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void zz(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jqQ = i;
            this.jrf = true;
            this.jrg = true;
            this.jqT.put("loadingTime", 1L);
            this.jqX = 0L;
            this.jqS.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void zA(int i) {
        if (this.mCurrentState == 5) {
            cyp();
        } else if (this.mCurrentState == 3) {
            this.jqQ = i;
            this.jqY = System.currentTimeMillis();
            this.jqS.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cyk() {
        if (this.jqY != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.jqZ += currentTimeMillis - this.jqY;
            this.jqY = currentTimeMillis;
        }
        this.jra++;
        this.jrc = System.currentTimeMillis();
        this.jqS.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void cyl() {
        this.jqY = System.currentTimeMillis();
        if (this.jrc != 0) {
            this.jrb += System.currentTimeMillis() - this.jrc;
        }
        this.jqS.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void s(long j, int i) {
        this.jra++;
        this.jrb += j;
        this.jrd.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cym() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.jqY != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.jqZ = (currentTimeMillis - this.jqY) + this.jqZ;
                this.jqY = 0L;
            }
            this.jqS.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cyp() {
        if (this.mCurrentState == 5) {
            this.jqY = System.currentTimeMillis();
            this.jqS.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Ix(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.zI(str);
            cyr();
            this.jqS.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            ahn();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Iy(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.zI(str);
        cyr();
        this.jqT.put("stallDuration", Long.valueOf(this.jrb));
        this.jqS.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        ahn();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Iz(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.zI(str);
        cyr();
        this.jqS.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        ahn();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.jqV == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jqV = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.jqV);
            }
            if (this.jqV != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.jqV.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.baM())) {
            if (this.jqU == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jqU = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.jqU);
            }
            if (this.jqU != null) {
                if (this.jqU.size() == 0) {
                    this.jrl = i2;
                }
                this.jqU.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.jqW == null) {
            this.jqW = new ArrayList();
        }
        this.jqW.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.jqQ = i;
        this.jrf = false;
        this.jrh = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.zI(str);
        cyr();
        if (!v.isEmpty(this.jqW)) {
            int size = this.jqW.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.jqW.get(i4);
                if (cVar != null) {
                    cVar.cyG();
                }
            }
        }
        this.jqS.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, cyq()));
        this.mCurrentState = -1;
        ahn();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] cyq() {
        if (this.jqW == null || this.jqW.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.jqW.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jqW.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.jqW.get(i2).cyE();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void IA(String str) {
        this.jrj = str;
    }

    private void cyr() {
        if (this.jqY != 0) {
            this.jqZ += System.currentTimeMillis() - this.jqY;
        }
        this.jqT.put("playDuration", Long.valueOf(this.jqZ));
        this.jqT.put("stallCount", Long.valueOf(this.jra));
        this.jqT.put("stallDuration", Long.valueOf(this.jrb));
        if (!this.jqT.containsKey("loadingTime")) {
            this.jqT.put("loadingTime", 0L);
        }
        this.jqX = 0L;
        this.jqY = 0L;
        this.jqZ = 0L;
        this.jra = 0L;
        this.jrb = 0L;
        this.jrc = 0L;
    }

    public void ahn() {
        if (!this.jri) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.baH() || !this.jrf) && reportType != 3) {
                this.jri = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.blV());
                            jSONObject.put("kpiInfo", j.this.cys());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.jrf)) {
                                JSONObject cyu = j.this.cyu();
                                cyu.put("running", j.this.cyv());
                                jSONObject.put("debugInfo", cyu);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cyu());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dhr().f(jSONObject, j.this.jrf ? false : true);
                        if (j.this.jrk != null) {
                            j.this.jrk.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject blV() {
        JSONObject blV = VideoPlatformStatic.blV();
        if (this.jrk != null) {
            try {
                int size = this.jrk.size();
                for (int i = 0; i < size; i++) {
                    this.jrk.get(i).dr(blV);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return blV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cys() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.jqT.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.jqT.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.jqT.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.jqT.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.jqT.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.jre ? 1 : 0);
            jSONObject.put("playSuccess", this.jrf ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cyt());
            jSONObject.put("retryError", this.jrh ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.jrk != null) {
                int size = this.jrk.size();
                for (int i = 0; i < size; i++) {
                    this.jrk.get(i).ds(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cyt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.jrm);
            jSONObject.put("startTime", this.jrn);
            jSONObject.put("totalTime", this.jro);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cyw();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cyu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.jqP)) {
                jSONObject.put("parentUuid", this.jqP);
            }
            jSONObject.put("tid", this.ais);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.oV(this.jqQ));
            jSONObject.put("urlType", this.jqR);
            jSONObject.put("sub_error", this.jrl);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.jrg ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.jrd);
            jSONObject.put("pcdn_used", this.jrp ? "1" : "0");
            jSONObject.put("p2p_used", this.jrq ? "1" : "0");
            if (!StringUtils.isNull(this.jrj)) {
                jSONObject.put("error_stack", this.jrj);
            }
            if (this.jrk != null) {
                int size = this.jrk.size();
                for (int i = 0; i < size; i++) {
                    this.jrk.get(i).dt(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cyv() {
        JSONArray jSONArray = new JSONArray();
        if (this.jqS == null) {
            return jSONArray;
        }
        int size = this.jqS.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.jqS.get(i).cRR());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.jrk == null) {
            this.jrk = new ArrayList();
        }
        this.jrk.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void qy(boolean z) {
        this.jrf = z;
    }

    @Override // com.baidu.tieba.k.i
    public String cyn() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String cyo() {
        return this.jrl + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.jrm = j;
        this.jrn = j2;
        this.jro = j3;
    }

    private void cyw() {
        this.jrm = 0L;
        this.jrn = 0L;
        this.jro = 0L;
    }
}
