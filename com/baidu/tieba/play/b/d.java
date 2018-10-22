package com.baidu.tieba.play.b;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements b {
    public final int gwW;
    public final int gwX;
    public final String msg;
    public final int what;

    public d(int i, int i2, int i3) {
        this.gwW = i;
        this.what = i2;
        this.gwX = i3;
        this.msg = "";
    }

    public d(int i, int i2, int i3, String str) {
        this.gwW = i;
        this.what = i2;
        this.gwX = i3;
        this.msg = str;
    }

    @Override // com.baidu.tieba.play.b.b
    public JSONObject bqV() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.gwW == -100) {
                str = "system";
            } else if (this.gwW == -200) {
                str = "ijkplayer";
            } else {
                str = "unknown";
            }
            jSONObject.put("player", str);
            jSONObject.put("what", this.what);
            jSONObject.put("extra", this.gwX);
            jSONObject.put("msg", this.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
