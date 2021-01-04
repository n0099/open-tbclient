package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public boolean pcy;
    public TextMsg pcz;

    public b(TextMsg textMsg) {
        this.pcz = textMsg;
        try {
            if (new JSONObject(this.pcz.getMsgContent()).has("notifiyType")) {
                this.pcy = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean eoh() {
        return this.pcy;
    }
}
