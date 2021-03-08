package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.IMTrack;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l extends b {
    private boolean mNotify;

    private l(Context context, String str, long j, String str2) {
        super(context, str, j, str2);
    }

    public l(Context context, String str, long j, String str2, boolean z) {
        this(context, str, j, str2);
        this.mNotify = z;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.f.b
    public String ekg() {
        return IMTrack.DbBuilder.ACTION_UPDATE;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.f.b
    public void b(StringBuilder sb) {
        if (sb != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notify", this.mNotify ? "yes" : "no");
                sb.append("&ext=").append(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
