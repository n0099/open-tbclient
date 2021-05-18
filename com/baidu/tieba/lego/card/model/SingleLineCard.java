package com.baidu.tieba.lego.card.model;

import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.exception.CardParseException;
import d.a.k0.j1.o.j.c;
import d.a.k0.j1.o.k.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SingleLineCard extends BaseCardInfo {
    public final int bgColor;
    public final int bgColorNight;
    public final c buttonInfo;
    public final int gravity;
    public final int height;
    public final String iconTitle;
    public final int iconTitleColor;
    public final int iconTitleColorNight;
    public final int iconType;
    public final String iconUrl;
    public final String iconUrlNight;
    public final int maxLines;
    public final int paramColor;
    public final int paramColorNight;
    public final List<String> params;
    public final boolean showLeftIcon;
    public final boolean showLeftLine;
    public final int textSize;
    public final int titleColor;
    public final int titleColorNight;

    public SingleLineCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("icon");
        if (optJSONObject != null) {
            this.iconUrl = optJSONObject.optString("url");
            this.iconUrlNight = optJSONObject.optString("urlNight");
            this.iconType = optJSONObject.optInt("type");
            this.iconTitle = optJSONObject.optString("text");
            int b2 = b.b(optJSONObject.optString("tColor", ""));
            int b3 = b.b(optJSONObject.optString("tColorN", ""));
            if (!b.a(b2) && !b.a(b3)) {
                this.iconTitleColor = b2;
                this.iconTitleColorNight = b3;
            } else {
                this.iconTitleColor = SkinManager.getColor(R.color.CAM_X0302);
                this.iconTitleColorNight = SkinManager.getColor(R.color.CAM_X0302_1);
            }
        } else {
            this.iconUrl = "";
            this.iconUrlNight = "";
            this.iconType = 0;
            this.iconTitle = "";
            this.iconTitleColor = Integer.MAX_VALUE;
            this.iconTitleColorNight = Integer.MAX_VALUE;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("params");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.params = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.params.add(optJSONArray.optString(i2));
        }
        this.paramColor = b.b(jSONObject.optString("pColor", ""));
        this.paramColorNight = b.b(jSONObject.optString("pColorNight", ""));
        this.titleColor = b.b(jSONObject.optString("tColor", ""));
        this.titleColorNight = b.b(jSONObject.optString("tColorNight", ""));
        this.bgColor = b.b(jSONObject.optString("bgColor", ""));
        this.bgColorNight = b.b(jSONObject.optString("bgColorNight", ""));
        this.buttonInfo = c.a(jSONObject.optJSONObject("moreButton"));
        this.showLeftLine = jSONObject.optInt("showLeftLine") == 1;
        this.showLeftIcon = jSONObject.optInt("showLeftIcon") == 1;
        this.maxLines = jSONObject.optInt("maxLines", 1);
        this.textSize = jSONObject.optInt("textSize", 32);
        this.height = jSONObject.optInt("height", 40);
        this.gravity = jSONObject.optInt(NotificationCompat.WearableExtender.KEY_GRAVITY, 0);
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public int getBgColorNight() {
        return this.bgColorNight;
    }

    public c getButtonInfo() {
        return this.buttonInfo;
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getHeight() {
        return this.height;
    }

    public String getIconTitle() {
        return this.iconTitle;
    }

    public int getIconTitleColor() {
        return this.iconTitleColor;
    }

    public int getIconTitleColorNight() {
        return this.iconTitleColorNight;
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

    public int getMaxLines() {
        return this.maxLines;
    }

    public int getParamColor() {
        return this.paramColor;
    }

    public int getParamColorNight() {
        return this.paramColorNight;
    }

    public List<String> getParams() {
        return this.params;
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

    public boolean isShowLeftIcon() {
        return this.showLeftIcon;
    }

    public boolean isShowLeftLine() {
        return this.showLeftLine;
    }
}
