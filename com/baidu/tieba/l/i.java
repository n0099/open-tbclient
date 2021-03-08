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
/* loaded from: classes7.dex */
public class i implements h {
    private String anU;
    private int eBs;
    private int eOu;
    private String lwL;
    private int lwM;
    private long lwS;
    private long lwT;
    private long lwU;
    private boolean lwW;
    private boolean lxa;
    private String lxb;
    private List<b> lxc;
    private int lxd;
    private long lxe;
    private long lxf;
    private long lxg;
    private int mError;
    private String mSource;
    private String mVideoUrl;
    private boolean lwX = true;
    private boolean lwY = false;
    private boolean lwZ = false;
    private boolean lxh = false;
    private boolean lxi = false;
    private String mUuid = UUID.randomUUID().toString();
    private Map<String, Long> lwO = new HashMap();
    private List<com.baidu.tieba.n.b> lwN = new ArrayList();
    private long lwP = 0;
    private long lwQ = 0;
    private long lwR = 0;
    private ArrayList<Integer> lwV = new ArrayList<>();

    public i(String str, String str2, String str3) {
        this.eBs = 0;
        this.eBs = 0;
        this.anU = str;
        this.mVideoUrl = str2;
        this.lwL = str3;
        dhj();
    }

    @Override // com.baidu.tieba.l.h
    public void dhb() {
        this.lwP = System.currentTimeMillis();
        this.lwN.add(new com.baidu.tieba.n.a(3));
        this.eBs = 0;
    }

    @Override // com.baidu.tieba.l.h
    public void ua(boolean z) {
        this.lwW = z;
        this.lwN.add(new com.baidu.tieba.n.a(1));
        this.eBs = 1;
    }

    @Override // com.baidu.tieba.l.h
    public void ao(boolean z, boolean z2) {
        this.lxh = z;
        this.lxi = z2;
    }

