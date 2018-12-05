package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes4.dex */
public class AtMeCacheModel extends CacheModel<c, AtMessageActivity> {
    public AtMeCacheModel(TbPageContext<AtMessageActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<c> On() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Oo() {
        return 2001258;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Op() {
        return 2001258;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String NY() {
        return "tb_user_atme";
    }
}
