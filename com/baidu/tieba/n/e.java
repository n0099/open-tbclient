package com.baidu.tieba.n;

import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends c.a {
    private final int fzu;
    private final String ip;
    private final int kCQ;
    private final int kCR;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.kCQ = i3;
        this.what = i4;
        this.kCR = i5;
        this.ip = str;
        this.fzu = i6;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cRR() {
        JSONObject cRR = super.cRR();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put("error_msg", b.d(this.kCQ, this.what, this.kCR, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.fzu));
            cRR.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cRR;
    }
}
