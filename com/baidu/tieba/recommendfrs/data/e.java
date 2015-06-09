package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.e {
    private String cca;

    public e(String str) {
        this.cca = str;
    }

    public String ahC() {
        return this.cca;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.cca;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String AK() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Bq() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
