package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes4.dex */
public class ReplyMeCacheModel extends CacheModel<l, ReplyMessageFragment> {
    public ReplyMeCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<l> Oo() {
        return l.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Op() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Oq() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String NZ() {
        return "tb_user_replyme";
    }
}
