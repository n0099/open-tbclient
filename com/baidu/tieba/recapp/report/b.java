package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gTF;
    private String gTJ;
    private JSONObject gTK;
    private int gTL;
    private int gTM;
    private int gTN;
    private int gTO;
    private int gTP;
    private int gTQ;
    private int gTR;
    private int gTS;
    private String gTT;
    private String gTU;
    private String gTV;
    private String gTW;
    private String gTX;
    private String gTY;
    private String placeId;
    private int gTG = -1;
    private int gTH = -1;
    private int pageNumber = -1;
    private long gTI = System.currentTimeMillis() / 1000;

    public void uP(String str) {
        this.extInfo = str;
    }

    public void ug(int i) {
        this.gTG = i;
        if (this.gTK != null) {
            try {
                this.gTK.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void uh(int i) {
        this.gTH = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void uQ(String str) {
        this.placeId = str;
    }

    public void uR(String str) {
        this.gTJ = str;
    }

    public void ui(int i) {
        this.gTO = i;
    }

    public void uj(int i) {
        this.gTP = i;
    }

    public void uk(int i) {
        this.gTQ = i;
    }

    public void ul(int i) {
        this.gTS = i;
    }

    public void uS(String str) {
        this.gTT = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gTH = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gTJ = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cA(String str, String str2) {
        if (this.gTF == null) {
            this.gTF = new JSONObject();
        }
        try {
            this.gTF.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bwe() {
        if (this.gTK != null) {
            return this.gTK;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gTH != -1) {
                jSONObject.put("da_locate", this.gTH);
            }
            if (this.gTG != -1) {
                jSONObject.put("da_type", this.gTG);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gTI);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gTJ);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gTL);
            jSONObject.put("ext3", this.gTN);
            jSONObject.put("ext2", this.gTM);
            jSONObject.put("da_ext1", this.gTO);
            jSONObject.put("da_ext2", this.gTP);
            jSONObject.put("da_ext3", this.gTQ);
            jSONObject.put("da_ext4", this.gTR);
            jSONObject.put("da_ext5", this.gTS);
            jSONObject.put("da_menu1", this.gTU);
            jSONObject.put("da_menu2", this.gTV);
            jSONObject.put("da_menu3", this.gTW);
            jSONObject.put("da_page", this.gTX);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gTT);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gTY);
        } catch (JSONException e) {
        }
        if (this.gTF != null) {
            try {
                jSONObject.put("ext", this.gTF);
            } catch (Exception e2) {
            }
        }
        this.gTK = jSONObject;
        return jSONObject;
    }

    public void uT(String str) {
        this.gTU = str;
    }

    public void uU(String str) {
        this.gTV = str;
    }

    public void uV(String str) {
        this.gTW = str;
    }

    public void uW(String str) {
        this.gTX = str;
    }

    public void uX(String str) {
        this.gTY = str;
    }
}
