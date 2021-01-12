package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public boolean oXT;
    public TextMsg oXU;

    public b(TextMsg textMsg) {
        this.oXU = textMsg;
        try {
            if (new JSONObject(this.oXU.getMsgContent()).has("notifiyType")) {
                this.oXT = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean ekm() {
        return this.oXT;
    }
}
