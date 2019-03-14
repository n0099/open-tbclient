package com.baidu.tieba.recapp.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.m;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, j> implements com.baidu.tieba.recapp.m {
    protected BaseActivity<?> cNa;

    public i(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cNa = baseActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        View view = new View(this.cNa.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, j jVar) {
        boolean z = false;
        AppData ceh = mVar.ceh();
        if (ceh != null) {
            com.baidu.tbadk.core.data.c cVar = ceh.advertAppContext;
            if (ceh.goods != null && ceh.goods.goods_style == -1001) {
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
