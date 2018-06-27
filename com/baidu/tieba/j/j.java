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
    private String aWo;
    private String bcS;
    private String fgX;
    private int fgY;
    private int fgZ;
    private com.baidu.tieba.j.a.b fhc;
    private com.baidu.tieba.j.a.d fhd;
    private List<com.baidu.tieba.j.a.c> fhe;
    private long fhi;
    private long fhj;
    private long fhk;
    private boolean fhl;
    private boolean fho;
    private String fhp;
    private List<b> fhq;
    private int fhr;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fhm = true;
    private boolean fhn = false;
    private String fgW = UUID.randomUUID().toString();
    private Map<String, Long> fhb = new HashMap();
    private List<com.baidu.tieba.m.c> fha = new ArrayList();
    private long fhf = 0;
    private long fhg = 0;
    private long fhh = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aWo = str;
        this.bcS = str2;
        this.fgX = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aXq() {
        this.fhf = System.currentTimeMillis();
        this.fha.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void qz(String str) {
        qE(str);
        this.fha.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void qE(String str) {
        if (!StringUtils.isNull(str)) {
            this.fgZ = VideoPlatformStatic.iz(str);
            if (this.fgZ != 0) {
                this.fhl = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aXr() {
        this.fha.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aXs() {
        if (this.mCurrentState != 2) {
            this.fhf = System.currentTimeMillis();
            this.fha.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fhf = System.currentTimeMillis();
        qE(str);
        this.fha.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void pV(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fgY = i;
            this.fhm = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fhf;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fhb.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fhf = 0L;
            this.fhg = System.currentTimeMillis();
            this.fha.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pW(int i) {
        if (this.mCurrentState == 5) {
            aXz();
        } else if (this.mCurrentState == 3) {
            this.fgY = i;
            this.fha.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aXt() {
        if (this.fhg != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fhh += currentTimeMillis - this.fhg;
            this.fhg = currentTimeMillis;
        }
        this.fhi++;
        this.fhk = System.currentTimeMillis();
        this.fha.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aXu() {
        this.fhg = System.currentTimeMillis();
        if (this.fhk != 0) {
            this.fhj += System.currentTimeMillis() - this.fhk;
        }
        this.fha.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aXv() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fhg != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fhh += currentTimeMillis - this.fhg;
                this.fhg = currentTimeMillis;
            }
            this.fha.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aXz() {
        if (this.mCurrentState == 5) {
            this.fhg = System.currentTimeMillis();
            this.fha.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qA(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.iA(str);
            aXB();
            this.fha.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aXw();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String qB(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fgW;
        }
        this.mSource = VideoPlatformStatic.iA(str);
        aXB();
        this.fhb.put("stallDuration", Long.valueOf(this.fhj));
        this.fha.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aXw();
        return this.fgW;
    }

    @Override // com.baidu.tieba.j.i
    public boolean qC(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.iA(str);
        aXB();
        this.fha.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aXw();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fhd == null && com.baidu.adp.lib.util.f.ge()) {
                this.fhd = new com.baidu.tieba.j.a.d(this.fgW);
                a(this.fhd);
            }
            if (this.fhd != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fhd.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Fn())) {
            if (this.fhc == null && com.baidu.adp.lib.util.f.ge()) {
                this.fhc = new com.baidu.tieba.j.a.b(this.fgW);
                a(this.fhc);
            }
            if (this.fhc != null) {
                if (this.fhc.size() == 0) {
                    this.fhr = i2;
                }
                this.fhc.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fhe == null) {
            this.fhe = new ArrayList();
        }
        this.fhe.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fgW;
        }
        this.fgY = i;
        this.fhm = false;
        this.fhn = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.iA(str);
        aXB();
        if (!w.A(this.fhe)) {
            int size = this.fhe.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fhe.get(i4);
                if (cVar != null) {
                    cVar.aXK();
                }
            }
        }
        this.fha.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aXA()));
        this.mCurrentState = -1;
        aXw();
        return this.fgW;
    }

    private com.baidu.tieba.j.a.e[] aXA() {
        if (this.fhe == null || this.fhe.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fhe.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fhe.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fhe.get(i2).aXI();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qD(String str) {
        this.fhp = str;
    }

    private void aXB() {
        if (this.fhg != 0) {
            this.fhh += System.currentTimeMillis() - this.fhg;
        }
        this.fhb.put("playDuration", Long.valueOf(this.fhh));
        this.fhb.put("stallCount", Long.valueOf(this.fhi));
        this.fhb.put("stallDuration", Long.valueOf(this.fhj));
        if (!this.fhb.containsKey("loadingTime")) {
            this.fhb.put("loadingTime", 0L);
        }
        this.fhf = 0L;
        this.fhg = 0L;
        this.fhh = 0L;
        this.fhi = 0L;
        this.fhj = 0L;
        this.fhk = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aXw() {
        if (!this.fho) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Fi() || !this.fhm) && reportType != 3) {
                this.fho = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Qv());
                            jSONObject.put("kpiInfo", j.this.aXC());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fhm)) {
                                JSONObject aXD = j.this.aXD();
                                aXD.put("running", j.this.aXE());
                                jSONObject.put("debugInfo", aXD);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aXD());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.t.e.bBo().c(jSONObject, j.this.fhm ? false : true);
                        if (j.this.fhq != null) {
                            j.this.fhq.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Qv() {
        JSONObject Qv = VideoPlatformStatic.Qv();
        if (this.fhq != null) {
            try {
                int size = this.fhq.size();
                for (int i = 0; i < size; i++) {
                    this.fhq.get(i).T(Qv);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Qv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXC() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fhb.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fhb.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fhb.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fhb.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fhb.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fhl ? 1 : 0);
            jSONObject.put("playSuccess", this.fhm ? 1 : 0);
            jSONObject.put("retryError", this.fhn ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fhq != null) {
                int size = this.fhq.size();
                for (int i = 0; i < size; i++) {
                    this.fhq.get(i).U(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fgW);
            if (!StringUtils.isNull(this.fgX)) {
                jSONObject.put("parentUuid", this.fgX);
            }
            jSONObject.put("tid", this.aWo);
            jSONObject.put("videoUrl", this.bcS);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gm(this.fgY));
            jSONObject.put("urlType", this.fgZ);
            jSONObject.put("sub_error", this.fhr);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fhp)) {
                jSONObject.put("error_stack", this.fhp);
            }
            if (this.fhq != null) {
                int size = this.fhq.size();
                for (int i = 0; i < size; i++) {
                    this.fhq.get(i).V(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aXE() {
        JSONArray jSONArray = new JSONArray();
        if (this.fha == null) {
            return jSONArray;
        }
        int size = this.fha.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fha.get(i).bmK());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fhq == null) {
            this.fhq = new ArrayList();
        }
        this.fhq.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void ja(boolean z) {
        this.fhm = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aXx() {
        return this.fgW;
    }

    @Override // com.baidu.tieba.j.i
    public String aXy() {
        return this.fhr + "";
    }
}