    @Override // com.baidu.tieba.l.h
    public void EM(int i) {
        if (this.eBs != 4 && this.eBs != 5 && this.eBs != 7 && this.eBs != 8) {
            this.lwM = i;
            this.lwX = true;
            long currentTimeMillis = System.currentTimeMillis() - this.lwP;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.lwO.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.lwP = 0L;
            this.lwN.add(new com.baidu.tieba.n.a(102));
            this.eBs = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void EN(int i) {
        if (this.eBs != 4 && this.eBs != 5 && this.eBs != 7 && this.eBs != 8) {
            this.lwM = i;
            this.lwX = true;
            this.lwY = true;
            this.lwO.put("loadingTime", 1L);
            this.lwP = 0L;
            this.lwN.add(new com.baidu.tieba.n.a(103));
            this.eBs = 3;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void EO(int i) {
        if (this.eBs == 5) {
            dhd();
        } else if (this.eBs == 3) {
            this.lwM = i;
            this.lwQ = System.currentTimeMillis();
            this.lwN.add(new com.baidu.tieba.n.a(200));
            this.eBs = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void F(long j, int i) {
        this.lwS++;
        this.lwT += j;
        this.lwV.add(Integer.valueOf(i));
    }

    @Override // com.baidu.tieba.l.h
    public void dhc() {
        if (this.eBs == 4 || this.eBs == 3) {
            if (this.lwQ != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.lwR = (currentTimeMillis - this.lwQ) + this.lwR;
                this.lwQ = 0L;
            }
            this.lwN.add(new com.baidu.tieba.n.a(203));
            this.eBs = 5;
        }
    }

    public void dhd() {
        if (this.eBs == 5) {
            this.lwQ = System.currentTimeMillis();
            this.lwN.add(new com.baidu.tieba.n.a(204));
            this.eBs = 4;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void OL(String str) {
        if (this.eBs != 8 && this.eBs != 7 && this.eBs != 6 && this.eBs != -1) {
            this.mSource = VideoPlatformStatic.EA(str);
            dhe();
            this.lwN.add(new com.baidu.tieba.n.a(205));
            this.eBs = 8;
            aur();
        }
    }

    @Override // com.baidu.tieba.l.h
    public String OM(String str) {
        if (this.eBs == 8 || this.eBs == 7 || this.eBs == 6 || this.eBs == -1) {
            return this.mUuid;
        }
        this.mSource = VideoPlatformStatic.EA(str);
        dhe();
        this.lwO.put("stallDuration", Long.valueOf(this.lwT));
        this.lwN.add(new com.baidu.tieba.n.a(206));
        this.eBs = 6;
        aur();
        return this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public boolean ON(String str) {
        if (this.eBs == 8 || this.eBs == 7 || this.eBs == 6 || this.eBs == -1 || this.eBs == 1) {
            return false;
        }
        this.mSource = VideoPlatformStatic.EA(str);
        dhe();
        this.lwN.add(new com.baidu.tieba.n.a(207));
        this.eBs = 7;
        aur();
        return true;
    }

    private void dhe() {
        if (this.lwQ != 0) {
            this.lwR += System.currentTimeMillis() - this.lwQ;
        }
        this.lwO.put("playDuration", Long.valueOf(this.lwR));
        this.lwO.put("stallCount", Long.valueOf(this.lwS));
        this.lwO.put("stallDuration", Long.valueOf(this.lwT));
        if (!this.lwO.containsKey("loadingTime")) {
            this.lwO.put("loadingTime", 0L);
        }
        this.lwP = 0L;
        this.lwQ = 0L;
        this.lwR = 0L;
        this.lwS = 0L;
        this.lwT = 0L;
        this.lwU = 0L;
    }

    public void aur() {
        if (!this.lxa) {
            int byZ = com.baidu.tbadk.coreExtra.model.g.byZ();
            if ((com.baidu.tbadk.coreExtra.model.g.byY() || !this.lwX) && byZ != 3) {
                this.lxa = true;
                new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.l.i.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        int byZ2 = com.baidu.tbadk.coreExtra.model.g.byZ();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("baseInfo", i.this.bKU());
                            jSONObject.put("kpiInfo", i.this.dhf());
                            if (byZ2 == 0 || (byZ2 == 4 && i.this.lwX)) {
                                JSONObject dhh = i.this.dhh();
                                dhh.put("running", i.this.dhi());
                                jSONObject.put("debugInfo", dhh);
                            } else if (byZ2 == 2) {
                                jSONObject.put("debugInfo", i.this.dhh());
                            } else if (byZ2 == 1) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.tieba.u.e.dRP().g(jSONObject, i.this.lwX ? false : true);
                        if (i.this.lxc != null) {
                            i.this.lxc.clear();
                            return null;
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKU() {
        JSONObject bKU = VideoPlatformStatic.bKU();
        if (this.lxc != null) {
            try {
                int size = this.lxc.size();
                for (int i = 0; i < size; i++) {
                    this.lxc.get(i).eE(bKU);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bKU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dhf() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.lwO.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.lwO.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.lwO.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.lwO.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.lwO.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.lwW ? 1 : 0);
            jSONObject.put("playSuccess", this.lwX ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", dhg());
            jSONObject.put("retryError", this.lwZ ? 1 : 0);
            jSONObject.put(BdStatsConstant.StatsType.ERROR, this.mError);
            if (this.lxc != null) {
                int size = this.lxc.size();
                for (int i = 0; i < size; i++) {
                    this.lxc.get(i).eF(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject dhg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.lxe);
            jSONObject.put("startTime", this.lxf);
            jSONObject.put("totalTime", this.lxg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dhj();
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject dhh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.mUuid);
            if (!StringUtils.isNull(this.lwL)) {
                jSONObject.put("parentUuid", this.lwL);
            }
            jSONObject.put("tid", this.anU);
            jSONObject.put("videoUrl", this.mVideoUrl);
            jSONObject.put("source", this.mSource);
            jSONObject.put("playerType", VideoPlatformStatic.sW(this.lwM));
            jSONObject.put("urlType", this.eOu);
            jSONObject.put("sub_error", this.lxd);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.lwY ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.lwV);
            jSONObject.put("pcdn_used", this.lxh ? "1" : "0");
            jSONObject.put("p2p_used", this.lxi ? "1" : "0");
            if (!StringUtils.isNull(this.lxb)) {
                jSONObject.put("error_stack", this.lxb);
            }
            if (this.lxc != null) {
                int size = this.lxc.size();
                for (int i = 0; i < size; i++) {
                    this.lxc.get(i).eG(jSONObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray dhi() {
        JSONArray jSONArray = new JSONArray();
        if (this.lwN == null) {
            return jSONArray;
        }
        int size = this.lwN.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.lwN.get(i).dBi());
        }
        return jSONArray;
    }

    @Override // com.baidu.tieba.l.h
    public void i(long j, long j2, long j3) {
        this.lxe = j;
        this.lxf = j2;
        this.lxg = j3;
    }

    private void dhj() {
        this.lxe = 0L;
        this.lxf = 0L;
        this.lxg = 0L;
    }
}
