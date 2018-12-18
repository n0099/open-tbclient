package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gQN;
    private String gQR;
    private JSONObject gQS;
    private int gQT;
    private int gQU;
    private int gQV;
    private int gQW;
    private int gQX;
    private int gQY;
    private int gQZ;
    private int gRa;
    private String gRb;
    private String gRc;
    private String gRd;
    private String gRe;
    private String gRf;
    private String gRg;
    private String placeId;
    private int gQO = -1;
    private int gQP = -1;
    private int pageNumber = -1;
    private long gQQ = System.currentTimeMillis() / 1000;

    public void uM(String str) {
        this.extInfo = str;
    }

    public void tT(int i) {
        this.gQO = i;
        if (this.gQS != null) {
            try {
                this.gQS.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void tU(int i) {
        this.gQP = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void uN(String str) {
        this.placeId = str;
    }

    public void uO(String str) {
        this.gQR = str;
    }

    public void tV(int i) {
        this.gQW = i;
    }

    public void tW(int i) {
        this.gQX = i;
    }

    public void tX(int i) {
        this.gQY = i;
    }

    public void tY(int i) {
        this.gRa = i;
    }

    public void uP(String str) {
        this.gRb = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gQP = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gQR = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cA(String str, String str2) {
        if (this.gQN == null) {
            this.gQN = new JSONObject();
        }
        try {
            this.gQN.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bvs() {
        if (this.gQS != null) {
            return this.gQS;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gQP != -1) {
                jSONObject.put("da_locate", this.gQP);
            }
            if (this.gQO != -1) {
                jSONObject.put("da_type", this.gQO);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gQQ);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gQR);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gQT);
            jSONObject.put("ext3", this.gQV);
            jSONObject.put("ext2", this.gQU);
            jSONObject.put("da_ext1", this.gQW);
            jSONObject.put("da_ext2", this.gQX);
            jSONObject.put("da_ext3", this.gQY);
            jSONObject.put("da_ext4", this.gQZ);
            jSONObject.put("da_ext5", this.gRa);
            jSONObject.put("da_menu1", this.gRc);
            jSONObject.put("da_menu2", this.gRd);
            jSONObject.put("da_menu3", this.gRe);
            jSONObject.put("da_page", this.gRf);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gRb);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gRg);
        } catch (JSONException e) {
        }
        if (this.gQN != null) {
            try {
                jSONObject.put("ext", this.gQN);
            } catch (Exception e2) {
            }
        }
        this.gQS = jSONObject;
        return jSONObject;
    }

    public void uQ(String str) {
        this.gRc = str;
    }

    public void uR(String str) {
        this.gRd = str;
    }

    public void uS(String str) {
        this.gRe = str;
    }

    public void uT(String str) {
        this.gRf = str;
    }

    public void uU(String str) {
        this.gRg = str;
    }
}
