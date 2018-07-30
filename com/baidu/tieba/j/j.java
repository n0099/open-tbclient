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
    private int fhA;
    private String fhg;
    private int fhh;
    private int fhi;
    private com.baidu.tieba.j.a.b fhl;
    private com.baidu.tieba.j.a.d fhm;
    private List<com.baidu.tieba.j.a.c> fhn;
    private long fhr;
    private long fhs;
    private long fht;
    private boolean fhu;
    private boolean fhx;
    private String fhy;
    private List<b> fhz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fhv = true;
    private boolean fhw = false;
    private String fhf = UUID.randomUUID().toString();
    private Map<String, Long> fhk = new HashMap();
    private List<com.baidu.tieba.m.c> fhj = new ArrayList();
    private long fho = 0;
    private long fhp = 0;
    private long fhq = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aWq = str;
        this.bdb = str2;
        this.fhg = str3;
    }

    @Override // com.baidu.tieba.j.i
    public void aVJ() {
        this.fho = System.currentTimeMillis();
        this.fhj.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void qs(String str) {
        qx(str);
        this.fhj.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void qx(String str) {
        if (!StringUtils.isNull(str)) {
            this.fhi = VideoPlatformStatic.iw(str);
            if (this.fhi != 0) {
                this.fhu = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aVK() {
        this.fhj.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void aVL() {
        if (this.mCurrentState != 2) {
            this.fho = System.currentTimeMillis();
            this.fhj.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fho = System.currentTimeMillis();
        qx(str);
        this.fhj.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void pS(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fhh = i;
            this.fhv = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fho;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.fhk.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fho = 0L;
            this.fhp = System.currentTimeMillis();
            this.fhj.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void pT(int i) {
        if (this.mCurrentState == 5) {
            aVS();
        } else if (this.mCurrentState == 3) {
            this.fhh = i;
            this.fhj.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void aVM() {
        if (this.fhp != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fhq += currentTimeMillis - this.fhp;
            this.fhp = currentTimeMillis;
        }
        this.fhr++;
        this.fht = System.currentTimeMillis();
        this.fhj.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void aVN() {
        this.fhp = System.currentTimeMillis();
        if (this.fht != 0) {
            this.fhs += System.currentTimeMillis() - this.fht;
        }
        this.fhj.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void aVO() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fhp != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fhq += currentTimeMillis - this.fhp;
                this.fhp = currentTimeMillis;
            }
            this.fhj.add(new com.baidu.tieba.m.a(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION));
            this.mCurrentState = 5;
        }
    }

    public void aVS() {
        if (this.mCurrentState == 5) {
            this.fhp = System.currentTimeMillis();
            this.fhj.add(new com.baidu.tieba.m.a(HttpStatus.SC_NO_CONTENT));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qt(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.ix(str);
            aVU();
            this.fhj.add(new com.baidu.tieba.m.a(HttpStatus.SC_RESET_CONTENT));
            this.mCurrentState = 8;
            aVP();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String qu(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fhf;
        }
        this.mSource = VideoPlatformStatic.ix(str);
        aVU();
        this.fhk.put("stallDuration", Long.valueOf(this.fhs));
        this.fhj.add(new com.baidu.tieba.m.a(HttpStatus.SC_PARTIAL_CONTENT));
        this.mCurrentState = 6;
        aVP();
        return this.fhf;
    }

    @Override // com.baidu.tieba.j.i
    public boolean qv(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.ix(str);
        aVU();
        this.fhj.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        aVP();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fhm == null && com.baidu.adp.lib.util.f.gd()) {
                this.fhm = new com.baidu.tieba.j.a.d(this.fhf);
                a(this.fhm);
            }
            if (this.fhm != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fhm.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Fj())) {
            if (this.fhl == null && com.baidu.adp.lib.util.f.gd()) {
                this.fhl = new com.baidu.tieba.j.a.b(this.fhf);
                a(this.fhl);
            }
            if (this.fhl != null) {
                if (this.fhl.size() == 0) {
                    this.fhA = i2;
                }
                this.fhl.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fhn == null) {
            this.fhn = new ArrayList();
        }
        this.fhn.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fhf;
        }
        this.fhh = i;
        this.fhv = false;
        this.fhw = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.ix(str);
        aVU();
        if (!w.z(this.fhn)) {
            int size = this.fhn.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fhn.get(i4);
                if (cVar != null) {
                    cVar.aWf();
                }
            }
        }
        this.fhj.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, aVT()));
        this.mCurrentState = -1;
        aVP();
        return this.fhf;
    }

    private com.baidu.tieba.j.a.e[] aVT() {
        if (this.fhn == null || this.fhn.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fhn.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fhn.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fhn.get(i2).aWd();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void qw(String str) {
        this.fhy = str;
    }

    private void aVU() {
        if (this.fhp != 0) {
            this.fhq += System.currentTimeMillis() - this.fhp;
        }
        this.fhk.put("playDuration", Long.valueOf(this.fhq));
        this.fhk.put("stallCount", Long.valueOf(this.fhr));
        this.fhk.put("stallDuration", Long.valueOf(this.fhs));
        if (!this.fhk.containsKey("loadingTime")) {
            this.fhk.put("loadingTime", 0L);
        }
        this.fho = 0L;
        this.fhp = 0L;
        this.fhq = 0L;
        this.fhr = 0L;
        this.fhs = 0L;
        this.fht = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void aVP() {
        if (!this.fhx) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Fe() || !this.fhv) && reportType != 3) {
                this.fhx = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.QC());
                            jSONObject.put("kpiInfo", j.this.aVV());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fhv)) {
                                JSONObject aVW = j.this.aVW();
                                aVW.put("running", j.this.aVX());
                                jSONObject.put("debugInfo", aVW);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.aVW());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.bzR().c(jSONObject, j.this.fhv ? false : true);
                        if (j.this.fhz != null) {
                            j.this.fhz.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject QC() {
        JSONObject QC = VideoPlatformStatic.QC();
        if (this.fhz != null) {
            try {
                int size = this.fhz.size();
                for (int i = 0; i < size; i++) {
                    this.fhz.get(i).S(QC);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return QC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVV() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fhk.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fhk.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fhk.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fhk.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fhk.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fhu ? 1 : 0);
            jSONObject.put("playSuccess", this.fhv ? 1 : 0);
            jSONObject.put("retryError", this.fhw ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.fhz != null) {
                int size = this.fhz.size();
                for (int i = 0; i < size; i++) {
                    this.fhz.get(i).T(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.fhf);
            if (!StringUtils.isNull(this.fhg)) {
                jSONObject.put("parentUuid", this.fhg);
            }
            jSONObject.put("tid", this.aWq);
            jSONObject.put("videoUrl", this.bdb);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.gr(this.fhh));
            jSONObject.put("urlType", this.fhi);
            jSONObject.put("sub_error", this.fhA);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fhy)) {
                jSONObject.put("error_stack", this.fhy);
            }
            if (this.fhz != null) {
                int size = this.fhz.size();
                for (int i = 0; i < size; i++) {
                    this.fhz.get(i).U(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray aVX() {
        JSONArray jSONArray = new JSONArray();
        if (this.fhj == null) {
            return jSONArray;
        }
        int size = this.fhj.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fhj.get(i).bld());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fhz == null) {
            this.fhz = new ArrayList();
        }
        this.fhz.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void iM(boolean z) {
        this.fhv = z;
    }

    @Override // com.baidu.tieba.j.i
    public String aVQ() {
        return this.fhf;
    }

    @Override // com.baidu.tieba.j.i
    public String aVR() {
        return this.fhA + "";
    }
}
