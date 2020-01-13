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
/* loaded from: classes8.dex */
public class j implements i {
    private String OG;
    private String inT;
    private int inU;
    private int inV;
    private com.baidu.tieba.j.a.b inY;
    private com.baidu.tieba.j.a.d inZ;
    private List<com.baidu.tieba.j.a.c> ioa;
    private long ioe;
    private long iof;
    private long iog;
    private boolean ioh;
    private boolean iok;
    private String iol;
    private List<b> iom;
    private int ion;
    private String ioo;
    private String iop;
    private long ioq;
    private long ior;
    private long ios;
    private long iot;
    private long iou;
    private int iov;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean ioi = true;
    private boolean ioj = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> inX = new HashMap();
    private List<com.baidu.tieba.m.c> inW = new ArrayList();
    private long iob = 0;
    private long ioc = 0;
    private long iod = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.OG = str;
        this.mVideoUrl = str2;
        this.inT = str3;
        cfn();
    }

    @Override // com.baidu.tieba.j.i
    public void ceY() {
        this.iob = System.currentTimeMillis();
        this.inW.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void EM(String str) {
        ER(str);
        this.inW.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.j.i
    public void oN(boolean z) {
        this.ioh = z;
        this.inW.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void ER(String str) {
        if (!StringUtils.isNull(str)) {
            this.inV = VideoPlatformStatic.wq(str);
            if (this.inV != 0) {
                this.ioh = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void ceZ() {
        this.inW.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void cfa() {
        if (this.mCurrentState != 2) {
            this.iob = System.currentTimeMillis();
            this.inW.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.iob = System.currentTimeMillis();
        ER(str);
        this.inW.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void yb(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.inU = i;
            this.ioi = true;
            long currentTimeMillis = System.currentTimeMillis() - this.iob;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.inX.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.iob = 0L;
            this.ioc = System.currentTimeMillis();
            this.inW.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void yc(int i) {
        if (this.mCurrentState == 5) {
            cfg();
        } else if (this.mCurrentState == 3) {
            this.inU = i;
            this.inW.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void cfb() {
        if (this.ioc != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.iod += currentTimeMillis - this.ioc;
            this.ioc = currentTimeMillis;
        }
        this.ioe++;
        this.iog = System.currentTimeMillis();
        this.inW.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void cfc() {
        this.ioc = System.currentTimeMillis();
        if (this.iog != 0) {
            this.iof += System.currentTimeMillis() - this.iog;
        }
        this.inW.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void cfd() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.ioc != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.iod += currentTimeMillis - this.ioc;
                this.ioc = currentTimeMillis;
            }
            this.inW.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cfg() {
        if (this.mCurrentState == 5) {
            this.ioc = System.currentTimeMillis();
            this.inW.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void EN(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.wr(str);
            cfi();
            this.inW.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            TW();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String EO(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.wr(str);
        cfi();
        this.inX.put("stallDuration", Long.valueOf(this.iof));
        this.inW.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        TW();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public boolean EP(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.wr(str);
        cfi();
        this.inW.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        TW();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.inZ == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.inZ = new com.baidu.tieba.j.a.d(this.mUuid);
                a(this.inZ);
            }
            if (this.inZ != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.inZ.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aJG())) {
            if (this.inY == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.inY = new com.baidu.tieba.j.a.b(this.mUuid);
                a(this.inY);
            }
            if (this.inY != null) {
                if (this.inY.size() == 0) {
                    this.ion = i2;
                }
                this.inY.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.ioa == null) {
            this.ioa = new ArrayList();
        }
        this.ioa.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.inU = i;
        this.ioi = false;
        this.ioj = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.wr(str);
        cfi();
        if (!v.isEmpty(this.ioa)) {
            int size = this.ioa.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.ioa.get(i4);
                if (cVar != null) {
                    cVar.cfw();
                }
            }
        }
        this.inW.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, cfh()));
        this.mCurrentState = -1;
        TW();
        return this.mUuid;
    }

    private com.baidu.tieba.j.a.e[] cfh() {
        if (this.ioa == null || this.ioa.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.ioa.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ioa.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.ioa.get(i2).cfu();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void EQ(String str) {
        this.iol = str;
    }

    private void cfi() {
        if (this.ioc != 0) {
            this.iod += System.currentTimeMillis() - this.ioc;
        }
        this.inX.put("playDuration", Long.valueOf(this.iod));
        this.inX.put("stallCount", Long.valueOf(this.ioe));
        this.inX.put("stallDuration", Long.valueOf(this.iof));
        if (!this.inX.containsKey("loadingTime")) {
            this.inX.put("loadingTime", 0L);
        }
        this.iob = 0L;
        this.ioc = 0L;
        this.iod = 0L;
        this.ioe = 0L;
        this.iof = 0L;
        this.iog = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void TW() {
        if (!this.iok) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aJB() || !this.ioi) && reportType != 3) {
                this.iok = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aVj());
                            jSONObject.put("kpiInfo", j.this.cfj());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.ioi)) {
                                JSONObject cfl = j.this.cfl();
                                cfl.put("running", j.this.cfm());
                                jSONObject.put("debugInfo", cfl);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cfl());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.t.e.cNp().e(jSONObject, j.this.ioi ? false : true);
                        if (j.this.iom != null) {
                            j.this.iom.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aVj() {
        JSONObject aVj = VideoPlatformStatic.aVj();
        if (this.iom != null) {
            try {
                int size = this.iom.size();
                for (int i = 0; i < size; i++) {
                    this.iom.get(i).cZ(aVj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aVj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cfj() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.inX.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.inX.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.inX.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.inX.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.inX.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.ioh ? 1 : 0);
            jSONObject.put("playSuccess", this.ioi ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", cfk());
            jSONObject.put("retryError", this.ioj ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.iom != null) {
                int size = this.iom.size();
                for (int i = 0; i < size; i++) {
                    this.iom.get(i).da(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject cfk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.ioo);
            jSONObject.put("tid", this.iop);
            jSONObject.put("preparedTime", this.ioq);
            jSONObject.put("startTime", this.ior);
            jSONObject.put("totalTime", this.ios);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.iot);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.iou);
            jSONObject.put("autoPlay", this.iov);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cfn();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cfl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.inT)) {
                jSONObject.put("parentUuid", this.inT);
            }
            jSONObject.put("tid", this.OG);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.nI(this.inU));
            jSONObject.put("urlType", this.inV);
            jSONObject.put("sub_error", this.ion);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.iol)) {
                jSONObject.put("error_stack", this.iol);
            }
            if (this.iom != null) {
                int size = this.iom.size();
                for (int i = 0; i < size; i++) {
                    this.iom.get(i).db(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray cfm() {
        JSONArray jSONArray = new JSONArray();
        if (this.inW == null) {
            return jSONArray;
        }
        int size = this.inW.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.inW.get(i).cyp());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.iom == null) {
            this.iom = new ArrayList();
        }
        this.iom.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void oO(boolean z) {
        this.ioi = z;
    }

    @Override // com.baidu.tieba.j.i
    public String cfe() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public String cff() {
        return this.ion + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (aq.isEmpty(str)) {
            str = "default";
        }
        this.ioo = str;
        this.ioq = j;
        this.ior = j2;
        this.ios = j3;
        this.iot = j4;
        this.iou = j5;
        this.iop = str2;
        this.iov = i;
    }

    private void cfn() {
        this.ioo = "default";
        this.ioq = 0L;
        this.ior = 0L;
        this.ios = 0L;
        this.iot = 0L;
        this.iou = 0L;
        this.iop = "";
        this.iov = 0;
    }
}
