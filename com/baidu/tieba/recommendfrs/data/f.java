package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.e {
    private String ctc;

    public f(String str) {
        this.ctc = str;
    }

    public String ajK() {
        return this.ctc;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.ctc;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String CD() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean CE() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
