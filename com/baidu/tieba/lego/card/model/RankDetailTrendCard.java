package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.lego.card.exception.CardParseException;
import d.b.i0.j1.o.k.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RankDetailTrendCard extends BaseCardInfo {
    public final String btnDone;
    public final String btnText;
    public final String iconUrl;
    public boolean isDone;
    public final int picTrendType;
    public final String picTrendUrl;
    public final String picUrl;
    public final String postUrl;
    public final int rank;
    public final double ratio;
    public final int trendColor;
    public final int trendColorN;
    public final String trendText;

    public RankDetailTrendCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.rank = jSONObject.optInt("rank");
        this.ratio = jSONObject.optDouble("ratio", 1.0d);
        this.picUrl = jSONObject.optString("picUrl");
        this.iconUrl = jSONObject.optString("iconUrl", "");
        this.picTrendType = jSONObject.optInt("picTrendType");
        this.picTrendUrl = jSONObject.optString("picTrendUrl");
        this.trendText = jSONObject.optString("trendText");
        this.trendColor = b.b(jSONObject.optString("trendColor", ""));
        this.trendColorN = b.b(jSONObject.optString("trendColorN", ""));
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

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getPicTrendType() {
        return this.picTrendType;
    }

    public String getPicTrendUrl() {
        return this.picTrendUrl;
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

    public int getTrendColor() {
        return this.trendColor;
    }

    public int getTrendColorNight() {
        return this.trendColorN;
    }

    public String getTrendText() {
        return this.trendText;
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
