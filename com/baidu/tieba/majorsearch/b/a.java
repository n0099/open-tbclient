package com.baidu.tieba.majorsearch.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class a {
    public List<String> lhe;

    public void parseJson(JSONArray jSONArray) {
        this.lhe = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!StringUtils.isNull(optString)) {
                    this.lhe.add(optString);
                }
            }
        }
    }
}
