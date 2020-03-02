package com.baidu.tieba.signall;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public String cMY;
    public String jYw;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, TiebaInitialize.LogFields.REASON, "null");
            return;
        }
        try {
            this.jYw = jSONObject.optString("banner_pic");
            this.cMY = jSONObject.optString("banner_url");
        } catch (Exception e) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, TiebaInitialize.LogFields.REASON, e.toString());
            BdLog.e(e.getMessage());
        }
    }
}
