package com.baidu.tieba.lego.card.model;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.exception.CardParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SingleLineCard extends BaseCardInfo {
    private final int bgColor;
    private final int bgColorNight;
    private final c buttonInfo;
    private final int gravity;
    private final int height;
    private final String iconTitle;
    private final int iconTitleColor;
    private final int iconTitleColorNight;
    private final int iconType;
    private final String iconUrl;
    private final String iconUrlNight;
    private final int maxLines;
    private final int paramColor;
    private final int paramColorNight;
    private final List<String> params;
    private final boolean showLeftIcon;
    private final boolean showLeftLine;
    private final int textSize;
    private final int titleColor;
    private final int titleColorNight;

    public int getHeight() {
        return this.height;
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getIconType() {
        return this.iconType;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getIconUrlNight() {
        return this.iconUrlNight;
    }

    public c getButtonInfo() {
        return this.buttonInfo;
    }

    public boolean isShowLeftLine() {
        return this.showLeftLine;
    }

    public boolean isShowLeftIcon() {
        return this.showLeftIcon;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public int getTitleColorNight() {
        return this.titleColorNight;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public int getBgColorNight() {
        return this.bgColorNight;
    }

    public List<String> getParams() {
        return this.params;
    }

    public int getParamColorNight() {
        return this.paramColorNight;
    }

    public int getParamColor() {
        return this.paramColor;
    }

    public int getIconTitleColor() {
        return this.iconTitleColor;
    }

    public int getIconTitleColorNight() {
        return this.iconTitleColorNight;
    }

    public String getIconTitle() {
        return this.iconTitle;
    }

    public SingleLineCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        if (optJSONObject != null) {
            this.iconUrl = optJSONObject.optString("url");
            this.iconUrlNight = optJSONObject.optString("urlNight");
            this.iconType = optJSONObject.optInt("type");
            this.iconTitle = optJSONObject.optString("text");
            int sF = com.baidu.tieba.lego.card.c.b.sF(optJSONObject.optString("tColor", ""));
            int sF2 = com.baidu.tieba.lego.card.c.b.sF(optJSONObject.optString("tColorN", ""));
            if (com.baidu.tieba.lego.card.c.b.Fh(sF) || com.baidu.tieba.lego.card.c.b.Fh(sF2)) {
                this.iconTitleColor = ao.getColor(R.color.CAM_X0302);
                this.iconTitleColorNight = ao.getColor(R.color.CAM_X0302_1);
            } else {
                this.iconTitleColor = sF;
                this.iconTitleColorNight = sF2;
            }
        } else {
            this.iconUrl = "";
            this.iconUrlNight = "";
            this.iconType = 0;
            this.iconTitle = "";
            this.iconTitleColor = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.iconTitleColorNight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("params");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.params = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.params.add(optJSONArray.optString(i));
        }
        this.paramColor = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("pColor", ""));
        this.paramColorNight = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("pColorNight", ""));
        this.titleColor = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("tColor", ""));
        this.titleColorNight = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("tColorNight", ""));
        this.bgColor = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("bgColor", ""));
        this.bgColorNight = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("bgColorNight", ""));
        this.buttonInfo = c.ey(jSONObject.optJSONObject("moreButton"));
        this.showLeftLine = jSONObject.optInt("showLeftLine") == 1;
        this.showLeftIcon = jSONObject.optInt("showLeftIcon") == 1;
        this.maxLines = jSONObject.optInt("maxLines", 1);
        this.textSize = jSONObject.optInt("textSize", 32);
        this.height = jSONObject.optInt("height", 40);
        this.gravity = jSONObject.optInt("gravity", 0);
    }
}
