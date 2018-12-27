package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes4.dex */
public class j implements i {
    private String aEO;
    private String biz;
    private long fHA;
    private long fHB;
    private long fHC;
    private int fHD;
    private String fHb;
    private int fHc;
    private int fHd;
    private com.baidu.tieba.j.a.b fHg;
    private com.baidu.tieba.j.a.d fHh;
    private List<com.baidu.tieba.j.a.c> fHi;
    private long fHm;
    private long fHn;
    private long fHo;
    private boolean fHp;
    private boolean fHs;
    private String fHt;
    private List<b> fHu;
    private int fHv;
    private String fHw;
    private String fHx;
    private long fHy;
    private long fHz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fHq = true;
    private boolean fHr = false;
    private String fHa = UUID.randomUUID().toString();
    private Map<String, Long> fHf = new HashMap();
    private List<com.baidu.tieba.m.c> fHe = new ArrayList();
    private long fHj = 0;
    private long fHk = 0;
    private long fHl = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.biz = str;
        this.aEO = str2;
        this.fHb = str3;
        bdw();
    }

    @Override // com.baidu.tieba.j.i
    public void bdh() {
        this.fHj = System.currentTimeMillis();
        this.fHe.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void sf(String str) {
        sk(str);
        this.fHe.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void sk(String str) {
        if (!StringUtils.isNull(str)) {
            this.fHd = VideoPlatformStatic.jH(str);
            if (this.fHd != 0) {
                this.fHp = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bdi() {
        this.fHe.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bdj() {
        if (this.mCurrentState != 2) {
            this.fHj = System.currentTimeMillis();
            this.fHe.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fHj = System.currentTimeMillis();
        sk(str);
        this.fHe.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void rU(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fHc = i;
            this.fHq = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fHj;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = ErrDef.Feature.WEIGHT;
            }
            this.fHf.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fHj = 0L;
            this.fHk = System.currentTimeMillis();
            this.fHe.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rV(int i) {
        if (this.mCurrentState == 5) {
            bdp();
        } else if (this.mCurrentState == 3) {
            this.fHc = i;
            this.fHe.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bdk() {
        if (this.fHk != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fHl += currentTimeMillis - this.fHk;
            this.fHk = currentTimeMillis;
        }
        this.fHm++;
        this.fHo = System.currentTimeMillis();
        this.fHe.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bdl() {
        this.fHk = System.currentTimeMillis();
        if (this.fHo != 0) {
            this.fHn += System.currentTimeMillis() - this.fHo;
        }
        this.fHe.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bdm() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fHk != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fHl += currentTimeMillis - this.fHk;
                this.fHk = currentTimeMillis;
            }
            this.fHe.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bdp() {
        if (this.mCurrentState == 5) {
            this.fHk = System.currentTimeMillis();
            this.fHe.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sg(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.jI(str);
            bdr();
            this.fHe.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            report();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String sh(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fHa;
        }
        this.mSource = VideoPlatformStatic.jI(str);
        bdr();
        this.fHf.put("stallDuration", Long.valueOf(this.fHn));
        this.fHe.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        report();
        return this.fHa;
    }

    @Override // com.baidu.tieba.j.i
    public boolean si(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.jI(str);
        bdr();
        this.fHe.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        report();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fHh == null && com.baidu.adp.lib.util.f.hA()) {
                this.fHh = new com.baidu.tieba.j.a.d(this.fHa);
                a(this.fHh);
            }
            if (this.fHh != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fHh.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.JR())) {
            if (this.fHg == null && com.baidu.adp.lib.util.f.hA()) {
                this.fHg = new com.baidu.tieba.j.a.b(this.fHa);
                a(this.fHg);
            }
            if (this.fHg != null) {
                if (this.fHg.size() == 0) {
                    this.fHv = i2;
                }
                this.fHg.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fHi == null) {
            this.fHi = new ArrayList();
        }
        this.fHi.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fHa;
        }
        this.fHc = i;
        this.fHq = false;
        this.fHr = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.jI(str);
        bdr();
        if (!v.I(this.fHi)) {
            int size = this.fHi.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fHi.get(i4);
                if (cVar != null) {
                    cVar.bdE();
                }
            }
        }
        this.fHe.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bdq()));
        this.mCurrentState = -1;
        report();
        return this.fHa;
    }

    private com.baidu.tieba.j.a.e[] bdq() {
        if (this.fHi == null || this.fHi.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fHi.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fHi.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fHi.get(i2).bdC();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sj(String str) {
        this.fHt = str;
    }

    private void bdr() {
        if (this.fHk != 0) {
            this.fHl += System.currentTimeMillis() - this.fHk;
        }
        this.fHf.put("playDuration", Long.valueOf(this.fHl));
        this.fHf.put("stallCount", Long.valueOf(this.fHm));
        this.fHf.put("stallDuration", Long.valueOf(this.fHn));
        if (!this.fHf.containsKey("loadingTime")) {
            this.fHf.put("loadingTime", 0L);
        }
        this.fHj = 0L;
        this.fHk = 0L;
        this.fHl = 0L;
        this.fHm = 0L;
        this.fHn = 0L;
        this.fHo = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void report() {
        if (!this.fHs) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.JM() || !this.fHq) && reportType != 3) {
                this.fHs = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.VI());
                            jSONObject.put("kpiInfo", j.this.bds());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fHq)) {
                                JSONObject bdu = j.this.bdu();
                                bdu.put("running", j.this.bdv());
                                jSONObject.put("debugInfo", bdu);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bdu());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.t.e.bIo().c(jSONObject, j.this.fHq ? false : true);
                        if (j.this.fHu != null) {
                            j.this.fHu.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject VI() {
        JSONObject VI = VideoPlatformStatic.VI();
        if (this.fHu != null) {
            try {
                int size = this.fHu.size();
                for (int i = 0; i < size; i++) {
                    this.fHu.get(i).ao(VI);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return VI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bds() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fHf.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fHf.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fHf.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fHf.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fHf.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fHp ? 1 : 0);
            jSONObject.put("playSuccess", this.fHq ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bdt());
            jSONObject.put("retryError", this.fHr ? 1 : 0);
            jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.mError);
            if (this.fHu != null) {
                int size = this.fHu.size();
                for (int i = 0; i < size; i++) {
                    this.fHu.get(i).ap(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bdt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SystemScreenshotManager.PAGE, this.fHw);
            jSONObject.put("tid", this.fHx);
            jSONObject.put("preparedTime", this.fHy);
            jSONObject.put("startTime", this.fHz);
            jSONObject.put("totalTime", this.fHA);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.fHB);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.fHC);
            jSONObject.put("autoPlay", this.fHD);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bdw();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bdu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.fHa);
            if (!StringUtils.isNull(this.fHb)) {
                jSONObject.put("parentUuid", this.fHb);
            }
            jSONObject.put("tid", this.biz);
            jSONObject.put("videoUrl", this.aEO);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.hA(this.fHc));
            jSONObject.put("urlType", this.fHd);
            jSONObject.put("sub_error", this.fHv);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fHt)) {
                jSONObject.put("error_stack", this.fHt);
            }
            if (this.fHu != null) {
                int size = this.fHu.size();
                for (int i = 0; i < size; i++) {
                    this.fHu.get(i).aq(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bdv() {
        JSONArray jSONArray = new JSONArray();
        if (this.fHe == null) {
            return jSONArray;
        }
        int size = this.fHe.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fHe.get(i).bsV());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fHu == null) {
            this.fHu = new ArrayList();
        }
        this.fHu.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jS(boolean z) {
        this.fHq = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bdn() {
        return this.fHa;
    }

    @Override // com.baidu.tieba.j.i
    public String bdo() {
        return this.fHv + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ao.isEmpty(str)) {
            str = "default";
        }
        this.fHw = str;
        this.fHy = j;
        this.fHz = j2;
        this.fHA = j3;
        this.fHB = j4;
        this.fHC = j5;
        this.fHx = str2;
        this.fHD = i;
    }

    private void bdw() {
        this.fHw = "default";
        this.fHy = 0L;
        this.fHz = 0L;
        this.fHA = 0L;
        this.fHB = 0L;
        this.fHC = 0L;
        this.fHx = "";
        this.fHD = 0;
    }
}
