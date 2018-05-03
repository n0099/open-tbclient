package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cej;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gbX;
    private int gbY;
    private int gbZ;
    private long gca = System.currentTimeMillis() / 1000;
    private String gcb;
    private int gcc;
    private int gcd;
    private int gce;
    private int gcf;
    private int gcg;
    private int gch;
    private int gci;
    private String gcj;
    private String gck;
    private String gcl;
    private String gcm;
    private String gcn;
    private String gco;
    private int pageNumber;
    private String placeId;

    public void sd(String str) {
        this.extInfo = str;
    }

    public void rS(int i) {
        this.gbY = i;
        if (this.cej != null) {
            try {
                this.cej.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void rT(int i) {
        this.gbZ = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void se(String str) {
        this.placeId = str;
    }

    public void sf(String str) {
        this.gcb = str;
    }

    public void rU(int i) {
        this.gcf = i;
    }

    public void rV(int i) {
        this.gcg = i;
    }

    public void rW(int i) {
        this.gch = i;
    }

    public void rX(int i) {
        this.gci = i;
    }

    public void sg(String str) {
        this.gcj = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gbZ = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gcb = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bR(String str, String str2) {
        if (this.gbX == null) {
            this.gbX = new JSONObject();
        }
        try {
            this.gbX.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bkd() {
        if (this.cej != null) {
            return this.cej;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gbZ);
            jSONObject.put("da_type", this.gbY);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gca);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gcb);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gcc);
            jSONObject.put("ext3", this.gce);
            jSONObject.put("ext2", this.gcd);
            jSONObject.put("da_ext1", this.gcf);
            jSONObject.put("da_ext2", this.gcg);
            jSONObject.put("da_ext3", this.gch);
            jSONObject.put("da_ext4", this.gci);
            jSONObject.put("da_menu1", this.gck);
            jSONObject.put("da_menu2", this.gcl);
            jSONObject.put("da_menu3", this.gcm);
            jSONObject.put("da_page", this.gcn);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gcj);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gco);
        } catch (JSONException e) {
        }
        if (this.gbX != null) {
            try {
                jSONObject.put("ext", this.gbX);
            } catch (Exception e2) {
            }
        }
        this.cej = jSONObject;
        return jSONObject;
    }

    public void sh(String str) {
        this.gck = str;
    }

    public void si(String str) {
        this.gcl = str;
    }

    public void sj(String str) {
        this.gcm = str;
    }

    public void sk(String str) {
        this.gcn = str;
    }

    public void sl(String str) {
        this.gco = str;
    }
}
