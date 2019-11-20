package com.baidu.tieba.tbadvert.a;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public List<b> jlK;
    public List<b> jlL;

    public void parserJsonStr(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                parserJson(jSONObject);
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("splash_schedule")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("current");
            if (optJSONArray != null) {
                this.jlK = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    b bVar = new b();
                    bVar.parserJson(optJSONArray.optJSONObject(i));
                    this.jlK.add(bVar);
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
            if (optJSONArray != null) {
                this.jlL = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    b bVar2 = new b();
                    bVar2.parserJson(optJSONArray2.optJSONObject(i2));
                    this.jlL.add(bVar2);
                }
            }
        }
    }
}
