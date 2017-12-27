package com.baidu.tieba.l;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.l.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c.a {
    private final int aTC;
    private final int gFm;
    private final int gFn;
    private final String ip;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.gFm = i3;
        this.what = i4;
        this.gFn = i5;
        this.ip = str;
        this.aTC = i6;
    }

    @Override // com.baidu.tieba.l.c.a, com.baidu.tieba.l.c
    public JSONObject brv() {
        JSONObject brv = super.brv();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.b(this.gFm, this.what, this.gFn, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.aTC));
            brv.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brv;
    }
}
