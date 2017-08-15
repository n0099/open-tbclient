package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fKi;
    private int fKj;
    private int fKk;
    private long fKl = System.currentTimeMillis() / 1000;
    private String fKm;
    private JSONObject fKn;
    private int fKo;
    private int fKp;
    private int fKq;
    private int fKr;
    private int fKs;
    private int fKt;
    private String fKu;
    private String fKv;
    private String fKw;
    private String fKx;
    private String fKy;
    private String fKz;
    private int pageNumber;
    private String placeId;

    public void rk(String str) {
        this.extInfo = str;
    }

    public void sd(int i) {
        this.fKj = i;
    }

    public void se(int i) {
        this.fKk = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rl(String str) {
        this.placeId = str;
    }

    public void rm(String str) {
        this.fKm = str;
    }

    public void sf(int i) {
        this.fKr = i;
    }

    public void sg(int i) {
        this.fKs = i;
    }

    public void sh(int i) {
        this.fKt = i;
    }

    public void rn(String str) {
        this.fKu = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fKk = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fKm = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bZ(String str, String str2) {
        if (this.fKi == null) {
            this.fKi = new JSONObject();
        }
        try {
            this.fKi.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject biS() {
        if (this.fKn != null) {
            return this.fKn;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fKk);
            jSONObject.put("da_type", this.fKj);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fKl);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fKm);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fKo);
            jSONObject.put("ext3", this.fKq);
            jSONObject.put("ext2", this.fKp);
            jSONObject.put("da_ext1", this.fKr);
            jSONObject.put("da_ext2", this.fKs);
            jSONObject.put("da_ext3", this.fKt);
            jSONObject.put("da_menu1", this.fKv);
            jSONObject.put("da_menu2", this.fKw);
            jSONObject.put("da_menu3", this.fKx);
            jSONObject.put("da_page", this.fKy);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fKu);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fKz);
        } catch (JSONException e) {
        }
        if (this.fKi != null) {
            try {
                jSONObject.put("ext", this.fKi);
            } catch (Exception e2) {
            }
        }
        this.fKn = jSONObject;
        return jSONObject;
    }

    public void ro(String str) {
        this.fKv = str;
    }

    public void rp(String str) {
        this.fKw = str;
    }

    public void rq(String str) {
        this.fKx = str;
    }

    public void rr(String str) {
        this.fKy = str;
    }

    public void rs(String str) {
        this.fKz = str;
    }
}
