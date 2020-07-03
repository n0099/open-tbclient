package com.baidu.tieba.n;

import com.baidu.tieba.n.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends c.a {
    private final int fKO;
    private final String ip;
    private final int kXU;
    private final int kXV;
    private final int type;
    private final int what;

    public e(int i, int i2, int i3, int i4, int i5, String str, int i6) {
        super(i);
        this.type = i2;
        this.kXU = i3;
        this.what = i4;
        this.kXV = i5;
        this.ip = str;
        this.fKO = i6;
    }

    @Override // com.baidu.tieba.n.c.a, com.baidu.tieba.n.c
    public JSONObject cWx() {
        JSONObject cWx = super.cWx();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("retry_type", this.type));
            jSONArray.put(new JSONObject().put("error_msg", b.d(this.kXU, this.what, this.kXV, 0L).toString()));
            jSONArray.put(new JSONObject().put("retry_ip", this.ip));
            jSONArray.put(new JSONObject().put("retry_error_times", this.fKO));
            cWx.put("ext", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cWx;
    }
}
