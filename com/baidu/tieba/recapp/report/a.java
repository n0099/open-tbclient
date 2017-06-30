package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fuc;
    private int fud;
    private int fue;
    private long fuf = System.currentTimeMillis() / 1000;
    private String fug;
    private JSONObject fuh;
    private int fui;
    private int fuj;
    private int fuk;
    private int ful;
    private int fum;
    private int fun;
    private String fuo;
    private String fup;
    private String fuq;
    private String fur;
    private String fus;
    private String fut;
    private int pageNumber;
    private String placeId;

    public void qE(String str) {
        this.extInfo = str;
    }

    public void rC(int i) {
        this.fud = i;
    }

    public void rD(int i) {
        this.fue = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void qF(String str) {
        this.placeId = str;
    }

    public void qG(String str) {
        this.fug = str;
    }

    public void rE(int i) {
        this.ful = i;
    }

    public void rF(int i) {
        this.fum = i;
    }

    public void rG(int i) {
        this.fun = i;
    }

    public void qH(String str) {
        this.fuo = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fue = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fug = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bX(String str, String str2) {
        if (this.fuc == null) {
            this.fuc = new JSONObject();
        }
        try {
            this.fuc.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject beB() {
        if (this.fuh != null) {
            return this.fuh;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fue);
            jSONObject.put("da_type", this.fud);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fuf);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fug);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fui);
            jSONObject.put("ext3", this.fuk);
            jSONObject.put("ext2", this.fuj);
            jSONObject.put("da_ext1", this.ful);
            jSONObject.put("da_ext2", this.fum);
            jSONObject.put("da_ext3", this.fun);
            jSONObject.put("da_menu1", this.fup);
            jSONObject.put("da_menu2", this.fuq);
            jSONObject.put("da_menu3", this.fur);
            jSONObject.put("da_page", this.fus);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fuo);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fut);
        } catch (JSONException e) {
        }
        if (this.fuc != null) {
            try {
                jSONObject.put("ext", this.fuc);
            } catch (Exception e2) {
            }
        }
        this.fuh = jSONObject;
        return jSONObject;
    }

    public void qI(String str) {
        this.fup = str;
    }

    public void qJ(String str) {
        this.fuq = str;
    }

    public void qK(String str) {
        this.fur = str;
    }

    public void qL(String str) {
        this.fus = str;
    }

    public void qM(String str) {
        this.fut = str;
    }
}
