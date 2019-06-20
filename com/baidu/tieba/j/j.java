package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.VideoPlatformStatic;
import com.coremedia.iso.boxes.UserBox;
import com.tencent.connect.share.QzonePublish;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j implements i {
    private String bVM;
    private String bVa;
    private long hpC;
    private long hpD;
    private long hpE;
    private boolean hpF;
    private boolean hpI;
    private String hpJ;
    private List<b> hpK;
    private int hpL;
    private String hpM;
    private String hpN;
    private long hpO;
    private long hpP;
    private long hpQ;
    private long hpR;
    private long hpS;
    private int hpT;
    private String hpr;
    private int hps;
    private int hpt;
    private com.baidu.tieba.j.a.b hpw;
    private com.baidu.tieba.j.a.d hpx;
    private List<com.baidu.tieba.j.a.c> hpy;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hpG = true;
    private boolean hpH = false;
    private String hpq = UUID.randomUUID().toString();
    private Map<String, Long> hpv = new HashMap();
    private List<com.baidu.tieba.m.c> hpu = new ArrayList();
    private long hpz = 0;
    private long hpA = 0;
    private long hpB = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bVM = str;
        this.bVa = str2;
        this.hpr = str3;
        bMl();
    }

    @Override // com.baidu.tieba.j.i
    public void bLW() {
        this.hpz = System.currentTimeMillis();
        this.hpu.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void Ap(String str) {
        Au(str);
        this.hpu.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void Au(String str) {
        if (!StringUtils.isNull(str)) {
            this.hpt = VideoPlatformStatic.rQ(str);
            if (this.hpt != 0) {
                this.hpF = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bLX() {
        this.hpu.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bLY() {
        if (this.mCurrentState != 2) {
            this.hpz = System.currentTimeMillis();
            this.hpu.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hpz = System.currentTimeMillis();
        Au(str);
        this.hpu.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void wI(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hps = i;
            this.hpG = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hpz;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hpv.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hpz = 0L;
            this.hpA = System.currentTimeMillis();
            this.hpu.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void wJ(int i) {
        if (this.mCurrentState == 5) {
            bMe();
        } else if (this.mCurrentState == 3) {
            this.hps = i;
            this.hpu.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bLZ() {
        if (this.hpA != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hpB += currentTimeMillis - this.hpA;
            this.hpA = currentTimeMillis;
        }
        this.hpC++;
        this.hpE = System.currentTimeMillis();
        this.hpu.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bMa() {
        this.hpA = System.currentTimeMillis();
        if (this.hpE != 0) {
            this.hpD += System.currentTimeMillis() - this.hpE;
        }
        this.hpu.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bMb() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hpA != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hpB += currentTimeMillis - this.hpA;
                this.hpA = currentTimeMillis;
            }
            this.hpu.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bMe() {
        if (this.mCurrentState == 5) {
            this.hpA = System.currentTimeMillis();
            this.hpu.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Aq(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.rR(str);
            bMg();
            this.hpu.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Fr();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String Ar(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hpq;
        }
        this.mSource = VideoPlatformStatic.rR(str);
        bMg();
        this.hpv.put("stallDuration", Long.valueOf(this.hpD));
        this.hpu.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Fr();
        return this.hpq;
    }

    @Override // com.baidu.tieba.j.i
    public boolean As(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.rR(str);
        bMg();
        this.hpu.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Fr();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hpx == null && com.baidu.adp.lib.util.f.gs()) {
                this.hpx = new com.baidu.tieba.j.a.d(this.hpq);
                a(this.hpx);
            }
            if (this.hpx != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hpx.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aoB())) {
            if (this.hpw == null && com.baidu.adp.lib.util.f.gs()) {
                this.hpw = new com.baidu.tieba.j.a.b(this.hpq);
                a(this.hpw);
            }
            if (this.hpw != null) {
                if (this.hpw.size() == 0) {
                    this.hpL = i2;
                }
                this.hpw.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hpy == null) {
            this.hpy = new ArrayList();
        }
        this.hpy.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hpq;
        }
        this.hps = i;
        this.hpG = false;
        this.hpH = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.rR(str);
        bMg();
        if (!v.aa(this.hpy)) {
            int size = this.hpy.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hpy.get(i4);
                if (cVar != null) {
                    cVar.bMt();
                }
            }
        }
        this.hpu.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bMf()));
        this.mCurrentState = -1;
        Fr();
        return this.hpq;
    }

    private com.baidu.tieba.j.a.e[] bMf() {
        if (this.hpy == null || this.hpy.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hpy.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hpy.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hpy.get(i2).bMr();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void At(String str) {
        this.hpJ = str;
    }

    private void bMg() {
        if (this.hpA != 0) {
            this.hpB += System.currentTimeMillis() - this.hpA;
        }
        this.hpv.put("playDuration", Long.valueOf(this.hpB));
        this.hpv.put("stallCount", Long.valueOf(this.hpC));
        this.hpv.put("stallDuration", Long.valueOf(this.hpD));
        if (!this.hpv.containsKey("loadingTime")) {
            this.hpv.put("loadingTime", 0L);
        }
        this.hpz = 0L;
        this.hpA = 0L;
        this.hpB = 0L;
        this.hpC = 0L;
        this.hpD = 0L;
        this.hpE = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Fr() {
        if (!this.hpI) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aow() || !this.hpG) && reportType != 3) {
                this.hpI = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aBk());
                            jSONObject.put("kpiInfo", j.this.bMh());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hpG)) {
                                JSONObject bMj = j.this.bMj();
                                bMj.put("running", j.this.bMk());
                                jSONObject.put("debugInfo", bMj);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bMj());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.cqB().c(jSONObject, j.this.hpG ? false : true);
                        if (j.this.hpK != null) {
                            j.this.hpK.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aBk() {
        JSONObject aBk = VideoPlatformStatic.aBk();
        if (this.hpK != null) {
            try {
                int size = this.hpK.size();
                for (int i = 0; i < size; i++) {
                    this.hpK.get(i).bJ(aBk);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aBk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMh() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hpv.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hpv.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hpv.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hpv.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hpv.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hpF ? 1 : 0);
            jSONObject.put("playSuccess", this.hpG ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bMi());
            jSONObject.put("retryError", this.hpH ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.hpK != null) {
                int size = this.hpK.size();
                for (int i = 0; i < size; i++) {
                    this.hpK.get(i).bK(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bMi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hpM);
            jSONObject.put("tid", this.hpN);
            jSONObject.put("preparedTime", this.hpO);
            jSONObject.put("startTime", this.hpP);
            jSONObject.put("totalTime", this.hpQ);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hpR);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hpS);
            jSONObject.put("autoPlay", this.hpT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bMl();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.hpq);
            if (!StringUtils.isNull(this.hpr)) {
                jSONObject.put("parentUuid", this.hpr);
            }
            jSONObject.put("tid", this.bVM);
            jSONObject.put("videoUrl", this.bVa);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.me(this.hps));
            jSONObject.put("urlType", this.hpt);
            jSONObject.put("sub_error", this.hpL);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hpJ)) {
                jSONObject.put("error_stack", this.hpJ);
            }
            if (this.hpK != null) {
                int size = this.hpK.size();
                for (int i = 0; i < size; i++) {
                    this.hpK.get(i).bL(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bMk() {
        JSONArray jSONArray = new JSONArray();
        if (this.hpu == null) {
            return jSONArray;
        }
        int size = this.hpu.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hpu.get(i).cct());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hpK == null) {
            this.hpK = new ArrayList();
        }
        this.hpK.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void nj(boolean z) {
        this.hpG = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bMc() {
        return this.hpq;
    }

    @Override // com.baidu.tieba.j.i
    public String bMd() {
        return this.hpL + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ap.isEmpty(str)) {
            str = NotifyAdapterUtil.PRIMARY_CHANNEL;
        }
        this.hpM = str;
        this.hpO = j;
        this.hpP = j2;
        this.hpQ = j3;
        this.hpR = j4;
        this.hpS = j5;
        this.hpN = str2;
        this.hpT = i;
    }

    private void bMl() {
        this.hpM = NotifyAdapterUtil.PRIMARY_CHANNEL;
        this.hpO = 0L;
        this.hpP = 0L;
        this.hpQ = 0L;
        this.hpR = 0L;
        this.hpS = 0L;
        this.hpN = "";
        this.hpT = 0;
    }
}
