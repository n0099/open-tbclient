package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public boolean piK;
    public TextMsg piL;

    public b(TextMsg textMsg) {
        this.piL = textMsg;
        try {
            if (new JSONObject(this.piL.getMsgContent()).has("notifiyType")) {
                this.piK = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean emM() {
        return this.piK;
    }
}
