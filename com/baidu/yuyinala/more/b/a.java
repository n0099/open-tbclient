package com.baidu.yuyinala.more.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements IAdapterData {
    public static final BdUniqueId oWZ = BdUniqueId.gen();
    private String ggy;
    private String mAction;
    private String mIconUrl;
    private String mId;
    private String mName;
    private boolean oXa;
    private boolean oXb;
    private String oXc;

    public String getId() {
        return this.mId;
    }

    public String BS() {
        return this.ggy;
    }

    public String ejv() {
        return this.oXc;
    }

    public void XX(String str) {
        this.oXc = str;
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

    public boolean ejw() {
        return this.oXa;
    }

    public boolean ejx() {
        return this.oXb;
    }

    public void AI(boolean z) {
        this.oXb = z;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mIconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.mName = jSONObject.optString("text");
            this.mAction = jSONObject.optString("action");
            this.oXa = jSONObject.optInt("red_note", 0) == 1;
            this.ggy = jSONObject.optString("url");
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return oWZ;
    }
}
