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
    private String eQH;
    private int eQI;
    private int eQJ;
    private com.baidu.tieba.j.a.b eQM;
    private com.baidu.tieba.j.a.d eQN;
    private List<com.baidu.tieba.j.a.c> eQO;
    private long eQS;
    private long eQT;
    private long eQU;
    private boolean eQV;
    private boolean eQY;
    private String eQZ;
    private List<b> eRa;
    private int eRb;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean eQW = true;
    private boolean eQX = false;
    private String eQG = UUID.randomUUID().toString();
    private Map<String, Long> eQL = new HashMap();
    private List<com.baidu.tieba.m.c> eQK = new ArrayList();
    private long eQP = 0;
    private long eQQ = 0;
    private long eQR = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aNu = str;
        this.baI = str2;
        this.eQH = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aRM() {
        this.eQP = System.currentTimeMillis();
        this.eQK.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void pI(String str) {
        pN(str);
        this.eQK.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void pN(String str) {
        if (!StringUtils.isNull(str)) {
            this.eQJ = VideoPlatformStatic.hU(str);
            if (this.eQJ != 0) {
                this.eQV = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aRN() {
        this.eQK.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aRO() {
        if (this.mCurrentState != 2) {
            this.eQP = System.currentTimeMillis();
            this.eQK.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.eQP = System.currentTimeMillis();
        pN(str);
        this.eQK.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void pD(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.eQI = i;
            this.eQW = true;
            long currentTimeMillis = System.currentTimeMillis() - this.eQP;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.eQL.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.eQP = 0L;
            this.eQQ = System.currentTimeMillis();
            this.eQK.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pE(int i) {
        if (this.mCurrentState == 5) {
            aRV();
        } else if (this.mCurrentState == 3) {
            this.eQI = i;
            this.eQK.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aRP() {
        if (this.eQQ != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eQR += currentTimeMillis - this.eQQ;
            this.eQQ = currentTimeMillis;
        }
        this.eQS++;
        this.eQU = System.currentTimeMillis();
        this.eQK.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aRQ() {
        this.eQQ = System.currentTimeMillis();
        if (this.eQU != 0) {
            this.eQT += System.currentTimeMillis() - this.eQU;
        }
        this.eQK.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aRR() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.eQQ != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.eQR += currentTimeMillis - this.eQQ;
                this.eQQ = currentTimeMillis;
            }
            this.eQK.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aRV() {
        if (this.mCurrentState == 5) {
            this.eQQ = System.currentTimeMillis();
            this.eQK.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pJ(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.hV(str);
            aRX();
            this.eQK.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aRS();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String pK(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eQG;
        }
        this.mSource = VideoPlatformStatic.hV(str);
        aRX();
        this.eQL.put("stallDuration", Long.valueOf(this.eQT));
        this.eQK.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aRS();
        return this.eQG;
    }

    @Override // com.baidu.tieba.j.i
    public boolean pL(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.hV(str);
        aRX();
        this.eQK.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aRS();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.eQN == null && com.baidu.adp.lib.util.f.m9do()) {
                this.eQN = new com.baidu.tieba.j.a.d(this.eQG);
                a(this.eQN);
            }
            if (this.eQN != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.eQN.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Bw())) {
            if (this.eQM == null && com.baidu.adp.lib.util.f.m9do()) {
                this.eQM = new com.baidu.tieba.j.a.b(this.eQG);
                a(this.eQM);
            }
            if (this.eQM != null) {
                if (this.eQM.size() == 0) {
                    this.eRb = i2;
                }
                this.eQM.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.eQO == null) {
            this.eQO = new ArrayList();
        }
        this.eQO.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eQG;
        }
        this.eQI = i;
        this.eQW = false;
        this.eQX = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hV(str);
        aRX();
        if (!v.w(this.eQO)) {
            int size = this.eQO.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.eQO.get(i4);
                if (cVar != null) {
                    cVar.aSg();
                }
            }
        }
        this.eQK.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aRW()));
        this.mCurrentState = -1;
        aRS();
        return this.eQG;
    }

    private com.baidu.tieba.j.a.e[] aRW() {
        if (this.eQO == null || this.eQO.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.eQO.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eQO.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.eQO.get(i2).aSe();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pM(String str) {
        this.eQZ = str;
    }

    private void aRX() {
        if (this.eQQ != 0) {
            this.eQR += System.currentTimeMillis() - this.eQQ;
        }
        this.eQL.put("playDuration", Long.valueOf(this.eQR));
        this.eQL.put("stallCount", Long.valueOf(this.eQS));
        this.eQL.put("stallDuration", Long.valueOf(this.eQT));
        if (!this.eQL.containsKey("loadingTime")) {
            this.eQL.put("loadingTime", 0L);
        }
        this.eQP = 0L;
        this.eQQ = 0L;
        this.eQR = 0L;
        this.eQS = 0L;
        this.eQT = 0L;
        this.eQU = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aRS() {
        if (!this.eQY) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Br() || !this.eQW) && reportType != 3) {
                this.eQY = true;
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
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.eQW)) {
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
                        com.baidu.tieba.r.e.bvJ().c(jSONObject, j.this.eQW ? false : true);
                        if (j.this.eRa != null) {
                            j.this.eRa.clear();
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
        if (this.eRa != null) {
            try {
                int size = this.eRa.size();
                for (int i = 0; i < size; i++) {
                    this.eRa.get(i).P(MB);
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
            for (Map.Entry<String, Long> entry : this.eQL.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.eQL.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.eQL.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.eQL.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.eQL.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.eQV ? 1 : 0);
            jSONObject.put("playSuccess", this.eQW ? 1 : 0);
            jSONObject.put("retryError", this.eQX ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.eRa != null) {
                int size = this.eRa.size();
                for (int i = 0; i < size; i++) {
                    this.eRa.get(i).Q(jSONObject);
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
            jSONObject.put(UserBox.TYPE, this.eQG);
            if (!StringUtils.isNull(this.eQH)) {
                jSONObject.put("parentUuid", this.eQH);
            }
            jSONObject.put("tid", this.aNu);
            jSONObject.put("videoUrl", this.baI);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gj(this.eQI));
            jSONObject.put("urlType", this.eQJ);
            jSONObject.put("sub_error", this.eRb);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.eQZ)) {
                jSONObject.put("error_stack", this.eQZ);
            }
            if (this.eRa != null) {
                int size = this.eRa.size();
                for (int i = 0; i < size; i++) {
                    this.eRa.get(i).R(jSONObject);
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
        if (this.eQK == null) {
            return jSONArray;
        }
        int size = this.eQK.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.eQK.get(i).bhi());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.eRa == null) {
            this.eRa = new ArrayList();
        }
        this.eRa.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void iJ(boolean z) {
        this.eQW = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aRT() {
        return this.eQG;
    }

    @Override // com.baidu.tieba.j.i
    public String aRU() {
        return this.eRb + "";
    }
}
