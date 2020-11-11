package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BaseData {
    public List<C0894a> aIb;

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0894a {
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
                this.aIb = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                    C0894a c0894a = new C0894a();
                    c0894a.user_name = optJSONObject2.optString("user_name");
                    c0894a.user_nickname = optJSONObject2.optString("user_nickname");
                    c0894a.bd_portrait = optJSONObject2.optString("bd_portrait");
                    c0894a.uk = optJSONObject2.optString("uk");
                    this.aIb.add(c0894a);
                }
            }
        }
    }
}
