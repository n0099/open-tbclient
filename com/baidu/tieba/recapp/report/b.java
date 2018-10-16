package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gIA;
    private int gIB;
    private int gIC;
    private int gID;
    private int gIE;
    private int gIF;
    private int gIG;
    private int gIH;
    private int gII;
    private String gIJ;
    private String gIK;
    private String gIL;
    private String gIM;
    private String gIN;
    private String gIO;
    private JSONObject gIv;
    private String gIz;
    private String placeId;
    private int gIw = -1;
    private int gIx = -1;
    private int pageNumber = -1;
    private long gIy = System.currentTimeMillis() / 1000;

    public void uh(String str) {
        this.extInfo = str;
    }

    public void tg(int i) {
        this.gIw = i;
        if (this.gIA != null) {
            try {
                this.gIA.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void th(int i) {
        this.gIx = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void ui(String str) {
        this.placeId = str;
    }

    public void uj(String str) {
        this.gIz = str;
    }

    public void ti(int i) {
        this.gIE = i;
    }

    public void tj(int i) {
        this.gIF = i;
    }

    public void tk(int i) {
        this.gIG = i;
    }

    public void tl(int i) {
        this.gII = i;
    }

    public void uk(String str) {
        this.gIJ = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gIx = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gIz = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cv(String str, String str2) {
        if (this.gIv == null) {
            this.gIv = new JSONObject();
        }
        try {
            this.gIv.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bue() {
        if (this.gIA != null) {
            return this.gIA;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gIx != -1) {
                jSONObject.put("da_locate", this.gIx);
            }
            if (this.gIw != -1) {
                jSONObject.put("da_type", this.gIw);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gIy);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gIz);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gIB);
            jSONObject.put("ext3", this.gID);
            jSONObject.put("ext2", this.gIC);
            jSONObject.put("da_ext1", this.gIE);
            jSONObject.put("da_ext2", this.gIF);
            jSONObject.put("da_ext3", this.gIG);
            jSONObject.put("da_ext4", this.gIH);
            jSONObject.put("da_ext5", this.gII);
            jSONObject.put("da_menu1", this.gIK);
            jSONObject.put("da_menu2", this.gIL);
            jSONObject.put("da_menu3", this.gIM);
            jSONObject.put("da_page", this.gIN);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gIJ);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gIO);
        } catch (JSONException e) {
        }
        if (this.gIv != null) {
            try {
                jSONObject.put("ext", this.gIv);
            } catch (Exception e2) {
            }
        }
        this.gIA = jSONObject;
        return jSONObject;
    }

    public void ul(String str) {
        this.gIK = str;
    }

    public void um(String str) {
        this.gIL = str;
    }

    public void un(String str) {
        this.gIM = str;
    }

    public void uo(String str) {
        this.gIN = str;
    }

    public void up(String str) {
        this.gIO = str;
    }
}
