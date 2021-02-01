package com.baidu.tieba.tbadkCore.data;

import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.tbadk.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    public List<AbstractData> eOu = new ArrayList();
    public String id;
    public MetaData nxH;

    public void parseJson(JSONObject jSONObject) {
        try {
            this.id = jSONObject.optString("id");
            this.nxH = new MetaData();
            this.nxH.parserJson(jSONObject.optJSONObject("author"));
            JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
            this.eOu = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray.getJSONObject(i));
                    this.eOu.add(abstractData);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
