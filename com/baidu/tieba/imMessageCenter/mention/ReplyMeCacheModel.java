package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes2.dex */
public class ReplyMeCacheModel extends CacheModel<l, ReplyMessageFragment> {
    public ReplyMeCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<l> JN() {
        return l.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int JO() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int JP() {
        return 2001257;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Jy() {
        return "tb_user_replyme";
    }
}
