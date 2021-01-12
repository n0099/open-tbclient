package com.baidu.yuyinala.emoticon.a;

import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements IAdapterData {
    public static final BdUniqueId oLX = BdUniqueId.gen();
    private String mId;
    private String mName;
    private String oLY;
    private List<String> oLZ;
    private String oLy;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oLy;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("img_id");
            this.mName = jSONObject.optString("img_name");
            this.oLy = jSONObject.optString("compression_img");
            this.oLY = jSONObject.optString("prototype_img");
            JSONArray optJSONArray = jSONObject.optJSONArray("results_img");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.oLZ = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.oLZ.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return oLX;
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
