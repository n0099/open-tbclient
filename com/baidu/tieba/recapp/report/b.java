package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gUL;
    private String gUP;
    private JSONObject gUQ;
    private int gUR;
    private int gUS;
    private int gUT;
    private int gUU;
    private int gUV;
    private int gUW;
    private int gUX;
    private int gUY;
    private String gUZ;
    private String gVa;
    private String gVb;
    private String gVc;
    private String gVd;
    private String gVe;
    private String placeId;
    private int gUM = -1;
    private int gUN = -1;
    private int pageNumber = -1;
    private long gUO = System.currentTimeMillis() / 1000;

    public void vf(String str) {
        this.extInfo = str;
    }

    public void uj(int i) {
        this.gUM = i;
        if (this.gUQ != null) {
            try {
                this.gUQ.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void uk(int i) {
        this.gUN = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void vg(String str) {
        this.placeId = str;
    }

    public void vh(String str) {
        this.gUP = str;
    }

    public void ul(int i) {
        this.gUU = i;
    }

    public void um(int i) {
        this.gUV = i;
    }

    public void un(int i) {
        this.gUW = i;
    }

    public void uo(int i) {
        this.gUY = i;
    }

    public void vi(String str) {
        this.gUZ = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gUN = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gUP = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cB(String str, String str2) {
        if (this.gUL == null) {
            this.gUL = new JSONObject();
        }
        try {
            this.gUL.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bwN() {
        if (this.gUQ != null) {
            return this.gUQ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gUN != -1) {
                jSONObject.put("da_locate", this.gUN);
            }
            if (this.gUM != -1) {
                jSONObject.put("da_type", this.gUM);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gUO);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gUP);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gUR);
            jSONObject.put("ext3", this.gUT);
            jSONObject.put("ext2", this.gUS);
            jSONObject.put("da_ext1", this.gUU);
            jSONObject.put("da_ext2", this.gUV);
            jSONObject.put("da_ext3", this.gUW);
            jSONObject.put("da_ext4", this.gUX);
            jSONObject.put("da_ext5", this.gUY);
            jSONObject.put("da_menu1", this.gVa);
            jSONObject.put("da_menu2", this.gVb);
            jSONObject.put("da_menu3", this.gVc);
            jSONObject.put("da_page", this.gVd);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gUZ);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gVe);
        } catch (JSONException e) {
        }
        if (this.gUL != null) {
            try {
                jSONObject.put("ext", this.gUL);
            } catch (Exception e2) {
            }
        }
        this.gUQ = jSONObject;
        return jSONObject;
    }

    public void vj(String str) {
        this.gVa = str;
    }

    public void vk(String str) {
        this.gVb = str;
    }

    public void vl(String str) {
        this.gVc = str;
    }

    public void vm(String str) {
        this.gVd = str;
    }

    public void vn(String str) {
        this.gVe = str;
    }
}
