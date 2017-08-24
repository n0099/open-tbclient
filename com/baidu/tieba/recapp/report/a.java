package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String fKA;
    private String fKB;
    private JSONObject fKk;
    private int fKl;
    private int fKm;
    private long fKn = System.currentTimeMillis() / 1000;
    private String fKo;
    private JSONObject fKp;
    private int fKq;
    private int fKr;
    private int fKs;
    private int fKt;
    private int fKu;
    private int fKv;
    private String fKw;
    private String fKx;
    private String fKy;
    private String fKz;
    private int pageNumber;
    private String placeId;

    public void rp(String str) {
        this.extInfo = str;
    }

    public void sd(int i) {
        this.fKl = i;
    }

    public void se(int i) {
        this.fKm = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rq(String str) {
        this.placeId = str;
    }

    public void rr(String str) {
        this.fKo = str;
    }

    public void sf(int i) {
        this.fKt = i;
    }

    public void sg(int i) {
        this.fKu = i;
    }

    public void sh(int i) {
        this.fKv = i;
    }

    public void rs(String str) {
        this.fKw = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fKm = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fKo = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ca(String str, String str2) {
        if (this.fKk == null) {
            this.fKk = new JSONObject();
        }
        try {
            this.fKk.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject biN() {
        if (this.fKp != null) {
            return this.fKp;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fKm);
            jSONObject.put("da_type", this.fKl);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fKn);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fKo);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fKq);
            jSONObject.put("ext3", this.fKs);
            jSONObject.put("ext2", this.fKr);
            jSONObject.put("da_ext1", this.fKt);
            jSONObject.put("da_ext2", this.fKu);
            jSONObject.put("da_ext3", this.fKv);
            jSONObject.put("da_menu1", this.fKx);
            jSONObject.put("da_menu2", this.fKy);
            jSONObject.put("da_menu3", this.fKz);
            jSONObject.put("da_page", this.fKA);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fKw);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fKB);
        } catch (JSONException e) {
        }
        if (this.fKk != null) {
            try {
                jSONObject.put("ext", this.fKk);
            } catch (Exception e2) {
            }
        }
        this.fKp = jSONObject;
        return jSONObject;
    }

    public void rt(String str) {
        this.fKx = str;
    }

    public void ru(String str) {
        this.fKy = str;
    }

    public void rv(String str) {
        this.fKz = str;
    }

    public void rw(String str) {
        this.fKA = str;
    }

    public void rx(String str) {
        this.fKB = str;
    }
}
