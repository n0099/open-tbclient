package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.tbadkCore.data.AppData;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.data.l, j> implements m {
    protected BaseActivity<?> bmZ;

    public i(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bmZ = baseActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        View view = new View(this.bmZ.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.l lVar, j jVar) {
        boolean z = false;
        AppData bvT = lVar.bvT();
        if (bvT != null) {
            com.baidu.tbadk.core.data.b bVar = bvT.advertAppContext;
            if (bvT.goods != null && bvT.goods.goods_style == -1001) {
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
