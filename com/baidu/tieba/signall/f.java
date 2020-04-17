package com.baidu.tieba.signall;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public String dmq;
    public String kJx;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, TiebaInitialize.LogFields.REASON, "null");
            return;
        }
        try {
            this.kJx = jSONObject.optString("banner_pic");
            this.dmq = jSONObject.optString("banner_url");
        } catch (Exception e) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, TiebaInitialize.LogFields.REASON, e.toString());
            BdLog.e(e.getMessage());
        }
    }
}
