package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cem;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gca;
    private int gcb;
    private int gcc;
    private long gcd = System.currentTimeMillis() / 1000;
    private String gce;
    private int gcf;
    private int gcg;
    private int gch;
    private int gci;
    private int gcj;
    private int gck;
    private int gcl;
    private String gcm;
    private String gcn;
    private String gco;
    private String gcp;
    private String gcq;
    private String gcr;
    private int pageNumber;
    private String placeId;

    public void sd(String str) {
        this.extInfo = str;
    }

    public void rS(int i) {
        this.gcb = i;
        if (this.cem != null) {
            try {
                this.cem.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void rT(int i) {
        this.gcc = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void se(String str) {
        this.placeId = str;
    }

    public void sf(String str) {
        this.gce = str;
    }

    public void rU(int i) {
        this.gci = i;
    }

    public void rV(int i) {
        this.gcj = i;
    }

    public void rW(int i) {
        this.gck = i;
    }

    public void rX(int i) {
        this.gcl = i;
    }

    public void sg(String str) {
        this.gcm = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gcc = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gce = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bR(String str, String str2) {
        if (this.gca == null) {
            this.gca = new JSONObject();
        }
        try {
            this.gca.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bkd() {
        if (this.cem != null) {
            return this.cem;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gcc);
            jSONObject.put("da_type", this.gcb);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gcd);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gce);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gcf);
            jSONObject.put("ext3", this.gch);
            jSONObject.put("ext2", this.gcg);
            jSONObject.put("da_ext1", this.gci);
            jSONObject.put("da_ext2", this.gcj);
            jSONObject.put("da_ext3", this.gck);
            jSONObject.put("da_ext4", this.gcl);
            jSONObject.put("da_menu1", this.gcn);
            jSONObject.put("da_menu2", this.gco);
            jSONObject.put("da_menu3", this.gcp);
            jSONObject.put("da_page", this.gcq);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gcm);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gcr);
        } catch (JSONException e) {
        }
        if (this.gca != null) {
            try {
                jSONObject.put("ext", this.gca);
            } catch (Exception e2) {
            }
        }
        this.cem = jSONObject;
        return jSONObject;
    }

    public void sh(String str) {
        this.gcn = str;
    }

    public void si(String str) {
        this.gco = str;
    }

    public void sj(String str) {
        this.gcp = str;
    }

    public void sk(String str) {
        this.gcq = str;
    }

    public void sl(String str) {
        this.gcr = str;
    }
}
