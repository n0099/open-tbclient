package com.baidu.tieba.m;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c.a {
    private final int aoY;
    private final int ghC;
    private final int ghD;
    private final String ip;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.ghC = i3;
        this.what = i4;
        this.ghD = i5;
        this.ip = str;
        this.aoY = i6;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject bmK() {
        JSONObject bmK = super.bmK();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.b(this.ghC, this.what, this.ghD, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.aoY));
            bmK.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmK;
    }
}
