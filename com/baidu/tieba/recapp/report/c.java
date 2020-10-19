package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject mfS;
    private String mfU;
    private JSONObject mfV;
    private int mfW;
    private String mfX;
    private int mfY;
    private int mfZ;
    private int mga;
    private int mgb;
    private int mgc;
    private int mgd;
    private String mge;
    private String mgf;
    private String mgg;
    private String mgh;
    private String mgi;
    private String mgj;
    private String placeId;
    private int ZL = -1;
    private int ZN = -1;
    private int pageNumber = -1;
    private long mfT = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void Hs(int i) {
        this.ZL = i;
        if (this.mfV != null) {
            try {
                this.mfV.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Ht(int i) {
        this.ZN = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void QQ(String str) {
        this.placeId = str;
    }

    public void QR(String str) {
        this.mfU = str;
    }

    public void QS(String str) {
    }

    public void Hu(int i) {
        this.mfZ = i;
    }

    public void Hv(int i) {
        this.mga = i;
    }

    public void Hw(int i) {
        this.mgb = i;
    }

    public void Hx(int i) {
        this.mgc = i;
    }

    public void Hy(int i) {
        this.mgd = i;
    }

    public void QT(String str) {
        this.mge = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.ZN = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mfU = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void fZ(String str, String str2) {
        if (this.mfS == null) {
            this.mfS = new JSONObject();
        }
        try {
            this.mfS.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject dvF() {
        if (this.mfV != null) {
            return this.mfV;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ZN != -1) {
                jSONObject.put("da_locate", this.ZN);
            }
            if (this.ZL != -1) {
                jSONObject.put("da_type", this.ZL);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.mfT);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mfU);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mfW);
            jSONObject.put("ext3", this.mfY);
            jSONObject.put("ext2", this.mfX);
            jSONObject.put("da_ext1", this.mfZ);
            jSONObject.put("da_ext2", this.mga);
            jSONObject.put("da_ext3", this.mgb);
            jSONObject.put("da_ext4", this.mgc);
            jSONObject.put("da_ext5", this.mgd);
            jSONObject.put("da_menu1", this.mgf);
            jSONObject.put("da_menu2", this.mgg);
            jSONObject.put("da_menu3", this.mgh);
            jSONObject.put("da_page", this.mgi);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mge);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mgj);
        } catch (JSONException e) {
        }
        if (this.mfS != null) {
            try {
                jSONObject.put("ext", this.mfS);
            } catch (Exception e2) {
            }
        }
        this.mfV = jSONObject;
        return jSONObject;
    }

    public void QU(String str) {
        this.mgf = str;
    }

    public void QV(String str) {
        this.mgg = str;
    }

    public void QW(String str) {
        this.mgh = str;
    }

    public void QX(String str) {
        this.mgi = str;
    }

    public void QY(String str) {
        this.mgj = str;
    }
}
