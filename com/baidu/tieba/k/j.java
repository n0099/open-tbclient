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
    private String Pk;
    private String irG;
    private int irH;
    private int irI;
    private com.baidu.tieba.k.a.b irL;
    private com.baidu.tieba.k.a.d irM;
    private List<com.baidu.tieba.k.a.c> irN;
    private long irR;
    private long irS;
    private long irT;
    private boolean irU;
    private boolean irY;
    private String irZ;
    private List<b> isa;
    private int isb;
    private long isc;
    private long isd;
    private long ise;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean irV = true;
    private boolean irW = false;
    private boolean irX = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> irK = new HashMap();
    private List<com.baidu.tieba.n.c> irJ = new ArrayList();
    private long irO = 0;
    private long irP = 0;
    private long irQ = 0;

    public j(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.Pk = str;
        this.mVideoUrl = str2;
        this.irG = str3;
        cho();
    }

    @Override // com.baidu.tieba.k.i
    public void cgZ() {
        this.irO = System.currentTimeMillis();
        this.irJ.add(new com.baidu.tieba.n.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.k.i
    public void Fd(String str) {
        Fi(str);
        this.irJ.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.k.i
    public void oW(boolean z) {
        this.irU = z;
        this.irJ.add(new com.baidu.tieba.n.a(1));
        this.mCurrentState = 1;
    }

    private void Fi(String str) {
        if (!StringUtils.isNull(str)) {
            this.irI = VideoPlatformStatic.wM(str);
            if (this.irI != 0) {
                this.irU = true;
            }
        }
    }

    @Override // com.baidu.tieba.k.i
    public void cha() {
        this.irJ.add(new com.baidu.tieba.n.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void chb() {
        if (this.mCurrentState != 2) {
            this.irO = System.currentTimeMillis();
            this.irJ.add(new com.baidu.tieba.n.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void a(int i, String str, int i2, int i3, int i4, String str2, int i5) {
        this.irO = System.currentTimeMillis();
        Fi(str);
        this.irJ.add(new com.baidu.tieba.n.e(4, i, i2, i3, i4, str2, i5));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.k.i
    public void yp(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.irH = i;
            this.irV = true;
            long currentTimeMillis = System.currentTimeMillis() - this.irO;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.irK.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.irO = 0L;
            this.irJ.add(new com.baidu.tieba.n.a(102));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yq(int i) {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            this.irH = i;
            this.irV = true;
            this.irW = true;
            this.irK.put("loadingTime", 1L);
            this.irO = 0L;
            this.irJ.add(new com.baidu.tieba.n.a(103));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void yr(int i) {
        if (this.mCurrentState == 5) {
            chh();
        } else if (this.mCurrentState == 3) {
            this.irH = i;
            this.irP = System.currentTimeMillis();
            this.irJ.add(new com.baidu.tieba.n.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void chc() {
        if (this.irP != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.irQ += currentTimeMillis - this.irP;
            this.irP = currentTimeMillis;
        }
        this.irR++;
        this.irT = System.currentTimeMillis();
        this.irJ.add(new com.baidu.tieba.n.a(201));
    }

    @Override // com.baidu.tieba.k.i
    public void chd() {
        this.irP = System.currentTimeMillis();
        if (this.irT != 0) {
            this.irS += System.currentTimeMillis() - this.irT;
        }
        this.irJ.add(new com.baidu.tieba.n.a(202));
    }

    @Override // com.baidu.tieba.k.i
    public void che() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.irP != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.irQ = (currentTimeMillis - this.irP) + this.irQ;
                this.irP = 0L;
            }
            this.irJ.add(new com.baidu.tieba.n.a(203));
            this.mCurrentState = 5;
        }
    }

    public void chh() {
        if (this.mCurrentState == 5) {
            this.irP = System.currentTimeMillis();
            this.irJ.add(new com.baidu.tieba.n.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fe(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.mSource = VideoPlatformStatic.wN(str);
            chj();
            this.irJ.add(new com.baidu.tieba.n.a(205));
            this.mCurrentState = 8;
            Wp();
        }
    }

    @Override // com.baidu.tieba.k.i
    public String Ff(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.wN(str);
        chj();
        this.irK.put("stallDuration", Long.valueOf(this.irS));
        this.irJ.add(new com.baidu.tieba.n.a(206));
        this.mCurrentState = 6;
        Wp();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public boolean Fg(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.wN(str);
        chj();
        this.irJ.add(new com.baidu.tieba.n.a(HttpStatus.SC_MULTI_STATUS));
        this.mCurrentState = 7;
        Wp();
        return true;
    }

    @Override // com.baidu.tieba.k.i
    public void m(int i, int i2, String str) {
        if (i == -10000 || i == -24399 || i == -34399 || i == -300) {
            if (this.irM == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.irM = new com.baidu.tieba.k.a.d(this.mUuid);
                a(this.irM);
            }
            if (this.irM != null) {
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                this.irM.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        } else if ("1".equals(com.baidu.tbadk.coreExtra.model.f.aMh())) {
            if (this.irL == null && com.baidu.adp.lib.util.f.checkSD()) {
                this.irL = new com.baidu.tieba.k.a.b(this.mUuid);
                a(this.irL);
            }
            if (this.irL != null) {
                if (this.irL.size() == 0) {
                    this.isb = i2;
                }
                this.irL.a(new com.baidu.tieba.play.b.d(-200, i, i2, str));
            }
        }
    }

    private void a(com.baidu.tieba.k.a.c cVar) {
        if (this.irN == null) {
            this.irN = new ArrayList();
        }
        this.irN.add(cVar);
    }

    @Override // com.baidu.tieba.k.i
    public String a(int i, int i2, int i3, String str, boolean z, long j, String str2) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.mUuid;
        }
        this.irH = i;
        this.irV = false;
        this.irX = z;
        this.mError = i3;
        this.mSource = VideoPlatformStatic.wN(str);
        chj();
        if (!v.isEmpty(this.irN)) {
            int size = this.irN.size();
            for (int i4 = 0; i4 < size; i4++) {
                com.baidu.tieba.k.a.c cVar = this.irN.get(i4);
                if (cVar != null) {
                    cVar.chy();
                }
            }
        }
        this.irJ.add(new com.baidu.tieba.n.b(i, i2, i3, j, str2, chi()));
        this.mCurrentState = -1;
        Wp();
        return this.mUuid;
    }

    private com.baidu.tieba.k.a.e[] chi() {
        if (this.irN == null || this.irN.size() == 0) {
            return null;
        }
        com.baidu.tieba.k.a.e[] eVarArr = new com.baidu.tieba.k.a.e[this.irN.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.irN.size()) {
                return eVarArr;
            }
            eVarArr[i2] = this.irN.get(i2).chw();
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.k.i
    public void Fh(String str) {
        this.irZ = str;
    }

    private void chj() {
        if (this.irP != 0) {
            this.irQ += System.currentTimeMillis() - this.irP;
        }
        this.irK.put("playDuration", Long.valueOf(this.irQ));
        this.irK.put("stallCount", Long.valueOf(this.irR));
        this.irK.put("stallDuration", Long.valueOf(this.irS));
        if (!this.irK.containsKey("loadingTime")) {
            this.irK.put("loadingTime", 0L);
        }
        this.irO = 0L;
        this.irP = 0L;
        this.irQ = 0L;
        this.irR = 0L;
        this.irS = 0L;
        this.irT = 0L;
    }

    public void Wp() {
        if (!this.irY) {
            int reportType = com.baidu.tbadk.coreExtra.model.f.getReportType();
            if ((com.baidu.tbadk.coreExtra.model.f.aMc() || !this.irV) && reportType != 3) {
                this.irY = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.k.j.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int reportType2 = com.baidu.tbadk.coreExtra.model.f.getReportType();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", j.this.aXG());
                            jSONObject.put("kpiInfo", j.this.chk());
                            if (reportType2 == 0 || (reportType2 == 4 && j.this.irV)) {
                                JSONObject chm = j.this.chm();
                                chm.put("running", j.this.chn());
                                jSONObject.put("debugInfo", chm);
                            } else if (reportType2 == 2) {
                                jSONObject.put("debugInfo", j.this.chm());
                            } else if (reportType2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.cPj().e(jSONObject, j.this.irV ? false : true);
                        if (j.this.isa != null) {
                            j.this.isa.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aXG() {
        JSONObject aXG = VideoPlatformStatic.aXG();
        if (this.isa != null) {
            try {
                int size = this.isa.size();
                for (int i = 0; i < size; i++) {
                    this.isa.get(i).cZ(aXG);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aXG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject chk() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.irK.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.irK.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.irK.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.irK.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.irK.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.irU ? 1 : 0);
            jSONObject.put("playSuccess", this.irV ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", chl());
            jSONObject.put("retryError", this.irX ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.isa != null) {
                int size = this.isa.size();
                for (int i = 0; i < size; i++) {
                    this.isa.get(i).da(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject chl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.isc);
            jSONObject.put("startTime", this.isd);
            jSONObject.put("totalTime", this.ise);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cho();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject chm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.irG)) {
                jSONObject.put("parentUuid", this.irG);
            }
            jSONObject.put("tid", this.Pk);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.ob(this.irH));
            jSONObject.put("urlType", this.irI);
            jSONObject.put("sub_error", this.isb);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.irW ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            if (!StringUtils.isNull(this.irZ)) {
                jSONObject.put("error_stack", this.irZ);
            }
            if (this.isa != null) {
                int size = this.isa.size();
                for (int i = 0; i < size; i++) {
                    this.isa.get(i).db(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray chn() {
        JSONArray jSONArray = new JSONArray();
        if (this.irJ == null) {
            return jSONArray;
        }
        int size = this.irJ.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.irJ.get(i).cAj());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.k.i
    public void a(b bVar) {
        if (this.isa == null) {
            this.isa = new ArrayList();
        }
        this.isa.add(bVar);
    }

    @Override // com.baidu.tieba.k.i
    public void oX(boolean z) {
        this.irV = z;
    }

    @Override // com.baidu.tieba.k.i
    public String chf() {
        return this.mUuid;
    }

    @Override // com.baidu.tieba.k.i
    public String chg() {
        return this.isb + "";
    }

    @Override // com.baidu.tieba.k.i
    public void e(long j, long j2, long j3) {
        this.isc = j;
        this.isd = j2;
        this.ise = j3;
    }

    private void cho() {
        this.isc = 0L;
        this.isd = 0L;
        this.ise = 0L;
    }
}
