package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.lego.card.exception.CardParseException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class RankScoreCard extends BaseCardInfo {
    private final String btnDone;
    private final String btnText;
    private final int d2Color;
    private final int d2ColorN;
    private final String d2Scheme;
    private final String desc;
    private final String desc2;
    private boolean isDone;
    private final String picUrl;
    private final String postUrl;
    private final int rank;
    private final double ratio;
    private final int sColor;
    private final int sColorNight;
    private final String subTitle;

    public String getDesc() {
        return this.desc;
    }

    public String getDesc2() {
        return this.desc2;
    }

    public int getD2Color() {
        return this.d2Color;
    }

    public int getD2ColorN() {
        return this.d2ColorN;
    }

    public int getScoreColor() {
        return this.sColor;
    }

    public int getScoreColorNight() {
        return this.sColorNight;
    }

    public String getD2Scheme() {
        return this.d2Scheme;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public int getRank() {
        return this.rank;
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

    public RankScoreCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.rank = jSONObject.optInt("rank");
        this.desc = jSONObject.optString("desc");
        this.desc2 = jSONObject.optString("desc2");
        this.d2Color = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("d2Color", ""));
        this.d2ColorN = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("d2ColorN", ""));
        this.d2Scheme = jSONObject.optString("d2Scheme");
        this.ratio = jSONObject.optDouble(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
        this.picUrl = jSONObject.optString("picUrl");
        this.subTitle = jSONObject.optString("subTitle");
        this.sColor = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("sColor", ""));
        this.sColorNight = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("sColorN", ""));
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
