package com.baidu.tieba.m;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.m.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends c.b {
    private final int code;
    private final String msg;

    public d(int i, String str, int i2, String str2) {
        super(i, str);
        this.code = i2;
        this.msg = str2;
    }

    @Override // com.baidu.tieba.m.c.b, com.baidu.tieba.m.c
    public JSONObject cfj() {
        JSONObject cfj = super.cfj();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.code != -4399) {
                jSONObject.put("code", this.code);
            }
            if (!StringUtils.isNull(this.msg)) {
                jSONObject.put("msg", this.msg);
            }
            cfj.put("ext", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cfj;
    }
}
