package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gtC;
    private String gtG;
    private JSONObject gtH;
    private int gtI;
    private int gtJ;
    private int gtK;
    private int gtL;
    private int gtM;
    private int gtN;
    private int gtO;
    private int gtP;
    private String gtQ;
    private String gtR;
    private String gtS;
    private String gtT;
    private String gtU;
    private String gtV;
    private String placeId;
    private int gtD = -1;
    private int gtE = -1;
    private int pageNumber = -1;
    private long gtF = System.currentTimeMillis() / 1000;

    public void sY(String str) {
        this.extInfo = str;
    }

    public void sl(int i) {
        this.gtD = i;
        if (this.gtH != null) {
            try {
                this.gtH.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void sm(int i) {
        this.gtE = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void sZ(String str) {
        this.placeId = str;
    }

    public void ta(String str) {
        this.gtG = str;
    }

    public void sn(int i) {
        this.gtL = i;
    }

    public void so(int i) {
        this.gtM = i;
    }

    public void sp(int i) {
        this.gtN = i;
    }

    public void sq(int i) {
        this.gtP = i;
    }

    public void tb(String str) {
        this.gtQ = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gtE = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gtG = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ca(String str, String str2) {
        if (this.gtC == null) {
            this.gtC = new JSONObject();
        }
        try {
            this.gtC.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject boi() {
        if (this.gtH != null) {
            return this.gtH;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gtE != -1) {
                jSONObject.put("da_locate", this.gtE);
            }
            if (this.gtD != -1) {
                jSONObject.put("da_type", this.gtD);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gtF);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gtG);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gtI);
            jSONObject.put("ext3", this.gtK);
            jSONObject.put("ext2", this.gtJ);
            jSONObject.put("da_ext1", this.gtL);
            jSONObject.put("da_ext2", this.gtM);
            jSONObject.put("da_ext3", this.gtN);
            jSONObject.put("da_ext4", this.gtO);
            jSONObject.put("da_ext5", this.gtP);
            jSONObject.put("da_menu1", this.gtR);
            jSONObject.put("da_menu2", this.gtS);
            jSONObject.put("da_menu3", this.gtT);
            jSONObject.put("da_page", this.gtU);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gtQ);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gtV);
        } catch (JSONException e) {
        }
        if (this.gtC != null) {
            try {
                jSONObject.put("ext", this.gtC);
            } catch (Exception e2) {
            }
        }
        this.gtH = jSONObject;
        return jSONObject;
    }

    public void tc(String str) {
        this.gtR = str;
    }

    public void td(String str) {
        this.gtS = str;
    }

    public void te(String str) {
        this.gtT = str;
    }

    public void tf(String str) {
        this.gtU = str;
    }

    public void tg(String str) {
        this.gtV = str;
    }
}
