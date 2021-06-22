package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import d.a.o0.g1.b.m;
/* loaded from: classes4.dex */
public class ReplyMeCacheModel extends CacheModel<m, ReplyMessageFragment> {
    public ReplyMeCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<m> H() {
        return m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int I() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int J() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String v() {
        return "tb_user_replyme";
    }
}
