package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.VideoPlatformStatic;
import com.coremedia.iso.boxes.UserBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j implements i {
    private String aVt;
    private String biU;
    private int fdA;
    private String fdg;
    private int fdh;
    private int fdi;
    private com.baidu.tieba.j.a.b fdl;
    private com.baidu.tieba.j.a.d fdm;
    private List<com.baidu.tieba.j.a.c> fdn;
    private long fdr;
    private long fds;
    private long fdt;
    private boolean fdu;
    private boolean fdx;
    private String fdy;
    private List<b> fdz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fdv = true;
    private boolean fdw = false;
    private String fdf = UUID.randomUUID().toString();
    private Map<String, Long> fdk = new HashMap();
    private List<com.baidu.tieba.m.c> fdj = new ArrayList();
    private long fdo = 0;
    private long fdp = 0;
    private long fdq = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aVt = str;
        this.biU = str2;
        this.fdg = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aWJ() {
        this.fdo = System.currentTimeMillis();
        this.fdj.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void qz(String str) {
        qE(str);
        this.fdj.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void qE(String str) {
        if (!StringUtils.isNull(str)) {
            this.fdi = VideoPlatformStatic.iu(str);
            if (this.fdi != 0) {
                this.fdu = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aWK() {
        this.fdj.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aWL() {
        if (this.mCurrentState != 2) {
            this.fdo = System.currentTimeMillis();
            this.fdj.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fdo = System.currentTimeMillis();
        qE(str);
        this.fdj.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void pO(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fdh = i;
            this.fdv = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fdo;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fdk.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fdo = 0L;
            this.fdp = System.currentTimeMillis();
            this.fdj.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pP(int i) {
        if (this.mCurrentState == 5) {
            aWS();
        } else if (this.mCurrentState == 3) {
            this.fdh = i;
            this.fdj.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aWM() {
        if (this.fdp != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fdq += currentTimeMillis - this.fdp;
            this.fdp = currentTimeMillis;
        }
        this.fdr++;
        this.fdt = System.currentTimeMillis();
        this.fdj.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aWN() {
        this.fdp = System.currentTimeMillis();
        if (this.fdt != 0) {
            this.fds += System.currentTimeMillis() - this.fdt;
        }
        this.fdj.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aWO() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fdp != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fdq += currentTimeMillis - this.fdp;
                this.fdp = currentTimeMillis;
            }
            this.fdj.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aWS() {
        if (this.mCurrentState == 5) {
            this.fdp = System.currentTimeMillis();
            this.fdj.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qA(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.iv(str);
            aWU();
            this.fdj.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aWP();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String qB(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fdf;
        }
        this.mSource = VideoPlatformStatic.iv(str);
        aWU();
        this.fdk.put("stallDuration", Long.valueOf(this.fds));
        this.fdj.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aWP();
        return this.fdf;
    }

    @Override // com.baidu.tieba.j.i
    public boolean qC(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.iv(str);
        aWU();
        this.fdj.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aWP();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fdm == null && com.baidu.adp.lib.util.f.ge()) {
                this.fdm = new com.baidu.tieba.j.a.d(this.fdf);
                a(this.fdm);
            }
            if (this.fdm != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fdm.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.EV())) {
            if (this.fdl == null && com.baidu.adp.lib.util.f.ge()) {
                this.fdl = new com.baidu.tieba.j.a.b(this.fdf);
                a(this.fdl);
            }
            if (this.fdl != null) {
                if (this.fdl.size() == 0) {
                    this.fdA = i2;
                }
                this.fdl.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fdn == null) {
            this.fdn = new ArrayList();
        }
        this.fdn.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fdf;
        }
        this.fdh = i;
        this.fdv = false;
        this.fdw = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.iv(str);
        aWU();
        if (!w.z(this.fdn)) {
            int size = this.fdn.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fdn.get(i4);
                if (cVar != null) {
                    cVar.aXd();
                }
            }
        }
        this.fdj.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aWT()));
        this.mCurrentState = -1;
        aWP();
        return this.fdf;
    }

    private com.baidu.tieba.j.a.e[] aWT() {
        if (this.fdn == null || this.fdn.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fdn.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fdn.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fdn.get(i2).aXb();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qD(String str) {
        this.fdy = str;
    }

    private void aWU() {
        if (this.fdp != 0) {
            this.fdq += System.currentTimeMillis() - this.fdp;
        }
        this.fdk.put("playDuration", Long.valueOf(this.fdq));
        this.fdk.put("stallCount", Long.valueOf(this.fdr));
        this.fdk.put("stallDuration", Long.valueOf(this.fds));
        if (!this.fdk.containsKey("loadingTime")) {
            this.fdk.put("loadingTime", 0L);
        }
        this.fdo = 0L;
        this.fdp = 0L;
        this.fdq = 0L;
        this.fdr = 0L;
        this.fds = 0L;
        this.fdt = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aWP() {
        if (!this.fdx) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.EQ() || !this.fdv) && reportType != 3) {
                this.fdx = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.PY());
                            jSONObject.put("kpiInfo", j.this.aWV());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fdv)) {
                                JSONObject aWW = j.this.aWW();
                                aWW.put("running", j.this.aWX());
                                jSONObject.put("debugInfo", aWW);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aWW());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.t.e.bAO().c(jSONObject, j.this.fdv ? false : true);
                        if (j.this.fdz != null) {
                            j.this.fdz.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject PY() {
        JSONObject PY = VideoPlatformStatic.PY();
        if (this.fdz != null) {
            try {
                int size = this.fdz.size();
                for (int i = 0; i < size; i++) {
                    this.fdz.get(i).U(PY);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return PY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aWV() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fdk.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fdk.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fdk.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fdk.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fdk.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fdu ? 1 : 0);
            jSONObject.put("playSuccess", this.fdv ? 1 : 0);
            jSONObject.put("retryError", this.fdw ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fdz != null) {
                int size = this.fdz.size();
                for (int i = 0; i < size; i++) {
                    this.fdz.get(i).V(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aWW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fdf);
            if (!StringUtils.isNull(this.fdg)) {
                jSONObject.put("parentUuid", this.fdg);
            }
            jSONObject.put("tid", this.aVt);
            jSONObject.put("videoUrl", this.biU);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gl(this.fdh));
            jSONObject.put("urlType", this.fdi);
            jSONObject.put("sub_error", this.fdA);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fdy)) {
                jSONObject.put("error_stack", this.fdy);
            }
            if (this.fdz != null) {
                int size = this.fdz.size();
                for (int i = 0; i < size; i++) {
                    this.fdz.get(i).W(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aWX() {
        JSONArray jSONArray = new JSONArray();
        if (this.fdj == null) {
            return jSONArray;
        }
        int size = this.fdj.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fdj.get(i).bmg());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fdz == null) {
            this.fdz = new ArrayList();
        }
        this.fdz.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void iQ(boolean z) {
        this.fdv = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aWQ() {
        return this.fdf;
    }

    @Override // com.baidu.tieba.j.i
    public String aWR() {
        return this.fdA + "";
    }
}
