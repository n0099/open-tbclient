package com.baidu.tieba.imMessageCenter.mention;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends ak implements com.baidu.tbadk.mvc.b.f {
    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String Fi() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean fW(String str) {
        try {
            m(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
