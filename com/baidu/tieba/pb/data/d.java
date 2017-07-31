package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String appName;
    private String eDG;
    private String eDH;
    private String eDI;
    private String eDJ;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.appName = jSONObject.optString("app_name", "");
                this.eDG = jSONObject.optString("app_desc", "");
                this.eDH = jSONObject.optString("p_name", "");
                this.eDI = jSONObject.optString("p_url", "");
                this.eDJ = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
