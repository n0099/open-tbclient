package com.baidu.tieba.n;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends c.a {
    private final int eHr;
    private final String ip;
    private final int jAM;
    private final int jAN;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.jAM = i3;
        this.what = i4;
        this.jAN = i5;
        this.ip = str;
        this.eHr = i6;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cAj() {
        JSONObject cAj = super.cAj();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put(PushConstants.EXTRA_ERROR_CODE, b.d(this.jAM, this.what, this.jAN, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.eHr));
            cAj.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cAj;
    }
}
