package com.baidu.tieba.play.c;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int guu;
    public final int guv;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.guu = i;
        this.what = i2;
        this.guv = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.guu = i;
        this.what = i2;
        this.guv = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.c.b
    public JSONObject bkO() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.guu == -100) {
                str = "system";
            } else if (this.guu == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.guv);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
