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
    private String aWq;
    private String bdb;
    private String fha;
    private int fhb;
    private int fhc;
    private com.baidu.tieba.j.a.b fhf;
    private com.baidu.tieba.j.a.d fhg;
    private List<com.baidu.tieba.j.a.c> fhh;
    private long fhl;
    private long fhm;
    private long fhn;
    private boolean fho;
    private boolean fhr;
    private String fhs;
    private List<b> fht;
    private int fhu;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fhp = true;
    private boolean fhq = false;
    private String fgZ = UUID.randomUUID().toString();
    private Map<String, Long> fhe = new HashMap();
    private List<com.baidu.tieba.m.c> fhd = new ArrayList();
    private long fhi = 0;
    private long fhj = 0;
    private long fhk = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aWq = str;
        this.bdb = str2;
        this.fha = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aVF() {
        this.fhi = System.currentTimeMillis();
        this.fhd.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void qu(String str) {
        qz(str);
        this.fhd.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void qz(String str) {
        if (!StringUtils.isNull(str)) {
            this.fhc = VideoPlatformStatic.ix(str);
            if (this.fhc != 0) {
                this.fho = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aVG() {
        this.fhd.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aVH() {
        if (this.mCurrentState != 2) {
            this.fhi = System.currentTimeMillis();
            this.fhd.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fhi = System.currentTimeMillis();
        qz(str);
        this.fhd.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void pS(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fhb = i;
            this.fhp = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fhi;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fhe.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fhi = 0L;
            this.fhj = System.currentTimeMillis();
            this.fhd.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pT(int i) {
        if (this.mCurrentState == 5) {
            aVO();
        } else if (this.mCurrentState == 3) {
            this.fhb = i;
            this.fhd.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aVI() {
        if (this.fhj != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fhk += currentTimeMillis - this.fhj;
            this.fhj = currentTimeMillis;
        }
        this.fhl++;
        this.fhn = System.currentTimeMillis();
        this.fhd.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aVJ() {
        this.fhj = System.currentTimeMillis();
        if (this.fhn != 0) {
            this.fhm += System.currentTimeMillis() - this.fhn;
        }
        this.fhd.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aVK() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fhj != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fhk += currentTimeMillis - this.fhj;
                this.fhj = currentTimeMillis;
            }
            this.fhd.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aVO() {
        if (this.mCurrentState == 5) {
            this.fhj = System.currentTimeMillis();
            this.fhd.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qv(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.iy(str);
            aVQ();
            this.fhd.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aVL();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String qw(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fgZ;
        }
        this.mSource = VideoPlatformStatic.iy(str);
        aVQ();
        this.fhe.put("stallDuration", Long.valueOf(this.fhm));
        this.fhd.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aVL();
        return this.fgZ;
    }

    @Override // com.baidu.tieba.j.i
    public boolean qx(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.iy(str);
        aVQ();
        this.fhd.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aVL();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fhg == null && com.baidu.adp.lib.util.f.gd()) {
                this.fhg = new com.baidu.tieba.j.a.d(this.fgZ);
                a(this.fhg);
            }
            if (this.fhg != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fhg.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Fj())) {
            if (this.fhf == null && com.baidu.adp.lib.util.f.gd()) {
                this.fhf = new com.baidu.tieba.j.a.b(this.fgZ);
                a(this.fhf);
            }
            if (this.fhf != null) {
                if (this.fhf.size() == 0) {
                    this.fhu = i2;
                }
                this.fhf.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fhh == null) {
            this.fhh = new ArrayList();
        }
        this.fhh.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fgZ;
        }
        this.fhb = i;
        this.fhp = false;
        this.fhq = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.iy(str);
        aVQ();
        if (!w.z(this.fhh)) {
            int size = this.fhh.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fhh.get(i4);
                if (cVar != null) {
                    cVar.aWb();
                }
            }
        }
        this.fhd.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aVP()));
        this.mCurrentState = -1;
        aVL();
        return this.fgZ;
    }

    private com.baidu.tieba.j.a.e[] aVP() {
        if (this.fhh == null || this.fhh.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fhh.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fhh.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fhh.get(i2).aVZ();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qy(String str) {
        this.fhs = str;
    }

    private void aVQ() {
        if (this.fhj != 0) {
            this.fhk += System.currentTimeMillis() - this.fhj;
        }
        this.fhe.put("playDuration", Long.valueOf(this.fhk));
        this.fhe.put("stallCount", Long.valueOf(this.fhl));
        this.fhe.put("stallDuration", Long.valueOf(this.fhm));
        if (!this.fhe.containsKey("loadingTime")) {
            this.fhe.put("loadingTime", 0L);
        }
        this.fhi = 0L;
        this.fhj = 0L;
        this.fhk = 0L;
        this.fhl = 0L;
        this.fhm = 0L;
        this.fhn = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aVL() {
        if (!this.fhr) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Fe() || !this.fhp) && reportType != 3) {
                this.fhr = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.QH());
                            jSONObject.put("kpiInfo", j.this.aVR());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fhp)) {
                                JSONObject aVS = j.this.aVS();
                                aVS.put("running", j.this.aVT());
                                jSONObject.put("debugInfo", aVS);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aVS());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.bzT().b(jSONObject, j.this.fhp ? false : true);
                        if (j.this.fht != null) {
                            j.this.fht.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject QH() {
        JSONObject QH = VideoPlatformStatic.QH();
        if (this.fht != null) {
            try {
                int size = this.fht.size();
                for (int i = 0; i < size; i++) {
                    this.fht.get(i).S(QH);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return QH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVR() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fhe.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fhe.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fhe.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fhe.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fhe.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fho ? 1 : 0);
            jSONObject.put("playSuccess", this.fhp ? 1 : 0);
            jSONObject.put("retryError", this.fhq ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fht != null) {
                int size = this.fht.size();
                for (int i = 0; i < size; i++) {
                    this.fht.get(i).T(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fgZ);
            if (!StringUtils.isNull(this.fha)) {
                jSONObject.put("parentUuid", this.fha);
            }
            jSONObject.put("tid", this.aWq);
            jSONObject.put("videoUrl", this.bdb);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gq(this.fhb));
            jSONObject.put("urlType", this.fhc);
            jSONObject.put("sub_error", this.fhu);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fhs)) {
                jSONObject.put("error_stack", this.fhs);
            }
            if (this.fht != null) {
                int size = this.fht.size();
                for (int i = 0; i < size; i++) {
                    this.fht.get(i).U(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aVT() {
        JSONArray jSONArray = new JSONArray();
        if (this.fhd == null) {
            return jSONArray;
        }
        int size = this.fhd.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fhd.get(i).bla());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fht == null) {
            this.fht = new ArrayList();
        }
        this.fht.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void iM(boolean z) {
        this.fhp = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aVM() {
        return this.fgZ;
    }

    @Override // com.baidu.tieba.j.i
    public String aVN() {
        return this.fhu + "";
    }
}
