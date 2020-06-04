package com.baidu.tieba.n;

import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends c.a {
    private final int fzF;
    private final String ip;
    private final int kDY;
    private final int kDZ;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.kDY = i3;
        this.what = i4;
        this.kDZ = i5;
        this.ip = str;
        this.fzF = i6;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cSh() {
        JSONObject cSh = super.cSh();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put("error_msg", b.d(this.kDY, this.what, this.kDZ, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.fzF));
            cSh.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cSh;
    }
}
