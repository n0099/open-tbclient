package com.baidu.tieba.majorsearch.c;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes18.dex */
public class a {
    public List<String> jXD;

    public void parseJson(JSONArray jSONArray) {
        this.jXD = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!StringUtils.isNull(optString)) {
                    this.jXD.add(optString);
                }
            }
        }
    }
}
