package com.baidu.tieba.m;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.m.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e extends c.a {
    private final int dNW;
    private final int iBk;
    private final int iBl;
    private final String ip;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.iBk = i3;
        this.what = i4;
        this.iBl = i5;
        this.ip = str;
        this.dNW = i6;
    }

    @Override // com.baidu.tieba.m.c.a, com.baidu.tieba.m.c
    public JSONObject cdp() {
        JSONObject cdp = super.cdp();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.d(this.iBk, this.what, this.iBl, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.dNW));
            cdp.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cdp;
    }
}
