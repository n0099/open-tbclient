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
    private String bpK;
    private int mFaceShopVersion;
    private int bpN = 0;
    private VersionData bpH = new VersionData();
    private com.baidu.tieba.data.d bpI = new com.baidu.tieba.data.d();
    private com.baidu.tieba.data.f bpJ = new com.baidu.tieba.data.f();
    private CombineDownload bpL = new CombineDownload();
    private ai bpM = new ai();

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
                this.bpH.parserJson(jSONObject.optJSONObject("version"));
                this.bpI.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.util.a.uR().parserJson(jSONObject.optJSONObject("ad_config"));
                com.baidu.tbadk.core.util.j.setIp(jSONObject.optString("client_ip", null));
                this.bpJ.parserJson(jSONObject.optJSONObject("config"));
                this.bpK = jSONObject.optString("config_version");
                this.bpL.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bpM.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bpN = jSONObject.optInt("sync_active", 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001145, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkApplication.m251getInst().getFaceShopVersion()) {
                    TbadkApplication.m251getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkApplication.m251getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    com.baidu.tieba.aj.wk().ee(optJSONObject.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tieba.data.f TX() {
        return this.bpJ;
    }

    public String TY() {
        return this.bpK;
    }

    public CombineDownload TZ() {
        return this.bpL;
    }

    public VersionData Ua() {
        return this.bpH;
    }

    public com.baidu.tieba.data.d Ub() {
        return this.bpI;
    }
}
