package com.baidu.tieba.imMessageCenter.mention;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends j implements com.baidu.tbadk.mvc.b.f {
    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String ME() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean gG(String str) {
        try {
            j(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
