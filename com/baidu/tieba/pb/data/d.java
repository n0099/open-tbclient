package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends PostData {
    private String aqs;
    private String eCt;
    private String eCu;
    private String eCv;
    private String eCw;
    private String imgUrl;
    private int pos;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pos = jSONObject.optInt("pos", 1);
                this.aqs = jSONObject.optString("app_name", "");
                this.eCt = jSONObject.optString("app_desc", "");
                this.eCu = jSONObject.optString("p_name", "");
                this.eCv = jSONObject.optString("p_url", "");
                this.eCw = jSONObject.optString("web_url", "");
                this.imgUrl = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
