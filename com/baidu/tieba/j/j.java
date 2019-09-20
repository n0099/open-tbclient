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
    private String bXN;
    private String bXa;
    private long hyA;
    private long hyB;
    private long hyC;
    private boolean hyD;
    private boolean hyG;
    private String hyH;
    private List<b> hyI;
    private int hyJ;
    private String hyK;
    private String hyL;
    private long hyM;
    private long hyN;
    private long hyO;
    private long hyP;
    private long hyQ;
    private int hyR;
    private String hyp;
    private int hyq;
    private int hyr;
    private com.baidu.tieba.j.a.b hyu;
    private com.baidu.tieba.j.a.d hyv;
    private List<com.baidu.tieba.j.a.c> hyw;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean hyE = true;
    private boolean hyF = false;
    private String hyo = UUID.randomUUID().toString();
    private Map<String, Long> hyt = new HashMap();
    private List<com.baidu.tieba.m.c> hys = new ArrayList();
    private long hyx = 0;
    private long hyy = 0;
    private long hyz = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.bXN = str;
        this.bXa = str2;
        this.hyp = str3;
        bPU();
    }

    @Override // com.baidu.tieba.j.i
    public void bPF() {
        this.hyx = System.currentTimeMillis();
        this.hys.add(new com.baidu.tieba.m.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.j.i
    public void BA(String str) {
        BF(str);
        this.hys.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.j.i
    public void nA(boolean z) {
        this.hyD = z;
        this.hys.add(new com.baidu.tieba.m.a(1));
        this.mCurrentState = 1;
    }

    private void BF(String str) {
        if (!StringUtils.isNull(str)) {
            this.hyr = VideoPlatformStatic.su(str);
            if (this.hyr != 0) {
                this.hyD = true;
            }
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bPG() {
        this.hys.add(new com.baidu.tieba.m.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void bPH() {
        if (this.mCurrentState != 2) {
            this.hyx = System.currentTimeMillis();
            this.hys.add(new com.baidu.tieba.m.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.hyx = System.currentTimeMillis();
        BF(str);
        this.hys.add(new com.baidu.tieba.m.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.j.i
    public void xq(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.hyq = i;
            this.hyE = true;
            long currentTimeMillis = System.currentTimeMillis() - this.hyx;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.hyt.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.hyx = 0L;
            this.hyy = System.currentTimeMillis();
            this.hys.add(new com.baidu.tieba.m.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void xr(int i) {
        if (this.mCurrentState == 5) {
            bPN();
        } else if (this.mCurrentState == 3) {
            this.hyq = i;
            this.hys.add(new com.baidu.tieba.m.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void bPI() {
        if (this.hyy != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.hyz += currentTimeMillis - this.hyy;
            this.hyy = currentTimeMillis;
        }
        this.hyA++;
        this.hyC = System.currentTimeMillis();
        this.hys.add(new com.baidu.tieba.m.a(201));
    }

    @Override // com.baidu.tieba.j.i
    public void bPJ() {
        this.hyy = System.currentTimeMillis();
        if (this.hyC != 0) {
            this.hyB += System.currentTimeMillis() - this.hyC;
        }
        this.hys.add(new com.baidu.tieba.m.a(202));
    }

    @Override // com.baidu.tieba.j.i
    public void bPK() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.hyy != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.hyz += currentTimeMillis - this.hyy;
                this.hyy = currentTimeMillis;
            }
            this.hys.add(new com.baidu.tieba.m.a(203));
            this.mCurrentState = 5;
        }
    }

    public void bPN() {
        if (this.mCurrentState == 5) {
            this.hyy = System.currentTimeMillis();
            this.hys.add(new com.baidu.tieba.m.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void BB(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.sv(str);
            bPP();
            this.hys.add(new com.baidu.tieba.m.a(205));
            this.mCurrentState = 8;
            Gf();
        }
    }

    @Override // com.baidu.tieba.j.i
    public String BC(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hyo;
        }
        this.mSource = VideoPlatformStatic.sv(str);
        bPP();
        this.hyt.put("stallDuration", Long.valueOf(this.hyB));
        this.hys.add(new com.baidu.tieba.m.a(206));
        this.mCurrentState = 6;
        Gf();
        return this.hyo;
    }

    @Override // com.baidu.tieba.j.i
    public boolean BD(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.sv(str);
        bPP();
        this.hys.add(new com.baidu.tieba.m.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Gf();
        return true;
    }

    @Override // com.baidu.tieba.j.i
    public void i(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.hyv == null && com.baidu.adp.lib.util.f.gB()) {
                this.hyv = new com.baidu.tieba.j.a.d(this.hyo);
                a(this.hyv);
            }
            if (this.hyv != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.hyv.a(new com.baidu.tieba.play.c.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.apV())) {
            if (this.hyu == null && com.baidu.adp.lib.util.f.gB()) {
                this.hyu = new com.baidu.tieba.j.a.b(this.hyo);
                a(this.hyu);
            }
            if (this.hyu != null) {
                if (this.hyu.size() == 0) {
                    this.hyJ = i2;
                }
                this.hyu.a(new com.baidu.tieba.play.c.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.j.a.c cVar) {
        if (this.hyw == null) {
            this.hyw = new ArrayList();
        }
        this.hyw.add(cVar);
    }

    @Override // com.baidu.tieba.j.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.hyo;
        }
        this.hyq = i;
        this.hyE = false;
        this.hyF = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.sv(str);
        bPP();
        if (!v.aa(this.hyw)) {
            int size = this.hyw.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.j.a.c cVar = this.hyw.get(i4);
                if (cVar != null) {
                    cVar.bQd();
                }
            }
        }
        this.hys.add(new com.baidu.tieba.m.b(i, i2, i3, j, str2, bPO()));
        this.mCurrentState = -1;
        Gf();
        return this.hyo;
    }

    private com.baidu.tieba.j.a.e[] bPO() {
        if (this.hyw == null || this.hyw.size() == 0) {
            return null;
        }
        com.baidu.tieba.j.a.e[] eVarArr = new com.baidu.tieba.j.a.e[this.hyw.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hyw.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.hyw.get(i2).bQb();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.j.i
    public void BE(String str) {
        this.hyH = str;
    }

    private void bPP() {
        if (this.hyy != 0) {
            this.hyz += System.currentTimeMillis() - this.hyy;
        }
        this.hyt.put("playDuration", Long.valueOf(this.hyz));
        this.hyt.put("stallCount", Long.valueOf(this.hyA));
        this.hyt.put("stallDuration", Long.valueOf(this.hyB));
        if (!this.hyt.containsKey("loadingTime")) {
            this.hyt.put("loadingTime", 0L);
        }
        this.hyx = 0L;
        this.hyy = 0L;
        this.hyz = 0L;
        this.hyA = 0L;
        this.hyB = 0L;
        this.hyC = 0L;
    }

    @Override // com.baidu.tieba.j.i
    public void Gf() {
        if (!this.hyG) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.apQ() || !this.hyE) && reportType != 3) {
                this.hyG = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.j.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aCP());
                            jSONObject.put("kpiInfo", j.this.bPQ());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.hyE)) {
                                JSONObject bPS = j.this.bPS();
                                bPS.put("running", j.this.bPT());
                                jSONObject.put("debugInfo", bPS);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.bPS());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.s.e.cuv().c(jSONObject, j.this.hyE ? false : true);
                        if (j.this.hyI != null) {
                            j.this.hyI.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aCP() {
        JSONObject aCP = VideoPlatformStatic.aCP();
        if (this.hyI != null) {
            try {
                int size = this.hyI.size();
                for (int i = 0; i < size; i++) {
                    this.hyI.get(i).bJ(aCP);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aCP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bPQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.hyt.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.hyt.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.hyt.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.hyt.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.hyt.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.hyD ? 1 : 0);
            jSONObject.put("playSuccess", this.hyE ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", bPR());
            jSONObject.put("retryError", this.hyF ? 1 : 0);
            jSONObject.put("error", this.mError);
            if (this.hyI != null) {
                int size = this.hyI.size();
                for (int i = 0; i < size; i++) {
                    this.hyI.get(i).bK(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject bPR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.hyK);
            jSONObject.put("tid", this.hyL);
            jSONObject.put("preparedTime", this.hyM);
            jSONObject.put("startTime", this.hyN);
            jSONObject.put("totalTime", this.hyO);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.hyP);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.hyQ);
            jSONObject.put("autoPlay", this.hyR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bPU();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bPS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.hyo);
            if (!StringUtils.isNull(this.hyp)) {
                jSONObject.put("parentUuid", this.hyp);
            }
            jSONObject.put("tid", this.bXN);
            jSONObject.put("videoUrl", this.bXa);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.mq(this.hyq));
            jSONObject.put("urlType", this.hyr);
            jSONObject.put("sub_error", this.hyJ);
            jSONObject.put("current_pid", Process.myPid());
            if (!StringUtils.isNull(this.hyH)) {
                jSONObject.put("error_stack", this.hyH);
            }
            if (this.hyI != null) {
                int size = this.hyI.size();
                for (int i = 0; i < size; i++) {
                    this.hyI.get(i).bL(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray bPT() {
        JSONArray jSONArray = new JSONArray();
        if (this.hys == null) {
            return jSONArray;
        }
        int size = this.hys.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hys.get(i).cgp());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.j.i
    public void a(b bVar) {
        if (this.hyI == null) {
            this.hyI = new ArrayList();
        }
        this.hyI.add(bVar);
    }

    @Override // com.baidu.tieba.j.i
    public void nB(boolean z) {
        this.hyE = z;
    }

    @Override // com.baidu.tieba.j.i
    public String bPL() {
        return this.hyo;
    }

    @Override // com.baidu.tieba.j.i
    public String bPM() {
        return this.hyJ + "";
    }

    @Override // com.baidu.tieba.j.i
    public void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i) {
        if (aq.isEmpty(str)) {
            str = NotifyAdapterUtil.PRIMARY_CHANNEL;
        }
        this.hyK = str;
        this.hyM = j;
        this.hyN = j2;
        this.hyO = j3;
        this.hyP = j4;
        this.hyQ = j5;
        this.hyL = str2;
        this.hyR = i;
    }

    private void bPU() {
        this.hyK = NotifyAdapterUtil.PRIMARY_CHANNEL;
        this.hyM = 0L;
        this.hyN = 0L;
        this.hyO = 0L;
        this.hyP = 0L;
        this.hyQ = 0L;
        this.hyL = "";
        this.hyR = 0;
    }
}
