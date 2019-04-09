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
    private String bNo;
    private String ctx;
    private String gXW;
    private int gXX;
    private int gXY;
    private com.baidu.tieba.j.a.b gYb;
    private com.baidu.tieba.j.a.d gYc;
    private List<com.baidu.tieba.j.a.c> gYd;
    private long gYh;
    private long gYi;
    private long gYj;
    private boolean gYk;
    private boolean gYn;
    private String gYo;
    private List<b> gYp;
    private int gYq;
    private String gYr;
    private String gYs;
    private long gYt;
    private long gYu;
    private long gYv;
    private long gYw;
    private long gYx;
    private int gYy;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean gYl = true;
    private boolean gYm = false;
    private String gXV = UUID.randomUUID().toString();
    private Map<String, Long> gYa = new HashMap();
    private List<com.baidu.tieba.m.c> gXZ = new ArrayList();
    private long gYe = 0;
    private long gYf = 0;
    private long gYg = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ctx = str;
        this.bNo = str2;
        this.gXW = str3;
        bEw();
    }

    @Override // com.baidu.tieba.j.i
    public void bEh() {
        this.gYe = System.currentTimeMillis();
        this.gXZ.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void yX(String str) {
        zc(str);
        this.gXZ.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void zc(String str) {
        if (!StringUtils.isNull(str)) {
            this.gXY = VideoPlatformStatic.qI(str);
            if (this.gXY != 0) {
                this.gYk = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bEi() {
        this.gXZ.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bEj() {
        if (this.mCurrentState != 2) {
            this.gYe = System.currentTimeMillis();
            this.gXZ.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.gYe = System.currentTimeMillis();
        zc(str);
        this.gXZ.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void vB(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.gXX = i;
            this.gYl = true;
            long currentTimeMillis = System.currentTimeMillis() - this.gYe;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.gYa.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.gYe = 0L;
            this.gYf = System.currentTimeMillis();
            this.gXZ.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void vC(int i) {
        if (this.mCurrentState == 5) {
            bEp();
        } else if (this.mCurrentState == 3) {
            this.gXX = i;
            this.gXZ.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bEk() {
        if (this.gYf != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.gYg += currentTimeMillis - this.gYf;
            this.gYf = currentTimeMillis;
        }
        this.gYh++;
        this.gYj = System.currentTimeMillis();
        this.gXZ.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bEl() {
        this.gYf = System.currentTimeMillis();
        if (this.gYj != 0) {
            this.gYi += System.currentTimeMillis() - this.gYj;
        }
        this.gXZ.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bEm() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.gYf != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.gYg += currentTimeMillis - this.gYf;
                this.gYf = currentTimeMillis;
            }
            this.gXZ.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bEp() {
        if (this.mCurrentState == 5) {
            this.gYf = System.currentTimeMillis();
            this.gXZ.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void yY(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.qJ(str);
            bEr();
            this.gXZ.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Ko();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String yZ(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.gXV;
        }
        this.mSource = VideoPlatformStatic.qJ(str);
        bEr();
        this.gYa.put("stallDuration", Long.valueOf(this.gYi));
        this.gXZ.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Ko();
        return this.gXV;
    }

    @Override // com.baidu.tieba.j.i
    public boolean za(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.qJ(str);
        bEr();
        this.gXZ.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Ko();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void h(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.gYc == null && com.baidu.adp.lib.util.f.hy()) {
                this.gYc = new com.baidu.tieba.j.a.d(this.gXV);
                a(this.gYc);
            }
            if (this.gYc != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.gYc.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.ajA())) {
            if (this.gYb == null && com.baidu.adp.lib.util.f.hy()) {
                this.gYb = new com.baidu.tieba.j.a.b(this.gXV);
                a(this.gYb);
            }
            if (this.gYb != null) {
                if (this.gYb.size() == 0) {
                    this.gYq = i2;
                }
                this.gYb.a(new com.baidu.tieba.play.b.d(SapiErrorCode.NETWORK_FAILED, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.gYd == null) {
            this.gYd = new ArrayList();
        }
        this.gYd.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.gXV;
        }
        this.gXX = i;
        this.gYl = false;
        this.gYm = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.qJ(str);
        bEr();
        if (!v.T(this.gYd)) {
            int size = this.gYd.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.gYd.get(i4);
                if (cVar != null) {
                    cVar.bEE();
                }
            }
        }
        this.gXZ.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bEq()));
        this.mCurrentState = -1;
        Ko();
        return this.gXV;
    }

    private com.baidu.tieba.j.a.e[] bEq() {
        if (this.gYd == null || this.gYd.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.gYd.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gYd.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.gYd.get(i2).bEC();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void zb(String str) {
        this.gYo = str;
    }

    private void bEr() {
        if (this.gYf != 0) {
            this.gYg += System.currentTimeMillis() - this.gYf;
        }
        this.gYa.put("playDuration", Long.valueOf(this.gYg));
        this.gYa.put("stallCount", Long.valueOf(this.gYh));
        this.gYa.put("stallDuration", Long.valueOf(this.gYi));
        if (!this.gYa.containsKey("loadingTime")) {
            this.gYa.put("loadingTime", 0L);
        }
        this.gYe = 0L;
        this.gYf = 0L;
        this.gYg = 0L;
        this.gYh = 0L;
        this.gYi = 0L;
        this.gYj = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Ko() {
        if (!this.gYn) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.ajv() || !this.gYl) && reportType != 3) {
                this.gYn = true;
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
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.gYl)) {
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
                        com.baidu.tieba.s.e.civ().c(jSONObject, j.this.gYl ? false : true);
                        if (j.this.gYp != null) {
                            j.this.gYp.clear();
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
        if (this.gYp != null) {
            try {
                int size = this.gYp.size();
                for (int i = 0; i < size; i++) {
                    this.gYp.get(i).bx(awb);
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
            for (Map.Entry<String, Long> entry : this.gYa.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.gYa.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.gYa.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.gYa.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.gYa.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.gYk ? 1 : 0);
            jSONObject.put("playSuccess", this.gYl ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bEt());
            jSONObject.put("retryError", this.gYm ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.gYp != null) {
                int size = this.gYp.size();
                for (int i = 0; i < size; i++) {
                    this.gYp.get(i).by(jSONObject);
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
            jSONObject.put("page", this.gYr);
            jSONObject.put("tid", this.gYs);
            jSONObject.put("preparedTime", this.gYt);
            jSONObject.put("startTime", this.gYu);
            jSONObject.put("totalTime", this.gYv);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.gYw);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.gYx);
            jSONObject.put("autoPlay", this.gYy);
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
            jSONObject.put(UserBox.TYPE, this.gXV);
            if (!StringUtils.isNull(this.gXW)) {
                jSONObject.put("parentUuid", this.gXW);
            }
            jSONObject.put("tid", this.ctx);
            jSONObject.put("videoUrl", this.bNo);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.lp(this.gXX));
            jSONObject.put("urlType", this.gXY);
            jSONObject.put("sub_error", this.gYq);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.gYo)) {
                jSONObject.put("error_stack", this.gYo);
            }
            if (this.gYp != null) {
                int size = this.gYp.size();
                for (int i = 0; i < size; i++) {
                    this.gYp.get(i).bz(jSONObject);
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
        if (this.gXZ == null) {
            return jSONArray;
        }
        int size = this.gXZ.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.gXZ.get(i).bUo());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.gYp == null) {
            this.gYp = new ArrayList();
        }
        this.gYp.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void mt(boolean z) {
        this.gYl = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bEn() {
        return this.gXV;
    }

    @Override // com.baidu.tieba.j.i
    public String bEo() {
        return this.gYq + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ap.isEmpty(str)) {
            str = "default";
        }
        this.gYr = str;
        this.gYt = j;
        this.gYu = j2;
        this.gYv = j3;
        this.gYw = j4;
        this.gYx = j5;
        this.gYs = str2;
        this.gYy = i;
    }

    private void bEw() {
        this.gYr = "default";
        this.gYt = 0L;
        this.gYu = 0L;
        this.gYv = 0L;
        this.gYw = 0L;
        this.gYx = 0L;
        this.gYs = "";
        this.gYy = 0;
    }
}
