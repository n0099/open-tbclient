package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean oWC;
    public TextMsg oWD;

    public b(TextMsg textMsg) {
        this.oWD = textMsg;
        try {
            if (new JSONObject(this.oWD.getMsgContent()).has("notifiyType")) {
                this.oWC = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean eob() {
        return this.oWC;
    }
}
