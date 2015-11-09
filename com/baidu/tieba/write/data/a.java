package com.baidu.tieba.write.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private final ArrayList<MetaData> dmY = new ArrayList<>();
    private HashMap<String, String> dmZ = null;

    public void c(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (z) {
                try {
                    if (this.dmZ == null) {
                        this.dmZ = new HashMap<>();
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MetaData metaData = new MetaData();
                    metaData.parserJson(optJSONArray.getJSONObject(i));
                    if (!TextUtils.isEmpty(metaData.getName_show())) {
                        this.dmY.add(metaData);
                        if (z) {
                            this.dmZ.put(metaData.getName_show(), metaData.getPortrait());
                        }
                    }
                }
            }
        }
    }

    public void mt(String str) {
        try {
            c(new JSONObject(str), true);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public ArrayList<MetaData> aCu() {
        return this.dmY;
    }

    public HashMap<String, String> aCv() {
        return this.dmZ;
    }
}
