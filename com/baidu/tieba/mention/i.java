package com.baidu.tieba.mention;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends x implements com.baidu.tbadk.mvc.b.f {
    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String CF() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean fk(String str) {
        try {
            g(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
