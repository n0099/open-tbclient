package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject ljD;
    private String ljF;
    private JSONObject ljG;
    private int ljH;
    private String ljI;
    private int ljJ;
    private int ljK;
    private int ljL;
    private int ljM;
    private int ljN;
    private int ljO;
    private String ljP;
    private String ljQ;
    private String ljR;
    private String ljS;
    private String ljT;
    private String ljU;
    private String placeId;
    private int YF = -1;
    private int YH = -1;
    private int pageNumber = -1;
    private long ljE = System.currentTimeMillis() / 1000;

    public void LW(String str) {
        this.extInfo = str;
    }

    public void Du(int i) {
        this.YF = i;
        if (this.ljG != null) {
            try {
                this.ljG.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Dv(int i) {
        this.YH = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void LX(String str) {
        this.placeId = str;
    }

    public void LY(String str) {
        this.ljF = str;
    }

    public void LZ(String str) {
    }

    public void Dw(int i) {
        this.ljK = i;
    }

    public void Dx(int i) {
        this.ljL = i;
    }

    public void Dy(int i) {
        this.ljM = i;
    }

    public void Dz(int i) {
        this.ljN = i;
    }

    public void DA(int i) {
        this.ljO = i;
    }

    public void Ma(String str) {
        this.ljP = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.YH = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.ljF = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void fm(String str, String str2) {
        if (this.ljD == null) {
            this.ljD = new JSONObject();
        }
        try {
            this.ljD.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cZP() {
        if (this.ljG != null) {
            return this.ljG;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.YH != -1) {
                jSONObject.put("da_locate", this.YH);
            }
            if (this.YF != -1) {
                jSONObject.put("da_type", this.YF);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.ljE);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.ljF);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.ljH);
            jSONObject.put("ext3", this.ljJ);
            jSONObject.put("ext2", this.ljI);
            jSONObject.put("da_ext1", this.ljK);
            jSONObject.put("da_ext2", this.ljL);
            jSONObject.put("da_ext3", this.ljM);
            jSONObject.put("da_ext4", this.ljN);
            jSONObject.put("da_ext5", this.ljO);
            jSONObject.put("da_menu1", this.ljQ);
            jSONObject.put("da_menu2", this.ljR);
            jSONObject.put("da_menu3", this.ljS);
            jSONObject.put("da_page", this.ljT);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.ljP);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.ljU);
        } catch (JSONException e) {
        }
        if (this.ljD != null) {
            try {
                jSONObject.put("ext", this.ljD);
            } catch (Exception e2) {
            }
        }
        this.ljG = jSONObject;
        return jSONObject;
    }

    public void Mb(String str) {
        this.ljQ = str;
    }

    public void Mc(String str) {
        this.ljR = str;
    }

    public void Md(String str) {
        this.ljS = str;
    }

    public void Me(String str) {
        this.ljT = str;
    }

    public void Mf(String str) {
        this.ljU = str;
    }
}
