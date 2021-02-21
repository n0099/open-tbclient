package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public boolean gSN;
    public ArrayList<a> gSO;
    public long gSu;
    public String portrait;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("send_user");
        if (optJSONObject != null) {
            this.userName = optJSONObject.optString("user_name");
            this.portrait = optJSONObject.optString("bd_portrait");
        }
        this.gSN = jSONObject.optInt("loot_result") == 1;
        this.gSu = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        JSONArray optJSONArray = jSONObject.optJSONArray("loot_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            this.gSO = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                if (jSONObject2 != null) {
                    a aVar = new a();
                    aVar.parserJson(jSONObject2);
                    this.gSO.add(aVar);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public long amount;
        public String portrait;
        public String userId;
        public String userName;

        public void parserJson(JSONObject jSONObject) {
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("bd_portrait");
            this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
