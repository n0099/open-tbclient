package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fHc;
    private int fHd;
    private int fHe;
    private long fHf = System.currentTimeMillis() / 1000;
    private String fHg;
    private JSONObject fHh;
    private int fHi;
    private int fHj;
    private int fHk;
    private int fHl;
    private int fHm;
    private int fHn;
    private String fHo;
    private String fHp;
    private String fHq;
    private String fHr;
    private String fHs;
    private String fHt;
    private int pageNumber;
    private String placeId;

    public void rd(String str) {
        this.extInfo = str;
    }

    public void rU(int i) {
        this.fHd = i;
    }

    public void rV(int i) {
        this.fHe = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void re(String str) {
        this.placeId = str;
    }

    public void rf(String str) {
        this.fHg = str;
    }

    public void rW(int i) {
        this.fHl = i;
    }

    public void rX(int i) {
        this.fHm = i;
    }

    public void rY(int i) {
        this.fHn = i;
    }

    public void rg(String str) {
        this.fHo = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fHe = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fHg = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bY(String str, String str2) {
        if (this.fHc == null) {
            this.fHc = new JSONObject();
        }
        try {
            this.fHc.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bic() {
        if (this.fHh != null) {
            return this.fHh;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fHe);
            jSONObject.put("da_type", this.fHd);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fHf);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fHg);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fHi);
            jSONObject.put("ext3", this.fHk);
            jSONObject.put("ext2", this.fHj);
            jSONObject.put("da_ext1", this.fHl);
            jSONObject.put("da_ext2", this.fHm);
            jSONObject.put("da_ext3", this.fHn);
            jSONObject.put("da_menu1", this.fHp);
            jSONObject.put("da_menu2", this.fHq);
            jSONObject.put("da_menu3", this.fHr);
            jSONObject.put("da_page", this.fHs);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fHo);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fHt);
        } catch (JSONException e) {
        }
        if (this.fHc != null) {
            try {
                jSONObject.put("ext", this.fHc);
            } catch (Exception e2) {
            }
        }
        this.fHh = jSONObject;
        return jSONObject;
    }

    public void rh(String str) {
        this.fHp = str;
    }

    public void ri(String str) {
        this.fHq = str;
    }

    public void rj(String str) {
        this.fHr = str;
    }

    public void rk(String str) {
        this.fHs = str;
    }

    public void rl(String str) {
        this.fHt = str;
    }
}
