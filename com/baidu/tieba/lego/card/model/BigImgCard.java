package com.baidu.tieba.lego.card.model;

import com.baidu.adp.lib.util.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BigImgCard extends BaseCardInfo {
    private final double ratio;
    private final String url;

    public BigImgCard(JSONObject jSONObject) {
        super(jSONObject);
        this.url = jSONObject.optString("url");
        this.ratio = jSONObject.optDouble("ratio");
    }

    public String getUrl() {
        return this.url;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        if (k.isEmpty(this.url)) {
            return false;
        }
        return super.isValid();
    }
}
