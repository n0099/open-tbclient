package com.baidu.tieba.yuyinala.liveroom.k;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends BaseData {
    public boolean aFV = true;
    public List<b> aFW;
    public int pn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.aFV = jSONObject.optInt("has_more") == 1;
            this.aFW = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("live");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length() && (optJSONObject = optJSONArray.optJSONObject(i)) != null; i++) {
                    b bVar = new b();
                    bVar.parserJson(optJSONObject);
                    this.aFW.add(bVar);
                }
            }
        }
    }
}
