package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int ita;
    public final int itb;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.ita = i;
        this.what = i2;
        this.itb = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.ita = i;
        this.what = i2;
        this.itb = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject ccs() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ita == -100) {
                str = "system";
            } else if (this.ita == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.itb);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
