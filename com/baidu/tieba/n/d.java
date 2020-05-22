package com.baidu.tieba.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends c.b {
    private final int code;
    private final String msg;

    public d(int i, String str, int i2, String str2) {
        super(i, str);
        this.code = i2;
        this.msg = str2;
    }

    @Override // com.baidu.tieba.n.c.b, com.baidu.tieba.n.c
    public JSONObject cRR() {
        JSONObject cRR = super.cRR();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.code != -4399) {
                jSONObject.put("code", this.code);
            }
            if (!StringUtils.isNull(this.msg)) {
                jSONObject.put("msg", this.msg);
            }
            cRR.put("ext", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cRR;
    }
}
