package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.mvc.b.e {
    private long dEV;

    public m(long j) {
        this.dEV = j;
    }

    public long aFu() {
        return this.dEV;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.dEV)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String EB() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean EC() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
