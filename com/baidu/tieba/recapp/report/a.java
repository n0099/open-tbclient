package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fdJ;
    private String fdK;
    private int fdL;
    private String fdO;
    private JSONObject fdP;
    private int fdQ;
    private int fdR;
    private int fdS;
    private String fdT;
    private int pageNumber;
    private long fdN = System.currentTimeMillis() / 1000;
    private int fdM = i.gs();

    public void qG(String str) {
        this.extInfo = str;
    }

    public void qH(String str) {
        this.fdK = str;
    }

    public void qR(int i) {
        this.fdL = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void qI(String str) {
        this.fdO = str;
    }

    public void qS(int i) {
        this.fdQ = i;
    }

    public void qT(int i) {
        this.fdR = i;
    }

    public void qU(int i) {
        this.fdS = i;
    }

    public void qJ(String str) {
        this.fdT = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fdL = com.baidu.adp.lib.h.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fdO = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bN(String str, String str2) {
        if (this.fdJ == null) {
            this.fdJ = new JSONObject();
        }
        try {
            this.fdJ.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bcd() {
        if (this.fdP != null) {
            return this.fdP;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fdL);
            jSONObject.put("da_type", this.fdK);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fdN);
            jSONObject.put("net_type", this.fdM);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.fdO);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("action_type", this.fdQ);
            jSONObject.put("total_dur", this.fdR);
            jSONObject.put("play_dur", this.fdS);
            jSONObject.put("lego_extra", this.fdT);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("fid", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.fdJ != null) {
            try {
                jSONObject.put("ext", this.fdJ);
            } catch (Exception e2) {
            }
        }
        this.fdP = jSONObject;
        return jSONObject;
    }
}
