package com.baidu.yuyinala.more.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements IAdapterData {
    public static final BdUniqueId oXz = BdUniqueId.gen();
    private String ggD;
    private String mAction;
    private String mIconUrl;
    private String mId;
    private String mName;
    private boolean oXA;
    private boolean oXB;
    private String oXC;

    public String getId() {
        return this.mId;
    }

    public String BS() {
        return this.ggD;
    }

    public String ejD() {
        return this.oXC;
    }

    public void Yj(String str) {
        this.oXC = str;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getName() {
        return this.mName;
    }

    public String getAction() {
        return this.mAction;
    }

    public boolean ejE() {
        return this.oXA;
    }

    public boolean ejF() {
        return this.oXB;
    }

    public void AI(boolean z) {
        this.oXB = z;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mIconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.mName = jSONObject.optString("text");
            this.mAction = jSONObject.optString("action");
            this.oXA = jSONObject.optInt("red_note", 0) == 1;
            this.ggD = jSONObject.optString("url");
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return oXz;
    }
}
