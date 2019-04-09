package com.baidu.tieba.m;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e extends c.a {
    private final int iar;
    private final int ias;
    private final String ip;
    private final int times;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.iar = i3;
        this.what = i4;
        this.ias = i5;
        this.ip = str;
        this.times = i6;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bUo() {
        JSONObject bUo = super.bUo();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.c(this.iar, this.what, this.ias, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.times));
            bUo.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bUo;
    }
}
