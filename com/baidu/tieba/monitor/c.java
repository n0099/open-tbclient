package com.baidu.tieba.monitor;

import android.location.Address;
import android.os.Build;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.d;
import com.baidu.tbadk.coreExtra.c.f;
import com.coremedia.iso.boxes.UserBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.play.b.a {
    private String aMi;
    private String aXu;
    private boolean exA;
    private String exB;
    private String exk;
    private int exl;
    private int exm;
    private List<com.baidu.tieba.play.c.c> exp;
    private long exu;
    private long exv;
    private long exw;
    private boolean exx;
    private int mCurrentState;
    private int mError;
    private String mSource;
    private boolean exy = true;
    private boolean exz = false;
    private String exj = UUID.randomUUID().toString();
    private Map<String, Long> exo = new HashMap();
    private List<com.baidu.tieba.monitor.a.c> exn = new ArrayList();
    private long exq = 0;
    private long exr = 0;
    private long exs = 0;

    public c(String str, String str2, String str3) {
        this.mCurrentState = 0;
        this.mCurrentState = 0;
        this.aMi = str;
        this.aXu = str2;
        this.exk = str3;
    }

    @Override // com.baidu.tieba.play.b.a
    public void aMT() {
        this.exq = System.currentTimeMillis();
        this.exn.add(new com.baidu.tieba.monitor.a.a(3));
        this.mCurrentState = 0;
    }

    @Override // com.baidu.tieba.play.b.a
    public void oE(String str) {
        if (!StringUtils.isNull(str)) {
            this.exm = VideoMonitorStatic.oJ(str);
            if (this.exm != 0) {
                this.exx = true;
            }
        }
        this.exn.add(new com.baidu.tieba.monitor.a.a(1));
        this.mCurrentState = 1;
    }

    @Override // com.baidu.tieba.play.b.a
    public void aMU() {
        this.exn.add(new com.baidu.tieba.monitor.a.a(2));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.play.b.a
    public void aMV() {
        if (this.mCurrentState != 2) {
            this.exq = System.currentTimeMillis();
            this.exn.add(new com.baidu.tieba.monitor.a.a(101));
            this.mCurrentState = 2;
        }
    }

    @Override // com.baidu.tieba.play.b.a
    public void aMW() {
        this.exq = System.currentTimeMillis();
        this.exn.add(new com.baidu.tieba.monitor.a.a(4));
        this.mCurrentState = 2;
    }

    @Override // com.baidu.tieba.play.b.a
    public void aMX() {
        if (this.mCurrentState != 4 && this.mCurrentState != 5 && this.mCurrentState != 7 && this.mCurrentState != 8) {
            long currentTimeMillis = System.currentTimeMillis() - this.exq;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.exo.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.exq = 0L;
            this.exr = System.currentTimeMillis();
            this.exn.add(new com.baidu.tieba.monitor.a.a(SapiSafeFacade.SAPIWEBVIEW_BACK));
            this.mCurrentState = 3;
        }
    }

    @Override // com.baidu.tieba.play.b.a
    public void pa(int i) {
        if (this.mCurrentState == 5) {
            aNb();
        } else if (this.mCurrentState == 3) {
            this.exl = i;
            this.exn.add(new com.baidu.tieba.monitor.a.a(200));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.play.b.a
    public void aMY() {
        if (this.exr != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.exs += currentTimeMillis - this.exr;
            this.exr = currentTimeMillis;
        }
        this.exu++;
        this.exw = System.currentTimeMillis();
        this.exn.add(new com.baidu.tieba.monitor.a.a(201));
    }

    @Override // com.baidu.tieba.play.b.a
    public void aMZ() {
        this.exr = System.currentTimeMillis();
        if (this.exw != 0) {
            this.exv += System.currentTimeMillis() - this.exw;
        }
        this.exn.add(new com.baidu.tieba.monitor.a.a(202));
    }

    @Override // com.baidu.tieba.play.b.a
    public void aNa() {
        if (this.mCurrentState == 4 || this.mCurrentState == 3) {
            if (this.exr != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.exs += currentTimeMillis - this.exr;
                this.exr = currentTimeMillis;
            }
            this.exn.add(new com.baidu.tieba.monitor.a.a(203));
            this.mCurrentState = 5;
        }
    }

    public void aNb() {
        if (this.mCurrentState == 5) {
            this.exr = System.currentTimeMillis();
            this.exn.add(new com.baidu.tieba.monitor.a.a(204));
            this.mCurrentState = 4;
        }
    }

    @Override // com.baidu.tieba.play.b.a
    public void oF(String str) {
        if (this.mCurrentState != 8 && this.mCurrentState != 7 && this.mCurrentState != 6 && this.mCurrentState != -1) {
            this.exy = true;
            this.mSource = VideoMonitorStatic.oK(str);
            aNc();
            this.exn.add(new com.baidu.tieba.monitor.a.a(205));
            this.mCurrentState = 8;
            aNd();
        }
    }

    @Override // com.baidu.tieba.play.b.a
    public String oG(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.exj;
        }
        this.exy = true;
        this.mSource = VideoMonitorStatic.oK(str);
        aNc();
        this.exo.put("stallDuration", Long.valueOf(this.exv));
        this.exn.add(new com.baidu.tieba.monitor.a.a(206));
        this.mCurrentState = 6;
        aNd();
        return this.exj;
    }

    @Override // com.baidu.tieba.play.b.a
    public boolean oH(String str) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1 || this.mCurrentState == 1) {
            return false;
        }
        this.exy = true;
        this.mSource = VideoMonitorStatic.oK(str);
        aNc();
        this.exn.add(new com.baidu.tieba.monitor.a.a(207));
        this.mCurrentState = 7;
        aNd();
        return true;
    }

    @Override // com.baidu.tieba.play.b.a
    public void bt(int i, int i2) {
        if (this.exp == null) {
            this.exp = new ArrayList();
        }
        this.exp.add(new com.baidu.tieba.play.c.c(SapiErrorCode.NETWORK_FAILED, i, i2));
    }

    @Override // com.baidu.tieba.play.b.a
    public String a(int i, int i2, int i3, String str, boolean z) {
        if (this.mCurrentState == 8 || this.mCurrentState == 7 || this.mCurrentState == 6 || this.mCurrentState == -1) {
            return this.exj;
        }
        this.exy = false;
        this.exz = z;
        this.mError = i3;
        this.mSource = VideoMonitorStatic.oK(str);
        aNc();
        this.exn.add(new com.baidu.tieba.monitor.a.b(i, i2, i3, this.exp));
        if (this.exp != null) {
            this.exp.clear();
        }
        this.mCurrentState = -1;
        aNd();
        return this.exj;
    }

    @Override // com.baidu.tieba.play.b.a
    public void oI(String str) {
        this.exB = str;
    }

    private void aNc() {
        if (this.exr != 0) {
            this.exs += System.currentTimeMillis() - this.exr;
        }
        this.exo.put("playDuration", Long.valueOf(this.exs));
        this.exo.put("stallCount", Long.valueOf(this.exu));
        this.exo.put("stallDuration", Long.valueOf(this.exv));
        if (!this.exo.containsKey("loadingTime")) {
            this.exo.put("loadingTime", 0L);
        }
        this.exq = 0L;
        this.exr = 0L;
        this.exs = 0L;
        this.exu = 0L;
        this.exv = 0L;
        this.exw = 0L;
    }

    @Override // com.baidu.tieba.play.b.a
    public void aNd() {
        if (!this.exA) {
            int reportType = f.getReportType();
            if ((f.Aq() || !this.exy) && reportType != 3) {
                this.exA = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("baseInfo", aNe());
                    jSONObject.put("kpiInfo", aNf());
                    if (reportType == 0 || (reportType == 4 && this.exy)) {
                        JSONObject aNg = aNg();
                        aNg.put("running", aNh());
                        jSONObject.put("debugInfo", aNg);
                    } else if (reportType == 2) {
                        jSONObject.put("debugInfo", aNg());
                    } else if (reportType == 1) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.baidu.tieba.monitor.b.b.aNm().c(jSONObject, this.exy ? false : true);
            }
        }
    }

    private static JSONObject aNe() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appVer", TbConfig.getVersion());
            jSONObject.put("clientIp", d.getIp());
            jSONObject.put("clientTimestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("deviceId", UtilHelper.getDeviceId());
            jSONObject.put("network", VideoMonitorStatic.aNj());
            jSONObject.put("osType", "AND");
            jSONObject.put("osVer", Build.VERSION.RELEASE);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            } else {
                jSONObject.put(SapiAccountManager.SESSION_UID, "");
            }
            StringBuilder sb = new StringBuilder();
            if (com.baidu.adp.lib.d.a.fc().D(false) != null) {
                Address D = com.baidu.adp.lib.d.a.fc().D(false);
                if (!StringUtils.isNull(D.getAdminArea())) {
                    sb.append(D.getAdminArea());
                }
                if (!StringUtils.isNull(D.getSubAdminArea())) {
                    sb.append(D.getSubAdminArea());
                }
                if (!StringUtils.isNull(D.getSubLocality())) {
                    sb.append(D.getSubLocality());
                }
            }
            jSONObject.put("location", sb.toString());
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject aNf() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.exo.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.exo.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.exo.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.exo.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.exo.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            jSONObject.put("isCacheHit", this.exx ? 1 : 0);
            jSONObject.put("playSuccess", this.exy ? 1 : 0);
            jSONObject.put("retryError", this.exz ? 1 : 0);
            jSONObject.put("error", this.mError);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject aNg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserBox.TYPE, this.exj);
            if (!StringUtils.isNull(this.exk)) {
                jSONObject.put("parentUuid", this.exk);
            }
            jSONObject.put("tid", this.aMi);
            jSONObject.put("videoUrl", this.aXu);
            jSONObject.put(LegoListActivityConfig.IS_FROM, this.mSource);
            jSONObject.put("playerType", VideoMonitorStatic.pb(this.exl));
            jSONObject.put("urlType", this.exm);
            if (!StringUtils.isNull(this.exB)) {
                jSONObject.put("error_stack", this.exB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONArray aNh() {
        JSONArray jSONArray = new JSONArray();
        if (this.exn == null) {
            return jSONArray;
        }
        int size = this.exn.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.exn.get(i).aNk());
        }
        return jSONArray;
    }
}
