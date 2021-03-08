package com.baidu.yuyinala.more.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements IAdapterData {
    public static final BdUniqueId oZE = BdUniqueId.gen();
    private String gih;
    private String mAction;
    private String mIconUrl;
    private String mId;
    private String mName;
    private boolean oZF;
    private boolean oZG;
    private String oZH;

    public String getId() {
        return this.mId;
    }

    public String BV() {
        return this.gih;
    }

    public String ejN() {
        return this.oZH;
    }

    public void Yq(String str) {
        this.oZH = str;
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

    public boolean ejO() {
        return this.oZF;
    }

    public boolean ejP() {
        return this.oZG;
    }

    public void AH(boolean z) {
        this.oZG = z;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mIconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.mName = jSONObject.optString("text");
            this.mAction = jSONObject.optString("action");
            this.oZF = jSONObject.optInt("red_note", 0) == 1;
            this.gih = jSONObject.optString("url");
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return oZE;
    }
}
