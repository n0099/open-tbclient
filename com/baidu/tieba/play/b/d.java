package com.baidu.tieba.play.b;

import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int fQG;
    public final int fQH;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.fQG = i;
        this.what = i2;
        this.fQH = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.fQG = i;
        this.what = i2;
        this.fQH = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject bjI() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.fQG == -100) {
                str = "system";
            } else if (this.fQG == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.fQH);
            jSONObject.put(AddFriendActivityConfig.MSG, this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
