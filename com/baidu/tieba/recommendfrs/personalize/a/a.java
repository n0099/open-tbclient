package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.d, C0072a> {
    private TbPageContext<?> DV;
    private boolean Zv;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.d.aRC);
        this.mSkinType = 3;
        this.Zv = false;
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public C0072a b(ViewGroup viewGroup) {
        return new C0072a(new com.baidu.tieba.card.e(this.DV));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.d dVar, C0072a c0072a) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.DV.getLayoutMode().ae(this.mSkinType == 1);
        this.DV.getLayoutMode().x(view);
        c0072a.eaZ.d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        c0072a.eaZ.setFromCDN(this.Zv);
        c0072a.eaZ.a(dVar);
        return c0072a.getView();
    }

    public void setFromCDN(boolean z) {
        this.Zv = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.recommendfrs.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0072a extends y.a {
        public com.baidu.tieba.card.e eaZ;

        public C0072a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.eaZ = eVar;
        }
    }
}
