package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int iaE;
    public final int iaF;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.iaE = i;
        this.what = i2;
        this.iaF = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.iaE = i;
        this.what = i2;
        this.iaF = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject bUs() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.iaE == -100) {
                str = "system";
            } else if (this.iaE == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.iaF);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
