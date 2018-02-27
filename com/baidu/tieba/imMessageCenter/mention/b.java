package com.baidu.tieba.imMessageCenter.mention;
/* loaded from: classes2.dex */
public class b extends m {
    @Override // com.baidu.tieba.imMessageCenter.mention.m, com.baidu.tbadk.mvc.b.e
    public String MX() {
        return "tb_user_atme";
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.m, com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.m, com.baidu.tbadk.mvc.b.e
    public boolean MY() {
        return false;
    }
}
