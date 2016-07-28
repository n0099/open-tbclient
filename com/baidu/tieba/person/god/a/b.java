package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.bc;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.a.a<m, a> {
    private TbPageContext<?> EA;
    private BdUniqueId aTm;
    private bc cBn;
    private bx cuh;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cuh = new c(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bV */
    public a a(ViewGroup viewGroup) {
        this.cBn = new bc(this.EA);
        this.cBn.j(this.aTm);
        this.cBn.a(this.cuh);
        return new a(this.cBn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, a aVar) {
        if (mVar != null) {
            mVar.fH(i + 1);
        }
        aVar.cBp.a(mVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bc cBp;

        public a(bc bcVar) {
            super(bcVar.getView());
            this.cBp = bcVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTm = bdUniqueId;
    }
}
