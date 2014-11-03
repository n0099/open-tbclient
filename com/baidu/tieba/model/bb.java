package com.baidu.tieba.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private String bpY;
    private int mFaceShopVersion;
    private int bqb = 0;
    private VersionData bpV = new VersionData();
    private com.baidu.tieba.data.d bpW = new com.baidu.tieba.data.d();
    private com.baidu.tieba.data.f bpX = new com.baidu.tieba.data.f();
    private CombineDownload bpZ = new CombineDownload();
    private ai bqa = new ai();

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bpV.parserJson(jSONObject.optJSONObject("version"));
                this.bpW.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.util.a.uT().parserJson(jSONObject.optJSONObject("ad_config"));
                com.baidu.tbadk.core.util.j.setIp(jSONObject.optString("client_ip", null));
                this.bpX.parserJson(jSONObject.optJSONObject("config"));
                this.bpY = jSONObject.optString("config_version");
                this.bpZ.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bqa.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bqb = jSONObject.optInt("sync_active", 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001145, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkApplication.m251getInst().getFaceShopVersion()) {
                    TbadkApplication.m251getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkApplication.m251getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    com.baidu.tieba.aj.wm().ee(optJSONObject.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tieba.data.f Ua() {
        return this.bpX;
    }

    public String Ub() {
        return this.bpY;
    }

    public CombineDownload Uc() {
        return this.bpZ;
    }

    public VersionData Ud() {
        return this.bpV;
    }

    public com.baidu.tieba.data.d Ue() {
        return this.bpW;
    }
}
