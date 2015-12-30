package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.mvc.b.e {
    private long dpm;

    public g(long j) {
        this.dpm = j;
    }

    public long ayp() {
        return this.dpm;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.dpm)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Dg() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Dh() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
