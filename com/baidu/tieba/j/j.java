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
    private String aNv;
    private String baJ;
    private String eRO;
    private int eRP;
    private int eRQ;
    private com.baidu.tieba.j.a.b eRT;
    private com.baidu.tieba.j.a.d eRU;
    private List<com.baidu.tieba.j.a.c> eRV;
    private long eRZ;
    private long eSa;
    private long eSb;
    private boolean eSc;
    private boolean eSf;
    private String eSg;
    private List<b> eSh;
    private int eSi;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean eSd = true;
    private boolean eSe = false;
    private String eRN = UUID.randomUUID().toString();
    private Map<String, Long> eRS = new HashMap();
    private List<com.baidu.tieba.m.c> eRR = new ArrayList();
    private long eRW = 0;
    private long eRX = 0;
    private long eRY = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aNv = str;
        this.baJ = str2;
        this.eRO = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aRM() {
        this.eRW = System.currentTimeMillis();
        this.eRR.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void pL(String str) {
        pQ(str);
        this.eRR.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void pQ(String str) {
        if (!StringUtils.isNull(str)) {
            this.eRQ = VideoPlatformStatic.hV(str);
            if (this.eRQ != 0) {
                this.eSc = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aRN() {
        this.eRR.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aRO() {
        if (this.mCurrentState != 2) {
            this.eRW = System.currentTimeMillis();
            this.eRR.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.eRW = System.currentTimeMillis();
        pQ(str);
        this.eRR.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void pC(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.eRP = i;
            this.eSd = true;
            long currentTimeMillis = System.currentTimeMillis() - this.eRW;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.eRS.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.eRW = 0L;
            this.eRX = System.currentTimeMillis();
            this.eRR.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pD(int i) {
        if (this.mCurrentState == 5) {
            aRV();
        } else if (this.mCurrentState == 3) {
            this.eRP = i;
            this.eRR.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aRP() {
        if (this.eRX != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eRY += currentTimeMillis - this.eRX;
            this.eRX = currentTimeMillis;
        }
        this.eRZ++;
        this.eSb = System.currentTimeMillis();
        this.eRR.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aRQ() {
        this.eRX = System.currentTimeMillis();
        if (this.eSb != 0) {
            this.eSa += System.currentTimeMillis() - this.eSb;
        }
        this.eRR.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aRR() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.eRX != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.eRY += currentTimeMillis - this.eRX;
                this.eRX = currentTimeMillis;
            }
            this.eRR.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aRV() {
        if (this.mCurrentState == 5) {
            this.eRX = System.currentTimeMillis();
            this.eRR.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pM(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.hW(str);
            aRX();
            this.eRR.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aRS();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String pN(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eRN;
        }
        this.mSource = VideoPlatformStatic.hW(str);
        aRX();
        this.eRS.put("stallDuration", Long.valueOf(this.eSa));
        this.eRR.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aRS();
        return this.eRN;
    }

    @Override // com.baidu.tieba.j.i
    public boolean pO(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.hW(str);
        aRX();
        this.eRR.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aRS();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.eRU == null && com.baidu.adp.lib.util.f.m9do()) {
                this.eRU = new com.baidu.tieba.j.a.d(this.eRN);
                a(this.eRU);
            }
            if (this.eRU != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.eRU.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Bu())) {
            if (this.eRT == null && com.baidu.adp.lib.util.f.m9do()) {
                this.eRT = new com.baidu.tieba.j.a.b(this.eRN);
                a(this.eRT);
            }
            if (this.eRT != null) {
                if (this.eRT.size() == 0) {
                    this.eSi = i2;
                }
                this.eRT.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.eRV == null) {
            this.eRV = new ArrayList();
        }
        this.eRV.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.eRN;
        }
        this.eRP = i;
        this.eSd = false;
        this.eSe = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.hW(str);
        aRX();
        if (!v.w(this.eRV)) {
            int size = this.eRV.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.eRV.get(i4);
                if (cVar != null) {
                    cVar.aSg();
                }
            }
        }
        this.eRR.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aRW()));
        this.mCurrentState = -1;
        aRS();
        return this.eRN;
    }

    private com.baidu.tieba.j.a.e[] aRW() {
        if (this.eRV == null || this.eRV.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.eRV.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eRV.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.eRV.get(i2).aSe();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pP(String str) {
        this.eSg = str;
    }

    private void aRX() {
        if (this.eRX != 0) {
            this.eRY += System.currentTimeMillis() - this.eRX;
        }
        this.eRS.put("playDuration", Long.valueOf(this.eRY));
        this.eRS.put("stallCount", Long.valueOf(this.eRZ));
        this.eRS.put("stallDuration", Long.valueOf(this.eSa));
        if (!this.eRS.containsKey("loadingTime")) {
            this.eRS.put("loadingTime", 0L);
        }
        this.eRW = 0L;
        this.eRX = 0L;
        this.eRY = 0L;
        this.eRZ = 0L;
        this.eSa = 0L;
        this.eSb = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aRS() {
        if (!this.eSf) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Bp() || !this.eSd) && reportType != 3) {
                this.eSf = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Mz());
                            jSONObject.put("kpiInfo", j.this.aRY());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.eSd)) {
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
                        com.baidu.tieba.r.e.bvH().c(jSONObject, j.this.eSd ? false : true);
                        if (j.this.eSh != null) {
                            j.this.eSh.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Mz() {
        JSONObject Mz = VideoPlatformStatic.Mz();
        if (this.eSh != null) {
            try {
                int size = this.eSh.size();
                for (int i = 0; i < size; i++) {
                    this.eSh.get(i).P(Mz);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Mz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aRY() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.eRS.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.eRS.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.eRS.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.eRS.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.eRS.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.eSc ? 1 : 0);
            jSONObject.put("playSuccess", this.eSd ? 1 : 0);
            jSONObject.put("retryError", this.eSe ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.eSh != null) {
                int size = this.eSh.size();
                for (int i = 0; i < size; i++) {
                    this.eSh.get(i).Q(jSONObject);
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
            jSONObject.put(UserBox.TYPE, this.eRN);
            if (!StringUtils.isNull(this.eRO)) {
                jSONObject.put("parentUuid", this.eRO);
            }
            jSONObject.put("tid", this.aNv);
            jSONObject.put("videoUrl", this.baJ);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gk(this.eRP));
            jSONObject.put("urlType", this.eRQ);
            jSONObject.put("sub_error", this.eSi);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.eSg)) {
                jSONObject.put("error_stack", this.eSg);
            }
            if (this.eSh != null) {
                int size = this.eSh.size();
                for (int i = 0; i < size; i++) {
                    this.eSh.get(i).R(jSONObject);
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
        if (this.eRR == null) {
            return jSONArray;
        }
        int size = this.eRR.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.eRR.get(i).bhi());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.eSh == null) {
            this.eSh = new ArrayList();
        }
        this.eSh.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void iK(boolean z) {
        this.eSd = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aRT() {
        return this.eRN;
    }

    @Override // com.baidu.tieba.j.i
    public String aRU() {
        return this.eSi + "";
    }
}
