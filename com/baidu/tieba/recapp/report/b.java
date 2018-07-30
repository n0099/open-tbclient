package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String gtD;
    private JSONObject gtE;
    private int gtF;
    private int gtG;
    private int gtH;
    private int gtI;
    private int gtJ;
    private int gtK;
    private int gtL;
    private int gtM;
    private String gtN;
    private String gtO;
    private String gtP;
    private String gtQ;
    private String gtR;
    private String gtS;
    private JSONObject gtz;
    private String placeId;
    private int gtA = -1;
    private int gtB = -1;
    private int pageNumber = -1;
    private long gtC = System.currentTimeMillis() / 1000;

    public void sU(String str) {
        this.extInfo = str;
    }

    public void sl(int i) {
        this.gtA = i;
        if (this.gtE != null) {
            try {
                this.gtE.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void sm(int i) {
        this.gtB = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void sV(String str) {
        this.placeId = str;
    }

    public void sW(String str) {
        this.gtD = str;
    }

    public void sn(int i) {
        this.gtI = i;
    }

    public void so(int i) {
        this.gtJ = i;
    }

    public void sp(int i) {
        this.gtK = i;
    }

    public void sq(int i) {
        this.gtM = i;
    }

    public void sX(String str) {
        this.gtN = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gtB = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gtD = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ca(String str, String str2) {
        if (this.gtz == null) {
            this.gtz = new JSONObject();
        }
        try {
            this.gtz.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject boh() {
        if (this.gtE != null) {
            return this.gtE;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gtB != -1) {
                jSONObject.put("da_locate", this.gtB);
            }
            if (this.gtA != -1) {
                jSONObject.put("da_type", this.gtA);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gtC);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gtD);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gtF);
            jSONObject.put("ext3", this.gtH);
            jSONObject.put("ext2", this.gtG);
            jSONObject.put("da_ext1", this.gtI);
            jSONObject.put("da_ext2", this.gtJ);
            jSONObject.put("da_ext3", this.gtK);
            jSONObject.put("da_ext4", this.gtL);
            jSONObject.put("da_ext5", this.gtM);
            jSONObject.put("da_menu1", this.gtO);
            jSONObject.put("da_menu2", this.gtP);
            jSONObject.put("da_menu3", this.gtQ);
            jSONObject.put("da_page", this.gtR);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gtN);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gtS);
        } catch (JSONException e) {
        }
        if (this.gtz != null) {
            try {
                jSONObject.put("ext", this.gtz);
            } catch (Exception e2) {
            }
        }
        this.gtE = jSONObject;
        return jSONObject;
    }

    public void sY(String str) {
        this.gtO = str;
    }

    public void sZ(String str) {
        this.gtP = str;
    }

    public void ta(String str) {
        this.gtQ = str;
    }

    public void tb(String str) {
        this.gtR = str;
    }

    public void tc(String str) {
        this.gtS = str;
    }
}
