package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int iaK;
    public final int iaL;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.iaK = i;
        this.what = i2;
        this.iaL = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.iaK = i;
        this.what = i2;
        this.iaL = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject bUq() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.iaK == -100) {
                str = "system";
            } else if (this.iaK == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.iaL);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
