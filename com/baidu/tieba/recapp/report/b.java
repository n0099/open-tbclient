package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject iOB;
    private String iOD;
    private JSONObject iOE;
    private int iOF;
    private String iOG;
    private int iOH;
    private int iOI;
    private int iOJ;
    private int iOK;
    private int iOL;
    private int iOM;
    private String iON;
    private String iOO;
    private String iOP;
    private String iOQ;
    private String iOR;
    private String iOS;
    private String placeId;
    private int Sr = -1;
    private int St = -1;
    private int pageNumber = -1;
    private long iOC = System.currentTimeMillis() / 1000;

    public void Eu(String str) {
        this.extInfo = str;
    }

    public void zJ(int i) {
        this.Sr = i;
        if (this.iOE != null) {
            try {
                this.iOE.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void zK(int i) {
        this.St = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Ev(String str) {
        this.placeId = str;
    }

    public void Ew(String str) {
        this.iOD = str;
    }

    public void Ex(String str) {
    }

    public void zL(int i) {
        this.iOI = i;
    }

    public void zM(int i) {
        this.iOJ = i;
    }

    public void zN(int i) {
        this.iOK = i;
    }

    public void zO(int i) {
        this.iOL = i;
    }

    public void zP(int i) {
        this.iOM = i;
    }

    public void Ey(String str) {
        this.iON = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.St = com.baidu.adp.lib.g.b.f(downloadStaticsData.getAdPosition(), 0);
            this.iOD = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void eb(String str, String str2) {
        if (this.iOB == null) {
            this.iOB = new JSONObject();
        }
        try {
            this.iOB.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cjD() {
        if (this.iOE != null) {
            return this.iOE;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.St != -1) {
                jSONObject.put("da_locate", this.St);
            }
            if (this.Sr != -1) {
                jSONObject.put("da_type", this.Sr);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.iOC);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iOD);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iOF);
            jSONObject.put("ext3", this.iOH);
            jSONObject.put("ext2", this.iOG);
            jSONObject.put("da_ext1", this.iOI);
            jSONObject.put("da_ext2", this.iOJ);
            jSONObject.put("da_ext3", this.iOK);
            jSONObject.put("da_ext4", this.iOL);
            jSONObject.put("da_ext5", this.iOM);
            jSONObject.put("da_menu1", this.iOO);
            jSONObject.put("da_menu2", this.iOP);
            jSONObject.put("da_menu3", this.iOQ);
            jSONObject.put("da_page", this.iOR);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iON);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iOS);
        } catch (JSONException e) {
        }
        if (this.iOB != null) {
            try {
                jSONObject.put("ext", this.iOB);
            } catch (Exception e2) {
            }
        }
        this.iOE = jSONObject;
        return jSONObject;
    }

    public void Ez(String str) {
        this.iOO = str;
    }

    public void EA(String str) {
        this.iOP = str;
    }

    public void EB(String str) {
        this.iOQ = str;
    }

    public void EC(String str) {
        this.iOR = str;
    }

    public void ED(String str) {
        this.iOS = str;
    }
}
