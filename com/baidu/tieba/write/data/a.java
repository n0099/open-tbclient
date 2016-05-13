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
    private final ArrayList<MetaData> eYW = new ArrayList<>();
    private HashMap<String, String> eYX = null;

    public void c(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (z) {
                try {
                    if (this.eYX == null) {
                        this.eYX = new HashMap<>();
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
                        this.eYW.add(metaData);
                        if (z) {
                            this.eYX.put(metaData.getName_show(), metaData.getPortrait());
                        }
                    }
                }
            }
        }
    }

    public void pe(String str) {
        try {
            c(new JSONObject(str), true);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public ArrayList<MetaData> bbS() {
        return this.eYW;
    }

    public HashMap<String, String> bbT() {
        return this.eYX;
    }
}
