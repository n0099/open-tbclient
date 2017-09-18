package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String arp;
    private String eEQ;
    private String eER;
    private String eES;
    private String eET;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.arp = jSONObject.optString("app_name", "");
                this.eEQ = jSONObject.optString("app_desc", "");
                this.eER = jSONObject.optString("p_name", "");
                this.eES = jSONObject.optString("p_url", "");
                this.eET = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
