package com.baidu.yuyinala.more.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private String mTitle;
    private List<a> oXd;

    public String getTitle() {
        return this.mTitle;
    }

    public List<a> ejy() {
        return this.oXd;
    }

    public void parse(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.mTitle = jSONObject.optString("title");
            JSONArray optJSONArray = jSONObject.optJSONArray("btn_list");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.oXd = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    a aVar = new a();
                    aVar.parse(optJSONArray.optJSONObject(i));
                    this.oXd.add(aVar);
                }
            }
        }
    }
}
