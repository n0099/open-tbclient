package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public boolean oXU;
    public TextMsg oXV;

    public b(TextMsg textMsg) {
        this.oXV = textMsg;
        try {
            if (new JSONObject(this.oXV.getMsgContent()).has("notifiyType")) {
                this.oXU = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean ekm() {
        return this.oXU;
    }
}
