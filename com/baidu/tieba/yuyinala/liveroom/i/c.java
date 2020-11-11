package com.baidu.tieba.yuyinala.liveroom.i;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BaseData {
    public boolean aJj = true;
    public List<b> aJk;
    public int pn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.aJj = jSONObject.optInt("has_more") == 1;
            this.aJk = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("live");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length() && (optJSONObject = optJSONArray.optJSONObject(i)) != null; i++) {
                    b bVar = new b();
                    bVar.parserJson(optJSONObject);
                    this.aJk.add(bVar);
                }
            }
        }
    }
}
