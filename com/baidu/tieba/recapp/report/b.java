package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gAW;
    private String gBa;
    private JSONObject gBb;
    private int gBc;
    private int gBd;
    private int gBe;
    private int gBf;
    private int gBg;
    private int gBh;
    private int gBi;
    private int gBj;
    private String gBk;
    private String gBl;
    private String gBm;
    private String gBn;
    private String gBo;
    private String gBp;
    private String placeId;
    private int gAX = -1;
    private int gAY = -1;
    private int pageNumber = -1;
    private long gAZ = System.currentTimeMillis() / 1000;

    public void tF(String str) {
        this.extInfo = str;
    }

    public void sJ(int i) {
        this.gAX = i;
        if (this.gBb != null) {
            try {
                this.gBb.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void sK(int i) {
        this.gAY = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void tG(String str) {
        this.placeId = str;
    }

    public void tH(String str) {
        this.gBa = str;
    }

    public void sL(int i) {
        this.gBf = i;
    }

    public void sM(int i) {
        this.gBg = i;
    }

    public void sN(int i) {
        this.gBh = i;
    }

    public void sO(int i) {
        this.gBj = i;
    }

    public void tI(String str) {
        this.gBk = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gAY = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gBa = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ck(String str, String str2) {
        if (this.gAW == null) {
            this.gAW = new JSONObject();
        }
        try {
            this.gAW.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bqP() {
        if (this.gBb != null) {
            return this.gBb;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gAY != -1) {
                jSONObject.put("da_locate", this.gAY);
            }
            if (this.gAX != -1) {
                jSONObject.put("da_type", this.gAX);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gAZ);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gBa);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gBc);
            jSONObject.put("ext3", this.gBe);
            jSONObject.put("ext2", this.gBd);
            jSONObject.put("da_ext1", this.gBf);
            jSONObject.put("da_ext2", this.gBg);
            jSONObject.put("da_ext3", this.gBh);
            jSONObject.put("da_ext4", this.gBi);
            jSONObject.put("da_ext5", this.gBj);
            jSONObject.put("da_menu1", this.gBl);
            jSONObject.put("da_menu2", this.gBm);
            jSONObject.put("da_menu3", this.gBn);
            jSONObject.put("da_page", this.gBo);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gBk);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gBp);
        } catch (JSONException e) {
        }
        if (this.gAW != null) {
            try {
                jSONObject.put("ext", this.gAW);
            } catch (Exception e2) {
            }
        }
        this.gBb = jSONObject;
        return jSONObject;
    }

    public void tJ(String str) {
        this.gBl = str;
    }

    public void tK(String str) {
        this.gBm = str;
    }

    public void tL(String str) {
        this.gBn = str;
    }

    public void tM(String str) {
        this.gBo = str;
    }

    public void tN(String str) {
        this.gBp = str;
    }
}
