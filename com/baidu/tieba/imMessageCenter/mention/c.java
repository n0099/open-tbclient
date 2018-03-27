package com.baidu.tieba.imMessageCenter.mention;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends k implements com.baidu.tbadk.mvc.b.f {
    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public String Na() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public boolean gY(String str) {
        try {
            o(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
