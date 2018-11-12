package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gJX;
    private String gKb;
    private JSONObject gKc;
    private int gKd;
    private int gKe;
    private int gKf;
    private int gKg;
    private int gKh;
    private int gKi;
    private int gKj;
    private int gKk;
    private String gKl;
    private String gKm;
    private String gKn;
    private String gKo;
    private String gKp;
    private String gKq;
    private String placeId;
    private int gJY = -1;
    private int gJZ = -1;
    private int pageNumber = -1;
    private long gKa = System.currentTimeMillis() / 1000;

    public void ul(String str) {
        this.extInfo = str;
    }

    public void tz(int i) {
        this.gJY = i;
        if (this.gKc != null) {
            try {
                this.gKc.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void tA(int i) {
        this.gJZ = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void um(String str) {
        this.placeId = str;
    }

    public void un(String str) {
        this.gKb = str;
    }

    public void tB(int i) {
        this.gKg = i;
    }

    public void tC(int i) {
        this.gKh = i;
    }

    public void tD(int i) {
        this.gKi = i;
    }

    public void tE(int i) {
        this.gKk = i;
    }

    public void uo(String str) {
        this.gKl = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gJZ = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gKb = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cv(String str, String str2) {
        if (this.gJX == null) {
            this.gJX = new JSONObject();
        }
        try {
            this.gJX.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject btA() {
        if (this.gKc != null) {
            return this.gKc;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gJZ != -1) {
                jSONObject.put("da_locate", this.gJZ);
            }
            if (this.gJY != -1) {
                jSONObject.put("da_type", this.gJY);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gKa);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gKb);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gKd);
            jSONObject.put("ext3", this.gKf);
            jSONObject.put("ext2", this.gKe);
            jSONObject.put("da_ext1", this.gKg);
            jSONObject.put("da_ext2", this.gKh);
            jSONObject.put("da_ext3", this.gKi);
            jSONObject.put("da_ext4", this.gKj);
            jSONObject.put("da_ext5", this.gKk);
            jSONObject.put("da_menu1", this.gKm);
            jSONObject.put("da_menu2", this.gKn);
            jSONObject.put("da_menu3", this.gKo);
            jSONObject.put("da_page", this.gKp);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gKl);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gKq);
        } catch (JSONException e) {
        }
        if (this.gJX != null) {
            try {
                jSONObject.put("ext", this.gJX);
            } catch (Exception e2) {
            }
        }
        this.gKc = jSONObject;
        return jSONObject;
    }

    public void up(String str) {
        this.gKm = str;
    }

    public void uq(String str) {
        this.gKn = str;
    }

    public void ur(String str) {
        this.gKo = str;
    }

    public void us(String str) {
        this.gKp = str;
    }

    public void ut(String str) {
        this.gKq = str;
    }
}
