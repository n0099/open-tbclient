package com.baidu.yuyinala.emoticon.a;

import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAdapterData {
    public static final BdUniqueId ovf = BdUniqueId.gen();
    private String mId;
    private String mName;
    private String ouJ;
    private String ovg;
    private List<String> ovh;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.ouJ;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("img_id");
            this.mName = jSONObject.optString("img_name");
            this.ouJ = jSONObject.optString("compression_img");
            this.ovg = jSONObject.optString("prototype_img");
            JSONArray optJSONArray = jSONObject.optJSONArray("results_img");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.ovh = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.ovh.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return ovf;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return TextUtils.equals(this.mId, ((a) obj).mId);
    }
}
