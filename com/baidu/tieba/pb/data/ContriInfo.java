package com.baidu.tieba.pb.data;

import d.a.c.e.p.k;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ContriInfo implements Serializable {
    public String afterMsg;
    public String colorMsg;
    public String mPreColorMsg;
    public String mToastBackImage;

    public String getAfterMsg() {
        return this.afterMsg;
    }

    public String getColorMsg() {
        return this.colorMsg;
    }

    public String getPreColorMsg() {
        return this.mPreColorMsg;
    }

    public String getToastBackImage() {
        return this.mToastBackImage;
    }

    public boolean isShowToast() {
        return (k.isEmpty(this.colorMsg) || k.isEmpty(this.afterMsg)) ? false : true;
    }

    public void parseJson(JSONObject jSONObject) {
        int indexOf;
        if (jSONObject == null) {
            return;
        }
        this.colorMsg = jSONObject.optString("color_msg");
        String optString = jSONObject.optString("after_msg");
        this.afterMsg = optString;
        if (!k.isEmpty(optString) && (indexOf = this.afterMsg.indexOf("，")) >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.afterMsg.substring(0, indexOf));
            sb.append("\n");
            String str = this.afterMsg;
            sb.append(str.substring(indexOf + 1, str.length()));
            this.afterMsg = sb.toString();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("toast_config");
        if (optJSONArray != null) {
            try {
                if (optJSONArray.getJSONObject(0) != null) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                    this.mPreColorMsg = jSONObject2.optString("pre_color_msg");
                    this.mToastBackImage = jSONObject2.optString("toast_back_image");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAfterMsg(String str) {
        this.afterMsg = str;
    }

    public void setColorMsg(String str) {
        this.colorMsg = str;
    }
}
