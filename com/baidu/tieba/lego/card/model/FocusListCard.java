package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class FocusListCard extends BaseCardInfo {
    private static final int MIN_FOCUS_ITEMS = 3;
    private final int bgColor;
    private final int bgColorNight;
    private final List<a> focusItemList;
    private final int titleColor;
    private final int titleColorNight;

    /* loaded from: classes9.dex */
    public static class a {
        public String kYi;
        public int kYj;
        public int kYk;
        public long kYl;
        public String scheme;
        public String statistics;
        public String subtitle;
        public String title;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusListCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONArray optJSONArray;
        this.titleColor = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("titleColor", ""));
        this.titleColorNight = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("titleColorNight", ""));
        this.bgColor = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("bgColor", ""));
        this.bgColorNight = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("bgColorNight", ""));
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
                        aVar.kYi = optJSONArray.getString(2);
                    }
                    aVar.kYj = com.baidu.tieba.lego.card.c.b.sF(optJSONObject.optString("focusColor", ""));
                    aVar.kYk = com.baidu.tieba.lego.card.c.b.sF(optJSONObject.optString("focusColorNight", ""));
                    aVar.scheme = optJSONObject.optString("scheme");
                    aVar.kYl = optJSONObject.optLong("resourceId");
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
