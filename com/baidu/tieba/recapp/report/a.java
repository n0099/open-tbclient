package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String fPA;
    private String fPB;
    private String fPC;
    private String fPD;
    private JSONObject fPl;
    private int fPm;
    private int fPn;
    private long fPo = System.currentTimeMillis() / 1000;
    private String fPp;
    private JSONObject fPq;
    private int fPr;
    private int fPs;
    private int fPt;
    private int fPu;
    private int fPv;
    private int fPw;
    private int fPx;
    private String fPy;
    private String fPz;
    private int pageNumber;
    private String placeId;

    public void rC(String str) {
        this.extInfo = str;
    }

    public void sw(int i) {
        this.fPm = i;
    }

    public void sx(int i) {
        this.fPn = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rD(String str) {
        this.placeId = str;
    }

    public void rE(String str) {
        this.fPp = str;
    }

    public void sy(int i) {
        this.fPu = i;
    }

    public void sz(int i) {
        this.fPv = i;
    }

    public void sA(int i) {
        this.fPw = i;
    }

    public void sB(int i) {
        this.fPx = i;
    }

    public void rF(String str) {
        this.fPy = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fPn = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fPp = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bU(String str, String str2) {
        if (this.fPl == null) {
            this.fPl = new JSONObject();
        }
        try {
            this.fPl.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bjU() {
        if (this.fPq != null) {
            return this.fPq;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fPn);
            jSONObject.put("da_type", this.fPm);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fPo);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fPp);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fPr);
            jSONObject.put("ext3", this.fPt);
            jSONObject.put("ext2", this.fPs);
            jSONObject.put("da_ext1", this.fPu);
            jSONObject.put("da_ext2", this.fPv);
            jSONObject.put("da_ext3", this.fPw);
            jSONObject.put("da_ext4", this.fPx);
            jSONObject.put("da_menu1", this.fPz);
            jSONObject.put("da_menu2", this.fPA);
            jSONObject.put("da_menu3", this.fPB);
            jSONObject.put("da_page", this.fPC);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fPy);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fPD);
        } catch (JSONException e) {
        }
        if (this.fPl != null) {
            try {
                jSONObject.put("ext", this.fPl);
            } catch (Exception e2) {
            }
        }
        this.fPq = jSONObject;
        return jSONObject;
    }

    public void rG(String str) {
        this.fPz = str;
    }

    public void rH(String str) {
        this.fPA = str;
    }

    public void rI(String str) {
        this.fPB = str;
    }

    public void rJ(String str) {
        this.fPC = str;
    }

    public void rK(String str) {
        this.fPD = str;
    }
}
