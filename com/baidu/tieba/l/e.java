package com.baidu.tieba.l;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.l.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c.a {
    private final int aUZ;
    private final int gwA;
    private final int gwB;
    private final String ip;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.gwA = i3;
        this.what = i4;
        this.gwB = i5;
        this.ip = str;
        this.aUZ = i6;
    }

    @Override // com.baidu.tieba.l.c.a, com.baidu.tieba.l.c
    public JSONObject bmc() {
        JSONObject bmc = super.bmc();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.b(this.gwA, this.what, this.gwB, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.aUZ));
            bmc.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmc;
    }
}
