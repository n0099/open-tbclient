package com.baidu.tieba.n;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends c.a {
    private final int eGI;
    private final String ip;
    private final int jzb;
    private final int jzc;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.jzb = i3;
        this.what = i4;
        this.jzc = i5;
        this.ip = str;
        this.eGI = i6;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject czO() {
        JSONObject czO = super.czO();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.d(this.jzb, this.what, this.jzc, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.eGI));
            czO.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return czO;
    }
}
