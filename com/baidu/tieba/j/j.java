package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.VideoPlatformStatic;
import com.coremedia.iso.boxes.UserBox;
import com.tencent.connect.share.QzonePublish;
import com.vivo.push.util.NotifyAdapterUtil;
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
    private String bWU;
    private String bWh;
    private com.baidu.tieba.j.a.b hwA;
    private com.baidu.tieba.j.a.d hwB;
    private List<com.baidu.tieba.j.a.c> hwC;
    private long hwG;
    private long hwH;
    private long hwI;
    private boolean hwJ;
    private boolean hwM;
    private String hwN;
    private List<b> hwO;
    private int hwP;
    private String hwQ;
    private String hwR;
    private long hwS;
    private long hwT;
    private long hwU;
    private long hwV;
    private long hwW;
    private int hwX;
    private String hwv;
    private int hww;
    private int hwx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hwK = true;
    private boolean hwL = false;
    private String hwu = UUID.randomUUID().toString();
    private Map<String, Long> hwz = new HashMap();
    private List<com.baidu.tieba.m.c> hwy = new ArrayList();
    private long hwD = 0;
    private long hwE = 0;
    private long hwF = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bWU = str;
        this.bWh = str2;
        this.hwv = str3;
        bPh();
    }

    @Override // com.baidu.tieba.j.i
    public void bOS() {
        this.hwD = System.currentTimeMillis();
        this.hwy.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void Bb(String str) {
        Bg(str);
        this.hwy.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void Bg(String str) {
        if (!StringUtils.isNull(str)) {
            this.hwx = VideoPlatformStatic.si(str);
            if (this.hwx != 0) {
                this.hwJ = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bOT() {
        this.hwy.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bOU() {
        if (this.mCurrentState != 2) {
            this.hwD = System.currentTimeMillis();
            this.hwy.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hwD = System.currentTimeMillis();
        Bg(str);
        this.hwy.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void xn(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hww = i;
            this.hwK = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hwD;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hwz.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hwD = 0L;
            this.hwE = System.currentTimeMillis();
            this.hwy.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void xo(int i) {
        if (this.mCurrentState == 5) {
            bPa();
        } else if (this.mCurrentState == 3) {
            this.hww = i;
            this.hwy.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bOV() {
        if (this.hwE != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hwF += currentTimeMillis - this.hwE;
            this.hwE = currentTimeMillis;
        }
        this.hwG++;
        this.hwI = System.currentTimeMillis();
        this.hwy.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bOW() {
        this.hwE = System.currentTimeMillis();
        if (this.hwI != 0) {
            this.hwH += System.currentTimeMillis() - this.hwI;
        }
        this.hwy.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bOX() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hwE != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hwF += currentTimeMillis - this.hwE;
                this.hwE = currentTimeMillis;
            }
            this.hwy.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bPa() {
        if (this.mCurrentState == 5) {
            this.hwE = System.currentTimeMillis();
            this.hwy.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Bc(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.sj(str);
            bPc();
            this.hwy.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Gb();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String Bd(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hwu;
        }
        this.mSource = VideoPlatformStatic.sj(str);
        bPc();
        this.hwz.put("stallDuration", Long.valueOf(this.hwH));
        this.hwy.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Gb();
        return this.hwu;
    }

    @Override // com.baidu.tieba.j.i
    public boolean Be(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.sj(str);
        bPc();
        this.hwy.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Gb();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hwB == null && com.baidu.adp.lib.util.f.gB()) {
                this.hwB = new com.baidu.tieba.j.a.d(this.hwu);
                a(this.hwB);
            }
            if (this.hwB != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hwB.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.apJ())) {
            if (this.hwA == null && com.baidu.adp.lib.util.f.gB()) {
                this.hwA = new com.baidu.tieba.j.a.b(this.hwu);
                a(this.hwA);
            }
            if (this.hwA != null) {
                if (this.hwA.size() == 0) {
                    this.hwP = i2;
                }
                this.hwA.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hwC == null) {
            this.hwC = new ArrayList();
        }
        this.hwC.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hwu;
        }
        this.hww = i;
        this.hwK = false;
        this.hwL = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.sj(str);
        bPc();
        if (!v.aa(this.hwC)) {
            int size = this.hwC.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hwC.get(i4);
                if (cVar != null) {
                    cVar.bPp();
                }
            }
        }
        this.hwy.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bPb()));
        this.mCurrentState = -1;
        Gb();
        return this.hwu;
    }

    private com.baidu.tieba.j.a.e[] bPb() {
        if (this.hwC == null || this.hwC.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hwC.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hwC.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hwC.get(i2).bPn();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void Bf(String str) {
        this.hwN = str;
    }

    private void bPc() {
        if (this.hwE != 0) {
            this.hwF += System.currentTimeMillis() - this.hwE;
        }
        this.hwz.put("playDuration", Long.valueOf(this.hwF));
        this.hwz.put("stallCount", Long.valueOf(this.hwG));
        this.hwz.put("stallDuration", Long.valueOf(this.hwH));
        if (!this.hwz.containsKey("loadingTime")) {
            this.hwz.put("loadingTime", 0L);
        }
        this.hwD = 0L;
        this.hwE = 0L;
        this.hwF = 0L;
        this.hwG = 0L;
        this.hwH = 0L;
        this.hwI = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Gb() {
        if (!this.hwM) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.apE() || !this.hwK) && reportType != 3) {
                this.hwM = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aCB());
                            jSONObject.put("kpiInfo", j.this.bPd());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hwK)) {
                                JSONObject bPf = j.this.bPf();
                                bPf.put("running", j.this.bPg());
                                jSONObject.put("debugInfo", bPf);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bPf());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.ctH().c(jSONObject, j.this.hwK ? false : true);
                        if (j.this.hwO != null) {
                            j.this.hwO.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aCB() {
        JSONObject aCB = VideoPlatformStatic.aCB();
        if (this.hwO != null) {
            try {
                int size = this.hwO.size();
                for (int i = 0; i < size; i++) {
                    this.hwO.get(i).bJ(aCB);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aCB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bPd() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hwz.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hwz.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hwz.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hwz.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hwz.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hwJ ? 1 : 0);
            jSONObject.put("playSuccess", this.hwK ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bPe());
            jSONObject.put("retryError", this.hwL ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.hwO != null) {
                int size = this.hwO.size();
                for (int i = 0; i < size; i++) {
                    this.hwO.get(i).bK(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bPe() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hwQ);
            jSONObject.put("tid", this.hwR);
            jSONObject.put("preparedTime", this.hwS);
            jSONObject.put("startTime", this.hwT);
            jSONObject.put("totalTime", this.hwU);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hwV);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hwW);
            jSONObject.put("autoPlay", this.hwX);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bPh();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bPf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.hwu);
            if (!StringUtils.isNull(this.hwv)) {
                jSONObject.put("parentUuid", this.hwv);
            }
            jSONObject.put("tid", this.bWU);
            jSONObject.put("videoUrl", this.bWh);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.mm(this.hww));
            jSONObject.put("urlType", this.hwx);
            jSONObject.put("sub_error", this.hwP);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hwN)) {
                jSONObject.put("error_stack", this.hwN);
            }
            if (this.hwO != null) {
                int size = this.hwO.size();
                for (int i = 0; i < size; i++) {
                    this.hwO.get(i).bL(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bPg() {
        JSONArray jSONArray = new JSONArray();
        if (this.hwy == null) {
            return jSONArray;
        }
        int size = this.hwy.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hwy.get(i).cfB());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hwO == null) {
            this.hwO = new ArrayList();
        }
        this.hwO.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void nx(boolean z) {
        this.hwK = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bOY() {
        return this.hwu;
    }

    @Override // com.baidu.tieba.j.i
    public String bOZ() {
        return this.hwP + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (aq.isEmpty(str)) {
            str = NotifyAdapterUtil.PRIMARY_CHANNEL;
        }
        this.hwQ = str;
        this.hwS = j;
        this.hwT = j2;
        this.hwU = j3;
        this.hwV = j4;
        this.hwW = j5;
        this.hwR = str2;
        this.hwX = i;
    }

    private void bPh() {
        this.hwQ = NotifyAdapterUtil.PRIMARY_CHANNEL;
        this.hwS = 0L;
        this.hwT = 0L;
        this.hwU = 0L;
        this.hwV = 0L;
        this.hwW = 0L;
        this.hwR = "";
        this.hwX = 0;
    }
}
