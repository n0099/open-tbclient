package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.e {
    private String cKs;

    public f(String str) {
        this.cKs = str;
    }

    public String aqQ() {
        return this.cKs;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.cKs;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Cq() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Cr() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
