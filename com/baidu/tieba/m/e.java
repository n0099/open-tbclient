package com.baidu.tieba.m;

import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends c.a {
    private final int gwV;
    private final int gwW;
    private final String ip;
    private final int times;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.gwV = i3;
        this.what = i4;
        this.gwW = i5;
        this.ip = str;
        this.times = i6;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bqV() {
        JSONObject bqV = super.bqV();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put("error_msg", b.b(this.gwV, this.what, this.gwW, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.times));
            bqV.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bqV;
    }
}
