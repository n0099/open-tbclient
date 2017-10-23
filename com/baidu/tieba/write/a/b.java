package com.baidu.tieba.write.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private final ArrayList<MetaData> gIi = new ArrayList<>();
    private HashMap<String, String> gIj = null;

    public void c(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (z) {
                try {
                    if (this.gIj == null) {
                        this.gIj = new HashMap<>();
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(StoryPageActivityConfig.USER_LIST);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MetaData metaData = new MetaData();
                    metaData.parserJson(optJSONArray.getJSONObject(i));
                    if (!TextUtils.isEmpty(metaData.getName_show())) {
                        this.gIi.add(metaData);
                        if (z) {
                            this.gIj.put(metaData.getName_show(), metaData.getPortrait());
                        }
                    }
                }
            }
        }
    }

    public void tc(String str) {
        try {
            c(new JSONObject(str), true);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public ArrayList<MetaData> bzJ() {
        return this.gIi;
    }

    public HashMap<String, String> bzK() {
        return this.gIj;
    }
}
