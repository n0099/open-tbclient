package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes20.dex */
public class i extends com.baidu.adp.widget.ListView.a<n, j> implements m {
    protected BaseFragmentActivity hwQ;

    public i(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.hwQ = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cE */
    public j b(ViewGroup viewGroup) {
        View view = new View(this.hwQ.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, j jVar) {
        boolean z = false;
        AppData dwt = nVar.dwt();
        if (dwt != null) {
            com.baidu.tbadk.core.data.b bVar = dwt.advertAppContext;
            if (dwt.goods != null && dwt.goods.goods_style == -1001) {
                z = true;
            }
            com.baidu.tbadk.core.data.b.b(bVar, nVar.getPosition(), z);
        }
        return jVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
