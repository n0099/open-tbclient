package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.e {
    private String cIx;

    public f(String str) {
        this.cIx = str;
    }

    public String aqi() {
        return this.cIx;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.cIx;
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
