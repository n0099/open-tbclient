package com.baidu.tieba.recommendlist.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends BaseData {
    public String msg;
    public String type;

    public c(String str) {
        if (!TextUtils.isEmpty(str)) {
            parserJson(str);
        }
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optString("type");
            this.msg = jSONObject.optString("msg");
        }
    }
}
