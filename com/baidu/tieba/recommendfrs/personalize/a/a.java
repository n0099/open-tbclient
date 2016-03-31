package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.d, C0079a> {
    private TbPageContext<?> ND;
    private boolean adX;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.d.aVx);
        this.mSkinType = 3;
        this.adX = false;
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public C0079a b(ViewGroup viewGroup) {
        return new C0079a(new com.baidu.tieba.card.c(this.ND));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.d dVar, C0079a c0079a) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.ND.getLayoutMode().ab(this.mSkinType == 1);
        this.ND.getLayoutMode().x(view);
        c0079a.dXQ.d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        c0079a.dXQ.setFromCDN(this.adX);
        c0079a.dXQ.a(dVar);
        return c0079a.getView();
    }

    public void setFromCDN(boolean z) {
        this.adX = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.recommendfrs.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079a extends x.a {
        public com.baidu.tieba.card.c dXQ;

        public C0079a(com.baidu.tieba.card.c cVar) {
            super(cVar.getView());
            this.dXQ = cVar;
        }
    }
}
