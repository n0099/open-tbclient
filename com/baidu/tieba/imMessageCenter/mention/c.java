package com.baidu.tieba.imMessageCenter.mention;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends j implements com.baidu.tbadk.mvc.b.f {
    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String MW() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean hX(String str) {
        try {
            H(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
