package com.baidu.tieba.write.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private final ArrayList<MetaData> nZV = new ArrayList<>();
    private HashMap<String, String> nZW = null;

    public void j(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (z) {
                try {
                    if (this.nZW == null) {
                        this.nZW = new HashMap<>();
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
                        this.nZV.add(metaData);
                        if (z) {
                            this.nZW.put(metaData.getName_show(), metaData.getPortrait());
                        }
                    }
                }
            }
        }
    }

    public void Vm(String str) {
        try {
            j(new JSONObject(str), true);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public ArrayList<MetaData> dYH() {
        return this.nZV;
    }
}
