package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fcc;
    private int fcd;
    private int fce;
    private long fcf = System.currentTimeMillis() / 1000;
    private String fcg;
    private JSONObject fch;
    private int fci;
    private int fcj;
    private int fck;
    private int fcl;
    private int fcm;
    private int fcn;
    private String fco;
    private String fcp;
    private String fcq;
    private String fcr;
    private String fcs;
    private int pageNumber;

    public void pe(String str) {
        this.extInfo = str;
    }

    public void qQ(int i) {
        this.fcd = i;
    }

    public void qR(int i) {
        this.fce = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pf(String str) {
        this.fcg = str;
    }

    public void qS(int i) {
        this.fcl = i;
    }

    public void qT(int i) {
        this.fcm = i;
    }

    public void qU(int i) {
        this.fcn = i;
    }

    public void pg(String str) {
        this.fco = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fce = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fcg = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bU(String str, String str2) {
        if (this.fcc == null) {
            this.fcc = new JSONObject();
        }
        try {
            this.fcc.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aZP() {
        if (this.fch != null) {
            return this.fch;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fce);
            jSONObject.put("da_type", this.fcd);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fcf);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fcg);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fci);
            jSONObject.put("ext3", this.fck);
            jSONObject.put("ext2", this.fcj);
            jSONObject.put("da_ext1", this.fcl);
            jSONObject.put("da_ext2", this.fcm);
            jSONObject.put("da_ext3", this.fcn);
            jSONObject.put("da_menu1", this.fcp);
            jSONObject.put("da_menu2", this.fcq);
            jSONObject.put("da_menu3", this.fcr);
            jSONObject.put("da_page", this.fcs);
            jSONObject.put("lego_extra", this.fco);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.fcc != null) {
            try {
                jSONObject.put("ext", this.fcc);
            } catch (Exception e2) {
            }
        }
        this.fch = jSONObject;
        return jSONObject;
    }

    public void ph(String str) {
        this.fcp = str;
    }

    public void pi(String str) {
        this.fcq = str;
    }

    public void pj(String str) {
        this.fcr = str;
    }

    public void pk(String str) {
        this.fcs = str;
    }
}
