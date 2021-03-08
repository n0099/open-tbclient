package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public boolean pkQ;
    public TextMsg pkR;

    public b(TextMsg textMsg) {
        this.pkR = textMsg;
        try {
            if (new JSONObject(this.pkR.getMsgContent()).has("notifiyType")) {
                this.pkQ = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean emW() {
        return this.pkQ;
    }
}
