package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String jNA;
    private String jNB;
    private JSONObject jNk;
    private String jNm;
    private JSONObject jNn;
    private int jNo;
    private String jNp;
    private int jNq;
    private int jNr;
    private int jNs;
    private int jNt;
    private int jNu;
    private int jNv;
    private String jNw;
    private String jNx;
    private String jNy;
    private String jNz;
    private String placeId;
    private int Er = -1;
    private int Et = -1;
    private int pageNumber = -1;
    private long jNl = System.currentTimeMillis() / 1000;

    public void Ia(String str) {
        this.extInfo = str;
    }

    public void Bg(int i) {
        this.Er = i;
        if (this.jNn != null) {
            try {
                this.jNn.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Bh(int i) {
        this.Et = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Ib(String str) {
        this.placeId = str;
    }

    public void Ic(String str) {
        this.jNm = str;
    }

    public void Id(String str) {
    }

    public void Bi(int i) {
        this.jNr = i;
    }

    public void Bj(int i) {
        this.jNs = i;
    }

    public void Bk(int i) {
        this.jNt = i;
    }

    public void Bl(int i) {
        this.jNu = i;
    }

    public void Bm(int i) {
        this.jNv = i;
    }

    public void Ie(String str) {
        this.jNw = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Et = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.jNm = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ep(String str, String str2) {
        if (this.jNk == null) {
            this.jNk = new JSONObject();
        }
        try {
            this.jNk.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cDJ() {
        if (this.jNn != null) {
            return this.jNn;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Et != -1) {
                jSONObject.put("da_locate", this.Et);
            }
            if (this.Er != -1) {
                jSONObject.put("da_type", this.Er);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.jNl);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.jNm);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.jNo);
            jSONObject.put("ext3", this.jNq);
            jSONObject.put("ext2", this.jNp);
            jSONObject.put("da_ext1", this.jNr);
            jSONObject.put("da_ext2", this.jNs);
            jSONObject.put("da_ext3", this.jNt);
            jSONObject.put("da_ext4", this.jNu);
            jSONObject.put("da_ext5", this.jNv);
            jSONObject.put("da_menu1", this.jNx);
            jSONObject.put("da_menu2", this.jNy);
            jSONObject.put("da_menu3", this.jNz);
            jSONObject.put("da_page", this.jNA);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.jNw);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.jNB);
        } catch (JSONException e) {
        }
        if (this.jNk != null) {
            try {
                jSONObject.put("ext", this.jNk);
            } catch (Exception e2) {
            }
        }
        this.jNn = jSONObject;
        return jSONObject;
    }

    public void If(String str) {
        this.jNx = str;
    }

    public void Ig(String str) {
        this.jNy = str;
    }

    public void Ih(String str) {
        this.jNz = str;
    }

    public void Ii(String str) {
        this.jNA = str;
    }

    public void Ij(String str) {
        this.jNB = str;
    }
}
