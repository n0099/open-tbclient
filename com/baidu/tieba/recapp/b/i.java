package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.m;
/* loaded from: classes11.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, j> implements com.baidu.tieba.recapp.m {
    protected BaseFragmentActivity gpB;

    public i(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.gpB = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public j b(ViewGroup viewGroup) {
        View view = new View(this.gpB.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, j jVar) {
        boolean z = false;
        AppData cJn = mVar.cJn();
        if (cJn != null) {
            com.baidu.tbadk.core.data.c cVar = cJn.advertAppContext;
            if (cJn.goods != null && cJn.goods.goods_style == -1001) {
                z = true;
            }
            com.baidu.tbadk.core.data.c.b(cVar, mVar.getPosition(), z);
        }
        return jVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
