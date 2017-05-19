package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String aoQ;
    private String ecQ;
    private String ecR;
    private String ecS;
    private String ecT;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.aoQ = jSONObject.optString("app_name", "");
                this.ecQ = jSONObject.optString("app_desc", "");
                this.ecR = jSONObject.optString("p_name", "");
                this.ecS = jSONObject.optString("p_url", "");
                this.ecT = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
