package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String gsA;
    private String gsB;
    private String gsC;
    private String gsD;
    private String gsE;
    private String gsF;
    private JSONObject gsm;
    private String gsq;
    private JSONObject gsr;
    private int gss;
    private int gst;
    private int gsu;
    private int gsv;
    private int gsw;
    private int gsx;
    private int gsy;
    private int gsz;
    private String placeId;
    private int gsn = -1;
    private int gso = -1;
    private int pageNumber = -1;
    private long gsp = System.currentTimeMillis() / 1000;

    public void sX(String str) {
        this.extInfo = str;
    }

    public void sn(int i) {
        this.gsn = i;
        if (this.gsr != null) {
            try {
                this.gsr.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void so(int i) {
        this.gso = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void sY(String str) {
        this.placeId = str;
    }

    public void sZ(String str) {
        this.gsq = str;
    }

    public void sp(int i) {
        this.gsv = i;
    }

    public void sq(int i) {
        this.gsw = i;
    }

    public void sr(int i) {
        this.gsx = i;
    }

    public void ss(int i) {
        this.gsz = i;
    }

    public void ta(String str) {
        this.gsA = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gso = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gsq = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cd(String str, String str2) {
        if (this.gsm == null) {
            this.gsm = new JSONObject();
        }
        try {
            this.gsm.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bpC() {
        if (this.gsr != null) {
            return this.gsr;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gso != -1) {
                jSONObject.put("da_locate", this.gso);
            }
            if (this.gsn != -1) {
                jSONObject.put("da_type", this.gsn);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gsp);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.gsq);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gss);
            jSONObject.put("ext3", this.gsu);
            jSONObject.put("ext2", this.gst);
            jSONObject.put("da_ext1", this.gsv);
            jSONObject.put("da_ext2", this.gsw);
            jSONObject.put("da_ext3", this.gsx);
            jSONObject.put("da_ext4", this.gsy);
            jSONObject.put("da_ext5", this.gsz);
            jSONObject.put("da_menu1", this.gsB);
            jSONObject.put("da_menu2", this.gsC);
            jSONObject.put("da_menu3", this.gsD);
            jSONObject.put("da_page", this.gsE);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gsA);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gsF);
        } catch (JSONException e) {
        }
        if (this.gsm != null) {
            try {
                jSONObject.put("ext", this.gsm);
            } catch (Exception e2) {
            }
        }
        this.gsr = jSONObject;
        return jSONObject;
    }

    public void tb(String str) {
        this.gsB = str;
    }

    public void tc(String str) {
        this.gsC = str;
    }

    public void td(String str) {
        this.gsD = str;
    }

    public void te(String str) {
        this.gsE = str;
    }

    public void tf(String str) {
        this.gsF = str;
    }
}
