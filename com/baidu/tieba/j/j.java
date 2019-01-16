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
    private String aFq;
    private String bjm;
    private String fHV;
    private int fHW;
    private int fHX;
    private com.baidu.tieba.j.a.b fIa;
    private com.baidu.tieba.j.a.d fIb;
    private List<com.baidu.tieba.j.a.c> fIc;
    private long fIg;
    private long fIh;
    private long fIi;
    private boolean fIj;
    private boolean fIm;
    private String fIn;
    private List<b> fIo;
    private int fIp;
    private String fIq;
    private String fIr;
    private long fIs;
    private long fIt;
    private long fIu;
    private long fIv;
    private long fIw;
    private int fIx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fIk = true;
    private boolean fIl = false;
    private String fHU = UUID.randomUUID().toString();
    private Map<String, Long> fHZ = new HashMap();
    private List<com.baidu.tieba.m.c> fHY = new ArrayList();
    private long fId = 0;
    private long fIe = 0;
    private long fIf = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bjm = str;
        this.aFq = str2;
        this.fHV = str3;
        bdW();
    }

    @Override // com.baidu.tieba.j.i
    public void bdH() {
        this.fId = System.currentTimeMillis();
        this.fHY.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void sw(String str) {
        sB(str);
        this.fHY.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void sB(String str) {
        if (!StringUtils.isNull(str)) {
            this.fHX = VideoPlatformStatic.jX(str);
            if (this.fHX != 0) {
                this.fIj = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bdI() {
        this.fHY.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bdJ() {
        if (this.mCurrentState != 2) {
            this.fId = System.currentTimeMillis();
            this.fHY.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fId = System.currentTimeMillis();
        sB(str);
        this.fHY.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void rW(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fHW = i;
            this.fIk = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fId;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = ErrDef.Feature.WEIGHT;
            }
            this.fHZ.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fId = 0L;
            this.fIe = System.currentTimeMillis();
            this.fHY.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rX(int i) {
        if (this.mCurrentState == 5) {
            bdP();
        } else if (this.mCurrentState == 3) {
            this.fHW = i;
            this.fHY.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bdK() {
        if (this.fIe != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fIf += currentTimeMillis - this.fIe;
            this.fIe = currentTimeMillis;
        }
        this.fIg++;
        this.fIi = System.currentTimeMillis();
        this.fHY.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bdL() {
        this.fIe = System.currentTimeMillis();
        if (this.fIi != 0) {
            this.fIh += System.currentTimeMillis() - this.fIi;
        }
        this.fHY.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bdM() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fIe != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fIf += currentTimeMillis - this.fIe;
                this.fIe = currentTimeMillis;
            }
            this.fHY.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bdP() {
        if (this.mCurrentState == 5) {
            this.fIe = System.currentTimeMillis();
            this.fHY.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sx(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.jY(str);
            bdR();
            this.fHY.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            report();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String sy(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fHU;
        }
        this.mSource = VideoPlatformStatic.jY(str);
        bdR();
        this.fHZ.put("stallDuration", Long.valueOf(this.fIh));
        this.fHY.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        report();
        return this.fHU;
    }

    @Override // com.baidu.tieba.j.i
    public boolean sz(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.jY(str);
        bdR();
        this.fHY.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        report();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fIb == null && com.baidu.adp.lib.util.f.hA()) {
                this.fIb = new com.baidu.tieba.j.a.d(this.fHU);
                a(this.fIb);
            }
            if (this.fIb != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fIb.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Kg())) {
            if (this.fIa == null && com.baidu.adp.lib.util.f.hA()) {
                this.fIa = new com.baidu.tieba.j.a.b(this.fHU);
                a(this.fIa);
            }
            if (this.fIa != null) {
                if (this.fIa.size() == 0) {
                    this.fIp = i2;
                }
                this.fIa.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fIc == null) {
            this.fIc = new ArrayList();
        }
        this.fIc.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fHU;
        }
        this.fHW = i;
        this.fIk = false;
        this.fIl = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.jY(str);
        bdR();
        if (!v.I(this.fIc)) {
            int size = this.fIc.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fIc.get(i4);
                if (cVar != null) {
                    cVar.bee();
                }
            }
        }
        this.fHY.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bdQ()));
        this.mCurrentState = -1;
        report();
        return this.fHU;
    }

    private com.baidu.tieba.j.a.e[] bdQ() {
        if (this.fIc == null || this.fIc.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fIc.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fIc.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fIc.get(i2).bec();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sA(String str) {
        this.fIn = str;
    }

    private void bdR() {
        if (this.fIe != 0) {
            this.fIf += System.currentTimeMillis() - this.fIe;
        }
        this.fHZ.put("playDuration", Long.valueOf(this.fIf));
        this.fHZ.put("stallCount", Long.valueOf(this.fIg));
        this.fHZ.put("stallDuration", Long.valueOf(this.fIh));
        if (!this.fHZ.containsKey("loadingTime")) {
            this.fHZ.put("loadingTime", 0L);
        }
        this.fId = 0L;
        this.fIe = 0L;
        this.fIf = 0L;
        this.fIg = 0L;
        this.fIh = 0L;
        this.fIi = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void report() {
        if (!this.fIm) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Kb() || !this.fIk) && reportType != 3) {
                this.fIm = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.We());
                            jSONObject.put("kpiInfo", j.this.bdS());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fIk)) {
                                JSONObject bdU = j.this.bdU();
                                bdU.put("running", j.this.bdV());
                                jSONObject.put("debugInfo", bdU);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bdU());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.t.e.bIX().c(jSONObject, j.this.fIk ? false : true);
                        if (j.this.fIo != null) {
                            j.this.fIo.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject We() {
        JSONObject We = VideoPlatformStatic.We();
        if (this.fIo != null) {
            try {
                int size = this.fIo.size();
                for (int i = 0; i < size; i++) {
                    this.fIo.get(i).ao(We);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return We;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bdS() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fHZ.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fHZ.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fHZ.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fHZ.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fHZ.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fIj ? 1 : 0);
            jSONObject.put("playSuccess", this.fIk ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bdT());
            jSONObject.put("retryError", this.fIl ? 1 : 0);
            jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.mError);
            if (this.fIo != null) {
                int size = this.fIo.size();
                for (int i = 0; i < size; i++) {
                    this.fIo.get(i).ap(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bdT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SystemScreenshotManager.PAGE, this.fIq);
            jSONObject.put("tid", this.fIr);
            jSONObject.put("preparedTime", this.fIs);
            jSONObject.put("startTime", this.fIt);
            jSONObject.put("totalTime", this.fIu);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.fIv);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.fIw);
            jSONObject.put("autoPlay", this.fIx);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bdW();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bdU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.fHU);
            if (!StringUtils.isNull(this.fHV)) {
                jSONObject.put("parentUuid", this.fHV);
            }
            jSONObject.put("tid", this.bjm);
            jSONObject.put("videoUrl", this.aFq);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.hA(this.fHW));
            jSONObject.put("urlType", this.fHX);
            jSONObject.put("sub_error", this.fIp);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fIn)) {
                jSONObject.put("error_stack", this.fIn);
            }
            if (this.fIo != null) {
                int size = this.fIo.size();
                for (int i = 0; i < size; i++) {
                    this.fIo.get(i).aq(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bdV() {
        JSONArray jSONArray = new JSONArray();
        if (this.fHY == null) {
            return jSONArray;
        }
        int size = this.fHY.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fHY.get(i).btE());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fIo == null) {
            this.fIo = new ArrayList();
        }
        this.fIo.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jS(boolean z) {
        this.fIk = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bdN() {
        return this.fHU;
    }

    @Override // com.baidu.tieba.j.i
    public String bdO() {
        return this.fIp + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ao.isEmpty(str)) {
            str = "default";
        }
        this.fIq = str;
        this.fIs = j;
        this.fIt = j2;
        this.fIu = j3;
        this.fIv = j4;
        this.fIw = j5;
        this.fIr = str2;
        this.fIx = i;
    }

    private void bdW() {
        this.fIq = "default";
        this.fIs = 0L;
        this.fIt = 0L;
        this.fIu = 0L;
        this.fIv = 0L;
        this.fIw = 0L;
        this.fIr = "";
        this.fIx = 0;
    }
}
