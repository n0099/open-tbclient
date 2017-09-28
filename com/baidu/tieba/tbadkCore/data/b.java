package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String ggc;
    private String mDescription;
    private String mType;

    public String getDescription() {
        return this.mDescription;
    }

    public String bqT() {
        return this.ggc;
    }

    public String getType() {
        return this.mType;
    }

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.ggc = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mDescription = jSONObject.optString("desc");
                this.ggc = jSONObject.optString("link");
                this.mType = jSONObject.optString("type");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
