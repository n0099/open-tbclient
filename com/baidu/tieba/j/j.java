package com.baidu.tieba.j;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
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
/* loaded from: classes7.dex */
public class j implements i {
    private String OC;
    private long ikA;
    private boolean ikB;
    private boolean ikE;
    private String ikF;
    private List<b> ikG;
    private int ikH;
    private String ikI;
    private String ikJ;
    private long ikK;
    private long ikL;
    private long ikM;
    private long ikN;
    private long ikO;
    private int ikP;
    private String ikn;
    private int iko;
    private int ikp;
    private com.baidu.tieba.j.a.b iks;
    private com.baidu.tieba.j.a.d ikt;
    private List<com.baidu.tieba.j.a.c> iku;
    private long iky;
    private long ikz;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean ikC = true;
    private boolean ikD = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> ikr = new HashMap();
    private List<com.baidu.tieba.m.c> ikq = new ArrayList();
    private long ikv = 0;
    private long ikw = 0;
    private long ikx = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.OC = str;
        this.mVideoUrl = str2;
        this.ikn = str3;
        cee();
    }

    @Override // com.baidu.tieba.j.i
    public void cdP() {
        this.ikv = System.currentTimeMillis();
        this.ikq.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void EC(String str) {
        EH(str);
        this.ikq.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.j.i
    public void oB(boolean z) {
        this.ikB = z;
        this.ikq.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void EH(String str) {
        if (!StringUtils.isNull(str)) {
            this.ikp = VideoPlatformStatic.wm(str);
            if (this.ikp != 0) {
                this.ikB = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void cdQ() {
        this.ikq.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void cdR() {
        if (this.mCurrentState != 2) {
            this.ikv = System.currentTimeMillis();
            this.ikq.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.ikv = System.currentTimeMillis();
        EH(str);
        this.ikq.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void xW(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.iko = i;
            this.ikC = true;
            long currentTimeMillis = System.currentTimeMillis() - this.ikv;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.ikr.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.ikv = 0L;
            this.ikw = System.currentTimeMillis();
            this.ikq.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void xX(int i) {
        if (this.mCurrentState == 5) {
            cdX();
        } else if (this.mCurrentState == 3) {
            this.iko = i;
            this.ikq.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void cdS() {
        if (this.ikw != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ikx += currentTimeMillis - this.ikw;
            this.ikw = currentTimeMillis;
        }
        this.iky++;
        this.ikA = System.currentTimeMillis();
        this.ikq.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void cdT() {
        this.ikw = System.currentTimeMillis();
        if (this.ikA != 0) {
            this.ikz += System.currentTimeMillis() - this.ikA;
        }
        this.ikq.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void cdU() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.ikw != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.ikx += currentTimeMillis - this.ikw;
                this.ikw = currentTimeMillis;
            }
            this.ikq.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void cdX() {
        if (this.mCurrentState == 5) {
            this.ikw = System.currentTimeMillis();
            this.ikq.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void ED(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.wn(str);
            cdZ();
            this.ikq.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Tz();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String EE(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.wn(str);
        cdZ();
        this.ikr.put("stallDuration", Long.valueOf(this.ikz));
        this.ikq.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Tz();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public boolean EF(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.wn(str);
        cdZ();
        this.ikq.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Tz();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void k(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.ikt == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.ikt = new com.baidu.tieba.j.a.d(this.mUuid);
                a(this.ikt);
            }
            if (this.ikt != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.ikt.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aJm())) {
            if (this.iks == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.iks = new com.baidu.tieba.j.a.b(this.mUuid);
                a(this.iks);
            }
            if (this.iks != null) {
                if (this.iks.size() == 0) {
                    this.ikH = i2;
                }
                this.iks.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.iku == null) {
            this.iku = new ArrayList();
        }
        this.iku.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.iko = i;
        this.ikC = false;
        this.ikD = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.wn(str);
        cdZ();
        if (!v.isEmpty(this.iku)) {
            int size = this.iku.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.iku.get(i4);
                if (cVar != null) {
                    cVar.cen();
                }
            }
        }
        this.ikq.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, cdY()));
        this.mCurrentState = -1;
        Tz();
        return this.mUuid;
    }

    private com.baidu.tieba.j.a.e[] cdY() {
        if (this.iku == null || this.iku.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.iku.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iku.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.iku.get(i2).cel();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void EG(String str) {
        this.ikF = str;
    }

    private void cdZ() {
        if (this.ikw != 0) {
            this.ikx += System.currentTimeMillis() - this.ikw;
        }
        this.ikr.put("playDuration", Long.valueOf(this.ikx));
        this.ikr.put("stallCount", Long.valueOf(this.iky));
        this.ikr.put("stallDuration", Long.valueOf(this.ikz));
        if (!this.ikr.containsKey("loadingTime")) {
            this.ikr.put("loadingTime", 0L);
        }
        this.ikv = 0L;
        this.ikw = 0L;
        this.ikx = 0L;
        this.iky = 0L;
        this.ikz = 0L;
        this.ikA = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Tz() {
        if (!this.ikE) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aJh() || !this.ikC) && reportType != 3) {
                this.ikE = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aUP());
                            jSONObject.put("kpiInfo", j.this.cea());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.ikC)) {
                                JSONObject cec = j.this.cec();
                                cec.put("running", j.this.ced());
                                jSONObject.put("debugInfo", cec);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.cec());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.t.e.cMk().e(jSONObject, j.this.ikC ? false : true);
                        if (j.this.ikG != null) {
                            j.this.ikG.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aUP() {
        JSONObject aUP = VideoPlatformStatic.aUP();
        if (this.ikG != null) {
            try {
                int size = this.ikG.size();
                for (int i = 0; i < size; i++) {
                    this.ikG.get(i).cZ(aUP);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aUP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cea() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.ikr.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.ikr.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.ikr.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.ikr.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.ikr.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.ikB ? 1 : 0);
            jSONObject.put("playSuccess", this.ikC ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", ceb());
            jSONObject.put("retryError", this.ikD ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.ikG != null) {
                int size = this.ikG.size();
                for (int i = 0; i < size; i++) {
                    this.ikG.get(i).da(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject ceb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.ikI);
            jSONObject.put("tid", this.ikJ);
            jSONObject.put("preparedTime", this.ikK);
            jSONObject.put("startTime", this.ikL);
            jSONObject.put("totalTime", this.ikM);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.ikN);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.ikO);
            jSONObject.put("autoPlay", this.ikP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cee();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cec() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.ikn)) {
                jSONObject.put("parentUuid", this.ikn);
            }
            jSONObject.put("tid", this.OC);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.nI(this.iko));
            jSONObject.put("urlType", this.ikp);
            jSONObject.put("sub_error", this.ikH);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.ikF)) {
                jSONObject.put("error_stack", this.ikF);
            }
            if (this.ikG != null) {
                int size = this.ikG.size();
                for (int i = 0; i < size; i++) {
                    this.ikG.get(i).db(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray ced() {
        JSONArray jSONArray = new JSONArray();
        if (this.ikq == null) {
            return jSONArray;
        }
        int size = this.ikq.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.ikq.get(i).cxi());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.ikG == null) {
            this.ikG = new ArrayList();
        }
        this.ikG.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void oC(boolean z) {
        this.ikC = z;
    }

    @Override // com.baidu.tieba.j.i
    public String cdV() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.j.i
    public String cdW() {
        return this.ikH + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (aq.isEmpty(str)) {
            str = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        }
        this.ikI = str;
        this.ikK = j;
        this.ikL = j2;
        this.ikM = j3;
        this.ikN = j4;
        this.ikO = j5;
        this.ikJ = str2;
        this.ikP = i;
    }

    private void cee() {
        this.ikI = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        this.ikK = 0L;
        this.ikL = 0L;
        this.ikM = 0L;
        this.ikN = 0L;
        this.ikO = 0L;
        this.ikJ = "";
        this.ikP = 0;
    }
}
