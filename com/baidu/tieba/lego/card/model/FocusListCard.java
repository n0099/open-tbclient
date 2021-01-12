package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FocusListCard extends BaseCardInfo {
    private static final int MIN_FOCUS_ITEMS = 3;
    private final int bgColor;
    private final int bgColorNight;
    private final List<a> focusItemList;
    private final int titleColor;
    private final int titleColorNight;

    /* loaded from: classes8.dex */
    public static class a {
        public String kTD;
        public int kTE;
        public int kTF;
        public long kTG;
        public String scheme;
        public String statistics;
        public String subtitle;
        public String title;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusListCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONArray optJSONArray;
        this.titleColor = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("titleColor", ""));
        this.titleColorNight = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("titleColorNight", ""));
        this.bgColor = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("bgColor", ""));
        this.bgColorNight = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("bgColorNight", ""));
        JSONArray optJSONArray2 = jSONObject.optJSONArray("itemList");
        int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
        this.focusItemList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("strList")) != null && optJSONArray.length() != 0) {
                a aVar = new a();
                try {
                    if (optJSONArray.length() > 0) {
                        aVar.title = optJSONArray.getString(0);
                    }
                    if (optJSONArray.length() > 1) {
                        aVar.subtitle = optJSONArray.getString(1);
                    }
                    if (optJSONArray.length() > 2) {
                        aVar.kTD = optJSONArray.getString(2);
                    }
                    aVar.kTE = com.baidu.tieba.lego.card.c.b.rt(optJSONObject.optString("focusColor", ""));
                    aVar.kTF = com.baidu.tieba.lego.card.c.b.rt(optJSONObject.optString("focusColorNight", ""));
                    aVar.scheme = optJSONObject.optString("scheme");
                    aVar.kTG = optJSONObject.optLong("resourceId");
                    aVar.statistics = this.statistics;
                    this.focusItemList.add(aVar);
                } catch (Exception e) {
                }
            }
        }
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public int getTitleColorNight() {
        return this.titleColorNight;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public int getBgColorNight() {
        return this.bgColorNight;
    }

    public List<a> getFocusItemList() {
        return this.focusItemList;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return this.focusItemList.size() >= 3 && super.isValid();
    }
}
