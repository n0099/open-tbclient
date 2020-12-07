package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean oWA;
    public TextMsg oWB;

    public b(TextMsg textMsg) {
        this.oWB = textMsg;
        try {
            if (new JSONObject(this.oWB.getMsgContent()).has("notifiyType")) {
                this.oWA = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean eoa() {
        return this.oWA;
    }
}
