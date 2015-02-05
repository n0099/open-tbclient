package com.baidu.tieba.mention;
/* loaded from: classes.dex */
public class h extends ad {
    @Override // com.baidu.tieba.mention.ad, com.baidu.tbadk.mvc.b.e
    public String lj() {
        return "tb_user_atme";
    }

    @Override // com.baidu.tieba.mention.ad, com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // com.baidu.tieba.mention.ad, com.baidu.tbadk.mvc.b.e
    public boolean xl() {
        return false;
    }
}
