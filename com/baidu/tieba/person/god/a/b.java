package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.bd;
import com.baidu.tieba.card.by;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.person.a.c<l, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private bd bUx;
    private by bUy;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUy = new c(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        this.bUx = new bd(this.DV);
        this.bUx.j(this.aOT);
        this.bUx.a(this.bUy);
        return new a(this.bUx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar != null) {
            lVar.fw(i + 1);
        }
        aVar.bUA.a(lVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bd bUA;

        public a(bd bdVar) {
            super(bdVar.getView());
            this.bUA = bdVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }
}
