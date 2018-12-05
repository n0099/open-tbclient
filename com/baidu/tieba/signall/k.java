package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String hdy;
    public String link;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hdy = jSONObject.optString("banner");
                this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
