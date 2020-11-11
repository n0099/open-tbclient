package com.baidu.tieba.yuyinala.liveroom.roomcard;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.yuyinala.liveroom.roomcard.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRoomCardInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private e nZj;

    public e dYp() {
        return this.nZj;
    }

    public AlaGetRoomCardInfoHttpResponseMessage() {
        super(1031019);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031019) {
            if (this.nZj == null) {
                this.nZj = new e();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.nZj.nZp = optJSONObject.optInt("room_editor_show");
                this.nZj.nZq = optJSONObject.optInt("room_ban_show");
                this.nZj.nZr = optJSONObject.optString("room_unfollow_copywriting");
                this.nZj.nZs = optJSONObject.optInt("room_follow_status");
                this.nZj.nZv = optJSONObject.optInt("room_fans");
                this.nZj.nZw = optJSONObject.optInt(UbcStatConstant.KEY_CUSTOM_ROOM_ID);
                this.nZj.nZx = optJSONObject.optString("room_cover");
                this.nZj.room_name = optJSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
                if (optJSONObject.has("room_host") && (optJSONArray2 = optJSONObject.optJSONArray("room_host")) != null && optJSONArray2.length() > 0) {
                    this.nZj.nZt = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray2.get(i2);
                        e.a aVar = new e.a();
                        aVar.nZz = jSONObject2.optString("user_cover");
                        aVar.nZy = jSONObject2.optInt("user_Identity");
                        aVar.user_name = jSONObject2.optString("user_name");
                        aVar.user_uk = jSONObject2.optString("user_uk");
                        aVar.nZA = false;
                        this.nZj.nZt.add(aVar);
                    }
                }
                if (optJSONObject.has("room_manage") && (optJSONArray = optJSONObject.optJSONArray("room_manage")) != null && optJSONArray.length() > 0) {
                    this.nZj.nZu = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i3);
                        e.a aVar2 = new e.a();
                        aVar2.nZz = jSONObject3.optString("user_cover");
                        aVar2.nZy = jSONObject3.optInt("user_Identity");
                        aVar2.user_name = jSONObject3.optString("user_name");
                        aVar2.user_uk = jSONObject3.optString("user_uk");
                        aVar2.nZA = false;
                        this.nZj.nZu.add(aVar2);
                    }
                }
            }
        }
    }
}
