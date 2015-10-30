package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.e {
    private String cIW;

    public f(String str) {
        this.cIW = str;
    }

    public String aqk() {
        return this.cIW;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.cIW;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Cx() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Cy() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
