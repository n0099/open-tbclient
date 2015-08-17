package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class bh extends bj<com.baidu.tieba.tbadkCore.data.h, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public bh(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public PbRecBaseViewHolder a(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.aje().l(this.mContext, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.h hVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.data.h) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tieba.tbadkCore.data.h hVar2 = (com.baidu.tieba.tbadkCore.data.h) aA(i);
        this.cbx.getLayoutMode().ad(this.mSkinType == 1);
        this.cbx.getLayoutMode().k(view);
        pbRecBaseViewHolder.update(hVar2, i, this.mIsFromCDN);
        return view;
    }
}
