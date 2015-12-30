package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class bx extends ce<com.baidu.tieba.tbadkCore.data.q, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public bx(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public PbRecBaseViewHolder a(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.axH().l(this.mContext, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) au(i);
        this.cGj.getLayoutMode().ac(this.mSkinType == 1);
        this.cGj.getLayoutMode().k(view);
        pbRecBaseViewHolder.update(qVar2, i, this.mIsFromCDN);
        return view;
    }
}
