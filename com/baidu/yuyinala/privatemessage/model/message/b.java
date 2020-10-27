package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean owy;
    public TextMsg owz;

    public b(TextMsg textMsg) {
        this.owz = textMsg;
        try {
            if (new JSONObject(this.owz.getMsgContent()).has("notifiyType")) {
                this.owy = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean eey() {
        return this.owy;
    }
}
