package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.d, C0082a> {
    private TbPageContext<?> Nw;
    private boolean aeC;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.d.aRP);
        this.mSkinType = 3;
        this.aeC = false;
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public C0082a b(ViewGroup viewGroup) {
        return new C0082a(new com.baidu.tieba.card.c(this.Nw));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.d dVar, C0082a c0082a) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.Nw.getLayoutMode().ac(this.mSkinType == 1);
        this.Nw.getLayoutMode().x(view);
        c0082a.dGe.d(this.Nw, TbadkCoreApplication.m411getInst().getSkinType());
        c0082a.dGe.setFromCDN(this.aeC);
        c0082a.dGe.a(dVar);
        return c0082a.getView();
    }

    public void setFromCDN(boolean z) {
        this.aeC = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.recommendfrs.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0082a extends x.a {
        public com.baidu.tieba.card.c dGe;

        public C0082a(com.baidu.tieba.card.c cVar) {
            super(cVar.getView());
            this.dGe = cVar;
        }
    }
}
