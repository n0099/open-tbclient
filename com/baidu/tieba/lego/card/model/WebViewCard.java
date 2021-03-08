package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class WebViewCard extends BaseCardInfo {
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

    public WebViewCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.url = jSONObject.optString("url");
        this.height = jSONObject.optInt("height", -1);
        this.container = jSONObject.optInt("container", 0);
        this.enableTouchFromNet = jSONObject.optInt("enable_scroll_from_net", 0) == 1;
    }
}
