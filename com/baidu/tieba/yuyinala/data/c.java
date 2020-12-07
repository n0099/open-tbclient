package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends g {
    public int aJg;
    public String aUg;
    public String cover;
    public int eKc;
    public ArrayList<a> gIP;
    public String liveId;
    public int rank;
    public String room_name;

    @Override // com.baidu.tieba.yuyinala.data.g
    public void parserJson(JSONObject jSONObject) {
        this.rank = jSONObject.optInt("rank");
        this.aJg = jSONObject.optInt(Config.EVENT_HEAT_POINT);
        this.aUg = jSONObject.optString("room_id");
        this.liveId = jSONObject.optString("live_id");
        this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
        this.cover = jSONObject.optString("cover");
        this.eKc = jSONObject.optInt("live_status");
        JSONArray optJSONArray = jSONObject.optJSONArray("bro_list");
        if (optJSONArray != null) {
            this.gIP = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a aVar = new a();
                aVar.parserJson(optJSONObject);
                this.gIP.add(aVar);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.data.g
    public String getNameShow() {
        return this.room_name;
    }

    /* loaded from: classes4.dex */
    public class a {
        public long bmv;
        public String portrait;
        public String uk;
        public String userName;
        public String userNickName;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.uk = jSONObject.optString("user_uk");
                this.userName = jSONObject.optString("user_name");
                this.userNickName = jSONObject.optString("user_nickname");
                this.portrait = jSONObject.optString("bd_portrait");
                this.bmv = jSONObject.optLong("charm_value");
            }
        }

        public String getNameShow() {
            return !StringHelper.isEmpty(this.userNickName) ? this.userNickName : this.userName;
        }
    }
}
