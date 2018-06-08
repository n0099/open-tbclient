package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cnj;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int goA;
    private int goB;
    private int goC;
    private int goD;
    private int goE;
    private int goF;
    private int goG;
    private int goH;
    private String goI;
    private String goJ;
    private String goK;
    private String goL;
    private String goM;
    private String goN;
    private JSONObject gov;
    private int gow;
    private int gox;
    private long goy = System.currentTimeMillis() / 1000;
    private String goz;
    private int pageNumber;
    private String placeId;

    public void sY(String str) {
        this.extInfo = str;
    }

    public void sd(int i) {
        this.gow = i;
        if (this.cnj != null) {
            try {
                this.cnj.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void se(int i) {
        this.gox = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void sZ(String str) {
        this.placeId = str;
    }

    public void ta(String str) {
        this.goz = str;
    }

    public void sf(int i) {
        this.goD = i;
    }

    public void sg(int i) {
        this.goE = i;
    }

    public void sh(int i) {
        this.goF = i;
    }

    public void si(int i) {
        this.goH = i;
    }

    public void tb(String str) {
        this.goI = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gox = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.goz = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bZ(String str, String str2) {
        if (this.gov == null) {
            this.gov = new JSONObject();
        }
        try {
            this.gov.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bpb() {
        if (this.cnj != null) {
            return this.cnj;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gox);
            jSONObject.put("da_type", this.gow);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.goy);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.goz);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.goA);
            jSONObject.put("ext3", this.goC);
            jSONObject.put("ext2", this.goB);
            jSONObject.put("da_ext1", this.goD);
            jSONObject.put("da_ext2", this.goE);
            jSONObject.put("da_ext3", this.goF);
            jSONObject.put("da_ext4", this.goG);
            jSONObject.put("da_ext5", this.goH);
            jSONObject.put("da_menu1", this.goJ);
            jSONObject.put("da_menu2", this.goK);
            jSONObject.put("da_menu3", this.goL);
            jSONObject.put("da_page", this.goM);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.goI);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.goN);
        } catch (JSONException e) {
        }
        if (this.gov != null) {
            try {
                jSONObject.put("ext", this.gov);
            } catch (Exception e2) {
            }
        }
        this.cnj = jSONObject;
        return jSONObject;
    }

    public void tc(String str) {
        this.goJ = str;
    }

    public void td(String str) {
        this.goK = str;
    }

    public void te(String str) {
        this.goL = str;
    }

    public void tf(String str) {
        this.goM = str;
    }

    public void tg(String str) {
        this.goN = str;
    }
}
