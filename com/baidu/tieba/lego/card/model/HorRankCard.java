package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.lego.card.exception.CardParseException;
import d.b.j0.j1.o.j.c;
import d.b.j0.j1.o.k.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HorRankCard extends BaseCardInfo {
    public final double displayNum;
    public final String itemStatistics;
    public final int picType;
    public final int position;
    public List<a> rankInfoList;
    public final double ratio;
    public final c rightText;
    public final boolean scrollEnabled;
    public final boolean showLeft;
    public final boolean showSep;
    public final int titleColor;
    public final int titleColorNight;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f18290a;

        /* renamed from: b  reason: collision with root package name */
        public String f18291b;

        /* renamed from: c  reason: collision with root package name */
        public String f18292c;

        /* renamed from: d  reason: collision with root package name */
        public String f18293d;

        /* renamed from: e  reason: collision with root package name */
        public String f18294e;

        /* renamed from: f  reason: collision with root package name */
        public String f18295f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18296g;

        /* renamed from: h  reason: collision with root package name */
        public String f18297h;
        public String i;
        public String j;
        public int k;
        public int l;
        public HorRankCard m;
    }

    public HorRankCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.titleColor = b.b(jSONObject.optString("tColor", ""));
        this.titleColorNight = b.b(jSONObject.optString("tColorNight", ""));
        this.displayNum = jSONObject.optDouble("displayNum", 5.0d);
        this.ratio = jSONObject.optDouble("ratio", 1.0d);
        int optInt = jSONObject.optInt("picType", 1);
        if (optInt <= 0) {
            this.picType = 1;
        } else {
            this.picType = optInt;
        }
        this.scrollEnabled = jSONObject.optInt("scrollEnabled", 1) == 1;
        this.position = jSONObject.optInt("position");
        this.itemStatistics = jSONObject.optString("itemStatistics");
        this.showLeft = jSONObject.optInt("showLeft", 1) == 1;
        this.showSep = jSONObject.optInt("showSep") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("ranks");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.rankInfoList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            a aVar = new a();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            aVar.f18290a = optJSONObject.optInt("rank");
            aVar.f18291b = optJSONObject.optString("picUrl");
            aVar.f18292c = optJSONObject.optString("picIcon");
            aVar.f18293d = optJSONObject.optString("title");
            aVar.f18294e = optJSONObject.optString("subTitle");
            aVar.f18295f = optJSONObject.optString("postUrl");
            aVar.f18296g = optJSONObject.optInt("isDone") == 1;
            aVar.f18297h = optJSONObject.optString("btnText");
            aVar.i = optJSONObject.optString("btnDone");
            aVar.j = optJSONObject.optString("picScheme");
            aVar.k = b.b(optJSONObject.optString("bgColor", ""));
            aVar.l = b.b(optJSONObject.optString("bgColorNight", ""));
            optJSONObject.optLong("resourceId");
            aVar.m = this;
            this.rankInfoList.add(aVar);
        }
        this.rightText = c.a(jSONObject.optJSONObject("moreButton"));
    }

    public double getDisplayNum() {
        return this.displayNum;
    }

    public String getItemStatistics() {
        return this.itemStatistics;
    }

    public int getPicType() {
        return this.picType;
    }

    public int getPosition() {
        return this.position;
    }

    public List<a> getRankInfoList() {
        return this.rankInfoList;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    public c getRightText() {
        return this.rightText;
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public int getTitleColorNight() {
        return this.titleColorNight;
    }

    public boolean isScrollEnabled() {
        return this.scrollEnabled;
    }

    public boolean isShowLeft() {
        return this.showLeft;
    }

    public boolean isShowSep() {
        return this.showSep;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        boolean z2 = false;
        for (a aVar : this.rankInfoList) {
            if (!TextUtils.isEmpty(aVar.f18295f) && !TextUtils.isEmpty(aVar.f18297h) && !TextUtils.isEmpty(aVar.i) && TextUtils.equals(str, getFidFromPostUrl(aVar.f18295f))) {
                aVar.f18296g = z;
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        boolean z2 = false;
        for (a aVar : this.rankInfoList) {
            if (!TextUtils.isEmpty(aVar.f18295f) && !TextUtils.isEmpty(aVar.f18297h) && !TextUtils.isEmpty(aVar.i) && TextUtils.equals(getTouidFromPostUrl(aVar.f18295f), str)) {
                aVar.f18296g = z;
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return !ListUtils.isEmpty(this.rankInfoList);
    }
}
