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
    private String aFr;
    private String bjn;
    private String fHW;
    private int fHX;
    private int fHY;
    private com.baidu.tieba.j.a.b fIb;
    private com.baidu.tieba.j.a.d fIc;
    private List<com.baidu.tieba.j.a.c> fId;
    private long fIh;
    private long fIi;
    private long fIj;
    private boolean fIk;
    private boolean fIn;
    private String fIo;
    private List<b> fIp;
    private int fIq;
    private String fIr;
    private String fIs;
    private long fIt;
    private long fIu;
    private long fIv;
    private long fIw;
    private long fIx;
    private int fIy;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fIl = true;
    private boolean fIm = false;
    private String fHV = UUID.randomUUID().toString();
    private Map<String, Long> fIa = new HashMap();
    private List<com.baidu.tieba.m.c> fHZ = new ArrayList();
    private long fIe = 0;
    private long fIf = 0;
    private long fIg = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bjn = str;
        this.aFr = str2;
        this.fHW = str3;
        bdW();
    }

    @Override // com.baidu.tieba.j.i
    public void bdH() {
        this.fIe = System.currentTimeMillis();
        this.fHZ.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void sw(String str) {
        sB(str);
        this.fHZ.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void sB(String str) {
        if (!StringUtils.isNull(str)) {
            this.fHY = VideoPlatformStatic.jX(str);
            if (this.fHY != 0) {
                this.fIk = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bdI() {
        this.fHZ.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bdJ() {
        if (this.mCurrentState != 2) {
            this.fIe = System.currentTimeMillis();
            this.fHZ.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fIe = System.currentTimeMillis();
        sB(str);
        this.fHZ.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void rW(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fHX = i;
            this.fIl = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fIe;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = ErrDef.Feature.WEIGHT;
            }
            this.fIa.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fIe = 0L;
            this.fIf = System.currentTimeMillis();
            this.fHZ.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rX(int i) {
        if (this.mCurrentState == 5) {
            bdP();
        } else if (this.mCurrentState == 3) {
            this.fHX = i;
            this.fHZ.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bdK() {
        if (this.fIf != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fIg += currentTimeMillis - this.fIf;
            this.fIf = currentTimeMillis;
        }
        this.fIh++;
        this.fIj = System.currentTimeMillis();
        this.fHZ.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bdL() {
        this.fIf = System.currentTimeMillis();
        if (this.fIj != 0) {
            this.fIi += System.currentTimeMillis() - this.fIj;
        }
        this.fHZ.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bdM() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fIf != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fIg += currentTimeMillis - this.fIf;
                this.fIf = currentTimeMillis;
            }
            this.fHZ.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bdP() {
        if (this.mCurrentState == 5) {
            this.fIf = System.currentTimeMillis();
            this.fHZ.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sx(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.jY(str);
            bdR();
            this.fHZ.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            report();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String sy(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fHV;
        }
        this.mSource = VideoPlatformStatic.jY(str);
        bdR();
        this.fIa.put("stallDuration", Long.valueOf(this.fIi));
        this.fHZ.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        report();
        return this.fHV;
    }

    @Override // com.baidu.tieba.j.i
    public boolean sz(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.jY(str);
        bdR();
        this.fHZ.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        report();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fIc == null && com.baidu.adp.lib.util.f.hA()) {
                this.fIc = new com.baidu.tieba.j.a.d(this.fHV);
                a(this.fIc);
            }
            if (this.fIc != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fIc.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.Kg())) {
            if (this.fIb == null && com.baidu.adp.lib.util.f.hA()) {
                this.fIb = new com.baidu.tieba.j.a.b(this.fHV);
                a(this.fIb);
            }
            if (this.fIb != null) {
                if (this.fIb.size() == 0) {
                    this.fIq = i2;
                }
                this.fIb.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fId == null) {
            this.fId = new ArrayList();
        }
        this.fId.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fHV;
        }
        this.fHX = i;
        this.fIl = false;
        this.fIm = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.jY(str);
        bdR();
        if (!v.I(this.fId)) {
            int size = this.fId.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fId.get(i4);
                if (cVar != null) {
                    cVar.bee();
                }
            }
        }
        this.fHZ.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bdQ()));
        this.mCurrentState = -1;
        report();
        return this.fHV;
    }

    private com.baidu.tieba.j.a.e[] bdQ() {
        if (this.fId == null || this.fId.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fId.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fId.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fId.get(i2).bec();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void sA(String str) {
        this.fIo = str;
    }

    private void bdR() {
        if (this.fIf != 0) {
            this.fIg += System.currentTimeMillis() - this.fIf;
        }
        this.fIa.put("playDuration", Long.valueOf(this.fIg));
        this.fIa.put("stallCount", Long.valueOf(this.fIh));
        this.fIa.put("stallDuration", Long.valueOf(this.fIi));
        if (!this.fIa.containsKey("loadingTime")) {
            this.fIa.put("loadingTime", 0L);
        }
        this.fIe = 0L;
        this.fIf = 0L;
        this.fIg = 0L;
        this.fIh = 0L;
        this.fIi = 0L;
        this.fIj = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void report() {
        if (!this.fIn) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.Kb() || !this.fIl) && reportType != 3) {
                this.fIn = true;
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
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fIl)) {
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
                        com.baidu.tieba.t.e.bIX().c(jSONObject, j.this.fIl ? false : true);
                        if (j.this.fIp != null) {
                            j.this.fIp.clear();
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
        if (this.fIp != null) {
            try {
                int size = this.fIp.size();
                for (int i = 0; i < size; i++) {
                    this.fIp.get(i).ao(We);
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
            for (Map.Entry<String, Long> entry : this.fIa.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fIa.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fIa.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fIa.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fIa.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fIk ? 1 : 0);
            jSONObject.put("playSuccess", this.fIl ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bdT());
            jSONObject.put("retryError", this.fIm ? 1 : 0);
            jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.mError);
            if (this.fIp != null) {
                int size = this.fIp.size();
                for (int i = 0; i < size; i++) {
                    this.fIp.get(i).ap(jSONObject);
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
            jSONObject.put(SystemScreenshotManager.PAGE, this.fIr);
            jSONObject.put("tid", this.fIs);
            jSONObject.put("preparedTime", this.fIt);
            jSONObject.put("startTime", this.fIu);
            jSONObject.put("totalTime", this.fIv);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.fIw);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.fIx);
            jSONObject.put("autoPlay", this.fIy);
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
            jSONObject.put("uuid", this.fHV);
            if (!StringUtils.isNull(this.fHW)) {
                jSONObject.put("parentUuid", this.fHW);
            }
            jSONObject.put("tid", this.bjn);
            jSONObject.put("videoUrl", this.aFr);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.hA(this.fHX));
            jSONObject.put("urlType", this.fHY);
            jSONObject.put("sub_error", this.fIq);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fIo)) {
                jSONObject.put("error_stack", this.fIo);
            }
            if (this.fIp != null) {
                int size = this.fIp.size();
                for (int i = 0; i < size; i++) {
                    this.fIp.get(i).aq(jSONObject);
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
        if (this.fHZ == null) {
            return jSONArray;
        }
        int size = this.fHZ.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fHZ.get(i).btE());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fIp == null) {
            this.fIp = new ArrayList();
        }
        this.fIp.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jS(boolean z) {
        this.fIl = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bdN() {
        return this.fHV;
    }

    @Override // com.baidu.tieba.j.i
    public String bdO() {
        return this.fIq + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ao.isEmpty(str)) {
            str = "default";
        }
        this.fIr = str;
        this.fIt = j;
        this.fIu = j2;
        this.fIv = j3;
        this.fIw = j4;
        this.fIx = j5;
        this.fIs = str2;
        this.fIy = i;
    }

    private void bdW() {
        this.fIr = "default";
        this.fIt = 0L;
        this.fIu = 0L;
        this.fIv = 0L;
        this.fIw = 0L;
        this.fIx = 0L;
        this.fIs = "";
        this.fIy = 0;
    }
}
