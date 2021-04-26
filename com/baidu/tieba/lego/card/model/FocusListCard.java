package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import d.a.j0.j1.o.k.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FocusListCard extends BaseCardInfo {
    public static final int MIN_FOCUS_ITEMS = 3;
    public final int bgColor;
    public final int bgColorNight;
    public final List<a> focusItemList;
    public final int titleColor;
    public final int titleColorNight;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18639a;

        /* renamed from: b  reason: collision with root package name */
        public String f18640b;

        /* renamed from: c  reason: collision with root package name */
        public String f18641c;

        /* renamed from: d  reason: collision with root package name */
        public int f18642d;

        /* renamed from: e  reason: collision with root package name */
        public int f18643e;

        /* renamed from: f  reason: collision with root package name */
        public String f18644f;

        /* renamed from: g  reason: collision with root package name */
        public long f18645g;
    }

    public FocusListCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONArray optJSONArray;
        this.titleColor = b.b(jSONObject.optString("titleColor", ""));
        this.titleColorNight = b.b(jSONObject.optString("titleColorNight", ""));
        this.bgColor = b.b(jSONObject.optString("bgColor", ""));
        this.bgColorNight = b.b(jSONObject.optString("bgColorNight", ""));
        JSONArray optJSONArray2 = jSONObject.optJSONArray("itemList");
        int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
        this.focusItemList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("strList")) != null && optJSONArray.length() != 0) {
                a aVar = new a();
                try {
                    if (optJSONArray.length() > 0) {
                        aVar.f18639a = optJSONArray.getString(0);
                    }
                    if (optJSONArray.length() > 1) {
                        aVar.f18640b = optJSONArray.getString(1);
                    }
                    if (optJSONArray.length() > 2) {
                        aVar.f18641c = optJSONArray.getString(2);
                    }
                    aVar.f18642d = b.b(optJSONObject.optString("focusColor", ""));
                    aVar.f18643e = b.b(optJSONObject.optString("focusColorNight", ""));
                    aVar.f18644f = optJSONObject.optString("scheme");
                    aVar.f18645g = optJSONObject.optLong("resourceId");
                    this.focusItemList.add(aVar);
                } catch (Exception unused) {
                }
            }
        }
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

    public int getTitleColor() {
        return this.titleColor;
    }

    public int getTitleColorNight() {
        return this.titleColorNight;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return this.focusItemList.size() >= 3 && super.isValid();
    }
}
