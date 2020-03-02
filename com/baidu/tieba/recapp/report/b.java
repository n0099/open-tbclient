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
    private String jLB;
    private int jLC;
    private int jLD;
    private int jLE;
    private int jLF;
    private int jLG;
    private int jLH;
    private String jLI;
    private String jLJ;
    private String jLK;
    private String jLL;
    private String jLM;
    private String jLN;
    private JSONObject jLw;
    private String jLy;
    private JSONObject jLz;
    private String placeId;
    private int Er = -1;
    private int Et = -1;
    private int pageNumber = -1;
    private long jLx = System.currentTimeMillis() / 1000;

    public void Ia(String str) {
        this.extInfo = str;
    }

    public void AY(int i) {
        this.Er = i;
        if (this.jLz != null) {
            try {
                this.jLz.put("da_type", i);
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
        this.jLy = str;
    }

    public void Id(String str) {
    }

    public void Ba(int i) {
        this.jLD = i;
    }

    public void Bb(int i) {
        this.jLE = i;
    }

    public void Bc(int i) {
        this.jLF = i;
    }

    public void Bd(int i) {
        this.jLG = i;
    }

    public void Be(int i) {
        this.jLH = i;
    }

    public void Ie(String str) {
        this.jLI = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Et = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.jLy = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void er(String str, String str2) {
        if (this.jLw == null) {
            this.jLw = new JSONObject();
        }
        try {
            this.jLw.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cDo() {
        if (this.jLz != null) {
            return this.jLz;
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
            jSONObject.put("origin_time", this.jLx);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.jLy);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.jLA);
            jSONObject.put("ext3", this.jLC);
            jSONObject.put("ext2", this.jLB);
            jSONObject.put("da_ext1", this.jLD);
            jSONObject.put("da_ext2", this.jLE);
            jSONObject.put("da_ext3", this.jLF);
            jSONObject.put("da_ext4", this.jLG);
            jSONObject.put("da_ext5", this.jLH);
            jSONObject.put("da_menu1", this.jLJ);
            jSONObject.put("da_menu2", this.jLK);
            jSONObject.put("da_menu3", this.jLL);
            jSONObject.put("da_page", this.jLM);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.jLI);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.jLN);
        } catch (JSONException e) {
        }
        if (this.jLw != null) {
            try {
                jSONObject.put("ext", this.jLw);
            } catch (Exception e2) {
            }
        }
        this.jLz = jSONObject;
        return jSONObject;
    }

    public void If(String str) {
        this.jLJ = str;
    }

    public void Ig(String str) {
        this.jLK = str;
    }

    public void Ih(String str) {
        this.jLL = str;
    }

    public void Ii(String str) {
        this.jLM = str;
    }

    public void Ij(String str) {
        this.jLN = str;
    }
}
