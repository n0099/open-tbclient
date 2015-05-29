package com.baidu.tieba.recommendfrs.data;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.e {
    private String cbZ;

    public e(String str) {
        this.cbZ = str;
    }

    public String ahB() {
        return this.cbZ;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.cbZ;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String AJ() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Bp() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
