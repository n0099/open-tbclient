package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int jLA;
    private int jLB;
    private int jLC;
    private int jLD;
    private int jLE;
    private int jLF;
    private String jLG;
    private String jLH;
    private String jLI;
    private String jLJ;
    private String jLK;
    private String jLL;
    private JSONObject jLu;
    private String jLw;
    private JSONObject jLx;
    private int jLy;
    private String jLz;
    private String placeId;
    private int Er = -1;
    private int Et = -1;
    private int pageNumber = -1;
    private long jLv = System.currentTimeMillis() / 1000;

    public void Ia(String str) {
        this.extInfo = str;
    }

    public void AY(int i) {
        this.Er = i;
        if (this.jLx != null) {
            try {
                this.jLx.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void AZ(int i) {
        this.Et = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Ib(String str) {
        this.placeId = str;
    }

    public void Ic(String str) {
        this.jLw = str;
    }

    public void Id(String str) {
    }

    public void Ba(int i) {
        this.jLB = i;
    }

    public void Bb(int i) {
        this.jLC = i;
    }

    public void Bc(int i) {
        this.jLD = i;
    }

    public void Bd(int i) {
        this.jLE = i;
    }

    public void Be(int i) {
        this.jLF = i;
    }

    public void Ie(String str) {
        this.jLG = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Et = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.jLw = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void er(String str, String str2) {
        if (this.jLu == null) {
            this.jLu = new JSONObject();
        }
        try {
            this.jLu.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cDm() {
        if (this.jLx != null) {
            return this.jLx;
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
            jSONObject.put("origin_time", this.jLv);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.jLw);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.jLy);
            jSONObject.put("ext3", this.jLA);
            jSONObject.put("ext2", this.jLz);
            jSONObject.put("da_ext1", this.jLB);
            jSONObject.put("da_ext2", this.jLC);
            jSONObject.put("da_ext3", this.jLD);
            jSONObject.put("da_ext4", this.jLE);
            jSONObject.put("da_ext5", this.jLF);
            jSONObject.put("da_menu1", this.jLH);
            jSONObject.put("da_menu2", this.jLI);
            jSONObject.put("da_menu3", this.jLJ);
            jSONObject.put("da_page", this.jLK);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.jLG);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.jLL);
        } catch (JSONException e) {
        }
        if (this.jLu != null) {
            try {
                jSONObject.put("ext", this.jLu);
            } catch (Exception e2) {
            }
        }
        this.jLx = jSONObject;
        return jSONObject;
    }

    public void If(String str) {
        this.jLH = str;
    }

    public void Ig(String str) {
        this.jLI = str;
    }

    public void Ih(String str) {
        this.jLJ = str;
    }

    public void Ii(String str) {
        this.jLK = str;
    }

    public void Ij(String str) {
        this.jLL = str;
    }
}
