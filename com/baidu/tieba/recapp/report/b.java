package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String gIA;
    private JSONObject gIB;
    private int gIC;
    private int gID;
    private int gIE;
    private int gIF;
    private int gIG;
    private int gIH;
    private int gII;
    private int gIJ;
    private String gIK;
    private String gIL;
    private String gIM;
    private String gIN;
    private String gIO;
    private String gIP;
    private JSONObject gIw;
    private String placeId;
    private int gIx = -1;
    private int gIy = -1;
    private int pageNumber = -1;
    private long gIz = System.currentTimeMillis() / 1000;

    public void uh(String str) {
        this.extInfo = str;
    }

    public void tg(int i) {
        this.gIx = i;
        if (this.gIB != null) {
            try {
                this.gIB.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void th(int i) {
        this.gIy = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void ui(String str) {
        this.placeId = str;
    }

    public void uj(String str) {
        this.gIA = str;
    }

    public void ti(int i) {
        this.gIF = i;
    }

    public void tj(int i) {
        this.gIG = i;
    }

    public void tk(int i) {
        this.gIH = i;
    }

    public void tl(int i) {
        this.gIJ = i;
    }

    public void uk(String str) {
        this.gIK = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gIy = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.gIA = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cv(String str, String str2) {
        if (this.gIw == null) {
            this.gIw = new JSONObject();
        }
        try {
            this.gIw.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bue() {
        if (this.gIB != null) {
            return this.gIB;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gIy != -1) {
                jSONObject.put("da_locate", this.gIy);
            }
            if (this.gIx != -1) {
                jSONObject.put("da_type", this.gIx);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gIz);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gIA);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gIC);
            jSONObject.put("ext3", this.gIE);
            jSONObject.put("ext2", this.gID);
            jSONObject.put("da_ext1", this.gIF);
            jSONObject.put("da_ext2", this.gIG);
            jSONObject.put("da_ext3", this.gIH);
            jSONObject.put("da_ext4", this.gII);
            jSONObject.put("da_ext5", this.gIJ);
            jSONObject.put("da_menu1", this.gIL);
            jSONObject.put("da_menu2", this.gIM);
            jSONObject.put("da_menu3", this.gIN);
            jSONObject.put("da_page", this.gIO);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gIK);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gIP);
        } catch (JSONException e) {
        }
        if (this.gIw != null) {
            try {
                jSONObject.put("ext", this.gIw);
            } catch (Exception e2) {
            }
        }
        this.gIB = jSONObject;
        return jSONObject;
    }

    public void ul(String str) {
        this.gIL = str;
    }

    public void um(String str) {
        this.gIM = str;
    }

    public void un(String str) {
        this.gIN = str;
    }

    public void uo(String str) {
        this.gIO = str;
    }

    public void up(String str) {
        this.gIP = str;
    }
}
