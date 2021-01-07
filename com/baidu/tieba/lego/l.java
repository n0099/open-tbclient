package com.baidu.tieba.lego;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.adapter.LegoDelegateAdapter;
/* loaded from: classes9.dex */
public class l implements com.baidu.tieba.lego.d.a {
    @Override // com.baidu.tieba.lego.d.a
    public com.baidu.tieba.lego.model.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        return new com.baidu.tieba.lego.model.c(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.lego.d.a
    public com.baidu.tieba.lego.c.a a(com.baidu.tieba.lego.c.e eVar) {
        return new com.baidu.tieba.lego.c.c(eVar);
    }

    @Override // com.baidu.tieba.lego.d.a
    public com.baidu.tieba.lego.card.adapter.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        return new LegoDelegateAdapter(tbPageContext, bdUniqueId, i);
    }
}
