package com.baidu.tieba.play.d;

import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int exS;
    public final int exT;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.exS = i;
        this.what = i2;
        this.exT = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.exS = i;
        this.what = i2;
        this.exT = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.d.b
    public JSONObject aNo() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.exS == -100) {
                str = "system";
            } else if (this.exS == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.exT);
            jSONObject.put(AddFriendActivityConfig.MSG, this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
