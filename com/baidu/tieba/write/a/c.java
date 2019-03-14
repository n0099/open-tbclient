package com.baidu.tieba.write.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private final ArrayList<MetaData> joI = new ArrayList<>();

    public void a(JSONObject jSONObject, b bVar) {
        String str;
        HashMap<String, String> cpt = bVar.cpt();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    MetaData metaData = new MetaData();
                    metaData.parserJson(optJSONArray.getJSONObject(i2));
                    metaData.setName_show(metaData.getUserName());
                    if (cpt != null && (str = cpt.get(metaData.getUserName())) != null) {
                        metaData.setPortrait(str);
                    }
                    this.joI.add(metaData);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void a(String str, b bVar) {
        try {
            a(new JSONObject(str), bVar);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void v(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.joI.size()) {
                    MetaData metaData = this.joI.get(i2);
                    metaData.setPortrait(hashMap.get(metaData.getUserName()));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ArrayList<MetaData> cpu() {
        return this.joI;
    }
}
