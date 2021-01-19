package com.baidu.tieba.yuyinala.liveroom.roomcard;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.yuyinala.liveroom.roomcard.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetRoomCardInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private e ooz;

    public e dZu() {
        return this.ooz;
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
            if (this.ooz == null) {
                this.ooz = new e();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.ooz.ooF = optJSONObject.optInt("room_editor_show");
                this.ooz.ooG = optJSONObject.optInt("room_ban_show");
                this.ooz.ooH = optJSONObject.optString("room_unfollow_copywriting");
                this.ooz.ooI = optJSONObject.optInt("room_follow_status");
                this.ooz.ooL = optJSONObject.optInt("room_fans");
                this.ooz.ooM = optJSONObject.optInt(UbcStatConstant.KEY_CUSTOM_ROOM_ID);
                this.ooz.ooN = optJSONObject.optString("room_cover");
                this.ooz.room_name = optJSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
                if (optJSONObject.has("room_host") && (optJSONArray2 = optJSONObject.optJSONArray("room_host")) != null && optJSONArray2.length() > 0) {
                    this.ooz.ooJ = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray2.get(i2);
                        e.a aVar = new e.a();
                        aVar.ooP = jSONObject2.optString("user_cover");
                        aVar.ooO = jSONObject2.optInt("user_Identity");
                        aVar.user_name = jSONObject2.optString("user_name");
                        aVar.user_uk = jSONObject2.optString("user_uk");
                        aVar.ooQ = false;
                        this.ooz.ooJ.add(aVar);
                    }
                }
                if (optJSONObject.has("room_manage") && (optJSONArray = optJSONObject.optJSONArray("room_manage")) != null && optJSONArray.length() > 0) {
                    this.ooz.ooK = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i3);
                        e.a aVar2 = new e.a();
                        aVar2.ooP = jSONObject3.optString("user_cover");
                        aVar2.ooO = jSONObject3.optInt("user_Identity");
                        aVar2.user_name = jSONObject3.optString("user_name");
                        aVar2.user_uk = jSONObject3.optString("user_uk");
                        aVar2.ooQ = false;
                        this.ooz.ooK.add(aVar2);
                    }
                }
            }
        }
    }
}
