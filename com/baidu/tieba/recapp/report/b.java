package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gUK;
    private String gUO;
    private JSONObject gUP;
    private int gUQ;
    private int gUR;
    private int gUS;
    private int gUT;
    private int gUU;
    private int gUV;
    private int gUW;
    private int gUX;
    private String gUY;
    private String gUZ;
    private String gVa;
    private String gVb;
    private String gVc;
    private String gVd;
    private String placeId;
    private int gUL = -1;
    private int gUM = -1;
    private int pageNumber = -1;
    private long gUN = System.currentTimeMillis() / 1000;

    public void vf(String str) {
        this.extInfo = str;
    }

    public void uj(int i) {
        this.gUL = i;
        if (this.gUP != null) {
            try {
                this.gUP.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void uk(int i) {
        this.gUM = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void vg(String str) {
        this.placeId = str;
    }

    public void vh(String str) {
        this.gUO = str;
    }

    public void ul(int i) {
        this.gUT = i;
    }

    public void um(int i) {
        this.gUU = i;
    }

    public void un(int i) {
        this.gUV = i;
    }

    public void uo(int i) {
        this.gUX = i;
    }

    public void vi(String str) {
        this.gUY = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gUM = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gUO = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cB(String str, String str2) {
        if (this.gUK == null) {
            this.gUK = new JSONObject();
        }
        try {
            this.gUK.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bwN() {
        if (this.gUP != null) {
            return this.gUP;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gUM != -1) {
                jSONObject.put("da_locate", this.gUM);
            }
            if (this.gUL != -1) {
                jSONObject.put("da_type", this.gUL);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gUN);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gUO);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gUQ);
            jSONObject.put("ext3", this.gUS);
            jSONObject.put("ext2", this.gUR);
            jSONObject.put("da_ext1", this.gUT);
            jSONObject.put("da_ext2", this.gUU);
            jSONObject.put("da_ext3", this.gUV);
            jSONObject.put("da_ext4", this.gUW);
            jSONObject.put("da_ext5", this.gUX);
            jSONObject.put("da_menu1", this.gUZ);
            jSONObject.put("da_menu2", this.gVa);
            jSONObject.put("da_menu3", this.gVb);
            jSONObject.put("da_page", this.gVc);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gUY);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gVd);
        } catch (JSONException e) {
        }
        if (this.gUK != null) {
            try {
                jSONObject.put("ext", this.gUK);
            } catch (Exception e2) {
            }
        }
        this.gUP = jSONObject;
        return jSONObject;
    }

    public void vj(String str) {
        this.gUZ = str;
    }

    public void vk(String str) {
        this.gVa = str;
    }

    public void vl(String str) {
        this.gVb = str;
    }

    public void vm(String str) {
        this.gVc = str;
    }

    public void vn(String str) {
        this.gVd = str;
    }
}
