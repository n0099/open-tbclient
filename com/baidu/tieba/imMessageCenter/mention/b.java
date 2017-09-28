package com.baidu.tieba.imMessageCenter.mention;
/* loaded from: classes2.dex */
public class b extends l {
    @Override // com.baidu.tieba.imMessageCenter.mention.l, com.baidu.tbadk.mvc.b.e
    public String ED() {
        return "tb_user_atme";
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.l, com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.l, com.baidu.tbadk.mvc.b.e
    public boolean EE() {
        return false;
    }
}
