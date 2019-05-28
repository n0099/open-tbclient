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
    private String bUZ;
    private String bVL;
    private long hpB;
    private long hpC;
    private long hpD;
    private boolean hpE;
    private boolean hpH;
    private String hpI;
    private List<b> hpJ;
    private int hpK;
    private String hpL;
    private String hpM;
    private long hpN;
    private long hpO;
    private long hpP;
    private long hpQ;
    private long hpR;
    private int hpS;
    private String hpq;
    private int hpr;
    private int hps;
    private com.baidu.tieba.j.a.b hpv;
    private com.baidu.tieba.j.a.d hpw;
    private List<com.baidu.tieba.j.a.c> hpx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hpF = true;
    private boolean hpG = false;
    private String hpp = UUID.randomUUID().toString();
    private Map<String, Long> hpu = new HashMap();
    private List<com.baidu.tieba.m.c> hpt = new ArrayList();
    private long hpy = 0;
    private long hpz = 0;
    private long hpA = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bVL = str;
        this.bUZ = str2;
        this.hpq = str3;
        bMk();
    }

    @Override // com.baidu.tieba.j.i
    public void bLV() {
        this.hpy = System.currentTimeMillis();
        this.hpt.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void An(String str) {
        As(str);
        this.hpt.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void As(String str) {
        if (!StringUtils.isNull(str)) {
            this.hps = VideoPlatformStatic.rR(str);
            if (this.hps != 0) {
                this.hpE = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bLW() {
        this.hpt.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bLX() {
        if (this.mCurrentState != 2) {
            this.hpy = System.currentTimeMillis();
            this.hpt.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hpy = System.currentTimeMillis();
        As(str);
        this.hpt.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void wI(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hpr = i;
            this.hpF = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hpy;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hpu.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hpy = 0L;
            this.hpz = System.currentTimeMillis();
            this.hpt.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void wJ(int i) {
        if (this.mCurrentState == 5) {
            bMd();
        } else if (this.mCurrentState == 3) {
            this.hpr = i;
            this.hpt.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bLY() {
        if (this.hpz != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hpA += currentTimeMillis - this.hpz;
            this.hpz = currentTimeMillis;
        }
        this.hpB++;
        this.hpD = System.currentTimeMillis();
        this.hpt.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bLZ() {
        this.hpz = System.currentTimeMillis();
        if (this.hpD != 0) {
            this.hpC += System.currentTimeMillis() - this.hpD;
        }
        this.hpt.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bMa() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hpz != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hpA += currentTimeMillis - this.hpz;
                this.hpz = currentTimeMillis;
            }
            this.hpt.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bMd() {
        if (this.mCurrentState == 5) {
            this.hpz = System.currentTimeMillis();
            this.hpt.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Ao(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.rS(str);
            bMf();
            this.hpt.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Fr();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String Ap(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hpp;
        }
        this.mSource = VideoPlatformStatic.rS(str);
        bMf();
        this.hpu.put("stallDuration", Long.valueOf(this.hpC));
        this.hpt.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Fr();
        return this.hpp;
    }

    @Override // com.baidu.tieba.j.i
    public boolean Aq(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.rS(str);
        bMf();
        this.hpt.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Fr();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hpw == null && com.baidu.adp.lib.util.f.gs()) {
                this.hpw = new com.baidu.tieba.j.a.d(this.hpp);
                a(this.hpw);
            }
            if (this.hpw != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hpw.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aoB())) {
            if (this.hpv == null && com.baidu.adp.lib.util.f.gs()) {
                this.hpv = new com.baidu.tieba.j.a.b(this.hpp);
                a(this.hpv);
            }
            if (this.hpv != null) {
                if (this.hpv.size() == 0) {
                    this.hpK = i2;
                }
                this.hpv.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hpx == null) {
            this.hpx = new ArrayList();
        }
        this.hpx.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hpp;
        }
        this.hpr = i;
        this.hpF = false;
        this.hpG = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.rS(str);
        bMf();
        if (!v.aa(this.hpx)) {
            int size = this.hpx.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hpx.get(i4);
                if (cVar != null) {
                    cVar.bMs();
                }
            }
        }
        this.hpt.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bMe()));
        this.mCurrentState = -1;
        Fr();
        return this.hpp;
    }

    private com.baidu.tieba.j.a.e[] bMe() {
        if (this.hpx == null || this.hpx.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hpx.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hpx.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hpx.get(i2).bMq();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Ar(String str) {
        this.hpI = str;
    }

    private void bMf() {
        if (this.hpz != 0) {
            this.hpA += System.currentTimeMillis() - this.hpz;
        }
        this.hpu.put("playDuration", Long.valueOf(this.hpA));
        this.hpu.put("stallCount", Long.valueOf(this.hpB));
        this.hpu.put("stallDuration", Long.valueOf(this.hpC));
        if (!this.hpu.containsKey("loadingTime")) {
            this.hpu.put("loadingTime", 0L);
        }
        this.hpy = 0L;
        this.hpz = 0L;
        this.hpA = 0L;
        this.hpB = 0L;
        this.hpC = 0L;
        this.hpD = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Fr() {
        if (!this.hpH) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aow() || !this.hpF) && reportType != 3) {
                this.hpH = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aBk());
                            jSONObject.put("kpiInfo", j.this.bMg());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hpF)) {
                                JSONObject bMi = j.this.bMi();
                                bMi.put("running", j.this.bMj());
                                jSONObject.put("debugInfo", bMi);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bMi());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.cqA().c(jSONObject, j.this.hpF ? false : true);
                        if (j.this.hpJ != null) {
                            j.this.hpJ.clear();
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
        if (this.hpJ != null) {
            try {
                int size = this.hpJ.size();
                for (int i = 0; i < size; i++) {
                    this.hpJ.get(i).bJ(aBk);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aBk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMg() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hpu.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hpu.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hpu.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hpu.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hpu.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hpE ? 1 : 0);
            jSONObject.put("playSuccess", this.hpF ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bMh());
            jSONObject.put("retryError", this.hpG ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.hpJ != null) {
                int size = this.hpJ.size();
                for (int i = 0; i < size; i++) {
                    this.hpJ.get(i).bK(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bMh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hpL);
            jSONObject.put("tid", this.hpM);
            jSONObject.put("preparedTime", this.hpN);
            jSONObject.put("startTime", this.hpO);
            jSONObject.put("totalTime", this.hpP);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hpQ);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hpR);
            jSONObject.put("autoPlay", this.hpS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bMk();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.hpp);
            if (!StringUtils.isNull(this.hpq)) {
                jSONObject.put("parentUuid", this.hpq);
            }
            jSONObject.put("tid", this.bVL);
            jSONObject.put("videoUrl", this.bUZ);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.me(this.hpr));
            jSONObject.put("urlType", this.hps);
            jSONObject.put("sub_error", this.hpK);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hpI)) {
                jSONObject.put("error_stack", this.hpI);
            }
            if (this.hpJ != null) {
                int size = this.hpJ.size();
                for (int i = 0; i < size; i++) {
                    this.hpJ.get(i).bL(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bMj() {
        JSONArray jSONArray = new JSONArray();
        if (this.hpt == null) {
            return jSONArray;
        }
        int size = this.hpt.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hpt.get(i).ccs());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hpJ == null) {
            this.hpJ = new ArrayList();
        }
        this.hpJ.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void ni(boolean z) {
        this.hpF = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bMb() {
        return this.hpp;
    }

    @Override // com.baidu.tieba.j.i
    public String bMc() {
        return this.hpK + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ap.isEmpty(str)) {
            str = NotifyAdapterUtil.PRIMARY_CHANNEL;
        }
        this.hpL = str;
        this.hpN = j;
        this.hpO = j2;
        this.hpP = j3;
        this.hpQ = j4;
        this.hpR = j5;
        this.hpM = str2;
        this.hpS = i;
    }

    private void bMk() {
        this.hpL = NotifyAdapterUtil.PRIMARY_CHANNEL;
        this.hpN = 0L;
        this.hpO = 0L;
        this.hpP = 0L;
        this.hpQ = 0L;
        this.hpR = 0L;
        this.hpM = "";
        this.hpS = 0;
    }
}
