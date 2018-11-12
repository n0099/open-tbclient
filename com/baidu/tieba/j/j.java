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
    private String aBn;
    private String beV;
    private List<com.baidu.tieba.j.a.c> fxA;
    private long fxE;
    private long fxF;
    private long fxG;
    private boolean fxH;
    private boolean fxK;
    private String fxL;
    private List<b> fxM;
    private int fxN;
    private String fxO;
    private String fxP;
    private long fxQ;
    private long fxR;
    private long fxS;
    private long fxT;
    private long fxU;
    private int fxV;
    private String fxt;
    private int fxu;
    private int fxv;
    private com.baidu.tieba.j.a.b fxy;
    private com.baidu.tieba.j.a.d fxz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean fxI = true;
    private boolean fxJ = false;
    private String fxs = UUID.randomUUID().toString();
    private Map<String, Long> fxx = new HashMap();
    private List<com.baidu.tieba.m.c> fxw = new ArrayList();
    private long fxB = 0;
    private long fxC = 0;
    private long fxD = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.beV = str;
        this.aBn = str2;
        this.fxt = str3;
        baS();
    }

    @Override // com.baidu.tieba.j.i
    public void baD() {
        this.fxB = System.currentTimeMillis();
        this.fxw.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void rA(String str) {
        rF(str);
        this.fxw.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void rF(String str) {
        if (!StringUtils.isNull(str)) {
            this.fxv = VideoPlatformStatic.jo(str);
            if (this.fxv != 0) {
                this.fxH = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void baE() {
        this.fxw.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void baF() {
        if (this.mCurrentState != 2) {
            this.fxB = System.currentTimeMillis();
            this.fxw.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.fxB = System.currentTimeMillis();
        rF(str);
        this.fxw.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void rn(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.fxu = i;
            this.fxI = true;
            long currentTimeMillis = System.currentTimeMillis() - this.fxB;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = ErrDef.Feature.WEIGHT;
            }
            this.fxx.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.fxB = 0L;
            this.fxC = System.currentTimeMillis();
            this.fxw.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void ro(int i) {
        if (this.mCurrentState == 5) {
            baL();
        } else if (this.mCurrentState == 3) {
            this.fxu = i;
            this.fxw.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void baG() {
        if (this.fxC != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fxD += currentTimeMillis - this.fxC;
            this.fxC = currentTimeMillis;
        }
        this.fxE++;
        this.fxG = System.currentTimeMillis();
        this.fxw.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void baH() {
        this.fxC = System.currentTimeMillis();
        if (this.fxG != 0) {
            this.fxF += System.currentTimeMillis() - this.fxG;
        }
        this.fxw.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void baI() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.fxC != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fxD += currentTimeMillis - this.fxC;
                this.fxC = currentTimeMillis;
            }
            this.fxw.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void baL() {
        if (this.mCurrentState == 5) {
            this.fxC = System.currentTimeMillis();
            this.fxw.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rB(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.jp(str);
            baN();
            this.fxw.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            report();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String rC(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fxs;
        }
        this.mSource = VideoPlatformStatic.jp(str);
        baN();
        this.fxx.put("stallDuration", Long.valueOf(this.fxF));
        this.fxw.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        report();
        return this.fxs;
    }

    @Override // com.baidu.tieba.j.i
    public boolean rD(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.jp(str);
        baN();
        this.fxw.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        report();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void f(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.fxz == null && com.baidu.adp.lib.util.f.hA()) {
                this.fxz = new com.baidu.tieba.j.a.d(this.fxs);
                a(this.fxz);
            }
            if (this.fxz != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.fxz.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.IM())) {
            if (this.fxy == null && com.baidu.adp.lib.util.f.hA()) {
                this.fxy = new com.baidu.tieba.j.a.b(this.fxs);
                a(this.fxy);
            }
            if (this.fxy != null) {
                if (this.fxy.size() == 0) {
                    this.fxN = i2;
                }
                this.fxy.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.fxA == null) {
            this.fxA = new ArrayList();
        }
        this.fxA.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.fxs;
        }
        this.fxu = i;
        this.fxI = false;
        this.fxJ = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.jp(str);
        baN();
        if (!v.I(this.fxA)) {
            int size = this.fxA.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.fxA.get(i4);
                if (cVar != null) {
                    cVar.bba();
                }
            }
        }
        this.fxw.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, baM()));
        this.mCurrentState = -1;
        report();
        return this.fxs;
    }

    private com.baidu.tieba.j.a.e[] baM() {
        if (this.fxA == null || this.fxA.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.fxA.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fxA.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.fxA.get(i2).baY();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void rE(String str) {
        this.fxL = str;
    }

    private void baN() {
        if (this.fxC != 0) {
            this.fxD += System.currentTimeMillis() - this.fxC;
        }
        this.fxx.put("playDuration", Long.valueOf(this.fxD));
        this.fxx.put("stallCount", Long.valueOf(this.fxE));
        this.fxx.put("stallDuration", Long.valueOf(this.fxF));
        if (!this.fxx.containsKey("loadingTime")) {
            this.fxx.put("loadingTime", 0L);
        }
        this.fxB = 0L;
        this.fxC = 0L;
        this.fxD = 0L;
        this.fxE = 0L;
        this.fxF = 0L;
        this.fxG = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void report() {
        if (!this.fxK) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.IH() || !this.fxI) && reportType != 3) {
                this.fxK = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.UA());
                            jSONObject.put("kpiInfo", j.this.baO());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.fxI)) {
                                JSONObject baQ = j.this.baQ();
                                baQ.put("running", j.this.baR());
                                jSONObject.put("debugInfo", baQ);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.baQ());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.bFv().b(jSONObject, j.this.fxI ? false : true);
                        if (j.this.fxM != null) {
                            j.this.fxM.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject UA() {
        JSONObject UA = VideoPlatformStatic.UA();
        if (this.fxM != null) {
            try {
                int size = this.fxM.size();
                for (int i = 0; i < size; i++) {
                    this.fxM.get(i).am(UA);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return UA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject baO() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.fxx.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.fxx.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.fxx.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.fxx.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.fxx.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.fxH ? 1 : 0);
            jSONObject.put("playSuccess", this.fxI ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", baP());
            jSONObject.put("retryError", this.fxJ ? 1 : 0);
            jSONObject.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, this.mError);
            if (this.fxM != null) {
                int size = this.fxM.size();
                for (int i = 0; i < size; i++) {
                    this.fxM.get(i).an(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject baP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SystemScreenshotManager.PAGE, this.fxO);
            jSONObject.put("tid", this.fxP);
            jSONObject.put("preparedTime", this.fxQ);
            jSONObject.put("startTime", this.fxR);
            jSONObject.put("totalTime", this.fxS);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.fxT);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.fxU);
            jSONObject.put("autoPlay", this.fxV);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        baS();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject baQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.fxs);
            if (!StringUtils.isNull(this.fxt)) {
                jSONObject.put("parentUuid", this.fxt);
            }
            jSONObject.put("tid", this.beV);
            jSONObject.put("videoUrl", this.aBn);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.hl(this.fxu));
            jSONObject.put("urlType", this.fxv);
            jSONObject.put("sub_error", this.fxN);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.fxL)) {
                jSONObject.put("error_stack", this.fxL);
            }
            if (this.fxM != null) {
                int size = this.fxM.size();
                for (int i = 0; i < size; i++) {
                    this.fxM.get(i).ao(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray baR() {
        JSONArray jSONArray = new JSONArray();
        if (this.fxw == null) {
            return jSONArray;
        }
        int size = this.fxw.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.fxw.get(i).bqr());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.fxM == null) {
            this.fxM = new ArrayList();
        }
        this.fxM.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void jM(boolean z) {
        this.fxI = z;
    }

    @Override // com.baidu.tieba.j.i
    public String baJ() {
        return this.fxs;
    }

    @Override // com.baidu.tieba.j.i
    public String baK() {
        return this.fxN + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (ao.isEmpty(str)) {
            str = "default";
        }
        this.fxO = str;
        this.fxQ = j;
        this.fxR = j2;
        this.fxS = j3;
        this.fxT = j4;
        this.fxU = j5;
        this.fxP = str2;
        this.fxV = i;
    }

    private void baS() {
        this.fxO = "default";
        this.fxQ = 0L;
        this.fxR = 0L;
        this.fxS = 0L;
        this.fxT = 0L;
        this.fxU = 0L;
        this.fxP = "";
        this.fxV = 0;
    }
}
