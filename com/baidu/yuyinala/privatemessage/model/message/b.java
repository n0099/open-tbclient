package com.baidu.yuyinala.privatemessage.model.message;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean oHu;
    public TextMsg oHv;

    public b(TextMsg textMsg) {
        this.oHv = textMsg;
        try {
            if (new JSONObject(this.oHv.getMsgContent()).has("notifiyType")) {
                this.oHu = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean eil() {
        return this.oHu;
    }
}
