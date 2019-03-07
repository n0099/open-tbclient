package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes4.dex */
public class ReplyMeCacheModel extends CacheModel<l, ReplyMessageFragment> {
    public ReplyMeCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<l> aom() {
        return l.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int aon() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int aoo() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String anW() {
        return "tb_user_replyme";
    }
}
