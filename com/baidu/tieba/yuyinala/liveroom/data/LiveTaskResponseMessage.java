package com.baidu.tieba.yuyinala.liveroom.data;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveTaskResponseMessage extends JsonHttpResponsedMessage {
    public String btnText;
    public long hBV;
    public int hBW;
    public String hBX;
    public String hBY;
    public String message;
    public String scheme;
    public String url;

    public LiveTaskResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.message = optJSONObject.optString("message");
                this.btnText = optJSONObject.optString("btnText");
                this.hBV = optJSONObject.optLong("toastDuration");
                this.url = optJSONObject.optString("url");
                this.scheme = optJSONObject.optString("schema");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject2 != null) {
                this.hBW = optJSONObject2.optInt(BaseJsonData.TAG_ERRNO);
                this.hBX = optJSONObject2.optString(BaseJsonData.TAG_ERRMSG);
                this.hBY = optJSONObject2.optString("usermsg");
            }
        }
    }
}
