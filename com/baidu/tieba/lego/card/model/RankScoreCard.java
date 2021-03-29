package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.exception.CardParseException;
import d.b.i0.i1.o.k.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RankScoreCard extends BaseCardInfo {
    public final String btnDone;
    public final String btnText;
    public final int d2Color;
    public final int d2ColorN;
    public final String d2Scheme;
    public final String desc;
    public final String desc2;
    public boolean isDone;
    public final String picUrl;
    public final String postUrl;
    public final int rank;
    public final double ratio;
    public final int sColor;
    public final int sColorNight;
    public final String subTitle;

    public RankScoreCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.rank = jSONObject.optInt("rank");
        this.desc = jSONObject.optString("desc");
        this.desc2 = jSONObject.optString("desc2");
        this.d2Color = b.b(jSONObject.optString("d2Color", ""));
        this.d2ColorN = b.b(jSONObject.optString("d2ColorN", ""));
        this.d2Scheme = jSONObject.optString("d2Scheme");
        this.ratio = jSONObject.optDouble("ratio");
        this.picUrl = jSONObject.optString("picUrl");
        this.subTitle = jSONObject.optString("subTitle");
        this.sColor = b.b(jSONObject.optString("sColor", ""));
        this.sColorNight = b.b(jSONObject.optString("sColorN", ""));
        this.postUrl = jSONObject.optString("postUrl");
        this.isDone = jSONObject.optInt("isDone") == 1;
        this.btnText = jSONObject.optString("btnText");
        this.btnDone = jSONObject.optString("btnDone");
    }

    public String getBtnDone() {
        return this.btnDone;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public int getD2Color() {
        return this.d2Color;
    }

    public int getD2ColorN() {
        return this.d2ColorN;
    }

    public String getD2Scheme() {
        return this.d2Scheme;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDesc2() {
        return this.desc2;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getPostUrl() {
        return this.postUrl;
    }

    public int getRank() {
        return this.rank;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    public int getScoreColor() {
        return this.sColor;
    }

    public int getScoreColorNight() {
        return this.sColorNight;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public boolean isDone() {
        return this.isDone;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        if (TextUtils.equals(getFidFromPostUrl(this.postUrl), str)) {
            this.isDone = z;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        if (TextUtils.equals(getTouidFromPostUrl(this.postUrl), str)) {
            this.isDone = z;
            return true;
        }
        return false;
    }

    public void setIsDone(boolean z) {
        this.isDone = z;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return (TextUtils.isEmpty(this.postUrl) || TextUtils.isEmpty(this.btnText) || TextUtils.isEmpty(this.btnDone)) ? false : true;
    }
}
