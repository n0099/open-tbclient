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
    private String cmS;
    private String cmf;
    private long hxA;
    private long hxB;
    private long hxC;
    private long hxD;
    private int hxE;
    private String hxc;
    private int hxd;
    private int hxe;
    private com.baidu.tieba.j.a.b hxh;
    private com.baidu.tieba.j.a.d hxi;
    private List<com.baidu.tieba.j.a.c> hxj;
    private long hxn;
    private long hxo;
    private long hxp;
    private boolean hxq;
    private boolean hxt;
    private String hxu;
    private List<b> hxv;
    private int hxw;
    private String hxx;
    private String hxy;
    private long hxz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hxr = true;
    private boolean hxs = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> hxg = new HashMap();
    private List<com.baidu.tieba.m.c> hxf = new ArrayList();
    private long hxk = 0;
    private long hxl = 0;
    private long hxm = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.cmS = str;
        this.cmf = str2;
        this.hxc = str3;
        bMU();
    }

    @Override // com.baidu.tieba.j.i
    public void bMF() {
        this.hxk = System.currentTimeMillis();
        this.hxf.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void zU(String str) {
        zZ(str);
        this.hxf.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.j.i
    public void nm(boolean z) {
        this.hxq = z;
        this.hxf.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void zZ(String str) {
        if (!StringUtils.isNull(str)) {
            this.hxe = VideoPlatformStatic.rd(str);
            if (this.hxe != 0) {
                this.hxq = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bMG() {
        this.hxf.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bMH() {
        if (this.mCurrentState != 2) {
            this.hxk = System.currentTimeMillis();
            this.hxf.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hxk = System.currentTimeMillis();
        zZ(str);
        this.hxf.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void vW(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hxd = i;
            this.hxr = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hxk;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hxg.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hxk = 0L;
            this.hxl = System.currentTimeMillis();
            this.hxf.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void vX(int i) {
        if (this.mCurrentState == 5) {
            bMN();
        } else if (this.mCurrentState == 3) {
            this.hxd = i;
            this.hxf.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bMI() {
        if (this.hxl != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hxm += currentTimeMillis - this.hxl;
            this.hxl = currentTimeMillis;
        }
        this.hxn++;
        this.hxp = System.currentTimeMillis();
        this.hxf.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bMJ() {
        this.hxl = System.currentTimeMillis();
        if (this.hxp != 0) {
            this.hxo += System.currentTimeMillis() - this.hxp;
        }
        this.hxf.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bMK() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hxl != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hxm += currentTimeMillis - this.hxl;
                this.hxl = currentTimeMillis;
            }
            this.hxf.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bMN() {
        if (this.mCurrentState == 5) {
            this.hxl = System.currentTimeMillis();
            this.hxf.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void zV(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.re(str);
            bMP();
            this.hxf.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            KZ();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String zW(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.re(str);
        bMP();
        this.hxg.put("stallDuration", Long.valueOf(this.hxo));
        this.hxf.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        KZ();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public boolean zX(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.re(str);
        bMP();
        this.hxf.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        KZ();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hxi == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.hxi = new com.baidu.tieba.j.a.d(this.mUuid);
                a(this.hxi);
            }
            if (this.hxi != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hxi.a(new com.baidu.tieba.play.c.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.arP())) {
            if (this.hxh == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.hxh = new com.baidu.tieba.j.a.b(this.mUuid);
                a(this.hxh);
            }
            if (this.hxh != null) {
                if (this.hxh.size() == 0) {
                    this.hxw = i2;
                }
                this.hxh.a(new com.baidu.tieba.play.c.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hxj == null) {
            this.hxj = new ArrayList();
        }
        this.hxj.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.hxd = i;
        this.hxr = false;
        this.hxs = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.re(str);
        bMP();
        if (!v.isEmpty(this.hxj)) {
            int size = this.hxj.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hxj.get(i4);
                if (cVar != null) {
                    cVar.bNd();
                }
            }
        }
        this.hxf.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bMO()));
        this.mCurrentState = -1;
        KZ();
        return this.mUuid;
    }

    private com.baidu.tieba.j.a.e[] bMO() {
        if (this.hxj == null || this.hxj.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hxj.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hxj.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hxj.get(i2).bNb();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void zY(String str) {
        this.hxu = str;
    }

    private void bMP() {
        if (this.hxl != 0) {
            this.hxm += System.currentTimeMillis() - this.hxl;
        }
        this.hxg.put("playDuration", Long.valueOf(this.hxm));
        this.hxg.put("stallCount", Long.valueOf(this.hxn));
        this.hxg.put("stallDuration", Long.valueOf(this.hxo));
        if (!this.hxg.containsKey("loadingTime")) {
            this.hxg.put("loadingTime", 0L);
        }
        this.hxk = 0L;
        this.hxl = 0L;
        this.hxm = 0L;
        this.hxn = 0L;
        this.hxo = 0L;
        this.hxp = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void KZ() {
        if (!this.hxt) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.arK() || !this.hxr) && reportType != 3) {
                this.hxt = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aCY());
                            jSONObject.put("kpiInfo", j.this.bMQ());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hxr)) {
                                JSONObject bMS = j.this.bMS();
                                bMS.put("running", j.this.bMT());
                                jSONObject.put("debugInfo", bMS);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bMS());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.csk().d(jSONObject, j.this.hxr ? false : true);
                        if (j.this.hxv != null) {
                            j.this.hxv.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aCY() {
        JSONObject aCY = VideoPlatformStatic.aCY();
        if (this.hxv != null) {
            try {
                int size = this.hxv.size();
                for (int i = 0; i < size; i++) {
                    this.hxv.get(i).ci(aCY);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aCY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hxg.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hxg.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hxg.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hxg.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hxg.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hxq ? 1 : 0);
            jSONObject.put("playSuccess", this.hxr ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bMR());
            jSONObject.put("retryError", this.hxs ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.hxv != null) {
                int size = this.hxv.size();
                for (int i = 0; i < size; i++) {
                    this.hxv.get(i).cj(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bMR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hxx);
            jSONObject.put("tid", this.hxy);
            jSONObject.put("preparedTime", this.hxz);
            jSONObject.put("startTime", this.hxA);
            jSONObject.put("totalTime", this.hxB);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hxC);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hxD);
            jSONObject.put("autoPlay", this.hxE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bMU();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bMS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.hxc)) {
                jSONObject.put("parentUuid", this.hxc);
            }
            jSONObject.put("tid", this.cmS);
            jSONObject.put("videoUrl", this.cmf);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.lv(this.hxd));
            jSONObject.put("urlType", this.hxe);
            jSONObject.put("sub_error", this.hxw);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hxu)) {
                jSONObject.put("error_stack", this.hxu);
            }
            if (this.hxv != null) {
                int size = this.hxv.size();
                for (int i = 0; i < size; i++) {
                    this.hxv.get(i).ck(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bMT() {
        JSONArray jSONArray = new JSONArray();
        if (this.hxf == null) {
            return jSONArray;
        }
        int size = this.hxf.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hxf.get(i).cdp());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hxv == null) {
            this.hxv = new ArrayList();
        }
        this.hxv.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void nn(boolean z) {
        this.hxr = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bML() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public String bMM() {
        return this.hxw + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (aq.isEmpty(str)) {
            str = "default";
        }
        this.hxx = str;
        this.hxz = j;
        this.hxA = j2;
        this.hxB = j3;
        this.hxC = j4;
        this.hxD = j5;
        this.hxy = str2;
        this.hxE = i;
    }

    private void bMU() {
        this.hxx = "default";
        this.hxz = 0L;
        this.hxA = 0L;
        this.hxB = 0L;
        this.hxC = 0L;
        this.hxD = 0L;
        this.hxy = "";
        this.hxE = 0;
    }
}
