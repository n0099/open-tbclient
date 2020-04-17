package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int kkR;
    public final int kkS;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.kkR = i;
        this.what = i2;
        this.kkS = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.kkR = i;
        this.what = i2;
        this.kkS = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject cKT() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.kkR == -100) {
                str = "system";
            } else if (this.kkR == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.kkS);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
