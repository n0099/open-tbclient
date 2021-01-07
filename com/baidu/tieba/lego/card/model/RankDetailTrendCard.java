package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.lego.card.exception.CardParseException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class RankDetailTrendCard extends BaseCardInfo {
    private final String btnDone;
    private final String btnText;
    private final String iconUrl;
    private boolean isDone;
    private final int picTrendType;
    private final String picTrendUrl;
    private final String picUrl;
    private final String postUrl;
    private final int rank;
    private final double ratio;
    private final int trendColor;
    private final int trendColorN;
    private final String trendText;

    public int getRank() {
        return this.rank;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    public String getPicUrl() {
        return this.picUrl;
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

    public String getTrendText() {
        return this.trendText;
    }

    public int getTrendColor() {
        return this.trendColor;
    }

    public int getTrendColorNight() {
        return this.trendColorN;
    }

    public String getPostUrl() {
        return this.postUrl;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setIsDone(boolean z) {
        this.isDone = z;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public String getBtnDone() {
        return this.btnDone;
    }

    public RankDetailTrendCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.rank = jSONObject.optInt("rank");
        this.ratio = jSONObject.optDouble(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 1.0d);
        this.picUrl = jSONObject.optString("picUrl");
        this.iconUrl = jSONObject.optString("iconUrl", "");
        this.picTrendType = jSONObject.optInt("picTrendType");
        this.picTrendUrl = jSONObject.optString("picTrendUrl");
        this.trendText = jSONObject.optString("trendText");
        this.trendColor = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("trendColor", ""));
        this.trendColorN = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("trendColorN", ""));
        this.postUrl = jSONObject.optString("postUrl");
        this.isDone = jSONObject.optInt("isDone") == 1;
        this.btnText = jSONObject.optString("btnText");
        this.btnDone = jSONObject.optString("btnDone");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return (TextUtils.isEmpty(this.postUrl) || TextUtils.isEmpty(this.btnText) || TextUtils.isEmpty(this.btnDone)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        if (TextUtils.equals(getTouidFromPostUrl(this.postUrl), str)) {
            this.isDone = z;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        if (TextUtils.equals(getFidFromPostUrl(this.postUrl), str)) {
            this.isDone = z;
            return true;
        }
        return false;
    }
}
