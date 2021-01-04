package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BaseData {
    public List<C0888a> aJx;

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0888a {
        public String bd_portrait;
        public String uk;
        public String user_name;
        public String user_nickname;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null && jSONObject.has("data")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject.has("ban_list")) {
                jSONArray = optJSONObject.optJSONArray("ban_list");
            } else if (!optJSONObject.has("ban_forever_list")) {
                jSONArray = null;
            } else {
                jSONArray = optJSONObject.optJSONArray("ban_forever_list");
            }
            if (jSONArray != null) {
                this.aJx = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                    C0888a c0888a = new C0888a();
                    c0888a.user_name = optJSONObject2.optString("user_name");
                    c0888a.user_nickname = optJSONObject2.optString("user_nickname");
                    c0888a.bd_portrait = optJSONObject2.optString("bd_portrait");
                    c0888a.uk = optJSONObject2.optString("uk");
                    this.aJx.add(c0888a);
                }
            }
        }
    }
}
