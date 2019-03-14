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
    private String bNl;
    private String ctu;
    private String gYA;
    private List<b> gYB;
    private int gYC;
    private String gYD;
    private String gYE;
    private long gYF;
    private long gYG;
    private long gYH;
    private long gYI;
    private long gYJ;
    private int gYK;
    private String gYi;
    private int gYj;
    private int gYk;
    private com.baidu.tieba.j.a.b gYn;
    private com.baidu.tieba.j.a.d gYo;
    private List<com.baidu.tieba.j.a.c> gYp;
    private long gYt;
    private long gYu;
    private long gYv;
    private boolean gYw;
    private boolean gYz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean gYx = true;
    private boolean gYy = false;
    private String gYh = UUID.randomUUID().toString();
    private Map<String, Long> gYm = new HashMap();
    private List<com.baidu.tieba.m.c> gYl = new ArrayList();
    private long gYq = 0;
    private long gYr = 0;
    private long gYs = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ctu = str;
        this.bNl = str2;
        this.gYi = str3;
        bEz();
    }

    @Override // com.baidu.tieba.j.i
    public void bEk() {
        this.gYq = System.currentTimeMillis();
        this.gYl.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void yY(String str) {
        zd(str);
        this.gYl.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void zd(String str) {
        if (!StringUtils.isNull(str)) {
            this.gYk = VideoPlatformStatic.qH(str);
            if (this.gYk != 0) {
                this.gYw = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bEl() {
        this.gYl.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bEm() {
        if (this.mCurrentState != 2) {
            this.gYq = System.currentTimeMillis();
            this.gYl.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.gYq = System.currentTimeMillis();
        zd(str);
        this.gYl.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void vF(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.gYj = i;
            this.gYx = true;
            long currentTimeMillis = System.currentTimeMillis() - this.gYq;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.gYm.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.gYq = 0L;
            this.gYr = System.currentTimeMillis();
            this.gYl.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void vG(int i) {
        if (this.mCurrentState == 5) {
            bEs();
        } else if (this.mCurrentState == 3) {
            this.gYj = i;
            this.gYl.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bEn() {
        if (this.gYr != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.gYs += currentTimeMillis - this.gYr;
            this.gYr = currentTimeMillis;
        }
        this.gYt++;
        this.gYv = System.currentTimeMillis();
        this.gYl.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bEo() {
        this.gYr = System.currentTimeMillis();
        if (this.gYv != 0) {
            this.gYu += System.currentTimeMillis() - this.gYv;
        }
        this.gYl.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bEp() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.gYr != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.gYs += currentTimeMillis - this.gYr;
                this.gYr = currentTimeMillis;
            }
            this.gYl.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bEs() {
        if (this.mCurrentState == 5) {
            this.gYr = System.currentTimeMillis();
            this.gYl.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void yZ(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.qI(str);
            bEu();
            this.gYl.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Kq();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String za(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.gYh;
        }
        this.mSource = VideoPlatformStatic.qI(str);
        bEu();
        this.gYm.put("stallDuration", Long.valueOf(this.gYu));
        this.gYl.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Kq();
        return this.gYh;
    }

    @Override // com.baidu.tieba.j.i
    public boolean zb(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.qI(str);
        bEu();
        this.gYl.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Kq();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void h(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.gYo == null && com.baidu.adp.lib.util.f.hy()) {
                this.gYo = new com.baidu.tieba.j.a.d(this.gYh);
                a(this.gYo);
            }
            if (this.gYo != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.gYo.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.ajD())) {
            if (this.gYn == null && com.baidu.adp.lib.util.f.hy()) {
                this.gYn = new com.baidu.tieba.j.a.b(this.gYh);
                a(this.gYn);
            }
            if (this.gYn != null) {
                if (this.gYn.size() == 0) {
                    this.gYC = i2;
                }
                this.gYn.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.gYp == null) {
            this.gYp = new ArrayList();
        }
        this.gYp.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.gYh;
        }
        this.gYj = i;
        this.gYx = false;
        this.gYy = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.qI(str);
        bEu();
        if (!v.T(this.gYp)) {
            int size = this.gYp.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.gYp.get(i4);
                if (cVar != null) {
                    cVar.bEH();
                }
            }
        }
        this.gYl.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bEt()));
        this.mCurrentState = -1;
        Kq();
        return this.gYh;
    }

    private com.baidu.tieba.j.a.e[] bEt() {
        if (this.gYp == null || this.gYp.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.gYp.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gYp.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.gYp.get(i2).bEF();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void zc(String str) {
        this.gYA = str;
    }

    private void bEu() {
        if (this.gYr != 0) {
            this.gYs += System.currentTimeMillis() - this.gYr;
        }
        this.gYm.put("playDuration", Long.valueOf(this.gYs));
        this.gYm.put("stallCount", Long.valueOf(this.gYt));
        this.gYm.put("stallDuration", Long.valueOf(this.gYu));
        if (!this.gYm.containsKey("loadingTime")) {
            this.gYm.put("loadingTime", 0L);
        }
        this.gYq = 0L;
        this.gYr = 0L;
        this.gYs = 0L;
        this.gYt = 0L;
        this.gYu = 0L;
        this.gYv = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Kq() {
        if (!this.gYz) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.ajy() || !this.gYx) && reportType != 3) {
                this.gYz = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.awe());
                            jSONObject.put("kpiInfo", j.this.bEv());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.gYx)) {
                                JSONObject bEx = j.this.bEx();
                                bEx.put("running", j.this.bEy());
                                jSONObject.put("debugInfo", bEx);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bEx());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.cix().c(jSONObject, j.this.gYx ? false : true);
                        if (j.this.gYB != null) {
                            j.this.gYB.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject awe() {
        JSONObject awe = VideoPlatformStatic.awe();
        if (this.gYB != null) {
            try {
                int size = this.gYB.size();
                for (int i = 0; i < size; i++) {
                    this.gYB.get(i).bx(awe);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return awe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bEv() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.gYm.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.gYm.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.gYm.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.gYm.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.gYm.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.gYw ? 1 : 0);
            jSONObject.put("playSuccess", this.gYx ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bEw());
            jSONObject.put("retryError", this.gYy ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.gYB != null) {
                int size = this.gYB.size();
                for (int i = 0; i < size; i++) {
                    this.gYB.get(i).by(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bEw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.gYD);
            jSONObject.put("tid", this.gYE);
            jSONObject.put("preparedTime", this.gYF);
            jSONObject.put("startTime", this.gYG);
            jSONObject.put("totalTime", this.gYH);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.gYI);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.gYJ);
            jSONObject.put("autoPlay", this.gYK);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bEz();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bEx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.gYh);
            if (!StringUtils.isNull(this.gYi)) {
                jSONObject.put("parentUuid", this.gYi);
            }
            jSONObject.put("tid", this.ctu);
            jSONObject.put("videoUrl", this.bNl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.lq(this.gYj));
            jSONObject.put("urlType", this.gYk);
            jSONObject.put("sub_error", this.gYC);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.gYA)) {
                jSONObject.put("error_stack", this.gYA);
            }
            if (this.gYB != null) {
                int size = this.gYB.size();
                for (int i = 0; i < size; i++) {
                    this.gYB.get(i).bz(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bEy() {
        JSONArray jSONArray = new JSONArray();
        if (this.gYl == null) {
            return jSONArray;
        }
        int size = this.gYl.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.gYl.get(i).bUs());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.gYB == null) {
            this.gYB = new ArrayList();
        }
        this.gYB.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void mt(boolean z) {
        this.gYx = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bEq() {
        return this.gYh;
    }

    @Override // com.baidu.tieba.j.i
    public String bEr() {
        return this.gYC + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ap.isEmpty(str)) {
            str = "default";
        }
        this.gYD = str;
        this.gYF = j;
        this.gYG = j2;
        this.gYH = j3;
        this.gYI = j4;
        this.gYJ = j5;
        this.gYE = str2;
        this.gYK = i;
    }

    private void bEz() {
        this.gYD = "default";
        this.gYF = 0L;
        this.gYG = 0L;
        this.gYH = 0L;
        this.gYI = 0L;
        this.gYJ = 0L;
        this.gYE = "";
        this.gYK = 0;
    }
}
