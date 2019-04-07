package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int iaq;
    public final int iar;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.iaq = i;
        this.what = i2;
        this.iar = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.iaq = i;
        this.what = i2;
        this.iar = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject bUo() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.iaq == -100) {
                str = "system";
            } else if (this.iaq == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.iar);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
