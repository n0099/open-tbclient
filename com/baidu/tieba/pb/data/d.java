package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String appName;
    private String eFC;
    private String eFD;
    private String eFE;
    private String eFF;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.appName = jSONObject.optString("app_name", "");
                this.eFC = jSONObject.optString("app_desc", "");
                this.eFD = jSONObject.optString("p_name", "");
                this.eFE = jSONObject.optString("p_url", "");
                this.eFF = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
