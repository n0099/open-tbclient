package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public boolean pij;
    public TextMsg pik;

    public b(TextMsg textMsg) {
        this.pik = textMsg;
        try {
            if (new JSONObject(this.pik.getMsgContent()).has("notifiyType")) {
                this.pij = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean emE() {
        return this.pij;
    }
}
