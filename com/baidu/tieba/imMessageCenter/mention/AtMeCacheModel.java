package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes2.dex */
public class AtMeCacheModel extends CacheModel<c, AtMessageActivity> {
    public AtMeCacheModel(TbPageContext<AtMessageActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<c> Jv() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Jw() {
        return 2001258;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Jx() {
        return 2001258;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Jg() {
        return "tb_user_atme";
    }
}
