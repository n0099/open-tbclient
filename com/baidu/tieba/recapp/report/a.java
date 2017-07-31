package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String fIA;
    private String fIB;
    private String fIC;
    private String fID;
    private String fIE;
    private String fIF;
    private JSONObject fIo;
    private int fIp;
    private int fIq;
    private long fIr = System.currentTimeMillis() / 1000;
    private String fIs;
    private JSONObject fIt;
    private int fIu;
    private int fIv;
    private int fIw;
    private int fIx;
    private int fIy;
    private int fIz;
    private int pageNumber;
    private String placeId;

    public void ri(String str) {
        this.extInfo = str;
    }

    public void rT(int i) {
        this.fIp = i;
    }

    public void rU(int i) {
        this.fIq = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rj(String str) {
        this.placeId = str;
    }

    public void rk(String str) {
        this.fIs = str;
    }

    public void rV(int i) {
        this.fIx = i;
    }

    public void rW(int i) {
        this.fIy = i;
    }

    public void rX(int i) {
        this.fIz = i;
    }

    public void rl(String str) {
        this.fIA = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fIq = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fIs = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bY(String str, String str2) {
        if (this.fIo == null) {
            this.fIo = new JSONObject();
        }
        try {
            this.fIo.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bim() {
        if (this.fIt != null) {
            return this.fIt;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fIq);
            jSONObject.put("da_type", this.fIp);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fIr);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fIs);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fIu);
            jSONObject.put("ext3", this.fIw);
            jSONObject.put("ext2", this.fIv);
            jSONObject.put("da_ext1", this.fIx);
            jSONObject.put("da_ext2", this.fIy);
            jSONObject.put("da_ext3", this.fIz);
            jSONObject.put("da_menu1", this.fIB);
            jSONObject.put("da_menu2", this.fIC);
            jSONObject.put("da_menu3", this.fID);
            jSONObject.put("da_page", this.fIE);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fIA);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fIF);
        } catch (JSONException e) {
        }
        if (this.fIo != null) {
            try {
                jSONObject.put("ext", this.fIo);
            } catch (Exception e2) {
            }
        }
        this.fIt = jSONObject;
        return jSONObject;
    }

    public void rm(String str) {
        this.fIB = str;
    }

    public void rn(String str) {
        this.fIC = str;
    }

    public void ro(String str) {
        this.fID = str;
    }

    public void rp(String str) {
        this.fIE = str;
    }

    public void rq(String str) {
        this.fIF = str;
    }
}
