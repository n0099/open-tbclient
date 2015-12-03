package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
/* loaded from: classes.dex */
public class bw extends cb<com.baidu.tieba.tbadkCore.data.n, PbRecBaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public bw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public PbRecBaseViewHolder a(ViewGroup viewGroup) {
        return com.baidu.tieba.recapp.a.avO().l(this.mContext, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cb, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.n nVar, PbRecBaseViewHolder pbRecBaseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.tbadkCore.data.n) pbRecBaseViewHolder);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tieba.tbadkCore.data.n nVar2 = (com.baidu.tieba.tbadkCore.data.n) aB(i);
        this.cCy.getLayoutMode().af(this.mSkinType == 1);
        this.cCy.getLayoutMode().k(view);
        pbRecBaseViewHolder.update(nVar2, i, this.mIsFromCDN);
        return view;
    }
}
