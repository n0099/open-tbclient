package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int jye;
    public final int jyf;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.jye = i;
        this.what = i2;
        this.jyf = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.jye = i;
        this.what = i2;
        this.jyf = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject cyp() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.jye == -100) {
                str = "system";
            } else if (this.jye == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.jyf);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
