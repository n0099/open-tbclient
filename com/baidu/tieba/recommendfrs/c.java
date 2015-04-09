package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> {
    final /* synthetic */ b bXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
        this.bXW = bVar;
    }

    @Override // com.baidu.tbadk.mvc.j.b
    public int dS(int i) {
        Object item = getItem(i);
        return item instanceof com.baidu.tieba.recommendfrs.data.b ? ((com.baidu.tieba.recommendfrs.data.b) item).getType() == 2 ? 1 : 0 : item instanceof Integer ? 2 : 0;
    }
}
