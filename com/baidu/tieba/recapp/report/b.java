package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject iMf;
    private String iMh;
    private JSONObject iMi;
    private int iMj;
    private String iMk;
    private int iMl;
    private int iMm;
    private int iMn;
    private int iMo;
    private int iMp;
    private int iMq;
    private String iMr;
    private String iMs;
    private String iMt;
    private String iMu;
    private String iMv;
    private String iMw;
    private String placeId;
    private int Ss = -1;
    private int Su = -1;
    private int pageNumber = -1;
    private long iMg = System.currentTimeMillis() / 1000;

    public void DU(String str) {
        this.extInfo = str;
    }

    public void zG(int i) {
        this.Ss = i;
        if (this.iMi != null) {
            try {
                this.iMi.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void zH(int i) {
        this.Su = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void DV(String str) {
        this.placeId = str;
    }

    public void DW(String str) {
        this.iMh = str;
    }

    public void DX(String str) {
    }

    public void zI(int i) {
        this.iMm = i;
    }

    public void zJ(int i) {
        this.iMn = i;
    }

    public void zK(int i) {
        this.iMo = i;
    }

    public void zL(int i) {
        this.iMp = i;
    }

    public void zM(int i) {
        this.iMq = i;
    }

    public void DY(String str) {
        this.iMr = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Su = com.baidu.adp.lib.g.b.f(downloadStaticsData.getAdPosition(), 0);
            this.iMh = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ea(String str, String str2) {
        if (this.iMf == null) {
            this.iMf = new JSONObject();
        }
        try {
            this.iMf.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject ciP() {
        if (this.iMi != null) {
            return this.iMi;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Su != -1) {
                jSONObject.put("da_locate", this.Su);
            }
            if (this.Ss != -1) {
                jSONObject.put("da_type", this.Ss);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.iMg);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iMh);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iMj);
            jSONObject.put("ext3", this.iMl);
            jSONObject.put("ext2", this.iMk);
            jSONObject.put("da_ext1", this.iMm);
            jSONObject.put("da_ext2", this.iMn);
            jSONObject.put("da_ext3", this.iMo);
            jSONObject.put("da_ext4", this.iMp);
            jSONObject.put("da_ext5", this.iMq);
            jSONObject.put("da_menu1", this.iMs);
            jSONObject.put("da_menu2", this.iMt);
            jSONObject.put("da_menu3", this.iMu);
            jSONObject.put("da_page", this.iMv);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iMr);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iMw);
        } catch (JSONException e) {
        }
        if (this.iMf != null) {
            try {
                jSONObject.put("ext", this.iMf);
            } catch (Exception e2) {
            }
        }
        this.iMi = jSONObject;
        return jSONObject;
    }

    public void DZ(String str) {
        this.iMs = str;
    }

    public void Ea(String str) {
        this.iMt = str;
    }

    public void Eb(String str) {
        this.iMu = str;
    }

    public void Ec(String str) {
        this.iMv = str;
    }

    public void Ed(String str) {
        this.iMw = str;
    }
}
