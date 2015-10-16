package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.e {
    private String cIW;

    public f(String str) {
        this.cIW = str;
    }

    public String aqo() {
        return this.cIW;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.cIW;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String CA() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean CB() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
