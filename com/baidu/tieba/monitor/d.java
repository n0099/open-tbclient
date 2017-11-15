package com.baidu.tieba.monitor;

import android.location.Address;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.monitor.b.e;
import com.coremedia.iso.boxes.UserBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.play.b.b {
    private String aMq;
    private String aXD;
    private com.baidu.tieba.monitor.b.b exA;
    private com.baidu.tieba.monitor.b.d exB;
    private List<com.baidu.tieba.monitor.b.c> exC;
    private long exG;
    private long exH;
    private long exI;
    private boolean exJ;
    private boolean exM;
    private String exN;
    private List<com.baidu.tieba.play.b.a> exO;
    private int exP;
    private String exv;
    private int exw;
    private int exx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean exK = true;
    private boolean exL = false;
    private String exu = UUID.randomUUID().toString();
    private Map<String, Long> exz = new HashMap();
    private List<com.baidu.tieba.monitor.a.c> exy = new ArrayList();
    private long exD = 0;
    private long exE = 0;
    private long exF = 0;

    public d(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aMq = str;
        this.aXD = str2;
        this.exv = str3;
    }

    @Override // com.baidu.tieba.play.b.b
    public void aMX() {
        this.exD = System.currentTimeMillis();
        this.exy.add(new com.baidu.tieba.monitor.a.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.play.b.b
    public void oI(String str) {
        oJ(str);
        this.exy.add(new com.baidu.tieba.monitor.a.a(1));
        this.mCurrentState = 1;
    }

    private void oJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.exx = VideoMonitorStatic.oO(str);
            if (this.exx != 0) {
                this.exJ = true;
            }
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void aMY() {
        this.exy.add(new com.baidu.tieba.monitor.a.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.play.b.b
    public void aMZ() {
        if (this.mCurrentState != 2) {
            this.exD = System.currentTimeMillis();
            this.exy.add(new com.baidu.tieba.monitor.a.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.exD = System.currentTimeMillis();
        oJ(str);
        this.exy.add(new com.baidu.tieba.monitor.a.d(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.play.b.b
    public void aNa() {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            long currentTimeMillis = System.currentTimeMillis() - this.exD;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.exz.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.exD = 0L;
            this.exE = System.currentTimeMillis();
            this.exy.add(new com.baidu.tieba.monitor.a.a(SapiSafeFacade.SAPIWEBVIEW_BACK));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void pb(int i) {
        if (this.mCurrentState == 5) {
            aNe();
        } else if (this.mCurrentState == 3) {
            this.exw = i;
            this.exy.add(new com.baidu.tieba.monitor.a.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void aNb() {
        if (this.exE != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.exF += currentTimeMillis - this.exE;
            this.exE = currentTimeMillis;
        }
        this.exG++;
        this.exI = System.currentTimeMillis();
        this.exy.add(new com.baidu.tieba.monitor.a.a(201));
    }

    @Override // com.baidu.tieba.play.b.b
    public void aNc() {
        this.exE = System.currentTimeMillis();
        if (this.exI != 0) {
            this.exH += System.currentTimeMillis() - this.exI;
        }
        this.exy.add(new com.baidu.tieba.monitor.a.a(202));
    }

    @Override // com.baidu.tieba.play.b.b
    public void aNd() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.exE != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.exF += currentTimeMillis - this.exE;
                this.exE = currentTimeMillis;
            }
            this.exy.add(new com.baidu.tieba.monitor.a.a(203));
            this.mCurrentState = 5;
        }
    }

    public void aNe() {
        if (this.mCurrentState == 5) {
            this.exE = System.currentTimeMillis();
            this.exy.add(new com.baidu.tieba.monitor.a.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void oK(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.exK = true;
            this.mSource = VideoMonitorStatic.oP(str);
            aNg();
            this.exy.add(new com.baidu.tieba.monitor.a.a(205));
            this.mCurrentState = 8;
            aNh();
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public String oL(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.exu;
        }
        this.exK = true;
        this.mSource = VideoMonitorStatic.oP(str);
        aNg();
        this.exz.put("stallDuration", Long.valueOf(this.exH));
        this.exy.add(new com.baidu.tieba.monitor.a.a(206));
        this.mCurrentState = 6;
        aNh();
        return this.exu;
    }

    @Override // com.baidu.tieba.play.b.b
    public boolean oM(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.exK = true;
        this.mSource = VideoMonitorStatic.oP(str);
        aNg();
        this.exy.add(new com.baidu.tieba.monitor.a.a(207));
        this.mCurrentState = 7;
        aNh();
        return true;
    }

    @Override // com.baidu.tieba.play.b.b
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.exB == null && f.dG()) {
                this.exB = new com.baidu.tieba.monitor.b.d(this.exu);
                a(this.exB);
            }
            if (this.exB != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.exB.a(new com.baidu.tieba.play.d.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.c.f.AD())) {
            if (this.exA == null && f.dG()) {
                this.exA = new com.baidu.tieba.monitor.b.b(this.exu);
                a(this.exA);
            }
            if (this.exA != null) {
                if (this.exA.size() == 0) {
                    this.exP = i2;
                }
                this.exA.a(new com.baidu.tieba.play.d.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.monitor.b.c cVar) {
        if (this.exC == null) {
            this.exC = new ArrayList();
        }
        this.exC.add(cVar);
    }

    @Override // com.baidu.tieba.play.b.b
    public String a(int i, int i2, int i3, String str, boolean z, long j) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.exu;
        }
        this.exw = i;
        this.exK = false;
        this.exL = z;
        this.mError = i3;
        this.mSource = VideoMonitorStatic.oP(str);
        aNg();
        if (!v.v(this.exC)) {
            int size = this.exC.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.monitor.b.c cVar = this.exC.get(i4);
                if (cVar != null) {
                    cVar.aNt();
                }
            }
        }
        this.exy.add(new com.baidu.tieba.monitor.a.b(i, i2, i3, j, aNf()));
        this.mCurrentState = -1;
        aNh();
        return this.exu;
    }

    private e[] aNf() {
        if (this.exC == null || this.exC.size() == 0) {
            return null;
        }
        e[] eVarArr = new e[this.exC.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.exC.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.exC.get(i2).aNr();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void oN(String str) {
        this.exN = str;
    }

    private void aNg() {
        if (this.exE != 0) {
            this.exF += System.currentTimeMillis() - this.exE;
        }
        this.exz.put("playDuration", Long.valueOf(this.exF));
        this.exz.put("stallCount", Long.valueOf(this.exG));
        this.exz.put("stallDuration", Long.valueOf(this.exH));
        if (!this.exz.containsKey("loadingTime")) {
            this.exz.put("loadingTime", 0L);
        }
        this.exD = 0L;
        this.exE = 0L;
        this.exF = 0L;
        this.exG = 0L;
        this.exH = 0L;
        this.exI = 0L;
    }

    @Override // com.baidu.tieba.play.b.b
    public void aNh() {
        if (!this.exM) {
            int reportType = com.baidu.tbadk.coreExtra.c.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.c.f.Ay() || !this.exK) && reportType != 3) {
                this.exM = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.monitor.d.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.c.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", d.this.aNi());
                            jSONObject.put("kpiInfo", d.this.aNj());
                            if (reportType2 == 0 || (reportType2 == 4 && d.this.exK)) {
                                JSONObject aNk = d.this.aNk();
                                aNk.put("running", d.this.aNl());
                                jSONObject.put("debugInfo", aNk);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", d.this.aNk());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.monitor.c.b.aNv().c(jSONObject, d.this.exK ? false : true);
                        if (d.this.exO != null) {
                            d.this.exO.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aNi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appVer", TbConfig.getVersion());
            jSONObject.put("clientIp", com.baidu.tbadk.core.util.d.getIp());
            jSONObject.put("clientTimestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("deviceId", UtilHelper.getDeviceId());
            jSONObject.put("network", VideoMonitorStatic.aNn());
            jSONObject.put("osType", "AND");
            jSONObject.put("osVer", Build.VERSION.RELEASE);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            } else {
                jSONObject.put(SapiAccountManager.SESSION_UID, "");
            }
            StringBuilder sb = new StringBuilder();
            if (com.baidu.adp.lib.d.a.fc().D(false) != null) {
                Address D = com.baidu.adp.lib.d.a.fc().D(false);
                if (!StringUtils.isNull(D.getAdminArea())) {
                    sb.append(D.getAdminArea());
                }
                if (!StringUtils.isNull(D.getSubAdminArea())) {
                    sb.append(D.getSubAdminArea());
                }
                if (!StringUtils.isNull(D.getSubLocality())) {
                    sb.append(D.getSubLocality());
                }
            }
            jSONObject.put("location", sb.toString());
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            if (this.exO != null) {
                int size = this.exO.size();
                for (int i = 0; i < size; i++) {
                    this.exO.get(i).J(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aNj() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.exz.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.exz.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.exz.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.exz.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.exz.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.exJ ? 1 : 0);
            jSONObject.put("playSuccess", this.exK ? 1 : 0);
            jSONObject.put("retryError", this.exL ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.exO != null) {
                int size = this.exO.size();
                for (int i = 0; i < size; i++) {
                    this.exO.get(i).K(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aNk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.exu);
            if (!StringUtils.isNull(this.exv)) {
                jSONObject.put("parentUuid", this.exv);
            }
            jSONObject.put("tid", this.aMq);
            jSONObject.put("videoUrl", this.aXD);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoMonitorStatic.pc(this.exw));
            jSONObject.put("urlType", this.exx);
            jSONObject.put("sub_error", this.exP);
            if (!StringUtils.isNull(this.exN)) {
                jSONObject.put("error_stack", this.exN);
            }
            if (this.exO != null) {
                int size = this.exO.size();
                for (int i = 0; i < size; i++) {
                    this.exO.get(i).L(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aNl() {
        JSONArray jSONArray = new JSONArray();
        if (this.exy == null) {
            return jSONArray;
        }
        int size = this.exy.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.exy.get(i).aNo());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.play.b.b
    public void a(com.baidu.tieba.play.b.a aVar) {
        if (this.exO == null) {
            this.exO = new ArrayList();
        }
        this.exO.add(aVar);
    }
}
