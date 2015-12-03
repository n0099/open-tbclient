package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.e {
    private long diL;

    public b(long j) {
        this.diL = j;
    }

    public long awj() {
        return this.diL;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.diL)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Dr() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Ds() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
