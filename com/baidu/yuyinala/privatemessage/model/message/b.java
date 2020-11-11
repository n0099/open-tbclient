package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean oFQ;
    public TextMsg oFR;

    public b(TextMsg textMsg) {
        this.oFR = textMsg;
        try {
            if (new JSONObject(this.oFR.getMsgContent()).has("notifiyType")) {
                this.oFQ = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean ein() {
        return this.oFQ;
    }
}
