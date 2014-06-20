package com.baidu.tieba.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bc {
    private int f;
    private int g = 0;
    private VersionData a = new VersionData();
    private com.baidu.tieba.data.c b = new com.baidu.tieba.data.c();
    private com.baidu.tieba.data.e c = new com.baidu.tieba.data.e();
    private CombineDownload d = new CombineDownload();
    private ah e = new ah();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.parserJson(jSONObject.optJSONObject("version"));
                this.b.a(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.b.a.a().a(jSONObject.optJSONObject("ad_config"));
                com.baidu.tbadk.core.util.n.a(jSONObject.optString("client_ip", null));
                this.c.a(jSONObject.optJSONObject("config"));
                this.d.parserJson(jSONObject.optJSONObject("combine_download"));
                this.e.a(jSONObject.optJSONObject("mainbar"));
                this.g = jSONObject.optInt("sync_active", 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageTypes.CMD_ADS_EMOTION, jSONObject));
                this.f = jSONObject.optInt("faceshop_version");
                if (this.f > TbadkApplication.m252getInst().getFaceShopVersion()) {
                    TbadkApplication.m252getInst().setTempFaceShopVersion(this.f);
                    TbadkApplication.m252getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    com.baidu.tieba.ai.c().m(optJSONObject.toString());
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public com.baidu.tieba.data.e a() {
        return this.c;
    }

    public CombineDownload b() {
        return this.d;
    }

    public VersionData c() {
        return this.a;
    }

    public com.baidu.tieba.data.c d() {
        return this.b;
    }
}
