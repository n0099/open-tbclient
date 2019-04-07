package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {
    public String izb;
    public String link;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.izb = jSONObject.optString("banner");
                this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
