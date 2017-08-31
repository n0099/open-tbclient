package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String ars;
    private String eDW;
    private String eDX;
    private String eDY;
    private String eDZ;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.ars = jSONObject.optString("app_name", "");
                this.eDW = jSONObject.optString("app_desc", "");
                this.eDX = jSONObject.optString("p_name", "");
                this.eDY = jSONObject.optString("p_url", "");
                this.eDZ = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
