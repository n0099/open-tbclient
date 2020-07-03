package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int kXU;
    public final int kXV;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.kXU = i;
        this.what = i2;
        this.kXV = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.kXU = i;
        this.what = i2;
        this.kXV = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject cWx() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.kXU == -100) {
                str = "system";
            } else if (this.kXU == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.kXV);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
