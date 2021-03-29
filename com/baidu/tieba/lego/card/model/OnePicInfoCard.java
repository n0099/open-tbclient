package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import d.b.i0.i1.o.j.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OnePicInfoCard extends BaseCardInfo {
    public final String desc;
    public final List<b> iconList;
    public final String pic;
    public final int tBgColor;
    public final int tBgColorN;
    public final String tag;

    public OnePicInfoCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.desc = jSONObject.optString("desc", "");
        this.pic = jSONObject.optString("pic");
        this.tag = jSONObject.optString("tag", "");
        this.tBgColor = d.b.i0.i1.o.k.b.b(jSONObject.optString("tBgColor", ""));
        this.tBgColorN = d.b.i0.i1.o.k.b.b(jSONObject.optString("tBgColorN", ""));
        JSONArray optJSONArray = jSONObject.optJSONArray("icons");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.iconList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                b bVar = new b();
                bVar.f55940c = optJSONObject.optInt("type");
                bVar.f55938a = optJSONObject.optString("url");
                bVar.f55939b = optJSONObject.optString("urlNight");
                bVar.f55941d = optJSONObject.optString("content", "");
                this.iconList.add(bVar);
            }
        }
    }

    public String getDesc() {
        return this.desc;
    }

    public List<b> getIconList() {
        return this.iconList;
    }

    public String getPic() {
        return this.pic;
    }

    public String getTag() {
        return this.tag;
    }

    public int gettBgColor() {
        return this.tBgColor;
    }

    public int gettBgColorN() {
        return this.tBgColorN;
    }
}
