package com.baidu.tieba.live.tbean.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CustomData extends BaseData {
    public String create_time;
    public List<DiscountData> discount;
    public int dubi;
    public int dubi_ios;
    public int duration;
    public int hide;
    public String icon_id;
    public String icon_name;
    public String icon_pic;
    public int ios_display;
    public String ios_icon_id;
    public int is_custom_price;
    public String name;
    public int non_member_i;
    public int non_member_t;
    public String package_pic;
    public String pic_url;
    public String productId;
    public int props_id;
    public String tag_name;
    public String update_time;
    public int validity;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.non_member_t = jSONObject.optInt("non_member_t");
            this.non_member_i = jSONObject.optInt("non_member_i");
            this.dubi = jSONObject.optInt("dubi");
            this.dubi_ios = jSONObject.optInt("dubi_ios");
            this.ios_display = jSONObject.optInt("ios_display");
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
            this.props_id = jSONObject.optInt("props_id");
            this.ios_icon_id = jSONObject.optString("ios_icon_id");
            this.validity = jSONObject.optInt("validity");
            this.update_time = jSONObject.optString("update_time");
            this.create_time = jSONObject.optString("create_time");
            this.package_pic = jSONObject.optString("package_pic");
            this.is_custom_price = jSONObject.optInt("is_custom_price");
            this.tag_name = jSONObject.optString("tag_name");
            this.productId = jSONObject.optString("product_id");
            if (TextUtils.isEmpty(this.productId) && jSONObject.has("productId")) {
                this.productId = jSONObject.optString("productId");
            }
            this.icon_id = jSONObject.optString("icon_id");
            this.pic_url = jSONObject.optString("pic_url");
            this.icon_name = jSONObject.optString("icon_name");
            this.icon_pic = jSONObject.optString("icon_pic");
        }
    }
}
