package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class OnePicInfoCard extends BaseCardInfo {
    private final String desc;
    private final List<b> iconList;
    private final String pic;
    private final int tBgColor;
    private final int tBgColorN;
    private final String tag;

    public List<b> getIconList() {
        return this.iconList;
    }

    public String getDesc() {
        return this.desc;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePicInfoCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.desc = jSONObject.optString("desc", "");
        this.pic = jSONObject.optString("pic");
        this.tag = jSONObject.optString("tag", "");
        this.tBgColor = com.baidu.tieba.lego.card.c.b.rM(jSONObject.optString("tBgColor", ""));
        this.tBgColorN = com.baidu.tieba.lego.card.c.b.rM(jSONObject.optString("tBgColorN", ""));
        JSONArray optJSONArray = jSONObject.optJSONArray("icons");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.iconList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                b bVar = new b();
                bVar.type = optJSONObject.optInt("type");
                bVar.url = optJSONObject.optString("url");
                bVar.lcb = optJSONObject.optString("urlNight");
                bVar.content = optJSONObject.optString("content", "");
                this.iconList.add(bVar);
            }
        }
    }
}
