package com.baidu.tieba.m;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends c.a {
    private final int eCy;
    private final String ip;
    private final int jye;
    private final int jyf;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.jye = i3;
        this.what = i4;
        this.jyf = i5;
        this.ip = str;
        this.eCy = i6;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cyp() {
        JSONObject cyp = super.cyp();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.d(this.jye, this.what, this.jyf, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.eCy));
            cyp.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cyp;
    }
}
