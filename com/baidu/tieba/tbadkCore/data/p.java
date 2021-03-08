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
    public List<AbstractData> ePV = new ArrayList();
    public String id;
    public MetaData nAm;

    public void parseJson(JSONObject jSONObject) {
        try {
            this.id = jSONObject.optString("id");
            this.nAm = new MetaData();
            this.nAm.parserJson(jSONObject.optJSONObject("author"));
            JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
            this.ePV = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray.getJSONObject(i));
                    this.ePV.add(abstractData);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
