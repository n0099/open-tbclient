package com.baidu.tieba.recommendfrs.personalize.a;

import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.lib.f.c<com.baidu.tbadk.widget.layout.c> {
    final /* synthetic */ f dYc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.dYc = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aMz */
    public com.baidu.tbadk.widget.layout.c hq() {
        TbPageContext tbPageContext;
        tbPageContext = this.dYc.ND;
        return new com.baidu.tbadk.widget.layout.c(tbPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public void l(com.baidu.tbadk.widget.layout.c cVar) {
        cVar.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.layout.c m(com.baidu.tbadk.widget.layout.c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: e */
    public com.baidu.tbadk.widget.layout.c n(com.baidu.tbadk.widget.layout.c cVar) {
        return cVar;
    }
}
