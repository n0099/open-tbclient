package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.lego.card.exception.CardParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HorRankCard extends BaseCardInfo {
    private final double displayNum;
    private final String itemStatistics;
    private final int picType;
    private final int position;
    List<a> rankInfoList;
    private final double ratio;
    private final c rightText;
    private final boolean scrollEnabled;
    private final boolean showLeft;
    private final boolean showSep;
    private final int titleColor;
    private final int titleColorNight;

    /* loaded from: classes2.dex */
    public static class a {
        public int bgColor;
        public int bgColorNight;
        public String btnDone;
        public String btnText;
        public long gGW;
        public String gGY;
        public String gGZ;
        public HorRankCard gHa;
        public boolean isDone;
        public String picUrl;
        public String postUrl;
        public int rank;
        public String subTitle;
        public String title;
    }

    public c getRightText() {
        return this.rightText;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    public boolean isScrollEnabled() {
        return this.scrollEnabled;
    }

    public int getPicType() {
        return this.picType;
    }

    public List<a> getRankInfoList() {
        return this.rankInfoList;
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public int getTitleColorNight() {
        return this.titleColorNight;
    }

    public double getDisplayNum() {
        return this.displayNum;
    }

    public int getPosition() {
        return this.position;
    }

    public String getItemStatistics() {
        return this.itemStatistics;
    }

    public boolean isShowLeft() {
        return this.showLeft;
    }

    public boolean isShowSep() {
        return this.showSep;
    }

    public HorRankCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.titleColor = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("tColor", ""));
        this.titleColorNight = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("tColorNight", ""));
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
            aVar.rank = optJSONObject.optInt("rank");
            aVar.picUrl = optJSONObject.optString("picUrl");
            aVar.gGY = optJSONObject.optString("picIcon");
            aVar.title = optJSONObject.optString("title");
            aVar.subTitle = optJSONObject.optString("subTitle");
            aVar.postUrl = optJSONObject.optString("postUrl");
            aVar.isDone = optJSONObject.optInt("isDone") == 1;
            aVar.btnText = optJSONObject.optString("btnText");
            aVar.btnDone = optJSONObject.optString("btnDone");
            aVar.gGZ = optJSONObject.optString("picScheme");
            aVar.bgColor = com.baidu.tieba.lego.card.d.a.parseColor(optJSONObject.optString("bgColor", ""));
            aVar.bgColorNight = com.baidu.tieba.lego.card.d.a.parseColor(optJSONObject.optString("bgColorNight", ""));
            aVar.gGW = optJSONObject.optLong("resourceId");
            aVar.gHa = this;
            this.rankInfoList.add(aVar);
        }
        this.rightText = c.bu(jSONObject.optJSONObject("moreButton"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return !v.T(this.rankInfoList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        boolean z2 = false;
        Iterator<a> it = this.rankInfoList.iterator();
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                a next = it.next();
                if (!TextUtils.isEmpty(next.postUrl) && !TextUtils.isEmpty(next.btnText) && !TextUtils.isEmpty(next.btnDone) && TextUtils.equals(getTouidFromPostUrl(next.postUrl), str)) {
                    next.isDone = z;
                    z3 = true;
                }
                z2 = z3;
            } else {
                return z3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        boolean z2 = false;
        Iterator<a> it = this.rankInfoList.iterator();
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                a next = it.next();
                if (!TextUtils.isEmpty(next.postUrl) && !TextUtils.isEmpty(next.btnText) && !TextUtils.isEmpty(next.btnDone) && TextUtils.equals(str, getFidFromPostUrl(next.postUrl))) {
                    next.isDone = z;
                    z3 = true;
                }
                z2 = z3;
            } else {
                return z3;
            }
        }
    }
}
