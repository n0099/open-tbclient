package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes2.dex */
public class ReplyMeCacheModel extends CacheModel<l, ReplyMessageFragment> {
    public ReplyMeCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<l> Jv() {
        return l.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Jw() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Jx() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Jg() {
        return "tb_user_replyme";
    }
}
