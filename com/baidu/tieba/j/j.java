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
    private String aEN;
    private String biw;
    private boolean fEA;
    private String fEB;
    private List<b> fEC;
    private int fED;
    private String fEE;
    private String fEF;
    private long fEG;
    private long fEH;
    private long fEI;
    private long fEJ;
    private long fEK;
    private int fEL;
    private String fEj;
    private int fEk;
    private int fEl;
    private com.baidu.tieba.j.a.b fEo;
    private com.baidu.tieba.j.a.d fEp;
    private List<com.baidu.tieba.j.a.c> fEq;
    private long fEu;
    private long fEv;
    private long fEw;
    private boolean fEx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fEy = true;
    private boolean fEz = false;
    private String fEi = UUID.randomUUID().toString();
    private Map<String, Long> fEn = new HashMap();
    private List<com.baidu.tieba.m.c> fEm = new ArrayList();
    private long fEr = 0;
    private long fEs = 0;
    private long fEt = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.biw = str;
        this.aEN = str2;
        this.fEj = str3;
        bcI();
    }

    @Override // com.baidu.tieba.j.i
    public void bct() {
        this.fEr = System.currentTimeMillis();
        this.fEm.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void sc(String str) {
        sh(str);
        this.fEm.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void sh(String str) {
        if (!StringUtils.isNull(str)) {
            this.fEl = VideoPlatformStatic.jG(str);
            if (this.fEl != 0) {
                this.fEx = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bcu() {
        this.fEm.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bcv() {
        if (this.mCurrentState != 2) {
            this.fEr = System.currentTimeMillis();
            this.fEm.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fEr = System.currentTimeMillis();
        sh(str);
        this.fEm.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void rH(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fEk = i;
            this.fEy = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fEr;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = ErrDef.Feature.WEIGHT;
            }
            this.fEn.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fEr = 0L;
            this.fEs = System.currentTimeMillis();
            this.fEm.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rI(int i) {
        if (this.mCurrentState == 5) {
            bcB();
        } else if (this.mCurrentState == 3) {
            this.fEk = i;
            this.fEm.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bcw() {
        if (this.fEs != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fEt += currentTimeMillis - this.fEs;
            this.fEs = currentTimeMillis;
        }
        this.fEu++;
        this.fEw = System.currentTimeMillis();
        this.fEm.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bcx() {
        this.fEs = System.currentTimeMillis();
        if (this.fEw != 0) {
            this.fEv += System.currentTimeMillis() - this.fEw;
        }
        this.fEm.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bcy() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fEs != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fEt += currentTimeMillis - this.fEs;
                this.fEs = currentTimeMillis;
            }
            this.fEm.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bcB() {
        if (this.mCurrentState == 5) {
            this.fEs = System.currentTimeMillis();
            this.fEm.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sd(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.jH(str);
            bcD();
            this.fEm.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            report();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String se(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fEi;
        }
        this.mSource = VideoPlatformStatic.jH(str);
        bcD();
        this.fEn.put("stallDuration", Long.valueOf(this.fEv));
        this.fEm.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        report();
        return this.fEi;
    }

    @Override // com.baidu.tieba.j.i
    public boolean sf(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.jH(str);
        bcD();
        this.fEm.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        report();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fEp == null && com.baidu.adp.lib.util.f.hA()) {
                this.fEp = new com.baidu.tieba.j.a.d(this.fEi);
                a(this.fEp);
            }
            if (this.fEp != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fEp.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.JQ())) {
            if (this.fEo == null && com.baidu.adp.lib.util.f.hA()) {
                this.fEo = new com.baidu.tieba.j.a.b(this.fEi);
                a(this.fEo);
            }
            if (this.fEo != null) {
                if (this.fEo.size() == 0) {
                    this.fED = i2;
                }
                this.fEo.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fEq == null) {
            this.fEq = new ArrayList();
        }
        this.fEq.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fEi;
        }
        this.fEk = i;
        this.fEy = false;
        this.fEz = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.jH(str);
        bcD();
        if (!v.I(this.fEq)) {
            int size = this.fEq.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fEq.get(i4);
                if (cVar != null) {
                    cVar.bcQ();
                }
            }
        }
        this.fEm.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bcC()));
        this.mCurrentState = -1;
        report();
        return this.fEi;
    }

    private com.baidu.tieba.j.a.e[] bcC() {
        if (this.fEq == null || this.fEq.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fEq.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fEq.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fEq.get(i2).bcO();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sg(String str) {
        this.fEB = str;
    }

    private void bcD() {
        if (this.fEs != 0) {
            this.fEt += System.currentTimeMillis() - this.fEs;
        }
        this.fEn.put("playDuration", Long.valueOf(this.fEt));
        this.fEn.put("stallCount", Long.valueOf(this.fEu));
        this.fEn.put("stallDuration", Long.valueOf(this.fEv));
        if (!this.fEn.containsKey("loadingTime")) {
            this.fEn.put("loadingTime", 0L);
        }
        this.fEr = 0L;
        this.fEs = 0L;
        this.fEt = 0L;
        this.fEu = 0L;
        this.fEv = 0L;
        this.fEw = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void report() {
        if (!this.fEA) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.JL() || !this.fEy) && reportType != 3) {
                this.fEA = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.VG());
                            jSONObject.put("kpiInfo", j.this.bcE());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fEy)) {
                                JSONObject bcG = j.this.bcG();
                                bcG.put("running", j.this.bcH());
                                jSONObject.put("debugInfo", bcG);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bcG());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.bHy().b(jSONObject, j.this.fEy ? false : true);
                        if (j.this.fEC != null) {
                            j.this.fEC.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject VG() {
        JSONObject VG = VideoPlatformStatic.VG();
        if (this.fEC != null) {
            try {
                int size = this.fEC.size();
                for (int i = 0; i < size; i++) {
                    this.fEC.get(i).ao(VG);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return VG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bcE() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fEn.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fEn.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fEn.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fEn.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fEn.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fEx ? 1 : 0);
            jSONObject.put("playSuccess", this.fEy ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bcF());
            jSONObject.put("retryError", this.fEz ? 1 : 0);
            jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.mError);
            if (this.fEC != null) {
                int size = this.fEC.size();
                for (int i = 0; i < size; i++) {
                    this.fEC.get(i).ap(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bcF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SystemScreenshotManager.PAGE, this.fEE);
            jSONObject.put("tid", this.fEF);
            jSONObject.put("preparedTime", this.fEG);
            jSONObject.put("startTime", this.fEH);
            jSONObject.put("totalTime", this.fEI);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.fEJ);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.fEK);
            jSONObject.put("autoPlay", this.fEL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bcI();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bcG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.fEi);
            if (!StringUtils.isNull(this.fEj)) {
                jSONObject.put("parentUuid", this.fEj);
            }
            jSONObject.put("tid", this.biw);
            jSONObject.put("videoUrl", this.aEN);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.hz(this.fEk));
            jSONObject.put("urlType", this.fEl);
            jSONObject.put("sub_error", this.fED);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fEB)) {
                jSONObject.put("error_stack", this.fEB);
            }
            if (this.fEC != null) {
                int size = this.fEC.size();
                for (int i = 0; i < size; i++) {
                    this.fEC.get(i).aq(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bcH() {
        JSONArray jSONArray = new JSONArray();
        if (this.fEm == null) {
            return jSONArray;
        }
        int size = this.fEm.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fEm.get(i).bsj());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fEC == null) {
            this.fEC = new ArrayList();
        }
        this.fEC.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jP(boolean z) {
        this.fEy = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bcz() {
        return this.fEi;
    }

    @Override // com.baidu.tieba.j.i
    public String bcA() {
        return this.fED + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ao.isEmpty(str)) {
            str = "default";
        }
        this.fEE = str;
        this.fEG = j;
        this.fEH = j2;
        this.fEI = j3;
        this.fEJ = j4;
        this.fEK = j5;
        this.fEF = str2;
        this.fEL = i;
    }

    private void bcI() {
        this.fEE = "default";
        this.fEG = 0L;
        this.fEH = 0L;
        this.fEI = 0L;
        this.fEJ = 0L;
        this.fEK = 0L;
        this.fEF = "";
        this.fEL = 0;
    }
}
