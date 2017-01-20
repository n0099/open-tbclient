package com.baidu.tieba.imMessageCenter.mention;
/* loaded from: classes.dex */
public class e extends as {
    @Override // com.baidu.tieba.imMessageCenter.mention.as, com.baidu.tbadk.mvc.b.e
    public String Ep() {
        return "tb_user_atme";
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as, com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as, com.baidu.tbadk.mvc.b.e
    public boolean Eq() {
        return false;
    }
}
