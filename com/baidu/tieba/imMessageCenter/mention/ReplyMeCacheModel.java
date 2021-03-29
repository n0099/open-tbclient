package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import d.b.i0.e1.b.m;
/* loaded from: classes3.dex */
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
    public String q() {
        return "tb_user_replyme";
    }
}
