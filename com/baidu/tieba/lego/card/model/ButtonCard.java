package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import d.b.i0.j1.o.k.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ButtonCard extends BaseCardInfo {
    public static final int BUTTON_COLOR_FILL = 2;
    public static final int BUTTON_COLOR_FRAME = 1;
    public static final int DEFAULT_BUTTON_COLOR_STYLE = -1;
    public final int bgColor;
    public final String bgPicUrl;
    public final int btnColorStyle;
    public final String btnScheme;
    public final int buttonColor;
    public final int cardHeight;
    public final int cardWidth;
    public int defaultHeight;
    public int defaultWidth;
    public String phoneNumber;
    public final String title;
    public final int titleColor;

    public ButtonCard(JSONObject jSONObject) {
        super(jSONObject);
        this.defaultWidth = 750;
        this.defaultHeight = 80;
        this.title = jSONObject.optString("title", "");
        this.titleColor = b.b(jSONObject.optString("title_color"));
        this.buttonColor = b.b(jSONObject.optString("btn_color"));
        this.btnScheme = jSONObject.optString("btn_scheme", "");
        this.cardWidth = jSONObject.optInt("width", this.defaultWidth);
        this.cardHeight = jSONObject.optInt("height", this.defaultHeight);
        this.bgColor = b.b(jSONObject.optString("bg_color"));
        this.bgPicUrl = jSONObject.optString("bg_pic_url", "");
        this.btnColorStyle = jSONObject.optInt("btn_color_style", -1);
        extractPhoneNumber(this.btnScheme);
    }

    private void extractPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            this.phoneNumber = "";
        } else {
            this.phoneNumber = str.substring(4);
        }
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public String getBtnScheme() {
        return this.btnScheme;
    }

    public int getButtonColor() {
        return this.buttonColor;
    }

    public int getCardHeight() {
        return this.cardHeight;
    }

    public int getCardWidth() {
        return this.cardWidth;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPicUrl() {
        return this.bgPicUrl;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        int i = this.cardWidth;
        if (i > 0) {
            return this.cardHeight / i;
        }
        return super.getRatio();
    }

    public int getStyle() {
        return this.btnColorStyle;
    }

    public String getText() {
        return this.title;
    }

    public int getTextColor() {
        return this.titleColor;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return !TextUtils.isEmpty(this.btnScheme);
    }

    public String toString() {
        return super.toString() + this.bgPicUrl + this.btnScheme;
    }
}
