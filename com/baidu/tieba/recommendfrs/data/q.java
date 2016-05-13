package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.mvc.b.e {
    private long eag;

    public q(long j) {
        this.eag = j;
    }

    public long aMw() {
        return this.eag;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.eag)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Dh() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Di() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
