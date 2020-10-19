package com.baidu.tieba.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class c extends b.AbstractC0765b {
    private final int code;
    private final String msg;

    public c(int i, String str, int i2, String str2) {
        super(i, str);
        this.code = i2;
        this.msg = str2;
    }

    @Override // com.baidu.tieba.n.b.AbstractC0765b, com.baidu.tieba.n.b
    public JSONObject dsk() {
        JSONObject dsk = super.dsk();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.code != -4399) {
                jSONObject.put("code", this.code);
            }
            if (!StringUtils.isNull(this.msg)) {
                jSONObject.put("msg", this.msg);
            }
            dsk.put("ext", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dsk;
    }
}
