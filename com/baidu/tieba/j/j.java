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
    private String bNn;
    private String ctw;
    private String gXV;
    private int gXW;
    private int gXX;
    private com.baidu.tieba.j.a.b gYa;
    private com.baidu.tieba.j.a.d gYb;
    private List<com.baidu.tieba.j.a.c> gYc;
    private long gYg;
    private long gYh;
    private long gYi;
    private boolean gYj;
    private boolean gYm;
    private String gYn;
    private List<b> gYo;
    private int gYp;
    private String gYq;
    private String gYr;
    private long gYs;
    private long gYt;
    private long gYu;
    private long gYv;
    private long gYw;
    private int gYx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean gYk = true;
    private boolean gYl = false;
    private String gXU = UUID.randomUUID().toString();
    private Map<String, Long> gXZ = new HashMap();
    private List<com.baidu.tieba.m.c> gXY = new ArrayList();
    private long gYd = 0;
    private long gYe = 0;
    private long gYf = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ctw = str;
        this.bNn = str2;
        this.gXV = str3;
        bEw();
    }

    @Override // com.baidu.tieba.j.i
    public void bEh() {
        this.gYd = System.currentTimeMillis();
        this.gXY.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void yX(String str) {
        zc(str);
        this.gXY.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void zc(String str) {
        if (!StringUtils.isNull(str)) {
            this.gXX = VideoPlatformStatic.qI(str);
            if (this.gXX != 0) {
                this.gYj = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bEi() {
        this.gXY.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bEj() {
        if (this.mCurrentState != 2) {
            this.gYd = System.currentTimeMillis();
            this.gXY.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.gYd = System.currentTimeMillis();
        zc(str);
        this.gXY.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void vB(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.gXW = i;
            this.gYk = true;
            long currentTimeMillis = System.currentTimeMillis() - this.gYd;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.gXZ.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.gYd = 0L;
            this.gYe = System.currentTimeMillis();
            this.gXY.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void vC(int i) {
        if (this.mCurrentState == 5) {
            bEp();
        } else if (this.mCurrentState == 3) {
            this.gXW = i;
            this.gXY.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bEk() {
        if (this.gYe != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.gYf += currentTimeMillis - this.gYe;
            this.gYe = currentTimeMillis;
        }
        this.gYg++;
        this.gYi = System.currentTimeMillis();
        this.gXY.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bEl() {
        this.gYe = System.currentTimeMillis();
        if (this.gYi != 0) {
            this.gYh += System.currentTimeMillis() - this.gYi;
        }
        this.gXY.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bEm() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.gYe != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.gYf += currentTimeMillis - this.gYe;
                this.gYe = currentTimeMillis;
            }
            this.gXY.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bEp() {
        if (this.mCurrentState == 5) {
            this.gYe = System.currentTimeMillis();
            this.gXY.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void yY(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.qJ(str);
            bEr();
            this.gXY.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Ko();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String yZ(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.gXU;
        }
        this.mSource = VideoPlatformStatic.qJ(str);
        bEr();
        this.gXZ.put("stallDuration", Long.valueOf(this.gYh));
        this.gXY.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Ko();
        return this.gXU;
    }

    @Override // com.baidu.tieba.j.i
    public boolean za(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.qJ(str);
        bEr();
        this.gXY.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Ko();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void h(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.gYb == null && com.baidu.adp.lib.util.f.hy()) {
                this.gYb = new com.baidu.tieba.j.a.d(this.gXU);
                a(this.gYb);
            }
            if (this.gYb != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.gYb.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.ajA())) {
            if (this.gYa == null && com.baidu.adp.lib.util.f.hy()) {
                this.gYa = new com.baidu.tieba.j.a.b(this.gXU);
                a(this.gYa);
            }
            if (this.gYa != null) {
                if (this.gYa.size() == 0) {
                    this.gYp = i2;
                }
                this.gYa.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.gYc == null) {
            this.gYc = new ArrayList();
        }
        this.gYc.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.gXU;
        }
        this.gXW = i;
        this.gYk = false;
        this.gYl = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.qJ(str);
        bEr();
        if (!v.T(this.gYc)) {
            int size = this.gYc.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.gYc.get(i4);
                if (cVar != null) {
                    cVar.bEE();
                }
            }
        }
        this.gXY.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bEq()));
        this.mCurrentState = -1;
        Ko();
        return this.gXU;
    }

    private com.baidu.tieba.j.a.e[] bEq() {
        if (this.gYc == null || this.gYc.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.gYc.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gYc.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.gYc.get(i2).bEC();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void zb(String str) {
        this.gYn = str;
    }

    private void bEr() {
        if (this.gYe != 0) {
            this.gYf += System.currentTimeMillis() - this.gYe;
        }
        this.gXZ.put("playDuration", Long.valueOf(this.gYf));
        this.gXZ.put("stallCount", Long.valueOf(this.gYg));
        this.gXZ.put("stallDuration", Long.valueOf(this.gYh));
        if (!this.gXZ.containsKey("loadingTime")) {
            this.gXZ.put("loadingTime", 0L);
        }
        this.gYd = 0L;
        this.gYe = 0L;
        this.gYf = 0L;
        this.gYg = 0L;
        this.gYh = 0L;
        this.gYi = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Ko() {
        if (!this.gYm) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.ajv() || !this.gYk) && reportType != 3) {
                this.gYm = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.awb());
                            jSONObject.put("kpiInfo", j.this.bEs());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.gYk)) {
                                JSONObject bEu = j.this.bEu();
                                bEu.put("running", j.this.bEv());
                                jSONObject.put("debugInfo", bEu);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bEu());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.civ().c(jSONObject, j.this.gYk ? false : true);
                        if (j.this.gYo != null) {
                            j.this.gYo.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject awb() {
        JSONObject awb = VideoPlatformStatic.awb();
        if (this.gYo != null) {
            try {
                int size = this.gYo.size();
                for (int i = 0; i < size; i++) {
                    this.gYo.get(i).bx(awb);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return awb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bEs() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.gXZ.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.gXZ.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.gXZ.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.gXZ.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.gXZ.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.gYj ? 1 : 0);
            jSONObject.put("playSuccess", this.gYk ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bEt());
            jSONObject.put("retryError", this.gYl ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.gYo != null) {
                int size = this.gYo.size();
                for (int i = 0; i < size; i++) {
                    this.gYo.get(i).by(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bEt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.gYq);
            jSONObject.put("tid", this.gYr);
            jSONObject.put("preparedTime", this.gYs);
            jSONObject.put("startTime", this.gYt);
            jSONObject.put("totalTime", this.gYu);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.gYv);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.gYw);
            jSONObject.put("autoPlay", this.gYx);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bEw();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bEu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.gXU);
            if (!StringUtils.isNull(this.gXV)) {
                jSONObject.put("parentUuid", this.gXV);
            }
            jSONObject.put("tid", this.ctw);
            jSONObject.put("videoUrl", this.bNn);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.lp(this.gXW));
            jSONObject.put("urlType", this.gXX);
            jSONObject.put("sub_error", this.gYp);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.gYn)) {
                jSONObject.put("error_stack", this.gYn);
            }
            if (this.gYo != null) {
                int size = this.gYo.size();
                for (int i = 0; i < size; i++) {
                    this.gYo.get(i).bz(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bEv() {
        JSONArray jSONArray = new JSONArray();
        if (this.gXY == null) {
            return jSONArray;
        }
        int size = this.gXY.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.gXY.get(i).bUo());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.gYo == null) {
            this.gYo = new ArrayList();
        }
        this.gYo.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void mt(boolean z) {
        this.gYk = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bEn() {
        return this.gXU;
    }

    @Override // com.baidu.tieba.j.i
    public String bEo() {
        return this.gYp + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ap.isEmpty(str)) {
            str = "default";
        }
        this.gYq = str;
        this.gYs = j;
        this.gYt = j2;
        this.gYu = j3;
        this.gYv = j4;
        this.gYw = j5;
        this.gYr = str2;
        this.gYx = i;
    }

    private void bEw() {
        this.gYq = "default";
        this.gYs = 0L;
        this.gYt = 0L;
        this.gYu = 0L;
        this.gYv = 0L;
        this.gYw = 0L;
        this.gYr = "";
        this.gYx = 0;
    }
}
