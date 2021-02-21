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
    private String luJ;
    private int luK;
    private long luQ;
    private long luR;
    private long luS;
    private boolean luU;
    private boolean luY;
    private String luZ;
    private List<b> lva;
    private int lvb;
    private long lvc;
    private long lvd;
    private long lve;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean luV = true;
    private boolean luW = false;
    private boolean luX = false;
    private boolean lvf = false;
    private boolean lvg = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> luM = new HashMap();
    private List<com.baidu.tieba.n.b> luL = new ArrayList();
    private long luN = 0;
    private long luO = 0;
    private long luP = 0;
    private ArrayList<Integer> luT = new ArrayList<>();

    public i(String str, String str2, String str3) {
        this.ezR = 0;
        this.ezR = 0;
        this.amC = str;
        this.mVideoUrl = str2;
        this.luJ = str3;
        dha();
    }

    @Override // com.baidu.tieba.l.h
    public void dgS() {
        this.luN = System.currentTimeMillis();
        this.luL.add(new com.baidu.tieba.n.a(3));
        this.ezR = 0;
    }

    @Override // com.baidu.tieba.l.h
    public void ua(boolean z) {
        this.luU = z;
        this.luL.add(new com.baidu.tieba.n.a(1));
        this.ezR = 1;
    }

    @Override // com.baidu.tieba.l.h
    public void ao(boolean z, boolean z2) {
        this.lvf = z;
        this.lvg = z2;
    }

    @Override // com.baidu.tieba.l.h
    public void EJ(int i) {
        if (this.ezR != 4 && this.ezR != 5 && this.ezR != 7 && this.ezR != 8) {
            this.luK = i;
            this.luV = true;
            long currentTimeMillis = System.currentTimeMillis() - this.luN;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.luM.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.luN = 0L;
            this.luL.add(new com.baidu.tieba.n.a(102));
            this.ezR = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void EK(int i) {
        if (this.ezR != 4 && this.ezR != 5 && this.ezR != 7 && this.ezR != 8) {
            this.luK = i;
            this.luV = true;
            this.luW = true;
            this.luM.put("loadingTime", 1L);
            this.luN = 0L;
            this.luL.add(new com.baidu.tieba.n.a(103));
            this.ezR = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void EL(int i) {
        if (this.ezR == 5) {
            dgU();
        } else if (this.ezR == 3) {
            this.luK = i;
            this.luO = System.currentTimeMillis();
            this.luL.add(new com.baidu.tieba.n.a(200));
            this.ezR = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void F(long j, int i) {
        this.luQ++;
        this.luR += j;
        this.luT.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.h
    public void dgT() {
        if (this.ezR == 4 || this.ezR == 3) {
            if (this.luO != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.luP = (currentTimeMillis - this.luO) + this.luP;
                this.luO = 0L;
            }
            this.luL.add(new com.baidu.tieba.n.a(203));
            this.ezR = 5;
        }
    }

    public void dgU() {
        if (this.ezR == 5) {
            this.luO = System.currentTimeMillis();
            this.luL.add(new com.baidu.tieba.n.a(204));
            this.ezR = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void OF(String str) {
        if (this.ezR != 8 && this.ezR != 7 && this.ezR != 6 && this.ezR != -1) {
            this.mSource = VideoPlatformStatic.Et(str);
            dgV();
            this.luL.add(new com.baidu.tieba.n.a(205));
            this.ezR = 8;
            auo();
        }
    }

    @Override // com.baidu.tieba.l.h
    public String OG(String str) {
        if (this.ezR == 8 || this.ezR == 7 || this.ezR == 6 || this.ezR == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.Et(str);
        dgV();
        this.luM.put("stallDuration", Long.valueOf(this.luR));
        this.luL.add(new com.baidu.tieba.n.a(206));
        this.ezR = 6;
        auo();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public boolean OH(String str) {
        if (this.ezR == 8 || this.ezR == 7 || this.ezR == 6 || this.ezR == -1 || this.ezR == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.Et(str);
        dgV();
        this.luL.add(new com.baidu.tieba.n.a(207));
        this.ezR = 7;
        auo();
        return true;
    }

    private void dgV() {
        if (this.luO != 0) {
            this.luP += System.currentTimeMillis() - this.luO;
        }
        this.luM.put("playDuration", Long.valueOf(this.luP));
        this.luM.put("stallCount", Long.valueOf(this.luQ));
        this.luM.put("stallDuration", Long.valueOf(this.luR));
        if (!this.luM.containsKey("loadingTime")) {
            this.luM.put("loadingTime", 0L);
        }
        this.luN = 0L;
        this.luO = 0L;
        this.luP = 0L;
        this.luQ = 0L;
        this.luR = 0L;
        this.luS = 0L;
    }

    public void auo() {
        if (!this.luY) {
            int byW = com.baidu.tbadk.coreExtra.model.g.byW();
            if ((com.baidu.tbadk.coreExtra.model.g.byV() || !this.luV) && byW != 3) {
                this.luY = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.i.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int byW2 = com.baidu.tbadk.coreExtra.model.g.byW();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", i.this.bKQ());
                            jSONObject.put("kpiInfo", i.this.dgW());
                            if (byW2 == 0 || (byW2 == 4 && i.this.luV)) {
                                JSONObject dgY = i.this.dgY();
                                dgY.put("running", i.this.dgZ());
                                jSONObject.put("debugInfo", dgY);
                            } else if (byW2 == 2) {
                                jSONObject.put("debugInfo", i.this.dgY());
                            } else if (byW2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dRH().i(jSONObject, i.this.luV ? false : true);
                        if (i.this.lva != null) {
                            i.this.lva.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKQ() {
        JSONObject bKQ = VideoPlatformStatic.bKQ();
        if (this.lva != null) {
            try {
                int size = this.lva.size();
                for (int i = 0; i < size; i++) {
                    this.lva.get(i).eC(bKQ);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bKQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dgW() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.luM.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.luM.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.luM.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.luM.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.luM.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.luU ? 1 : 0);
            jSONObject.put("playSuccess", this.luV ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", dgX());
            jSONObject.put("retryError", this.luX ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.lva != null) {
                int size = this.lva.size();
                for (int i = 0; i < size; i++) {
                    this.lva.get(i).eD(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject dgX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.lvc);
            jSONObject.put("startTime", this.lvd);
            jSONObject.put("totalTime", this.lve);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dha();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dgY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.luJ)) {
                jSONObject.put("parentUuid", this.luJ);
            }
            jSONObject.put("tid", this.amC);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.sU(this.luK));
            jSONObject.put("urlType", this.eMT);
            jSONObject.put("sub_error", this.lvb);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.luW ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.luT);
            jSONObject.put("pcdn_used", this.lvf ? "1" : "0");
            jSONObject.put("p2p_used", this.lvg ? "1" : "0");
            if (!StringUtils.isNull(this.luZ)) {
                jSONObject.put("error_stack", this.luZ);
            }
            if (this.lva != null) {
                int size = this.lva.size();
                for (int i = 0; i < size; i++) {
                    this.lva.get(i).eE(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray dgZ() {
        JSONArray jSONArray = new JSONArray();
        if (this.luL == null) {
            return jSONArray;
        }
        int size = this.luL.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.luL.get(i).dBa());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.h
    public void h(long j, long j2, long j3) {
        this.lvc = j;
        this.lvd = j2;
        this.lve = j3;
    }

    private void dha() {
        this.lvc = 0L;
        this.lvd = 0L;
        this.lve = 0L;
    }
}
