package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.VideoPlatformStatic;
import com.tencent.connect.share.QzonePublish;
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
    private String cln;
    private String cma;
    private boolean hwC;
    private String hwD;
    private List<b> hwE;
    private int hwF;
    private String hwG;
    private String hwH;
    private long hwI;
    private long hwJ;
    private long hwK;
    private long hwL;
    private long hwM;
    private int hwN;
    private String hwl;
    private int hwm;
    private int hwn;
    private com.baidu.tieba.j.a.b hwq;
    private com.baidu.tieba.j.a.d hwr;
    private List<com.baidu.tieba.j.a.c> hws;
    private long hww;
    private long hwx;
    private long hwy;
    private boolean hwz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hwA = true;
    private boolean hwB = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> hwp = new HashMap();
    private List<com.baidu.tieba.m.c> hwo = new ArrayList();
    private long hwt = 0;
    private long hwu = 0;
    private long hwv = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.cma = str;
        this.cln = str2;
        this.hwl = str3;
        bMS();
    }

    @Override // com.baidu.tieba.j.i
    public void bMD() {
        this.hwt = System.currentTimeMillis();
        this.hwo.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void zU(String str) {
        zZ(str);
        this.hwo.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.j.i
    public void nm(boolean z) {
        this.hwz = z;
        this.hwo.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void zZ(String str) {
        if (!StringUtils.isNull(str)) {
            this.hwn = VideoPlatformStatic.rd(str);
            if (this.hwn != 0) {
                this.hwz = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bME() {
        this.hwo.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bMF() {
        if (this.mCurrentState != 2) {
            this.hwt = System.currentTimeMillis();
            this.hwo.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hwt = System.currentTimeMillis();
        zZ(str);
        this.hwo.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void vV(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hwm = i;
            this.hwA = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hwt;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hwp.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hwt = 0L;
            this.hwu = System.currentTimeMillis();
            this.hwo.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void vW(int i) {
        if (this.mCurrentState == 5) {
            bML();
        } else if (this.mCurrentState == 3) {
            this.hwm = i;
            this.hwo.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bMG() {
        if (this.hwu != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hwv += currentTimeMillis - this.hwu;
            this.hwu = currentTimeMillis;
        }
        this.hww++;
        this.hwy = System.currentTimeMillis();
        this.hwo.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bMH() {
        this.hwu = System.currentTimeMillis();
        if (this.hwy != 0) {
            this.hwx += System.currentTimeMillis() - this.hwy;
        }
        this.hwo.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bMI() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hwu != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hwv += currentTimeMillis - this.hwu;
                this.hwu = currentTimeMillis;
            }
            this.hwo.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bML() {
        if (this.mCurrentState == 5) {
            this.hwu = System.currentTimeMillis();
            this.hwo.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void zV(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.re(str);
            bMN();
            this.hwo.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            La();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String zW(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.re(str);
        bMN();
        this.hwp.put("stallDuration", Long.valueOf(this.hwx));
        this.hwo.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        La();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public boolean zX(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.re(str);
        bMN();
        this.hwo.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        La();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hwr == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.hwr = new com.baidu.tieba.j.a.d(this.mUuid);
                a(this.hwr);
            }
            if (this.hwr != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hwr.a(new com.baidu.tieba.play.c.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.arN())) {
            if (this.hwq == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.hwq = new com.baidu.tieba.j.a.b(this.mUuid);
                a(this.hwq);
            }
            if (this.hwq != null) {
                if (this.hwq.size() == 0) {
                    this.hwF = i2;
                }
                this.hwq.a(new com.baidu.tieba.play.c.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hws == null) {
            this.hws = new ArrayList();
        }
        this.hws.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.hwm = i;
        this.hwA = false;
        this.hwB = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.re(str);
        bMN();
        if (!v.isEmpty(this.hws)) {
            int size = this.hws.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hws.get(i4);
                if (cVar != null) {
                    cVar.bNb();
                }
            }
        }
        this.hwo.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bMM()));
        this.mCurrentState = -1;
        La();
        return this.mUuid;
    }

    private com.baidu.tieba.j.a.e[] bMM() {
        if (this.hws == null || this.hws.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hws.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hws.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hws.get(i2).bMZ();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void zY(String str) {
        this.hwD = str;
    }

    private void bMN() {
        if (this.hwu != 0) {
            this.hwv += System.currentTimeMillis() - this.hwu;
        }
        this.hwp.put("playDuration", Long.valueOf(this.hwv));
        this.hwp.put("stallCount", Long.valueOf(this.hww));
        this.hwp.put("stallDuration", Long.valueOf(this.hwx));
        if (!this.hwp.containsKey("loadingTime")) {
            this.hwp.put("loadingTime", 0L);
        }
        this.hwt = 0L;
        this.hwu = 0L;
        this.hwv = 0L;
        this.hww = 0L;
        this.hwx = 0L;
        this.hwy = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void La() {
        if (!this.hwC) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.arI() || !this.hwA) && reportType != 3) {
                this.hwC = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aCW());
                            jSONObject.put("kpiInfo", j.this.bMO());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hwA)) {
                                JSONObject bMQ = j.this.bMQ();
                                bMQ.put("running", j.this.bMR());
                                jSONObject.put("debugInfo", bMQ);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bMQ());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.csi().d(jSONObject, j.this.hwA ? false : true);
                        if (j.this.hwE != null) {
                            j.this.hwE.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aCW() {
        JSONObject aCW = VideoPlatformStatic.aCW();
        if (this.hwE != null) {
            try {
                int size = this.hwE.size();
                for (int i = 0; i < size; i++) {
                    this.hwE.get(i).cj(aCW);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aCW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMO() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hwp.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hwp.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hwp.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hwp.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hwp.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hwz ? 1 : 0);
            jSONObject.put("playSuccess", this.hwA ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bMP());
            jSONObject.put("retryError", this.hwB ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.hwE != null) {
                int size = this.hwE.size();
                for (int i = 0; i < size; i++) {
                    this.hwE.get(i).ck(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bMP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hwG);
            jSONObject.put("tid", this.hwH);
            jSONObject.put("preparedTime", this.hwI);
            jSONObject.put("startTime", this.hwJ);
            jSONObject.put("totalTime", this.hwK);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hwL);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hwM);
            jSONObject.put("autoPlay", this.hwN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bMS();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.hwl)) {
                jSONObject.put("parentUuid", this.hwl);
            }
            jSONObject.put("tid", this.cma);
            jSONObject.put("videoUrl", this.cln);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.lu(this.hwm));
            jSONObject.put("urlType", this.hwn);
            jSONObject.put("sub_error", this.hwF);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hwD)) {
                jSONObject.put("error_stack", this.hwD);
            }
            if (this.hwE != null) {
                int size = this.hwE.size();
                for (int i = 0; i < size; i++) {
                    this.hwE.get(i).cl(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bMR() {
        JSONArray jSONArray = new JSONArray();
        if (this.hwo == null) {
            return jSONArray;
        }
        int size = this.hwo.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hwo.get(i).cdn());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hwE == null) {
            this.hwE = new ArrayList();
        }
        this.hwE.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void nn(boolean z) {
        this.hwA = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bMJ() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public String bMK() {
        return this.hwF + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (aq.isEmpty(str)) {
            str = "default";
        }
        this.hwG = str;
        this.hwI = j;
        this.hwJ = j2;
        this.hwK = j3;
        this.hwL = j4;
        this.hwM = j5;
        this.hwH = str2;
        this.hwN = i;
    }

    private void bMS() {
        this.hwG = "default";
        this.hwI = 0L;
        this.hwJ = 0L;
        this.hwK = 0L;
        this.hwL = 0L;
        this.hwM = 0L;
        this.hwH = "";
        this.hwN = 0;
    }
}
