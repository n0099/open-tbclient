package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int jzb;
    public final int jzc;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.jzb = i;
        this.what = i2;
        this.jzc = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.jzb = i;
        this.what = i2;
        this.jzc = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject czO() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.jzb == -100) {
                str = "system";
            } else if (this.jzb == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.jzc);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
