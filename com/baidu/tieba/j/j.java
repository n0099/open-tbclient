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
    private long hpA;
    private boolean hpB;
    private boolean hpE;
    private String hpF;
    private List<b> hpG;
    private int hpH;
    private String hpI;
    private String hpJ;
    private long hpK;
    private long hpL;
    private long hpM;
    private long hpN;
    private long hpO;
    private int hpP;
    private String hpn;
    private int hpo;
    private int hpp;
    private com.baidu.tieba.j.a.b hps;
    private com.baidu.tieba.j.a.d hpt;
    private List<com.baidu.tieba.j.a.c> hpu;
    private long hpy;
    private long hpz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hpC = true;
    private boolean hpD = false;
    private String hpm = UUID.randomUUID().toString();
    private Map<String, Long> hpr = new HashMap();
    private List<com.baidu.tieba.m.c> hpq = new ArrayList();
    private long hpv = 0;
    private long hpw = 0;
    private long hpx = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bVL = str;
        this.bUZ = str2;
        this.hpn = str3;
        bMh();
    }

    @Override // com.baidu.tieba.j.i
    public void bLS() {
        this.hpv = System.currentTimeMillis();
        this.hpq.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void An(String str) {
        As(str);
        this.hpq.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void As(String str) {
        if (!StringUtils.isNull(str)) {
            this.hpp = VideoPlatformStatic.rR(str);
            if (this.hpp != 0) {
                this.hpB = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bLT() {
        this.hpq.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bLU() {
        if (this.mCurrentState != 2) {
            this.hpv = System.currentTimeMillis();
            this.hpq.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hpv = System.currentTimeMillis();
        As(str);
        this.hpq.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void wI(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hpo = i;
            this.hpC = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hpv;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hpr.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hpv = 0L;
            this.hpw = System.currentTimeMillis();
            this.hpq.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void wJ(int i) {
        if (this.mCurrentState == 5) {
            bMa();
        } else if (this.mCurrentState == 3) {
            this.hpo = i;
            this.hpq.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bLV() {
        if (this.hpw != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hpx += currentTimeMillis - this.hpw;
            this.hpw = currentTimeMillis;
        }
        this.hpy++;
        this.hpA = System.currentTimeMillis();
        this.hpq.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bLW() {
        this.hpw = System.currentTimeMillis();
        if (this.hpA != 0) {
            this.hpz += System.currentTimeMillis() - this.hpA;
        }
        this.hpq.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bLX() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hpw != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hpx += currentTimeMillis - this.hpw;
                this.hpw = currentTimeMillis;
            }
            this.hpq.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bMa() {
        if (this.mCurrentState == 5) {
            this.hpw = System.currentTimeMillis();
            this.hpq.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Ao(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.rS(str);
            bMc();
            this.hpq.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Fr();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String Ap(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hpm;
        }
        this.mSource = VideoPlatformStatic.rS(str);
        bMc();
        this.hpr.put("stallDuration", Long.valueOf(this.hpz));
        this.hpq.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Fr();
        return this.hpm;
    }

    @Override // com.baidu.tieba.j.i
    public boolean Aq(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.rS(str);
        bMc();
        this.hpq.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Fr();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hpt == null && com.baidu.adp.lib.util.f.gs()) {
                this.hpt = new com.baidu.tieba.j.a.d(this.hpm);
                a(this.hpt);
            }
            if (this.hpt != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hpt.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aoB())) {
            if (this.hps == null && com.baidu.adp.lib.util.f.gs()) {
                this.hps = new com.baidu.tieba.j.a.b(this.hpm);
                a(this.hps);
            }
            if (this.hps != null) {
                if (this.hps.size() == 0) {
                    this.hpH = i2;
                }
                this.hps.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hpu == null) {
            this.hpu = new ArrayList();
        }
        this.hpu.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hpm;
        }
        this.hpo = i;
        this.hpC = false;
        this.hpD = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.rS(str);
        bMc();
        if (!v.aa(this.hpu)) {
            int size = this.hpu.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hpu.get(i4);
                if (cVar != null) {
                    cVar.bMp();
                }
            }
        }
        this.hpq.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bMb()));
        this.mCurrentState = -1;
        Fr();
        return this.hpm;
    }

    private com.baidu.tieba.j.a.e[] bMb() {
        if (this.hpu == null || this.hpu.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hpu.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hpu.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hpu.get(i2).bMn();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Ar(String str) {
        this.hpF = str;
    }

    private void bMc() {
        if (this.hpw != 0) {
            this.hpx += System.currentTimeMillis() - this.hpw;
        }
        this.hpr.put("playDuration", Long.valueOf(this.hpx));
        this.hpr.put("stallCount", Long.valueOf(this.hpy));
        this.hpr.put("stallDuration", Long.valueOf(this.hpz));
        if (!this.hpr.containsKey("loadingTime")) {
            this.hpr.put("loadingTime", 0L);
        }
        this.hpv = 0L;
        this.hpw = 0L;
        this.hpx = 0L;
        this.hpy = 0L;
        this.hpz = 0L;
        this.hpA = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Fr() {
        if (!this.hpE) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aow() || !this.hpC) && reportType != 3) {
                this.hpE = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aBh());
                            jSONObject.put("kpiInfo", j.this.bMd());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hpC)) {
                                JSONObject bMf = j.this.bMf();
                                bMf.put("running", j.this.bMg());
                                jSONObject.put("debugInfo", bMf);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bMf());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.cqy().c(jSONObject, j.this.hpC ? false : true);
                        if (j.this.hpG != null) {
                            j.this.hpG.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aBh() {
        JSONObject aBh = VideoPlatformStatic.aBh();
        if (this.hpG != null) {
            try {
                int size = this.hpG.size();
                for (int i = 0; i < size; i++) {
                    this.hpG.get(i).bJ(aBh);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aBh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMd() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hpr.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hpr.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hpr.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hpr.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hpr.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hpB ? 1 : 0);
            jSONObject.put("playSuccess", this.hpC ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bMe());
            jSONObject.put("retryError", this.hpD ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.hpG != null) {
                int size = this.hpG.size();
                for (int i = 0; i < size; i++) {
                    this.hpG.get(i).bK(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bMe() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hpI);
            jSONObject.put("tid", this.hpJ);
            jSONObject.put("preparedTime", this.hpK);
            jSONObject.put("startTime", this.hpL);
            jSONObject.put("totalTime", this.hpM);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hpN);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hpO);
            jSONObject.put("autoPlay", this.hpP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bMh();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.hpm);
            if (!StringUtils.isNull(this.hpn)) {
                jSONObject.put("parentUuid", this.hpn);
            }
            jSONObject.put("tid", this.bVL);
            jSONObject.put("videoUrl", this.bUZ);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.me(this.hpo));
            jSONObject.put("urlType", this.hpp);
            jSONObject.put("sub_error", this.hpH);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hpF)) {
                jSONObject.put("error_stack", this.hpF);
            }
            if (this.hpG != null) {
                int size = this.hpG.size();
                for (int i = 0; i < size; i++) {
                    this.hpG.get(i).bL(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bMg() {
        JSONArray jSONArray = new JSONArray();
        if (this.hpq == null) {
            return jSONArray;
        }
        int size = this.hpq.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hpq.get(i).ccp());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hpG == null) {
            this.hpG = new ArrayList();
        }
        this.hpG.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void ni(boolean z) {
        this.hpC = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bLY() {
        return this.hpm;
    }

    @Override // com.baidu.tieba.j.i
    public String bLZ() {
        return this.hpH + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ap.isEmpty(str)) {
            str = NotifyAdapterUtil.PRIMARY_CHANNEL;
        }
        this.hpI = str;
        this.hpK = j;
        this.hpL = j2;
        this.hpM = j3;
        this.hpN = j4;
        this.hpO = j5;
        this.hpJ = str2;
        this.hpP = i;
    }

    private void bMh() {
        this.hpI = NotifyAdapterUtil.PRIMARY_CHANNEL;
        this.hpK = 0L;
        this.hpL = 0L;
        this.hpM = 0L;
        this.hpN = 0L;
        this.hpO = 0L;
        this.hpJ = "";
        this.hpP = 0;
    }
}
