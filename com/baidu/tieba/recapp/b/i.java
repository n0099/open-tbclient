package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.tbadkCore.data.AppData;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.data.l, j> implements m {
    protected BaseActivity<?> bcJ;

    public i(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bcJ = baseActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        View view2 = new View(this.bcJ.getPageContext().getPageActivity());
        view2.setVisibility(8);
        return new j(view2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar, j jVar) {
        boolean z = false;
        AppData brP = lVar.brP();
        if (brP != null) {
            com.baidu.tbadk.core.data.b bVar = brP.advertAppContext;
            if (brP.goods != null && brP.goods.goods_style == -1001) {
                z = true;
            }
            com.baidu.tbadk.core.data.b.b(bVar, lVar.getPosition(), z);
        }
        return jVar.getView();
    }

    @Override // com.baidu.tieba.recapp.m
    public void setIsFromCDN(boolean z) {
    }
}
