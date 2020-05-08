package com.baidu.tieba.n;

import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends c.a {
    private final int flN;
    private final String ip;
    private final int kkV;
    private final int kkW;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.kkV = i3;
        this.what = i4;
        this.kkW = i5;
        this.ip = str;
        this.flN = i6;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cKQ() {
        JSONObject cKQ = super.cKQ();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put("error_msg", b.d(this.kkV, this.what, this.kkW, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.flN));
            cKQ.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cKQ;
    }
}
