package com.baidu.tieba.l;

import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.VideoPlatformStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i implements h {
    private String amC;
    private int eMT;
    private int ezR;
    private long luC;
    private long luD;
    private long luE;
    private boolean luG;
    private boolean luK;
    private String luL;
    private List<b> luM;
    private int luN;
    private long luO;
    private long luP;
    private long luQ;
    private String luv;
    private int luw;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean luH = true;
    private boolean luI = false;
    private boolean luJ = false;
    private boolean luR = false;
    private boolean luS = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> luy = new HashMap();
    private List<com.baidu.tieba.n.b> lux = new ArrayList();
    private long luz = 0;
    private long luA = 0;
    private long luB = 0;
    private ArrayList<Integer> luF = new ArrayList<>();

    public i(String str, String str2, String str3) {
        this.ezR = 0;
        this.ezR = 0;
        this.amC = str;
        this.mVideoUrl = str2;
        this.luv = str3;
        dgT();
    }

    @Override // com.baidu.tieba.l.h
    public void dgL() {
        this.luz = System.currentTimeMillis();
        this.lux.add(new com.baidu.tieba.n.a(3));
        this.ezR = 0;
    }

    @Override // com.baidu.tieba.l.h
    public void ua(boolean z) {
        this.luG = z;
        this.lux.add(new com.baidu.tieba.n.a(1));
        this.ezR = 1;
    }

    @Override // com.baidu.tieba.l.h
    public void ao(boolean z, boolean z2) {
        this.luR = z;
        this.luS = z2;
    }

    @Override // com.baidu.tieba.l.h
    public void EJ(int i) {
        if (this.ezR != 4 && this.ezR != 5 && this.ezR != 7 && this.ezR != 8) {
            this.luw = i;
            this.luH = true;
            long currentTimeMillis = System.currentTimeMillis() - this.luz;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.luy.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.luz = 0L;
            this.lux.add(new com.baidu.tieba.n.a(102));
            this.ezR = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void EK(int i) {
        if (this.ezR != 4 && this.ezR != 5 && this.ezR != 7 && this.ezR != 8) {
            this.luw = i;
            this.luH = true;
            this.luI = true;
            this.luy.put("loadingTime", 1L);
            this.luz = 0L;
            this.lux.add(new com.baidu.tieba.n.a(103));
            this.ezR = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void EL(int i) {
        if (this.ezR == 5) {
            dgN();
        } else if (this.ezR == 3) {
            this.luw = i;
            this.luA = System.currentTimeMillis();
            this.lux.add(new com.baidu.tieba.n.a(200));
            this.ezR = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void F(long j, int i) {
        this.luC++;
        this.luD += j;
        this.luF.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.h
    public void dgM() {
        if (this.ezR == 4 || this.ezR == 3) {
            if (this.luA != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.luB = (currentTimeMillis - this.luA) + this.luB;
                this.luA = 0L;
            }
            this.lux.add(new com.baidu.tieba.n.a(203));
            this.ezR = 5;
        }
    }

    public void dgN() {
        if (this.ezR == 5) {
            this.luA = System.currentTimeMillis();
            this.lux.add(new com.baidu.tieba.n.a(204));
            this.ezR = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void OE(String str) {
        if (this.ezR != 8 && this.ezR != 7 && this.ezR != 6 && this.ezR != -1) {
            this.mSource = VideoPlatformStatic.Ev(str);
            dgO();
            this.lux.add(new com.baidu.tieba.n.a(205));
            this.ezR = 8;
            auo();
        }
    }

    @Override // com.baidu.tieba.l.h
    public String OF(String str) {
        if (this.ezR == 8 || this.ezR == 7 || this.ezR == 6 || this.ezR == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Ev(str);
        dgO();
        this.luy.put("stallDuration", Long.valueOf(this.luD));
        this.lux.add(new com.baidu.tieba.n.a(206));
        this.ezR = 6;
        auo();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public boolean OG(String str) {
        if (this.ezR == 8 || this.ezR == 7 || this.ezR == 6 || this.ezR == -1 || this.ezR == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Ev(str);
        dgO();
        this.lux.add(new com.baidu.tieba.n.a(207));
        this.ezR = 7;
        auo();
        return true;
    }

    private void dgO() {
        if (this.luA != 0) {
            this.luB += System.currentTimeMillis() - this.luA;
        }
        this.luy.put("playDuration", Long.valueOf(this.luB));
        this.luy.put("stallCount", Long.valueOf(this.luC));
        this.luy.put("stallDuration", Long.valueOf(this.luD));
        if (!this.luy.containsKey("loadingTime")) {
            this.luy.put("loadingTime", 0L);
        }
        this.luz = 0L;
        this.luA = 0L;
        this.luB = 0L;
        this.luC = 0L;
        this.luD = 0L;
        this.luE = 0L;
    }

    public void auo() {
        if (!this.luK) {
            int byW = com.baidu.tbadk.coreExtra.model.g.byW();
            if ((com.baidu.tbadk.coreExtra.model.g.byV() || !this.luH) && byW != 3) {
                this.luK = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.i.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int byW2 = com.baidu.tbadk.coreExtra.model.g.byW();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", i.this.bKL());
                            jSONObject.put("kpiInfo", i.this.dgP());
                            if (byW2 == 0 || (byW2 == 4 && i.this.luH)) {
                                JSONObject dgR = i.this.dgR();
                                dgR.put("running", i.this.dgS());
                                jSONObject.put("debugInfo", dgR);
                            } else if (byW2 == 2) {
                                jSONObject.put("debugInfo", i.this.dgR());
                            } else if (byW2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dRz().i(jSONObject, i.this.luH ? false : true);
                        if (i.this.luM != null) {
                            i.this.luM.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKL() {
        JSONObject bKL = VideoPlatformStatic.bKL();
        if (this.luM != null) {
            try {
                int size = this.luM.size();
                for (int i = 0; i < size; i++) {
                    this.luM.get(i).eC(bKL);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bKL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dgP() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.luy.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.luy.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.luy.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.luy.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.luy.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.luG ? 1 : 0);
            jSONObject.put("playSuccess", this.luH ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", dgQ());
            jSONObject.put("retryError", this.luJ ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.luM != null) {
                int size = this.luM.size();
                for (int i = 0; i < size; i++) {
                    this.luM.get(i).eD(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject dgQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.luO);
            jSONObject.put("startTime", this.luP);
            jSONObject.put("totalTime", this.luQ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dgT();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dgR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.luv)) {
                jSONObject.put("parentUuid", this.luv);
            }
            jSONObject.put("tid", this.amC);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.sU(this.luw));
            jSONObject.put("urlType", this.eMT);
            jSONObject.put("sub_error", this.luN);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.luI ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.luF);
            jSONObject.put("pcdn_used", this.luR ? "1" : "0");
            jSONObject.put("p2p_used", this.luS ? "1" : "0");
            if (!StringUtils.isNull(this.luL)) {
                jSONObject.put("error_stack", this.luL);
            }
            if (this.luM != null) {
                int size = this.luM.size();
                for (int i = 0; i < size; i++) {
                    this.luM.get(i).eE(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray dgS() {
        JSONArray jSONArray = new JSONArray();
        if (this.lux == null) {
            return jSONArray;
        }
        int size = this.lux.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.lux.get(i).dAT());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.h
    public void h(long j, long j2, long j3) {
        this.luO = j;
        this.luP = j2;
        this.luQ = j3;
    }

    private void dgT() {
        this.luO = 0L;
        this.luP = 0L;
        this.luQ = 0L;
    }
}
