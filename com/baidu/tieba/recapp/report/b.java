package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject jLI;
    private String jLK;
    private JSONObject jLL;
    private int jLM;
    private String jLN;
    private int jLO;
    private int jLP;
    private int jLQ;
    private int jLR;
    private int jLS;
    private int jLT;
    private String jLU;
    private String jLV;
    private String jLW;
    private String jLX;
    private String jLY;
    private String jLZ;
    private String placeId;
    private int Er = -1;
    private int Et = -1;
    private int pageNumber = -1;
    private long jLJ = System.currentTimeMillis() / 1000;

    public void Ib(String str) {
        this.extInfo = str;
    }

    public void AY(int i) {
        this.Er = i;
        if (this.jLL != null) {
            try {
                this.jLL.put("da_type", i);
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

    public void Ic(String str) {
        this.placeId = str;
    }

    public void Id(String str) {
        this.jLK = str;
    }

    public void Ie(String str) {
    }

    public void Ba(int i) {
        this.jLP = i;
    }

    public void Bb(int i) {
        this.jLQ = i;
    }

    public void Bc(int i) {
        this.jLR = i;
    }

    public void Bd(int i) {
        this.jLS = i;
    }

    public void Be(int i) {
        this.jLT = i;
    }

    public void If(String str) {
        this.jLU = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Et = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.jLK = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void er(String str, String str2) {
        if (this.jLI == null) {
            this.jLI = new JSONObject();
        }
        try {
            this.jLI.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cDp() {
        if (this.jLL != null) {
            return this.jLL;
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
            jSONObject.put("origin_time", this.jLJ);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.jLK);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.jLM);
            jSONObject.put("ext3", this.jLO);
            jSONObject.put("ext2", this.jLN);
            jSONObject.put("da_ext1", this.jLP);
            jSONObject.put("da_ext2", this.jLQ);
            jSONObject.put("da_ext3", this.jLR);
            jSONObject.put("da_ext4", this.jLS);
            jSONObject.put("da_ext5", this.jLT);
            jSONObject.put("da_menu1", this.jLV);
            jSONObject.put("da_menu2", this.jLW);
            jSONObject.put("da_menu3", this.jLX);
            jSONObject.put("da_page", this.jLY);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.jLU);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.jLZ);
        } catch (JSONException e) {
        }
        if (this.jLI != null) {
            try {
                jSONObject.put("ext", this.jLI);
            } catch (Exception e2) {
            }
        }
        this.jLL = jSONObject;
        return jSONObject;
    }

    public void Ig(String str) {
        this.jLV = str;
    }

    public void Ih(String str) {
        this.jLW = str;
    }

    public void Ii(String str) {
        this.jLX = str;
    }

    public void Ij(String str) {
        this.jLY = str;
    }

    public void Ik(String str) {
        this.jLZ = str;
    }
}
