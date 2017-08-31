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
    private JSONObject fIk;
    private int fIl;
    private int fIm;
    private long fIn = System.currentTimeMillis() / 1000;
    private String fIo;
    private JSONObject fIp;
    private int fIq;
    private int fIr;
    private int fIs;
    private int fIt;
    private int fIu;
    private int fIv;
    private String fIw;
    private String fIx;
    private String fIy;
    private String fIz;
    private int pageNumber;
    private String placeId;

    public void rd(String str) {
        this.extInfo = str;
    }

    public void sa(int i) {
        this.fIl = i;
    }

    public void sb(int i) {
        this.fIm = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void re(String str) {
        this.placeId = str;
    }

    public void rf(String str) {
        this.fIo = str;
    }

    public void sc(int i) {
        this.fIt = i;
    }

    public void sd(int i) {
        this.fIu = i;
    }

    public void se(int i) {
        this.fIv = i;
    }

    public void rg(String str) {
        this.fIw = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fIm = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fIo = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bZ(String str, String str2) {
        if (this.fIk == null) {
            this.fIk = new JSONObject();
        }
        try {
            this.fIk.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bhM() {
        if (this.fIp != null) {
            return this.fIp;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fIm);
            jSONObject.put("da_type", this.fIl);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fIn);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fIo);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fIq);
            jSONObject.put("ext3", this.fIs);
            jSONObject.put("ext2", this.fIr);
            jSONObject.put("da_ext1", this.fIt);
            jSONObject.put("da_ext2", this.fIu);
            jSONObject.put("da_ext3", this.fIv);
            jSONObject.put("da_menu1", this.fIx);
            jSONObject.put("da_menu2", this.fIy);
            jSONObject.put("da_menu3", this.fIz);
            jSONObject.put("da_page", this.fIA);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fIw);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fIB);
        } catch (JSONException e) {
        }
        if (this.fIk != null) {
            try {
                jSONObject.put("ext", this.fIk);
            } catch (Exception e2) {
            }
        }
        this.fIp = jSONObject;
        return jSONObject;
    }

    public void rh(String str) {
        this.fIx = str;
    }

    public void ri(String str) {
        this.fIy = str;
    }

    public void rj(String str) {
        this.fIz = str;
    }

    public void rk(String str) {
        this.fIA = str;
    }

    public void rl(String str) {
        this.fIB = str;
    }
}
