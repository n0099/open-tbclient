package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import d.a.n0.g1.b.c;
/* loaded from: classes4.dex */
public class AtMeCacheModel extends CacheModel<c, AtMessageActivity> {
    public AtMeCacheModel(TbPageContext<AtMessageActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<c> H() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int I() {
        return 2001258;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int J() {
        return 2001258;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String v() {
        return "tb_user_atme";
    }
}
