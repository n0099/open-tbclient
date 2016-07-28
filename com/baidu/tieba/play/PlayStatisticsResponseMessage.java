package com.baidu.tieba.play;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PlayStatisticsResponseMessage extends JsonHttpResponsedMessage {
    public PlayStatisticsResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        jSONObject.toString();
    }
}
