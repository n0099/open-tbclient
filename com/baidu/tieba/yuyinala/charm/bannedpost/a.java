package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends BaseData {
    public List<C0909a> aEK;

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0909a {
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
                this.aEK = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                    C0909a c0909a = new C0909a();
                    c0909a.user_name = optJSONObject2.optString("user_name");
                    c0909a.user_nickname = optJSONObject2.optString("user_nickname");
                    c0909a.bd_portrait = optJSONObject2.optString("bd_portrait");
                    c0909a.uk = optJSONObject2.optString("uk");
                    this.aEK.add(c0909a);
                }
            }
        }
    }
}
