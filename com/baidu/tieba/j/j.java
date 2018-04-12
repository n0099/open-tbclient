package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.util.v;
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
    private String aNu;
    private String baI;
    private String eQK;
    private int eQL;
    private int eQM;
    private com.baidu.tieba.j.a.b eQP;
    private com.baidu.tieba.j.a.d eQQ;
    private List<com.baidu.tieba.j.a.c> eQR;
    private long eQV;
    private long eQW;
    private long eQX;
    private boolean eQY;
    private boolean eRb;
    private String eRc;
    private List<b> eRd;
    private int eRe;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean eQZ = true;
    private boolean eRa = false;
    private String eQJ = UUID.randomUUID().toString();
    private Map<String, Long> eQO = new HashMap();
    private List<com.baidu.tieba.m.c> eQN = new ArrayList();
    private long eQS = 0;
    private long eQT = 0;
    private long eQU = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aNu = str;
        this.baI = str2;
        this.eQK = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aRM() {
        this.eQS = System.currentTimeMillis();
        this.eQN.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void pI(String str) {
        pN(str);
        this.eQN.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void pN(String str) {
        if (!StringUtils.isNull(str)) {
            this.eQM = VideoPlatformStatic.hU(str);
            if (this.eQM != 0) {
                this.eQY = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aRN() {
        this.eQN.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aRO() {
        if (this.mCurrentState != 2) {
            this.eQS = System.currentTimeMillis();
            this.eQN.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.eQS = System.currentTimeMillis();
        pN(str);
        this.eQN.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void pE(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.eQL = i;
            this.eQZ = true;
            long currentTimeMillis = System.currentTimeMillis() - this.eQS;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.eQO.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.eQS = 0L;
            this.eQT = System.currentTimeMillis();
            this.eQN.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pF(int i) {
        if (this.mCurrentState == 5) {
            aRV();
        } else if (this.mCurrentState == 3) {
            this.eQL = i;
            this.eQN.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aRP() {
        if (this.eQT != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eQU += currentTimeMillis - this.eQT;
            this.eQT = currentTimeMillis;
        }
        this.eQV++;
        this.eQX = System.currentTimeMillis();
        this.eQN.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aRQ() {
        this.eQT = System.currentTimeMillis();
        if (this.eQX != 0) {
            this.eQW += System.currentTimeMillis() - this.eQX;
        }
        this.eQN.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aRR() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.eQT != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.eQU += currentTimeMillis - this.eQT;
                this.eQT = currentTimeMillis;
            }
            this.eQN.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aRV() {
        if (this.mCurrentState == 5) {
            this.eQT = System.currentTimeMillis();
            this.eQN.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pJ(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.hV(str);
            aRX();
            this.eQN.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aRS();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String pK(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eQJ;
        }
        this.mSource = VideoPlatformStatic.hV(str);
        aRX();
        this.eQO.put("stallDuration", Long.valueOf(this.eQW));
        this.eQN.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aRS();
        return this.eQJ;
    }

    @Override // com.baidu.tieba.j.i
    public boolean pL(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.hV(str);
        aRX();
        this.eQN.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aRS();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.eQQ == null && com.baidu.adp.lib.util.f.m9do()) {
                this.eQQ = new com.baidu.tieba.j.a.d(this.eQJ);
                a(this.eQQ);
            }
            if (this.eQQ != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.eQQ.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Bw())) {
            if (this.eQP == null && com.baidu.adp.lib.util.f.m9do()) {
                this.eQP = new com.baidu.tieba.j.a.b(this.eQJ);
                a(this.eQP);
            }
            if (this.eQP != null) {
                if (this.eQP.size() == 0) {
                    this.eRe = i2;
                }
                this.eQP.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.eQR == null) {
            this.eQR = new ArrayList();
        }
        this.eQR.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eQJ;
        }
        this.eQL = i;
        this.eQZ = false;
        this.eRa = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hV(str);
        aRX();
        if (!v.w(this.eQR)) {
            int size = this.eQR.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.eQR.get(i4);
                if (cVar != null) {
                    cVar.aSg();
                }
            }
        }
        this.eQN.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aRW()));
        this.mCurrentState = -1;
        aRS();
        return this.eQJ;
    }

    private com.baidu.tieba.j.a.e[] aRW() {
        if (this.eQR == null || this.eQR.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.eQR.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eQR.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.eQR.get(i2).aSe();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pM(String str) {
        this.eRc = str;
    }

    private void aRX() {
        if (this.eQT != 0) {
            this.eQU += System.currentTimeMillis() - this.eQT;
        }
        this.eQO.put("playDuration", Long.valueOf(this.eQU));
        this.eQO.put("stallCount", Long.valueOf(this.eQV));
        this.eQO.put("stallDuration", Long.valueOf(this.eQW));
        if (!this.eQO.containsKey("loadingTime")) {
            this.eQO.put("loadingTime", 0L);
        }
        this.eQS = 0L;
        this.eQT = 0L;
        this.eQU = 0L;
        this.eQV = 0L;
        this.eQW = 0L;
        this.eQX = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aRS() {
        if (!this.eRb) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Br() || !this.eQZ) && reportType != 3) {
                this.eRb = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.MB());
                            jSONObject.put("kpiInfo", j.this.aRY());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.eQZ)) {
                                JSONObject aRZ = j.this.aRZ();
                                aRZ.put("running", j.this.aSa());
                                jSONObject.put("debugInfo", aRZ);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aRZ());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.r.e.bvJ().c(jSONObject, j.this.eQZ ? false : true);
                        if (j.this.eRd != null) {
                            j.this.eRd.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject MB() {
        JSONObject MB = VideoPlatformStatic.MB();
        if (this.eRd != null) {
            try {
                int size = this.eRd.size();
                for (int i = 0; i < size; i++) {
                    this.eRd.get(i).P(MB);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return MB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aRY() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.eQO.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.eQO.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.eQO.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.eQO.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.eQO.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.eQY ? 1 : 0);
            jSONObject.put("playSuccess", this.eQZ ? 1 : 0);
            jSONObject.put("retryError", this.eRa ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.eRd != null) {
                int size = this.eRd.size();
                for (int i = 0; i < size; i++) {
                    this.eRd.get(i).Q(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aRZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.eQJ);
            if (!StringUtils.isNull(this.eQK)) {
                jSONObject.put("parentUuid", this.eQK);
            }
            jSONObject.put("tid", this.aNu);
            jSONObject.put("videoUrl", this.baI);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gk(this.eQL));
            jSONObject.put("urlType", this.eQM);
            jSONObject.put("sub_error", this.eRe);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.eRc)) {
                jSONObject.put("error_stack", this.eRc);
            }
            if (this.eRd != null) {
                int size = this.eRd.size();
                for (int i = 0; i < size; i++) {
                    this.eRd.get(i).R(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aSa() {
        JSONArray jSONArray = new JSONArray();
        if (this.eQN == null) {
            return jSONArray;
        }
        int size = this.eQN.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.eQN.get(i).bhi());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.eRd == null) {
            this.eRd = new ArrayList();
        }
        this.eRd.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void iJ(boolean z) {
        this.eQZ = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aRT() {
        return this.eQJ;
    }

    @Override // com.baidu.tieba.j.i
    public String aRU() {
        return this.eRe + "";
    }
}
