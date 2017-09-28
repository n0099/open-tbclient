package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String aqx;
    private String eyk;
    private String eyl;
    private String eyn;
    private String eyo;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.aqx = jSONObject.optString("app_name", "");
                this.eyk = jSONObject.optString("app_desc", "");
                this.eyl = jSONObject.optString("p_name", "");
                this.eyn = jSONObject.optString("p_url", "");
                this.eyo = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
