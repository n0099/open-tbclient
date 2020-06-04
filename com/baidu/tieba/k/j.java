package com.baidu.tieba.k;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.VideoPlatformStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j implements i {
    private String ais;
    private String jrV;
    private int jrW;
    private int jrX;
    private com.baidu.tieba.k.a.b jsa;
    private com.baidu.tieba.k.a.d jsb;
    private List<com.baidu.tieba.k.a.c> jsc;
    private long jsg;
    private long jsh;
    private long jsi;
    private boolean jsk;
    private boolean jso;
    private String jsp;
    private List<b> jsq;
    private int jsr;
    private long jss;
    private long jst;
    private long jsu;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean jsl = true;
    private boolean jsm = false;
    private boolean jsn = false;
    private boolean jsv = false;
    private boolean jsw = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> jrZ = new HashMap();
    private List<com.baidu.tieba.n.c> jrY = new ArrayList();
    private long jsd = 0;
    private long jse = 0;
    private long jsf = 0;
    private ArrayList<Integer> jsj = new ArrayList<>();

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.ais = str;
        this.mVideoUrl = str2;
        this.jrV = str3;
        cyN();
    }

    @Override // com.baidu.tieba.k.i
    public void cyy() {
        this.jsd = System.currentTimeMillis();
        this.jrY.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void Ix(String str) {
        IC(str);
        this.jrY.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void qx(boolean z) {
        this.jsk = z;
        this.jrY.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void IC(String str) {
        if (!StringUtils.isNull(str)) {
            this.jrX = VideoPlatformStatic.zH(str);
            if (this.jrX != 0) {
                this.jsk = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cyz() {
        this.jrY.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void cyA() {
        if (this.mCurrentState != 2) {
            this.jsd = System.currentTimeMillis();
            this.jrY.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void ac(boolean z, boolean z2) {
        this.jsv = z;
        this.jsw = z2;
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.jsd = System.currentTimeMillis();
        IC(str);
        this.jrY.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void zA(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jrW = i;
            this.jsl = true;
            long currentTimeMillis = System.currentTimeMillis() - this.jsd;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.jrZ.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.jsd = 0L;
            this.jrY.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void zB(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.jrW = i;
            this.jsl = true;
            this.jsm = true;
            this.jrZ.put("loadingTime", 1L);
            this.jsd = 0L;
            this.jrY.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void zC(int i) {
        if (this.mCurrentState == 5) {
            cyG();
        } else if (this.mCurrentState == 3) {
            this.jrW = i;
            this.jse = System.currentTimeMillis();
            this.jrY.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cyB() {
        if (this.jse != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.jsf += currentTimeMillis - this.jse;
            this.jse = currentTimeMillis;
        }
        this.jsg++;
        this.jsi = System.currentTimeMillis();
        this.jrY.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void cyC() {
        this.jse = System.currentTimeMillis();
        if (this.jsi != 0) {
            this.jsh += System.currentTimeMillis() - this.jsi;
        }
        this.jrY.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void s(long j, int i) {
        this.jsg++;
        this.jsh += j;
        this.jsj.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.k.i
    public void cyD() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.jse != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.jsf = (currentTimeMillis - this.jse) + this.jsf;
                this.jse = 0L;
            }
            this.jrY.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cyG() {
        if (this.mCurrentState == 5) {
            this.jse = System.currentTimeMillis();
            this.jrY.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Iy(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.zI(str);
            cyI();
            this.jrY.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            ahn();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Iz(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.zI(str);
        cyI();
        this.jrZ.put("stallDuration", Long.valueOf(this.jsh));
        this.jrY.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        ahn();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean IA(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.zI(str);
        cyI();
        this.jrY.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        ahn();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.jsb == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jsb = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.jsb);
            }
            if (this.jsb != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.jsb.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.baN())) {
            if (this.jsa == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.jsa = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.jsa);
            }
            if (this.jsa != null) {
                if (this.jsa.size() == 0) {
                    this.jsr = i2;
                }
                this.jsa.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.jsc == null) {
            this.jsc = new ArrayList();
        }
        this.jsc.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.jrW = i;
        this.jsl = false;
        this.jsn = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.zI(str);
        cyI();
        if (!v.isEmpty(this.jsc)) {
            int size = this.jsc.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.jsc.get(i4);
                if (cVar != null) {
                    cVar.cyX();
                }
            }
        }
        this.jrY.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, cyH()));
        this.mCurrentState = -1;
        ahn();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] cyH() {
        if (this.jsc == null || this.jsc.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.jsc.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jsc.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.jsc.get(i2).cyV();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void IB(String str) {
        this.jsp = str;
    }

    private void cyI() {
        if (this.jse != 0) {
            this.jsf += System.currentTimeMillis() - this.jse;
        }
        this.jrZ.put("playDuration", Long.valueOf(this.jsf));
        this.jrZ.put("stallCount", Long.valueOf(this.jsg));
        this.jrZ.put("stallDuration", Long.valueOf(this.jsh));
        if (!this.jrZ.containsKey("loadingTime")) {
            this.jrZ.put("loadingTime", 0L);
        }
        this.jsd = 0L;
        this.jse = 0L;
        this.jsf = 0L;
        this.jsg = 0L;
        this.jsh = 0L;
        this.jsi = 0L;
    }

    public void ahn() {
        if (!this.jso) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.baI() || !this.jsl) && reportType != 3) {
                this.jso = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.blX());
                            jSONObject.put("kpiInfo", j.this.cyJ());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.jsl)) {
                                JSONObject cyL = j.this.cyL();
                                cyL.put("running", j.this.cyM());
                                jSONObject.put("debugInfo", cyL);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cyL());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dhG().f(jSONObject, j.this.jsl ? false : true);
                        if (j.this.jsq != null) {
                            j.this.jsq.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject blX() {
        JSONObject blX = VideoPlatformStatic.blX();
        if (this.jsq != null) {
            try {
                int size = this.jsq.size();
                for (int i = 0; i < size; i++) {
                    this.jsq.get(i).dr(blX);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return blX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cyJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.jrZ.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.jrZ.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.jrZ.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.jrZ.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.jrZ.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.jsk ? 1 : 0);
            jSONObject.put("playSuccess", this.jsl ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cyK());
            jSONObject.put("retryError", this.jsn ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.jsq != null) {
                int size = this.jsq.size();
                for (int i = 0; i < size; i++) {
                    this.jsq.get(i).ds(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cyK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.jss);
            jSONObject.put("startTime", this.jst);
            jSONObject.put("totalTime", this.jsu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cyN();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cyL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.jrV)) {
                jSONObject.put("parentUuid", this.jrV);
            }
            jSONObject.put("tid", this.ais);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.oX(this.jrW));
            jSONObject.put("urlType", this.jrX);
            jSONObject.put("sub_error", this.jsr);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.jsm ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.jsj);
            jSONObject.put("pcdn_used", this.jsv ? "1" : "0");
            jSONObject.put("p2p_used", this.jsw ? "1" : "0");
            if (!StringUtils.isNull(this.jsp)) {
                jSONObject.put("error_stack", this.jsp);
            }
            if (this.jsq != null) {
                int size = this.jsq.size();
                for (int i = 0; i < size; i++) {
                    this.jsq.get(i).dt(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cyM() {
        JSONArray jSONArray = new JSONArray();
        if (this.jrY == null) {
            return jSONArray;
        }
        int size = this.jrY.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.jrY.get(i).cSh());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.jsq == null) {
            this.jsq = new ArrayList();
        }
        this.jsq.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void qy(boolean z) {
        this.jsl = z;
    }

    @Override // com.baidu.tieba.k.i
    public String cyE() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String cyF() {
        return this.jsr + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.jss = j;
        this.jst = j2;
        this.jsu = j3;
    }

    private void cyN() {
        this.jss = 0L;
        this.jst = 0L;
        this.jsu = 0L;
    }
}
