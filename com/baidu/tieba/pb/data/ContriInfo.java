package com.baidu.tieba.pb.data;

import com.baidu.tbadk.core.util.am;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ContriInfo implements Serializable {
    private String afterMsg;
    private String colorMsg;

    public void parseJson(JSONObject jSONObject) {
        int indexOf;
        if (jSONObject != null) {
            this.colorMsg = jSONObject.optString("color_msg");
            this.afterMsg = jSONObject.optString("after_msg");
            if (!am.isEmpty(this.afterMsg) && (indexOf = this.afterMsg.indexOf("，")) >= 0) {
                this.afterMsg = this.afterMsg.substring(0, indexOf) + "\n" + this.afterMsg.substring(indexOf + 1, this.afterMsg.length());
            }
        }
    }

    public boolean isShowToast() {
        return (am.isEmpty(this.colorMsg) || am.isEmpty(this.afterMsg)) ? false : true;
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
