package com.baidu.tieba.write.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private final ArrayList<MetaData> dkT = new ArrayList<>();

    public void a(JSONObject jSONObject, HashMap<String, String> hashMap) {
        String str;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("uname");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    MetaData metaData = new MetaData();
                    String optString = optJSONArray.optString(i2);
                    metaData.setUserName(optString);
                    metaData.setName_show(optString);
                    if (hashMap != null && (str = hashMap.get(metaData.getUserName())) != null) {
                        metaData.setPortrait(str);
                    }
                    this.dkT.add(metaData);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void a(String str, HashMap<String, String> hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void i(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dkT.size()) {
                    MetaData metaData = this.dkT.get(i2);
                    metaData.setPortrait(hashMap.get(metaData.getUserName()));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ArrayList<MetaData> aBB() {
        return this.dkT;
    }
}
