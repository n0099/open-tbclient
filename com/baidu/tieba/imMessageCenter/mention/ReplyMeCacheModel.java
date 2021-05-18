package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import d.a.k0.f1.b.m;
/* loaded from: classes4.dex */
public class ReplyMeCacheModel extends CacheModel<m, ReplyMessageFragment> {
    public ReplyMeCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<m> D() {
        return m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int E() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int F() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String r() {
        return "tb_user_replyme";
    }
}
