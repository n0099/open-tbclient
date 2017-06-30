package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String apB;
    private String erk;
    private String erl;
    private String erm;
    private String ern;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.apB = jSONObject.optString("app_name", "");
                this.erk = jSONObject.optString("app_desc", "");
                this.erl = jSONObject.optString("p_name", "");
                this.erm = jSONObject.optString("p_url", "");
                this.ern = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
