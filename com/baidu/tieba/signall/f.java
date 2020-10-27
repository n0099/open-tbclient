package com.baidu.tieba.signall;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class f {
    public String esW;
    public String mHU;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, TiebaInitialize.LogFields.REASON, "null");
            return;
        }
        try {
            this.mHU = jSONObject.optString("banner_pic");
            this.esW = jSONObject.optString("banner_url");
        } catch (Exception e) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, TiebaInitialize.LogFields.REASON, e.toString());
            BdLog.e(e.getMessage());
        }
    }
}
