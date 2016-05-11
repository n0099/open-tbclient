package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.mvc.b.e {
    private long eag;

    public m(long j) {
        this.eag = j;
    }

    public long aMt() {
        return this.eag;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.eag)).toString();
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
