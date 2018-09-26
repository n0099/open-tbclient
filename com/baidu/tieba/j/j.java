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
    private String aZG;
    private String avN;
    private com.baidu.tieba.j.a.b foC;
    private com.baidu.tieba.j.a.d foD;
    private List<com.baidu.tieba.j.a.c> foE;
    private long foI;
    private long foJ;
    private long foK;
    private boolean foL;
    private boolean foO;
    private String foP;
    private List<b> foQ;
    private int foR;
    private String fox;
    private int foy;
    private int foz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean foM = true;
    private boolean foN = false;
    private String fow = UUID.randomUUID().toString();
    private Map<String, Long> foB = new HashMap();
    private List<com.baidu.tieba.m.c> foA = new ArrayList();
    private long foF = 0;
    private long foG = 0;
    private long foH = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aZG = str;
        this.avN = str2;
        this.fox = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aXT() {
        this.foF = System.currentTimeMillis();
        this.foA.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void qZ(String str) {
        re(str);
        this.foA.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void re(String str) {
        if (!StringUtils.isNull(str)) {
            this.foz = VideoPlatformStatic.iZ(str);
            if (this.foz != 0) {
                this.foL = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aXU() {
        this.foA.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aXV() {
        if (this.mCurrentState != 2) {
            this.foF = System.currentTimeMillis();
            this.foA.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.foF = System.currentTimeMillis();
        re(str);
        this.foA.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void qw(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.foy = i;
            this.foM = true;
            long currentTimeMillis = System.currentTimeMillis() - this.foF;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.foB.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.foF = 0L;
            this.foG = System.currentTimeMillis();
            this.foA.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qx(int i) {
        if (this.mCurrentState == 5) {
            aYc();
        } else if (this.mCurrentState == 3) {
            this.foy = i;
            this.foA.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aXW() {
        if (this.foG != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.foH += currentTimeMillis - this.foG;
            this.foG = currentTimeMillis;
        }
        this.foI++;
        this.foK = System.currentTimeMillis();
        this.foA.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aXX() {
        this.foG = System.currentTimeMillis();
        if (this.foK != 0) {
            this.foJ += System.currentTimeMillis() - this.foK;
        }
        this.foA.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aXY() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.foG != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.foH += currentTimeMillis - this.foG;
                this.foG = currentTimeMillis;
            }
            this.foA.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aYc() {
        if (this.mCurrentState == 5) {
            this.foG = System.currentTimeMillis();
            this.foA.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void ra(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.ja(str);
            aYe();
            this.foA.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aXZ();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String rb(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fow;
        }
        this.mSource = VideoPlatformStatic.ja(str);
        aYe();
        this.foB.put("stallDuration", Long.valueOf(this.foJ));
        this.foA.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aXZ();
        return this.fow;
    }

    @Override // com.baidu.tieba.j.i
    public boolean rc(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.ja(str);
        aYe();
        this.foA.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aXZ();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.foD == null && com.baidu.adp.lib.util.f.hk()) {
                this.foD = new com.baidu.tieba.j.a.d(this.fow);
                a(this.foD);
            }
            if (this.foD != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.foD.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Gz())) {
            if (this.foC == null && com.baidu.adp.lib.util.f.hk()) {
                this.foC = new com.baidu.tieba.j.a.b(this.fow);
                a(this.foC);
            }
            if (this.foC != null) {
                if (this.foC.size() == 0) {
                    this.foR = i2;
                }
                this.foC.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.foE == null) {
            this.foE = new ArrayList();
        }
        this.foE.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fow;
        }
        this.foy = i;
        this.foM = false;
        this.foN = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.ja(str);
        aYe();
        if (!v.z(this.foE)) {
            int size = this.foE.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.foE.get(i4);
                if (cVar != null) {
                    cVar.aYp();
                }
            }
        }
        this.foA.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aYd()));
        this.mCurrentState = -1;
        aXZ();
        return this.fow;
    }

    private com.baidu.tieba.j.a.e[] aYd() {
        if (this.foE == null || this.foE.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.foE.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.foE.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.foE.get(i2).aYn();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rd(String str) {
        this.foP = str;
    }

    private void aYe() {
        if (this.foG != 0) {
            this.foH += System.currentTimeMillis() - this.foG;
        }
        this.foB.put("playDuration", Long.valueOf(this.foH));
        this.foB.put("stallCount", Long.valueOf(this.foI));
        this.foB.put("stallDuration", Long.valueOf(this.foJ));
        if (!this.foB.containsKey("loadingTime")) {
            this.foB.put("loadingTime", 0L);
        }
        this.foF = 0L;
        this.foG = 0L;
        this.foH = 0L;
        this.foI = 0L;
        this.foJ = 0L;
        this.foK = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aXZ() {
        if (!this.foO) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Gu() || !this.foM) && reportType != 3) {
                this.foO = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.Sv());
                            jSONObject.put("kpiInfo", j.this.aYf());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.foM)) {
                                JSONObject aYg = j.this.aYg();
                                aYg.put("running", j.this.aYh());
                                jSONObject.put("debugInfo", aYg);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aYg());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.bCI().b(jSONObject, j.this.foM ? false : true);
                        if (j.this.foQ != null) {
                            j.this.foQ.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Sv() {
        JSONObject Sv = VideoPlatformStatic.Sv();
        if (this.foQ != null) {
            try {
                int size = this.foQ.size();
                for (int i = 0; i < size; i++) {
                    this.foQ.get(i).ac(Sv);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Sv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aYf() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.foB.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.foB.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.foB.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.foB.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.foB.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.foL ? 1 : 0);
            jSONObject.put("playSuccess", this.foM ? 1 : 0);
            jSONObject.put("retryError", this.foN ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.foQ != null) {
                int size = this.foQ.size();
                for (int i = 0; i < size; i++) {
                    this.foQ.get(i).ad(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aYg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fow);
            if (!StringUtils.isNull(this.fox)) {
                jSONObject.put("parentUuid", this.fox);
            }
            jSONObject.put("tid", this.aZG);
            jSONObject.put("videoUrl", this.avN);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gQ(this.foy));
            jSONObject.put("urlType", this.foz);
            jSONObject.put("sub_error", this.foR);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.foP)) {
                jSONObject.put("error_stack", this.foP);
            }
            if (this.foQ != null) {
                int size = this.foQ.size();
                for (int i = 0; i < size; i++) {
                    this.foQ.get(i).ae(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aYh() {
        JSONArray jSONArray = new JSONArray();
        if (this.foA == null) {
            return jSONArray;
        }
        int size = this.foA.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.foA.get(i).bnG());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.foQ == null) {
            this.foQ = new ArrayList();
        }
        this.foQ.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jk(boolean z) {
        this.foM = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aYa() {
        return this.fow;
    }

    @Override // com.baidu.tieba.j.i
    public String aYb() {
        return this.foR + "";
    }
}
