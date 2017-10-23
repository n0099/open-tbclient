package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String aql;
    private String exW;
    private String exX;
    private String exY;
    private String exZ;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.aql = jSONObject.optString("app_name", "");
                this.exW = jSONObject.optString("app_desc", "");
                this.exX = jSONObject.optString("p_name", "");
                this.exY = jSONObject.optString("p_url", "");
                this.exZ = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
