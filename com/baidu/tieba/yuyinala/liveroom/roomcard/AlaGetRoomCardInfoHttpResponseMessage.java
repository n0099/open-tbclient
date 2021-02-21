package com.baidu.tieba.yuyinala.liveroom.roomcard;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.yuyinala.liveroom.roomcard.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetRoomCardInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private e oyP;

    public e ebP() {
        return this.oyP;
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
            if (this.oyP == null) {
                this.oyP = new e();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.oyP.oyV = optJSONObject.optInt("room_editor_show");
                this.oyP.oyW = optJSONObject.optInt("room_ban_show");
                this.oyP.oyX = optJSONObject.optString("room_unfollow_copywriting");
                this.oyP.oyY = optJSONObject.optInt("room_follow_status");
                this.oyP.ozb = optJSONObject.optInt("room_fans");
                this.oyP.ozc = optJSONObject.optLong(UbcStatConstant.KEY_CUSTOM_ROOM_ID);
                this.oyP.ozd = optJSONObject.optString("room_cover");
                this.oyP.room_name = optJSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
                if (optJSONObject.has("room_host") && (optJSONArray2 = optJSONObject.optJSONArray("room_host")) != null && optJSONArray2.length() > 0) {
                    this.oyP.oyZ = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray2.get(i2);
                        e.a aVar = new e.a();
                        aVar.ozf = jSONObject2.optString("user_cover");
                        aVar.oze = jSONObject2.optInt("user_Identity");
                        aVar.user_name = jSONObject2.optString("user_name");
                        aVar.user_uk = jSONObject2.optString("user_uk");
                        aVar.ozg = false;
                        this.oyP.oyZ.add(aVar);
                    }
                }
                if (optJSONObject.has("room_manage") && (optJSONArray = optJSONObject.optJSONArray("room_manage")) != null && optJSONArray.length() > 0) {
                    this.oyP.oza = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i3);
                        e.a aVar2 = new e.a();
                        aVar2.ozf = jSONObject3.optString("user_cover");
                        aVar2.oze = jSONObject3.optInt("user_Identity");
                        aVar2.user_name = jSONObject3.optString("user_name");
                        aVar2.user_uk = jSONObject3.optString("user_uk");
                        aVar2.ozg = false;
                        this.oyP.oza.add(aVar2);
                    }
                }
            }
        }
    }
}
