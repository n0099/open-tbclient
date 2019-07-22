package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
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
    private String bWO;
    private String bWb;
    private String hvD;
    private int hvE;
    private int hvF;
    private com.baidu.tieba.j.a.b hvI;
    private com.baidu.tieba.j.a.d hvJ;
    private List<com.baidu.tieba.j.a.c> hvK;
    private long hvO;
    private long hvP;
    private long hvQ;
    private boolean hvR;
    private boolean hvU;
    private String hvV;
    private List<b> hvW;
    private int hvX;
    private String hvY;
    private String hvZ;
    private long hwa;
    private long hwb;
    private long hwc;
    private long hwd;
    private long hwe;
    private int hwf;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hvS = true;
    private boolean hvT = false;
    private String hvC = UUID.randomUUID().toString();
    private Map<String, Long> hvH = new HashMap();
    private List<com.baidu.tieba.m.c> hvG = new ArrayList();
    private long hvL = 0;
    private long hvM = 0;
    private long hvN = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bWO = str;
        this.bWb = str2;
        this.hvD = str3;
        bOT();
    }

    @Override // com.baidu.tieba.j.i
    public void bOE() {
        this.hvL = System.currentTimeMillis();
        this.hvG.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void Ba(String str) {
        Bf(str);
        this.hvG.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void Bf(String str) {
        if (!StringUtils.isNull(str)) {
            this.hvF = VideoPlatformStatic.si(str);
            if (this.hvF != 0) {
                this.hvR = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bOF() {
        this.hvG.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bOG() {
        if (this.mCurrentState != 2) {
            this.hvL = System.currentTimeMillis();
            this.hvG.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hvL = System.currentTimeMillis();
        Bf(str);
        this.hvG.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void xl(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hvE = i;
            this.hvS = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hvL;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hvH.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hvL = 0L;
            this.hvM = System.currentTimeMillis();
            this.hvG.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void xm(int i) {
        if (this.mCurrentState == 5) {
            bOM();
        } else if (this.mCurrentState == 3) {
            this.hvE = i;
            this.hvG.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bOH() {
        if (this.hvM != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hvN += currentTimeMillis - this.hvM;
            this.hvM = currentTimeMillis;
        }
        this.hvO++;
        this.hvQ = System.currentTimeMillis();
        this.hvG.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bOI() {
        this.hvM = System.currentTimeMillis();
        if (this.hvQ != 0) {
            this.hvP += System.currentTimeMillis() - this.hvQ;
        }
        this.hvG.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bOJ() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hvM != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hvN += currentTimeMillis - this.hvM;
                this.hvM = currentTimeMillis;
            }
            this.hvG.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bOM() {
        if (this.mCurrentState == 5) {
            this.hvM = System.currentTimeMillis();
            this.hvG.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Bb(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.sj(str);
            bOO();
            this.hvG.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Gb();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String Bc(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hvC;
        }
        this.mSource = VideoPlatformStatic.sj(str);
        bOO();
        this.hvH.put("stallDuration", Long.valueOf(this.hvP));
        this.hvG.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Gb();
        return this.hvC;
    }

    @Override // com.baidu.tieba.j.i
    public boolean Bd(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.sj(str);
        bOO();
        this.hvG.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Gb();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hvJ == null && com.baidu.adp.lib.util.f.gB()) {
                this.hvJ = new com.baidu.tieba.j.a.d(this.hvC);
                a(this.hvJ);
            }
            if (this.hvJ != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hvJ.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.apH())) {
            if (this.hvI == null && com.baidu.adp.lib.util.f.gB()) {
                this.hvI = new com.baidu.tieba.j.a.b(this.hvC);
                a(this.hvI);
            }
            if (this.hvI != null) {
                if (this.hvI.size() == 0) {
                    this.hvX = i2;
                }
                this.hvI.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hvK == null) {
            this.hvK = new ArrayList();
        }
        this.hvK.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hvC;
        }
        this.hvE = i;
        this.hvS = false;
        this.hvT = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.sj(str);
        bOO();
        if (!v.aa(this.hvK)) {
            int size = this.hvK.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hvK.get(i4);
                if (cVar != null) {
                    cVar.bPb();
                }
            }
        }
        this.hvG.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bON()));
        this.mCurrentState = -1;
        Gb();
        return this.hvC;
    }

    private com.baidu.tieba.j.a.e[] bON() {
        if (this.hvK == null || this.hvK.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hvK.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hvK.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hvK.get(i2).bOZ();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Be(String str) {
        this.hvV = str;
    }

    private void bOO() {
        if (this.hvM != 0) {
            this.hvN += System.currentTimeMillis() - this.hvM;
        }
        this.hvH.put("playDuration", Long.valueOf(this.hvN));
        this.hvH.put("stallCount", Long.valueOf(this.hvO));
        this.hvH.put("stallDuration", Long.valueOf(this.hvP));
        if (!this.hvH.containsKey("loadingTime")) {
            this.hvH.put("loadingTime", 0L);
        }
        this.hvL = 0L;
        this.hvM = 0L;
        this.hvN = 0L;
        this.hvO = 0L;
        this.hvP = 0L;
        this.hvQ = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Gb() {
        if (!this.hvU) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.apC() || !this.hvS) && reportType != 3) {
                this.hvU = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aCz());
                            jSONObject.put("kpiInfo", j.this.bOP());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hvS)) {
                                JSONObject bOR = j.this.bOR();
                                bOR.put("running", j.this.bOS());
                                jSONObject.put("debugInfo", bOR);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bOR());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.ctl().c(jSONObject, j.this.hvS ? false : true);
                        if (j.this.hvW != null) {
                            j.this.hvW.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aCz() {
        JSONObject aCz = VideoPlatformStatic.aCz();
        if (this.hvW != null) {
            try {
                int size = this.hvW.size();
                for (int i = 0; i < size; i++) {
                    this.hvW.get(i).bJ(aCz);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aCz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bOP() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hvH.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hvH.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hvH.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hvH.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hvH.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hvR ? 1 : 0);
            jSONObject.put("playSuccess", this.hvS ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bOQ());
            jSONObject.put("retryError", this.hvT ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.hvW != null) {
                int size = this.hvW.size();
                for (int i = 0; i < size; i++) {
                    this.hvW.get(i).bK(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bOQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hvY);
            jSONObject.put("tid", this.hvZ);
            jSONObject.put("preparedTime", this.hwa);
            jSONObject.put("startTime", this.hwb);
            jSONObject.put("totalTime", this.hwc);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hwd);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hwe);
            jSONObject.put("autoPlay", this.hwf);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bOT();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bOR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.hvC);
            if (!StringUtils.isNull(this.hvD)) {
                jSONObject.put("parentUuid", this.hvD);
            }
            jSONObject.put("tid", this.bWO);
            jSONObject.put("videoUrl", this.bWb);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.ml(this.hvE));
            jSONObject.put("urlType", this.hvF);
            jSONObject.put("sub_error", this.hvX);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hvV)) {
                jSONObject.put("error_stack", this.hvV);
            }
            if (this.hvW != null) {
                int size = this.hvW.size();
                for (int i = 0; i < size; i++) {
                    this.hvW.get(i).bL(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bOS() {
        JSONArray jSONArray = new JSONArray();
        if (this.hvG == null) {
            return jSONArray;
        }
        int size = this.hvG.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hvG.get(i).cfj());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hvW == null) {
            this.hvW = new ArrayList();
        }
        this.hvW.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void nx(boolean z) {
        this.hvS = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bOK() {
        return this.hvC;
    }

    @Override // com.baidu.tieba.j.i
    public String bOL() {
        return this.hvX + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (aq.isEmpty(str)) {
            str = NotifyAdapterUtil.PRIMARY_CHANNEL;
        }
        this.hvY = str;
        this.hwa = j;
        this.hwb = j2;
        this.hwc = j3;
        this.hwd = j4;
        this.hwe = j5;
        this.hvZ = str2;
        this.hwf = i;
    }

    private void bOT() {
        this.hvY = NotifyAdapterUtil.PRIMARY_CHANNEL;
        this.hwa = 0L;
        this.hwb = 0L;
        this.hwc = 0L;
        this.hwd = 0L;
        this.hwe = 0L;
        this.hvZ = "";
        this.hwf = 0;
    }
}
