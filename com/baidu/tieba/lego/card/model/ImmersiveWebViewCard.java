package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ImmersiveWebViewCard extends BaseCardInfo {
    private final int container;
    private final boolean enableTouchFromNet;
    private final int height;
    private final String url;

    public String getPageUrl() {
        return this.url;
    }

    public int getHeight() {
        return this.height;
    }

    public int getContainer() {
        return this.container;
    }

    public boolean isEnableTouchFromNet() {
        return this.enableTouchFromNet;
    }

    public ImmersiveWebViewCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.url = jSONObject.optString("url");
        this.height = jSONObject.optInt("height", -1);
        this.container = jSONObject.optInt("container", 0);
        this.enableTouchFromNet = jSONObject.optInt("enable_scroll_from_net", 0) == 1;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return 1.78d;
    }
}
