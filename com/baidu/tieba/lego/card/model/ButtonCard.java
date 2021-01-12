package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tieba.recapp.lego.model.FormCard;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ButtonCard extends BaseCardInfo {
    public static final int BUTTON_COLOR_FILL = 2;
    public static final int BUTTON_COLOR_FRAME = 1;
    public static final int DEFAULT_BUTTON_COLOR_STYLE = -1;
    private final int bgColor;
    private final String bgPicUrl;
    private final int btnColorStyle;
    private final String btnScheme;
    private final int buttonColor;
    private final int cardHeight;
    private final int cardWidth;
    private int defaultHeight;
    private int defaultWidth;
    private String phoneNumber;
    private final String title;
    private final int titleColor;

    public ButtonCard(JSONObject jSONObject) {
        super(jSONObject);
        this.defaultWidth = FormCard.WIDTH_DEFAULT_SIZE;
        this.defaultHeight = 80;
        this.title = jSONObject.optString("title", "");
        this.titleColor = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("title_color"));
        this.buttonColor = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("btn_color"));
        this.btnScheme = jSONObject.optString("btn_scheme", "");
        this.cardWidth = jSONObject.optInt("width", this.defaultWidth);
        this.cardHeight = jSONObject.optInt("height", this.defaultHeight);
        this.bgColor = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("bg_color"));
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

    public String getText() {
        return this.title;
    }

    public int getTextColor() {
        return this.titleColor;
    }

    public int getButtonColor() {
        return this.buttonColor;
    }

    public String getBtnScheme() {
        return this.btnScheme;
    }

    public int getCardWidth() {
        return this.cardWidth;
    }

    public int getCardHeight() {
        return this.cardHeight;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public String getPicUrl() {
        return this.bgPicUrl;
    }

    public int getStyle() {
        return this.btnColorStyle;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.cardWidth > 0 ? this.cardHeight / this.cardWidth : super.getRatio();
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String toString() {
        return super.toString() + this.bgPicUrl + this.btnScheme;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return !TextUtils.isEmpty(this.btnScheme);
    }
}
