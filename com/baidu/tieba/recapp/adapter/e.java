package com.baidu.tieba.recapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.o;
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.widget.ListView.a<o, PbAppEmptyHolder> implements p {
    protected BaseFragmentActivity iMq;

    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iMq = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cV */
    public PbAppEmptyHolder e(ViewGroup viewGroup) {
        View view = new View(this.iMq.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new PbAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, PbAppEmptyHolder pbAppEmptyHolder) {
        boolean z = false;
        AppData dNC = oVar.dNC();
        if (dNC != null) {
            com.baidu.tbadk.core.data.d dVar = dNC.advertAppContext;
            if (dNC.goods != null && dNC.goods.goods_style == -1001) {
                z = true;
            }
            com.baidu.tbadk.core.data.d.b(dVar, oVar.getPosition(), z);
        }
        return pbAppEmptyHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.p
    public void setIsFromCDN(boolean z) {
    }
}
