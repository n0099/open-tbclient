package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.mvc.b.e {
    private long dWX;

    public m(long j) {
        this.dWX = j;
    }

    public long aMi() {
        return this.dWX;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.dWX)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Fo() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Fp() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
