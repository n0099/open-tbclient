package com.baidu.tieba.live.tbean.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IconInfoData extends BaseData {
    public List<DiscountData> discount;
    public int dubi;
    public int duration;
    public int hide;
    public String iconId;
    public String name;
    public int non_member_t;
    public String picUrl;
    public String productId;
    public String sign;
    public String tag_name;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.productId = jSONObject.optString("productId");
            if (TextUtils.isEmpty(this.productId) && jSONObject.has("product_id")) {
                this.productId = jSONObject.optString("product_id");
            }
            this.name = jSONObject.optString("name");
            this.iconId = jSONObject.optString("iconId");
            this.picUrl = jSONObject.optString("picUrl");
            this.non_member_t = jSONObject.optInt("non_member_t");
            this.dubi = jSONObject.optInt("dubi");
            this.duration = jSONObject.optInt("duration");
            this.hide = jSONObject.optInt("hide");
            this.discount = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("discount");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    DiscountData discountData = new DiscountData();
                    discountData.parserJson(optJSONArray.optJSONObject(i));
                    this.discount.add(discountData);
                }
            }
            this.sign = jSONObject.optString("sign");
            this.tag_name = jSONObject.optString("");
        }
    }
}
