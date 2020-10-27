package com.baidu.yuyinala.privatemessage.model.http;

import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaAudioUserGetPaBindInfoResponseMessage extends JsonHttpResponsedMessage {
    public String uk;

    public YuyinAlaAudioUserGetPaBindInfoResponseMessage() {
        super(1031067);
        this.uk = "";
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        try {
            this.uk = jSONObject.optJSONObject("data").optJSONObject("list").optString("uk");
        } catch (Exception e) {
            LogUtils.e("YuyinAlaAudioUserGetPaBindInfo", BdStatsConstant.StatsType.ERROR);
        }
    }
}
