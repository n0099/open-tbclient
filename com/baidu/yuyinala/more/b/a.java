package com.baidu.yuyinala.more.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements IAdapterData {
    public static final BdUniqueId oMQ = BdUniqueId.gen();
    private String mAction;
    private String mIconUrl;
    private String mId;
    private String mName;
    private boolean oMR;
    private boolean oMS;

    public String getId() {
        return this.mId;
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

    public boolean ehc() {
        return this.oMR;
    }

    public boolean ehd() {
        return this.oMS;
    }

    public void Ap(boolean z) {
        this.oMS = z;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mIconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.mName = jSONObject.optString("text");
            this.mAction = jSONObject.optString("action");
            this.oMR = jSONObject.optInt("red_note", 0) == 1;
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return oMQ;
    }
}
