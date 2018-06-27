package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.util.ap;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ContriInfo implements Serializable {
    private String afterMsg;
    private String colorMsg;
    private String mPreColorMsg;
    private String mToastBackImage;

    public void parseJson(JSONObject jSONObject) {
        int indexOf;
        if (jSONObject != null) {
            this.colorMsg = jSONObject.optString("color_msg");
            this.afterMsg = jSONObject.optString("after_msg");
            if (!ap.isEmpty(this.afterMsg) && (indexOf = this.afterMsg.indexOf("，")) >= 0) {
                this.afterMsg = this.afterMsg.substring(0, indexOf) + "\n" + this.afterMsg.substring(indexOf + 1, this.afterMsg.length());
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("toast_config");
            if (optJSONArray != null) {
                try {
                    if (optJSONArray.getJSONObject(0) != null) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                        this.mPreColorMsg = jSONObject2.optString("pre_color_msg");
                        this.mToastBackImage = jSONObject2.optString("toast_back_image");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getPreColorMsg() {
        return this.mPreColorMsg;
    }

    public String getToastBackImage() {
        return this.mToastBackImage;
    }

    public boolean isShowToast() {
        return (ap.isEmpty(this.colorMsg) || ap.isEmpty(this.afterMsg)) ? false : true;
    }

    public String getColorMsg() {
        return this.colorMsg;
    }

    public void setColorMsg(String str) {
        this.colorMsg = str;
    }

    public String getAfterMsg() {
        return this.afterMsg;
    }

    public void setAfterMsg(String str) {
        this.afterMsg = str;
    }
}
