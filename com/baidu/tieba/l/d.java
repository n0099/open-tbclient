package com.baidu.tieba.l;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.l.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends c.b {
    private final int code;
    private final String msg;

    public d(int i, String str, int i2, String str2) {
        super(i, str);
        this.code = i2;
        this.msg = str2;
    }

    @Override // com.baidu.tieba.l.c.b, com.baidu.tieba.l.c
    public JSONObject bjQ() {
        JSONObject bjQ = super.bjQ();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.code != -4399) {
                jSONObject.put("code", this.code);
            }
            if (!StringUtils.isNull(this.msg)) {
                jSONObject.put(AddFriendActivityConfig.MSG, this.msg);
            }
            bjQ.put("ext", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bjQ;
    }
}
