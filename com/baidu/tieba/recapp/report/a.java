package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fJd;
    private int fJe;
    private int fJf;
    private long fJg = System.currentTimeMillis() / 1000;
    private String fJh;
    private JSONObject fJi;
    private int fJj;
    private int fJk;
    private int fJl;
    private int fJm;
    private int fJn;
    private int fJo;
    private String fJp;
    private String fJq;
    private String fJr;
    private String fJs;
    private String fJt;
    private String fJu;
    private int pageNumber;
    private String placeId;

    public void rf(String str) {
        this.extInfo = str;
    }

    public void sc(int i) {
        this.fJe = i;
    }

    public void sd(int i) {
        this.fJf = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rg(String str) {
        this.placeId = str;
    }

    public void rh(String str) {
        this.fJh = str;
    }

    public void se(int i) {
        this.fJm = i;
    }

    public void sf(int i) {
        this.fJn = i;
    }

    public void sg(int i) {
        this.fJo = i;
    }

    public void ri(String str) {
        this.fJp = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fJf = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fJh = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bZ(String str, String str2) {
        if (this.fJd == null) {
            this.fJd = new JSONObject();
        }
        try {
            this.fJd.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bhX() {
        if (this.fJi != null) {
            return this.fJi;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fJf);
            jSONObject.put("da_type", this.fJe);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fJg);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fJh);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fJj);
            jSONObject.put("ext3", this.fJl);
            jSONObject.put("ext2", this.fJk);
            jSONObject.put("da_ext1", this.fJm);
            jSONObject.put("da_ext2", this.fJn);
            jSONObject.put("da_ext3", this.fJo);
            jSONObject.put("da_menu1", this.fJq);
            jSONObject.put("da_menu2", this.fJr);
            jSONObject.put("da_menu3", this.fJs);
            jSONObject.put("da_page", this.fJt);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fJp);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fJu);
        } catch (JSONException e) {
        }
        if (this.fJd != null) {
            try {
                jSONObject.put("ext", this.fJd);
            } catch (Exception e2) {
            }
        }
        this.fJi = jSONObject;
        return jSONObject;
    }

    public void rj(String str) {
        this.fJq = str;
    }

    public void rk(String str) {
        this.fJr = str;
    }

    public void rl(String str) {
        this.fJs = str;
    }

    public void rm(String str) {
        this.fJt = str;
    }

    public void rn(String str) {
        this.fJu = str;
    }
}
