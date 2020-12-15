package com.baidu.tieba.o;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.o.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class c extends b.AbstractC0820b {
    private final int code;
    private final String msg;

    public c(int i, String str, int i2, String str2) {
        super(i, str);
        this.code = i2;
        this.msg = str2;
    }

    @Override // com.baidu.tieba.o.b.AbstractC0820b, com.baidu.tieba.o.b
    public JSONObject dCL() {
        JSONObject dCL = super.dCL();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.code != -4399) {
                jSONObject.put("code", this.code);
            }
            if (!StringUtils.isNull(this.msg)) {
                jSONObject.put("msg", this.msg);
            }
            dCL.put("ext", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dCL;
    }
}
