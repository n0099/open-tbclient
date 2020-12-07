package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes26.dex */
public class i extends com.baidu.adp.widget.ListView.a<n, j> implements o {
    protected BaseFragmentActivity ixc;

    public i(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.ixc = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cJ */
    public j c(ViewGroup viewGroup) {
        View view = new View(this.ixc.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, j jVar) {
        boolean z = false;
        AppData dOU = nVar.dOU();
        if (dOU != null) {
            com.baidu.tbadk.core.data.c cVar = dOU.advertAppContext;
            if (dOU.goods != null && dOU.goods.goods_style == -1001) {
                z = true;
            }
            com.baidu.tbadk.core.data.c.b(cVar, nVar.getPosition(), z);
        }
        return jVar.getView();
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
    }
}
