package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.bp;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.a.a<o, a> {
    private TbPageContext<?> EA;
    private BdUniqueId aTm;
    private bp cBs;
    private bx cuh;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cuh = new e(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bW */
    public a a(ViewGroup viewGroup) {
        this.cBs = new bp(this.EA);
        this.cBs.j(this.aTm);
        this.cBs.a(this.cuh);
        return new a(this.cBs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, a aVar) {
        if (oVar != null) {
            oVar.fH(i + 1);
        }
        aVar.cBu.a(oVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bp cBu;

        public a(bp bpVar) {
            super(bpVar.getView());
            this.cBu = bpVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTm = bdUniqueId;
    }
}
