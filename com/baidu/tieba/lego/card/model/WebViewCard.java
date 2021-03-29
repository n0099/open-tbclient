package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WebViewCard extends BaseCardInfo {
    public final int container;
    public final boolean enableTouchFromNet;
    public final int height;
    public final String url;

    public WebViewCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.url = jSONObject.optString("url");
        this.height = jSONObject.optInt("height", -1);
        this.container = jSONObject.optInt("container", 0);
        this.enableTouchFromNet = jSONObject.optInt("enable_scroll_from_net", 0) == 1;
    }

    public int getContainer() {
        return this.container;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPageUrl() {
        return this.url;
    }

    public boolean isEnableTouchFromNet() {
        return this.enableTouchFromNet;
    }
}
