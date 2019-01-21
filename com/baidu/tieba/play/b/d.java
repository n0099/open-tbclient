package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int gJj;
    public final int gJk;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.gJj = i;
        this.what = i2;
        this.gJk = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.gJj = i;
        this.what = i2;
        this.gJk = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject btE() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gJj == -100) {
                str = "system";
            } else if (this.gJj == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.gJk);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
