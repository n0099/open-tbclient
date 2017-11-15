package com.baidu.tieba.monitor.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.monitor.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a {
    private final int aeX;
    private final int exS;
    private final int exT;
    private final String ip;
    private final int type;
    private final int what;

    public d(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.exS = i3;
        this.what = i4;
        this.exT = i5;
        this.ip = str;
        this.aeX = i6;
    }

    @Override // com.baidu.tieba.monitor.a.c.a, com.baidu.tieba.monitor.a.c
    public JSONObject aNo() {
        JSONObject aNo = super.aNo();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.b(this.exS, this.what, this.exT, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.aeX));
            aNo.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aNo;
    }
}
